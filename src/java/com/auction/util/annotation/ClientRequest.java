/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.util.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import com.auction.util.ACTION;

/**
 *
 * @author alamgir
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientRequest {

    ACTION action();

    //default time 2 minutes
    int timeOut() default 1000 * 60 * 2;

}
