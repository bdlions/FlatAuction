package com.auction.manager;

import com.auction.db.HibernateUtil;
import com.auction.dto.AccountSettingFA;
import com.auction.dto.Currency;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nazmul hasan
 */
public class FeaturedAdManager {
    public AccountSettingFA getFeaturedAdAccountSetting(int userId)
    {
        AccountSettingFA accountSettingFA = new AccountSettingFA();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
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
        session.getTransaction().commit();
        return accountSettingFA;
    }
    
    public AccountSettingFA addFeaturedAdAccountSetting(AccountSettingFA accountSettingFA)
    {
        Currency defaultBidPerClickUnit = new Currency();
        defaultBidPerClickUnit.setId(1);
        accountSettingFA.setDefaultBidPerClickUnit(defaultBidPerClickUnit);
        Currency dailyBudgetUnit = new Currency();
        dailyBudgetUnit.setId(1);
        accountSettingFA.setDailyBudgetUnit(dailyBudgetUnit);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(accountSettingFA);
        session.getTransaction().commit();
        return accountSettingFA;
    }
    
    public void updateFeaturedAdAccountSetting(AccountSettingFA accountSettingFA)
    {
        Session session = HibernateUtil.getSession();
        session.clear();
        session.beginTransaction();
        session.update(accountSettingFA);
        session.getTransaction().commit();
    }
}
