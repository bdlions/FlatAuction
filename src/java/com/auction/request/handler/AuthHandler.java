/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.request.handler;

import com.auction.packet.IPacket;
import com.auction.session.ISession;
import com.auction.session.ISessionManager;
import com.auction.util.ACTION;
import com.auction.util.ClientResponse;
import com.auction.util.SignInResponse;
import com.auction.util.annotation.ClientRequest;

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
    public ClientResponse signIn(ISession session, IPacket packet){
        SignInResponse response = new SignInResponse();
        response.setMessage("You are Signed in successfully");
        response.setSuccess(true);
        response.setAddress("Dhaka");
        response.setUserName("dddd");
        //return null;
        return response;
    }
    //{"sfd":"sfsd"}
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
