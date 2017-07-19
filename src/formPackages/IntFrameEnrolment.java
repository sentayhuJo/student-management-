/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages;


import formPackages.classPackages.businessLayer;
import static formPackages.classPackages.businessLayer.IDHolder_TotalIncome;
import formPackages.classPackages.utility;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;


import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author jo
 */
public class IntFrameEnrolment extends javax.swing.JInternalFrame {

   /**
    * Procedure variable declaration in order to load up the Combo box and list box
    */       
        private String proc_Benefit="SELECT_DATA_PACKAGE.get_Benefit(?)"; 
        private String proc_ProjectTargates="SELECT_DATA_PACKAGE.get_Blf_ProjectTarget(?)"; 
        private String proc_DisabilityNature="SELECT_DATA_PACKAGE.get_DisabilityNature(?)"; 
        private String proc_DisabilityStatus="SELECT_DATA_PACKAGE.get_DisabilityStatus(?)"; 
        private String proc_EmployementStatus="SELECT_DATA_PACKAGE.get_EmployementStatus(?)"; 
        private String proc_EqualityInfo="SELECT_DATA_PACKAGE.get_EqualityInformation(?)"; 
        private String proc_Ethnicity="SELECT_DATA_PACKAGE.get_Ethnicity(?)"; 
        
        private String proc_EthniBackground="SELECT_DATA_PACKAGE.get_EthinicityBackground(?,?)"; 
        private String proc_HouseHoldIncome="SELECT_DATA_PACKAGE.get_HouseHoldIncome(?)"; 
        private String proc_KnowAboutUs="SELECT_DATA_PACKAGE.get_KnowsAboutUs(?)"; 
        private String proc_LivingIn="SELECT_DATA_PACKAGE.get_LivingIn(?)"; 
        private String proc_Qualification="SELECT_DATA_PACKAGE.get_Qualification(?)"; 
        private String proc_Relegion="SELECT_DATA_PACKAGE.get_Relegion(?)"; 
        private String proc_SexOrientation="SELECT_DATA_PACKAGE.get_SexualOreintation(?)"; 
    
    /**
     * Class instantiation and Variable declaration  
     */
        private int age;
        private String BLF_Type ;//BLF_NONAcc;
        //private String BLF_Vol;
        private String with_Carer;
        
        private String student_Ref;
        private String national_Ins;
        private Date registration_Date;
         private Date date_Entry;
        private String sur_Name;
        private String given_Name;
        private String gender ;
        private Date date_of_Birth;
        
        private String address1;
        private String address2;
        private String city;
        private String postal_code;
        private String email;
        private String tel_No;
        private String twitter;
        
        private String vol_Profession;
        private Date vol_StartDate;
        private Date vol_EndDate;
        
        private int emp_Status_ID ;
        private int total_HIncome_ID;
        private int live_In_ID;
        private int qualification_ID;
        private int receipt_of_Benefit_ID;
        private String eligibility_Comment;
        
        private int ethnicity_ID;
        private int ethnicity_Background_ID;
        private List<String> disability_Status;
        private List<String> disability_Nature=null;
        private List<String> prefer_Contact;
        private String other_Needs;
        
        private List<String> disadvantage_Group=null;
        private int sexual_Orientaion_ID;
        private int relegion_ID;
        private List<String> hear_AboutUs=null;
        private String refered_By;
        private static final String NOT_SELECTABLE_OPTION="Select...";
        
        utility utiObj =new utility();
        businessLayer busObj=new businessLayer();
      
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
       
        Date date = new Date();
       
        
    public IntFrameEnrolment() {
        initComponents();
    
        
        dtDateOfBirth.setDate(date);
        DtRegestration.setDate(date);
        dtVolStartDate.setDate(date);
        dtVolFinishedDate.setDate(utiObj.addWeeks());
         
         selectCombo(cboEmploymentStatus);
         selectCombo(cboTotalIncome);
         selectCombo(cboLiveIn);
         selectCombo(cboQualification);
         selectCombo(cboBenefit);
         selectCombo(cboEthnicity);
         selectCombo(cboSexOrientaion);
         selectCombo(cboRelegion); 
        
        busObj.pop_Combo(cboEmploymentStatus,proc_EmployementStatus,"cboEmploymentStatus");
        busObj.pop_Combo(cboQualification,proc_Qualification,"cboQualification");
        busObj.pop_Combo(cboBenefit,proc_Benefit,"cboBenefit");
        busObj.pop_Combo(cboTotalIncome,proc_HouseHoldIncome,"cboTotalIncome");
        busObj.pop_Combo(cboLiveIn,proc_LivingIn,"cboLiveIn");
        busObj.pop_Combo(cboSexOrientaion,proc_SexOrientation,"cboSexOrientaion");
        busObj.pop_Combo(cboRelegion,proc_Relegion,"cboRelegion");
        busObj.pop_Combo(cboEthnicity,proc_Ethnicity,"cboEthnicity");
      
        
        busObj.pop_List(lstDisability,proc_DisabilityStatus,0);
        busObj.pop_List(lstNatureDisability,proc_DisabilityNature,0);
        busObj.pop_List(lstKnowAboutUs,proc_KnowAboutUs,0);
        busObj.pop_List(lstDisadvantageGroup,proc_EqualityInfo,0);
        
        txtStudentReferenceNo.setText(utiObj.generateBeneficiaryID(5, "BLF", busObj.set_SeqNextVal(1)));
        
        try{
        MaskFormatter ssnFormatter = new MaskFormatter("(####) ###-####");
        ssnFormatter.setValueClass(String.class);
        ssnFormatter.setPlaceholderCharacter('_');  
        DefaultFormatterFactory ssnFormatterFactory = new
        DefaultFormatterFactory(ssnFormatter);
        txtTelNo.setFormatterFactory(ssnFormatterFactory);}
        catch(Exception ex){ 
               System.out.println(ex);
        }
        
        try{
        MaskFormatter ssnFormatter = new MaskFormatter("UU######U");
        ssnFormatter.setValueClass(String.class);
        ssnFormatter.setPlaceholderCharacter('_');  
        DefaultFormatterFactory ssnFormatterFactory = new
        DefaultFormatterFactory(ssnFormatter);
        txtNationalInssuranceNo.setFormatterFactory(ssnFormatterFactory);
        }catch(Exception ex){ 
               System.out.println(ex);
        }
    
         JcomboSelection(cboEthnicity);
         
         
         
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTypeOfBeneficiary = new javax.swing.JPanel();
        chkBLFvol = new javax.swing.JCheckBox();
        chkBlfNonAcc = new javax.swing.JCheckBox();
        lblVolStartDate = new javax.swing.JLabel();
        lblVolEndDate = new javax.swing.JLabel();
        lblVolQualification = new javax.swing.JLabel();
        chkWithCarer = new javax.swing.JCheckBox();
        lblVolunteerInfo = new javax.swing.JLabel();
        dtVolStartDate = new com.toedter.calendar.JDateChooser();
        dtVolFinishedDate = new com.toedter.calendar.JDateChooser();
        txtVolProfession = new javax.swing.JTextField();
        lblBenPicture = new javax.swing.JLabel();
        btnPicBrowse = new javax.swing.JButton();
        jPanelEnrolmentIfo = new javax.swing.JPanel();
        lblStudentReferenceNo = new javax.swing.JLabel();
        txtStudentReferenceNo = new javax.swing.JTextField();
        lblNI = new javax.swing.JLabel();
        lblDateReg = new javax.swing.JLabel();
        DtRegestration = new com.toedter.calendar.JDateChooser();
        txtNationalInssuranceNo = new javax.swing.JFormattedTextField();
        dtDateEntry = new com.toedter.calendar.JDateChooser();
        lblDateReg1 = new javax.swing.JLabel();
        jPanelAddress = new javax.swing.JPanel();
        lblAddress1 = new javax.swing.JLabel();
        lblAddress2 = new javax.swing.JLabel();
        lblAddress3 = new javax.swing.JLabel();
        lblAddress4 = new javax.swing.JLabel();
        lblAddress6 = new javax.swing.JLabel();
        lblAddress5 = new javax.swing.JLabel();
        txtAddress1 = new javax.swing.JTextField();
        txtAddress2 = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPostalCode = new javax.swing.JTextField();
        lblAddress7 = new javax.swing.JLabel();
        txtTwitter = new javax.swing.JTextField();
        txtTelNo = new javax.swing.JFormattedTextField();
        jPanelBasicInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSurName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGivenName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboGender = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        dtDateOfBirth = new com.toedter.calendar.JDateChooser();
        tabBackground = new javax.swing.JTabbedPane();
        jPanelBackground = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cboEmploymentStatus = new javax.swing.JComboBox();
        cboLiveIn = new javax.swing.JComboBox();
        cboQualification = new javax.swing.JComboBox();
        cboBenefit = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEligibilityComment = new javax.swing.JTextArea();
        cboTotalIncome = new javax.swing.JComboBox();
        jPanelPersonalInfo = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cboEthnicity = new javax.swing.JComboBox();
        cboEthnicityBack = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstDisability = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstNatureDisability = new javax.swing.JList();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtOtherNeeds = new javax.swing.JTextArea();
        jPanelEqualityOther = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstDisadvantageGroup = new javax.swing.JList();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        lstKnowAboutUs = new javax.swing.JList();
        lblRefferedBy = new javax.swing.JLabel();
        cboSexOrientaion = new javax.swing.JComboBox();
        cboRelegion = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtRefferedBy = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        lstPreferContact = new javax.swing.JList();
        jLabel24 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setIconifiable(true);
        setTitle("Register Beneficiary");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/register-icon.png"))); // NOI18N
        setName("frmEnrolment"); // NOI18N
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

        jPanelTypeOfBeneficiary.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chkBLFvol.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        chkBLFvol.setText("BLF Vol");
        chkBLFvol.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBLFvolItemStateChanged(evt);
            }
        });
        chkBLFvol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBLFvolActionPerformed(evt);
            }
        });

        chkBlfNonAcc.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        chkBlfNonAcc.setSelected(true);
        chkBlfNonAcc.setText("BLF NON Acc");
        chkBlfNonAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBlfNonAccActionPerformed(evt);
            }
        });

        lblVolStartDate.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblVolStartDate.setText("Vol Start Date");
        lblVolStartDate.setEnabled(false);

        lblVolEndDate.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblVolEndDate.setText("Vol End Date");
        lblVolEndDate.setEnabled(false);

        lblVolQualification.setText("Vol. Qualification");
        lblVolQualification.setEnabled(false);

        chkWithCarer.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        chkWithCarer.setText("With Carer");

        lblVolunteerInfo.setText("Volunteer Information");
        lblVolunteerInfo.setEnabled(false);

        dtVolStartDate.setDateFormatString("dd/MM/yyyy");
        dtVolStartDate.setEnabled(false);

        dtVolFinishedDate.setDateFormatString("dd/MM/yyyy");
        dtVolFinishedDate.setEnabled(false);

        txtVolProfession.setEnabled(false);

        javax.swing.GroupLayout jPanelTypeOfBeneficiaryLayout = new javax.swing.GroupLayout(jPanelTypeOfBeneficiary);
        jPanelTypeOfBeneficiary.setLayout(jPanelTypeOfBeneficiaryLayout);
        jPanelTypeOfBeneficiaryLayout.setHorizontalGroup(
            jPanelTypeOfBeneficiaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTypeOfBeneficiaryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTypeOfBeneficiaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTypeOfBeneficiaryLayout.createSequentialGroup()
                        .addComponent(chkBlfNonAcc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkWithCarer))
                    .addGroup(jPanelTypeOfBeneficiaryLayout.createSequentialGroup()
                        .addGroup(jPanelTypeOfBeneficiaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBLFvol)
                            .addGroup(jPanelTypeOfBeneficiaryLayout.createSequentialGroup()
                                .addGroup(jPanelTypeOfBeneficiaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVolEndDate, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblVolStartDate, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblVolQualification, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelTypeOfBeneficiaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dtVolStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(dtVolFinishedDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtVolProfession)))
                            .addGroup(jPanelTypeOfBeneficiaryLayout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(lblVolunteerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelTypeOfBeneficiaryLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dtVolFinishedDate, dtVolStartDate, txtVolProfession});

        jPanelTypeOfBeneficiaryLayout.setVerticalGroup(
            jPanelTypeOfBeneficiaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTypeOfBeneficiaryLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTypeOfBeneficiaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkBlfNonAcc)
                    .addComponent(chkWithCarer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBLFvol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVolunteerInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTypeOfBeneficiaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVolQualification)
                    .addComponent(txtVolProfession, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTypeOfBeneficiaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVolStartDate)
                    .addComponent(dtVolStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTypeOfBeneficiaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtVolFinishedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVolEndDate))
                .addContainerGap())
        );

        jPanelTypeOfBeneficiaryLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dtVolFinishedDate, dtVolStartDate});

        lblBenPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stock_people.png"))); // NOI18N
        lblBenPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblBenPicture.setName("lblBenPicture"); // NOI18N

        btnPicBrowse.setText("Browse ");
        btnPicBrowse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPicBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPicBrowseActionPerformed(evt);
            }
        });

        jPanelEnrolmentIfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblStudentReferenceNo.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblStudentReferenceNo.setText("Student Ref. No.");

        txtStudentReferenceNo.setEditable(false);
        txtStudentReferenceNo.setEnabled(false);
        txtStudentReferenceNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentReferenceNoActionPerformed(evt);
            }
        });

        lblNI.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblNI.setText("National Ins. No.");

        lblDateReg.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblDateReg.setText("Registration Date");

        DtRegestration.setDateFormatString("dd/MM/yyyy");

        txtNationalInssuranceNo.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        dtDateEntry.setDateFormatString("dd/MM/yyyy");

        lblDateReg1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblDateReg1.setText("Date Of Entry(UK)");

        javax.swing.GroupLayout jPanelEnrolmentIfoLayout = new javax.swing.GroupLayout(jPanelEnrolmentIfo);
        jPanelEnrolmentIfo.setLayout(jPanelEnrolmentIfoLayout);
        jPanelEnrolmentIfoLayout.setHorizontalGroup(
            jPanelEnrolmentIfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnrolmentIfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelEnrolmentIfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStudentReferenceNo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNI, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDateReg1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDateReg, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEnrolmentIfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEnrolmentIfoLayout.createSequentialGroup()
                        .addGroup(jPanelEnrolmentIfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNationalInssuranceNo, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtStudentReferenceNo))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(DtRegestration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtDateEntry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelEnrolmentIfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DtRegestration, dtDateEntry});

        jPanelEnrolmentIfoLayout.setVerticalGroup(
            jPanelEnrolmentIfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnrolmentIfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnrolmentIfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStudentReferenceNo)
                    .addComponent(txtStudentReferenceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEnrolmentIfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNationalInssuranceNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEnrolmentIfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDateReg1)
                    .addComponent(dtDateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEnrolmentIfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDateReg)
                    .addComponent(DtRegestration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelEnrolmentIfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DtRegestration, dtDateEntry, txtNationalInssuranceNo, txtStudentReferenceNo});

        jPanelAddress.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelAddress.setFont(new java.awt.Font("Liberation Sans Narrow", 0, 10)); // NOI18N

        lblAddress1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblAddress1.setText("Address 1");

        lblAddress2.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblAddress2.setText("Address 2");

        lblAddress3.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblAddress3.setText("City");

        lblAddress4.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblAddress4.setText("Postal Code");

        lblAddress6.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblAddress6.setText("Tel.No.");

        lblAddress5.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblAddress5.setText("Email");

        txtCity.setEditable(false);
        txtCity.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtCity.setText("Liverpool");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        lblAddress7.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblAddress7.setText("Twitter");

        txtTelNo.setColumns(14);
        txtTelNo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("(#####)-######"))));
        txtTelNo.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        javax.swing.GroupLayout jPanelAddressLayout = new javax.swing.GroupLayout(jPanelAddress);
        jPanelAddress.setLayout(jPanelAddressLayout);
        jPanelAddressLayout.setHorizontalGroup(
            jPanelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddressLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAddress6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAddress5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAddress4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAddress3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAddress2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAddress1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmail)
                    .addComponent(txtPostalCode)
                    .addComponent(txtCity, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(txtAddress2)
                    .addComponent(txtTwitter)
                    .addComponent(txtAddress1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(txtTelNo))
                .addContainerGap())
        );

        jPanelAddressLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAddress1, txtAddress2, txtCity, txtEmail, txtPostalCode, txtTelNo, txtTwitter});

        jPanelAddressLayout.setVerticalGroup(
            jPanelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress1)
                    .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress2)
                    .addComponent(txtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress3)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress4)
                    .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress6)
                    .addComponent(txtTelNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAddressLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtAddress1, txtAddress2, txtCity, txtEmail, txtPostalCode, txtTelNo, txtTwitter});

        jPanelBasicInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel1.setText("Surname");

        txtSurName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSurNameKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSurNameKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel2.setText("Given Name");

        txtGivenName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGivenNameKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel3.setText("Gender");

        cboGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        cboGender.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel4.setText("Date of Birth");

        lblAge.setText("Age");

        dtDateOfBirth.setDateFormatString("dd/MM/yyyy");
        dtDateOfBirth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtDateOfBirthPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanelBasicInfoLayout = new javax.swing.GroupLayout(jPanelBasicInfo);
        jPanelBasicInfo.setLayout(jPanelBasicInfoLayout);
        jPanelBasicInfoLayout.setHorizontalGroup(
            jPanelBasicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBasicInfoLayout.createSequentialGroup()
                .addGroup(jPanelBasicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBasicInfoLayout.createSequentialGroup()
                        .addGroup(jPanelBasicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBasicInfoLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanelBasicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12)
                        .addGroup(jPanelBasicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSurName)
                            .addComponent(txtGivenName)
                            .addComponent(lblAge, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );

        jPanelBasicInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dtDateOfBirth, txtGivenName});

        jPanelBasicInfoLayout.setVerticalGroup(
            jPanelBasicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBasicInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBasicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSurName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBasicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGivenName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelBasicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboGender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBasicInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(lblAge, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jPanelBasicInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dtDateOfBirth, txtGivenName, txtSurName});

        tabBackground.setBackground(new java.awt.Color(51, 51, 51));
        tabBackground.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabBackground.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel8.setText("Employment Status");

        jLabel9.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 51));
        jLabel9.setText("OCR Funding - Eligibility Questioner");

        jLabel10.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel10.setText("Total Household Income ");

        jLabel11.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel11.setText("You live In");

        jLabel12.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel12.setText("Receipt of Benefit");

        jLabel13.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel13.setText("Qualification");

        jLabel14.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel14.setText("Comment Regarding Eligibility");

        cboEmploymentStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboEmploymentStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cboLiveIn.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboLiveIn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cboQualification.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboQualification.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cboBenefit.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboBenefit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtEligibilityComment.setColumns(20);
        txtEligibilityComment.setRows(5);
        jScrollPane3.setViewportView(txtEligibilityComment);

        cboTotalIncome.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboTotalIncome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelBackgroundLayout = new javax.swing.GroupLayout(jPanelBackground);
        jPanelBackground.setLayout(jPanelBackgroundLayout);
        jPanelBackgroundLayout.setHorizontalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboEmploymentStatus, 0, 154, Short.MAX_VALUE)
                            .addComponent(cboLiveIn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTotalIncome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel9))
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboBenefit, 0, 170, Short.MAX_VALUE)
                            .addComponent(cboQualification, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(133, 133, 133))
        );

        jPanelBackgroundLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboEmploymentStatus, cboTotalIncome});

        jPanelBackgroundLayout.setVerticalGroup(
            jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                        .addComponent(cboQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboBenefit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelBackgroundLayout.createSequentialGroup()
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboEmploymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBackgroundLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboLiveIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addGroup(jPanelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(cboTotalIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, Short.MAX_VALUE))
        );

        jPanelBackgroundLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboEmploymentStatus, cboTotalIncome});

        tabBackground.addTab("Background", jPanelBackground);

        jLabel15.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel15.setText("Ethnicity");

        jLabel16.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel16.setText("Ethnic Background");

        jLabel17.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel17.setText("Disability");

        jLabel18.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel18.setText("Nature Of Disability");

        cboEthnicity.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboEthnicity.setMaximumRowCount(20);
        cboEthnicity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cboEthnicityBack.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboEthnicityBack.setMaximumRowCount(20);
        cboEthnicityBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lstDisability.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstDisability.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstDisability.setToolTipText("");
        lstDisability.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDisabilityValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstDisability);

        lstNatureDisability.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstNatureDisability.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstNatureDisability.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstNatureDisabilityValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstNatureDisability);

        jLabel19.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel19.setText("Other Needs");

        txtOtherNeeds.setColumns(20);
        txtOtherNeeds.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtOtherNeeds.setRows(5);
        jScrollPane5.setViewportView(txtOtherNeeds);

        javax.swing.GroupLayout jPanelPersonalInfoLayout = new javax.swing.GroupLayout(jPanelPersonalInfo);
        jPanelPersonalInfo.setLayout(jPanelPersonalInfoLayout);
        jPanelPersonalInfoLayout.setHorizontalGroup(
            jPanelPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPersonalInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboEthnicity, 0, 233, Short.MAX_VALUE)
                    .addComponent(cboEthnicityBack, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonalInfoLayout.createSequentialGroup()
                        .addGroup(jPanelPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jPanelPersonalInfoLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(45, 45, 45)))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelPersonalInfoLayout.setVerticalGroup(
            jPanelPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonalInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonalInfoLayout.createSequentialGroup()
                        .addGroup(jPanelPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18)
                            .addComponent(cboEthnicity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboEthnicityBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonalInfoLayout.createSequentialGroup()
                        .addGroup(jPanelPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabBackground.addTab("Personal Information", jPanelPersonalInfo);

        jLabel20.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel20.setText("Sexual Orientation");

        jLabel21.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel21.setText("Religion");

        jLabel22.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel22.setText("Disadvantaged Groups");

        lstDisadvantageGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstDisadvantageGroup.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstDisadvantageGroup.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDisadvantageGroupValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstDisadvantageGroup);

        jLabel23.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel23.setText("How did you hear about us");

        lstKnowAboutUs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstKnowAboutUs.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstKnowAboutUs.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstKnowAboutUsValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(lstKnowAboutUs);

        lblRefferedBy.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblRefferedBy.setText("Reffered By");

        cboSexOrientaion.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboSexOrientaion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cboRelegion.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboRelegion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtRefferedBy.setColumns(20);
        txtRefferedBy.setRows(5);
        jScrollPane6.setViewportView(txtRefferedBy);

        lstPreferContact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstPreferContact.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstPreferContact.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Email", "Phone Call" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstPreferContact.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPreferContactValueChanged(evt);
            }
        });
        jScrollPane9.setViewportView(lstPreferContact);

        jLabel24.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel24.setText("Prefered way of contact ");

        javax.swing.GroupLayout jPanelEqualityOtherLayout = new javax.swing.GroupLayout(jPanelEqualityOther);
        jPanelEqualityOther.setLayout(jPanelEqualityOtherLayout);
        jPanelEqualityOtherLayout.setHorizontalGroup(
            jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                        .addGroup(jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addGap(4, 4, 4)
                        .addGroup(jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboSexOrientaion, 0, 159, Short.MAX_VALUE)
                            .addComponent(cboRelegion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                        .addComponent(lblRefferedBy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelEqualityOtherLayout.setVerticalGroup(
            jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                        .addComponent(cboSexOrientaion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                                .addComponent(cboRelegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                                        .addComponent(lblRefferedBy)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                        .addGroup(jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEqualityOtherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanelEqualityOtherLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabBackground.addTab("Equality and Others", jPanelEqualityOther);

        btnSave.setText("Save All");
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBenPicture)
                            .addComponent(btnPicBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelTypeOfBeneficiary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelBasicInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelEnrolmentIfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelTypeOfBeneficiary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelBasicInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBenPicture)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPicBrowse))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelEnrolmentIfo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(tabBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void set_StudentRef(){ student_Ref=txtStudentReferenceNo.getText(); }
    private String get_StudentRef(){ return student_Ref;}
    
    private void set_NationalInsu(){ national_Ins=txtNationalInssuranceNo.getText(); }
    private String get_NationalInsu(){ return national_Ins;}
    
    private void set_RegistrationDate(){ 
        try{
            String  feachDate=dateFormat.format(DtRegestration.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            registration_Date= feachdate;
        }catch(Exception ex){
            utiObj.setToolTip(DtRegestration, "Registration Date error ! Error :" + ex);
        }   
    }
    private Date get_RegistrationDate(){return registration_Date;}
    
    private void set_DateEntry(){ 
        try{
            String  feachDate=dateFormat.format(dtDateEntry.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            date_Entry= feachdate;
        }catch(Exception ex){
            utiObj.setToolTip(dtDateEntry, "Registration Date error ! Error :" + ex);
        }   
    }
    private Date get_DateEntry(){return date_Entry;}
    
    private void set_SurName(){ sur_Name=txtSurName.getText(); }
    private String get_SurName(){ return sur_Name;}

    private void set_GivenName(){ given_Name=txtGivenName.getText(); }
    private String get_GivenName(){ return given_Name;}

    private void set_Gender(){ gender=cboGender.getSelectedItem().toString(); }
    private String get_Gender(){ return gender;}

    private void set_DOB(){ 
        try{
            String  feachDate=dateFormat.format(dtDateOfBirth.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            date_of_Birth= feachdate;
            
        }catch(Exception ex){
            utiObj.setToolTip(dtDateOfBirth, "Date of Birth Date error ! Error :" + ex);
        } 
    }
    private Date get_DOB(){ return date_of_Birth;}
    
/**
 *  Set and get Address Information 
 */
    
    private void set_Address1(){ address1=txtAddress1.getText(); }
    private String get_Address1(){ return address1;}
    
    private void set_Address2(){ address2=txtAddress2.getText(); }
    private String get_Address2(){ return address2;}
    
    private void set_City(){ city=txtCity.getText(); }
    private String get_City(){ return city;}
    
    private void set_PostalCode(){ postal_code=txtPostalCode.getText(); }
    private String get_PostalCode(){ return postal_code;}
    
    private void set_Email(){ email=txtEmail.getText(); }
    private String get_Email(){ return email;}

    private void set_TelNo(){ tel_No=txtTelNo.getText(); }
    private String get_TelNo(){ return tel_No;}
    
    private void set_Twitter(){ twitter=txtTwitter.getText(); }
    private String get_Twitter(){ return twitter;}
    
    /**
     * Set and Get  BLF Volunteer information 
     */
    
    private void set_VolProfession(){ vol_Profession=txtVolProfession.getText(); }
    private String get_VolProfession(){ return vol_Profession;}
    
    private void set_VolStartDate(){ 
        
        try{
            if(chkBLFvol.isSelected()){
            String  feachDate=dateFormat.format(dtVolStartDate.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            vol_StartDate= feachdate;
            }else vol_StartDate=null;
            
        }catch(Exception ex){
            utiObj.setToolTip(dtVolStartDate, "voluneer start Date error ! Error :" + ex);
        } 
    }
    private Date get_VolStartDate(){ return vol_StartDate;}
    
    private void set_VolEndDate(){ 
        
        try{
            if(chkBLFvol.isSelected()){
            String  feachDate=dateFormat.format(dtVolFinishedDate.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            vol_EndDate= feachdate;
            }else vol_EndDate=null;
        }catch(Exception ex){
            utiObj.setToolTip(dtVolFinishedDate, "voluneer End Date error ! Error :" + ex);
        } 
    }
    private Date get_VolEndDate(){ return vol_EndDate;}
    
    private void set_BLFType(){
        
        if(chkBlfNonAcc.isSelected() && !chkBLFvol.isSelected()) BLF_Type="BLF_NONAcc";
        else if (chkBLFvol.isSelected() && !chkBlfNonAcc.isSelected()) BLF_Type="BLF_VOL";
        else if (chkBlfNonAcc.isSelected() && chkBLFvol.isSelected()) BLF_Type="BLF_NONAcc,BLF_VOL";
        
        
    }
    private String get_BLFType(){return BLF_Type;}
    
    private void set_Withcarer(){ 
        if (chkWithCarer.isSelected()) with_Carer="TRUE"; else with_Carer="FALSE";
    }
    private String get_withcarer(){return with_Carer;}
    
    /**
     * Set and Get Personal Background Information 
     */

    private void set_EmpStatus(){ 
        if(!(cboEmploymentStatus.getSelectedIndex()==0))
        emp_Status_ID=busObj.IDHolder_EmpStatus.get(cboEmploymentStatus.getSelectedIndex());
        else 
        JOptionPane.showMessageDialog(IntFrameEnrolment.this, "Employment status Field missing ");
    }
    private int get_EmpStatus(){ return emp_Status_ID;}
    
    private void set_TotalIncome(){ 
    //    JOptionPane.showMessageDialog(IntFrameEnrolment.this, cboTotalIncome.getSelectedIndex());
         if(!(cboTotalIncome.getSelectedIndex()==0))        
              total_HIncome_ID=busObj.IDHolder_TotalIncome.get(cboTotalIncome.getSelectedIndex()); 
    }
    private int get_TotalIncome(){ return total_HIncome_ID;}
    
    private void set_LiveIn(){ 
        if(!(cboLiveIn.getSelectedIndex()==0))   
            live_In_ID=busObj.IDHolder_LiveIn.get(cboLiveIn.getSelectedIndex()); 
    }
    private int get_LiveIn(){ return live_In_ID;}
    
    private void set_BlfQualification(){ 
        if(!(cboQualification.getSelectedIndex()==0))   
            qualification_ID=busObj.IDHolder_Qualification.get(cboQualification.getSelectedIndex()); }
    private int get_BlfQualification(){ return qualification_ID;}
    
    private void set_ReceiptBenefit(){ 
        if(!(cboBenefit.getSelectedIndex()==0))  
            receipt_of_Benefit_ID=busObj.IDHolder_Benefit.get(cboBenefit.getSelectedIndex()); }
    private int get_ReceiptBenefit(){ return receipt_of_Benefit_ID;}
    
    private void set_EligibilityComment(){ eligibility_Comment=txtEligibilityComment.getText(); }
    private String get_EligibilityComment(){ return eligibility_Comment;}
    
    /**
     * Set and Get Personal Information 
     */
    
    private void set_Ethnicity(){ 
         if(!(cboEthnicity.getSelectedIndex()==0))  
             ethnicity_ID=busObj.IDHolder_Ethnicity.get(cboEthnicity.getSelectedIndex()); 
         else JOptionPane.showMessageDialog(IntFrameEnrolment.this, "Ethnicity field missing");}
    private int get_Ethnicity(){ return ethnicity_ID;
    }
    
    private void set_EthnicityBackground(){ 
        if (!(cboEthnicityBack.getSelectedIndex()==0))
            ethnicity_Background_ID=busObj.IDHolder_EthnicityBack.get(cboEthnicityBack.getSelectedIndex()); 
        else JOptionPane.showMessageDialog(IntFrameEnrolment.this, "Ethnicity Background field missing");
        
    }
    private int get_EthnicityBackground(){ return ethnicity_Background_ID;}
    
    private String get_DisabilityStatus(){ 
          String temp_String="";
            
            if (!(lstDisability.isSelectionEmpty())){
                  for (String v : disability_Status) {
                     temp_String=temp_String + v.trim() +",";
                  }
                 temp_String= temp_String.substring(0, temp_String.length()-1).trim();
            }
            return temp_String;
    }
    private String get_PreferTocontact(){ 
          String temp_String="";
            
            if (!(lstPreferContact.isSelectionEmpty())){
                  for (String v : prefer_Contact) {
                     temp_String=temp_String + v.trim() +",";
                  }
                 temp_String= temp_String.substring(0, temp_String.length()-1).trim();
            }
            return temp_String;
    }
    private String get_DisabilityNature(){
        String temp_String="";
            
            if (!(lstNatureDisability.isSelectionEmpty())){ 
                  for (String v : disability_Nature) {
                     temp_String=temp_String + v.trim()  +",";
                  }
                 temp_String= temp_String.substring(0, temp_String.length()-1).trim();
            }
            return temp_String;
          
    }
    
    private void set_OtherNeed(){ other_Needs=txtOtherNeeds.getText(); }
    private String get_OtherNeed(){ return other_Needs;}
    
    /**
     * Set and Get Equality Information 
     */
    
   
    private String get_DisadvntageGroup(){ 
       String temp_String="";
            
            if (!(lstDisadvantageGroup.isSelectionEmpty())){
               
                  for (String v : disadvantage_Group) {
                     temp_String=temp_String + v.trim()  +",";
                  }
                  temp_String=temp_String.substring(0, temp_String.length()-1).trim();
            }
            return temp_String;
      }
    
    private void set_SexualOrientaion(){ 
         if(!(cboSexOrientaion.getSelectedIndex()==0))  
             sexual_Orientaion_ID=busObj.IDHolder_SexualOrientaion.get(cboSexOrientaion.getSelectedIndex()); }
    private int get_SexualOrientaion(){ return sexual_Orientaion_ID;}
    
    private void set_Relegion(){ 
         if(!(cboRelegion.getSelectedIndex()==0))  
             relegion_ID=busObj.IDHolder_Relegion.get(cboRelegion.getSelectedIndex()); }
    private int get_Relegion(){ return relegion_ID;}
    
   
    private String get_KnowAbutUs(){ 
        String temp_String="";
            
            if (!(lstKnowAboutUs.isSelectionEmpty())){
                  for (String v : hear_AboutUs) {
                     temp_String=temp_String + v.trim()  +",";
                  }
                  temp_String=temp_String.substring(0, temp_String.length()-1).trim();
            }
           return temp_String;
      
    }
    
    private void set_ReferedBy(){ refered_By=txtRefferedBy.getText(); }
    private String get_ReferedBy(){ return refered_By;}
    
    /**
     * Clear the Data field 
     * @param evt 
     */
    
    private void clear_Fields(){
        btnSave.setText("Save All");
        txtStudentReferenceNo.setText(utiObj.generateBeneficiaryID(5, "BLF", busObj.set_SeqNextVal(1)));
        txtSurName.setText("");
        txtGivenName.setText("");
        txtNationalInssuranceNo.setValue(null);
        txtAddress1.setText("");
        txtAddress2.setText("");
        txtPostalCode.setText("");
        txtEmail.setText("");
        txtTelNo.setValue(null);
        txtTwitter.setText("");
        txtEligibilityComment.setText("");
        txtOtherNeeds.setText("");
        txtRefferedBy.setText("");
        txtVolProfession.setText("");
        DtRegestration.setDate(null);
        dtDateEntry.setDate(null);
        dtDateOfBirth.setDate(null);
        dtVolFinishedDate.setDate(null);
        dtVolStartDate.setDate(null);
        chkBLFvol.setSelected(false);
        tabBackground.setSelectedIndex(0);
        lblAge.setText("");
        
         selectCombo(cboEmploymentStatus);
         selectCombo(cboTotalIncome);
         selectCombo(cboLiveIn);
         selectCombo(cboQualification);
         selectCombo(cboBenefit);
         selectCombo(cboEthnicity);
         selectCombo(cboSexOrientaion);
         selectCombo(cboRelegion); 
        
        busObj.pop_Combo(cboEmploymentStatus,proc_EmployementStatus,"cboEmploymentStatus");
        busObj.pop_Combo(cboQualification,proc_Qualification,"cboQualification");
        busObj.pop_Combo(cboBenefit,proc_Benefit,"cboBenefit");
        busObj.pop_Combo(cboTotalIncome,proc_HouseHoldIncome,"cboTotalIncome");
        busObj.pop_Combo(cboLiveIn,proc_LivingIn,"cboLiveIn");
        busObj.pop_Combo(cboSexOrientaion,proc_SexOrientation,"cboSexOrientaion");
        busObj.pop_Combo(cboRelegion,proc_Relegion,"cboRelegion");
        busObj.pop_Combo(cboEthnicity,proc_Ethnicity,"cboEthnicity");
        cboEthnicityBack.removeAll();
        lstDisability.clearSelection();
        lstDisadvantageGroup.clearSelection();
        lstKnowAboutUs.clearSelection();
        lstNatureDisability.clearSelection();
        
    }
    
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
    private void btnPicBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPicBrowseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPicBrowseActionPerformed

    private void txtStudentReferenceNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentReferenceNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentReferenceNoActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       
    JDialog.setDefaultLookAndFeelDecorated(true);
     
        try{
            if(!(btnSave.getText()=="Add Next")){
                    if(!(txtSurName.getText().isEmpty() || txtGivenName.getText().isEmpty() || age<15 || 
                            cboEthnicityBack.getSelectedIndex()==0 || 
                            cboEthnicity.getSelectedIndex()==0 ||
                            cboEmploymentStatus.getSelectedIndex()==0 || 
                            cboBenefit.getSelectedIndex()==0 ||
                            cboLiveIn.getSelectedIndex()==0||
                            cboQualification.getSelectedIndex()==0||
                            cboRelegion.getSelectedIndex()==0||
                            cboSexOrientaion.getSelectedIndex()==0 ||
                            cboTotalIncome.getSelectedIndex()==0 ||
                            (chkBLFvol.isSelected()==true &&
                            chkBlfNonAcc.isSelected()==true))){

                        int response = JOptionPane.showConfirmDialog(IntFrameEnrolment.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {

                            set_StudentRef();

                            set_SurName();
                            set_GivenName();
                            set_DOB();
                            set_Gender();
                            set_SexualOrientaion();
                            set_Relegion();
                            set_NationalInsu();
                            busObj.insert_Beneficiary(   get_StudentRef(),
                                                         get_SurName(),
                                                         get_GivenName(),
                                                         utiObj.sql_Date(get_DOB()),
                                                         get_Gender(),
                                                         get_SexualOrientaion(),
                                                         get_Relegion(),
                                                         get_NationalInsu());

                            /**
                             * Insert address Information
                             */

                            set_Address1();
                            set_Address2();
                            set_City();
                            set_PostalCode();
                            set_TelNo();
                            set_Email();
                            set_Twitter();
                            busObj.insert_Benficiary_Address(   get_StudentRef(), 
                                                                get_Address1(),
                                                                get_Address2(),
                                                                get_City(),
                                                                get_PostalCode(),
                                                                get_TelNo(),
                                                                get_Email(),
                                                                get_Twitter());
                            /**
                             * Insert Personal Information 
                             */
                            set_Ethnicity();
                            set_EthnicityBackground();
                            set_OtherNeed();
                            busObj.insert_Personal_Information( get_StudentRef(), 
                                                                get_Ethnicity(),
                                                                get_EthnicityBackground(),
                                                                get_DisabilityStatus(), 
                                                                get_DisabilityNature(),
                                                                get_OtherNeed());
                            /**
                             * Insert Personal Background 
                             */
                            set_EmpStatus();
                            set_TotalIncome();
                            set_LiveIn();
                            set_BlfQualification();
                            set_EligibilityComment();
                            set_ReceiptBenefit();
                            busObj.insert_Personal_Background(  get_StudentRef(), 
                                                                get_EmpStatus(),
                                                                get_TotalIncome(),
                                                                get_LiveIn(), 
                                                                get_BlfQualification(),
                                                                get_EligibilityComment(),
                                                                get_DisadvntageGroup(),
                                                                get_ReceiptBenefit());

                            /**
                             * Insert Additional Information 
                             */
                            
                            set_RegistrationDate();
                            set_DateEntry();
                            set_BLFType();
                            set_VolStartDate();
                            set_VolEndDate();

                            set_Withcarer();
                            set_ReferedBy();
                            set_VolProfession();
                            busObj.insert_Additional_Information(get_StudentRef(),
                                                                utiObj.sql_Date(get_RegistrationDate()), 
                                                                get_BLFType(), 
                                                                utiObj.sql_Date(get_VolStartDate()), 
                                                                utiObj.sql_Date(get_VolEndDate()), 
                                                                get_withcarer(), 
                                                                get_KnowAbutUs(), 
                                                                get_ReferedBy(), 
                                                                get_VolProfession(),
                                                                utiObj.sql_Date(get_DateEntry()),
                                                                get_PreferTocontact());


                            JOptionPane.showMessageDialog(IntFrameEnrolment.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            
                            btnSave.setText("Add Next");
                       }
                    }else JOptionPane.showMessageDialog(IntFrameEnrolment.this, " Please complete missing fields !","Data Insertion",JOptionPane.ERROR_MESSAGE);
            }else clear_Fields();
        }   
        catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameEnrolment.this, ex);
                }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void chkBLFvolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBLFvolActionPerformed
       
        if (chkBLFvol.isSelected())
       {
                lblVolStartDate.setEnabled(true);
                lblVolEndDate.setEnabled(true);
                lblVolunteerInfo.setEnabled(true);
                lblVolQualification.setEnabled(true);
                txtVolProfession.setEnabled(true);
                dtVolStartDate.setEnabled(true);
                dtVolFinishedDate.setEnabled(true);
                
            
       }
       else{
                lblVolStartDate.setEnabled(false);
                lblVolEndDate.setEnabled(false);
                lblVolunteerInfo.setEnabled(false);
                lblVolQualification.setEnabled(false);
                txtVolProfession.setEnabled(false);
                dtVolStartDate.setEnabled(false);
                dtVolFinishedDate.setEnabled(false);
       }
           
      
    }//GEN-LAST:event_chkBLFvolActionPerformed

    private void chkBLFvolItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBLFvolItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_chkBLFvolItemStateChanged

    private void txtSurNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurNameKeyPressed
        
      
    }//GEN-LAST:event_txtSurNameKeyPressed

    private void txtSurNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurNameKeyTyped
       
        char ch=evt.getKeyChar(); 
        if(Character.isDigit(ch)){
            getToolkit().beep();
            utiObj.showErrorMessage(txtSurName, "Only Character is alowed ! (A-Z)");
            evt.consume();
         }
    }//GEN-LAST:event_txtSurNameKeyTyped

    private void txtGivenNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGivenNameKeyTyped
        
        char ch=evt.getKeyChar(); 
        if(Character.isDigit(ch)){
            getToolkit().beep();
            utiObj.showErrorMessage(txtGivenName, "Only Character is alowed ! (A-Z)");
            evt.consume();
         }
    }//GEN-LAST:event_txtGivenNameKeyTyped

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
       
        if (!(utiObj.isValidEmailAddress(txtEmail.getText()))){
           getToolkit().beep();
            utiObj.showErrorMessage(txtEmail, "Incorrect email address  ! Eg. john@gmail.com ");
            txtEmail.selectAll();
            txtEmail.setFocusable(true);
       }
           
    }//GEN-LAST:event_txtEmailFocusLost

    private void dtDateOfBirthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtDateOfBirthPropertyChange
        // TODO add your handling code here:
        try{
            String feachDate=dateFormat.format(dtDateOfBirth.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            age=utiObj.cal_age(feachdate);
                       
            lblAge.setText(String.valueOf(age)+" Years Old");
                
                if(age<15) {
                    utiObj.showErrorMessage(dtDateOfBirth, "Age should be >=15 !");
                    lblAge.setForeground(Color.RED);
                }else  lblAge.setForeground(Color.black);
                
            }catch(Exception ex){
                utiObj.showErrorMessage(dtDateOfBirth, " Error calculating Age Error: "+ex);
            }
    }//GEN-LAST:event_dtDateOfBirthPropertyChange

    private void lstDisabilityValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDisabilityValueChanged
                   
                   if(!evt.getValueIsAdjusting()) {
                     disability_Status = lstDisability.getSelectedValuesList();
                   }
    }//GEN-LAST:event_lstDisabilityValueChanged

    private void lstNatureDisabilityValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstNatureDisabilityValueChanged
       
                   if(!evt.getValueIsAdjusting()) {
                     disability_Nature = lstNatureDisability.getSelectedValuesList();
                   }
    }//GEN-LAST:event_lstNatureDisabilityValueChanged

    private void lstDisadvantageGroupValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDisadvantageGroupValueChanged
            
                   if(!evt.getValueIsAdjusting()) {
                     disadvantage_Group = lstDisadvantageGroup.getSelectedValuesList();
                   }
    }//GEN-LAST:event_lstDisadvantageGroupValueChanged

    private void lstKnowAboutUsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstKnowAboutUsValueChanged
                
                   if(!evt.getValueIsAdjusting()) {
                     hear_AboutUs = lstKnowAboutUs.getSelectedValuesList();
                   }
    }//GEN-LAST:event_lstKnowAboutUsValueChanged

    private void chkBlfNonAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBlfNonAccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkBlfNonAccActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
                    utiObj.flag1=false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void lstPreferContactValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPreferContactValueChanged
        if(!evt.getValueIsAdjusting()) {
                     prefer_Contact = lstPreferContact.getSelectedValuesList();
          }
    }//GEN-LAST:event_lstPreferContactValueChanged

   public void JcomboSelection(final JComboBox combo){
    combo.addActionListener (new ActionListener () {
    public void actionPerformed(ActionEvent e) {
        busObj.ethnicity= combo.getSelectedItem().toString();
        cboEthnicityBack.removeAllItems(); 
        selectCombo(cboEthnicityBack);
        busObj.pop_Combo(cboEthnicityBack,proc_EthniBackground,"cboEthnicityBack");
        //if(cboEthnicityBack.getItemCount() != 0)cboEthnicityBack.setSelectedIndex(0);
    }
});
} 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DtRegestration;
    private javax.swing.JButton btnPicBrowse;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cboBenefit;
    private javax.swing.JComboBox cboEmploymentStatus;
    private javax.swing.JComboBox cboEthnicity;
    private javax.swing.JComboBox cboEthnicityBack;
    private javax.swing.JComboBox cboGender;
    private javax.swing.JComboBox cboLiveIn;
    private javax.swing.JComboBox cboQualification;
    private javax.swing.JComboBox cboRelegion;
    private javax.swing.JComboBox cboSexOrientaion;
    private javax.swing.JComboBox cboTotalIncome;
    private javax.swing.JCheckBox chkBLFvol;
    private javax.swing.JCheckBox chkBlfNonAcc;
    private javax.swing.JCheckBox chkWithCarer;
    private com.toedter.calendar.JDateChooser dtDateEntry;
    private com.toedter.calendar.JDateChooser dtDateOfBirth;
    private com.toedter.calendar.JDateChooser dtVolFinishedDate;
    private com.toedter.calendar.JDateChooser dtVolStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelAddress;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelBasicInfo;
    private javax.swing.JPanel jPanelEnrolmentIfo;
    private javax.swing.JPanel jPanelEqualityOther;
    private javax.swing.JPanel jPanelPersonalInfo;
    private javax.swing.JPanel jPanelTypeOfBeneficiary;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblAddress1;
    private javax.swing.JLabel lblAddress2;
    private javax.swing.JLabel lblAddress3;
    private javax.swing.JLabel lblAddress4;
    private javax.swing.JLabel lblAddress5;
    private javax.swing.JLabel lblAddress6;
    private javax.swing.JLabel lblAddress7;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblBenPicture;
    private javax.swing.JLabel lblDateReg;
    private javax.swing.JLabel lblDateReg1;
    private javax.swing.JLabel lblNI;
    private javax.swing.JLabel lblRefferedBy;
    private javax.swing.JLabel lblStudentReferenceNo;
    private javax.swing.JLabel lblVolEndDate;
    private javax.swing.JLabel lblVolQualification;
    private javax.swing.JLabel lblVolStartDate;
    private javax.swing.JLabel lblVolunteerInfo;
    private javax.swing.JList lstDisability;
    private javax.swing.JList lstDisadvantageGroup;
    private javax.swing.JList lstKnowAboutUs;
    private javax.swing.JList lstNatureDisability;
    private javax.swing.JList lstPreferContact;
    private javax.swing.JTabbedPane tabBackground;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtAddress2;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextArea txtEligibilityComment;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGivenName;
    private javax.swing.JFormattedTextField txtNationalInssuranceNo;
    private javax.swing.JTextArea txtOtherNeeds;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextArea txtRefferedBy;
    private javax.swing.JTextField txtStudentReferenceNo;
    private javax.swing.JTextField txtSurName;
    private javax.swing.JFormattedTextField txtTelNo;
    private javax.swing.JTextField txtTwitter;
    private javax.swing.JTextField txtVolProfession;
    // End of variables declaration//GEN-END:variables
}
