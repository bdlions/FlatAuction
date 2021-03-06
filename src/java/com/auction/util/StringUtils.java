package com.auction.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

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
    
    public static String getProductReferenceId()
    {
        String referenceId = "";
        Random random = new Random();
        int max = 9999999;
        int min = 1000000;
        referenceId = random.nextInt(max - min + 1) + min + "";
        return referenceId;
    }
}
