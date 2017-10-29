/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.auction.util.TimeUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nazmul
 */
public class TimeUtilTest {
    
    public TimeUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() 
    {
        TimeUtils timeUtils = new TimeUtils();
        long currentTime = timeUtils.getCurrentTime();
        System.out.println(currentTime);
        //System.out.println(timeUtils.convertUnixToHuman(currentTime));
        //System.out.println(timeUtils.convertUnixToHumanDate(currentTime));
        System.out.println(timeUtils.convertUnixToHumanTime(currentTime));
        
//        String date = timeUtils.getCurrentDate();
//        System.out.println(date);
//        //String dateFromat = "yyyy-MM-dd h:mm a";
//        String dateFromat = "yyyy-MM-dd";
//        long unixTime = timeUtils.getHumanToUnix(date, dateFromat);
//        System.out.println(unixTime);
//        
//        System.out.println(timeUtils.convertUnixToHuman(unixTime));
    }
}
