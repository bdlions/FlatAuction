/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.request.handler;

import com.auction.dto.Credential;
import org.bdlions.transport.packet.IPacket;
import org.bdlions.session.ISession;
import org.bdlions.session.ISessionManager;
import com.auction.util.ACTION;
import com.auction.commons.ClientMessages;
import com.auction.commons.HibernateProxyTypeAdapter;
import com.auction.dto.AccountStatus;
import com.auction.dto.Currency;
import com.auction.dto.CurrencyUnit;
import com.auction.dto.Image;
import com.auction.dto.Message;
import com.auction.dto.Product;
import com.auction.dto.ProductBid;
import com.auction.dto.User;
import com.auction.dto.response.ClientResponse;
import com.auction.dto.response.GeneralResponse;
import com.auction.dto.response.SignInResponse;
import com.auction.library.SendMail;
import com.auction.manager.MessageManager;
import com.auction.manager.ProductManager;
import com.auction.manager.UserManager;
import com.auction.util.Constants;
import com.auction.util.FileUtils;
import org.bdlions.util.StringUtils;
import org.bdlions.util.annotation.ClientRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;;
import org.bdlions.session.UserSessionManagerImpl;

/**
 *
 * @author alamgir
 */
public class AuthHandler {

    private final ISessionManager sessionManager;

    public AuthHandler(ISessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @ClientRequest(action = ACTION.SIGN_IN)
    public ClientResponse signIn(ISession session, IPacket packet) throws Exception {

        SignInResponse response = new SignInResponse();
        if(session != null){
            response.setMessage(ClientMessages.ALREADY_LOGGED_IN);
            response.setSessionId(session.getSessionId());
            response.setUserName(session.getUserName());
            response.setSuccess(true);
            return response;
        }
        if (StringUtils.isNullOrEmpty(packet.getPacketBody())) {
            response.setMessage(ClientMessages.INVALID_SIGNIN_REQUEST_FORMAT);
            response.setSuccess(false);
            return response;
        }

        Gson gson = new Gson();
        Credential credential = gson.fromJson(packet.getPacketBody(), Credential.class);

        if (StringUtils.isNullOrEmpty(credential.getUserName())) {
            response.setMessage(ClientMessages.USER_NAME_IS_MANDATORY);
            response.setSuccess(false);
            return response;
        }
        if (StringUtils.isNullOrEmpty(credential.getPassword())) {
            response.setMessage(ClientMessages.PASSWORD_IS_MANDATORY);
            response.setSuccess(false);
            return response;
        }

        try{
            session = sessionManager.createSession(credential);
        }catch(UnknownAccountException uae){
            response.setMessage(ClientMessages.INVALID_CREDENTIAL);
            response.setSuccess(false);
            return response;
        }
        
        if(session == null){
            response.setMessage(ClientMessages.INVALID_CREDENTIAL);
            response.setSuccess(false);
            return response;
        }
        
        session.setRemotePort(packet.getRemotePort());
        session.setRemoteIP(packet.getRemoteIP());
        response.setSessionId((String) session.getSessionId());
        response.setUserName(credential.getUserName());
        response.setFullName(credential.getFirstName() + " " + credential.getLastName());
        response.setSuccess(true);
        

        return response;
    }
    
    @ClientRequest(action = ACTION.SIGN_UP)
    public ClientResponse signUp(ISession session, IPacket packet) throws Exception 
    {
        Gson gson = new Gson();
        User user = gson.fromJson(packet.getPacketBody(), User.class);
        
        UserManager userManager = new UserManager();
        SignInResponse response = new SignInResponse();
        if(user != null)
        {
            User tempUser = userManager.getUserByIdentity(user.getEmail());
            if(tempUser == null)
            {
                AccountStatus accountStatus = new AccountStatus();
                accountStatus.setId(Constants.ACCOUNT_STATUS_ID_ACTIVE);
                user.setAccountStatus(accountStatus);

                //send user role also
                userManager.addUserProfile(user);

                //Once sign up is complete send account activation email to the user
                SendMail sendMail = new SendMail();
                //sendMail.sendSignUpMail("");

                
                response.setMessage("Sign up successful");
                response.setSuccess(true);
            }
            else
            {
                response.setMessage("Email already used or invalid.");
                response.setSuccess(false);
            }
        }
        else
        {
            response.setMessage("Invalid params to create a new user. Please try again later.");
            response.setSuccess(false);
        }        
        return response;
    }
    
    @ClientRequest(action = ACTION.ADD_PRODUCT)
    public ClientResponse addProduct(ISession session, IPacket packet) throws Exception 
    {
        Gson gson = new Gson();
        Product product = gson.fromJson(packet.getPacketBody(), Product.class);
        
        int userId = (int)session.getUserId();
        User user = new User();
        if(userId > 0)
        {
            user.setId(userId);
            product.setUser(user);
            ProductManager productManager = new ProductManager();
            productManager.addProduct(product);
            Image[] images = product.getImages();
            if (images != null) {
                for (Image image : images) {
                    String imageFileName = image.getTitle();
                    if(!com.auction.util.StringUtils.isNullOrEmpty(imageFileName))
                    {
                        String uploadPath = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.IMAGE_UPLOAD_PATH).getFile();
                        String profilePicPath = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.PRODUCT_IMAGE_PATH).getFile();
                        FileUtils.copyFile(uploadPath + imageFileName, profilePicPath + imageFileName);
                    }
                }
            }
        }
        
        
        SignInResponse response = new SignInResponse();
        response.setMessage("Product is created successfully");
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.ADD_PRODUCT_BID)
    public ClientResponse addProductBid(ISession session, IPacket packet) throws Exception 
    {
        Gson gson = new Gson();
        ProductBid productBid = gson.fromJson(packet.getPacketBody(), ProductBid.class);
        
        int userId = (int)session.getUserId();
        User user = new User();
        if(userId > 0)
        {
            user.setId(userId);
            productBid.setUser(user);
            //in future set this id based on user currency profile. right now default pound is used
            Currency currency = new Currency();
            //currency.setId(1);
            //by default setting 1, later set it from configuration file
            CurrencyUnit currencyUnit = new CurrencyUnit();
            currencyUnit.setId(Constants.CURRENCY_UNIT_DEFAULT);
            productBid.setCurrency(currency);
            productBid.setCurrencyUnit(currencyUnit);
            
            productBid.setReferenceId(StringUtils.getRandomString());
            
            ProductManager productManager = new ProductManager();
            productManager.addProductBid(productBid);
            
        }
        
        GeneralResponse response = new GeneralResponse();
        response.setMessage("Bid is added successfully");
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.ADD_MESSAGE_TEXT)
    public ClientResponse addMessageText(ISession session, IPacket packet) throws Exception 
    {
        
        Gson gson = new Gson();
        Message message = gson.fromJson(packet.getPacketBody(), Message.class);        
        int userId = (int)session.getUserId();
        User user = new User();        
        if(userId > 0 && message.getMessageTextList()!= null && !message.getMessageTextList().isEmpty())
        {
            user.setId(userId);
            message.getMessageTextList().get(0).setUser(user);            
            MessageManager messageManager = new MessageManager();
            messageManager.addMessageText(message);
            
            
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
            gson = gsonBuilder.create();
            String messageInfoString = gson.toJson(messageManager.getMessageInfo(message.getId()));
            Message response1 = gson.fromJson(messageInfoString, Message.class);            
            response1.setMessage("Message Text is added successfully");
            response1.setSuccess(true);
            return response1;
        }
        else
        {  
            GeneralResponse response2 = new GeneralResponse();
            response2.setMessage("Error while adding message text.");
            response2.setSuccess(false);
            return response2;
        }
        
    }
    
    @ClientRequest(action = ACTION.ADD_MESSAGE_INFO)
    public ClientResponse addMessageInfo(ISession session, IPacket packet) throws Exception 
    {
        
        Gson gson = new Gson();
        Message message = gson.fromJson(packet.getPacketBody(), Message.class);        
        int userId = (int)session.getUserId();
        User user = new User();        
        if(userId > 0 && message.getMessageTextList()!= null && !message.getMessageTextList().isEmpty())
        {
            try
            {
                User fromUser = new User();
                fromUser.setId(userId);
                message.setFrom(fromUser);

                User toUser = new User();
                toUser.setId(message.getProduct().getUser().getId());
                message.setTo(toUser);

                user.setId(userId);
                message.getMessageTextList().get(0).setUser(user);            
                MessageManager messageManager = new MessageManager();
                messageManager.addMessageText(message);


                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
                gson = gsonBuilder.create();
                String messageInfoString = gson.toJson(messageManager.getMessageInfo(message.getId()));
                Message response1 = gson.fromJson(messageInfoString, Message.class);            
                response1.setMessage("Message Text is added successfully");
                response1.setSuccess(true);
                return response1;
            }
            catch(Exception ex)
            {
                GeneralResponse response3 = new GeneralResponse();
                response3.setMessage("Error while adding message text.");
                response3.setSuccess(false);
                return response3;
            }
            
        }
        else
        {  
            GeneralResponse response2 = new GeneralResponse();
            response2.setMessage("Error while adding message text.");
            response2.setSuccess(false);
            return response2;
        }
        
    }

    @ClientRequest(action = ACTION.SIGN_OUT)
    public ClientResponse signOut(ISession session, IPacket packet) throws Exception {
        if(session != null)
        {
            String sessionId = session.getSessionId();
            try
            {
                sessionManager.destroySession(sessionId);
            }
            catch(Exception ex)
            {
                //add exception in log file
            }
        }
        System.out.println("msg" + packet.getPacketBody());
        SignInResponse response = new SignInResponse();
        response.setMessage("Sign out successful");
        response.setSuccess(true);
        //return null;
        return response;
    }
}
