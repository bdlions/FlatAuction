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
    SIGN_OUT(1002, REQUEST_TYPE.AUTH)
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
