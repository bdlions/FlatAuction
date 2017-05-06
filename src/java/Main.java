
import com.auction.db.HibernateUtil;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alamgir
 */
public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        System.out.println("done.");
    }
}
