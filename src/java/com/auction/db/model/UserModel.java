package com.auction.db.model;

import com.auction.dto.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nazmul hasan
 */
public class UserModel {
    private final Logger logger = LoggerFactory.getLogger(UserModel.class);
    private Connection connection;
    public UserModel(Connection connection)
    {
        this.connection = connection;
    }
    
    public User checkUser(String userName, String password)
    {
        User user = null;
        String select = "select * from users where user_name = '" + userName + "' and password = '" + password + "';";
        ResultSet rs = null;
        try {
            Statement stat = connection.createStatement();
            rs = stat.executeQuery(select);
            if (rs.next()) 
            {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
            }
        } 
        catch (Exception ex) 
        {
            logger.error(ex.toString());
            user = null;
        } 
        finally 
        {
            try 
            {
                rs.close();
            } 
            catch (Exception ex) {
                logger.error(ex.toString());    
                user = null;
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
