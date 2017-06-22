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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alamgir
 */
public class WorldPayConfig extends PropertyProvider{
    private static WorldPayConfig instance;
    
    public static final String INSTALLATION_ID          = "INSTALLATION_ID";
    public static final String TEST_MODE                = "TEST_MODE";
    public static final String ENVIRONMENT              = "ENVIRONMENT";
    public static final String CAPTURE_DELAY            = "CAPTURE_DELAY";
    public static final String CART_PREFIX              = "CART_PREFIX";
    public static final String CURRENCY_CODE            = "CURRENCY_CODE";
    public static final String MD5_ENCRYPTION           = "MD5_ENCRYPTION";
    public static final String MD5_SECRET_KEY           = "MD5_SECRET_KEY";
    public static final String BUTTON_DISPLAY_TEXT      = "BUTTON_DISPLAY_TEXT";
    public static final String VISA_CARD_ENABLE         = "VISA_CARD_ENABLE";
    public static final String MASTER_CARD_ENABLE       = "MASTER_CARD_ENABLE";
    public static final String MAESTRO_CARD_ENABLE      = "MAESTRO_CARD_ENABLE";
    public static final String JCB_CARD_ENABLE          = "JCB_CARD_ENABLE";
    public static final String AMEX_CARD_ENABLE         = "AMEX_CARD_ENABLE";
    public static final String ELV_CARD_ENABLE          = "ELV_CARD_ENABLE";
    public static final String BILLING_ADDRESS          = "BILLING_ADDRESS";
    public static final String WITH_DELIVERY            = "WITH_DELIVERY";
    public static final String DELIVER_ADDRESS          = "DELIVER_ADDRESS";
    public static final String FIXED_CONTACT_DETAILS    = "FIXED_CONTACT_DETAILS";
    public static final String HIDE_CONTACT_DETAILS     = "HIDE_CONTACT_DETAILS";
    public static final String AUTH_MODE                = "AUTH_MODE";
    public static final String AUTH_MODE_ERROR          = "AUTH_MODE_ERROR";
    public static final String WORLDPAY_URL             = "WORLDPAY_URL";
    public static final String WORLDPAY_SANDBOX_URL     = "WORLDPAY_SANDBOX_URL";
    public static final String VISA_CARD_URL            = "VISA_CARD_URL";
    public static final String MASTER_CARD_URL          = "MASTER_CARD_URL";
    public static final String MAESTRO_CARD_URL         = "MAESTRO_CARD_URL";
    public static final String JCB_CARD_URL             = "JCB_CARD_URL";
    public static final String AMEX_CARD_URL            = "AMEX_CARD_URL";
    public static final String ELV_CARD_URL             = "ELV_CARD_URL";
    public static final String MARCHANT_CODE_1          = "MARCHANT_CODE_1";
    public static final String MARCHANT_CODE_2          = "MARCHANT_CODE_2";
    public static final String MARCHANT_CODE_3          = "MARCHANT_CODE_3";
    
    private final Map<String, String> dynInfo = new HashMap<>();
    
    private WorldPayConfig(String fileName) throws IOException {
        super(fileName);
    }
    
    public static WorldPayConfig getInstance(){
        try{
            if(instance == null){
                instance = new WorldPayConfig("worldpay.properties");
                int captureDelayDay = Integer.parseInt(instance.get(CAPTURE_DELAY));
                
                instance.dynInfo.put(AUTH_MODE_ERROR, "");
                if(captureDelayDay == -1){
                    instance.dynInfo.put(AUTH_MODE, "E");
                }
                else if(captureDelayDay <= 14){
                    instance.dynInfo.put(AUTH_MODE, "A");
                }
                else{
                    instance.dynInfo.put(AUTH_MODE, "A");
                    instance.dynInfo.put(AUTH_MODE_ERROR, "This is not a valid Capture Delay setting. This will be set to 0 days by default.");
                }
                
                
                if(instance.get(ENVIRONMENT).equals("TEST")){
                    instance.dynInfo.put(TEST_MODE, "100");
                }
                else{
                    instance.dynInfo.put(TEST_MODE, "0");
                }
                
                if(instance.get(VISA_CARD_ENABLE).equals("Y")){
                    instance.dynInfo.put(VISA_CARD_URL, "<img src=\"http://www.worldpay.com/images/cardlogos/VISA.gif\" border=\"0\" alt=\"Visa Credit payments supported by WorldPay\">");
                }
                if(instance.get(MASTER_CARD_ENABLE).equals("Y")){
                    instance.dynInfo.put(MASTER_CARD_URL, "<img src=\"http://www.worldpay.com/images/cardlogos/mastercard.gif\" border=\"0\" alt=\"Mastercard payments supported by WorldPay\">");
                }
                if(instance.get(MAESTRO_CARD_ENABLE).equals("Y")){
                    instance.dynInfo.put(MAESTRO_CARD_URL, "<img src=\"http://www.worldpay.com/images/cardlogos/maestro.gif\" border=\"0\" alt=\"Maestro payments supported by WorldPay\">");
                }
                if(instance.get(JCB_CARD_ENABLE).equals("Y")){
                    instance.dynInfo.put(JCB_CARD_URL, "<img src=\"http://www.worldpay.com/images/cardlogos/JCB.gif\" border=\"0\" alt=\"JCB payments supported by WorldPay\">");
                }
                if(instance.get(AMEX_CARD_ENABLE).equals("Y")){
                    instance.dynInfo.put(AMEX_CARD_URL, "<img src=\"http://www.worldpay.com/images/cardlogos/AMEX.gif\" border=\"0\" alt=\"American Express payments supported by WorldPay\">");
                }
                if(instance.get(ELV_CARD_ENABLE).equals("Y")){
                    instance.dynInfo.put(ELV_CARD_URL, "<img src=\"http://www.worldpay.com/images/cardlogos/ELV.gif\" border=\"0\" alt=\"ELV payments supported by WorldPay\">");
                }
                
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return instance;
    }
    
    @Override
    public String get(String key){
        if(dynInfo.containsKey(key)){
            return dynInfo.get(key);
        }
        String val = super.get(key);
        
        return val == null ? "" : val;
    }
}
