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
import com.auction.dto.AccountStatus;
import com.auction.dto.Image;
import com.auction.dto.Product;
import com.auction.dto.User;
import com.auction.dto.response.ClientResponse;
import com.auction.dto.response.SignInResponse;
import com.auction.library.SendMail;
import com.auction.manager.ProductManager;
import com.auction.manager.UserManager;
import com.auction.util.Constants;
import com.auction.util.FileUtils;
import org.bdlions.util.StringUtils;
import org.bdlions.util.annotation.ClientRequest;
import com.google.gson.Gson;
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
        AccountStatus accountStatus = new AccountStatus();
        accountStatus.setId(Constants.ACCOUNT_STATUS_ID_ACTIVE);
        user.setAccountStatus(accountStatus);
        UserManager userManager = new UserManager();
        //send user role also
        userManager.addUserProfile(user);
        
        //Once sign up is complete send account activation email to the user
        SendMail sendMail = new SendMail();
        //sendMail.sendSignUpMail("");
        
        SignInResponse response = new SignInResponse();
        response.setMessage("Sign up successful");
        response.setSuccess(true);
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

    @ClientRequest(action = ACTION.SIGN_OUT)
    public ClientResponse signOut(ISession session, IPacket packet) throws Exception {
        System.out.println("msg" + packet.getPacketBody());
        SignInResponse response = new SignInResponse();
        response.setMessage("Sign out successful");
        response.setSuccess(true);
        //return null;
        return response;
    }
}
