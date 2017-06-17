/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.util;

import java.io.IOException;

/**
 *
 * @author alamgir
 */
public class FacebookConfig extends PropertyProvider{
    private static FacebookConfig instance;
    public static final String CALLBACK_URL = "CALLBACK_URL";
    public static final String APP_ID = "APP_ID";
    public static final String APP_SECRET = "APP_SECRET";
    public static final String SCOPE = "SCOPE";
    public static final String SCOPE_REQUIRED = "SCOPE_REQUIRED";
    public static final String AUTH_URL = "AUTH_URL";
    
    private FacebookConfig(String fileName) throws IOException {
        super(fileName);
    }
    
    public static FacebookConfig getInstance(){
        try{
            if(instance == null){
                instance = new FacebookConfig("facebook.properties");
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return instance;
    }
    
    @Override
    public String get(String key){
        return super.get(key);
    }
}
