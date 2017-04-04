/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.packet;

import com.auction.util.ACTION;
import com.auction.util.REQUEST_TYPE;

/**
 *
 * @author alamgir
 */
public interface IPacketHeader {
    ACTION getAction();
    REQUEST_TYPE getRequestType();
    String getSessionId();
}
