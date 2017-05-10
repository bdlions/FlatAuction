/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.request.handler;

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
import org.bdlions.packet.IPacket;
import org.bdlions.session.ISession;
import org.bdlions.session.ISessionManager;
import com.auction.util.ACTION;
import com.auction.dto.response.ClientResponse;
import org.bdlions.util.annotation.ClientRequest;
import com.google.gson.Gson;

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
        ProductList response = new Gson().fromJson("{\"products\":[{\"id\":\"1\",\"title\":\"Fun at the Bowling Alley1\", \"img\":\"a.jpg\", \"price\":\"£100\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR1.\"}, {\"id\":\"2\",\"title\":\"Fun at the Bowling Alley2\", \"img\":\"a.jpg\", \"price\":\"£200\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR2.\"}, {\"id\":\"3\",\"title\":\"Fun at the Bowling Alley3\", \"img\":\"a.jpg\", \"price\":\"£300\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR3.\"}, {\"id\":\"4\",\"title\":\"Fun at the Bowling Alley4\", \"img\":\"a.jpg\", \"price\":\"£400\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR4.\"}, {\"id\":\"5\",\"title\":\"Fun at the Bowling Alley5\", \"img\":\"a.jpg\", \"price\":\"£500\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR5.\"}, {\"id\":\"6\",\"title\":\"Fun at the Bowling Alley6\", \"img\":\"a.jpg\", \"price\":\"£600\", \"price_type\":\"pw\", \"size\":\"single\", \"images\":[{\"id\":\"1\", \"url\":\"a.jpg\"}, {\"id\":\"2\", \"url\":\"b.jpg\"}], \"available\":\"2017-04-18\", \"description\":\"Double room in E16 available from 17/04/2017, short walk away from Prince Regent Lane DLR6.\"} ]}", ProductList.class );
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
        BidList response = new Gson().fromJson("{\"bids\":[{\"bidId\":\"1\",\"time\":\"21 Apr 2017 9:38:35AM\",\"amount\":\"1000\", \"currency\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"firstName\":\"Nazmul\", \"lastName\":\"Hasan\"}}, {\"bidId\":\"2\",\"time\":\"20 Apr 2017 9:38:35AM\",\"amount\":\"2000\", \"currency\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.00\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"user\":{\"firstName\":\"Alamgir\", \"lastName\":\"Kabir\"}}]}", BidList.class );
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
        User response = new Gson().fromJson("{\"userId\":\"1\", \"firstName\":\"Nazmul\", \"lastName\":\"Hasan\", \"email\":\"bdlions@gmail.com\", \"cellNo\":\"8801678112509\", \"img\":\"user.jpg\", \"document\":\"document.jpg\", \"isVerified\":\"true\"}", User.class );
        response.setSuccess(true);
        return response;
    }
    
    @ClientRequest(action = ACTION.FETCH_ACCOUNT_SETTING_FA)
    public ClientResponse getAccountSettingFAInfo(ISession session, IPacket packet){
        AccountSettingFA response = new Gson().fromJson("{\"defaultBidPerClick\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"9.90\",\"currencyUnit\":{\"id\":\"2\",\"title\":\"p\"}}, \"dailyBudget\":{\"id\":\"1\",\"title\":\"£\",\"amount\":\"4.40\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"campainActive\":\"true\"}", AccountSettingFA.class );
        response.setSuccess(true);
        return response;
    }
}
