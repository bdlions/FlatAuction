package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.auction.dto.User;
import java.util.List;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.getNamedQuery("getUserByCredential")
                .setString("userName", userName)
                .setString("password", password);

        List<User> users = query.list();
        session.close();
        
        if (users.size() >= 1) {
            logger.debug("user credential is OK! for : " + userName);
            return users.get(0);
        }
        return null;
    }

    public void addUserProfile(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void updateUserProfile(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }
    public void getUserRoles() {

    }

    public void getActionsRoles() {

    }
}
