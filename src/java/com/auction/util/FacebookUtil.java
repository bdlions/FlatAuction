/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
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
            JsonObject json = (JsonObject) new JsonParser().parse(outputString);
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
            JsonObject json = (JsonObject) new JsonParser().parse(outputString);

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

//        String code = "AQDORZPBxaHAetYur_pkeITl4StuK9pKelUDkPeOv-22jvefMP852JR7uDyQUJm8YGFkePPjRspE4QDZoupNpy10MbFQgsFn-Xwuhc5yKDLla_qJ3JkF2okugzcRBJujaTtqD-hnLqnuMUAK8yv15_C5j6cgg_sgk1ad3itCTV4cMzDs3blI5EBC6ihYdKR7ZykrwkKDI3JRZ85Wd8gylo5XI6zTgdcG-KdZu8_h3bI5CN9ljM6oartMSfJk6-68Nhc5AlKrOEPGsXqlOC8-9FYvso2v_n6q9a_mCFYhpdJlj7e64RX_dCyuigPAwf4F6ho#_=_";
        String clientId = FacebookConfig.getInstance().get(FacebookConfig.APP_ID);
        String redirectURI = FacebookConfig.getInstance().get(FacebookConfig.CALLBACK_URL);
        String clientSecret = FacebookConfig.getInstance().get(FacebookConfig.APP_SECRET);

        //FacebookClient facebookClient = new DefaultFacebookClient(Version.VERSION_2_9);
//        FacebookClient.AccessToken accessToken = facebookClient.obtainUserAccessToken(clientId, clientSecret, redirectURI, code);
        String accessToken = "EAAJN8HlAVdEBANAPD7u3QN6YKumESMAn6ONP8L2fikMf6w38ooQBtXlj09Xkn1k9tVEdh6ymVfo6VrlxzliysMa7DP9mLZCmr6NJeTcaBS0dg8wLJmMMpyHxQZAoWV0XnemvslLCNrZB9cvkf0rMzZApQ35Fi1oZD";
        //String appAccessToken = facebookClient.obtainAppAccessToken(clientId, clientSecret).getAccessToken();
        //System.out.println(accessToken);
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_3);
        //FacebookClient.DebugTokenInfo debug = facebookClient.debugToken(appAccessToken);
        //System.out.println(debug);
        //System.out.println(debug.isValid());
        User user = facebookClient.fetchObject("me", User.class);
        String userId = user.getId();

        System.out.println("User Id: " + userId);
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Date of birth: " + user.getBirthday());
        System.out.println("Gender: " + user.getGender());
        com.restfb.json.JsonObject js = facebookClient.fetchObject("/me/picture", com.restfb.json.JsonObject.class,
                Parameter.with("type", "large"), // the image size
                Parameter.with("redirect", "false")); // don't redirect
        System.out.println("profile picture: " + ((com.restfb.json.JsonObject) js.get("data")).get("url"));

//        facebookClient = new DefaultFacebookClient(accessToken.getAccessToken(), clientSecret, Version.VERSION_2_3);
//        FacebookClient.AccessToken accessToken2 = facebookClient.obtainExtendedAccessToken(clientId, clientSecret);
//        
//        System.out.println(accessToken2.getAccessToken() );
    }
}
