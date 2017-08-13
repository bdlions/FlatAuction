package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.auction.dto.Amenity;
import com.auction.dto.Product;
import com.auction.dto.ProductAmenities;
import com.auction.dto.Role;
import com.auction.dto.User;
import com.auction.dto.UserRoles;
import com.auction.util.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nazmul hasan
 */
public class UserManager {

    private final Logger logger = LoggerFactory.getLogger(UserManager.class);
    
    //Session session = HibernateUtil.getSession();
    
    /**
     * This method will return user profile by credential
     * @param identity  user identity
     * @param password  user password
     * @return User user profile
     * @author nazmul hasan on 13th july 2017
    */
    public User getUserByCredential(String identity, String password) {
        Transaction transaction = null;
        User user = null;
        try
        {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {u.*} from users u where u.email = :email and u.password = :password ")
                    .addEntity("u",User.class)
                    .setString("email", identity)
                    .setString("password", password);

            user = (User)query.uniqueResult();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
        }        
        return user;
    }
    
    /**
     * This method will return user profile by identity
     * @param identity  user identity
     * @return User user profile
     * @author nazmul hasan on 13th july 2017
    */
    public User getUserByIdentity(String identity) {
        Transaction transaction = null;
        User user = null;
        try
        {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {u.*} from users u where u.email = :email ")
                    .addEntity("u",User.class)
                    .setString("email", identity);

            user = (User)query.uniqueResult();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            user = null;
        }
        
        return user;
    }
    
    /**
     * This method will return user profile by facebook code
     * @param fbCode  facebook code
     * @return User user profile
     * @author nazmul hasan on 13th july 2017
    */
    public User getUserProfileByFbCode(String fbCode) 
    {
        Transaction transaction = null;        
        User user = null;
        try
        {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {u.*} from users u where u.fb_code = :fb_code ")
                    .addEntity("u",User.class)
                    .setString("fb_code", fbCode);
            user = (User)query.uniqueResult();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            user = null;
        }        
        return user;
    }
    
    /**
     * This method will return member roles excluding admin
     * @return List, role list
     * @author nazmul hasan on 13th july 2017
    */
    public List<Role> getMemberRoles() {
        Transaction transaction = null;
        List<Role> roles = new ArrayList<>();
        try
        {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {r.*} from roles r")
                    .addEntity("r",Role.class);
            List<Object> rows = query.list();
            for(Object row:rows)
            {
                Role role = (Role)row;
                if(role.getId() != Constants.ROLE_ID_ADMIN)
                {
                    roles.add(role);
                }            
            }        
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            roles = new ArrayList<>();
        }        
        return roles;
    }
    
    /**
     * This method will return user profile
     * @param userId, user id
     * @return User user profile
     * @author nazmul hasan on 29th May 2017
    */
    public User getUserProfileById(int userId) 
    {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        User user = null;
        try
        {
            transaction = session.beginTransaction();
            //Query query = session.getNamedQuery("getUserById")
            //        .setInteger("id", userId);
            
            Query query = session.createSQLQuery("select {u.*} from users u where u.id = :user_id ")
                    .addEntity("u",User.class)
                    .setInteger("user_id", userId);
            List<Object[]> rows = query.list();
            for (Object row : rows) 
            {
                user = (User)row;
                break;
            }
            if(user != null)
            {
                user.setRoleList(new ArrayList<>());
                try
                {
                    Query query2 = session.createSQLQuery("select {r.*} from roles r join users_roles ur on r.id = ur.role_id where ur.user_id = :user_id ")
                            .addEntity("r",Role.class)
                            .setInteger("user_id", userId);

                    List<Object[]> rows2 = query2.list();
                    for (Object row : rows2) 
                    {
                        user.getRoleList().add((Role)row);
                    }
                }
                catch(Exception ex)
                {
                    logger.error(ex.toString());
                }
            }
            //user = (User)query.uniqueResult();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            user = null;
        }
        return user;
    }
    
    /**
     * This method will add new user profile
     * @param user user profile
     * @return boolean whether user profile is created or not
     * @author nazmul hasan on 29th May 2017
    */
    public boolean addUserProfile(User user) {
        Transaction transaction = null;
        try
        {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.save(user);
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
            return true;
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            return false;
        }        
    }
    
    /**
     * This method will update user profile
     * @param user user profile
     * @return boolean whether profile is updated or not
     * @author nazmul hasan on 29th May 2017
    */
    public boolean updateUserProfile(User user) 
    {
        Transaction transaction = null;
        try
        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();
            session.update(user);
            //delete current roles
            Query query1 = session.createSQLQuery(" delete from users_roles where user_id = :user_id")
                .setInteger("user_id", user.getId());
                query1.executeUpdate();
            //add roles
            List<Role> roleList = user.getRoleList();
            if (roleList != null) {
                for (Role role : roleList) {
                    UserRoles userRoles = new UserRoles();
                    userRoles.setRole(role);
                    userRoles.setUser(user);
                    session.save(userRoles);
                }
            }
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
            return true;
        }
        catch(Exception ex)
        {
            logger.debug(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            return false;
        }        
    }
    
    /**
     * This method will return user list
     * @param offset offset
     * @param limit limit
     * @return List user list
     * @author nazmul hasan on 29th May 2017
    */
    public List<User> getUsers(int offset, int limit) {
        Transaction transaction = null;
        List<User> users = new ArrayList<>();
        try
        {
            Session session = HibernateUtil.getSession();            
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {u.*} from users u limit :limit offset :offset ")
                        .addEntity("u",User.class)
                        .setInteger("limit", limit)
                        .setInteger("offset", offset);        
            users = query.list();        
            if (!transaction.wasCommitted()){
                transaction.commit();
            }            
        }   
        catch(Exception ex)
        {
            logger.error(ex.toString());
            if(transaction != null)
            {
                transaction.rollback();
            }
            users = new ArrayList<>();
        }        
        return users;
    }

    

    

//    public List<Role> getRoles() {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.getNamedQuery("getRoles");
//        List<Role> roles = query.list();
//        if (!transaction.wasCommitted()){
//            transaction.commit();
//        }
//        return roles;
//    }

//    public Set<Role> getUserRolesByUserId(int userId) {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.getNamedQuery("getUserById")
//                .setInteger("id", userId);
//        User user = (User)query.uniqueResult();        
//        Set<Role> roles = null;        
//        if(user != null){
//            roles = user.getRoles();
//        }
//        if (!transaction.wasCommitted()){
//            transaction.commit();
//        }
//        return roles;
//    }


//    public void getActionsRoles() {
//
//    }
    
}
