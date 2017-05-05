
package com.auction.db;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author nazmul hasan
 */
public class Database {
    private static Database _database;
    private String _connectionURL;
    private String _dbName = "auction_db";
    private String _driver = "com.mysql.jdbc.Driver";
    private String _userName = "root";
    private String _password = "";
    private String _host = "127.0.0.1";
    private String _port = "3306";
    
    
    /***
     * 
     * @throws DBSetupException 
     */
    private Database() throws Exception{
        
        _connectionURL = "jdbc:mysql://"+_host+":"+_port+"/";
        
        try{
            if(_userName == null || _userName.isEmpty()){
                throw new Exception();
            }
            if(_dbName == null || _dbName.isEmpty()){
                throw  new Exception();
            }
            
            Class.forName(_driver); 
            try{
                if(!isDatabaseExists()){
                    setUpDatabase();
                }
            }
            catch(SQLException ex){
                throw new Exception("Incomplete db setup error: " + ex.getMessage());
            }
            _connectionURL += _dbName;
        }
        catch(Exception ex){
            
        }
    }
    
    /***
     * 
     * @return true/false
     * @throws SQLException 
     */
    private boolean isDatabaseExists() throws SQLException{
        boolean found;
        try (Connection connection = (Connection)DriverManager.getConnection(_connectionURL, _userName, _password)) {
            found = false;
            try (ResultSet resultSet = connection.getMetaData().getCatalogs()) {
                while (resultSet.next() && !resultSet.isLast()) {
                    if(resultSet.getString("TABLE_CAT").equalsIgnoreCase(_dbName)){
                        found = true;
                        break;
                    }
                }
            }
        }
        
        return found;
    }
    
    /***
     * initial setup database if not exist
     * @throws SQLException 
     */
    private void setUpDatabase() throws SQLException{
        Connection connection = getConnection();
        try (Statement statement = (Statement) connection.createStatement()) 
        {
            
        }
    }
    
    /***
     * get the connection of the database with required username, password, dbname 
     * @return connection
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException{
        return (Connection) DriverManager.getConnection(_connectionURL, _userName, _password);
    }
    
    /**
     * get the instance of the database
     * singleton instance
     * 
     * @return
     * @throws DBSetupException 
     */
    public static synchronized Database getInstance() throws Exception{
        if(_database == null){
            _database = new Database();
        }
        return _database;
    }
}