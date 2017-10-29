/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.request.handler;

import com.auction.commons.HibernateProxyTypeAdapter;
import com.bdlions.dto.AccountSettingFA;
import com.bdlions.dto.AmenityList;
import com.bdlions.dto.AvailabilityList;
import com.bdlions.dto.BidTime;
import com.bdlions.dto.ListBidTime;
import com.bdlions.dto.ProductBidList;
import com.bdlions.dto.LocationList;
import com.bdlions.dto.Message;
import com.bdlions.dto.MessageList;
import com.bdlions.dto.OccupationList;
import com.bdlions.dto.PetList;
import com.bdlions.dto.PriceList;
import com.bdlions.dto.Product;
import com.bdlions.dto.ProductBid;
import com.bdlions.dto.ProductCategoryList;
import com.bdlions.dto.ProductList;
import com.bdlions.dto.ProductSizeList;
import com.bdlions.dto.ProductTypeList;
import com.bdlions.dto.Role;
import com.bdlions.dto.RoleList;
import com.bdlions.dto.SearchParams;
import com.bdlions.dto.SmokingList;
import com.bdlions.dto.Stat;
import com.bdlions.dto.StatList;
import com.bdlions.dto.StatParams;
import com.bdlions.dto.StayList;
import com.bdlions.dto.User;
import com.bdlions.dto.UserList;
import org.bdlions.transport.packet.IPacket;
import org.bdlions.session.ISession;
import org.bdlions.session.ISessionManager;
import com.bdlions.util.ACTION;
import com.bdlions.dto.response.ClientResponse;
import com.bdlions.dto.response.GeneralResponse;
import com.bdlions.dto.response.SignInResponse;
import com.auction.exceptions.InvalidRequestException;
import com.auction.library.ImageLibrary;
import com.auction.library.ProductLibrary;
import com.auction.manager.BidManager;
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
public class BidHandler {
    private final Logger logger = LoggerFactory.getLogger(BidHandler.class);
    private final ISessionManager sessionManager;
    public BidHandler(ISessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
    
    @ClientRequest(action = ACTION.FETCH_BID_TIME_LIST)
    public ClientResponse getBidTimeList(ISession session, IPacket packet){
        BidManager bidManager = new BidManager();
        List<BidTime> bidTimes = bidManager.getBidTimeList();
        ListBidTime listBidTime = new ListBidTime();
        listBidTime.setBidTimes(bidTimes);
        listBidTime.setSuccess(true);
        return listBidTime;
    }
}
