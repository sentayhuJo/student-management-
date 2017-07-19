/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formPackages.classPackages;


import java.sql.*;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;


/**
 *
 * @author jo
 */
public class persisitanceLayer {
          
        private static String ServerIpAddress; //Network  host  name/IP  address 
        private static String serverNmae; // The  database  server  name 
        private static String ServerPortNumber;//The  port  number 
        private static String UserdbName; // The  name  of  the  database 
        private static String UsPassword;
        public int flag=0;
        
        private static Connection conn;
        private static String url="";
        
        
   public Connection get_conn(){ return conn; }
        
    public void connectDB() 
    {
      
        try {
           
            OracleDataSource ods = new OracleDataSource(); // Create an OracleDataSource
            url = "jdbc:oracle:thin:"+UserdbName +"/"+UsPassword + "@//"+ ServerIpAddress +":"+ServerPortNumber+"/"+serverNmae; // Set the URL (user name, and password)
            ods.setURL(url);
            conn = ods.getConnection();// Retrieve a connection
            
            flag=1;
   
        }
        catch (SQLException OraException)
        {
            JOptionPane.showMessageDialog( null,"Database connection to the server lost. Database connection error : " +  OraException,
            "Database Connection Error",JOptionPane.WARNING_MESSAGE);
        
        }
        
    }
        
    
    public void setConnectionStringValue(String serverAddress,String oracleServerName,String oracleServerPortNo,
             String oracleUserName,String oracleUserPassword)
    {
            this.ServerIpAddress = serverAddress;
            this.serverNmae = oracleServerName;
            this.ServerPortNumber = oracleServerPortNo;
            this.UserdbName =oracleUserName;
            this.UsPassword = oracleUserPassword;
            connectDB();
    }
    
    
    
}
