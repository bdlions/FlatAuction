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
public enum REQUEST_TYPE {
    @SerializedName("0")
    NONE(0),
    @SerializedName("1")
    AUTH(1),
    @SerializedName("2")
    REQUEST(2),
    @SerializedName("3")
    UPDATE(3),
    
    ;

    private final int type;
    private REQUEST_TYPE(int type) {
        this.type = type;
    }

}
