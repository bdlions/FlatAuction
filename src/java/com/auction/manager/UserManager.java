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

    public User getUserByCredential(String userName, String password) {
        Session session = HibernateUtil.getSession();
        Query query = session.getNamedQuery("getUserByCredential")
                .setString("userName", userName)
                .setString("password", password);

        User user = (User)query.uniqueResult();
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
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    public List<Role> getRoles() {
        Session session = HibernateUtil.getSession();
        Query query = session.getNamedQuery("getRoles");
        List<Role> roles = query.list();
        return roles;
    }

    public List<Role> getUserRolesByUserId(int userId) {
        Session session = HibernateUtil.getSession();
        Query query = session.getNamedQuery("getUserById")
                .setInteger("userId", userId);

        User user = (User)query.uniqueResult();
        
        List<Role> roles = null;
        
        if(user != null){
            roles = user.getRoles();
        }
        
        return roles;
    }


    public void getActionsRoles() {

    }
}
