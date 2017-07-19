/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages;

import formPackages.classPackages.businessLayer;
import formPackages.classPackages.utility;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.ListAdaptor;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author jo
 */
public class IntFrameReportParameter extends javax.swing.JInternalFrame {

    /**
     * Creates new form IntFrameReportParameter
     */
    private Date attendanceDateFrom;
    private Date attendanceDateTo;
    private Date enrolmentDateDemograficFrom;
    private Date enrolmentDateDemograficTo;
    private Date enrolmentDateMonthlyFrom;
    private Date EnrolmentDateMonthlyTo;
    
    private String courseAttended;
    private String employementStatusatt;
    
    private List<String> disadvantage_Group=null;
    private List<String> disabilityStatus_Group=null;
    private String religion;
    private String sexualOrientation;
    
    private String livesIn;
    private String employementStatusBack;
    private String totlaIncomeRange;
    private String benefit;
    
    
    private String reportComment;
    private String commentDempgraphic;
    private String commentPersonalInfo;
    private String commentPersonalBack;
    private String commentMonthlyReport;
   
    private static int flag=0;
    
    private static final String NOT_SELECTABLE_OPTION="Select..."; 
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
    utility utilObj=new utility();
    businessLayer busObj =new businessLayer();
    
    private String proc_EmployementStatus="SELECT_DATA_PACKAGE.get_EmployementStatus(?)"; 
    private String proc_EqualityInfo="SELECT_DATA_PACKAGE.get_EqualityInformation(?)"; 
    private String proc_Relegion="SELECT_DATA_PACKAGE.get_Relegion(?)"; 
    private String proc_SexOrientation="SELECT_DATA_PACKAGE.get_SexualOreintation(?)"; 
    private String courseList="SELECT_DATA_PACKAGE.get_CourseList(?)"; 
    private String proc_DisabilityStatus="SELECT_DATA_PACKAGE.get_DisabilityStatus(?)"; 
    private String proc_LivingIn="SELECT_DATA_PACKAGE.get_LivingIn(?)"; 
    private String proc_HouseHoldIncome="SELECT_DATA_PACKAGE.get_HouseHoldIncome(?)"; 
     private String proc_Benefit="SELECT_DATA_PACKAGE.get_Benefit(?)"; 
    
    public IntFrameReportParameter() {
        initComponents();
        
        PromptSupport.setPrompt("Write comment...", txtCommentDemographic);
        PromptSupport.setPrompt("Write comment...", txtComment);
        PromptSupport.setPrompt("Write comment...", txtCommentPersonalInfo);
        PromptSupport.setPrompt("Write comment...", txtCommentPersonalBack);
        PromptSupport.setPrompt("Write comment...", txtCommentMonthlyReport);
        
        selectCombo(cboCourseAttended);
        selectCombo(cboEmploymentStatusAtt);
       
        selectCombo(cboRelegion);
        selectCombo(cboSexualOrientation);
        selectCombo(cboLivsIn);
        selectCombo(cboEmployemeStatusBack);
        selectCombo(cboTotalIncome);
        selectCombo(cboBenefit);
       
        busObj.pop_Combo(cboEmploymentStatusAtt,proc_EmployementStatus,"cboEmploymentStatus");
        busObj.pop_Combo(cboEmployemeStatusBack,proc_EmployementStatus,"cboEmploymentStatus");
        busObj.pop_Combo(cboCourseAttended,courseList,"cboCourseAttended");
        busObj.pop_List(cboDisadvantageGroup,proc_EqualityInfo,0);
        busObj.pop_List(lstDisabilityStatus, proc_DisabilityStatus, 0);
        busObj.pop_Combo(cboRelegion,proc_Relegion,"cboRelegion");
        busObj.pop_Combo(cboSexualOrientation,proc_SexOrientation,"cboSexualOrientation");
        
        busObj.pop_Combo(cboLivsIn,proc_LivingIn,"cboLivsIn");
        busObj.pop_Combo(cboTotalIncome,proc_HouseHoldIncome,"cboTotalIncome");
        busObj.pop_Combo(cboBenefit,proc_Benefit,"cboBenefit");
        
    }

    private void set_attendanceDateFrom(){
        try{
            String  feachDate=dateFormat.format(dtAttendaceFrom.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            attendanceDateFrom= feachdate;
        }catch(Exception ex){
            utilObj.setToolTip(dtAttendaceFrom, "Attendance From Date error ! Error :" + ex);
        }
    }
    private Date get_attendanceDateFrom(){
       return attendanceDateFrom;
    }

    private void set_attendanceDateTo(){
        try{
            String  feachDate=dateFormat.format(dtAttendanceTo.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            attendanceDateTo= feachdate;
        }catch(Exception ex){
            utilObj.setToolTip(dtAttendanceTo, "Attendance From Date error ! Error :" + ex);
        }
    }
    private Date get_attendanceDateTo(){
       return attendanceDateTo;
    }
    
    private void set_employementStatusAtt(){
        if(chkEmploymentStatus.isSelected())
         employementStatusatt=cboEmploymentStatusAtt.getSelectedItem().toString();
    }
    private String get_employementStatus(){
        return employementStatusatt;
    }
    
    private void set_courseAttended(){
        if(chkCoursAttended.isSelected())
        courseAttended=cboCourseAttended.getSelectedItem().toString();
    }
    private String get_courseAttended(){
        return courseAttended;
    }
   
    private void set_Comment(){
       reportComment=txtComment.getText();
    }
    private String get_Comment(){
        return reportComment;
    }
    
    private void set_CommentPersonalInfo(){
       commentPersonalInfo=txtCommentPersonalInfo.getText();
    }
    private String get_CommentPersonalInfo(){
        return commentPersonalInfo;
    }
    
    private void set_CommentMonthlyReport(){
       commentMonthlyReport=txtCommentMonthlyReport.getText();
    }
    private String get_CommentMonthlyReport(){
        return commentMonthlyReport;
    }
    
    private void set_enrolmentDateDemographicFrom(){
        try{
            String  feachDate=dateFormat.format(dtEnrolmentDateFrom.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            enrolmentDateDemograficFrom= feachdate;
        }catch(Exception ex){
            utilObj.setToolTip(dtEnrolmentDateFrom, "Attendance From Date error ! Error :" + ex);
        }
    }
    private Date get_enrolmentDateDemographicFrom(){
       return enrolmentDateDemograficFrom;
    }
    
    private void set_enrolmentDateDemographicTo(){
        try{
            String  feachDate=dateFormat.format(dtEnrolmentDateTo.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            enrolmentDateDemograficTo= feachdate;
        }catch(Exception ex){
            utilObj.setToolTip(dtEnrolmentDateTo, "Attendance From Date error ! Error :" + ex);
        }
    }
    private Date get_enrolmentDateDemographicTo(){
       return enrolmentDateDemograficTo;
    }
    
    private void set_enrolmentDateMothlyReportFrom(){
        try{
            String  feachDate=dateFormat.format(dtEnrolmentDateFrom1Month.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            enrolmentDateMonthlyFrom= feachdate;
        }catch(Exception ex){
            utilObj.setToolTip(dtEnrolmentDateFrom1Month, "Attendance From Date error ! Error :" + ex);
        }
    }
    private Date get_enrolmentDateMothlyReportFrom(){
       return enrolmentDateMonthlyFrom;
    }
    
     private void set_enrolmentDateMothlyReportTo(){
        try{
            String  feachDate=dateFormat.format(dtEnrolmentDateTo1Month.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            EnrolmentDateMonthlyTo= feachdate;
        }catch(Exception ex){
            utilObj.setToolTip(dtEnrolmentDateTo1Month, "Attendance From Date error ! Error :" + ex);
        }
    }
    private Date get_enrolmentDateMothlyReportTo(){
       return EnrolmentDateMonthlyTo;
    }

    private String get_DisadvantageGroup(){
       String temp_String="";
        if (!(cboDisadvantageGroup.isSelectionEmpty())){
            for (String v : disadvantage_Group) {
                     temp_String=temp_String + v.trim()  +",";
                }
           temp_String= temp_String.substring(0, temp_String.length()-1).trim();
        }
        return temp_String;
    }
    
    private String get_DisabilityStatus(){
       String temp_String="";
            
            if (!(lstDisabilityStatus.isSelectionEmpty())){
               // temp_String=String.join(",", disabilityStatus_Group);
                
                for (String v : disabilityStatus_Group) {
                     temp_String=temp_String + v.trim()  +",";
                }
                temp_String=temp_String.substring(0, temp_String.length()-1).trim();
            }
            return temp_String;
    }
   
    private void set_relegion(){
        religion=cboRelegion.getSelectedItem().toString();
    }
    private String get_relegion(){
        return religion;
    }
    
    private void set_sexualOrientation(){
        sexualOrientation=cboSexualOrientation.getSelectedItem().toString();
    }
    private String get_sexualOrientation(){
        return sexualOrientation;
    }
    
    private void set_commentDemographic(){
        commentDempgraphic=txtCommentDemographic.getText();
    }
    private String get_commentDemographic(){
        return commentDempgraphic;
    }
    
    private void set_commentPersonalBackground(){
        commentPersonalBack=txtCommentPersonalBack.getText();
    }
    private String get_commentPersonalBackground(){
        return commentPersonalBack;
    }
    
    private void set_livsin(){
        livesIn=cboLivsIn.getSelectedItem().toString();
    }
    private String get_livesin(){
        return livesIn;
    }
    
    private void set_employmentStatusBack(){
        employementStatusBack=cboEmployemeStatusBack.getSelectedItem().toString();
    }
    private String get_employementStatusBack(){
        return employementStatusBack;
    }
    
    private void set_ReciptBenefit(){
        benefit=cboBenefit.getSelectedItem().toString();
    }
    private String get_ReciptBenefit(){
        return benefit;
    }
          
    private void set_TotalIncome(){
        totlaIncomeRange=cboTotalIncome.getSelectedItem().toString();
    }
    private String get_TotalIncome(){
        return totlaIncomeRange;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupDemographic = new javax.swing.ButtonGroup();
        buttonGroupPersonalInfo = new javax.swing.ButtonGroup();
        buttonGroupPersonalBackg = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dtAttendaceFrom = new com.toedter.calendar.JDateChooser();
        dtAttendanceTo = new com.toedter.calendar.JDateChooser();
        cboEmploymentStatusAtt = new javax.swing.JComboBox();
        btnGenerateAttendanceReport = new javax.swing.JButton();
        chkEmploymentStatus = new javax.swing.JCheckBox();
        chkCoursAttended = new javax.swing.JCheckBox();
        cboCourseAttended = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComment = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dtEnrolmentDateFrom1Month = new com.toedter.calendar.JDateChooser();
        dtEnrolmentDateTo1Month = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        btnGenerateReportMonth = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtCommentMonthlyReport = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        optDisadvantageGroup = new javax.swing.JRadioButton();
        optSexualOrientation = new javax.swing.JRadioButton();
        optReligion = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCommentDemographic = new javax.swing.JTextArea();
        cboRelegion = new javax.swing.JComboBox();
        cboSexualOrientation = new javax.swing.JComboBox();
        btnGeneratDemographicReport = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        cboDisadvantageGroup = new javax.swing.JList();
        jPanel6 = new javax.swing.JPanel();
        optEthnicity = new javax.swing.JRadioButton();
        optDisabilityStatus = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstDisabilityStatus = new javax.swing.JList();
        btnGeneratePersonalReport = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtCommentPersonalInfo = new javax.swing.JTextArea();
        optShowGeneder = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        optLivesIn = new javax.swing.JRadioButton();
        optEmployementStatusBack = new javax.swing.JRadioButton();
        optTotlaIncome = new javax.swing.JRadioButton();
        optReciptBenefit = new javax.swing.JRadioButton();
        cboLivsIn = new javax.swing.JComboBox();
        cboEmployemeStatusBack = new javax.swing.JComboBox();
        cboTotalIncome = new javax.swing.JComboBox();
        cboBenefit = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtCommentPersonalBack = new javax.swing.JTextArea();
        btnGeneratePersonalBackReport = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtEnrolmentDateFrom = new com.toedter.calendar.JDateChooser();
        dtEnrolmentDateTo = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        chkAgeGreterthan = new javax.swing.JCheckBox();
        chkAgeLessThan = new javax.swing.JCheckBox();
        jsAgeLessThan = new javax.swing.JSpinner();
        jsAgeGreterThan = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        dsctopPane = new javax.swing.JDesktopPane();

        setClosable(true);
        setIconifiable(true);
        setTitle("Generate Report");
        setFrameIcon(null);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel1.setText("Attendance Date  From");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("To");

        dtAttendaceFrom.setDateFormatString("dd/MM/yyyy");
        dtAttendaceFrom.setPreferredSize(new java.awt.Dimension(96, 17));

        dtAttendanceTo.setDateFormatString("dd/MM/yyyy");
        dtAttendanceTo.setPreferredSize(new java.awt.Dimension(96, 17));

        cboEmploymentStatusAtt.setEnabled(false);

        btnGenerateAttendanceReport.setText("Generate Report");
        btnGenerateAttendanceReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateAttendanceReportActionPerformed(evt);
            }
        });

        chkEmploymentStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        chkEmploymentStatus.setText("Employement Status");
        chkEmploymentStatus.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkEmploymentStatusStateChanged(evt);
            }
        });

        chkCoursAttended.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        chkCoursAttended.setText("Course Attended");
        chkCoursAttended.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkCoursAttendedStateChanged(evt);
            }
        });

        cboCourseAttended.setEnabled(false);

        txtComment.setColumns(20);
        txtComment.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtComment.setRows(5);
        jScrollPane1.setViewportView(txtComment);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGenerateAttendanceReport, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkEmploymentStatus)
                            .addComponent(chkCoursAttended)
                            .addComponent(jLabel1))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboEmploymentStatusAtt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(dtAttendaceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(dtAttendanceTo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboCourseAttended, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dtAttendaceFrom, dtAttendanceTo});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dtAttendaceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(dtAttendanceTo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkEmploymentStatus)
                            .addComponent(cboEmploymentStatusAtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkCoursAttended)
                            .addComponent(cboCourseAttended, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerateAttendanceReport)
                .addGap(17, 17, 17))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dtAttendaceFrom, dtAttendanceTo});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Attendance Report", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Record Filtering Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 11))); // NOI18N

        jLabel8.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel8.setText("Enrolment Date");

        jLabel9.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel9.setText("To");

        dtEnrolmentDateFrom1Month.setDateFormatString("dd/MM/yyyy");

        dtEnrolmentDateTo1Month.setDateFormatString("dd/MM/yyyy");

        jLabel11.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel11.setText("From");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtEnrolmentDateFrom1Month, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtEnrolmentDateTo1Month, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(dtEnrolmentDateFrom1Month, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtEnrolmentDateTo1Month, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGenerateReportMonth.setText("Generate Report");
        btnGenerateReportMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportMonthActionPerformed(evt);
            }
        });

        txtCommentMonthlyReport.setColumns(20);
        txtCommentMonthlyReport.setRows(5);
        jScrollPane7.setViewportView(txtCommentMonthlyReport);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerateReportMonth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnGenerateReportMonth))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Monthly Managment Report", jPanel3);

        jTabbedPane2.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroupDemographic.add(optDisadvantageGroup);
        optDisadvantageGroup.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optDisadvantageGroup.setText("Disadvantage Group");
        optDisadvantageGroup.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                optDisadvantageGroupStateChanged(evt);
            }
        });

        buttonGroupDemographic.add(optSexualOrientation);
        optSexualOrientation.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optSexualOrientation.setText("Sexual Orientation");
        optSexualOrientation.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                optSexualOrientationStateChanged(evt);
            }
        });

        buttonGroupDemographic.add(optReligion);
        optReligion.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optReligion.setSelected(true);
        optReligion.setText("Religion");
        optReligion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                optReligionStateChanged(evt);
            }
        });

        txtCommentDemographic.setColumns(20);
        txtCommentDemographic.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtCommentDemographic.setRows(5);
        jScrollPane2.setViewportView(txtCommentDemographic);

        cboRelegion.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        cboSexualOrientation.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboSexualOrientation.setEnabled(false);

        btnGeneratDemographicReport.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnGeneratDemographicReport.setText("Generate Report");
        btnGeneratDemographicReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratDemographicReportActionPerformed(evt);
            }
        });

        cboDisadvantageGroup.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboDisadvantageGroup.setEnabled(false);
        cboDisadvantageGroup.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                cboDisadvantageGroupValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(cboDisadvantageGroup);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(optReligion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboRelegion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(optSexualOrientation, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboSexualOrientation, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(optDisadvantageGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(136, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(btnGeneratDemographicReport, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboRelegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optDisadvantageGroup)
                    .addComponent(optReligion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optSexualOrientation)
                            .addComponent(cboSexualOrientation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGeneratDemographicReport)))
                .addGap(10, 10, 10))
        );

        jTabbedPane2.addTab("Equality Report", jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroupPersonalInfo.add(optEthnicity);
        optEthnicity.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optEthnicity.setText("Show Ethnicity");
        optEthnicity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optEthnicityItemStateChanged(evt);
            }
        });

        buttonGroupPersonalInfo.add(optDisabilityStatus);
        optDisabilityStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optDisabilityStatus.setSelected(true);
        optDisabilityStatus.setText("Disability Status");
        optDisabilityStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optDisabilityStatusItemStateChanged(evt);
            }
        });

        lstDisabilityStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstDisabilityStatus.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDisabilityStatusValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstDisabilityStatus);

        btnGeneratePersonalReport.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnGeneratePersonalReport.setText("Generate Report");
        btnGeneratePersonalReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePersonalReportActionPerformed(evt);
            }
        });

        txtCommentPersonalInfo.setColumns(20);
        txtCommentPersonalInfo.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtCommentPersonalInfo.setRows(5);
        jScrollPane5.setViewportView(txtCommentPersonalInfo);

        buttonGroupPersonalInfo.add(optShowGeneder);
        optShowGeneder.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optShowGeneder.setText("Show Geneder");
        optShowGeneder.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optShowGenederItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(optDisabilityStatus)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(optEthnicity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(optShowGeneder))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGeneratePersonalReport, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(optDisabilityStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optEthnicity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optShowGeneder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGeneratePersonalReport))
                .addGap(24, 24, 24))
        );

        jTabbedPane2.addTab("Personal Information Report", jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        buttonGroupPersonalBackg.add(optLivesIn);
        optLivesIn.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optLivesIn.setSelected(true);
        optLivesIn.setText("Lives In");
        optLivesIn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optLivesInItemStateChanged(evt);
            }
        });

        buttonGroupPersonalBackg.add(optEmployementStatusBack);
        optEmployementStatusBack.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optEmployementStatusBack.setText("Employement Status");
        optEmployementStatusBack.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optEmployementStatusBackItemStateChanged(evt);
            }
        });

        buttonGroupPersonalBackg.add(optTotlaIncome);
        optTotlaIncome.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optTotlaIncome.setText("Total House Hold Income");
        optTotlaIncome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optTotlaIncomeItemStateChanged(evt);
            }
        });

        buttonGroupPersonalBackg.add(optReciptBenefit);
        optReciptBenefit.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optReciptBenefit.setText("Recipt of Benefits");
        optReciptBenefit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optReciptBenefitItemStateChanged(evt);
            }
        });

        cboLivsIn.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        cboEmployemeStatusBack.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboEmployemeStatusBack.setEnabled(false);

        cboTotalIncome.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboTotalIncome.setEnabled(false);

        cboBenefit.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboBenefit.setEnabled(false);

        txtCommentPersonalBack.setColumns(20);
        txtCommentPersonalBack.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtCommentPersonalBack.setRows(5);
        jScrollPane6.setViewportView(txtCommentPersonalBack);

        btnGeneratePersonalBackReport.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnGeneratePersonalBackReport.setText("Generate Report");
        btnGeneratePersonalBackReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePersonalBackReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optReciptBenefit)
                    .addComponent(optTotlaIncome)
                    .addComponent(optEmployementStatusBack)
                    .addComponent(optLivesIn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTotalIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEmployemeStatusBack, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLivsIn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBenefit, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(btnGeneratePersonalBackReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboLivsIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(optLivesIn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optEmployementStatusBack)
                            .addComponent(cboEmployemeStatusBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optTotlaIncome)
                            .addComponent(cboTotalIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optReciptBenefit)
                            .addComponent(cboBenefit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGeneratePersonalBackReport)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jTabbedPane2.addTab("Personal Background Report", jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Record Filtering Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Serif", 0, 11))); // NOI18N

        jLabel4.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel4.setText("Enrolment Date");

        jLabel5.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel5.setText("To");

        dtEnrolmentDateFrom.setDateFormatString("dd/MM/yyyy");

        dtEnrolmentDateTo.setDateFormatString("dd/MM/yyyy");

        jLabel6.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel6.setText("Age");

        chkAgeGreterthan.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        chkAgeGreterthan.setForeground(new java.awt.Color(0, 0, 0));
        chkAgeGreterthan.setSelected(true);
        chkAgeGreterthan.setText(">=");
        chkAgeGreterthan.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkAgeGreterthanStateChanged(evt);
            }
        });

        chkAgeLessThan.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        chkAgeLessThan.setForeground(new java.awt.Color(0, 0, 0));
        chkAgeLessThan.setText("<=");
        chkAgeLessThan.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkAgeLessThanStateChanged(evt);
            }
        });

        jsAgeLessThan.setModel(new javax.swing.SpinnerNumberModel(10, 10, 150, 1));
        jsAgeLessThan.setEnabled(false);

        jsAgeGreterThan.setModel(new javax.swing.SpinnerNumberModel(10, 10, 150, 1));
        jsAgeGreterThan.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel7.setText("From");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkAgeGreterthan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsAgeGreterThan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkAgeLessThan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsAgeLessThan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtEnrolmentDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtEnrolmentDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jsAgeGreterThan, jsAgeLessThan});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(dtEnrolmentDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtEnrolmentDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkAgeGreterthan)
                    .addComponent(jLabel6)
                    .addComponent(jsAgeLessThan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkAgeLessThan)
                    .addComponent(jsAgeGreterThan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jsAgeGreterThan, jsAgeLessThan});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jTabbedPane2)))
        );

        jTabbedPane1.addTab("Demographic Report", jPanel2);

        javax.swing.GroupLayout dsctopPaneLayout = new javax.swing.GroupLayout(dsctopPane);
        dsctopPane.setLayout(dsctopPaneLayout);
        dsctopPaneLayout.setHorizontalGroup(
            dsctopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dsctopPaneLayout.setVerticalGroup(
            dsctopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dsctopPane)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dsctopPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateAttendanceReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateAttendanceReportActionPerformed
        try{
            
            HashMap parametersMap = new HashMap();  
            if(!(dtAttendaceFrom.getDate()==null || dtAttendanceTo.getDate()==null)){
                if(chkCoursAttended.isSelected() && chkEmploymentStatus.isSelected()){
                    
                    if(!(cboCourseAttended.getSelectedIndex()==0 && cboEmploymentStatusAtt.getSelectedIndex()==0)){
                        parametersMap.clear();
                        
                        set_attendanceDateFrom();
                        set_attendanceDateTo();
                        set_employementStatusAtt();
                        set_courseAttended();
                        set_Comment();
                        
                        parametersMap.put("attendedDate1",get_attendanceDateFrom());
                        parametersMap.put("attendedDate2",get_attendanceDateTo());
                        parametersMap.put("employementStat",get_employementStatus());
                        parametersMap.put("course_Name",get_courseAttended());
                        parametersMap.put("usreComment",get_Comment());
                        parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());
                        
                        generateReport("reports/StudentAttendanceReport.jasper",parametersMap);
                        
                    }else 
                         JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the parameter",
                                 "Missing Parameter Selection", JOptionPane.ERROR_MESSAGE);
                } else if (chkCoursAttended.isSelected() && chkEmploymentStatus.isSelected()==false){
                    
                    if(!(cboCourseAttended.getSelectedIndex()==0)){
                        parametersMap.clear();
                        
                        set_attendanceDateFrom();
                        set_attendanceDateTo();
                        set_courseAttended();
                        set_Comment();
                         
                        parametersMap.put("attendedDate1",get_attendanceDateFrom());
                        parametersMap.put("attendedDate2",get_attendanceDateTo());
                        
                        parametersMap.put("course_Name",get_courseAttended());
                        parametersMap.put("usreComment",get_Comment());
                        parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());
                        
                        generateReport("reports/StudentAttendanceCourseOnlyReport.jasper",parametersMap);
                    }else 
                         JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the parameter",
                                 "Missing Parameter Selection", JOptionPane.ERROR_MESSAGE);
                }else if (chkCoursAttended.isSelected()== false && chkEmploymentStatus.isSelected()){
                    
                    if(!(cboEmploymentStatusAtt.getSelectedIndex()==0)){
                        parametersMap.clear();
                        
                        set_attendanceDateFrom();
                        set_attendanceDateTo();
                        set_employementStatusAtt();
                        set_Comment();
                        
                        parametersMap.put("attendedDate1",get_attendanceDateFrom());
                        parametersMap.put("attendedDate2",get_attendanceDateTo());
                        parametersMap.put("EmploymentStatus",get_employementStatus());
                        
                        parametersMap.put("usreComment",get_Comment());
                        parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());
                        
                        generateReport("reports/StudentAttendanceEmpStatOnlyReport.jasper",parametersMap);
                    }else 
                         JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the parameter",
                                 "Missing Parameter Selection", JOptionPane.ERROR_MESSAGE);
                }else 
                         JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select one of the option to Generate Report",
                                 "Missing Selection", JOptionPane.ERROR_MESSAGE);
            }else
            JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the Date range ",
                "Missing Date Range Selection", JOptionPane.ERROR_MESSAGE);
        }catch(Exception ex){
            
          JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Error While Generating Report"+ex.getMessage(), "Report Generate Error", JOptionPane.ERROR_MESSAGE);
    
        }
    }//GEN-LAST:event_btnGenerateAttendanceReportActionPerformed

    private void chkEmploymentStatusStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkEmploymentStatusStateChanged
        if(chkEmploymentStatus.isSelected())
            cboEmploymentStatusAtt.setEnabled(true);
        else
             cboEmploymentStatusAtt.setEnabled(false);
    }//GEN-LAST:event_chkEmploymentStatusStateChanged

    private void chkCoursAttendedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkCoursAttendedStateChanged
        if(chkCoursAttended.isSelected())
            cboCourseAttended.setEnabled(true);
        else
             cboCourseAttended.setEnabled(false);
    }//GEN-LAST:event_chkCoursAttendedStateChanged

    private void chkAgeGreterthanStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkAgeGreterthanStateChanged
        if(chkAgeGreterthan.isSelected())
            jsAgeGreterThan.setEnabled(true);
        else
            jsAgeGreterThan.setEnabled(false);
    }//GEN-LAST:event_chkAgeGreterthanStateChanged

    private void chkAgeLessThanStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkAgeLessThanStateChanged
        if(chkAgeLessThan.isSelected())
            jsAgeLessThan.setEnabled(true);
        else
            jsAgeLessThan.setEnabled(false);
    }//GEN-LAST:event_chkAgeLessThanStateChanged

    private void optDisadvantageGroupStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_optDisadvantageGroupStateChanged
            if (optDisadvantageGroup.isSelected())
                cboDisadvantageGroup.setEnabled(true);
            else 
                cboDisadvantageGroup.setEnabled(false);
    }//GEN-LAST:event_optDisadvantageGroupStateChanged

    private void optReligionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_optReligionStateChanged
            if (optReligion.isSelected())
                cboRelegion.setEnabled(true);
            else 
                cboRelegion.setEnabled(false);
    }//GEN-LAST:event_optReligionStateChanged

    private void optSexualOrientationStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_optSexualOrientationStateChanged
            if (optSexualOrientation.isSelected())
                cboSexualOrientation.setEnabled(true);
            else 
                cboSexualOrientation.setEnabled(false);
    }//GEN-LAST:event_optSexualOrientationStateChanged

    private void btnGeneratDemographicReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratDemographicReportActionPerformed
         try{
            HashMap parametersMap = new HashMap();  
            
            if (!(dtEnrolmentDateFrom.getDate()==null || dtEnrolmentDateTo.getDate()==null)){
                if(chkAgeGreterthan.isSelected() && chkAgeLessThan.isSelected()){
                    if(optDisadvantageGroup.isSelected()){
                        
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                           
                            set_commentDemographic();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Equality",get_DisadvantageGroup());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                            parametersMap.put("age2",jsAgeLessThan.getValue());
                            parametersMap.put("userComment",get_commentDemographic());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageBetweenAndDisadvReport.jasper",parametersMap);

                    }else if(optReligion.isSelected()){
                            
                            if(!(cboRelegion.getSelectedIndex()==0)){
                                parametersMap.clear();

                                set_enrolmentDateDemographicFrom();
                                set_enrolmentDateDemographicTo();
                                set_relegion();
                                set_commentDemographic();

                                parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                                parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                                parametersMap.put("Relegion",get_relegion());
                                parametersMap.put("age1",jsAgeGreterThan.getValue());
                                parametersMap.put("age2",jsAgeLessThan.getValue());
                                parametersMap.put("userComment",get_commentDemographic());
                                parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                                generateReport("reports/ageBetweenAndRelegionReport.jasper",parametersMap);
                            }else 
                                JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the parameter",
                                 "Missing Parameter Selection", JOptionPane.ERROR_MESSAGE);
                    }else if(optSexualOrientation.isSelected()){
                        
                        if(!(cboSexualOrientation.getSelectedIndex()==0)){
                                parametersMap.clear();

                                set_enrolmentDateDemographicFrom();
                                set_enrolmentDateDemographicTo();
                                set_sexualOrientation();
                                set_commentDemographic();

                                parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                                parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                                parametersMap.put("SexualOrient",get_sexualOrientation());
                                parametersMap.put("age1",jsAgeGreterThan.getValue());
                                parametersMap.put("age2",jsAgeLessThan.getValue());
                                parametersMap.put("userComment",get_commentDemographic());
                                parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                                generateReport("reports/ageBetweenAndSexualReport.jasper",parametersMap);
                            }else 
                                JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the parameter",
                                 "Missing Parameter Selection", JOptionPane.ERROR_MESSAGE);
                        
                    }
                } else if (chkAgeGreterthan.isSelected() && chkAgeLessThan.isSelected()==false){
                    
                    if(optDisadvantageGroup.isSelected()){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                           
                            
                            set_commentDemographic();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Equality",get_DisadvantageGroup());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                           
                            parametersMap.put("userComment",get_commentDemographic());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageGreterAndDisadvReport.jasper",parametersMap);
                    }else if(optReligion.isSelected()){
                        
                           if(!(cboRelegion.getSelectedIndex()==0)){
                                parametersMap.clear();

                                set_enrolmentDateDemographicFrom();
                                set_enrolmentDateDemographicTo();
                                set_relegion();
                                set_commentDemographic();

                                parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                                parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                                parametersMap.put("Relegion",get_relegion());
                                parametersMap.put("age1",jsAgeGreterThan.getValue());
                               
                                parametersMap.put("userComment",get_commentDemographic());
                                parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                                generateReport("reports/ageGreterAndRelegionReport.jasper",parametersMap);
                            }else 
                                JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the parameter",
                                 "Missing Parameter Selection", JOptionPane.ERROR_MESSAGE);
                    }else if (optSexualOrientation.isSelected()){
                        
                            if(!(cboSexualOrientation.getSelectedIndex()==0)){
                                parametersMap.clear();

                                set_enrolmentDateDemographicFrom();
                                set_enrolmentDateDemographicTo();
                                set_sexualOrientation();
                                set_commentDemographic();

                                parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                                parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                                parametersMap.put("SexualOrient",get_sexualOrientation());
                                parametersMap.put("age1",jsAgeGreterThan.getValue());
                                
                                parametersMap.put("userComment",get_commentDemographic());
                                parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                                generateReport("reports/ageGreterAndSexualReport.jasper",parametersMap);
                            }else 
                                JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the parameter",
                                 "Missing Parameter Selection", JOptionPane.ERROR_MESSAGE);
                    }
                }else if (chkAgeGreterthan.isSelected()== false && chkAgeLessThan.isSelected()){
                    
                    if(optDisadvantageGroup.isSelected()){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();

                            set_commentDemographic();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Equality",get_DisadvantageGroup());
                            parametersMap.put("age1",jsAgeLessThan.getValue());

                            parametersMap.put("userComment",get_commentDemographic());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageLessAndDisadvReport.jasper",parametersMap);
                            
                        
                    }else if(optReligion.isSelected()){
                        
                           if(!(cboRelegion.getSelectedIndex()==0)){
                                parametersMap.clear();

                                set_enrolmentDateDemographicFrom();
                                set_enrolmentDateDemographicTo();
                                set_relegion();
                                set_commentDemographic();

                                parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                                parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                                parametersMap.put("Relegion",get_relegion());
                                parametersMap.put("age1",jsAgeLessThan.getValue());
                               
                                parametersMap.put("userComment",get_commentDemographic());
                                parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                                generateReport("reports/ageLessAndRelegionReport.jasper",parametersMap);
                            }else 
                                JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the parameter",
                                 "Missing Parameter Selection", JOptionPane.ERROR_MESSAGE);
                    }else if (optSexualOrientation.isSelected()){
                        
                            if(!(cboSexualOrientation.getSelectedIndex()==0)){
                                parametersMap.clear();

                                set_enrolmentDateDemographicFrom();
                                set_enrolmentDateDemographicTo();
                                set_sexualOrientation();
                                set_commentDemographic();

                                parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                                parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                                parametersMap.put("SexualOrient",get_sexualOrientation());
                                parametersMap.put("age1",jsAgeLessThan.getValue());
                                
                                parametersMap.put("userComment",get_commentDemographic());
                                parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                                generateReport("reports/ageLessAndSexualReport.jasper",parametersMap);
                            }else 
                                JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the parameter",
                                 "Missing Parameter Selection", JOptionPane.ERROR_MESSAGE);
                    }
                         
                }else 
                         JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select one of the option to Generate Report",
                                 "Missing Selection", JOptionPane.ERROR_MESSAGE);
            }else
            JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the Enrolment Date range ",
                "Missing Enrolment Date Range Selection", JOptionPane.ERROR_MESSAGE);
        }catch(Exception ex){
            
          JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Error While Generating Report"+ex.getMessage(), "Report Generate Error", JOptionPane.ERROR_MESSAGE);
    
        }
    }//GEN-LAST:event_btnGeneratDemographicReportActionPerformed

    private void cboDisadvantageGroupValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_cboDisadvantageGroupValueChanged
       
                   if(!evt.getValueIsAdjusting()) {
                     disadvantage_Group = cboDisadvantageGroup.getSelectedValuesList();
                   }
    }//GEN-LAST:event_cboDisadvantageGroupValueChanged

    private void optDisabilityStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optDisabilityStatusItemStateChanged
        if(optDisabilityStatus.isSelected())
            lstDisabilityStatus.setEnabled(true);
        else 
            lstDisabilityStatus.setEnabled(false);
    }//GEN-LAST:event_optDisabilityStatusItemStateChanged

    private void lstDisabilityStatusValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDisabilityStatusValueChanged
        if(!evt.getValueIsAdjusting()) {
                     disabilityStatus_Group = lstDisabilityStatus.getSelectedValuesList();
                   }
    }//GEN-LAST:event_lstDisabilityStatusValueChanged

    private void btnGeneratePersonalReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePersonalReportActionPerformed
      try{
          
            HashMap parametersMap = new HashMap();  
            if (!(dtEnrolmentDateFrom.getDate()==null || dtEnrolmentDateTo.getDate()==null)){
            if(!(optEthnicity.isSelected()|| optShowGeneder.isSelected())){
                if(chkAgeGreterthan.isSelected() && chkAgeLessThan.isSelected()){
                    if(optDisabilityStatus.isSelected()){
                        
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                           
                            set_CommentPersonalInfo();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Disability",get_DisabilityStatus());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                            parametersMap.put("age2",jsAgeLessThan.getValue());
                            parametersMap.put("userComment",get_CommentPersonalInfo());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageBetweenAndDisabilityReport.jasper",parametersMap);
                  }else 
                         JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select one of the option to Generate Report",
                                 "Missing Selection", JOptionPane.ERROR_MESSAGE);
                }else if (chkAgeGreterthan.isSelected() && chkAgeLessThan.isSelected()==false){
                    
                    if(optDisabilityStatus.isSelected()){
                        
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                           
                            set_CommentPersonalInfo();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Disability",get_DisabilityStatus());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                           
                            parametersMap.put("userComment",get_CommentPersonalInfo());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageGreterAndDisabilityReport.jasper",parametersMap);
                  }else 
                         JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select one of the option to Generate Report",
                                 "Missing Selection", JOptionPane.ERROR_MESSAGE);
                }else if (chkAgeGreterthan.isSelected()==false && chkAgeLessThan.isSelected()){
                    
                        if(optDisabilityStatus.isSelected()){
                        
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                           
                            set_CommentPersonalInfo();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Disability",get_DisabilityStatus());
                            
                            parametersMap.put("age1",jsAgeLessThan.getValue());
                            parametersMap.put("userComment",get_CommentPersonalInfo());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageLessAndDisabilityReport.jasper",parametersMap);
                  }else 
                         JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select one of the option to Generate Report",
                                 "Missing Selection", JOptionPane.ERROR_MESSAGE);
                }
            } else if (optEthnicity.isSelected()){
                    
                    if(!(dtEnrolmentDateFrom.getDate()==null || dtEnrolmentDateTo.getDate()==null)){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                           
                            set_CommentPersonalInfo();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                           
                            parametersMap.put("userComment",get_CommentPersonalInfo());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ethincityReport.jasper",parametersMap);
                    }else
                        JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Enrolment Date should be selected", "Report Generate Error", JOptionPane.ERROR_MESSAGE);          
            }else {
                    if(!(dtEnrolmentDateFrom.getDate()==null || dtEnrolmentDateTo.getDate()==null)){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                           
                            set_CommentPersonalInfo();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                           
                            parametersMap.put("userComment",get_CommentPersonalInfo());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/genderReport.jasper",parametersMap);
                    }else
                        JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Enrolment Date should be selected", "Report Generate Error", JOptionPane.ERROR_MESSAGE);  
            
            }
            }else
            JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the Enrolment Date range ",
                "Missing Enrolment Date Range Selection", JOptionPane.ERROR_MESSAGE);
        }catch(Exception ex){
            
          JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Error While Generating Report"+ex.getMessage(), "Report Generate Error", JOptionPane.ERROR_MESSAGE);          
        }
    }//GEN-LAST:event_btnGeneratePersonalReportActionPerformed

    private void optEthnicityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optEthnicityItemStateChanged
        if(optEthnicity.isSelected())
            flag=1;
        else 
            flag=0;
    }//GEN-LAST:event_optEthnicityItemStateChanged

    private void optLivesInItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optLivesInItemStateChanged
        if(optLivesIn.isSelected())
            cboLivsIn.setEnabled(true);
        else
             cboLivsIn.setEnabled(false);
              
    }//GEN-LAST:event_optLivesInItemStateChanged

    private void optEmployementStatusBackItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optEmployementStatusBackItemStateChanged
         if(optEmployementStatusBack.isSelected())
            cboEmployemeStatusBack.setEnabled(true);
         else
             cboEmployemeStatusBack.setEnabled(false);
    }//GEN-LAST:event_optEmployementStatusBackItemStateChanged

    private void optTotlaIncomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optTotlaIncomeItemStateChanged
         if(optTotlaIncome.isSelected())
            cboTotalIncome.setEnabled(true);
         else
             cboTotalIncome.setEnabled(false);
    }//GEN-LAST:event_optTotlaIncomeItemStateChanged

    private void optReciptBenefitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optReciptBenefitItemStateChanged
         if(optReciptBenefit.isSelected())
            cboBenefit.setEnabled(true);
         else
             cboBenefit.setEnabled(false);
    }//GEN-LAST:event_optReciptBenefitItemStateChanged

    private void btnGeneratePersonalBackReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePersonalBackReportActionPerformed
        
        try{
            HashMap parametersMap = new HashMap();  
             if (!(dtEnrolmentDateFrom.getDate()==null || dtEnrolmentDateTo.getDate()==null)){
                if(chkAgeGreterthan.isSelected() && chkAgeLessThan.isSelected()){
                 
                    if(optLivesIn.isSelected()){
                        
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_livsin();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Livein",get_livesin());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                            parametersMap.put("age2",jsAgeLessThan.getValue());
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageBetweenAndLiveInReport.jasper",parametersMap);

                    }else if(optEmployementStatusBack.isSelected()){
                        
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_employmentStatusBack();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("EmpStatus",get_employementStatusBack());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                            parametersMap.put("age2",jsAgeLessThan.getValue());
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageBetweenAndEmpStatReport.jasper",parametersMap);

                   }else if (optTotlaIncome.isSelected()){
                       
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_TotalIncome();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("HouseHoldIncome",get_TotalIncome());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                            parametersMap.put("age2",jsAgeLessThan.getValue());
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageBetweenAndIncomeReport.jasper",parametersMap);
                   }else if (optReciptBenefit.isSelected()){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_ReciptBenefit();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Benefit",get_ReciptBenefit());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                            parametersMap.put("age2",jsAgeLessThan.getValue());
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageBetweenAndBenefitReport.jasper",parametersMap);
                   }
               
              
              }else if(chkAgeGreterthan.isSelected() && chkAgeLessThan.isSelected()==false){
                  
                  if(!(dtEnrolmentDateFrom.getDate()==null || dtEnrolmentDateTo.getDate()==null)){
                      if(optLivesIn.isSelected()){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_livsin();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Livein",get_livesin());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                            
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageGreterAndLiveInReport.jasper",parametersMap);
                      }else if (optEmployementStatusBack.isSelected()){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_employmentStatusBack();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("EmpStatus",get_employementStatusBack());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                            
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageGreterAndEmpStatReport.jasper",parametersMap);

                      }else if (optTotlaIncome.isSelected()){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_TotalIncome();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("HouseHoldIncome",get_TotalIncome());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                            
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent()); 
                            generateReport("reports/ageGreterAndIncomeReport.jasper",parametersMap);
                      }else if(optReciptBenefit.isSelected()){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_ReciptBenefit();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Benefit",get_ReciptBenefit());
                            parametersMap.put("age1",jsAgeGreterThan.getValue());
                           
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageGreterAndBenefitReport.jasper",parametersMap);
                      }
                      
                  }else JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Enrolment Date should be selected", "Report Generate Error", JOptionPane.ERROR_MESSAGE);          
              
              }else if (chkAgeGreterthan.isSelected()==false && chkAgeLessThan.isSelected()){
                  if(!(dtEnrolmentDateFrom.getDate()==null || dtEnrolmentDateTo.getDate()==null)){
                      if(optLivesIn.isSelected()){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_livsin();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Livein",get_livesin());
                            parametersMap.put("age1",jsAgeLessThan.getValue());
                            
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageLessAndLiveInReport.jasper",parametersMap);
                      }else if (optEmployementStatusBack.isSelected()){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_employmentStatusBack();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("EmpStatus",get_employementStatusBack());
                            parametersMap.put("age1",jsAgeLessThan.getValue());
                            
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageLessAndEmpStatReport.jasper",parametersMap);
                      }else if (optTotlaIncome.isSelected()){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_TotalIncome();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("HouseHoldIncome",get_TotalIncome());
                            parametersMap.put("age1",jsAgeLessThan.getValue());
                            
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent()); 
                            generateReport("reports/ageLessAndIncomeReport.jasper",parametersMap);
                            
                      }else if (optReciptBenefit.isSelected()){
                            parametersMap.clear();

                            set_enrolmentDateDemographicFrom();
                            set_enrolmentDateDemographicTo();
                            set_ReciptBenefit();
                            set_commentPersonalBackground();

                            parametersMap.put("enrolmentDate1",get_enrolmentDateDemographicFrom());
                            parametersMap.put("enrolmentDate2",get_enrolmentDateDemographicTo());
                            parametersMap.put("Benefit",get_ReciptBenefit());
                            parametersMap.put("age1",jsAgeLessThan.getValue());
                           
                            parametersMap.put("userComment",get_commentPersonalBackground());
                            parametersMap.put("totalStudentDB",busObj.get_TotlaStudent());

                            generateReport("reports/ageLessAndBenefitReport.jasper",parametersMap);
                      }
                  }else JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Enrolment Date should be selected", "Report Generate Error", JOptionPane.ERROR_MESSAGE);          
              
              }else JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Age Range shuld be selected", "Report Generate Error", JOptionPane.ERROR_MESSAGE);          
        }else
            JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Please select the Enrolment Date range ",
                "Missing Enrolment Date Range Selection", JOptionPane.ERROR_MESSAGE);
        }catch(Exception ex){
            
          JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Error While Generating Report"+ex.getMessage(), "Report Generate Error", JOptionPane.ERROR_MESSAGE);
    
        }
        
    }//GEN-LAST:event_btnGeneratePersonalBackReportActionPerformed

    private void btnGenerateReportMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportMonthActionPerformed
        try{
            HashMap parametersMap = new HashMap();  
            if(!(dtEnrolmentDateFrom1Month.getDate()==null || dtEnrolmentDateTo1Month.getDate()==null)){
                 parametersMap.clear();
                 set_enrolmentDateMothlyReportFrom();
                 set_enrolmentDateMothlyReportTo();
                 set_CommentMonthlyReport();
                 
                 parametersMap.put("enrolmentDate1", get_enrolmentDateMothlyReportFrom());
                 parametersMap.put("enrolmentDate2", get_enrolmentDateMothlyReportTo());
                 parametersMap.put("userComment", get_CommentMonthlyReport());
                 
                 generateReport("reports/monthlyMangReport.jasper",parametersMap);
            
            }else JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Enrolment Date should be selected", "Report Generate Error", JOptionPane.ERROR_MESSAGE);          

        }catch(Exception ex){
              JOptionPane.showMessageDialog(IntFrameReportParameter.this, "Error While Generating Report"+ex.getMessage(), "Report Generate Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGenerateReportMonthActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        utilObj.flag7=false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void optShowGenederItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optShowGenederItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_optShowGenederItemStateChanged
   
    public void selectCombo(JComboBox comboBox){
       
        comboBox.setModel(new DefaultComboBoxModel<String>() {

          boolean selectionAllowed = true;

          @Override
          public void setSelectedItem(Object anObject) {

            if (!NOT_SELECTABLE_OPTION.equals(anObject)) {
              super.setSelectedItem(anObject);
            } else if (selectionAllowed) {
              // Allow this just once
              selectionAllowed = false;
              super.setSelectedItem(anObject);
            }
          }
        });

    comboBox.addItem(NOT_SELECTABLE_OPTION);
    
   }   
    
    public void generateReport(String fileName,HashMap parameter){
        try
            {
                InputStream in = getClass().getClassLoader()
                               .getResourceAsStream(fileName);
                 //String in = this.getClass().getResource(fileName).toString();
            MyiReportViewer myiReportViewer = new MyiReportViewer(in,parameter);
            myiReportViewer.setBounds(0, 0, dsctopPane.getWidth(),
            dsctopPane.getHeight());
            myiReportViewer.setVisible(true);
            dsctopPane.add(myiReportViewer);
            myiReportViewer.setSelected(true);
            
            }
            catch (PropertyVetoException pve)
            {
            //pve.printStackTrace();
                JOptionPane.showMessageDialog(dsctopPane, "Null Document");
            }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeneratDemographicReport;
    private javax.swing.JButton btnGenerateAttendanceReport;
    private javax.swing.JButton btnGeneratePersonalBackReport;
    private javax.swing.JButton btnGeneratePersonalReport;
    private javax.swing.JButton btnGenerateReportMonth;
    private javax.swing.ButtonGroup buttonGroupDemographic;
    private javax.swing.ButtonGroup buttonGroupPersonalBackg;
    private javax.swing.ButtonGroup buttonGroupPersonalInfo;
    private javax.swing.JComboBox cboBenefit;
    private javax.swing.JComboBox cboCourseAttended;
    private javax.swing.JList cboDisadvantageGroup;
    private javax.swing.JComboBox cboEmployemeStatusBack;
    private javax.swing.JComboBox cboEmploymentStatusAtt;
    private javax.swing.JComboBox cboLivsIn;
    private javax.swing.JComboBox cboRelegion;
    private javax.swing.JComboBox cboSexualOrientation;
    private javax.swing.JComboBox cboTotalIncome;
    private javax.swing.JCheckBox chkAgeGreterthan;
    private javax.swing.JCheckBox chkAgeLessThan;
    private javax.swing.JCheckBox chkCoursAttended;
    private javax.swing.JCheckBox chkEmploymentStatus;
    private javax.swing.JDesktopPane dsctopPane;
    private com.toedter.calendar.JDateChooser dtAttendaceFrom;
    private com.toedter.calendar.JDateChooser dtAttendanceTo;
    private com.toedter.calendar.JDateChooser dtEnrolmentDateFrom;
    private com.toedter.calendar.JDateChooser dtEnrolmentDateFrom1Month;
    private com.toedter.calendar.JDateChooser dtEnrolmentDateTo;
    private com.toedter.calendar.JDateChooser dtEnrolmentDateTo1Month;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JSpinner jsAgeGreterThan;
    private javax.swing.JSpinner jsAgeLessThan;
    private javax.swing.JList lstDisabilityStatus;
    private javax.swing.JRadioButton optDisabilityStatus;
    private javax.swing.JRadioButton optDisadvantageGroup;
    private javax.swing.JRadioButton optEmployementStatusBack;
    private javax.swing.JRadioButton optEthnicity;
    private javax.swing.JRadioButton optLivesIn;
    private javax.swing.JRadioButton optReciptBenefit;
    private javax.swing.JRadioButton optReligion;
    private javax.swing.JRadioButton optSexualOrientation;
    private javax.swing.JRadioButton optShowGeneder;
    private javax.swing.JRadioButton optTotlaIncome;
    private javax.swing.JTextArea txtComment;
    private javax.swing.JTextArea txtCommentDemographic;
    private javax.swing.JTextArea txtCommentMonthlyReport;
    private javax.swing.JTextArea txtCommentPersonalBack;
    private javax.swing.JTextArea txtCommentPersonalInfo;
    // End of variables declaration//GEN-END:variables
}
