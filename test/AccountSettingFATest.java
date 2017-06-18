
import com.auction.db.HibernateUtil;
import com.auction.dto.AccountSettingFA;
import com.auction.dto.Currency;
import com.auction.dto.User;
import com.auction.manager.FeaturedAdManager;
import org.hibernate.Session;
import org.junit.Test;


/**
 *
 * @author alamgir
 */
public class AccountSettingFATest {
    @Test
    public void getAccountSettingFATest(){
        FeaturedAdManager featuredAdManager = new FeaturedAdManager();
        AccountSettingFA accountSettingFA = featuredAdManager.getFeaturedAdAccountSetting(1);
        System.out.println(accountSettingFA.getId());
    }
    
    //@Test
    public void addAccountSettingFATest(){
        FeaturedAdManager featuredAdManager = new FeaturedAdManager();
        AccountSettingFA accountSettingFA = new AccountSettingFA();
        User user = new User();
        user.setId(1);
        accountSettingFA.setUser(user);
        accountSettingFA.setDefaultBidPerClick(0.05);
        accountSettingFA.setDailyBudget(4);
        Currency defaultBidPerClickUnit = new Currency();
        defaultBidPerClickUnit.setId(1);
        accountSettingFA.setDefaultBidPerClickUnit(defaultBidPerClickUnit);
        Currency dailyBudgetUnit = new Currency();
        dailyBudgetUnit.setId(1);
        accountSettingFA.setDailyBudgetUnit(dailyBudgetUnit);
        accountSettingFA.setCampainActive(true);
        featuredAdManager.addFeaturedAdAccountSetting(accountSettingFA);
    }
    
    //@Test
    public void updateAccountSettingFATest(){
        FeaturedAdManager featuredAdManager = new FeaturedAdManager();
        AccountSettingFA accountSettingFA = featuredAdManager.getFeaturedAdAccountSetting(1);
        User user = new User();
        user.setId(1);
        accountSettingFA.setUser(user);
        accountSettingFA.setDefaultBidPerClick(0.06);
        accountSettingFA.setDailyBudget(7);
        Currency defaultBidPerClickUnit = new Currency();
        defaultBidPerClickUnit.setId(1);
        accountSettingFA.setDefaultBidPerClickUnit(defaultBidPerClickUnit);
        Currency dailyBudgetUnit = new Currency();
        dailyBudgetUnit.setId(1);
        accountSettingFA.setDailyBudgetUnit(dailyBudgetUnit);
        accountSettingFA.setCampainActive(true);
        featuredAdManager.addFeaturedAdAccountSetting(accountSettingFA);
    }
}
