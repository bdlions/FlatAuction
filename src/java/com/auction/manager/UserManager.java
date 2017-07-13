package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.auction.dto.Role;
import com.auction.dto.User;
import com.auction.util.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
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
        session.beginTransaction();
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
        session.getTransaction().commit();
        return roles;
    }
    
    //Session session = HibernateUtil.getSession();
    public User getUserByCredential(String identity, String password) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("getUserByCredential")
                .setString("email", identity)
                .setString("password", password);

        User user = (User)query.uniqueResult();
        session.getTransaction().commit();
        return user;
    }
    
    public User getUserByIdentity(String identity) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("getUserByIdentity")
                .setString("email", identity);

        User user = (User)query.uniqueResult();
        session.getTransaction().commit();
        return user;
    }

    public void addUserProfile(User user) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void updateUserProfile(User user) {
        Session session = HibernateUtil.getSession();
        session.clear();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    public List<Role> getRoles() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("getRoles");
        List<Role> roles = query.list();
        session.getTransaction().commit();
        return roles;
    }

    public Set<Role> getUserRolesByUserId(int userId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("getUserById")
                .setInteger("userId", userId);

        User user = (User)query.uniqueResult();
        
        Set<Role> roles = null;
        
        if(user != null){
            roles = user.getRoles();
        }
        session.getTransaction().commit();
        return roles;
    }


    public void getActionsRoles() {

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
            session.beginTransaction();
            Query query = session.getNamedQuery("getUserById")
                    .setInteger("id", userId);
            user = (User)query.uniqueResult();
            session.getTransaction().commit();
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
        }
        
        return user;
    }
    
    public User getUserProfileByFbCode(String fbCode) 
    {
        Session session = HibernateUtil.getSession();
        User user = null;
        try
        {
            session.beginTransaction();
            Query query = session.getNamedQuery("getUserByFbCode")
                    .setString("fb_code", fbCode);
            user = (User)query.uniqueResult();
            session.getTransaction().commit();
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
        session.beginTransaction();
        Query query = session.createSQLQuery("select {u.*} from users u limit :limit offset :offset ")
                    .addEntity("u",User.class)
                    .setInteger("limit", limit)
                    .setInteger("offset", offset);        
        users = query.list();        
        session.getTransaction().commit();
        return users;
    }
}
