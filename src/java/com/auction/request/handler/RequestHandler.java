/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.request.handler;

import com.auction.commons.HibernateProxyTypeAdapter;
import com.auction.dto.AccountSettingFA;
import com.auction.dto.BidList;
import com.auction.dto.CurrencyList;
import com.auction.dto.DurationList;
import com.auction.dto.GenderList;
import com.auction.dto.LocationList;
import com.auction.dto.OccupationList;
import com.auction.dto.Product;
import com.auction.dto.ProductList;
import com.auction.dto.ProductTypeList;
import com.auction.dto.RadiusList;
import com.auction.dto.RoomSizeList;
import com.auction.dto.User;
import org.bdlions.transport.packet.IPacket;
import org.bdlions.session.ISession;
import org.bdlions.session.ISessionManager;
import com.auction.util.ACTION;
import com.auction.dto.response.ClientResponse;
import com.auction.dto.response.SignInResponse;
import com.auction.manager.ProductManager;
import com.auction.manager.UserManager;
import com.auction.util.Constants;
import com.auction.util.FileUtils;
import com.auction.util.ServerPropertyProvider;
import com.auction.util.StringUtils;
import org.bdlions.util.annotation.ClientRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 *
 * @author alamgir
 */
public class RequestHandler {

    private final ISessionManager sessionManager;
    public RequestHandler(ISessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
    
    @ClientRequest(action = ACTION.FETCH_PRODUCT_LIST)
    public ClientResponse getProductList(ISession session, IPacket packet){
        ProductManager pm = new ProductManager();
        List<Product> products = pm.getProducts(0, 10);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(products);
        System.out.println(productString);
        ProductList response = gson.fromJson("{\"products\":" +productString +"}", ProductList.class);
//        ProductList response = new Gson().fromJson("{\"products\":[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley1\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR1.\"}, {\"id\":\"2\",\"title\":\"Fun at the Bowling Alley2\", \"img\":\"a.jpg\", \"price\":\"£200\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR2.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley3\", \"img\":\"a.jpg\", \"price\":\"£300\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR3.\"}, {\"id\":\"4\",\"title\":\"Fun at the Bowling Alley4\", \"img\":\"a.jpg\", \"price\":\"£400\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR4.\"}, {\"id\":\"5\",\"title\":\"Fun at the Bowling Alley5\", \"img\":\"a.jpg\", \"price\":\"£500\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR5.\"}, {\"id\":\"6\",\"title\":\"Fun at the Bowling Alley6\", \"img\":\"a.jpg\", \"price\":\"£600\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR6.\"} ]}", ProductList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_LOCATION_LIST)
    public ClientResponse getLocationList(ISession session, IPacket packet){
        LocationList response = new Gson().fromJson("{\"locations\":[{\"id\":\"1\",\"locationType\":\"area\",\"searchString\":\"London\",\"postCode\":\"c1\"}, {\"id\":\"2\",\"locationType\":\"area\",\"searchString\":\"London 123\",\"postCode\":\"c2\"}, {\"id\":\"3\",\"locationType\":\"area\",\"searchString\":\"London 456\",\"postCode\":\"c3\"}]}", LocationList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_RADIUS_LIST)
    public ClientResponse getRadiusList(ISession session, IPacket packet){
        RadiusList response = new Gson().fromJson("{\"radiuses\":[{\"id\":\"1\",\"title\":\"+0 miles\"}, {\"id\":\"2\",\"title\":\"+1/4 miles\"}, {\"id\":\"3\",\"title\":\"+1/2 miles\"}]}", RadiusList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_PRODUCT_TYPE_LIST)
    public ClientResponse getProductTypeList(ISession session, IPacket packet){
        ProductTypeList response = new Gson().fromJson("{\"productTypes\":[{\"id\":\"1\",\"title\":\"Property\"}, {\"id\":\"2\",\"title\":\"Room\"}]}", ProductTypeList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_OCCUPATION_LIST)
    public ClientResponse getOccupationList(ISession session, IPacket packet){
        OccupationList response = new Gson().fromJson("{\"occupations\":[{\"id\":\"1\",\"title\":\"Any Occupation\"}, {\"id\":\"2\",\"title\":\"Professional\"}, {\"id\":\"3\",\"title\":\"Student\"}]}", OccupationList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_GENDER_LIST)
    public ClientResponse getGenderList(ISession session, IPacket packet){
        GenderList response = new Gson().fromJson("{\"genders\":[{\"id\":\"1\",\"title\":\"Any Gender\"}, {\"id\":\"2\",\"title\":\"Males\"}, {\"id\":\"3\",\"title\":\"Females\"}]}", GenderList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_ROOM_SIZE_LIST)
    public ClientResponse getRoomSizeList(ISession session, IPacket packet){
        RoomSizeList response = new Gson().fromJson("{\"roomSizes\":[{\"id\":\"1\",\"title\":\"Any room size\"}, {\"id\":\"2\",\"title\":\"Double room\"}, {\"id\":\"3\",\"title\":\"Single room\"}]}", RoomSizeList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_DURATION_LIST)
    public ClientResponse getDurationList(ISession session, IPacket packet){
        DurationList response = new Gson().fromJson("{\"durations\":[{\"id\":\"1\",\"title\":\"Daily\"}, {\"id\":\"2\",\"title\":\"Weekly\"}, {\"id\":\"3\",\"title\":\"Monthly\"}]}", DurationList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_MIN_PRICE_LIST)
    public ClientResponse getMinPriceList(ISession session, IPacket packet){
        CurrencyList response = new Gson().fromJson("{\"currencies\":[{\"id\":\"1\",\"title\":\"£\",\"amount\":\"100\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, {\"id\":\"1\",\"title\":\"£\",\"amount\":\"200\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, {\"id\":\"1\",\"title\":\"£\",\"amount\":\"300\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}]}", CurrencyList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_MAX_PRICE_LIST)
    public ClientResponse getMaxPriceList(ISession session, IPacket packet){
        CurrencyList response = new Gson().fromJson("{\"currencies\":[{\"id\":\"1\",\"title\":\"£\",\"amount\":\"100\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, {\"id\":\"1\",\"title\":\"£\",\"amount\":\"200\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, {\"id\":\"1\",\"title\":\"£\",\"amount\":\"300\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}]}", CurrencyList.class );
        response.setSuccess(true);
        return response;
    }
    
    
    @ClientRequest(action = ACTION.FETCH_BID_LIST)
    public ClientResponse getBidList(ISession session, IPacket packet){
        //BidList response = new Gson().fromJson("{\"bids\":[{\"bidId\":\"1\",\"time\":\"21 Apr 2017 9:38:35AM\",\"amount\":\"1000\", \"currency\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"firstName\":\"Nazmul\", \"lastName\":\"Hasan\"}}, {\"bidId\":\"2\",\"time\":\"20 Apr 2017 9:38:35AM\",\"amount\":\"2000\", \"currency\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"firstName\":\"Alamgir\", \"lastName\":\"Kabir\"}}]}", BidList.class );
        BidList response = new Gson().fromJson("{\"bids\":[{\"id\":1,\"bidId\":\"1\",\"bidTime\":\"2017-04-25 9:38:35AM\",\"bidAmount\":\"1000\", \"bidAmountUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"userId\":1,\"firstName\":\"Nazmul\", \"lastName\":\"Hasan\"}, \"product\":{\"productId\":\"p1\"}}, {\"id\":2,\"bidId\":\"2\",\"bidTime\":\"2017-04-27 9:38:35AM\",\"bidAmount\":\"2000\", \"bidAmountUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"userId\":2,\"firstName\":\"Alamgir\", \"lastName\":\"Kabir\"}, \"product\":{\"productId\":\"p1\"}}, {\"id\":1,\"bidId\":\"3\",\"bidTime\":\"2017-04-28 9:38:35AM\",\"bidAmount\":\"3000\", \"bidAmountUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"userId\":3,\"firstName\":\"Shem\", \"lastName\":\"Haye\"}, \"product\":{\"productId\":\"p1\"}}]}", BidList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_PRODUCT_INFO)
    public ClientResponse getProductInfo(ISession session, IPacket packet){
        Product response = new Gson().fromJson("{\"id\":\"1\",\"productId\":\"p1\",\"user\":{\"id\":\"1\"},\"title\":\"Title of product1.\", \"description\":\"Description of product1.\",\"firstName\":\"Nazmul\",\"lastName\":\"Hasan\",\"phone\":\"01711123456\",\"img\":\"a.jpg\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"location\":{\"locationId\":\"1\", \"locationType\":\"area\", \"searchString\":\"London\", \"postCode\":\"AB2 8YR\"},\"productType\":{\"id\":\"1\"},\"productSize\":{\"id\":\"1\"},\"productCategory\":{\"id\":\"1\"}, \"amenities\":[{\"id\":\"1\"}, {\"id\":\"2\"}],\"smoking\":{\"id\":\"1\"},\"gender\":{\"id\":\"1\"},\"occupation\":{\"id\":\"1\"},\"pet\":{\"id\":\"1\"}, \"durations\":[{\"id\":\"1\"}, {\"id\":\"2\"}],\"basePrice\":\"100\", \"basePriceUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}},\"securityDeposit\":\"200\", \"securityDepositUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"startDate\":\"2017-05-10\", \"endDate\":\"2017-05-16\",\"minStay\":{\"id\":\"1\"},\"maxStay\":{\"id\":\"1\"}, \"isFeaturedAd\":\"true\", \"isDefaultBid\":\"false\",\"adBid\":\"0.3\", \"adBidUnit\":{\"id\":\"1\",\"title\":\"p\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}}", Product.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_USER_INFO)
    public ClientResponse getUserInfo(ISession session, IPacket packet){
        int userId = (int)session.getUserId();
        UserManager userManager = new UserManager();
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String userProfileString = gson.toJson(userManager.getUserProfileById(userId));
        User response = gson.fromJson(userProfileString, User.class);
        
        //User response = userManager.getUserProfileById(userId);
        //User response = new Gson().fromJson("{\"userId\":\"1\", \"firstName\":\"Nazmul\", \"lastName\":\"Hasan\", \"email\":\"bdlions@gmail.com\", \"cellNo\":\"8801678112509\", \"img\":\"user.jpg\", \"document\":\"document.jpg\", \"isVerified\":\"true\"}", User.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_ACCOUNT_SETTING_FA)
    public ClientResponse getAccountSettingFAInfo(ISession session, IPacket packet){
        AccountSettingFA response = new Gson().fromJson("{\"id\":\"1\",\"user\":{\"id\":\"1\"},\"defaultBidPerClick\":\"4\", \"defaultBidPerClickUnit\":{\"id\":\"1\",\"title\":\"p\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}},\"dailyBudget\":\"6\", \"dailyBudgetUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"campainActive\":\"true\"}", AccountSettingFA.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.UPDATE_USER_INFO)
    public ClientResponse updateUserInfo(ISession session, IPacket packet){
        UserManager userManager = new UserManager();
        Gson gson = new Gson();
        User user = gson.fromJson(packet.getPacketBody(), User.class);
        userManager.updateUserProfile(user);
        
        SignInResponse response = new SignInResponse();
        response.setMessage("Profile update successful.");
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.UPDATE_USER_PROFILE_PICTURE)
    public ClientResponse updateUserProfilePicture(ISession session, IPacket packet){
        Gson gson = new Gson();
        User user = gson.fromJson(packet.getPacketBody(), User.class);
        //read image from temp directory and place into user profile picture directory
        String imageFileName = user.getImg().trim().replaceAll("\n", "");
        user.setImg(imageFileName);
        if(!StringUtils.isNullOrEmpty(imageFileName))
        {
            //String root = Constants.SERVER_ROOT_DIR;
            String uploadPath = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.IMAGE_UPLOAD_PATH).getFile();
            String profilePicPath = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.PROFILE_PIC_PATH).getFile();
            //System.out.println(root);
            
            FileUtils.copyFile(uploadPath + imageFileName, profilePicPath + imageFileName);
        }
        UserManager userManager = new UserManager();
        userManager.updateUserProfile(user);
        
        SignInResponse response = new SignInResponse();
        response.setMessage("Profile update successful.");
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.UPDATE_USER_DOCUMENT)
    public ClientResponse updateUserDocument(ISession session, IPacket packet){
        Gson gson = new Gson();
        User user = gson.fromJson(packet.getPacketBody(), User.class);
        //read image from temp directory and place into user profile picture directory
        String imageFileName = user.getDocument().trim().replaceAll("\n", "");
        user.setDocument(imageFileName);
        if(!StringUtils.isNullOrEmpty(imageFileName))
        {
            //String root = Constants.SERVER_ROOT_DIR;
            String uploadPath = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.IMAGE_UPLOAD_PATH).getFile();
            String documentPath = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.USER_DOCUMENT_PATH).getFile();
            //System.out.println(root);
            
            FileUtils.copyFile(uploadPath + imageFileName, documentPath + imageFileName);
        }
        UserManager userManager = new UserManager();
        userManager.updateUserProfile(user);
        
        SignInResponse response = new SignInResponse();
        response.setMessage("Profile update successful.");
        response.setSuccess(true);
        return response;
    }
}
