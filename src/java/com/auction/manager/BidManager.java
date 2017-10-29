package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.bdlions.dto.BidTime;
import com.bdlions.dto.ProductType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nazmul Hasan
 */
public class BidManager {
    public BidManager()
    {
    
    }
    
    public List<BidTime> getBidTimeList()
    {
        List<BidTime> bidTimes = new ArrayList<>();
        Transaction transaction = null;
        Session session = HibernateUtil.getSession();
        session.clear();
        transaction = session.beginTransaction();        
        Query query = session.createSQLQuery("select {bt.*} from bid_times bt")
                .addEntity("bt",BidTime.class);
        bidTimes = query.list();
        if (!transaction.wasCommitted()){
            transaction.commit();
        }        
        return bidTimes;
    }
}
