/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.db;

import java.util.ArrayList;
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
    
    public static Session getSession() {
        //getTransaction().getStatus() != TransactionStatus.ACTIVE
        for(int i = 0; i < sessions.size() ;  i ++){
            if(sessions.get(i).getTransaction().getLocalStatus() != LocalStatus.ACTIVE){
                return sessions.get(i);
            }
        }
        Session session = sessionFactory.openSession();
        sessions.add(session);
        return session;
    }
    
    
}
