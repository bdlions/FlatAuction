/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.db;

import com.bdlions.dto.Role;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.transaction.spi.LocalStatus;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author alamgir
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static ArrayList<Session> sessions = new ArrayList();
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
//            configuration.generateSchemaCreationScript(dialect);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    synchronized public static Session getSession() {
        //getTransaction().getStatus() != TransactionStatus.ACTIVE
        for(int i = 0; i < sessions.size() ;  i ++){
            if(sessions.get(i).getTransaction().getLocalStatus() != LocalStatus.ACTIVE){
                Session tempSession = sessions.get(i);
                try
                {
                    //a dummy call to check whether session is valid or not
                    tempSession.beginTransaction();
                    Query query = tempSession.createSQLQuery("select * from roles");
                    List<Role> roles = query.list();
                    tempSession.getTransaction().commit();
                    return tempSession;
                }
                catch(Exception ex)
                {
                    //if there is exception then we will use next session in array list
                }
                //return sessions.get(i);
            }
        }
        Session session = sessionFactory.openSession();
        sessions.add(session);
        return session;
    }

    
}
