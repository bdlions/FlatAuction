package com.auction.packet;

import com.auction.packet.IPacket;
import com.auction.util.ACTION;
import com.auction.util.REQUEST_TYPE;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alamgir
 */
public class MockPacketHeader implements IPacketHeader {

    private ACTION action;
    private REQUEST_TYPE requestType;
    private String sessionId;
    private String packetId;

    public void setPacketId(String packetId) {
        this.packetId = packetId;
    }

    public void setAction(ACTION action) {
        this.action = action;
    }

    public void setRequestType(REQUEST_TYPE requestType) {
        this.requestType = requestType;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String getPacketId() {
        return packetId;
    }

    @Override
    public ACTION getAction() {
        return action;
    }

    @Override
    public REQUEST_TYPE getRequestType() {
        return requestType;
    }

    @Override
    public String getSessionId() {
        return "sssss";
    }

    public static void main(String[] args) {
        MockPacketHeader mockPacket = new MockPacketHeader();
        mockPacket.setAction(ACTION.SIGN_IN);
        mockPacket.setRequestType(REQUEST_TYPE.AUTH);
        mockPacket.setSessionId("sessionId-111");

        String gson = new GsonBuilder().create().toJson(mockPacket);
        System.out.println(gson);

        mockPacket = new GsonBuilder().create().fromJson(gson, MockPacketHeader.class);

        gson = new GsonBuilder().create().toJson(mockPacket);
        System.out.println(gson);

    }

}
