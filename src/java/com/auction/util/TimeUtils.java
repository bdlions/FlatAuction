package com.auction.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nazmul hasan
 */
public class TimeUtils {
    private final Logger logger = LoggerFactory.getLogger(TimeUtils.class);
    public TimeUtils()
    {
    
    }
    
    public long getCurrentTime()
    {
        long currentTime = System.currentTimeMillis() / 1000L;        
        return currentTime;
    }
    
    /**
     * This method will return current gmt date
     * @return String current date
     * @author nazmul hasan on 8 august 2017
     */
    public String getCurrentDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // give a timezone reference for formating (see comment at the bottom
        String timeStamp = sdf.format(java.util.Calendar.getInstance().getTime());
        return timeStamp;
    }
    
    public String convertUnixToHuman(long unixSeconds, String dateFormat) {
        if(StringUtils.isNullOrEmpty(dateFormat))
        {
            dateFormat = "yyyy-MM-dd h:mm a";
        }
        //reference http://stackoverflow.com/questions/17432735/convert-unix-time-stamp-to-date-in-java
        //http://stackoverflow.com/questions/8046167/convert-unix-time-into-readable-date-in-java
        Date date = new Date(unixSeconds * 1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat); // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // give a timezone reference for formating (see comment at the bottom
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
    
    public String convertUnixToHumanDate(long unixSeconds, String dateFormat) {
        //if no date formate is defined then we will use yyyy-MM-dd formate
        if(StringUtils.isNullOrEmpty(dateFormat))
        {
            dateFormat = "yyyy-MM-dd";
        }
        Date date = new Date(unixSeconds * 1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat); // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // give a timezone reference for formating (see comment at the bottom
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
    
    public String convertUnixToHumanTime(long unixSeconds) {
        Date date = new Date(unixSeconds * 1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("h a"); // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // give a timezone reference for formating (see comment at the bottom
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
    
    public long getHumanToUnix(String date, String dateFormat)
    {
        //if no date formate is defined then we will use yyyy-MM-dd formate
        if(StringUtils.isNullOrEmpty(dateFormat))
        {
            dateFormat = "yyyy-MM-dd";
        }
        long unixTime = 0;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat); // the format of your date
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            unixTime = sdf.parse(date).getTime() / 1000;            
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            unixTime = 0;
        }
        return unixTime;
    }
    
    /**
     * This method will convert database date format into user format
     * @param dbDate data in database format
     * @return String user format date
     * @author nazmul hasan on 8 august 2017
     */
    public String covertDBToUserDate(String dbDate)
    {
//        if(!StringUtils.isNullOrEmpty(dbDate))
//        {
//            String[] dbDateArray = dbDate.split("-");
//            if(dbDateArray.length == 3)
//            {
//                return dbDateArray[2]+"/"+dbDateArray[1]+"/"+dbDateArray[0];
//            }
//        }
        return dbDate;
    }
    
    /**
     * This method will convert user date format into db format
     * @param userDate data in user format
     * @return String db format date
     * @author nazmul hasan on 8 august 2017
     */
    public String covertUserToDBDate(String userDate)
    {
//        if(!StringUtils.isNullOrEmpty(userDate))
//        {
//            String[] userDateArray = userDate.split("/");
//            if(userDateArray.length == 3)
//            {
//                return userDateArray[2]+"-"+userDateArray[1]+"-"+userDateArray[0];
//            }
//        }
        return userDate;
    }
    
    
    
//    public long getEndingProductHumanToUnix(String humanFormatTime, String availableTime)
//    {
//        long response = 0;
//        long unixtime = 0;
//        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");  
//        dfm.setTimeZone(TimeZone.getTimeZone("GMT"));//Specify your timezone 
//        try
//        {
//            unixtime = dfm.parse(humanFormatTime).getTime();  
//            unixtime = unixtime/1000;
//            long currentTime = System.currentTimeMillis() / 1000L;
//            response = unixtime - currentTime;
//            long offset = this.convertTimeToUnix(availableTime);
//            response = response + offset;
//        } 
//        catch (Exception e) 
//        {
//            e.printStackTrace();
//            response = 0;
//        }
//        if(response < 0)
//        {
//            response = 0;
//        }
//        return response;
//    }
    
    public long convertTimeToUnix(String time)
    {
        long offset = 0;
        switch(time)
        {
            case "12 AM" : 
                offset = 0 * 3600;
                break;
            case "1 AM" : 
                offset = 1 * 3600;
                break;
            case "2 AM" : 
                offset = 2 * 3600;
                break;
            case "3 AM" : 
                offset = 3 * 3600;
                break;
            case "4 AM" : 
                offset = 4 * 3600;
                break;
            case "5 AM" : 
                offset = 5 * 3600;
                break;
            case "6 AM" : 
                offset = 6 * 3600;
                break;
            case "7 AM" : 
                offset = 7 * 3600;
                break;
            case "8 AM" : 
                offset = 8 * 3600;
                break;
            case "9 AM" : 
                offset = 9 * 3600;
                break;
            case "10 AM" : 
                offset = 10 * 3600;
                break;
            case "11 AM" : 
                offset = 11 * 3600;
                break;
            case "12 PM" : 
                offset = 12 * 3600;
                break;
            case "1 PM" : 
                offset = 13 * 3600;
                break;
            case "2 PM" : 
                offset = 14 * 3600;
                break;
            case "3 PM" : 
                offset = 15 * 3600;
                break;
            case "4 PM" : 
                offset = 16 * 3600;
                break;
            case "5 PM" : 
                offset = 17 * 3600;
                break;
            case "6 PM" : 
                offset = 18 * 3600;
                break;
            case "7 PM" : 
                offset = 19 * 3600;
                break;
            case "8 PM" : 
                offset = 20 * 3600;
                break;
            case "9 PM" : 
                offset = 21 * 3600;
                break;
            case "10 PM" : 
                offset = 22 * 3600;
                break;
            case "11 PM" : 
                offset = 23 * 3600;
                break;
            default:
                offset = 0;
        }
        return offset;
    }
}
