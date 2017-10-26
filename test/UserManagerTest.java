/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.auction.db.HibernateUtil;
import com.bdlions.dto.AccountStatus;
import com.bdlions.dto.Amenity;
import com.bdlions.dto.Availability;
import com.bdlions.dto.ProductBid;
import com.bdlions.dto.Credential;
import com.bdlions.dto.Currency;
import com.bdlions.dto.CurrencyUnit;
import com.bdlions.dto.Image;
import com.bdlions.dto.Location;
import com.bdlions.dto.Message;
import com.bdlions.dto.MessageText;
import com.bdlions.dto.Occupation;
import com.bdlions.dto.Pet;
import com.bdlions.dto.Product;
import com.bdlions.dto.ProductCategory;
import com.bdlions.dto.ProductSize;
import com.bdlions.dto.ProductType;
import com.bdlions.dto.Role;
import com.bdlions.dto.Smoking;
import com.bdlions.dto.Stay;
import com.bdlions.dto.Stock;
import com.bdlions.dto.User;
import com.bdlions.dto.UserRoles;
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
//    public void getRoles() {
//        UserManager user = new UserManager();
//        for (Role role : user.getRoles()) {
//            System.out.println(role.getId() + " " + role.getName() + " " + role.getDescription());
//        }
//    }

    
    
    @Test
    public void defaultData(){
        
        try
        {
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
            User user1 = new User();
            user1.setFirstName("Nazmul");
            user1.setLastName("Hasan");
            user1.setUserName("nazmul");
            user1.setPassword("pass");
            user1.setEmail("nazmul@gmail.com");
            user1.setCellNo("01711123456");
            user1.setImg("user.jpg");
            user1.setIsVerified(false);
            user1.setAccountStatus(activeStatus);

            User user2 = new User();
            user2.setFirstName("Alamgir");
            user2.setLastName("Kabir");
            user2.setUserName("alamgir");
            user2.setPassword("pass");
            user2.setEmail("alamgir@gmail.com");
            user2.setCellNo("01722123456");
            user2.setImg("user.jpg");
            user2.setIsVerified(false);
            user2.setAccountStatus(activeStatus);

            session2.save(user1);
            session2.save(user2);
            session2.getTransaction().commit();

            Session session3 = HibernateUtil.getSession();
            session3.beginTransaction();

            UserRoles userRoles1 = new UserRoles();
            userRoles1.setRole(role1);
            userRoles1.setUser(user1);

            UserRoles userRoles2 = new UserRoles();
            userRoles2.setRole(role2);
            userRoles2.setUser(user1);

            UserRoles userRoles3 = new UserRoles();
            userRoles3.setRole(role3);
            userRoles3.setUser(user1);

            UserRoles userRoles4 = new UserRoles();
            userRoles4.setRole(role3);
            userRoles4.setUser(user2);

            session3.save(userRoles1);
            session3.save(userRoles2);
            session3.save(userRoles3);
            session3.save(userRoles4);

            session3.getTransaction().commit();

            ProductType productType1 = new ProductType();
            productType1.setId(1);
            productType1.setTitle("Flat/Apartment");        
            ProductType productType2 = new ProductType();
            productType2.setId(2);
            productType2.setTitle("House");

            ProductSize productSize1 = new ProductSize();
            productSize1.setId(1);
            productSize1.setTitle("1 Bed");
            ProductSize productSize2 = new ProductSize();
            productSize2.setId(2);
            productSize2.setTitle("2 Bed");
            ProductSize productSize3 = new ProductSize();
            productSize3.setId(3);
            productSize3.setTitle("3 Bed");
            ProductSize productSize4 = new ProductSize();
            productSize4.setId(4);
            productSize4.setTitle("4 Bed");
            ProductSize productSize5 = new ProductSize();
            productSize5.setId(5);
            productSize5.setTitle("5 Bed");

            ProductCategory productCategory1 = new ProductCategory();
            productCategory1.setId(1);
            productCategory1.setTitle("1 Room");
            ProductCategory productCategory2 = new ProductCategory();
            productCategory2.setId(2);
            productCategory2.setTitle("2 Room");
            ProductCategory productCategory3 = new ProductCategory();
            productCategory3.setId(3);
            productCategory3.setTitle("3 Room");

            Location location1 = new Location();
            location1.setId(1);
            location1.setLocationType("type1");
            location1.setSearchString("london1");
            location1.setPostCode("c1");
            Location location2 = new Location();
            location2.setId(2);
            location2.setLocationType("type2");
            location2.setSearchString("london2");
            location2.setPostCode("c2");
            Location location3 = new Location();
            location3.setId(3);
            location3.setLocationType("type3");
            location3.setSearchString("london3");
            location3.setPostCode("c3");

            Amenity amenity1 = new Amenity();
            amenity1.setId(1);
            amenity1.setTitle("Parking");
            Amenity amenity2 = new Amenity();
            amenity2.setId(2);
            amenity2.setTitle("Balcony/patio");
            Amenity amenity3 = new Amenity();
            amenity3.setId(3);
            amenity3.setTitle("Garden/roof terrace");
            Amenity amenity4 = new Amenity();
            amenity4.setId(4);
            amenity4.setTitle("Disabled access");
            Amenity amenity5 = new Amenity();
            amenity5.setId(5);
            amenity5.setTitle("Garage");

            Availability availability1 = new Availability();
            availability1.setId(1);
            availability1.setTitle("Daily");
            
            Availability availability2 = new Availability();
            availability2.setId(1);
            availability2.setTitle("Weekly");
            
            Availability availability3 = new Availability();
            availability3.setId(1);
            availability3.setTitle("Monthly");
            

            Stay stay1 = new Stay();
            stay1.setId(1);
            stay1.setTitle("No Limit");
            Stay stay2 = new Stay();
            stay2.setId(2);
            stay2.setTitle("1 day");
            Stay stay3 = new Stay();
            stay3.setId(3);
            stay3.setTitle("3 week");
            Stay stay4 = new Stay();
            stay4.setId(4);
            stay4.setTitle("1 month");


            Smoking smoking1 = new Smoking();
            smoking1.setId(1);
            smoking1.setTitle("No preference");
            Smoking smoking2 = new Smoking();
            smoking2.setId(2);
            smoking2.setTitle("No");

            Occupation occupation1 = new Occupation();
            occupation1.setId(1);
            occupation1.setTitle("No preference");
            Occupation occupation2 = new Occupation();
            occupation2.setId(2);
            occupation2.setTitle("Student");
            Occupation occupation3 = new Occupation();
            occupation3.setId(1);
            occupation3.setTitle("Professional");

            Pet pet1 = new Pet();
            pet1.setId(1);
            pet1.setTitle("No preference");
            Pet pet2 = new Pet();
            pet2.setId(2);
            pet2.setTitle("No");


            Product product = new Product();
            product.setUser(user1);
            product.setReferenceId(StringUtils.getProductReferenceId());
            product.setTitle("product1");
            product.setDescription("description1");
            product.setFirstName("firstn1");
            product.setLastName("lastn1");
            product.setCompanyName("company1");
            product.setPhone("01722123456");
            product.setProductType(productType2);
            product.setProductSize(productSize3);
            product.setProductCategory(productCategory1);
            product.setLocation(location2);
            product.setMinStay(stay1);
            product.setMaxStay(stay3);
            product.setSmoking(smoking2);
            product.setOccupation(occupation2);
            product.setPet(pet2);
            product.setImg("a.jpg");

            Image image1 = new Image();
            image1.setTitle("a.jpg");        
            Image image2 = new Image();
            image2.setTitle("b.jpg");        
            Image image3 = new Image();
            image3.setTitle("c.jpg");
            Image[] images = new Image[3];
            images[0] = image1;
            images[1] = image2;
            images[2] = image3;


            session.beginTransaction();
            session.save(productType1);
            session.save(productType2);
            session.save(productSize1);
            session.save(productSize2);
            session.save(productSize3);
            session.save(productSize4);
            session.save(productSize5);
            session.save(productCategory1);
            session.save(productCategory2);
            session.save(productCategory3);
            session.save(location1);
            session.save(location2);
            session.save(location3);
            session.save(amenity1);
            session.save(amenity2);
            session.save(amenity3);
            session.save(amenity4);
            session.save(amenity5);
            session.save(availability1);
            session.save(availability2);
            session.save(availability3);
            session.save(stay1);
            session.save(stay2);
            session.save(stay3);
            session.save(stay4);
            session.save(smoking1);
            session.save(smoking2);
            session.save(occupation1);
            session.save(occupation2);
            session.save(occupation3);
            session.save(pet1);
            session.save(pet2);
            session.save(product);
            if (images != null) {
                for (Image image : images) {
                    image.setProductId(product.getId());
                    session.save(image);
                }
            }


            Currency currency1 = new Currency();
            currency1.setTitle("£");        
            Currency currency2 = new Currency();
            currency2.setTitle("$");
            session.save(currency1);
            session.save(currency2);

            CurrencyUnit currencyUnit1 = new CurrencyUnit();
            currencyUnit1.setTitle("default");
            CurrencyUnit currencyUnit2 = new CurrencyUnit();
            currencyUnit2.setTitle("p");
            session.save(currencyUnit1);
            session.save(currencyUnit2);


            //add a default bid
            ProductBid bid = new ProductBid();
            bid.setReferenceId("abcd1234");
            bid.setUser(user2);
            bid.setProduct(product);
            bid.setCreatedOn(1234567);
            bid.setPrice(100);
            bid.setCurrency(currency1);
            bid.setCurrencyUnit(currencyUnit1);
            session.save(bid);

            Message message = new Message();
            message.setFrom(user2);
            message.setTo(user1);
            message.setProduct(product);
            message.setSubject("I need a room");

            session.save(message);

            MessageText messageText = new MessageText();
            messageText.setBody("What is the price of that room?");
            messageText.setUser(user2);
            messageText.setMessageId(message.getId());

            session.save(messageText);

            session.getTransaction().commit();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }        
    }

    //@Test
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
    
    //@Test
    public void getUserProfileByCredentialTest() 
    {
        UserManager userManager = new UserManager();
        User user = userManager.getUserByCredential("shopnotori2@gmail.com", "");
        if(user == null)
        {
            System.out.println("User is null");
        }
        else
        {
            System.out.println(user.getEmail());
        }
    }
    
    //@Test
    public void getMemberRoles() {
        UserManager user = new UserManager();
        for (Role role : user.getMemberRoles()) {
            System.out.println(role.getId() + " " + role.getName() + " " + role.getDescription());
        }
    }
    
    //@Test
    public void getUserByIdTest() 
    {
        UserManager userManager = new UserManager();
        User user = userManager.getUserProfileById(1);
        System.out.println(user.getUserName());
    }
    
    //@Test
//    public void getUserRoles() {
//        UserManager user = new UserManager();
//        Set<Role> roles = user.getUserRolesByUserId(1);
//        System.out.println("roles are : ");
//        if(roles != null){
////            for(int i = 0; i < roles.size() ; i ++){
////                Role role = roles.get(i);
//////                System.out.println("Role id: " + role.getId() + ", Role Name: " + role.getName());
////                System.out.println("sdfffffffffffffffffffffffffffffffffffffff");
////            }
//            Iterator<Role> it = roles.iterator();
//            while(it.hasNext()){
//                Role role = it.next();
//                System.out.println("Role id: " + role.getId() + ", Role Name: " + role.getName());
//            }
//        }
//        
//    }  
}
