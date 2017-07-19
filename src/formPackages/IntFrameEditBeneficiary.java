/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages;

import formPackages.classPackages.businessLayer;
import formPackages.classPackages.utility;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import oracle.jdbc.OracleResultSet;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author jo
 */
public final class IntFrameEditBeneficiary extends javax.swing.JInternalFrame {

        private static int flag=0;
        private String StudentReference_No;
        private boolean ALLOW_ROW_SELECTION =true;
        private static final String NOT_SELECTABLE_OPTION="Select...";
        private int selectedRow;
        
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
        private Date volEndDate;
        
        private int emp_Status_ID ;
        private int total_HIncome_ID;
        private int live_In_ID;
        private int receipt_of_Benefit_ID;
       
        private int ethnicity_ID;
        private int ethnicity_Background_ID;
        private List<String> disability_Status;
        private List<String> disability_Nature=null;
       
        
        private List<String> disadvantage_Group=null;
        private int sexual_Orientaion_ID;
        private int relegion_ID;
        private String refered_By;
        private List <String> lstVolTypeObj;
        
        private static String refNo;
   
    businessLayer busObj =new businessLayer();
    utility utiObj=new utility();
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
    
    private String proc_DeletBeneficiary="{call Update_Data_Package.delete_Beneficiary(?,?)}";
    
    private String proc_Benefit="SELECT_DATA_PACKAGE.get_Benefit(?)"; 
    private String proc_DisabilityNature="SELECT_DATA_PACKAGE.get_DisabilityNature(?)"; 
    private String proc_DisabilityStatus="SELECT_DATA_PACKAGE.get_DisabilityStatus(?)"; 
    private String proc_EmployementStatus="SELECT_DATA_PACKAGE.get_EmployementStatus(?)"; 
    private String proc_EqualityInfo="SELECT_DATA_PACKAGE.get_EqualityInformation(?)"; 
    private String proc_Ethnicity="SELECT_DATA_PACKAGE.get_Ethnicity(?)"; 

    private String proc_EthniBackground="SELECT_DATA_PACKAGE.get_EthinicityBackground(?,?)"; 
    private String proc_HouseHoldIncome="SELECT_DATA_PACKAGE.get_HouseHoldIncome(?)"; 
    private String proc_LivingIn="SELECT_DATA_PACKAGE.get_LivingIn(?)"; 
    private String proc_Relegion="SELECT_DATA_PACKAGE.get_Relegion(?)"; 
    private String proc_SexOrientation="SELECT_DATA_PACKAGE.get_SexualOreintation(?)"; 
    
    
    public IntFrameEditBeneficiary() {
        initComponents();
        
        IntFrameEditBeneficiary.refNo=refNo;
        
        try{
        MaskFormatter ssnFormatter = new MaskFormatter("(####) ###-####");
        ssnFormatter.setValueClass(String.class);
        ssnFormatter.setPlaceholderCharacter('_');  
        DefaultFormatterFactory ssnFormatterFactory = new
        DefaultFormatterFactory(ssnFormatter);
        txtTelNO.setFormatterFactory(ssnFormatterFactory);}
        catch(Exception ex){ 
               System.out.println(ex);
        }
        
        try{
        MaskFormatter ssnFormatter = new MaskFormatter("UU######U");
        ssnFormatter.setValueClass(String.class);
        ssnFormatter.setPlaceholderCharacter('_');  
        DefaultFormatterFactory ssnFormatterFactory = new
        DefaultFormatterFactory(ssnFormatter);
        txtNINO.setFormatterFactory(ssnFormatterFactory);
        }catch(Exception ex){ 
               System.out.println(ex);
        }
        
         selectCombo(cboEmpStatus);
         selectCombo(cboTotalIncome);
         selectCombo(cboLiveIn);
         selectCombo(cboSexOrient);
         selectCombo(cboEthnicity);
         selectCombo(cboReciptBenefit);
         selectCombo(cboRelegion); 
         
        busObj.pop_Combo(cboEmpStatus,proc_EmployementStatus,"cboEmploymentStatus");
        busObj.pop_Combo(cboReciptBenefit,proc_Benefit,"cboBenefit");
        busObj.pop_Combo(cboTotalIncome,proc_HouseHoldIncome,"cboTotalIncome");
        busObj.pop_Combo(cboLiveIn,proc_LivingIn,"cboLiveIn");
        busObj.pop_Combo(cboSexOrient,proc_SexOrientation,"cboSexOrientaion");
        busObj.pop_Combo(cboRelegion,proc_Relegion,"cboRelegion");
        busObj.pop_Combo(cboEthnicity,proc_Ethnicity,"cboEthnicity");
        busObj.pop_List(lstDisabilityStatus,proc_DisabilityStatus,0);
        busObj.pop_List(lstDisabilityNature,proc_DisabilityNature,0);
        busObj.pop_List(lstEquality,proc_EqualityInfo,0);
               
        Tbl_SelectionMode(tblGeneralSearchBenficiary,"tblGeneralSearchBenficiary");
      JcomboSelection(cboEthnicity);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAddress = new javax.swing.ButtonGroup();
        buttonGroupBesicInfo = new javax.swing.ButtonGroup();
        buttonGroupBackground = new javax.swing.ButtonGroup();
        buttonGroupOther = new javax.swing.ButtonGroup();
        buttonGroupSearch = new javax.swing.ButtonGroup();
        optRedioByReference = new javax.swing.JRadioButton();
        optRedioBySurName = new javax.swing.JRadioButton();
        optRedioByFirstName = new javax.swing.JRadioButton();
        txtMultiSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGeneralSearchBenficiary = new javax.swing.JTable(){

            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        jPanel5 = new javax.swing.JPanel();
        optAddress1 = new javax.swing.JRadioButton();
        optAddress2 = new javax.swing.JRadioButton();
        optTwitter = new javax.swing.JRadioButton();
        optCity = new javax.swing.JRadioButton();
        optPostCode = new javax.swing.JRadioButton();
        optTelNo = new javax.swing.JRadioButton();
        optEmail = new javax.swing.JRadioButton();
        txtAddress1 = new javax.swing.JTextField();
        btnSaveChangeAddress = new javax.swing.JButton();
        txtCity = new javax.swing.JTextField();
        txtAddress2 = new javax.swing.JTextField();
        txtPostCode = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTwitter = new javax.swing.JTextField();
        txtTelNO = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        optSurname = new javax.swing.JRadioButton();
        optDateOfArriveUK = new javax.swing.JRadioButton();
        optGivenName = new javax.swing.JRadioButton();
        optDOB = new javax.swing.JRadioButton();
        optSex = new javax.swing.JRadioButton();
        optNINO = new javax.swing.JRadioButton();
        optBenefType = new javax.swing.JRadioButton();
        txtSurname = new javax.swing.JTextField();
        btnSaveChangeBasicinfo = new javax.swing.JButton();
        txtGivenName = new javax.swing.JTextField();
        dtDOB = new com.toedter.calendar.JDateChooser();
        cboSex = new javax.swing.JComboBox();
        txtNINO = new javax.swing.JFormattedTextField();
        dtDateofArriveUK = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstBenefType = new javax.swing.JList();
        lblStudentRefNo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        optEmpStatus = new javax.swing.JRadioButton();
        optTotalIncome = new javax.swing.JRadioButton();
        optLiveIN = new javax.swing.JRadioButton();
        optReciptBenefit = new javax.swing.JRadioButton();
        cboTotalIncome = new javax.swing.JComboBox();
        cboEmpStatus = new javax.swing.JComboBox();
        cboLiveIn = new javax.swing.JComboBox();
        cboReciptBenefit = new javax.swing.JComboBox();
        btnSaveChangeBackground = new javax.swing.JButton();
        optReleion = new javax.swing.JRadioButton();
        cboRelegion = new javax.swing.JComboBox();
        optSexualOrientation = new javax.swing.JRadioButton();
        cboSexOrient = new javax.swing.JComboBox();
        optEthnicity = new javax.swing.JRadioButton();
        cboEthnicity = new javax.swing.JComboBox();
        optEthnicityBack = new javax.swing.JRadioButton();
        cboEthnicityBack = new javax.swing.JComboBox();
        optReferdBy = new javax.swing.JRadioButton();
        txtReferedBy = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        dtVolEndDate = new com.toedter.calendar.JDateChooser();
        btnSaveChangeOther = new javax.swing.JButton();
        optDisabilityNature = new javax.swing.JRadioButton();
        optDisabilityStatus = new javax.swing.JRadioButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        lstDisabilityNature = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        lstDisabilityStatus = new javax.swing.JList();
        optEquality = new javax.swing.JRadioButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        lstEquality = new javax.swing.JList();
        optVolEndDate = new javax.swing.JRadioButton();
        optVolSartDate = new javax.swing.JRadioButton();
        dtVolStartDate = new com.toedter.calendar.JDateChooser();
        optRegistrationDate = new javax.swing.JRadioButton();
        dtRegistrationDate = new com.toedter.calendar.JDateChooser();
        optVolProfession = new javax.swing.JRadioButton();
        txtVolProfession = new javax.swing.JTextField();
        btnDeletBeneficiary = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setIconifiable(true);
        setTitle("Manage Beneficiary");
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

        buttonGroupSearch.add(optRedioByReference);
        optRedioByReference.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optRedioByReference.setSelected(true);
        optRedioByReference.setText("By Reference ID");
        optRedioByReference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRedioByReferenceActionPerformed(evt);
            }
        });

        buttonGroupSearch.add(optRedioBySurName);
        optRedioBySurName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optRedioBySurName.setText("By Surname");
        optRedioBySurName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRedioBySurNameActionPerformed(evt);
            }
        });

        buttonGroupSearch.add(optRedioByFirstName);
        optRedioByFirstName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optRedioByFirstName.setText("By Given Name");
        optRedioByFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRedioByFirstNameActionPerformed(evt);
            }
        });

        txtMultiSearch.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtMultiSearch.setToolTipText("");
        txtMultiSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtMultiSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMultiSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMultiSearchFocusLost(evt);
            }
        });
        txtMultiSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMultiSearchKeyPressed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SearchSmall.png"))); // NOI18N
        btnSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblGeneralSearchBenficiary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblGeneralSearchBenficiary.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane5.setViewportView(tblGeneralSearchBenficiary);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Address Information"));
        jPanel5.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        buttonGroupAddress.add(optAddress1);
        optAddress1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optAddress1.setText("Address 1");
        optAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAddress1ActionPerformed(evt);
            }
        });

        buttonGroupAddress.add(optAddress2);
        optAddress2.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optAddress2.setText("Address 2");
        optAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAddress2ActionPerformed(evt);
            }
        });

        buttonGroupAddress.add(optTwitter);
        optTwitter.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optTwitter.setText("Twitter");
        optTwitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optTwitterActionPerformed(evt);
            }
        });

        buttonGroupAddress.add(optCity);
        optCity.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optCity.setText("City");
        optCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optCityActionPerformed(evt);
            }
        });

        buttonGroupAddress.add(optPostCode);
        optPostCode.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optPostCode.setText("Post Code");
        optPostCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optPostCodeActionPerformed(evt);
            }
        });

        buttonGroupAddress.add(optTelNo);
        optTelNo.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optTelNo.setText("Tel. No");
        optTelNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optTelNoActionPerformed(evt);
            }
        });

        buttonGroupAddress.add(optEmail);
        optEmail.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optEmail.setText("Email");
        optEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEmailActionPerformed(evt);
            }
        });

        txtAddress1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtAddress1.setEnabled(false);

        btnSaveChangeAddress.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnSaveChangeAddress.setText("Save Change");
        btnSaveChangeAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangeAddressActionPerformed(evt);
            }
        });

        txtCity.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtCity.setEnabled(false);

        txtAddress2.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtAddress2.setEnabled(false);

        txtPostCode.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtPostCode.setEnabled(false);

        txtEmail.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtEmail.setEnabled(false);

        txtTwitter.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtTwitter.setEnabled(false);

        txtTelNO.setEnabled(false);
        txtTelNO.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optAddress1)
                    .addComponent(optAddress2)
                    .addComponent(optCity)
                    .addComponent(optPostCode)
                    .addComponent(optTelNo)
                    .addComponent(optEmail)
                    .addComponent(optTwitter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSaveChangeAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAddress1)
                    .addComponent(txtAddress2)
                    .addComponent(txtCity)
                    .addComponent(txtEmail)
                    .addComponent(txtPostCode, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(txtTelNO, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(txtTwitter))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtPostCode, txtTelNO});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optAddress1)
                    .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optAddress2)
                    .addComponent(txtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optCity)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optPostCode)
                    .addComponent(txtPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optTelNo)
                    .addComponent(txtTelNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optTwitter)
                    .addComponent(txtTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveChangeAddress)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtPostCode, txtTelNO});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Basic Personal Information"));
        jPanel3.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        buttonGroupBesicInfo.add(optSurname);
        optSurname.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optSurname.setText("Surname");
        optSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optSurnameActionPerformed(evt);
            }
        });

        buttonGroupBesicInfo.add(optDateOfArriveUK);
        optDateOfArriveUK.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optDateOfArriveUK.setText("Date Into UK");
        optDateOfArriveUK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDateOfArriveUKActionPerformed(evt);
            }
        });

        buttonGroupBesicInfo.add(optGivenName);
        optGivenName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optGivenName.setText("Given Name");
        optGivenName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optGivenNameActionPerformed(evt);
            }
        });

        buttonGroupBesicInfo.add(optDOB);
        optDOB.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optDOB.setText("Date of Birth");
        optDOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDOBActionPerformed(evt);
            }
        });

        buttonGroupBesicInfo.add(optSex);
        optSex.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optSex.setText("Sex");
        optSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optSexActionPerformed(evt);
            }
        });

        buttonGroupBesicInfo.add(optNINO);
        optNINO.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optNINO.setText("NI. NO");
        optNINO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optNINOActionPerformed(evt);
            }
        });

        buttonGroupBesicInfo.add(optBenefType);
        optBenefType.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optBenefType.setText("Beneficiary Type");
        optBenefType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optBenefTypeActionPerformed(evt);
            }
        });

        txtSurname.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtSurname.setEnabled(false);

        btnSaveChangeBasicinfo.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnSaveChangeBasicinfo.setText("Save Change");
        btnSaveChangeBasicinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangeBasicinfoActionPerformed(evt);
            }
        });

        txtGivenName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtGivenName.setEnabled(false);

        dtDOB.setDateFormatString("dd/MM/yyyy");
        dtDOB.setEnabled(false);
        dtDOB.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        cboSex.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        cboSex.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboSex.setEnabled(false);

        txtNINO.setEnabled(false);
        txtNINO.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        dtDateofArriveUK.setDateFormatString("dd/MM/yyyy");
        dtDateofArriveUK.setEnabled(false);
        dtDateofArriveUK.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        lstBenefType.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstBenefType.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "BLF_NONAcc", "BLF_VOL" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstBenefType.setEnabled(false);
        lstBenefType.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstBenefTypeValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstBenefType);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optSurname)
                    .addComponent(optNINO)
                    .addComponent(optDateOfArriveUK)
                    .addComponent(optDOB)
                    .addComponent(optGivenName)
                    .addComponent(optSex)
                    .addComponent(optBenefType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSurname)
                    .addComponent(txtGivenName)
                    .addComponent(dtDateofArriveUK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNINO)
                    .addComponent(dtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboSex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(btnSaveChangeBasicinfo, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optSurname)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optGivenName)
                    .addComponent(txtGivenName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optDOB)
                    .addComponent(dtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optSex)
                    .addComponent(cboSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optNINO)
                    .addComponent(txtNINO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optDateOfArriveUK)
                    .addComponent(dtDateofArriveUK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optBenefType)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveChangeBasicinfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboSex, dtDOB, dtDateofArriveUK, txtGivenName, txtNINO});

        lblStudentRefNo.setBackground(new java.awt.Color(255, 255, 255));
        lblStudentRefNo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lblStudentRefNo.setForeground(new java.awt.Color(255, 0, 0));
        lblStudentRefNo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Background "));
        jPanel7.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        buttonGroupBackground.add(optEmpStatus);
        optEmpStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optEmpStatus.setText("Employement Status");
        optEmpStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEmpStatusActionPerformed(evt);
            }
        });

        buttonGroupBackground.add(optTotalIncome);
        optTotalIncome.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optTotalIncome.setText("Total household Income");
        optTotalIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optTotalIncomeActionPerformed(evt);
            }
        });

        buttonGroupBackground.add(optLiveIN);
        optLiveIN.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optLiveIN.setText("Live IN");
        optLiveIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optLiveINActionPerformed(evt);
            }
        });

        buttonGroupBackground.add(optReciptBenefit);
        optReciptBenefit.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optReciptBenefit.setText("Recipt of Benefit");
        optReciptBenefit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optReciptBenefitActionPerformed(evt);
            }
        });

        cboTotalIncome.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboTotalIncome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboTotalIncome.setEnabled(false);

        cboEmpStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboEmpStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboEmpStatus.setEnabled(false);

        cboLiveIn.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboLiveIn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboLiveIn.setEnabled(false);

        cboReciptBenefit.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboReciptBenefit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboReciptBenefit.setEnabled(false);

        btnSaveChangeBackground.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnSaveChangeBackground.setText("Save Change");
        btnSaveChangeBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangeBackgroundActionPerformed(evt);
            }
        });

        buttonGroupBackground.add(optReleion);
        optReleion.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optReleion.setText("Religion");
        optReleion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optReleionActionPerformed(evt);
            }
        });

        cboRelegion.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboRelegion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboRelegion.setEnabled(false);

        buttonGroupBackground.add(optSexualOrientation);
        optSexualOrientation.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optSexualOrientation.setText("Sexual Orientaion:");
        optSexualOrientation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optSexualOrientationActionPerformed(evt);
            }
        });

        cboSexOrient.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboSexOrient.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboSexOrient.setEnabled(false);

        buttonGroupBackground.add(optEthnicity);
        optEthnicity.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optEthnicity.setText("Ethnicity");
        optEthnicity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEthnicityActionPerformed(evt);
            }
        });

        cboEthnicity.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboEthnicity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboEthnicity.setEnabled(false);

        buttonGroupBackground.add(optEthnicityBack);
        optEthnicityBack.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optEthnicityBack.setText("Ethnic Background");
        optEthnicityBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEthnicityBackActionPerformed(evt);
            }
        });

        cboEthnicityBack.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboEthnicityBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboEthnicityBack.setEnabled(false);

        buttonGroupBackground.add(optReferdBy);
        optReferdBy.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optReferdBy.setText("Refered By:");
        optReferdBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optReferdByActionPerformed(evt);
            }
        });

        txtReferedBy.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtReferedBy.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optEmpStatus)
                    .addComponent(optTotalIncome)
                    .addComponent(optLiveIN)
                    .addComponent(optReciptBenefit)
                    .addComponent(optReleion)
                    .addComponent(optSexualOrientation)
                    .addComponent(optEthnicity)
                    .addComponent(optEthnicityBack)
                    .addComponent(optReferdBy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveChangeBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(cboEmpStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboRelegion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboReciptBenefit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboLiveIn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboTotalIncome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboSexOrient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboEthnicity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboEthnicityBack, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtReferedBy))
                .addGap(17, 17, 17))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optEmpStatus)
                    .addComponent(cboEmpStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optTotalIncome)
                    .addComponent(cboTotalIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optLiveIN)
                    .addComponent(cboLiveIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optReciptBenefit)
                    .addComponent(cboReciptBenefit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optReleion)
                    .addComponent(cboRelegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optSexualOrientation)
                    .addComponent(cboSexOrient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optEthnicity)
                    .addComponent(cboEthnicity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optEthnicityBack)
                    .addComponent(cboEthnicityBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtReferedBy)
                    .addComponent(optReferdBy, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveChangeBackground)
                .addGap(6, 6, 6))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Other"));
        jPanel8.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        dtVolEndDate.setDateFormatString("dd/MM/yyyy");
        dtVolEndDate.setEnabled(false);
        dtVolEndDate.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        btnSaveChangeOther.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnSaveChangeOther.setText("Save Change");
        btnSaveChangeOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangeOtherActionPerformed(evt);
            }
        });

        buttonGroupOther.add(optDisabilityNature);
        optDisabilityNature.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optDisabilityNature.setText("Disability Nature");
        optDisabilityNature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDisabilityNatureActionPerformed(evt);
            }
        });

        buttonGroupOther.add(optDisabilityStatus);
        optDisabilityStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optDisabilityStatus.setText("Disability Status:");
        optDisabilityStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDisabilityStatusActionPerformed(evt);
            }
        });

        lstDisabilityNature.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstDisabilityNature.setEnabled(false);
        lstDisabilityNature.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDisabilityNatureValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(lstDisabilityNature);

        lstDisabilityStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstDisabilityStatus.setEnabled(false);
        lstDisabilityStatus.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDisabilityStatusValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(lstDisabilityStatus);

        buttonGroupOther.add(optEquality);
        optEquality.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optEquality.setText("Equality");
        optEquality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEqualityActionPerformed(evt);
            }
        });

        lstEquality.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstEquality.setEnabled(false);
        lstEquality.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEqualityValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(lstEquality);

        buttonGroupOther.add(optVolEndDate);
        optVolEndDate.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optVolEndDate.setText("Vol. End Date");
        optVolEndDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optVolEndDateActionPerformed(evt);
            }
        });

        buttonGroupOther.add(optVolSartDate);
        optVolSartDate.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optVolSartDate.setText("Vol. Start Date");
        optVolSartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optVolSartDateActionPerformed(evt);
            }
        });

        dtVolStartDate.setDateFormatString("dd/MM/yyyy");
        dtVolStartDate.setEnabled(false);
        dtVolStartDate.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        buttonGroupOther.add(optRegistrationDate);
        optRegistrationDate.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optRegistrationDate.setText("Registration Date");
        optRegistrationDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRegistrationDateActionPerformed(evt);
            }
        });

        dtRegistrationDate.setDateFormatString("dd/MM/yyyy");
        dtRegistrationDate.setEnabled(false);
        dtRegistrationDate.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        buttonGroupOther.add(optVolProfession);
        optVolProfession.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optVolProfession.setText("Vol. Profession");
        optVolProfession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optVolProfessionActionPerformed(evt);
            }
        });

        txtVolProfession.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtVolProfession.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optDisabilityStatus)
                    .addComponent(optDisabilityNature)
                    .addComponent(optEquality)
                    .addComponent(optVolSartDate)
                    .addComponent(optVolEndDate)
                    .addComponent(optVolProfession)
                    .addComponent(optRegistrationDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSaveChangeOther, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(dtVolStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(dtVolEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtRegistrationDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVolProfession))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optDisabilityStatus)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optDisabilityNature)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optEquality)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtVolStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optVolSartDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optVolEndDate)
                    .addComponent(dtVolEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optVolProfession)
                    .addComponent(txtVolProfession, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optRegistrationDate)
                    .addComponent(dtRegistrationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveChangeOther)
                .addGap(12, 12, 12))
        );

        btnDeletBeneficiary.setText("Delete");
        btnDeletBeneficiary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletBeneficiaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDeletBeneficiary)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblStudentRefNo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(323, 323, 323))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtMultiSearch)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(optRedioByReference)
                                                .addGap(18, 18, 18)
                                                .addComponent(optRedioBySurName)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(optRedioByFirstName)
                                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optRedioByReference)
                            .addComponent(optRedioBySurName)
                            .addComponent(optRedioByFirstName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMultiSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeletBeneficiary)
                            .addComponent(lblStudentRefNo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void set_VolEndDate(){ 
        try{
            String  feachDate=dateFormat.format(dtVolEndDate.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            volEndDate= feachdate;
        }catch(Exception ex){
            utiObj.setToolTip(dtVolEndDate, "Registration Date error ! Error :" + ex);
        }   
    }
    private Date get_VolEndDate(){return volEndDate;}
    private String get_VolType(){ 
          String temp_String="";
            
            if (!(lstBenefType.isSelectionEmpty())){
                  for (String v : lstVolTypeObj) {
                     temp_String=temp_String + v +",";
                  }
            }
            return temp_String.substring(0, temp_String.length()-1);
    }
    private void set_StudentRef(){ student_Ref=lblStudentRefNo.getText(); }
    private String get_StudentRef(){ return student_Ref;}
    private void set_NationalInsu(){ national_Ins=txtNINO.getText(); }
    private String get_NationalInsu(){ return national_Ins;}
    private void set_RegistrationDate(){ 
        try{
            String  feachDate=dateFormat.format(dtRegistrationDate.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            registration_Date= feachdate;
        }catch(Exception ex){
            utiObj.setToolTip(dtRegistrationDate, "Registration Date error ! Error :" + ex);
        }   
    }
    private Date get_RegistrationDate(){return registration_Date;}
    private void set_DateEntry(){ 
        try{
            String  feachDate=dateFormat.format(dtDateofArriveUK.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            date_Entry= feachdate;
        }catch(Exception ex){
            utiObj.setToolTip(dtDateofArriveUK, "Registration Date error ! Error :" + ex);
        }   
    }
    private Date get_DateEntry(){return date_Entry;}
    private void set_SurName(){ sur_Name=txtSurname.getText(); }
    private String get_SurName(){ return sur_Name;}
    private void set_GivenName(){ given_Name=txtGivenName.getText(); }
    private String get_GivenName(){ return given_Name;}
    private void set_Gender(){ gender=cboSex.getSelectedItem().toString(); }
    private String get_Gender(){ return gender;}
    private void set_DOB(){ 
        try{
            String  feachDate=dateFormat.format(dtDOB.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            date_of_Birth= feachdate;
            
        }catch(Exception ex){
            utiObj.setToolTip(dtDOB, "Date of Birth Date error ! Error :" + ex);
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
    private void set_PostalCode(){ postal_code=txtPostCode.getText(); }
    private String get_PostalCode(){ return postal_code;}
    private void set_Email(){ email=txtEmail.getText(); }
    private String get_Email(){ return email;}
    private void set_TelNo(){ tel_No=txtTelNO.getText(); }
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
           
            String  feachDate=dateFormat.format(dtVolStartDate.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            vol_StartDate= feachdate;
                      
        }catch(Exception ex){
            utiObj.setToolTip(dtVolStartDate, "voluneer start Date error ! Error :" + ex);
        } 
    }
    private Date get_VolStartDate(){ return vol_StartDate;}
  
    /**
     * Set and Get Personal Background Information 
     */

    private void set_EmpStatus(){ 
        if(!(cboEmpStatus.getSelectedIndex()==0))
        emp_Status_ID=busObj.IDHolder_EmpStatus.get(cboEmpStatus.getSelectedIndex());
        //else JOptionPane.showMessageDialog(IntFrameEnrolment.this, "Employment status Field missing ");
    }
    private int get_EmpStatus(){ return emp_Status_ID;}
    private void set_TotalIncome(){ 
  
         if(!(cboTotalIncome.getSelectedIndex()==0))        
              total_HIncome_ID=busObj.IDHolder_TotalIncome.get(cboTotalIncome.getSelectedIndex()); 
    }
    private int get_TotalIncome(){ return total_HIncome_ID;}
    private void set_LiveIn(){ 
        if(!(cboLiveIn.getSelectedIndex()==0))   
            live_In_ID=busObj.IDHolder_LiveIn.get(cboLiveIn.getSelectedIndex()); 
    }
    private int get_LiveIn(){ return live_In_ID;}
    private void set_ReceiptBenefit(){ 
        if(!(cboReciptBenefit.getSelectedIndex()==0))  
            receipt_of_Benefit_ID=busObj.IDHolder_Benefit.get(cboReciptBenefit.getSelectedIndex()); }
    private int get_ReceiptBenefit(){ return receipt_of_Benefit_ID;}
    
     /**
     * Set and Get Personal Information 
     */
    
    private void set_Ethnicity(){ 
         if(!(cboEthnicity.getSelectedIndex()==0))  
             ethnicity_ID=busObj.IDHolder_Ethnicity.get(cboEthnicity.getSelectedIndex()); 
        // else JOptionPane.showMessageDialog(IntFrameEnrolment.this, "Ethnicity field missing");
    }
    private int get_Ethnicity(){ return ethnicity_ID;}
    private void set_EthnicityBackground(){ 
        if (!(cboEthnicityBack.getSelectedIndex()==0))
            ethnicity_Background_ID=busObj.IDHolder_EthnicityBack.get(cboEthnicityBack.getSelectedIndex()); 
       // else JOptionPane.showMessageDialog(IntFrameEnrolment.this, "Ethnicity Background field missing");
        
    }
    private int get_EthnicityBackground(){ return ethnicity_Background_ID;}
    private String get_DisabilityStatus(){ 
          String temp_String="";
            
            if (!(lstDisabilityStatus.isSelectionEmpty())){
                  for (String v : disability_Status) {
                     temp_String=temp_String + v.trim() +",";
                  }
                 temp_String= temp_String.substring(0, temp_String.length()-1).trim();
            }
            return temp_String;
    }
    private String get_DisabilityNature(){
        String temp_String="";
            
            if (!(lstDisabilityNature.isSelectionEmpty())){ 
                  for (String v : disability_Nature) {
                     temp_String=temp_String + v.trim()  +",";
                  }
                 temp_String= temp_String.substring(0, temp_String.length()-1).trim();
            }
            return temp_String;
          
    }
    
    
    /**
     * Set and Get Equality Information 
     */
    
   
    private String get_DisadvntageGroup(){ 
       String temp_String="";
            
            if (!(lstEquality.isSelectionEmpty())){
               
                  for (String v : disadvantage_Group) {
                     temp_String=temp_String + v.trim()  +",";
                  }
                  temp_String=temp_String.substring(0, temp_String.length()-1).trim();
            }
            return temp_String;
      }
    private void set_SexualOrientaion(){ 
         if(!(cboSexOrient.getSelectedIndex()==0))  
             sexual_Orientaion_ID=busObj.IDHolder_SexualOrientaion.get(cboSexOrient.getSelectedIndex()); }
    private int get_SexualOrientaion(){ return sexual_Orientaion_ID;}
    private void set_Relegion(){ 
         if(!(cboRelegion.getSelectedIndex()==0))  
             relegion_ID=busObj.IDHolder_Relegion.get(cboRelegion.getSelectedIndex()); }
    private int get_Relegion(){ return relegion_ID;}
    private void set_ReferedBy(){ refered_By=txtReferedBy.getText(); }
    private String get_ReferedBy(){ return refered_By;}
    
    private void lstBenefTypeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstBenefTypeValueChanged
                if(!evt.getValueIsAdjusting()) {
                     lstVolTypeObj = lstBenefType.getSelectedValuesList();
                   }
    }//GEN-LAST:event_lstBenefTypeValueChanged

    private void optSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optSurnameActionPerformed
       if(optSurname.isSelected()){
           txtSurname.setEnabled(true);
           txtGivenName.setEnabled(false);
           dtDOB.setEnabled(false);
           cboSex.setEnabled(false);
           txtNINO.setEnabled(false);
           dtDateofArriveUK.setEnabled(false);
           lstBenefType.setEnabled(false);
       
       }
    }//GEN-LAST:event_optSurnameActionPerformed

    private void optAddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAddress1ActionPerformed
        if(optAddress1.isSelected()){
             txtAddress1.setEnabled(true);
             txtAddress2.setEnabled(false);
             txtCity.setEnabled(false);
             txtPostCode.setEnabled(false);
             txtTelNO.setEnabled(false);
             txtEmail.setEnabled(false);
             txtTwitter.setEnabled(false);
        }
    }//GEN-LAST:event_optAddress1ActionPerformed

    private void optAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAddress2ActionPerformed
         if(optAddress2.isSelected()){
             txtAddress1.setEnabled(false);
             txtAddress2.setEnabled(true);
             txtCity.setEnabled(false);
             txtPostCode.setEnabled(false);
             txtTelNO.setEnabled(false);
             txtEmail.setEnabled(false);
             txtTwitter.setEnabled(false);
        }
    }//GEN-LAST:event_optAddress2ActionPerformed

    private void optGivenNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optGivenNameActionPerformed
        if(optGivenName.isSelected()){
           txtSurname.setEnabled(false);
           txtGivenName.setEnabled(true);
           dtDOB.setEnabled(false);
           cboSex.setEnabled(false);
           txtNINO.setEnabled(false);
           dtDateofArriveUK.setEnabled(false);
           lstBenefType.setEnabled(false);
       
       }
    }//GEN-LAST:event_optGivenNameActionPerformed

    private void optDOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDOBActionPerformed
        if(optDOB.isSelected()){
           txtSurname.setEnabled(false);
           txtGivenName.setEnabled(false);
           dtDOB.setEnabled(true);
           cboSex.setEnabled(false);
           txtNINO.setEnabled(false);
           dtDateofArriveUK.setEnabled(false);
           lstBenefType.setEnabled(false);
       
       }
    }//GEN-LAST:event_optDOBActionPerformed

    private void optSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optSexActionPerformed
         if(optSex.isSelected()){
           txtSurname.setEnabled(false);
           txtGivenName.setEnabled(false);
           dtDOB.setEnabled(false);
           cboSex.setEnabled(true);
           txtNINO.setEnabled(false);
           dtDateofArriveUK.setEnabled(false);
           lstBenefType.setEnabled(false);
       
       }
    }//GEN-LAST:event_optSexActionPerformed

    private void optNINOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optNINOActionPerformed
           if(optNINO.isSelected()){
           txtSurname.setEnabled(false);
           txtGivenName.setEnabled(false);
           dtDOB.setEnabled(false);
           cboSex.setEnabled(false);
           txtNINO.setEnabled(true);
           dtDateofArriveUK.setEnabled(false);
           lstBenefType.setEnabled(false);
            }
    }//GEN-LAST:event_optNINOActionPerformed

    private void optDateOfArriveUKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDateOfArriveUKActionPerformed
         if(optDateOfArriveUK.isSelected()){
           txtSurname.setEnabled(false);
           txtGivenName.setEnabled(false);
           dtDOB.setEnabled(false);
           cboSex.setEnabled(false);
           txtNINO.setEnabled(false);
           dtDateofArriveUK.setEnabled(true);
           lstBenefType.setEnabled(false);
         }
    }//GEN-LAST:event_optDateOfArriveUKActionPerformed

    private void optBenefTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optBenefTypeActionPerformed
         if(optBenefType.isSelected()){
           txtSurname.setEnabled(false);
           txtGivenName.setEnabled(false);
           dtDOB.setEnabled(false);
           cboSex.setEnabled(false);
           txtNINO.setEnabled(false);
           dtDateofArriveUK.setEnabled(false);
           lstBenefType.setEnabled(true);
         }
    }//GEN-LAST:event_optBenefTypeActionPerformed

    private void optCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optCityActionPerformed
        if(optCity.isSelected()){
             txtAddress1.setEnabled(false);
             txtAddress2.setEnabled(false);
             txtCity.setEnabled(true);
             txtPostCode.setEnabled(false);
             txtTelNO.setEnabled(false);
             txtEmail.setEnabled(false);
             txtTwitter.setEnabled(false);
          }
    }//GEN-LAST:event_optCityActionPerformed

    private void optPostCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optPostCodeActionPerformed
         if(optPostCode.isSelected()){
             txtAddress1.setEnabled(false);
             txtAddress2.setEnabled(false);
             txtCity.setEnabled(false);
             txtPostCode.setEnabled(true);
             txtTelNO.setEnabled(false);
             txtEmail.setEnabled(false);
             txtTwitter.setEnabled(false);
            }
    }//GEN-LAST:event_optPostCodeActionPerformed

    private void optTelNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optTelNoActionPerformed
        if(optTelNo.isSelected()){
             txtAddress1.setEnabled(false);
             txtAddress2.setEnabled(false);
             txtCity.setEnabled(false);
             txtPostCode.setEnabled(false);
             txtTelNO.setEnabled(true);
             txtEmail.setEnabled(false);
             txtTwitter.setEnabled(false);
         }
    }//GEN-LAST:event_optTelNoActionPerformed

    private void optEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEmailActionPerformed
          if(optEmail.isSelected()){
            txtAddress1.setEnabled(false);
             txtAddress2.setEnabled(false);
             txtCity.setEnabled(false);
             txtPostCode.setEnabled(false);
             txtTelNO.setEnabled(false);
             txtEmail.setEnabled(true);
             txtTwitter.setEnabled(false);
            }
    }//GEN-LAST:event_optEmailActionPerformed

    private void optTwitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optTwitterActionPerformed
        if(optTwitter.isSelected()){
             txtAddress1.setEnabled(false);
             txtAddress2.setEnabled(false);
             txtCity.setEnabled(false);
             txtPostCode.setEnabled(false);
             txtTelNO.setEnabled(false);
             txtEmail.setEnabled(false);
             txtTwitter.setEnabled(true);
            }
    }//GEN-LAST:event_optTwitterActionPerformed

    private void optRedioByReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optRedioByReferenceActionPerformed
        JRadioButton button = (JRadioButton) evt.getSource();

        if (button == optRedioByReference)  {
            txtMultiSearch.setText("");
            PromptSupport.setPrompt("Enter student reference No...", txtMultiSearch);
            flag=0;
        }
    }//GEN-LAST:event_optRedioByReferenceActionPerformed

    private void optRedioBySurNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optRedioBySurNameActionPerformed
        JRadioButton button = (JRadioButton) evt.getSource();
        if (button == optRedioBySurName) {
            txtMultiSearch.setText("");
            PromptSupport.setPrompt("Enter beneficiary Surname...", txtMultiSearch);
            flag=1;
        }
    }//GEN-LAST:event_optRedioBySurNameActionPerformed

    private void optRedioByFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optRedioByFirstNameActionPerformed
        JRadioButton button = (JRadioButton) evt.getSource();
        if (button == optRedioByFirstName) {
            txtMultiSearch.setText("");
            PromptSupport.setPrompt("Enter beneficiary given name...", txtMultiSearch);
            flag=2;
        }
    }//GEN-LAST:event_optRedioByFirstNameActionPerformed

    private void txtMultiSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMultiSearchFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMultiSearchFocusGained

    private void txtMultiSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMultiSearchFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMultiSearchFocusLost

    private void txtMultiSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMultiSearchKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER) {
            if(flag==0) {

                // Fill Table
                busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryByReferenceNo(?,?)",
                    txtMultiSearch.getText().trim());
                jScrollPane5.getViewport().add(tblGeneralSearchBenficiary);

            }else if(flag==1) {

                // Fill Table
                busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryBySurName(?,?)",
                    txtMultiSearch.getText().trim());
                jScrollPane5.getViewport().add(tblGeneralSearchBenficiary);

            }else{

                // Fill Table
                busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryByGivenName(?,?)",
                    txtMultiSearch.getText().trim());
                jScrollPane5.getViewport().add(tblGeneralSearchBenficiary);
            }
            txtMultiSearch.setText(null);
            txtMultiSearch.grabFocus();
        }
    }//GEN-LAST:event_txtMultiSearchKeyPressed
/*
    private void popBeneficiaryDetal(String refNo){
        String [] beneficiaryD=null ;
        //get_BeneficiaryDetail
        try{
            
            if(!(StudentReference_No.isEmpty() && tblGeneralSearchBenficiary.getRowCount()==0)){
                
                              
                //asf
                txtSurname.setText(beneficiaryD[1]);
                txtGivenName.setText(beneficiaryD[2]);
                txtNINO.setText(beneficiaryD[7]);

                txtAddress1.setText(beneficiaryD[8]);
                txtAddress2.setText(beneficiaryD[9]);
                txtCity.setText(beneficiaryD[10]);
                txtPostCode.setText(beneficiaryD[11]);
                txtTelNO.setText(beneficiaryD[12]);
                txtEmail.setText(beneficiaryD[13]);
                txtTwitter.setText(beneficiaryD[14]);
                txtVolProfession.setText(beneficiaryD[32]);
                
                txtReferedBy.setText(beneficiaryD[31].toString());
                 
            }else JOptionPane.showMessageDialog(IntFrameEditBeneficiary.this,"Beneficiaries not selected, table null");
        
        }catch(SQLException sqEx){
            JOptionPane.showMessageDialog(IntFrameEditBeneficiary.this,"Error During personal detail loading ");
        }
    }
    */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        if(flag==0) {

            // Fill Table
            busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryByReferenceNo(?,?)",
                txtMultiSearch.getText().trim());
            jScrollPane5.getViewport().add(tblGeneralSearchBenficiary);

        }else if(flag==1) {

            // Fill Table
            busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryBySurName(?,?)",
                txtMultiSearch.getText().trim());
            jScrollPane5.getViewport().add(tblGeneralSearchBenficiary);

        }else{

            // Fill Table
            busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryByGivenName(?,?)",
                txtMultiSearch.getText().trim());
            jScrollPane5.getViewport().add(tblGeneralSearchBenficiary);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void optEmpStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEmpStatusActionPerformed
        if(optEmpStatus.isSelected()){
            cboEmpStatus.setEnabled(true);
            cboTotalIncome.setEnabled(false);
            cboLiveIn.setEnabled(false);
            cboReciptBenefit.setEnabled(false);
            cboRelegion.setEnabled(false);
            cboSexOrient.setEnabled(false);
            cboEthnicity.setEnabled(false);
            cboEthnicityBack.setEnabled(false);
            txtReferedBy.setEnabled(false);
         }
    }//GEN-LAST:event_optEmpStatusActionPerformed

    private void optTotalIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optTotalIncomeActionPerformed
       if(optTotalIncome.isSelected()){
            cboEmpStatus.setEnabled(false);
            cboTotalIncome.setEnabled(true);
            cboLiveIn.setEnabled(false);
            cboReciptBenefit.setEnabled(false);
            cboRelegion.setEnabled(false);
            cboSexOrient.setEnabled(false);
            cboEthnicity.setEnabled(false);
            cboEthnicityBack.setEnabled(false);
            txtReferedBy.setEnabled(false);
         }
    }//GEN-LAST:event_optTotalIncomeActionPerformed

    private void optLiveINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optLiveINActionPerformed
        if(optLiveIN.isSelected()){
            cboEmpStatus.setEnabled(false);
            cboTotalIncome.setEnabled(false);
            cboLiveIn.setEnabled(true);
            cboReciptBenefit.setEnabled(false);
            cboRelegion.setEnabled(false);
            cboSexOrient.setEnabled(false);
            cboEthnicity.setEnabled(false);
            cboEthnicityBack.setEnabled(false);
            txtReferedBy.setEnabled(false);
            
         }
    }//GEN-LAST:event_optLiveINActionPerformed

    private void optReciptBenefitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optReciptBenefitActionPerformed
        if(optReciptBenefit.isSelected()){
            cboEmpStatus.setEnabled(false);
            cboTotalIncome.setEnabled(false);
            cboLiveIn.setEnabled(false);
            cboReciptBenefit.setEnabled(true);
            cboRelegion.setEnabled(false);
            cboSexOrient.setEnabled(false);
            cboEthnicity.setEnabled(false);
            cboEthnicityBack.setEnabled(false);
            txtReferedBy.setEnabled(false);
         }
    }//GEN-LAST:event_optReciptBenefitActionPerformed

    private void optReleionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optReleionActionPerformed
       if(optReleion.isSelected()){
            cboEmpStatus.setEnabled(false);
            cboTotalIncome.setEnabled(false);
            cboLiveIn.setEnabled(false);
            cboReciptBenefit.setEnabled(false);
            cboRelegion.setEnabled(true);
            cboSexOrient.setEnabled(false);
            cboEthnicity.setEnabled(false);
            cboEthnicityBack.setEnabled(false);
            txtReferedBy.setEnabled(false);
         }
    }//GEN-LAST:event_optReleionActionPerformed

    private void optSexualOrientationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optSexualOrientationActionPerformed
         if(optSexualOrientation.isSelected()){
            cboEmpStatus.setEnabled(false);
            cboTotalIncome.setEnabled(false);
            cboLiveIn.setEnabled(false);
            cboReciptBenefit.setEnabled(false);
            cboRelegion.setEnabled(false);
            cboSexOrient.setEnabled(true);
            cboEthnicity.setEnabled(false);
            cboEthnicityBack.setEnabled(false);
            txtReferedBy.setEnabled(false);
         }
    }//GEN-LAST:event_optSexualOrientationActionPerformed

    private void optEthnicityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEthnicityActionPerformed
        if(optEthnicity.isSelected()){
            cboEmpStatus.setEnabled(false);
            cboTotalIncome.setEnabled(false);
            cboLiveIn.setEnabled(false);
            cboReciptBenefit.setEnabled(false);
            cboRelegion.setEnabled(false);
            cboSexOrient.setEnabled(false);
            cboEthnicity.setEnabled(true);
            cboEthnicityBack.setEnabled(false);
            txtReferedBy.setEnabled(false);
         }
    }//GEN-LAST:event_optEthnicityActionPerformed

    private void optEthnicityBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEthnicityBackActionPerformed
        if(optEthnicityBack.isSelected()){
            cboEmpStatus.setEnabled(false);
            cboTotalIncome.setEnabled(false);
            cboLiveIn.setEnabled(false);
            cboReciptBenefit.setEnabled(false);
            cboRelegion.setEnabled(false);
            cboSexOrient.setEnabled(false);
            cboEthnicity.setEnabled(false);
            cboEthnicityBack.setEnabled(true);
            txtReferedBy.setEnabled(false);
         }
    }//GEN-LAST:event_optEthnicityBackActionPerformed

    private void optReferdByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optReferdByActionPerformed
        if(optReferdBy.isSelected()){
            cboEmpStatus.setEnabled(false);
            cboTotalIncome.setEnabled(false);
            cboLiveIn.setEnabled(false);
            cboReciptBenefit.setEnabled(false);
            cboRelegion.setEnabled(false);
            cboSexOrient.setEnabled(false);
            cboEthnicity.setEnabled(false);
            cboEthnicityBack.setEnabled(false);
            txtReferedBy.setEnabled(true);
         }
    }//GEN-LAST:event_optReferdByActionPerformed

    private void btnSaveChangeOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangeOtherActionPerformed
         
        switch (getSelectedButtonText(buttonGroupOther)){
            case "Disability Status:":
                editInfo("PERSONAL_INFO", "DISABILITY", get_DisabilityStatus(),StudentReference_No);
                break;
            case "Disability Nature": 
                editInfo("PERSONAL_INFO", "DISABILITY_NATU", get_DisabilityNature(),StudentReference_No);
                break; 
            case "Equality": 
                editInfo("PERSON_BACKGROUND", "EQUALITY",get_DisadvntageGroup(),StudentReference_No);
                break;
            case "Vol. Start Date": 
                set_VolStartDate();
                editInfo("ADDITIONAL_INFO", "VOL_START_DATE", utiObj.sql_Date(get_VolStartDate()),StudentReference_No);
                break; 
            case "Vol. End Date": 
                set_VolEndDate();
                editInfo("ADDITIONAL_INFO", "VOL_END_DATE", utiObj.sql_Date(get_VolEndDate()),StudentReference_No);
                break; 
            case "Vol. Profession": 
                set_VolProfession();
                editInfo("ADDITIONAL_INFO", "VOL_PROFESSION", get_VolProfession(),StudentReference_No);
                break;
            case "Registration Date":  
                set_RegistrationDate();
                editInfo("ADDITIONAL_INFO", "DATE_REGISTER", utiObj.sql_Date(get_RegistrationDate()),StudentReference_No);
                break;
       }
        
    }//GEN-LAST:event_btnSaveChangeOtherActionPerformed

    private void optDisabilityNatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDisabilityNatureActionPerformed
        if(optDisabilityNature.isSelected()){
            lstDisabilityStatus.setEnabled(false);
            lstDisabilityNature.setEnabled(true);
            lstEquality.setEnabled(false);
            dtVolStartDate.setEnabled(false);
            dtVolEndDate.setEnabled(false);
            txtVolProfession.setEnabled(false);
            dtRegistrationDate.setEnabled(false);
           
         }
    }//GEN-LAST:event_optDisabilityNatureActionPerformed

    private void optDisabilityStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDisabilityStatusActionPerformed
       if(optDisabilityStatus.isSelected()){
            lstDisabilityStatus.setEnabled(true);
            lstDisabilityNature.setEnabled(false);
            lstEquality.setEnabled(false);
            dtVolStartDate.setEnabled(false);
            dtVolEndDate.setEnabled(false);
            txtVolProfession.setEnabled(false);
            dtRegistrationDate.setEnabled(false);
           
         }
    }//GEN-LAST:event_optDisabilityStatusActionPerformed

    private void optEqualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEqualityActionPerformed
        if(optEquality.isSelected()){
            lstDisabilityStatus.setEnabled(false);
            lstDisabilityNature.setEnabled(false);
            lstEquality.setEnabled(true);
            dtVolStartDate.setEnabled(false);
            dtVolEndDate.setEnabled(false);
            txtVolProfession.setEnabled(false);
            dtRegistrationDate.setEnabled(false);
           
         }
    }//GEN-LAST:event_optEqualityActionPerformed

    private void optVolEndDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optVolEndDateActionPerformed
       if(optVolEndDate.isSelected()){
            lstDisabilityStatus.setEnabled(false);
            lstDisabilityNature.setEnabled(false);
            lstEquality.setEnabled(false);
            dtVolStartDate.setEnabled(false);
            dtVolEndDate.setEnabled(true);
            txtVolProfession.setEnabled(false);
            dtRegistrationDate.setEnabled(false);
           
         }
    }//GEN-LAST:event_optVolEndDateActionPerformed

    private void optVolSartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optVolSartDateActionPerformed
        if(optVolSartDate.isSelected()){
            lstDisabilityStatus.setEnabled(false);
            lstDisabilityNature.setEnabled(false);
            lstEquality.setEnabled(false);
            dtVolStartDate.setEnabled(true);
            dtVolEndDate.setEnabled(false);
            txtVolProfession.setEnabled(false);
            dtRegistrationDate.setEnabled(false);
           
         }
    }//GEN-LAST:event_optVolSartDateActionPerformed

    private void optRegistrationDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optRegistrationDateActionPerformed
        if(optRegistrationDate.isSelected()){
            lstDisabilityStatus.setEnabled(false);
            lstDisabilityNature.setEnabled(false);
            lstEquality.setEnabled(false);
            dtVolStartDate.setEnabled(false);
            dtVolEndDate.setEnabled(false);
            txtVolProfession.setEnabled(false);
            dtRegistrationDate.setEnabled(true);
           
         }
    }//GEN-LAST:event_optRegistrationDateActionPerformed

    private void optVolProfessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optVolProfessionActionPerformed
        
        if(optVolProfession.isSelected()){
            
            lstDisabilityStatus.setEnabled(false);
            lstDisabilityNature.setEnabled(false);
            lstEquality.setEnabled(false);
            dtVolStartDate.setEnabled(false);
            dtVolEndDate.setEnabled(false);
            txtVolProfession.setEnabled(true);
            dtRegistrationDate.setEnabled(false);
            
         }
    }//GEN-LAST:event_optVolProfessionActionPerformed

    private void btnDeletBeneficiaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletBeneficiaryActionPerformed
      
      JDialog.setDefaultLookAndFeelDecorated(true);
        
      try{
           
            if(!(StudentReference_No==null)){
                
               int response = JOptionPane.showConfirmDialog(IntFrameEditBeneficiary.this, "Are you shure you want to delete the record?", "Confirm",
                        
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            busObj.delet_Beneficiary(StudentReference_No,proc_DeletBeneficiary);
                            JOptionPane.showMessageDialog(IntFrameEditBeneficiary.this, "Data Delete Successfully ! ","Deleting Data",JOptionPane.INFORMATION_MESSAGE);
                           
                        }
           } else JOptionPane.showMessageDialog(IntFrameEditBeneficiary.this,"Beneficiary being delete is not selected !");
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameEditBeneficiary.this,"Null selection! Error: ");}
    }//GEN-LAST:event_btnDeletBeneficiaryActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       utility.flag10=false;
    }//GEN-LAST:event_formInternalFrameClosed

   
    private void btnSaveChangeBasicinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangeBasicinfoActionPerformed
       
        switch (getSelectedButtonText(buttonGroupBesicInfo)){
            case "Surname":
                set_SurName();
                editInfo("BENEFICIARIES", "SURNAME", get_SurName(),StudentReference_No);
                break;
            case "Given Name": 
                set_GivenName();
                editInfo("BENEFICIARIES", "GIVEN_NAME", get_GivenName(),StudentReference_No);
                break;
            case "Date of Birth": 
                set_DOB();
                editInfo("BENEFICIARIES", "DATE_OF_BIRTH", utiObj.sql_Date(get_DOB()),StudentReference_No);
                break;
            case "Sex": 
                set_Gender();
                editInfo("BENEFICIARIES", "SEX", get_Gender(),StudentReference_No);
                break; 
            case "NI. NO": 
                set_NationalInsu();
                editInfo("BENEFICIARIES", "INSURANCE_NO", get_NationalInsu(),StudentReference_No);
                break; 
            case "Date Into UK": 
                set_DateEntry();
                editInfo("ADDITIONAL_INFO", "DATE_ARRIVEUK", utiObj.sql_Date(get_DateEntry()),StudentReference_No);
                break;
            case "Beneficiary Type":  
                editInfo("ADDITIONAL_INFO", "BENEF_TYPE", get_VolType(),StudentReference_No);
                break;
        }
       
    }//GEN-LAST:event_btnSaveChangeBasicinfoActionPerformed

    private void btnSaveChangeBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangeBackgroundActionPerformed
      switch (getSelectedButtonText(buttonGroupBackground)){
            case "Employement Status":
                set_EmpStatus();
                editInfo("PERSON_BACKGROUND", "EMP_STATUS_ID", String.valueOf(get_EmpStatus()),StudentReference_No);
                break;
            case "Total household Income": 
                set_TotalIncome();
                editInfo("PERSON_BACKGROUND", "INCOME_ID", String.valueOf(get_TotalIncome()),StudentReference_No);
                break;
            case "Live IN": 
                set_LiveIn();
                editInfo("PERSON_BACKGROUND", "LIVING_IN_ID",String.valueOf(get_LiveIn()),StudentReference_No);
                break;
            case "Recipt of Benefit": 
                set_ReceiptBenefit();
                editInfo("PERSON_BACKGROUND", "BENEFIT_ID", String.valueOf(get_ReceiptBenefit()),StudentReference_No);
                break; 
            case "Religion": 
                set_Relegion();
                editInfo("BENEFICIARIES", "RELIGION_ID", String.valueOf(get_Relegion()),StudentReference_No);
                break; 
            case "Sexual Orientaion:": 
                set_SexualOrientaion();
                editInfo("BENEFICIARIES", "SEX_ORIENT_ID", String.valueOf(get_SexualOrientaion()),StudentReference_No);
                break;
            case "Ethnicity":  
                set_Ethnicity();
                editInfo("PERSONAL_INFO", "ETHN_ID", String.valueOf(get_Ethnicity()),StudentReference_No);
                break;
            case "Ethnic Background":  
                set_EthnicityBackground();
                editInfo("PERSONAL_INFO", "ETHN_BAK_ID", String.valueOf(get_EthnicityBackground()),StudentReference_No);
                break;
           case "Refered By:":  
                set_ReferedBy();
                editInfo("ADDITIONAL_INFO", "REFER_BY", get_ReferedBy(),StudentReference_No);
                break;

       }
    }//GEN-LAST:event_btnSaveChangeBackgroundActionPerformed

    private void btnSaveChangeAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangeAddressActionPerformed
        
        switch (getSelectedButtonText(buttonGroupAddress)){
            case "Address 1":
                set_Address1();
                editInfo("ADDRESS", "ADDRESS_1", get_Address1(),StudentReference_No);
                break;
            case "Address 2": 
                set_Address2();
                editInfo("ADDRESS", "ADDRESS_2", get_Address2(),StudentReference_No);
                break;
            case "City": 
                set_City();
                editInfo("ADDRESS", "CITY",get_City(),StudentReference_No);
                break;
            case "Post Code": 
                set_PostalCode();
                editInfo("ADDRESS", "POSTAL_CODE", get_PostalCode(),StudentReference_No);
                break; 
            case "Tel. No": 
                set_TelNo();
                editInfo("ADDRESS", "TEL_NO", get_TelNo(),StudentReference_No);
                break; 
            case "Email": 
                set_Email();
                editInfo("ADDRESS", "EMAIL", get_Email(),StudentReference_No);
                break;
            case "Twitter":  
                set_Twitter();
                editInfo("ADDRESS", "TWITTER", get_Twitter(),StudentReference_No);
                break;
        }
    }//GEN-LAST:event_btnSaveChangeAddressActionPerformed

    private void lstDisabilityStatusValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDisabilityStatusValueChanged
                    if(!evt.getValueIsAdjusting()) {
                     disability_Status = lstDisabilityStatus.getSelectedValuesList();
                   }
    }//GEN-LAST:event_lstDisabilityStatusValueChanged

    private void lstDisabilityNatureValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDisabilityNatureValueChanged
        if(!evt.getValueIsAdjusting()) {
              disability_Nature = lstDisabilityNature.getSelectedValuesList();
        }
    }//GEN-LAST:event_lstDisabilityNatureValueChanged

    private void lstEqualityValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEqualityValueChanged
        if(!evt.getValueIsAdjusting()) {
        }
    }//GEN-LAST:event_lstEqualityValueChanged
    private void Tbl_SelectionMode(final JTable table,final String tbl_Name){
           
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
                if (ALLOW_ROW_SELECTION) { // true by default
                  ListSelectionModel rowSM = table.getSelectionModel();
                  rowSM.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                      // Ignore extra messages.
                      if (e.getValueIsAdjusting())
                        return;

                      ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                    
                         if (!(lsm.isSelectionEmpty())){
                              selectedRow = lsm.getMinSelectionIndex();
                              printDebugData(table,selectedRow,tbl_Name);

                          }
                        
                    }
                  });
                } else {
                  table.setRowSelectionAllowed(false);
                }
             
    }
    
    private void printDebugData(JTable table,int selcted_Row,String tbl_Name) {
       try{ 
       // int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
      
                StudentReference_No=String.valueOf(model.getValueAt(selcted_Row, 0).toString());
                lblStudentRefNo.setText(StudentReference_No);
                
        }catch(Exception ex){
            JOptionPane.showMessageDialog(IntFrameEditBeneficiary.this, "The table is Empety ! Error: " + ex);
        }
  }
  
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    
    public void editInfo(String tableName,String columnName,String newValu,String studentRefno){
    JDialog.setDefaultLookAndFeelDecorated(true);
        try{

        int response = JOptionPane.showConfirmDialog(IntFrameEditBeneficiary.this, "Are you shure you want to Edit the record?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {

                    busObj.update_BeneficiariesInfo(tableName,columnName,newValu,studentRefno);

                    JOptionPane.showMessageDialog(IntFrameEditBeneficiary.this, "Data Update Successfully ! ","Update Data",JOptionPane.INFORMATION_MESSAGE);
                   
                }
                }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameEditBeneficiary.this,"Null selection! Error: ");}
    }
    
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletBeneficiary;
    private javax.swing.JButton btnSaveChangeAddress;
    private javax.swing.JButton btnSaveChangeBackground;
    private javax.swing.JButton btnSaveChangeBasicinfo;
    private javax.swing.JButton btnSaveChangeOther;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroupAddress;
    private javax.swing.ButtonGroup buttonGroupBackground;
    private javax.swing.ButtonGroup buttonGroupBesicInfo;
    private javax.swing.ButtonGroup buttonGroupOther;
    private javax.swing.ButtonGroup buttonGroupSearch;
    private javax.swing.JComboBox cboEmpStatus;
    private javax.swing.JComboBox cboEthnicity;
    private javax.swing.JComboBox cboEthnicityBack;
    private javax.swing.JComboBox cboLiveIn;
    private javax.swing.JComboBox cboReciptBenefit;
    private javax.swing.JComboBox cboRelegion;
    private javax.swing.JComboBox cboSex;
    private javax.swing.JComboBox cboSexOrient;
    private javax.swing.JComboBox cboTotalIncome;
    private com.toedter.calendar.JDateChooser dtDOB;
    private com.toedter.calendar.JDateChooser dtDateofArriveUK;
    private com.toedter.calendar.JDateChooser dtRegistrationDate;
    private com.toedter.calendar.JDateChooser dtVolEndDate;
    private com.toedter.calendar.JDateChooser dtVolStartDate;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblStudentRefNo;
    private javax.swing.JList lstBenefType;
    private javax.swing.JList lstDisabilityNature;
    private javax.swing.JList lstDisabilityStatus;
    private javax.swing.JList lstEquality;
    private javax.swing.JRadioButton optAddress1;
    private javax.swing.JRadioButton optAddress2;
    private javax.swing.JRadioButton optBenefType;
    private javax.swing.JRadioButton optCity;
    private javax.swing.JRadioButton optDOB;
    private javax.swing.JRadioButton optDateOfArriveUK;
    private javax.swing.JRadioButton optDisabilityNature;
    private javax.swing.JRadioButton optDisabilityStatus;
    private javax.swing.JRadioButton optEmail;
    private javax.swing.JRadioButton optEmpStatus;
    private javax.swing.JRadioButton optEquality;
    private javax.swing.JRadioButton optEthnicity;
    private javax.swing.JRadioButton optEthnicityBack;
    private javax.swing.JRadioButton optGivenName;
    private javax.swing.JRadioButton optLiveIN;
    private javax.swing.JRadioButton optNINO;
    private javax.swing.JRadioButton optPostCode;
    private javax.swing.JRadioButton optReciptBenefit;
    private javax.swing.JRadioButton optRedioByFirstName;
    private javax.swing.JRadioButton optRedioByReference;
    private javax.swing.JRadioButton optRedioBySurName;
    private javax.swing.JRadioButton optReferdBy;
    private javax.swing.JRadioButton optRegistrationDate;
    private javax.swing.JRadioButton optReleion;
    private javax.swing.JRadioButton optSex;
    private javax.swing.JRadioButton optSexualOrientation;
    private javax.swing.JRadioButton optSurname;
    private javax.swing.JRadioButton optTelNo;
    private javax.swing.JRadioButton optTotalIncome;
    private javax.swing.JRadioButton optTwitter;
    private javax.swing.JRadioButton optVolEndDate;
    private javax.swing.JRadioButton optVolProfession;
    private javax.swing.JRadioButton optVolSartDate;
    private javax.swing.JTable tblGeneralSearchBenficiary;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtAddress2;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGivenName;
    private javax.swing.JTextField txtMultiSearch;
    private javax.swing.JFormattedTextField txtNINO;
    private javax.swing.JTextField txtPostCode;
    private javax.swing.JTextField txtReferedBy;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JFormattedTextField txtTelNO;
    private javax.swing.JTextField txtTwitter;
    private javax.swing.JTextField txtVolProfession;
    // End of variables declaration//GEN-END:variables
}
