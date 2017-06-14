/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 *
 * @author alamgir
 */
public class FacebookUtil {

    public static String getAccessToken(String code) {

        try {
            String clientId = FacebookConfig.getInstance().get(FacebookConfig.APP_ID);
            String redirectURI = FacebookConfig.getInstance().get(FacebookConfig.CALLBACK_URL);
            String clientSecret = FacebookConfig.getInstance().get(FacebookConfig.APP_SECRET);
            
            URL url = new URL("https://graph.facebook.com/oauth/access_token?client_id="
                    + clientId + "&redirect_uri=" + redirectURI
                    + "&client_secret=" + clientSecret
                    + "&code=" + code);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            String line, outputString = "";
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }
//            String accessToken = null;
//            if (outputString.indexOf("access_token") != -1) {
//                int k = outputString.length();
//                accessToken = outputString.substring(k + 1, outputString.indexOf("&"));
//            }
            JsonObject json = (JsonObject)new JsonParser().parse(outputString);
            //getPermanentAccessToken((String) json.get("access_token").getAsString());
            return (String) json.get("access_token").getAsString();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (ProtocolException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static String getPermanentAccessToken(String shortTimeAccessToken) {

        try {
            String clientId = "648645175170513";
            String clientSecret = "55b6fff3a717b0c16936b4353e9b2f73";
            
            String redirectURI = "http://localhost:8080/FlatAuction/SocialAuthServlet";
            
            URL url = new URL("https://graph.facebook.com/oauth/access_token?client_id="
                    + clientId + "&redirect_uri=" + redirectURI
                    + "&grant_type=fb_exchange_token"
                    + "&client_secret=" + clientSecret
                    + "&fb_exchange_token=" + shortTimeAccessToken);
            System.out.println(url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            String line, outputString = "";
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }
//            String accessToken = null;
//            if (outputString.indexOf("access_token") != -1) {
//                int k = outputString.length();
//                accessToken = outputString.substring(k + 1, outputString.indexOf("&"));
//            }
            System.out.println(outputString);
            JsonObject json = (JsonObject)new JsonParser().parse(outputString);
            
            return shortTimeAccessToken;
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (ProtocolException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        URIBuilder uriBuilder = new URIBuilder("https://www.facebook.com/dialog/oauth");
        uriBuilder.addParameter("client_id", FacebookConfig.getInstance().get(FacebookConfig.APP_ID));
        uriBuilder.addParameter("redirect_uri", FacebookConfig.getInstance().get(FacebookConfig.CALLBACK_URL));
        uriBuilder.addParameter("scope", FacebookConfig.getInstance().get(FacebookConfig.SCOPE));
        System.out.println(uriBuilder.toString());
    }
}
