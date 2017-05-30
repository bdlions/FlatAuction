/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.auction.db.HibernateUtil;
import com.auction.dto.AccountStatus;
import com.auction.dto.Credential;
import com.auction.dto.Role;
import com.auction.dto.Stock;
import com.auction.dto.User;
import com.auction.dto.UserRoles;
import com.auction.manager.UserManager;
import com.auction.util.DBUserProvider;
import com.auction.util.FileUtils;
import com.auction.util.ServerPropertyProvider;
import com.auction.util.StringUtils;
import com.google.gson.Gson;
import com.google.gson.internal.bind.TypeAdapters;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.persistence.Persistence;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.bdlions.session.UserAuthentificationInfo;
import org.bdlions.session.UserRealm;
import org.bdlions.session.UserSessionImpl;
import org.bdlions.session.db.IDBUserProvider;
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
        //user.setAccountStatusId(1);
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
        
        Role role1 = new Role();
        role1.setName("ADMIN");
        role1.setDescription("Admin");

        Role role2 = new Role();
        role2.setName("LANDLORD");
        role2.setDescription("Landlord");
        
        Role role3 = new Role();
        role3.setName("TANENT");
        role3.setDescription("Tanent");
                
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(role1);
        session.save(role2);
        session.save(role3);
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
        user.setFirstName("Nazmul");
        user.setLastName("Hasan");
        user.setUserName("nazmul");
        user.setPassword("pass");
        user.setImg("user.jpg");
        user.setIsVerified(false);
        user.setAccountStatus(activeStatus);

        session2.save(user);
        session2.getTransaction().commit();
        
        Session session3 = HibernateUtil.getSession();
        session3.beginTransaction();
        
        UserRoles userRoles1 = new UserRoles();
        userRoles1.setRole(role1);
        userRoles1.setUser(user);
        
        UserRoles userRoles2 = new UserRoles();
        userRoles2.setRole(role2);
        userRoles2.setUser(user);
        
        UserRoles userRoles3 = new UserRoles();
        userRoles3.setRole(role2);
        userRoles3.setUser(user);
        
        session3.save(userRoles1);
        session3.save(userRoles2);
        session3.save(userRoles3);
        
        session3.getTransaction().commit();
        
    }

    //@Test
    public void getUserByIdTest() 
    {
        UserManager userManager = new UserManager();
        User user = userManager.getUserProfileById(1);
        System.out.println(user.getUserName());
    }
    
    @Test
    public void updateUserProfilePictureTest() 
    {
        UserManager userManager = new UserManager();
        User user = userManager.getUserProfileById(1);
        user.setImg("fv485tdkdgr9hb2ru5d0av0qcq.jpg");
        
        String imageFileName = user.getImg();
        if(!StringUtils.isNullOrEmpty(imageFileName))
        {
            String root = ServerPropertyProvider.get("SERVER_ROOT_DIR");
            
            FileUtils.copyFile(root + ServerPropertyProvider.get("IMAGE_UPLOAD_PATH") + imageFileName, root + ServerPropertyProvider.get("PROFILE_PIC_PATH") + imageFileName);
        }
        
        userManager.updateUserProfile(user);
        System.out.println("User profile is updated successfully.");
    }
    
    //@Test
    public void updateUserProfileTest() 
    {
        UserManager userManager = new UserManager();
        User user = userManager.getUserProfileById(1);
        user.setCellNo("01711123456");
        userManager.updateUserProfile(user);
        System.out.println("User profile is updated successfully.");
    }
}
