/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.util;

/**
 *
 * @author alamgir
 */
public class StringUtils {
    public static boolean isNullOrEmpty(String value){
        if(value == null || value.equals("")){
            return true;
        }
        return false;
    }
}
