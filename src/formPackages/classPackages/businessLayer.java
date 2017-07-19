
package formPackages.classPackages;

import java.awt.Font;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author jo
 */

public class businessLayer {
        
        public static OracleResultSet csvRs;
        private  OracleCallableStatement call_Stetment;
        private  OracleResultSet record_Set;
        
        private static String ErrorCode ;
               
        public static String ethnicity;
        public String targetName;
        
        public static int ethnicity_ID;
        public static int seq_next_Val;
        public static String [] row_Values= null;
        public static int flag_Parameter;
        
        private String seq_ValProc="select_Data_Package.get_Seq(?)";
        private String seq_Autho="select_Data_Package.get_AuthoSeq(?)";
        private String seq_AutoIncome="select_Data_Package.get_seqIncomeRange(?)";
        private String seq_AuthoQualification="select_Data_Package.get_seqQualification(?)";
        private String seq_ValAuthoLiveIn="select_Data_Package.get_seqLiveIn(?)";
        private String seq_AuthoBenefit="select_Data_Package.get_seqBenefit(?)";
        private String seq_ValAuthoEthnic="select_Data_Package.get_seqEthnic(?)";
        private String seq_AuthoEthnicBg="select_Data_Package.get_seqEthnicBG(?)";
        private String seq_ValAuthoDisabilityNature="select_Data_Package.get_seqDisabilityNature(?)";
        private String seq_AuthoEquality="select_Data_Package.get_seqEquality(?)";
        private String seq_ValAuthoRelegion="select_Data_Package.get_seqRelegion(?)";
        private String seq_AuthoEmpStatus="select_Data_Package.get_seqEmpStatus(?)";
        
        public static HashMap<Integer, Integer> IDHolder_EmpStatus= new HashMap<>();
        public static HashMap<Integer, Integer> IDHolder_TotalIncome= new HashMap<>();
        public static HashMap<Integer, Integer> IDHolder_LiveIn= new HashMap<>();
        public static HashMap<Integer, Integer> IDHolder_SexualOrientaion= new HashMap<>();
        public static HashMap<Integer, Integer> IDHolder_Qualification= new HashMap<>();
        public static HashMap<Integer, Integer> IDHolder_Benefit= new HashMap<>();
        public static HashMap<Integer, Integer> IDHolder_Ethnicity= new HashMap<>();
        public static HashMap<Integer, Integer> IDHolder_EthnicityBack= new HashMap<>();
        public static HashMap<Integer, Integer> IDHolder_Relegion= new HashMap<>();
        public static HashMap<Integer,Integer> IDholder_TargetNames=new HashMap<>();
        public static HashMap<Integer,Integer> IDholder_CourseName=new HashMap<>(); 
        public static HashMap<Integer, Integer> IDHolder_test= new HashMap<>(); //test
        
        utility utilityObj=new utility();
        persisitanceLayer persistancObj= new persisitanceLayer();
    
    /**
     * Insert the data to the database  
     */
        
   public void insert_NewAccount(String userID,String Sur_Name,String Given_Name,String gunder,String date_of_Birth){
                                      
            try{
                                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_System_User(?,?,?,?,to_date(?,'dd/MM/yyyy'),?)}");
                
                call_Stetment.setString(1, userID);
                call_Stetment.setString(2, Sur_Name);
                call_Stetment.setString(3, Given_Name); 
                call_Stetment.setString(4,gunder);
                call_Stetment.setString(5, date_of_Birth);
                              
                call_Stetment.registerOutParameter(6, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(6);  
              
                              
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
             }
        }
        
   public void insert_LoginData(String userID,String userName,String password){
        
            try{
                                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_login(?,?,?,?)}");
                
                call_Stetment.setString(1, userID);
                call_Stetment.setString(2, userName);
                call_Stetment.setString(3, password); 
               
                call_Stetment.registerOutParameter(4, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(4);  
              
                              
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
             }
        }
   
   public void insert_accessData(String userID,String accessLevel,String grantUserContent){
        
            try{
                                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Grant_Acess(?,?,?,?)}");
                
                call_Stetment.setString(1, userID);
                call_Stetment.setString(2, accessLevel);
                call_Stetment.setString(3, grantUserContent);          
                call_Stetment.registerOutParameter(4, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(4);  
              
                              
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
             }
        }
   
   public void insert_Beneficiary(String student_Ref,String Sur_Name,String Given_Name,String date_of_Birth,
                                      String gunder, int sex_Orientaion,int relegion,String insurance_No){
        
            try{
                
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Beneficiary(?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?)}");
                
                //call_Stetment.registerOutParameter(12, OracleTypes.VARCHAR);
               
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setString(2, Sur_Name);
                call_Stetment.setString(3, Given_Name); 
                call_Stetment.setString(4, date_of_Birth);
                call_Stetment.setString(5,gunder);
                call_Stetment.setInt(6, sex_Orientaion);
                call_Stetment.setInt(7, relegion);
                call_Stetment.setString(8, insurance_No);
                
                call_Stetment.registerOutParameter(9, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(9);  
              
                              
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
             }
        }
                
   public void insert_Benficiary_Address(String student_Ref,String address1,String address2,String city,
               String postal_Code,String tel_No,String email,String Twitter){
          
           try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Address(?,?,?,?,?,?,?,?,?)}");
          
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setString(2, address1);
                call_Stetment.setString(3, address2); 
                call_Stetment.setString(4, city);
                call_Stetment.setString(5,postal_Code);
                call_Stetment.setString(6, tel_No);
                call_Stetment.setString(7, email);
                call_Stetment.setString(8, Twitter);
                
                call_Stetment.registerOutParameter(9, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(9);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
       
       }         
       
    public void insert_Personal_Information(String student_Ref, int ethnicity,int ethnicity_Back,String disability,
                                            String disability_Nature,String Other){
                        
                try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Personal_Information(?,?,?,?,?,?,?)}");
                //System.out.println(student_Ref +" , "+ disability);  
                
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setInt(2, ethnicity);
                call_Stetment.setInt(3, ethnicity_Back); 
                call_Stetment.setString(4, disability);
                call_Stetment.setString(5,disability_Nature);
                call_Stetment.setString(6, Other);
                
                call_Stetment.registerOutParameter(7, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
                
                ErrorCode=call_Stetment.getString(7);  
               // System.out.println(ErrorCode +" , "+ call_Stetment.isClosed()); 
             // JOptionPane.showMessageDialog(null, "Data Save Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                              
                }catch(Exception ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void insert_Personal_Background(String student_Ref,int employment_Status,int income,int livingIn,int qualification,
                                            String eligibility_Comment,String disadvantage_Group,int Benefit){
       
        try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Personal_Background(?,?,?,?,?,?,?,?,?)}");
          
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setInt(2,employment_Status);
                call_Stetment.setInt(3, income);
                call_Stetment.setInt(4, livingIn); 
                call_Stetment.setInt(5, qualification);
                call_Stetment.setString(6,eligibility_Comment);
                call_Stetment.setString(7, disadvantage_Group);
                call_Stetment.setInt(8, Benefit);
                
                
                call_Stetment.registerOutParameter(9, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(9);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
            
    public void insert_Additional_Information(String student_Ref,String enrolment_Date,String type_Beneficiary,
                                              String vol_StartDate,String vol_EndDate, String with_Carer,String know_About_Us,
                                              String refer_By,String vol_Profession,String dateEntryUk,String preferToContact){
        
                try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Additional_Information(?,to_date(?,'dd/MM/yyyy'),?,to_date(?,'dd/MM/yyyy'),to_date(?,'dd/MM/yyyy'),?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?)}");
          
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setString(2,enrolment_Date);
                call_Stetment.setString(3, type_Beneficiary);
                call_Stetment.setString(4, vol_StartDate); 
                call_Stetment.setString(5, vol_EndDate);
                //call_Stetment.setDate(6,original_VolStartDate);
                call_Stetment.setString(6, with_Carer);
                call_Stetment.setString(7, know_About_Us);
                call_Stetment.setString(8, refer_By);
                call_Stetment.setString(9, vol_Profession);
                call_Stetment.setString(10, dateEntryUk);
                 call_Stetment.setString(11, preferToContact);
                
                call_Stetment.registerOutParameter(12, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(12);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void insert_Course(int course_ID,int target_ID,String course_Name,float ITQ_Point,String course_Description){
        
             try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Course(?,?,?,?,?,?)}");
          
                call_Stetment.setInt(1, course_ID);
                call_Stetment.setInt(2,target_ID);
                call_Stetment.setString(3, course_Name);
                call_Stetment.setFloat(4, ITQ_Point); 
                call_Stetment.setString(5, course_Description);
                
                              
                call_Stetment.registerOutParameter(6, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(6);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void insert_CourseTaken(String student_Ref,int course_ID ){
         try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Course_Taken(?,?,?)}");
          
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setInt(2,course_ID);
                             
                call_Stetment.registerOutParameter(3, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(3);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
        
    }
    
    public void insert_CourseeExam(String student_Ref,int course_ID,String exam_Status,String date_Claimed,String date_StatusConfermed ){
         try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Course_Exam(?,?,?,to_date(?,'dd/MM/yyyy'),to_date(?,'dd/MM/yyyy'),?)}");
          
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setInt(2,course_ID);
                call_Stetment.setString(3, exam_Status);
                call_Stetment.setString(4,date_Claimed);
                call_Stetment.setString(5, date_StatusConfermed);
             
                             
                call_Stetment.registerOutParameter(6, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(6);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
        
    }
    
    public void insert_Target(int target_ID,String target_Name){
        
         try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Project_Targate(?,?,?)}");
          
                call_Stetment.setInt(1, target_ID);
                call_Stetment.setString(2,target_Name);
                             
                call_Stetment.registerOutParameter(3, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(3);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
        
        
    }
   
    public void insert_Event(int event_ID,int target_ID,String event_Name,String event_Start_Date,String presented_By){
             
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Event(?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?)}");
          
                call_Stetment.setInt(1,event_ID);
                call_Stetment.setInt(2,target_ID);
                call_Stetment.setString(3,event_Name);
                call_Stetment.setString(4,event_Start_Date);
                call_Stetment.setString(5,presented_By);
                call_Stetment.setString(6,"Waiting");
                
                call_Stetment.registerOutParameter(7, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(7);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void insert_EventAttendance(int event_ID,int number_Attendee){
         
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Event_Attendance(?,?,?)}");
          
                call_Stetment.setInt(1,event_ID);
                call_Stetment.setInt(2,number_Attendee);
                                
                call_Stetment.registerOutParameter(3, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(3);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void insert_Vulnerablity(String student_Ref,String description,String vul_Date,String whom_Report){
        try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Vulnerable_Adult(?,?,to_date(?,'dd/MM/yyyy'),?,?)}");
          
                call_Stetment.setString(1,student_Ref);
                call_Stetment.setString(2,description);
                call_Stetment.setString(3,vul_Date);
                call_Stetment.setString(4,whom_Report);  
                
                call_Stetment.registerOutParameter(5, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(5);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void insert_AdditinalParameter(int id_Parameter,String val_Parameter,String proc_Name){
        try{
                            
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall(proc_Name);
                if (proc_Name=="{call data_Entry_Package.add_New_Ethnicity_BgInfo(?,?,?,?)}"){
                    call_Stetment.setInt(1,ethnicity_ID);
                    call_Stetment.setInt(2,id_Parameter);
                    call_Stetment.setString(3,val_Parameter);

                    call_Stetment.registerOutParameter(4, java.sql.Types.VARCHAR);
                    call_Stetment.executeUpdate();
               
                    ErrorCode=call_Stetment.getString(4);  
                } else {
                    
                    call_Stetment.setInt(1,id_Parameter);
                    call_Stetment.setString(2,val_Parameter);

                    call_Stetment.registerOutParameter(3, java.sql.Types.VARCHAR);
                    call_Stetment.executeUpdate();

                    ErrorCode=call_Stetment.getString(3);  
                }
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void insert_Certificate(String student_Ref,int course_ID,String isCertificateReceived,
                                   String certificateType,String status,String dateCollected){
             try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Certificate(?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?)}");
          
                call_Stetment.setString(1,student_Ref);
                call_Stetment.setInt(2,course_ID);
                call_Stetment.setString(3,isCertificateReceived);
                call_Stetment.setString(4,certificateType);  
                call_Stetment.setString(5,status); 
                call_Stetment.setString(6,dateCollected); 
                 
                call_Stetment.registerOutParameter(7, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(7);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void insert_CourseSchedule(int course_ID,String week_Day,String session_Start,String session_End,String roomNo ){
         try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Course_Schedule(?,?,to_date(?,'HH24:MI'),to_date(?,'HH24:MI'),?,?)}");
          
                call_Stetment.setInt(1,course_ID);
                call_Stetment.setString(2,week_Day);
                call_Stetment.setString(3,session_Start);
                call_Stetment.setString(4,session_End);  
                call_Stetment.setString(5,roomNo);              
                
                call_Stetment.registerOutParameter(6, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(6);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void insert_Attendace(String student_Ref,int courseId,String todate,String timeIn ,int flag){
         try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Student_Attendance(?,?,to_date(?,'dd/MM/yyyy'),to_date(?,'HH24:MI'),to_date(?,'HH24:MI'),?,?,?)}");
          
                call_Stetment.setString(1,student_Ref);
                call_Stetment.setInt(2,courseId);
                call_Stetment.setString(3,todate);
                call_Stetment.setString(4,timeIn);  
                call_Stetment.setString(5,null);              
                call_Stetment.setString(6,null);
                call_Stetment.setInt(7,flag);
                call_Stetment.registerOutParameter(8, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(8);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void insert_AttendaceVol(String student_Ref,String todate,String timeIn ,int flag){
         try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call data_Entry_Package.add_Vol_Attendance(?,to_date(?,'dd/MM/yyyy'),to_date(?,'HH24:MI'),to_date(?,'HH24:MI'),?,?,?)}");
          
                call_Stetment.setString(1,student_Ref);
                call_Stetment.setString(2,todate);
                call_Stetment.setString(3,timeIn);  
                call_Stetment.setString(4,null);              
                call_Stetment.setString(5,null);
                call_Stetment.setInt(6,flag);
                call_Stetment.registerOutParameter(7, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(7);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Insertion",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
     }
    
    public void update_Target(int target_ID,String target_Name){
        
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_Target(?,?,?)}");
          
                call_Stetment.setInt(1, target_ID);
                call_Stetment.setString(2,target_Name);
                             
                call_Stetment.registerOutParameter(3, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(3);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void update_Course(int course_ID,String course_Name,float ITQ_Point,String course_Description){
         
             try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_Course(?,?,?,?,?)}");
          
                call_Stetment.setInt(1, course_ID);
                call_Stetment.setString(2, course_Name);
                call_Stetment.setFloat(3, ITQ_Point); 
                call_Stetment.setString(4, course_Description);
                
                              
                call_Stetment.registerOutParameter(5, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(5);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
        
    }
    
    public void update_Event(int event_ID,String event_Name,String event_Start_Date,String presented_By){
        
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_Event(?,?,to_date(?,'dd/MM/yyyy'),?,?)}");
          
                call_Stetment.setInt(1,event_ID);
                call_Stetment.setString(2,event_Name);
                call_Stetment.setString(3,event_Start_Date);
                call_Stetment.setString(4,presented_By);
                
                
                call_Stetment.registerOutParameter(5, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(5);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void update_EventNoAttende(int event_ID,int NoAttende,String Status){
        
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_EventNoAttende(?,?,?,?)}");
          
                call_Stetment.setInt(1,event_ID);
                call_Stetment.setInt(2,NoAttende);
                call_Stetment.setString(3,Status);
  
                call_Stetment.registerOutParameter(4, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(4);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void update_BeneficiariesInfo(String tableName,String columnName,String value,String studentRefNo){
        try{
                    
            if(columnName=="DATE_OF_BIRTH" || columnName=="DATE_ARRIVEUK" ||
               columnName=="VOL_START_DATE" || columnName=="VOL_END_DATE"||
               columnName=="DATE_REGISTER")
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_Beneficiinfo(?,?,to_date(?,'dd/MM/yyyy'),?,?)}");
            else if (columnName=="EMP_STATUS_ID" || columnName=="INCOME_ID" ||
                    columnName=="LIVING_IN_ID" || columnName=="BENEFIT_ID" ||
                    columnName=="ETHN_BAK_ID" || columnName=="SEX_ORIENT_ID" ||
                    columnName=="ETHN_ID" || columnName=="RELIGION_ID"){
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_Beneficiinfo(?,?,TO_NUMBER(?),?,?)}");
            }else
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_Beneficiinfo(?,?,INITCAP(?),?,?)}");

                call_Stetment.setString(1,tableName);
                call_Stetment.setString(2,columnName);
                call_Stetment.setString(3,value);
                call_Stetment.setString(4,studentRefNo);
               
  
                call_Stetment.registerOutParameter(5, java.sql.Types.VARCHAR);
                call_Stetment.execute();
               
                ErrorCode=call_Stetment.getString(5);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    public void update_Parameter(String tableName,String columnName,String value,String actualvalue){
        
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_Parameter(?,?,?,?,?)}");
          
                call_Stetment.setString(1,tableName);
                call_Stetment.setString(2,columnName);
                call_Stetment.setString(3,value);
                call_Stetment.setString(4,actualvalue);
               
  
                call_Stetment.registerOutParameter(5, java.sql.Types.VARCHAR);
                call_Stetment.execute();
               
                ErrorCode=call_Stetment.getString(5);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void update_CourseExam(String student_Ref,int course_ID,String exam_Status,String date_Exam_Registration,String exam_Date){
        try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_CourseExam(?,?,?,to_date(?,'dd/MM/yyyy'),to_date(?,'dd/MM/yyyy'),?)}");
          
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setInt(2, course_ID);
                call_Stetment.setString(3, exam_Status); 
                call_Stetment.setString(4, date_Exam_Registration);
                call_Stetment.setString(5, exam_Date);
                
                              
                call_Stetment.registerOutParameter(6, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(6);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void update_Certificate(int passedCourseID , String isCertificateReady,String certificateType,String status,String dateCollected){
        
        //update_Certificate
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_Certificate(?,?,?,?,to_date(?,'dd/MM/yyyy'),?)}");
                
                call_Stetment.setInt(1, passedCourseID);
                call_Stetment.setString(2, isCertificateReady);
                call_Stetment.setString(3, certificateType);
                call_Stetment.setString(4, status); 
                call_Stetment.setString(5, dateCollected);
                
                
                              
                call_Stetment.registerOutParameter(6, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(6);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void update_Attendance(String student_Ref,String timeOute,String TotalTime,int flag){
         //Update Student and Volunteer Attendance
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_Attendance(?,to_date(?,'HH24:MI'),?,?,?)}");
                
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setString(2, timeOute);
                call_Stetment.setString(3, TotalTime); 
                call_Stetment.setInt(4, flag);
                          
                                              
                call_Stetment.registerOutParameter(5, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(5);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void update_VolType(String student_Ref,String volType){
         //Update Student and Volunteer Attendance
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_VolType(?,?,?)}");
                
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setString(2, volType);
                call_Stetment.registerOutParameter(3, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(3);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
     
    public void update_VolEndDate(String student_Ref,String volEndDate){
         //Update Student and Volunteer Attendance
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_VolEndDate(?,to_date(?,'dd/MM/yyyy'),?)}");
                
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setString(2, volEndDate);
                call_Stetment.registerOutParameter(3, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(3);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
   
    public void update_VolTypeEndDate(String student_Ref,String VolType ,String volEndDate){
         //Update Student and Volunteer Attendance
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall("{call Update_Data_Package.update_VolTypeEndDate(?,?,to_date(?,'dd/MM/yyyy'),?)}");
                
                call_Stetment.setString(1, student_Ref);
                call_Stetment.setString(2, VolType);
                call_Stetment.setString(3, volEndDate);
                call_Stetment.registerOutParameter(4, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(4);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Update",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void delet_AdditionalParameter(String val_Parameter,String proc_Name){
            
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall(proc_Name);
          
                call_Stetment.setString(1, val_Parameter);
                             
                call_Stetment.registerOutParameter(2, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(2);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Delete",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    
    public void delet_Beneficiary(String studentRef,String proc_Name){
            
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall(proc_Name);
          
                call_Stetment.setString(1, studentRef);
                             
                call_Stetment.registerOutParameter(2, java.sql.Types.VARCHAR);
                call_Stetment.executeUpdate();
               
                ErrorCode=call_Stetment.getString(2);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Delete",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void delete_Schedule(int val_Parameter,String proc_Name){
            
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall(proc_Name);
          
                call_Stetment.setInt(1, val_Parameter);
                             
                call_Stetment.registerOutParameter(2, java.sql.Types.VARCHAR);
                call_Stetment.execute();
               
                ErrorCode=call_Stetment.getString(2);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Delete",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    public void delete_Event(int val_Parameter,String proc_Name){
            
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall(proc_Name);
          
                call_Stetment.setInt(1, val_Parameter);
                             
                call_Stetment.registerOutParameter(2, java.sql.Types.VARCHAR);
                call_Stetment.execute();
               
                ErrorCode=call_Stetment.getString(2);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Delete",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    public void delete_Course(int val_Parameter,String proc_Name){
            
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall(proc_Name);
          
                call_Stetment.setInt(1, val_Parameter);
                             
                call_Stetment.registerOutParameter(2, java.sql.Types.VARCHAR);
                call_Stetment.execute();
               
                ErrorCode=call_Stetment.getString(2);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Delete",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    public void delete_UserAccount(String userID,String proc_Name){
            
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall(proc_Name);
          
                call_Stetment.setString(1,userID);
                             
                call_Stetment.registerOutParameter(2, java.sql.Types.VARCHAR);
                call_Stetment.execute();
               
                ErrorCode=call_Stetment.getString(2);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Delete",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public void delete_AssignedCourse(String refno,int courseID,String proc_Name){
            
            try{
                              
                call_Stetment=(OracleCallableStatement) 
                              persistancObj.get_conn().prepareCall(proc_Name);
          
                call_Stetment.setString(1,refno);
                call_Stetment.setInt(2,courseID);   
                
                call_Stetment.registerOutParameter(3, java.sql.Types.VARCHAR);
                call_Stetment.execute();
               
                ErrorCode=call_Stetment.getString(3);  
                            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,ErrorCode + " Error : " + ex,"Data Delete",1);
            }finally{
               
                 try { if (ErrorCode != null) ErrorCode=""; } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
            }
    }
    
    public int get_TotlaStudent(){
        
        int totalNoStudent=0;
        try{
               
               call_Stetment=(OracleCallableStatement) 
               persistancObj.get_conn().prepareCall("{call SELECT_DATA_PACKAGE.get_TotalNoStudent(?)}");
               call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
               call_Stetment.execute();
               record_Set=(OracleResultSet)call_Stetment.getObject(1);
               try{   
                    while(record_Set.next())
                    {       
                         totalNoStudent=Integer.parseInt(record_Set.getString(1));
                    }
               }catch (SQLException ex){
                        JOptionPane.showMessageDialog(null, "Error during Total Student val record set ... Error : "+ex);
                    }
                
               call_Stetment.close();
               record_Set.close();
               
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error on Total Student val procedure call : " + ex.toString());
        }
        return totalNoStudent;
                
    }
    
    public int get_TotlavolOnly(){
        
        int totalNoStudent=0;
        try{
               
               call_Stetment=(OracleCallableStatement) 
               persistancObj.get_conn().prepareCall("{call SELECT_DATA_PACKAGE.get_TotalNoVolOnly(?)}");
               call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
               call_Stetment.execute();
               record_Set=(OracleResultSet)call_Stetment.getObject(1);
               try{   
                    while(record_Set.next())
                    {       
                         totalNoStudent=Integer.parseInt(record_Set.getString(1));
                    }
               }catch (SQLException ex){
                        JOptionPane.showMessageDialog(null, "Error during Total volunteer val record set ... Error : "+ex);
                    }
                
               call_Stetment.close();
               record_Set.close();
               
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error on Total Student val procedure call : " + ex.toString());
        }
        return totalNoStudent;
                
    }
    
    public int set_SeqNextVal(int flag){
            
            try{
                
                switch(flag){
                    case 0:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_Autho + "}");
                       break;
                    case 1:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_ValProc + "}");
                        break;
                    case 2:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_AutoIncome + "}");
                       break;
                    case 3:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_AuthoQualification + "}");
                        break;
                    case 4:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_ValAuthoLiveIn + "}");
                        break;
                    case 5:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_AuthoBenefit + "}");
                        break;
                    case 6:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_ValAuthoEthnic + "}");
                        break;
                    case 7:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_AuthoEthnicBg + "}");
                        break;
                    case 8:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_ValAuthoDisabilityNature + "}");
                        break;
                    case 9:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_AuthoEquality + "}");
                        break;
                    case 10:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_ValAuthoRelegion
                               + "}");
                        break;
                    case 11:
                       call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_AuthoEmpStatus + "}");
                        break;
                                                                  
                       
                }
              /*  if(flag==1){
                    call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_ValProc + "}");

                }else{
                    call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + seq_Autho + "}");
                 
                }*/
                    call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                    call_Stetment.execute();
                    record_Set=(OracleResultSet)call_Stetment.getObject(1);
               
               try{   
                    while(record_Set.next())
                    {       
                         seq_next_Val=Integer.parseInt(record_Set.getString(1));
                    }
               }
               catch (SQLException ex){
                        JOptionPane.showMessageDialog(null, "Error during sequence next val record set ... Error : "+ex);
                    }
                
               call_Stetment.close();
                record_Set.close();
               
             }catch (SQLException ex){
             JOptionPane.showMessageDialog(null,"Error on Sequence next val procedure call : " + ex.toString());
             }
            return seq_next_Val;
    } 
      
    public void pop_Combo(JComboBox cbo_Component,String procedure_Name,String combo_Name){
             
         try{
           
               call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + procedure_Name + "}");
               if (procedure_Name=="SELECT_DATA_PACKAGE.get_EthinicityBackground(?,?)"){
                   call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                   call_Stetment.setString(2, ethnicity);
            
               }else if (procedure_Name=="SELECT_DATA_PACKAGE.get_CourseInTarget(?,?)"){
                    call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                    call_Stetment.setString(2, targetName);
                    
               }else
                    call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                    
                    call_Stetment.execute();
                    record_Set=(OracleResultSet)call_Stetment.getObject(1);

                    int a=1;
              
                    try{       
                        while(record_Set.next())
                        {
                            cbo_Component.addItem(record_Set.getString(2));
                            if(combo_Name=="cboEmploymentStatus")
                            IDHolder_EmpStatus.put(a, record_Set.getInt(1)); 
                            else if (combo_Name=="cboTotalIncome")
                            IDHolder_TotalIncome.put(a, record_Set.getInt(1)); 
                            else if (combo_Name=="cboLiveIn")
                            IDHolder_LiveIn.put(a, record_Set.getInt(1)); 
                            else if (combo_Name=="cboQualification")
                            IDHolder_Qualification.put(a, record_Set.getInt(1)); 
                            else if (combo_Name=="cboBenefit")
                            IDHolder_Benefit.put(a, record_Set.getInt(1)); 
                            else if (combo_Name=="cboEthnicity")
                            IDHolder_Ethnicity.put(a, record_Set.getInt(1)); 
                            else if (combo_Name=="cboEthnicityBack")
                            IDHolder_EthnicityBack.put(a, record_Set.getInt(1)); 
                            else if (combo_Name=="cboSexOrientaion")
                            IDHolder_SexualOrientaion.put(a, record_Set.getInt(1)); 
                            else if (combo_Name=="cboRelegion")
                            IDHolder_Relegion.put(a, record_Set.getInt(1)); 
                            else if (combo_Name=="jComboBox2")
                            IDHolder_test.put(a, record_Set.getInt(1)); 
                            else if (combo_Name=="cboTargetNames")
                            IDholder_TargetNames.put(a, record_Set.getInt(1));
                            else if (combo_Name=="cboCourseNameInTarg")
                            IDholder_CourseName.put(a, record_Set.getInt(1));
                           
                            a++;
                        }

                    }
                    catch (SQLException ex){
                        JOptionPane.showMessageDialog(null, "Error pop data to the control : " +ex);
                    }
              
                
             }catch (SQLException ex){
                    
                    JOptionPane.showMessageDialog(null, "Error pop data to the control : " + ex);
             }
             finally{               
                    try { if (record_Set != null) record_Set.close(); } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
             }
         
   }
    
    public void pop_List(JList list_Component,String procedure_Name,int flag_Paramet){
       
        flag_Parameter=flag_Paramet;
        DefaultListModel defList=new DefaultListModel();
         try{
             //SELECT_DATA_PACKAGE.GET_BENEFIT
             call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + procedure_Name + "}");
             if (procedure_Name=="SELECT_DATA_PACKAGE.get_EthinicityBackground(?,?)"){
                   call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                   call_Stetment.setString(2, ethnicity);
             }               
               
               call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
               call_Stetment.execute();
	       record_Set=(OracleResultSet)call_Stetment.getObject(1);
               int a=0;
               try{   
                    while(record_Set.next()){  
                            
                            switch(flag_Parameter){
                                case 1:
                                    defList.addElement(record_Set.getString(2));
                                    break;
                                case 3:
                                    defList.addElement(record_Set.getString(2));
                                    IDHolder_Ethnicity.put(a, record_Set.getInt(1));
                                    break;
                                default:
                                    defList.addElement(record_Set.getString(1));  
                             }
                     a++;       
                    }
               }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error during look up data loading... Error : "+ex);
               }
                    call_Stetment.close();
                    record_Set.close();
                    list_Component.setModel(defList);
                
             }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,"Error pop data to the control : " + ex.toString());
             }finally{
                    try { if (record_Set != null) record_Set.close(); } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
             }
    
    }
    public java.sql.ResultSet csvResulSet(String procedure_Name){
        try{
             //SELECT_DATA_PACKAGE.GET_BENEFIT
               call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + procedure_Name + "}");
              
                   call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                 
               call_Stetment.execute();
	       record_Set=(OracleResultSet)call_Stetment.getObject(1);
               
              
             }catch (SQLException ex){
                 JOptionPane.showMessageDialog(null, "Error pop data to the Table : " + ex.toString());
             }
             finally{
              
                    try { if (record_Set != null) record_Set.close(); } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
             }
         return record_Set;
    }
    public void pop_Talbe(JTable table,String procedure_Name,String parameter){
        
        try{
             //SELECT_DATA_PACKAGE.GET_BENEFIT
               call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + procedure_Name + "}");
               
               if (parameter=="tblCourseSchedule"||parameter=="jXTable1"){
                   
                   call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                   
               }else{
                   
                   call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                   call_Stetment.setString(2, parameter); 
                   
               }
               
               call_Stetment.execute();
	       record_Set=(OracleResultSet)call_Stetment.getObject(1);
                              
               table.setModel(get_TableData(record_Set));
               
               JTableHeader header = table.getTableHeader();
               header.setFont(new Font("SansSerif", Font.BOLD, 12));    
              
             }catch (SQLException ex){
                 JOptionPane.showMessageDialog(null, "Error pop data to the Table : " + ex.toString());
             }
             finally{
               
                    try { if (record_Set != null) record_Set.close(); } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
             }
        
    }
    
    public void pop_TalbeAttendance(JTable table,String procedure_Name,String Nameparameter,String Date1,String Date2){
        
        try{
             //SELECT_DATA_PACKAGE.GET_BENEFIT
               call_Stetment=(OracleCallableStatement) 
                       persistancObj.get_conn().prepareCall("{call " + procedure_Name + "}");
               
               if (Nameparameter=="tblEventAttendance"){
                    call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                    call_Stetment.setString(2, Date1); 
                    call_Stetment.setString(3, Date2); 
               }else   { 
                   call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                   call_Stetment.setString(2, Nameparameter); 
                   call_Stetment.setString(3, Date1); 
                   call_Stetment.setString(4, Date2); 
               }
             
               
               call_Stetment.execute();
	       record_Set=(OracleResultSet)call_Stetment.getObject(1);
                              
               table.setModel(get_TableData(record_Set));
               
               JTableHeader header = table.getTableHeader();
               header.setFont(new Font("SansSerif", Font.BOLD, 12));    
              
             }catch (SQLException ex){
                 JOptionPane.showMessageDialog(null, "Error pop data to the Table : " + ex.toString());
             }
             finally{
               
                    try { if (record_Set != null) record_Set.close(); } catch (Exception e) {};
                    try { if (call_Stetment != null) call_Stetment.close(); } catch (Exception e) {};
             }
        
    }
    
    public DefaultTableModel get_TableData(OracleResultSet resultSet){
       
	DefaultTableModel model=new DefaultTableModel();
	{  
            
		try{
                       //resultSet res=consult(querry);
			ResultSetMetaData metaDataResult= resultSet.getMetaData();
			int contColum=metaDataResult.getColumnCount();
                       
                        
			Object[] object=new Object[contColum];
			 
			for(int i=0; i<contColum;i++)
			{
				object[i]=metaDataResult.getColumnLabel(i+1);
			}
			model.setColumnIdentifiers(object);
			
                        while(resultSet.next())
			{
				Object[] fillData=new Object[model.getColumnCount()];
				
                                for (int i=0;i<model.getColumnCount();i++)
				{
					fillData[i]=resultSet.getObject(i+1);
				}
				
				model.addRow(fillData);
			}
		
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Table Model Error " + ex);
		}
	
	}
       
	return model;
}
    
    public ArrayList getCourseSchedule(String procedure_Name,String day)throws SQLException{
   
            ArrayList<String> coursSchedulList = new ArrayList<String>();

            call_Stetment=(OracleCallableStatement) 
                               persistancObj.get_conn().prepareCall("{call " + procedure_Name + "}");

            call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                      
                       call_Stetment.setString(2, day);
                       call_Stetment.execute();
            record_Set=(OracleResultSet)call_Stetment.getObject(1);
            
           while(record_Set.next()){  
               int i = 1;
                    while(i <= record_Set.getMetaData().getColumnCount()) 
                    coursSchedulList.add(record_Set.getString(i++));
                    
           }
           
            return coursSchedulList;
    
    }
    
    public ArrayList getCourseAttend(String procedure_Name,String reference_No)throws SQLException{
   
            ArrayList<String> coursSchedulList = new ArrayList<String>();

            call_Stetment=(OracleCallableStatement) 
                               persistancObj.get_conn().prepareCall("{call " + procedure_Name + "}");

            call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                       call_Stetment.setString(2, reference_No);
                       call_Stetment.execute();
              record_Set=(OracleResultSet)call_Stetment.getObject(1); 
             while(record_Set.next()){  
                
               coursSchedulList.add(record_Set.getString(1));
                
             }
            
            return coursSchedulList;
    
    }
    
    public ArrayList getBenefiType(String procedure_Name,String reference_No)throws SQLException{
   
            ArrayList<String> beneficiaryType = new ArrayList<>();

            call_Stetment=(OracleCallableStatement) 
                               persistancObj.get_conn().prepareCall("{call " + procedure_Name + "}");

            call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                      
                       call_Stetment.setString(2, reference_No);
                       call_Stetment.execute();
            record_Set=(OracleResultSet)call_Stetment.getObject(1);
            
           while(record_Set.next()){  
               int i = 1;
                    while(i <= record_Set.getMetaData().getColumnCount()) 
                    beneficiaryType.add(record_Set.getString(i++));
                    
           }
           
            return beneficiaryType;
    
    }
    
    public ArrayList getSysUser(String procedure_Name,String userID,String userPassword)throws SQLException{
   
            ArrayList<String> allSysUserInfo = new ArrayList<>();

            call_Stetment=(OracleCallableStatement) 
                               persistancObj.get_conn().prepareCall("{call " + procedure_Name + "}");

            call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                      
                       call_Stetment.setString(2, userID);
                       call_Stetment.setString(3, userPassword);
                       call_Stetment.execute();
            record_Set=(OracleResultSet)call_Stetment.getObject(1);
            
           while(record_Set.next()){  
               int i = 1;
                    while(i <= record_Set.getMetaData().getColumnCount()) 
                    allSysUserInfo.add(record_Set.getString(i++));
                    
           }
           
            return allSysUserInfo;
    
    }
    public ArrayList get_BeneficiaryDetail(String refNo) throws SQLException{
   
            ArrayList<String> beneficiaryDetail = new ArrayList<>();

            call_Stetment=(OracleCallableStatement) 
                               persistancObj.get_conn().prepareCall("{call " + "select_Data_Package.get_AllBeneficiary(?,?)" + "}");

            call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
            call_Stetment.setString(2, refNo);
            call_Stetment.execute();
            
            record_Set=(OracleResultSet)call_Stetment.getObject(1);
            
           while(record_Set.next()){  
               int i = 1;
                    while(i <= record_Set.getMetaData().getColumnCount()) 
                    beneficiaryDetail.add(record_Set.getString(i++));
                    
           }
           
            return beneficiaryDetail;
    
    }
       
    public void get_userSurGivenName(String userID,String procedure_Name,JTextField txtuserName,JTextField txtsurname,JTextField txtGivenName)throws SQLException{
   

            call_Stetment=(OracleCallableStatement) 
                               persistancObj.get_conn().prepareCall("{call " + procedure_Name + "}");

            call_Stetment.registerOutParameter(1, OracleTypes.CURSOR);
                      
                       call_Stetment.setString(2, userID);
                       call_Stetment.execute();
            record_Set=(OracleResultSet)call_Stetment.getObject(1);
            
           while(record_Set.next()){  
                    txtuserName.setText(record_Set.getString(1));
                    txtsurname.setText(record_Set.getString(2));
                    txtGivenName.setText(record_Set.getString(3));
                    
           }
     
    
    }
}
