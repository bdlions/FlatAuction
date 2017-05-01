/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.request.handler;

import com.auction.dto.Profile;
import com.auction.packet.IPacket;
import com.auction.session.ISession;
import com.auction.session.ISessionManager;
import com.auction.util.ACTION;
import com.auction.util.ClientMessages;
import com.auction.util.ClientResponse;
import com.auction.util.SignInResponse;
import com.auction.util.StringUtils;
import com.auction.util.annotation.ClientRequest;
import com.google.gson.Gson;
import java.util.UUID;

/**
 *
 * @author alamgir
 */
public class AuthHandler {

    private final ISessionManager sessionManager;
    public AuthHandler(ISessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
    
    @ClientRequest(action = ACTION.SIGN_IN)
    public ClientResponse signIn(ISession session, IPacket packet) throws Exception{
        SignInResponse response = new SignInResponse();
        
        if(StringUtils.isNullOrEmpty(packet.getPacketBody())){
            response.setMessage(ClientMessages.INVALID_SIGNIN_REQUEST_FORMAT);
            response.setSuccess(false);
            return response;
        }
        
        Gson gson = new Gson();
        Profile user = gson.fromJson(packet.getPacketBody(), Profile.class);
        
        if(StringUtils.isNullOrEmpty(user.getUserName())){
            response.setMessage(ClientMessages.USER_NAME_IS_MANDATORY);
            response.setSuccess(false);
            return response;
        }
        if(StringUtils.isNullOrEmpty(user.getPassword())){
            response.setMessage(ClientMessages.PASSWORD_IS_MANDATORY);
            response.setSuccess(false);
            return response;
        }
        
        response.setSessionId(UUID.randomUUID() + user.getUserName());
        response.setSuccess(true);
        response.setAddress("Dhaka");
        response.setUserName("dddd");

        return response;
    }

    @ClientRequest(action = ACTION.SIGN_OUT)
    public ClientResponse signOut(ISession session, IPacket packet) throws Exception{
        System.out.println("msg" + packet.getPacketBody());
        SignInResponse response = new SignInResponse();
        response.setMessage("Sign out successful");
        response.setSuccess(true);
        //return null;
        return response;
    }
}
