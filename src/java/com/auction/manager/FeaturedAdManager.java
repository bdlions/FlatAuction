package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.bdlions.dto.AccountSettingFA;
import com.bdlions.dto.Currency;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nazmul hasan
 */
public class FeaturedAdManager {
    private final Logger logger = LoggerFactory.getLogger(FeaturedAdManager.class);
    
    /**
     * This method will return account settings of featured ad
     * @param userId user id
     * @return AccountSettingFA
     * @author nazmul hasan on 11th June 2017
     */
    public AccountSettingFA getFeaturedAdAccountSetting(int userId)
    {
        Transaction transaction = null;
        AccountSettingFA accountSettingFA = null;
        try
        {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("select {asfa.*} from account_setting_fa asfa where user_id = :user_id ")
                            .addEntity("asfa",AccountSettingFA.class)
                            .setInteger("user_id", userId);
            List<AccountSettingFA> accountSettingFAList =  query.list();        
            if(accountSettingFAList != null && !accountSettingFAList.isEmpty())
            {
                accountSettingFA =  accountSettingFAList.get(0);  
                Currency defaultBidPerClickUnit = new Currency();
                defaultBidPerClickUnit.setId(1);
                accountSettingFA.setDefaultBidPerClickUnit(defaultBidPerClickUnit);
                Currency dailyBudgetUnit = new Currency();
                dailyBudgetUnit.setId(1);
                accountSettingFA.setDailyBudgetUnit(dailyBudgetUnit);
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
            accountSettingFA = null;
        }        
        return accountSettingFA;
    }
    
    /**
     * This method will add account settings of featured ad
     * @param accountSettingFA account setting featured ad
     * @return AccountSettingFA
     * @author nazmul hasan on 11th June 2017
     */
    public AccountSettingFA addFeaturedAdAccountSetting(AccountSettingFA accountSettingFA)
    {
        //N.B. this method should return boolean fields instead of returning object
        Transaction transaction = null;
        try
        {
            Currency defaultBidPerClickUnit = new Currency();
            defaultBidPerClickUnit.setId(1);
            accountSettingFA.setDefaultBidPerClickUnit(defaultBidPerClickUnit);
            Currency dailyBudgetUnit = new Currency();
            dailyBudgetUnit.setId(1);
            accountSettingFA.setDailyBudgetUnit(dailyBudgetUnit);
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.save(accountSettingFA);
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
        return accountSettingFA;
    }
    
    /**
     * This method will update account settings of featured ad
     * @param accountSettingFA account setting featured ad
     * @return boolean whether account setting featured ad is updated or not
     * @author nazmul hasan on 11th June 2017
     */
    public boolean updateFeaturedAdAccountSetting(AccountSettingFA accountSettingFA)
    {
        Transaction transaction = null;
        try
        {
            Session session = HibernateUtil.getSession();
            session.clear();
            transaction = session.beginTransaction();
            session.update(accountSettingFA);
            //session.getTransaction().commit();
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
}
