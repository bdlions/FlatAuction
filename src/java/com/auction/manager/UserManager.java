package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.auction.dto.Role;
import com.auction.dto.User;
import java.util.ArrayList;
import java.util.Iterator;
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
    Session session = HibernateUtil.getSession();
    public User getUserByCredential(String identity, String password) {
        //Session session = HibernateUtil.getSession();
        Query query = session.getNamedQuery("getUserByCredential")
                .setString("email", identity)
                .setString("password", password);

        User user = (User)query.uniqueResult();
        return user;
    }
    
    public User getUserByIdentity(String identity) {
        Query query = session.getNamedQuery("getUserByIdentity")
                .setString("email", identity);

        User user = (User)query.uniqueResult();
        return user;
    }

    public void addUserProfile(User user) {
        //Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void updateUserProfile(User user) {
        //Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    public List<Role> getRoles() {
        //Session session = HibernateUtil.getSession();
        Query query = session.getNamedQuery("getRoles");
        List<Role> roles = query.list();
        return roles;
    }

    public Set<Role> getUserRolesByUserId(int userId) {
        
        Query query = session.getNamedQuery("getUserById")
                .setInteger("userId", userId);

        User user = (User)query.uniqueResult();
        
        Set<Role> roles = null;
        
        if(user != null){
            roles = user.getRoles();
        }
        
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
}
