package com.auction.manager;

import com.auction.db.Database;
import com.auction.db.model.UserModel;
import com.auction.dto.User;
import java.sql.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nazmul hasan
 */
public class UserManager {
    private final Logger logger = LoggerFactory.getLogger(UserManager.class);
    public UserManager()
    {
    
    }
    
    public User checkUser(String userName, String password)
    {
        User user = null;
        Connection connection = null;
        try
        {
            connection = Database.getInstance().getConnection();
            UserModel userModel = new UserModel(connection);
            user = userModel.checkUser(userName, password);
            connection.close();
        }
        catch(Exception ex)
        {
            logger.error(ex.toString());
            try 
            {
                if(connection != null)
                {
                    connection.close();
                }
            } 
            catch (Exception ex1) 
            {
                logger.error(ex1.toString());
            }
        } 
        return user;
    }
    
    public void getUserRoles()
    {
    
    }
    
    public void getActionsRoles()
    {
    
    }
}
