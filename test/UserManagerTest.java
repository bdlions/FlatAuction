/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.auction.db.HibernateUtil;
import com.auction.dto.Role;
import com.auction.dto.Stock;
import com.auction.dto.User;
import com.auction.manager.UserManager;
import java.util.List;
import java.util.Random;
import javax.persistence.Persistence;
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
    public void getUserByCredential() {
        UserManager manager = new UserManager();
        User user = manager.getUserByCredential("alamgir", "kabir");
        if (user != null) {
            System.out.println("first name: " + user.getFirstName());
        }
    }
//    @Test

    public void updateUserProfile() {
//        User user = new UserManager().getUserByCredential("alamgir87750", "pass");
        //Persistence.generateSchema("samplePU", null);
        User user = new User();
        user.setId(1);
        user.setLastName("Kabir11111111111");
        user.setFirstName("Alamgir1");

        user.setModifiedOn(System.currentTimeMillis());

        UserManager manager = new UserManager();
        manager.updateUserProfile(user);
    }

//    @Test
    public void getRoles() {
        UserManager user = new UserManager();
        for (Role role : user.getRoles()) {
            System.out.println(role.getId() + " " + role.getName() + " " + role.getDescription());
        }
    }

    @Test
    public void getUserRoles() {
        UserManager user = new UserManager();
        List<Role> roles = user.getUserRolesByUserId(1);

//        System.out.println("Role size: " + role.getRole().size());
        for (Role role1 : roles) {
            System.out.println(role1.getName());
        }

    }
//    
//    @Test

    public void getStocks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("getStocks");

        List<Stock> users = query.list();
        System.out.println("size " + users.size());
        session.close();
    }
}
