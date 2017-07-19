/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages.classPackages;

import java.awt.Color;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Properties;
import javax.swing.JOptionPane;


import java.util.Calendar;

import java.sql.Date;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
//import java.time.LocalDate;


import javax.swing.JComponent;
import javax.swing.JLabel;

import net.java.balloontip.BalloonTip;
import net.java.balloontip.positioners.BalloonTipPositioner;
import net.java.balloontip.positioners.LeftAbovePositioner;
import net.java.balloontip.styles.BalloonTipStyle;
import net.java.balloontip.styles.EdgedBalloonStyle;
import net.java.balloontip.styles.MinimalBalloonStyle;
import net.java.balloontip.utils.TimingUtils;
import net.java.balloontip.utils.ToolTipUtils;

/**
 *
 * @author jo
 */
public class utility {
    
        private String ServerIpAddress; //Network  host  name/IP  address 
        private String serverNmae; // The  database  server  name 
        private String ServerPortNumber;//The  port  number 
        private String UserdbName; // The  name  of  the  database 
        private String UsPassword;
        
        public int flag=0;
        //********** Control Running Form *************
        public static boolean flag1=false;
        public static boolean flag2=false;
        public static boolean flag3=false;
        public static boolean flag4=false;

        public static boolean flag5=false;
        public static boolean flag6=false;
        public static boolean flag7=false;
        public static boolean flag8=false;
        public static boolean flag9=false;
        public static boolean flag10=false;
        public static boolean flag11=false;
       //************End Control**************
        
        public static String refnu;
        public static String UserName ;
        public static String userPrivilage;
        public static String [] accessContent;
        
        Properties props = new Properties();
        private File configFile = new File("config.properties");
	
        persisitanceLayer accessLayerObj= new persisitanceLayer();
        private static BalloonTip errBalloon = null;
  
    public static void setToolTip(final JComponent comp, final String text) {
		BalloonTipStyle style = new MinimalBalloonStyle(new Color(169, 205, 221, 220), 5);
		final BalloonTip balloon = new BalloonTip(comp, new JLabel(text), style, BalloonTip.Orientation.LEFT_ABOVE, BalloonTip.AttachLocation.ALIGNED, 15, 10, false);
		balloon.addDefaultMouseListener(false);
		ToolTipUtils.balloonToToolTip(balloon, 500, 3000);
	}

    public static void showErrorMessage(JComponent comp, String text) {
		if (errBalloon!=null) {
			errBalloon.closeBalloon();
		}
		BalloonTipStyle style = new MinimalBalloonStyle(new Color(246, 197, 192, 220), 5);
		errBalloon = new BalloonTip(comp, new JLabel("<html><font color=\"#6f150d\">" + text + "</font></html>"),
				style, BalloonTip.Orientation.LEFT_ABOVE, BalloonTip.AttachLocation.ALIGNED, 15, 10, false);
		errBalloon.addDefaultMouseListener(false);
		TimingUtils.showTimedBalloon(errBalloon, 3000);
	}
 
    public static BalloonTipPositioner createBalloonTipPositioner() {
		return new LeftAbovePositioner(15, 10);
	}

	
    public static String monospace(String str) {
		return "<font face=\"monospace\">" + str + "</font>"; 
	}
    public static BalloonTipStyle createBalloonTipStyle() {
		return new EdgedBalloonStyle(new Color(255,253,245), new Color(64,64,64));
	}

    public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }
 

    public void testDbConnection(String serverAddress,String oracleServerName,String oracleServerPortNo,
             String oracleUserName,String oracleUserPassword)
    {
        accessLayerObj.setConnectionStringValue(serverAddress, oracleServerName, oracleServerPortNo, oracleUserName, oracleUserPassword);
        flag=accessLayerObj.flag;
    }
    
    public String[] getConnectionValue()
    {
        String [] ConnArr=new String[5];

        readConfigFile();

        ConnArr[0]= this.ServerIpAddress;
        ConnArr[1]= this.serverNmae ;
        ConnArr[2]=this.ServerPortNumber;
        ConnArr[3]=this.UserdbName ;
        ConnArr[4]=this.UsPassword;

        return ConnArr;
    }
    
    public void connect()
    {
        readConfigFile();
    
        accessLayerObj.setConnectionStringValue(this.ServerIpAddress, this.serverNmae, this.ServerPortNumber,
                this.UserdbName, this.UsPassword);
        flag=accessLayerObj.flag;
    }
    
    public void readConfigFile()
    {
       
        //configFile=getResourceAsFile("formPackages/classPackages/config.properties");
               
        try {
                //configFile=new File(url.toURI());         
                Properties defaultProps = new Properties();
		// sets default properties
		defaultProps.setProperty("serverName", "192.168.67.11");
		defaultProps.setProperty("oracleServerName", "xe");
		defaultProps.setProperty("oracleServerPortNo", "1521");
		defaultProps.setProperty("oracleUserName", "kclc");
		defaultProps.setProperty("oracleUserPassword", "kclcadmin");
                
		props = new Properties(defaultProps);
                // loads properties from file
		InputStream inputStream = new FileInputStream(configFile);
             	props.load(inputStream);
		inputStream.close();
                
                this.ServerIpAddress = props.getProperty("serverName");
                this.serverNmae = props.getProperty("oracleServerName");
                this.ServerPortNumber = props.getProperty("oracleServerPortNo");
                this.UserdbName = props.getProperty("oracleUserName");
                this.UsPassword = props.getProperty("oracleUserPassword");
               
                
        } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null, "Configuration file does not exist, Error : " + ex); // file does not exist
        } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "I/O error , Error : " + ex);// I/O error
        }
            
    }
    public static File getResourceAsFile(String resourcePath) {
    try {
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourcePath);
        if (in == null) {
            return null;
        }

        File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
        tempFile.deleteOnExit();

        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            //copy stream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        return tempFile;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}
     public void writeConfigFile(String serverAddress,String oracleServerName,String oracleServerPortNo,
             String oracleUserName,String oracleUserPassword) 
    {
        
        try {
           
                props.setProperty("serverName", serverAddress);
                props.setProperty("oracleServerName", oracleServerName);
                props.setProperty("oracleServerPortNo", oracleServerPortNo);
                props.setProperty("oracleUserName", oracleUserName);
                props.setProperty("oracleUserPassword", oracleUserPassword);
                OutputStream outputStream = new FileOutputStream(configFile);
		props.store(outputStream, "host setttings");
		outputStream.close();
               
        
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Configuration file does not exist, Error : " + ex); // file does not exist
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "I/O error , Error : " + ex);// I/O error
        }
        
    }
    
    
    public String generateBeneficiaryID(int digitSize,String prifixFormat,int seqNextValue){
        
            // DataSet rec;
            String Sid;
            int j;
                        
            Sid= Integer.toString(seqNextValue).trim();
           // int currentYear= Year.now().getValue();
            Calendar cal = Calendar.getInstance();
            int currentYear = cal.get(Calendar.YEAR);
            j = Sid.length();
            while (j < digitSize - 1)
            {
                Sid = "0" + Sid;
                j++;
            }
            Sid = prifixFormat.trim() + Sid.trim() + "/" + currentYear;
            
            return Sid;
            
    }
    public String generateFileName(int digitSize,String prifixFormat,int seqNextValue){
        
            // DataSet rec;
            String Sid;
            //int i;
            int j;
                        
            Sid= Integer.toString(seqNextValue).trim();
            //int currentYear= Year.now().getValue();
            Calendar cal = Calendar.getInstance();
            int currentYear = cal.get(Calendar.YEAR);
            j = Sid.length();
            while (j < digitSize - 1)
            {
                Sid = "0" + Sid;
                j++;
            }
            Sid = prifixFormat.trim() + Sid.trim() + "-" + currentYear;
            
            return Sid;
            
    }
        
    public int cal_age(java.util.Date  BirthDate){
        Calendar dob = Calendar.getInstance();  
        dob.setTime(BirthDate);  
        Calendar today = Calendar.getInstance();  
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
        age--;  
        } else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
                    && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
                    age--;  
        }
        return age;
    }
    
    public String sql_Date(java.util.Date JDate){
        String formatedDate;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        if(!(JDate==null)){
         java.sql.Date  sqlDate= new java.sql.Date(JDate.getTime());
          formatedDate=df.format(sqlDate);
         //java.sql.Date lastDate=df.parse(formatedDate);
        
        }
        else formatedDate= null;
        return formatedDate;
    }
      
        
    public java.util.Date addWeeks(){
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        //Date toDayDate=new Date();
        Calendar CalendarObj = Calendar.getInstance();
        Date toDayDate = new Date((CalendarObj.getTime()).getTime());
        int noOfDays = 70; //i.e two weeks
       
        CalendarObj.setTime(toDayDate);            
        CalendarObj.add(Calendar.DAY_OF_YEAR, noOfDays);
        java.util.Date date = CalendarObj.getTime();
        return date;
    }  
    
}
