package com.auction.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 *
 * @author nazmul hasan
 */
public class TimeUtils {
    public TimeUtils()
    {
    
    }
    
    public long getEndingProductHumanToUnix(String humanFormatTime)
    {
        long response = 0;
        long unixtime = 0;
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");  
        dfm.setTimeZone(TimeZone.getTimeZone("GMT"));//Specify your timezone 
        try
        {
            unixtime = dfm.parse(humanFormatTime).getTime();  
            unixtime = unixtime/1000;
            long currentTime = System.currentTimeMillis() / 1000L;
            response = unixtime - currentTime + 86400;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            response = 0;
        }
        if(response < 0)
        {
            response = 0;
        }
        return response;
    }
}
