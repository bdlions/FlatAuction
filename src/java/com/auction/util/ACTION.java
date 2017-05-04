/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.util;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author alamgir
 */
public enum ACTION {
    @SerializedName("1001")
    SIGN_IN(1001, REQUEST_TYPE.AUTH),
    @SerializedName("1002")
    SIGN_OUT(1002, REQUEST_TYPE.AUTH),
    @SerializedName("1003")
    FETCH_PRODUCT_LIST(1003, REQUEST_TYPE.REQUEST),
    @SerializedName("2001")
    FETCH_LOCATION_LIST(2001, REQUEST_TYPE.REQUEST),
    @SerializedName("2003")
    FETCH_RADIUS_LIST(2003, REQUEST_TYPE.REQUEST),
    @SerializedName("2004")
    FETCH_PRODUCT_TYPE_LIST(2004, REQUEST_TYPE.REQUEST),
    @SerializedName("2005")
    FETCH_OCCUPATION_LIST(2005, REQUEST_TYPE.REQUEST),
    @SerializedName("2006")
    FETCH_GENDER_LIST(2006, REQUEST_TYPE.REQUEST),
    @SerializedName("2007")
    FETCH_ROOM_SIZE_LIST(2007, REQUEST_TYPE.REQUEST),
    @SerializedName("2008")
    FETCH_DURATION_LIST(2008, REQUEST_TYPE.REQUEST),
    @SerializedName("2009")
    FETCH_MIN_PRICE_LIST(2009, REQUEST_TYPE.REQUEST),
    @SerializedName("2010")
    FETCH_MAX_PRICE_LIST(2010, REQUEST_TYPE.REQUEST),
    @SerializedName("2011")
    FETCH_BID_LIST(2011, REQUEST_TYPE.REQUEST),
    @SerializedName("3001")
    FETCH_PRODUCT_INFO(3001, REQUEST_TYPE.REQUEST),
    @SerializedName("3002")
    FETCH_USER_INFO(3002, REQUEST_TYPE.REQUEST),
    @SerializedName("3003")
    FETCH_ACCOUNT_SETTING_FA(3003, REQUEST_TYPE.REQUEST),
    ;

    private int id;
    private REQUEST_TYPE requestType;
    private ACTION(int id, REQUEST_TYPE requestType) {
        this.id = id;
        this.requestType = requestType;
    }
    
    public int getId(){
        return id;
    }
    
    public REQUEST_TYPE getRequestType(){
        return requestType;
    }
}
