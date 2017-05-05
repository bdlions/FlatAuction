/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.auction.db.HibernateUtil;
import com.auction.dto.User;
import com.auction.manager.UserManager;
import java.util.List;
import java.util.Random;
import org.hibernate.Query;
import org.hibernate.Session;
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
public class UserManagerTest {

    public UserManagerTest() {
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
    //@Test
    public void addUserProfile() {

        User user = new User();
        user.setLastName("Kabir");
        user.setFirstName("Alamgir");
        user.setUserName("alamgir" + new Random().nextInt(100000));
        user.setPassword("pass");
        user.setEmail("alamgir@gmail.com");
        user.setCreatedOn(System.currentTimeMillis());
        
        UserManager manager = new UserManager();
        manager.addUserProfile(user);
    }
    
    //@Test
    public void getUserByCredential(){
        UserManager manager = new UserManager();
        User user = manager.getUserByCredential("alamgir", "kabir");
        if(user != null){
            System.out.println("first name: " + user.getFirstName());
        }
    }
    @Test
    public void updateUserProfile(){
        User user = new UserManager().getUserByCredential("alamgir59216", "pass");
        
        user.setLastName("Kabir1");
        user.setFirstName("Alamgir1");
        
        user.setModifiedOn(System.currentTimeMillis());
        
        UserManager manager = new UserManager();
        manager.updateUserProfile(user);
    }
}
