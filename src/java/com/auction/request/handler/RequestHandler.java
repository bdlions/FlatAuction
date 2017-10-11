/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.request.handler;

import com.auction.commons.HibernateProxyTypeAdapter;
import com.auction.dto.AccountSettingFA;
import com.auction.dto.AmenityList;
import com.auction.dto.AvailabilityList;
import com.auction.dto.ProductBidList;
import com.auction.dto.LocationList;
import com.auction.dto.Message;
import com.auction.dto.MessageList;
import com.auction.dto.OccupationList;
import com.auction.dto.PetList;
import com.auction.dto.PriceList;
import com.auction.dto.Product;
import com.auction.dto.ProductBid;
import com.auction.dto.ProductCategoryList;
import com.auction.dto.ProductList;
import com.auction.dto.ProductSizeList;
import com.auction.dto.ProductTypeList;
import com.auction.dto.Role;
import com.auction.dto.RoleList;
import com.auction.dto.SearchParams;
import com.auction.dto.SmokingList;
import com.auction.dto.Stat;
import com.auction.dto.StatList;
import com.auction.dto.StatParams;
import com.auction.dto.StayList;
import com.auction.dto.User;
import com.auction.dto.UserList;
import org.bdlions.transport.packet.IPacket;
import org.bdlions.session.ISession;
import org.bdlions.session.ISessionManager;
import com.auction.util.ACTION;
import com.auction.dto.response.ClientResponse;
import com.auction.dto.response.GeneralResponse;
import com.auction.dto.response.SignInResponse;
import com.auction.exceptions.InvalidRequestException;
import com.auction.library.ImageLibrary;
import com.auction.library.ProductLibrary;
import com.auction.manager.FeaturedAdManager;
import com.auction.manager.MessageManager;
import com.auction.manager.ProductManager;
import com.auction.manager.UserManager;
import com.auction.util.Constants;
import com.auction.util.FileUtils;
import com.auction.util.StringUtils;
import org.bdlions.util.annotation.ClientRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author alamgir
 */
public class RequestHandler {
    private final Logger logger = LoggerFactory.getLogger(RequestHandler.class);
    private final ISessionManager sessionManager;
    public RequestHandler(ISessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
    
    @ClientRequest(action = ACTION.FETCH_MEMBER_ROLES)
    public ClientResponse getMemberRoleList(ISession session, IPacket packet){
        UserManager userManager = new UserManager();
        List<Role> roles = userManager.getMemberRoles();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String rolesString = gson.toJson(roles);
        RoleList response = gson.fromJson("{\"roles\":" +rolesString +"}", RoleList.class);
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_USER_LIST)
    public ClientResponse getUserList(ISession session, IPacket packet){
        UserManager userManager = new UserManager();
        List<User> users = userManager.getUsers(0, 10);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String userString = gson.toJson(users);
        UserList response = gson.fromJson("{\"users\":" +userString +"}", UserList.class);
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_PRODUCT_TYPE_LIST)
    public ClientResponse getProductTypeList(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();
        //ProductTypeList response = new Gson().fromJson("{\"productTypes\":[{\"id\":\"1\",\"title\":\"Property\"}, {\"id\":\"2\",\"title\":\"Room\"}]}", ProductTypeList.class );
        //ProductTypeList response = new ProductTypeList();
        //response.setProductTypes(productManager.getProductTypes());        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(productManager.getProductTypes());
        ProductTypeList response = gson.fromJson("{\"productTypes\":" +productString +"}", ProductTypeList.class);
        
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_PRODUCT_SIZE_LIST)
    public ClientResponse getProductSizeList(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();
        //ProductSizeList response = new ProductSizeList();
        //response.setProductSizes(productManager.getProductSizes());
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(productManager.getProductSizes());
        ProductSizeList response = gson.fromJson("{\"productSizes\":" +productString +"}", ProductSizeList.class);
        
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_PRODUCT_CATEGORY_LIST)
    public ClientResponse getProductCategoryList(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();
        
        //ProductCategoryList response = new ProductCategoryList();
        //response.setProductCategories(productManager.getProductCategories());
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(productManager.getProductCategories());
        ProductCategoryList response = gson.fromJson("{\"productCategories\":" +productString +"}", ProductCategoryList.class);
        
        
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_LOCATION_LIST)
    public ClientResponse getLocationList(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();
        //LocationList response = new Gson().fromJson("{\"locations\":[{\"id\":\"1\",\"locationType\":\"area\",\"searchString\":\"London\",\"postCode\":\"c1\"}, {\"id\":\"2\",\"locationType\":\"area\",\"searchString\":\"London 123\",\"postCode\":\"c2\"}, {\"id\":\"3\",\"locationType\":\"area\",\"searchString\":\"London 456\",\"postCode\":\"c3\"}]}", LocationList.class );
        //LocationList response = new LocationList();
        //response.setLocations(productManager.getLocations());
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(productManager.getLocations());
        LocationList response = gson.fromJson("{\"locations\":" +productString +"}", LocationList.class);
        
        
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_PRODUCT_AMENITY_LIST)
    public ClientResponse getAmenityList(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String amenityListString = gson.toJson(productManager.getAmenities());
        AmenityList response = gson.fromJson("{\"amenities\":" +amenityListString +"}", AmenityList.class);        
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_AVAILABILITY_LIST)
    public ClientResponse getAvailabilityList(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String availabilitiesString = gson.toJson(productManager.getAvailabilities());
        AvailabilityList response = gson.fromJson("{\"availabilities\":" +availabilitiesString +"}", AvailabilityList.class);
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_STAY_LIST)
    public ClientResponse getStayList(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();
        
        //StayList response = new StayList();
        //response.setStays(productManager.getStays());
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(productManager.getStays());
        StayList response = gson.fromJson("{\"stays\":" +productString +"}", StayList.class);
        
        
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_SMOKING_LIST)
    public ClientResponse getSmokingList(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();
        
        //SmokingList response = new SmokingList();
        //response.setSmokings(productManager.getSmokings());
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(productManager.getSmokings());
        SmokingList response = gson.fromJson("{\"smokings\":" +productString +"}", SmokingList.class);
        
        
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_OCCUPATION_LIST)
    public ClientResponse getOccupationList(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();
        
        //OccupationList response = new OccupationList();
        //response.setOccupations(productManager.getOccupations());
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(productManager.getOccupations());
        OccupationList response = gson.fromJson("{\"occupations\":" +productString +"}", OccupationList.class);
        
        
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_PET_LIST)
    public ClientResponse getPetList(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();
        
        //PetList response = new PetList();
        //response.setPets(productManager.getPets());
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(productManager.getPets());
        PetList response = gson.fromJson("{\"pets\":" +productString +"}", PetList.class);
        
        
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_MY_PRODUCT_LIST)
    public ClientResponse getMyProductList(ISession session, IPacket packet){
        int userId = (int)session.getUserId();
        ProductManager productManager = new ProductManager();
        List<Product> products = productManager.getMyProducts(userId, 0, 100);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(products);
        //System.out.println(productString);
        ProductList response = gson.fromJson("{\"products\":" +productString +"}", ProductList.class);
//        ProductList response = new Gson().fromJson("{\"products\":[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley1\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR1.\"}, {\"id\":\"2\",\"title\":\"Fun at the Bowling Alley2\", \"img\":\"a.jpg\", \"price\":\"£200\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR2.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley3\", \"img\":\"a.jpg\", \"price\":\"£300\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR3.\"}, {\"id\":\"4\",\"title\":\"Fun at the Bowling Alley4\", \"img\":\"a.jpg\", \"price\":\"£400\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR4.\"}, {\"id\":\"5\",\"title\":\"Fun at the Bowling Alley5\", \"img\":\"a.jpg\", \"price\":\"£500\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR5.\"}, {\"id\":\"6\",\"title\":\"Fun at the Bowling Alley6\", \"img\":\"a.jpg\", \"price\":\"£600\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR6.\"} ]}", ProductList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_CLOSING_PRODUCT_LIST)
    public ClientResponse getClosingProductList(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();
        List<Product> products = productManager.getClosingProducts(6);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(products);
        ProductList response = gson.fromJson("{\"products\":" +productString +"}", ProductList.class);
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_SAVED_PRODUCT_LIST)
    public ClientResponse getSavedProductList(ISession session, IPacket packet){
        int userId = (int)session.getUserId();
        ProductManager productManager = new ProductManager();
        List<Product> products = productManager.getSavedProducts(userId, 0, 100);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(products);
        ProductList response = gson.fromJson("{\"products\":" +productString +"}", ProductList.class);
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_PRODUCT_LIST)
    public ClientResponse getProductList(ISession session, IPacket packet){
        SearchParams searchParams = null;
        try
        {
            Gson gson1 = new Gson();
            searchParams = gson1.fromJson(packet.getPacketBody(), SearchParams.class);
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
        }
        
        
        ProductManager pm = new ProductManager();
        List<Product> products = pm.getProducts(searchParams, 0, 12);
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
    
    
    
//    @ClientRequest(action = ACTION.FETCH_RADIUS_LIST)
//    public ClientResponse getRadiusList(ISession session, IPacket packet){
//        RadiusList response = new Gson().fromJson("{\"radiuses\":[{\"id\":\"1\",\"title\":\"+0 miles\"}, {\"id\":\"2\",\"title\":\"+1/4 miles\"}, {\"id\":\"3\",\"title\":\"+1/2 miles\"}]}", RadiusList.class );
//        response.setSuccess(true);
//        return response;
//    }
    
    
    
//    @ClientRequest(action = ACTION.FETCH_OCCUPATION_LIST)
//    public ClientResponse getOccupationList(ISession session, IPacket packet){
//        OccupationList response = new Gson().fromJson("{\"occupations\":[{\"id\":\"1\",\"title\":\"Any Occupation\"}, {\"id\":\"2\",\"title\":\"Professional\"}, {\"id\":\"3\",\"title\":\"Student\"}]}", OccupationList.class );
//        response.setSuccess(true);
//        return response;
//    }
    
//    @ClientRequest(action = ACTION.FETCH_GENDER_LIST)
//    public ClientResponse getGenderList(ISession session, IPacket packet){
//        GenderList response = new Gson().fromJson("{\"genders\":[{\"id\":\"1\",\"title\":\"Any Gender\"}, {\"id\":\"2\",\"title\":\"Males\"}, {\"id\":\"3\",\"title\":\"Females\"}]}", GenderList.class );
//        response.setSuccess(true);
//        return response;
//    }
    
//    @ClientRequest(action = ACTION.FETCH_ROOM_SIZE_LIST)
//    public ClientResponse getRoomSizeList(ISession session, IPacket packet){
//        RoomSizeList response = new Gson().fromJson("{\"roomSizes\":[{\"id\":\"1\",\"title\":\"Any room size\"}, {\"id\":\"2\",\"title\":\"Double room\"}, {\"id\":\"3\",\"title\":\"Single room\"}]}", RoomSizeList.class );
//        response.setSuccess(true);
//        return response;
//    }
    
//    @ClientRequest(action = ACTION.FETCH_DURATION_LIST)
//    public ClientResponse getDurationList(ISession session, IPacket packet){
//        DurationList response = new Gson().fromJson("{\"durations\":[{\"id\":\"1\",\"title\":\"Daily\"}, {\"id\":\"2\",\"title\":\"Weekly\"}, {\"id\":\"3\",\"title\":\"Monthly\"}]}", DurationList.class );
//        response.setSuccess(true);
//        return response;
//    }
    
    @ClientRequest(action = ACTION.FETCH_MIN_PRICE_LIST)
    public ClientResponse getMinPriceList(ISession session, IPacket packet){
        PriceList response = new Gson().fromJson("{\"prices\":[{\"id\":\"1\",\"amount\":\"100\"}, {\"id\":\"2\",\"amount\":\"200\"}, {\"id\":\"3\",\"amount\":\"300\"}]}", PriceList.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_MAX_PRICE_LIST)
    public ClientResponse getMaxPriceList(ISession session, IPacket packet){
        PriceList response = new Gson().fromJson("{\"prices\":[{\"id\":\"1\",\"amount\":\"100\"}, {\"id\":\"2\",\"amount\":\"200\"}, {\"id\":\"3\",\"amount\":\"300\"}]}", PriceList.class );
        response.setSuccess(true);
        return response;
    }
    
    
    @ClientRequest(action = ACTION.FETCH_BID_LIST)
    public ClientResponse getBidList(ISession session, IPacket packet){
        //BidList response = new Gson().fromJson("{\"bids\":[{\"bidId\":\"1\",\"time\":\"21 Apr 2017 9:38:35AM\",\"amount\":\"1000\", \"currency\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"firstName\":\"Nazmul\", \"lastName\":\"Hasan\"}}, {\"bidId\":\"2\",\"time\":\"20 Apr 2017 9:38:35AM\",\"amount\":\"2000\", \"currency\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"firstName\":\"Alamgir\", \"lastName\":\"Kabir\"}}]}", ProductBidList.class );
        //ProductBidList response = new Gson().fromJson("{\"productBidList\":[{\"id\":1,\"bidId\":\"1\",\"bidTime\":\"2017-04-25 9:38:35AM\",\"bidAmount\":\"1000\", \"bidAmountUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"userId\":1,\"firstName\":\"Nazmul\", \"lastName\":\"Hasan\"}, \"product\":{\"productId\":\"p1\"}}, {\"id\":2,\"bidId\":\"2\",\"bidTime\":\"2017-04-27 9:38:35AM\",\"bidAmount\":\"2000\", \"bidAmountUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"userId\":2,\"firstName\":\"Alamgir\", \"lastName\":\"Kabir\"}, \"product\":{\"productId\":\"p1\"}}, {\"id\":1,\"bidId\":\"3\",\"bidTime\":\"2017-04-28 9:38:35AM\",\"bidAmount\":\"3000\", \"bidAmountUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"userId\":3,\"firstName\":\"Shem\", \"lastName\":\"Haye\"}, \"product\":{\"productId\":\"p1\"}}]}", ProductBidList.class );
        Gson gson1 = new Gson();
        Product product = gson1.fromJson(packet.getPacketBody(), Product.class);
        ProductManager productManager = new ProductManager();
        List<ProductBid> productBidList = productManager.getProductBidList(product.getId());
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productBidListString = gson.toJson(productBidList);
        ProductBidList response = gson.fromJson("{\"productBidList\":" +productBidListString +"}", ProductBidList.class);
        
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_PRODUCT_INFO)
    public ClientResponse getProductInfo(ISession session, IPacket packet){
        Gson gson1 = new Gson();
        Product product = gson1.fromJson(packet.getPacketBody(), Product.class);
        ProductManager productManager = new ProductManager();
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String productString = gson.toJson(productManager.getProductInfo(product.getId()));
        Product response = gson.fromJson(productString, Product.class);
        
        //Product response = new Gson().fromJson("{\"id\":\"1\",\"productId\":\"p1\",\"user\":{\"id\":\"1\"},\"title\":\"Title of product1.\", \"description\":\"Description of product1.\",\"firstName\":\"Nazmul\",\"lastName\":\"Hasan\",\"phone\":\"01711123456\",\"img\":\"a.jpg\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"location\":{\"locationId\":\"1\", \"locationType\":\"area\", \"searchString\":\"London\", \"postCode\":\"AB2 8YR\"},\"productType\":{\"id\":\"1\"},\"productSize\":{\"id\":\"1\"},\"productCategory\":{\"id\":\"1\"}, \"amenities\":[{\"id\":\"1\"}, {\"id\":\"2\"}],\"smoking\":{\"id\":\"1\"},\"gender\":{\"id\":\"1\"},\"occupation\":{\"id\":\"1\"},\"pet\":{\"id\":\"1\"}, \"durations\":[{\"id\":\"1\"}, {\"id\":\"2\"}],\"basePrice\":\"100\", \"basePriceUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}},\"securityDeposit\":\"200\", \"securityDepositUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"startDate\":\"2017-05-10\", \"endDate\":\"2017-05-16\",\"minStay\":{\"id\":\"1\"},\"maxStay\":{\"id\":\"1\"}, \"isFeaturedAd\":\"true\", \"isDefaultBid\":\"false\",\"adBid\":\"0.3\", \"adBidUnit\":{\"id\":\"1\",\"title\":\"p\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}}", Product.class );
        if(response != null)
        {
            response.setSuccess(true);
        }
        else
        {
            response = new Product();
            response.setSuccess(false);
        }
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_USER_INFO)
    public ClientResponse getUserInfo(ISession session, IPacket packet){
        //check if user info is provided with id, if not then use user id from the session
        User userInfo = null;
        int userId = 0;
        try
        {
            Gson gson = new Gson();
            userInfo = gson.fromJson(packet.getPacketBody(), User.class);
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
        }
        if(userInfo == null || userInfo.getId() == 0)
        {
            userId = (int)session.getUserId();
        }
        else
        {
            userId = userInfo.getId();
        }
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
        try
        {
            int userId = (int)session.getUserId();
            FeaturedAdManager featuredAdManager = new FeaturedAdManager();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
            Gson gson = gsonBuilder.create();
            AccountSettingFA accountSettingFA = featuredAdManager.getFeaturedAdAccountSetting(userId);            
            String accountSettingFAString = gson.toJson(accountSettingFA);
            AccountSettingFA response = new Gson().fromJson(accountSettingFAString, AccountSettingFA.class );
            response.setSuccess(true);
            return response;
        }
        catch(Exception ex)
        {
            GeneralResponse response = new GeneralResponse();
            response.setSuccess(false);
            return response;
        }
    }
    
    @ClientRequest(action = ACTION.FETCH_MESSAGE_INBOX_LIST)
    public ClientResponse getMessageInbooxList(ISession session, IPacket packet) throws InvalidRequestException, Throwable{
        logger.debug("processing request - fetch message inbox list");
        int userId = (int)session.getUserId();
        try
        {
            MessageManager messageManager = new MessageManager();
            List<Message> messageList = messageManager.getInboxMessageList(userId);
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
            Gson gson = gsonBuilder.create();
            String messageListString = gson.toJson(messageList);
            MessageList response = gson.fromJson("{\"messageList\":" +messageListString +"}", MessageList.class);
            response.setSuccess(true);
            logger.debug("fetch message inbox list completed.");
            return response;
        }
        catch(Exception ex)
        {
            logger.debug(ex.toString());
            throw new InvalidRequestException();            
        }
    }
    
    @ClientRequest(action = ACTION.FETCH_MESSAGE_SENT_LIST)
    public ClientResponse getMessageSentList(ISession session, IPacket packet){
        int userId = (int)session.getUserId();
        MessageManager messageManager = new MessageManager();
        List<Message> messageList = messageManager.getSentMessageList(userId);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String messageListString = gson.toJson(messageList);
        MessageList response = gson.fromJson("{\"messageList\":" +messageListString +"}", MessageList.class);
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_MESSAGE_INFO)
    public ClientResponse getMessageInfo(ISession session, IPacket packet){
        Gson gson1 = new Gson();
        Message message = gson1.fromJson(packet.getPacketBody(), Message.class);
        MessageManager messageManager = new MessageManager();
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String messageInfoString = gson.toJson(messageManager.getMessageInfo(message.getId()));
        Message response = gson.fromJson(messageInfoString, Message.class);
        
        if(response != null)
        {
            response.setSuccess(true);
        }
        else
        {
            response = new Message();
            response.setSuccess(false);
        }
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
        logger.debug("-------------------------imageFileName1:"+user.getImg());
        String imageFileName = user.getImg().trim().replaceAll("\n", "");
        logger.debug("-------------------------imageFileName2:"+imageFileName);
        user.setImg(imageFileName);
        if(!StringUtils.isNullOrEmpty(imageFileName))
        {
            //String root = Constants.SERVER_ROOT_DIR;
            String uploadPath = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.IMAGE_UPLOAD_PATH).getFile();
            String profilePicPath = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.PROFILE_PIC_PATH).getFile();
            //System.out.println(root);
            logger.debug("--------------------------------Source Path:"+uploadPath + imageFileName+", Destination Path"+profilePicPath + imageFileName);
            //copy actual image
            FileUtils.copyFile(uploadPath + imageFileName, profilePicPath + imageFileName);
            
            //resize image to 150px to 150px
            String profilePicPath150_150 = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.IMG_PROFILE_PIC_PATH_150_150).getFile();
            ImageLibrary imageLibrary = new ImageLibrary();
            imageLibrary.resizeImage(uploadPath + imageFileName, profilePicPath150_150 + imageFileName, Constants.IMG_PROFILE_PIC_WIDTH_150, Constants.IMG_PROFILE_PIC_HEIGHT_150);
            
            //resize image to 50px to 50px
            String profilePicPath50_50 = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.IMG_PROFILE_PIC_PATH_50_50).getFile();
            imageLibrary.resizeImage(uploadPath + imageFileName, profilePicPath50_50 + imageFileName, Constants.IMG_PROFILE_PIC_WIDTH_50, Constants.IMG_PROFILE_PIC_HEIGHT_50);
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
    
    @ClientRequest(action = ACTION.UPDATE_USER_LOGO)
    public ClientResponse updateUserLogo(ISession session, IPacket packet){
        Gson gson = new Gson();
        User user = gson.fromJson(packet.getPacketBody(), User.class);
        //read image from temp directory and place into user logo directory
        String imageFileName = user.getAgentLogo().trim().replaceAll("\n", "");
        user.setAgentLogo(imageFileName);
        if(!StringUtils.isNullOrEmpty(imageFileName))
        {
            //String root = Constants.SERVER_ROOT_DIR;
            String uploadPath = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.IMAGE_UPLOAD_PATH).getFile();
            String profilePicPath = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.USER_LOGO_PATH).getFile();
            
            //copy actual image
            FileUtils.copyFile(uploadPath + imageFileName, profilePicPath + imageFileName);
            
            //resize image to 100px to 100px
            String profileLogoPath100_100 = RequestHandler.class.getClassLoader().getResource(Constants.SERVER_ROOT_DIR + Constants.USER_LOGO_PATH_100_100).getFile();
            ImageLibrary imageLibrary = new ImageLibrary();
            imageLibrary.resizeImage(uploadPath + imageFileName, profileLogoPath100_100 + imageFileName, Constants.IMG_PROFILE_LOGO_WIDTH_100, Constants.IMG_PROFILE_LOGO_HEIGHT_100);
        }
        UserManager userManager = new UserManager();
        userManager.updateUserProfile(user);
        
        GeneralResponse response = new GeneralResponse();
        response.setMessage("Logo is updated successfully.");
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.UPDATE_PRODUCT_INFO)
    public ClientResponse updateProductInfo(ISession session, IPacket packet){
        ProductManager productManager = new ProductManager();
        Gson gson = new Gson();
        Product product = gson.fromJson(packet.getPacketBody(), Product.class);
        productManager.updateProduct(product);
        
        GeneralResponse response = new GeneralResponse();
        response.setMessage("Product is updated successfully.");
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_STAT_LIST)
    public ClientResponse getStatList(ISession session, IPacket packet){
        Gson gson1 = new Gson();
        StatParams statParams = gson1.fromJson(packet.getPacketBody(), StatParams.class);
        ProductLibrary productLibrary = new ProductLibrary();
        List<Stat> statList = productLibrary.getStatList(statParams.getStartDate(), statParams.getEndDate(), statParams.getProductId());
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String statListString = gson.toJson(statList);
        StatList response = gson.fromJson("{\"stats\":" +statListString +"}", StatList.class);
        response.setSuccess(true);
        return response;
    }
}
