/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.auction.dto.AccountSettingFA;
import com.google.gson.Gson;
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
public class AccountTest {
    
    public AccountTest() {
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
    public void accountSettingFATest() 
    {
        AccountSettingFA response = new Gson().fromJson("{\"id\":\"1\",\"user\":{\"id\":\"1\"},\"defaultBidPerClick\":\"4\", \"defaultBidPerClickUnit\":{\"id\":\"1\",\"title\":\"p\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}},\"dailyBudget\":\"6\", \"dailyBudgetUnit\":{\"id\":\"1\",\"title\":\"£\",\"currencyUnit\":{\"id\":\"1\",\"title\":\"£\"}}, \"campainActive\":\"true\"}", AccountSettingFA.class );
        response.setSuccess(true);
    }
}
