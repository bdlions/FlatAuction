/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.exceptions;

/**
 *
 * @author alamgir
 */
public class InvalidRequestException extends Exception{

    public InvalidRequestException(String msg) {
        super(msg);
    }

    public InvalidRequestException() {
        this("Invalid Request.");
    }
    
    
}
