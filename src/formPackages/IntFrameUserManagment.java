/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages;

import formPackages.classPackages.businessLayer;
import formPackages.classPackages.utility;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author jo
 */
public class IntFrameUserManagment extends javax.swing.JInternalFrame {

      
      private String surName;
      private String givenName;
      private String gender;
      private Date dateOfBirth;
      
      private String userName;
      private char [] password;
      private char []  rePassword;
      private String userIDDeleted;
      private List<String> grantUserContent;
      
      private String privilage;
      DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
      private String proc_UserID="SELECT_DATA_PACKAGE.get_UserIDName(?)"; 
      private String proc_surNameGivenName="SELECT_DATA_PACKAGE.get_AllUserInfo(?,?)"; 
      private String proc_DeletUserAccount="{call Update_Data_Package.delete_UserAccount(?,?)}"; 
      
      businessLayer busObj = new businessLayer();
      utility utilObj =new utility();
    
   public IntFrameUserManagment() {
        initComponents();
        busObj.pop_List(lstUserNames,proc_UserID,0);
        
    }
   
   private void set_Surname(){
       surName=txtSurnName.getText();
   }
   private String get_Surname(){
       return surName;
   }
   
   private void set_GivenName(){
       givenName=txtGivenName.getText();
   }
   private String get_GivenName(){
       return givenName;
   }
   
   private void set_gender(){
       gender=cboGeneer.getSelectedItem().toString();
   }
   private String get_gender(){
       return gender;
   }
   
    private void set_DOB(){
       try{
            String  feachDate=dateFormat.format(dtDOB.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            dateOfBirth= feachdate;
            
        }catch(Exception ex){
            utilObj.setToolTip(dtDOB, "Date of Birth Date error ! Error :" + ex);
        } 
   }
   private Date get_DOB(){
       return dateOfBirth;
   }
   
   private void set_userName(){
    
       userName= utilObj.generateBeneficiaryID(3, "USR", busObj.set_SeqNextVal(1));
       txtUserName.setText(userName);
   }
   private String get_userName(){
       return userName;
   }
   
   private void set_password(){
       password=txtPassword.getPassword();
   }
   private char []  get_password(){
       return password;
   }
   
   private void set_rePassword(){
       rePassword=txtRePassword.getPassword();
   }
   private char []  get_rePassword(){
       return rePassword;
   }
   
   private void set_AccessLevel(){
      privilage =cboAccessLevel.getSelectedItem().toString();
   }
   private String get_AccessLevel(){
       return privilage;
   }
   
   private void set_userIDDeleted(){
      userIDDeleted=lstUserNames.getSelectedValue().toString();
    }
   private String get_userIDDeleted(){
       return userIDDeleted;
   }
   
   private String get_GrantUserContent(){
       String temp_String="";
            
            if (!(lstGrantUser.isSelectionEmpty())){
                  for (String v : grantUserContent) {
                     temp_String=temp_String + v.trim() +",";
                  }
                  temp_String=temp_String.substring(0, temp_String.length()-1).trim();
            }
            return temp_String;
       
   }
   private boolean checkReturnPasswordMach(char[] password, char [] rePassword){
        //har[] pass = passField.getPassword();
        String passString = new String(password);
        String rePasswordString =new String(rePassword);
            if (passString.equals(rePasswordString))
                return true;
            else
                return false;
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMnuUserManagment = new javax.swing.JPopupMenu();
        popMnuEditAccount = new javax.swing.JRadioButtonMenuItem();
        popMnuDeleteAccount = new javax.swing.JRadioButtonMenuItem();
        rBtnGroupUser = new javax.swing.ButtonGroup();
        rBtnGroupModifyAcc = new javax.swing.ButtonGroup();
        buttonGroupNewDelete = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtSurnName = new javax.swing.JTextField();
        txtGivenName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboGeneer = new javax.swing.JComboBox();
        dtDOB = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        txtUserName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboAccessLevel = new javax.swing.JComboBox();
        txtPassword = new javax.swing.JPasswordField();
        txtRePassword = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstGrantUser = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstUserNames = new javax.swing.JList();
        btnCreateAccount = new javax.swing.JButton();
        btnModifyAccount = new javax.swing.JButton();
        optNewAccount = new javax.swing.JRadioButton();
        optDeleteAccount = new javax.swing.JRadioButton();

        popMnuUserManagment.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        popMnuEditAccount.setSelected(true);
        popMnuEditAccount.setText("Edit Account");
        popMnuUserManagment.add(popMnuEditAccount);

        popMnuDeleteAccount.setSelected(true);
        popMnuDeleteAccount.setText("Delete Account");
        popMnuUserManagment.add(popMnuDeleteAccount);

        setClosable(true);
        setIconifiable(true);
        setTitle("Mange System User");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/UserManagment.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSurnName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtSurnName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSurnNameKeyTyped(evt);
            }
        });

        txtGivenName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtGivenName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGivenNameKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Surname");

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Given Name");

        jLabel4.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel4.setText("Gender");

        jLabel5.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Date of Birth");

        cboGeneer.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboGeneer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male,", "Female" }));
        cboGeneer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        dtDOB.setPreferredSize(new java.awt.Dimension(96, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSurnName)
                    .addComponent(txtGivenName)
                    .addComponent(cboGeneer, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSurnName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGivenName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cboGeneer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtUserName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtUserName.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("User Name");

        jLabel8.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel9.setText("Access Lavel");

        cboAccessLevel.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboAccessLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Staff", "Volunteer" }));
        cboAccessLevel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPassword.setToolTipText("Enter the Password .");

        txtRePassword.setToolTipText("Enter the Password .");

        jLabel10.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Retype Password");

        lstGrantUser.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Register Student", "Search Student", "Manage Student Course", "Manage Student", "Manage Attendance", "Manage Course and Event", "Manage Additional Parameters", "Generate Student/Volunteer ID", "Manage System User", "Database Connection Setting", "Generate Reports", "View All Beneficiary" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstGrantUser.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstGrantUserValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstGrantUser);

        jLabel11.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel11.setText("Grant system user");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRePassword)
                            .addComponent(cboAccessLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtPassword)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtPassword, txtRePassword, txtUserName});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboAccessLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtPassword, txtRePassword, txtUserName});

        lstUserNames.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstUserNames.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstUserNames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstUserNames.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUserNamesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstUserNames);

        btnCreateAccount.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnCreateAccount.setText("Create Account");
        btnCreateAccount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCreateAccount.setEnabled(false);
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        btnModifyAccount.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnModifyAccount.setText("Delete Account");
        btnModifyAccount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModifyAccount.setEnabled(false);
        btnModifyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyAccountActionPerformed(evt);
            }
        });

        buttonGroupNewDelete.add(optNewAccount);
        optNewAccount.setText("New Account");
        optNewAccount.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optNewAccountItemStateChanged(evt);
            }
        });

        buttonGroupNewDelete.add(optDeleteAccount);
        optDeleteAccount.setText("Delete Account");
        optDeleteAccount.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optDeleteAccountItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(optNewAccount)
                        .addGap(18, 18, 18)
                        .addComponent(optDeleteAccount))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnModifyAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModifyAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optNewAccount)
                    .addComponent(optDeleteAccount))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Create System Account", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSurnNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurnNameKeyTyped
        char ch=evt.getKeyChar(); 
        if(Character.isDigit(ch)){
            getToolkit().beep();
            utilObj.showErrorMessage(txtSurnName, "Only Character is alowed ! (A-Z)");
            evt.consume();
         }
    }//GEN-LAST:event_txtSurnNameKeyTyped

    private void txtGivenNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGivenNameKeyTyped
        char ch=evt.getKeyChar(); 
        if(Character.isDigit(ch)){
            getToolkit().beep();
            utilObj.showErrorMessage(txtGivenName, "Only Character is alowed ! (A-Z)");
            evt.consume();
         }
    }//GEN-LAST:event_txtGivenNameKeyTyped

    private void optNewAccountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optNewAccountItemStateChanged
        
        if(optNewAccount.isSelected()){
            int response = JOptionPane.showConfirmDialog(IntFrameUserManagment.this, "Do you want to Create an account?", "Confirm",
                         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                            if (response == JOptionPane.YES_OPTION) {
                                    clearFiled();
                                    set_userName();
                                    btnCreateAccount.setEnabled(true);
                            }else 
                                    buttonGroupNewDelete.clearSelection();
        
        }
        else 
            btnCreateAccount.setEnabled(false);
    }//GEN-LAST:event_optNewAccountItemStateChanged

    private void optDeleteAccountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optDeleteAccountItemStateChanged
       
        if(optDeleteAccount.isSelected())
            btnModifyAccount.setEnabled(true);
        else 
            btnModifyAccount.setEnabled(false);
    }//GEN-LAST:event_optDeleteAccountItemStateChanged

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        try{
               if(optNewAccount.isSelected()){
                   set_Surname();
                   set_GivenName();
                   set_gender();
                   set_DOB();
                   set_password();
                   set_rePassword();
                   set_AccessLevel();
                   
                   if(!(get_Surname()==""|| get_GivenName()=="" )){
                        if(checkReturnPasswordMach(get_password(), get_rePassword())){
                            int response = JOptionPane.showConfirmDialog(IntFrameUserManagment.this, "Are you sure to Create an account?", "Confirm",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                            if (response == JOptionPane.YES_OPTION) {
                               
                                busObj.insert_NewAccount(get_userName(), 
                                                        get_Surname(),
                                                        get_GivenName(),
                                                        get_gender(),
                                                        utilObj.sql_Date(get_DOB()));
                                busObj.insert_LoginData(get_userName(),
                                                        get_userName(),
                                                        new String(get_password()));
                                busObj.insert_accessData(get_userName(),
                                                        get_AccessLevel(),
                                                        get_GrantUserContent());


                                lstUserNames.removeAll();
                                busObj.pop_List(lstUserNames,proc_UserID,0);

                                JOptionPane.showMessageDialog( IntFrameUserManagment.this,"Account Created Successfully !, Please Note your USER NAME and PASSWORD");
                                buttonGroupNewDelete.clearSelection();
                            }
                            
                        }else
                            JOptionPane.showMessageDialog( IntFrameUserManagment.this,"Password Dose not mach");
                   }else 
                       JOptionPane.showMessageDialog( IntFrameUserManagment.this,"Surname and Given name should not be null");
               
                   
               }
        }catch(Exception ex){
                JOptionPane.showMessageDialog( IntFrameUserManagment.this,"Error During Account Creation");
                                      
        }
        
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void btnModifyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyAccountActionPerformed
        try{
               if(optDeleteAccount.isSelected()){
                     if(!(txtUserName.getText()=="")){
                         
                         int response = JOptionPane.showConfirmDialog(IntFrameUserManagment.this, "Do you want to DELETE the record?", "Confirm",
                         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                            if (response == JOptionPane.YES_OPTION) {
                                set_userIDDeleted();
                                
                                busObj.delete_UserAccount(get_userIDDeleted(),proc_DeletUserAccount);
                                
                                txtUserName.setText("");
                                txtSurnName.setText("");
                                txtGivenName.setText("");
                                buttonGroupNewDelete.clearSelection();
                                
                                lstUserNames.removeAll();
                                busObj.pop_List(lstUserNames,proc_UserID,0);

                                JOptionPane.showMessageDialog( IntFrameUserManagment.this,"Account Deleted Successfully !");
                                buttonGroupNewDelete.clearSelection();
                            }
                            
                       }else
                         JOptionPane.showMessageDialog( IntFrameUserManagment.this,"User should be selected to delete");
                   }
                
        }catch(Exception ex){
               // JOptionPane.showMessageDialog( IntFrameUserManagment.this,"Error During Account Deletion, Error "+ex );
                                      
        }
    }//GEN-LAST:event_btnModifyAccountActionPerformed

    private void clearFiled(){
        txtSurnName.setText("");
        txtGivenName.setText("");
        txtUserName.setText("");
        txtPassword.setText("");
        txtRePassword.setText("");
    }
    private void popUser(String userId){
        try{
        busObj.get_userSurGivenName(userId, proc_surNameGivenName,txtUserName, txtSurnName, txtGivenName);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(IntFrameUserManagment.this, "Error during User selection");
        }
    }
    private void lstUserNamesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUserNamesValueChanged
        clearFiled();
        popUser(lstUserNames.getSelectedValue().toString().trim());
        
    }//GEN-LAST:event_lstUserNamesValueChanged

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        utilObj.flag6=false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void lstGrantUserValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstGrantUserValueChanged
                   if(!evt.getValueIsAdjusting()) {
                     grantUserContent = lstGrantUser.getSelectedValuesList();
                   }
    }//GEN-LAST:event_lstGrantUserValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnModifyAccount;
    private javax.swing.ButtonGroup buttonGroupNewDelete;
    private javax.swing.JComboBox cboAccessLevel;
    private javax.swing.JComboBox cboGeneer;
    private com.toedter.calendar.JDateChooser dtDOB;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList lstGrantUser;
    private javax.swing.JList lstUserNames;
    private javax.swing.JRadioButton optDeleteAccount;
    private javax.swing.JRadioButton optNewAccount;
    private javax.swing.JRadioButtonMenuItem popMnuDeleteAccount;
    private javax.swing.JRadioButtonMenuItem popMnuEditAccount;
    private javax.swing.JPopupMenu popMnuUserManagment;
    private javax.swing.ButtonGroup rBtnGroupModifyAcc;
    private javax.swing.ButtonGroup rBtnGroupUser;
    private javax.swing.JTextField txtGivenName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtRePassword;
    private javax.swing.JTextField txtSurnName;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
