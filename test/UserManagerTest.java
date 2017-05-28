/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.auction.db.HibernateUtil;
import com.auction.dto.AccountStatus;
import com.auction.dto.Role;
import com.auction.dto.Stock;
import com.auction.dto.User;
import com.auction.dto.UserRoles;
import com.auction.manager.UserManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
        user.setAccountStatusId(1);
        user.setCreatedOn(System.currentTimeMillis());

        UserManager manager = new UserManager();
        manager.addUserProfile(user);
    }

//    @Test
    public void getUserByCredential() {
        UserManager manager = new UserManager();
        User user = manager.getUserByCredential("alamgir", "pass");
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

    //@Test
    public void getUserRoles() {
        UserManager user = new UserManager();
        Set<Role> roles = user.getUserRolesByUserId(1);
        System.out.println("roles are : ");
        if(roles != null){
//            for(int i = 0; i < roles.size() ; i ++){
//                Role role = roles.get(i);
////                System.out.println("Role id: " + role.getId() + ", Role Name: " + role.getName());
//                System.out.println("sdfffffffffffffffffffffffffffffffffffffff");
//            }
            Iterator<Role> it = roles.iterator();
            while(it.hasNext()){
                Role role = it.next();
                System.out.println("Role id: " + role.getId() + ", Role Name: " + role.getName());
            }
        }
        
    }  
    
    //@Test
    public void defaultData(){
        
        Role role = new Role();
        role.setName("Admin");
        role.setDescription("Admin");

        Role role2 = new Role();
        role2.setName("Admin2");
        role2.setDescription("Admin2");
                
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(role);
        session.save(role2);
        session.getTransaction().commit();
        
        AccountStatus activeStatus = new AccountStatus();
        activeStatus.setDescription("Active");
        AccountStatus inActiveStatus = new AccountStatus();
        inActiveStatus.setDescription("Inactive");
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(activeStatus);
        session.save(inActiveStatus);
        session.getTransaction().commit();
        
        Session session2 = HibernateUtil.getSession();
        session2.beginTransaction();
        User user = new User();
        user.setFirstName("alamgir");
        user.setLastName("kabir");
        user.setUserName("alamgir");
        user.setPassword("pass");
        user.setAccountStatus(activeStatus);

        session2.save(user);
        session2.getTransaction().commit();
        
        Session session3 = HibernateUtil.getSession();
        session3.beginTransaction();
        
        UserRoles userRoles = new UserRoles();
        userRoles.setRole(role);
        userRoles.setUser(user);
        session3.save(userRoles);
        UserRoles userRoles2 = new UserRoles();
        userRoles2.setRole(role2);
        userRoles2.setUser(user);
        session3.save(userRoles2);
        
        session3.getTransaction().commit();
        
    }
    

}
