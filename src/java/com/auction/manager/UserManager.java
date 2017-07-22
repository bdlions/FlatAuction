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
    
    /**
     * This method will return member roles excluding admin
     * @return List, role list
     * @author nazmul hasan on 13th july 2017
    */
    public List<Role> getMemberRoles() {
        List<Role> roles = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
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
        return roles;
    }
    
    /**
     * This method will update user profile
     * @param userId, user id
     * @return User
     * @author nazmul hasan on 29th May 2017
    */
    public User getUserProfileById(int userId) 
    {
        Session session = HibernateUtil.getSession();
        User user = null;
        try
        {
            Transaction transaction = session.beginTransaction();
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
        }
        
        return user;
    }
    
    public void updateUserProfile(User user) {
        Session session = HibernateUtil.getSession();
        session.clear();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        try
        {
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
        }
        catch(Exception ex)
        {
            logger.debug(ex.toString());
        }
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
    }
    
    //Session session = HibernateUtil.getSession();
    public User getUserByCredential(String identity, String password) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery("getUserByCredential")
                .setString("email", identity)
                .setString("password", password);

        User user = (User)query.uniqueResult();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return user;
    }
    
    public User getUserByIdentity(String identity) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery("getUserByIdentity")
                .setString("email", identity);

        User user = (User)query.uniqueResult();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return user;
    }

    public void addUserProfile(User user) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
    }

    

    public List<Role> getRoles() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery("getRoles");
        List<Role> roles = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return roles;
    }

    public Set<Role> getUserRolesByUserId(int userId) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getNamedQuery("getUserById")
                .setInteger("id", userId);

        User user = (User)query.uniqueResult();
        
        Set<Role> roles = null;
        
        if(user != null){
            roles = user.getRoles();
        }
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return roles;
    }


    public void getActionsRoles() {

    }
    
    public User getUserProfileByFbCode(String fbCode) 
    {
        Session session = HibernateUtil.getSession();
        User user = null;
        try
        {
            Transaction transaction = session.beginTransaction();
            Query query = session.getNamedQuery("getUserByFbCode")
                    .setString("fb_code", fbCode);
            user = (User)query.uniqueResult();
            if (!transaction.wasCommitted()){
                transaction.commit();
            }
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
        }        
        return user;
    }
    
    public List<User> getUsers(int offset, int limit) {
        Session session = HibernateUtil.getSession();
        List<User> users = new ArrayList<>();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("select {u.*} from users u limit :limit offset :offset ")
                    .addEntity("u",User.class)
                    .setInteger("limit", limit)
                    .setInteger("offset", offset);        
        users = query.list();        
        if (!transaction.wasCommitted()){
            transaction.commit();
        }
        return users;
    }
}
