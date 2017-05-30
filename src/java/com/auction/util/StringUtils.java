package com.auction.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author nazml hasan
 */
public class StringUtils {
    public static boolean isNullOrEmpty(String str){
        return str == null || str.equals("");
    }
    
    public static String getRandomString()
    {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
}
