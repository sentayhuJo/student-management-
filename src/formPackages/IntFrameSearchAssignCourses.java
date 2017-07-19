/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages;

import formPackages.classPackages.businessLayer;

import static formPackages.classPackages.businessLayer.IDholder_CourseName;
import formPackages.classPackages.utility;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JButton;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author jo
 */
public class IntFrameSearchAssignCourses extends javax.swing.JInternalFrame {

    private String proc_TargetNames="SELECT_DATA_PACKAGE.get_Blf_ProjectTarget(?)";
    private String proc_CourseInTarget="SELECT_DATA_PACKAGE.get_CourseInTarget(?,?)";
    private String proc_deleteCourseAssi="{call Update_Data_Package.delete_ASSIGNCOURSE(?,?,?)}";
    
    private Date date_Exam;
    private Date date_Exam_Registration;
    
    private String exam_Status;
    private int course_IDForExam;
    private int courseID_assigned;
    private int course_IDforCertificate;
    private String attendStatus;
    
    private boolean ALLOW_ROW_SELECTION =true;
    private int selectedRow;
    private static int flag=0;
    private static String StudentReference_No;
    private int course_ID;
    private String vulDescrition;
    private String vulWhomeReport;
    private Date date_VulRegisterd;
    
    private String certificate_Type;
    private String status;
    private String isCertificateReady;
    private Date date_Collected;
    
    
    private static final String NOT_SELECTABLE_OPTION="Select...";
    
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
    
    businessLayer busObj=new businessLayer();
    utility utilObj=new utility();
    
    public IntFrameSearchAssignCourses() {
        initComponents();
        
        utilObj.connect();
        
        PromptSupport.setPrompt("Enter Reference No...", txtMultiSearch);
        
        selectCombo(cboTargateNameSearch);
        busObj.pop_Combo(cboTargateNameSearch, proc_TargetNames, "cboTargateNameSearch");
        //if(cboTargateNameSearch.getItemCount() != 0)cboTargateNameSearch.setSelectedIndex(1);
        
        Tbl_SelectionMode(tblGeneralSearchBenficiary,"tblGeneralSearchBenficiary");
        Tbl_SelectionMode(tblViewStudentCourseExamSchedule,"tblViewStudentCourseExamSchedule");
        Tbl_SelectionMode(tblCertificate, "tblCertificate");
        Tbl_SelectionMode(tblViewStudentCourse, "tblViewStudentCourse");
        
        prit_TblData(tblGeneralSearchBenficiary, btnPrintGeneralSearch ); 
        prit_TblData(tblViewStudentCourse,btnPrintTakenCourse); 
        prit_TblData(tblViewStudentCourseExamSchedule,btnExamSchedulePrint); 
        prit_TblData(tblVewVulnHistory,btnVulPrint);  
        
        JcomboSelection(cboTargateNameSearch);
        
        selectCombo(cboCertificateType);
        selectCombo(cboIsReadyWaiting);
        selectCombo(cboRecivingStatus);
        selectCombo(cboCourseNameInTarg);
        
        cboCertificateType.addItem("WEA Certificate");
        cboCertificateType.addItem("NoNACC Certificate");
        
        cboIsReadyWaiting.addItem("To Be Marked");
        cboIsReadyWaiting.addItem("Submitted");
        cboIsReadyWaiting.addItem("Received");
        
        cboRecivingStatus.addItem("Collected");
        cboRecivingStatus.addItem("Waiting");
        
              
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        popMnuEditBasicInfo = new javax.swing.JRadioButtonMenuItem();
        popMnuEditBackInfo = new javax.swing.JRadioButtonMenuItem();
        popMnuEditPersonalInfo = new javax.swing.JRadioButtonMenuItem();
        popMnuEqualityInfo = new javax.swing.JRadioButtonMenuItem();
        optGroupeSearch = new javax.swing.ButtonGroup();
        optGroupModificaton = new javax.swing.ButtonGroup();
        groupRedioButtonSearch = new javax.swing.ButtonGroup();
        shapePainter1 = new org.jdesktop.swingx.painter.ShapePainter();
        popMenuMangeCourse = new javax.swing.JPopupMenu();
        mnuDeleteAssignCourse = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtMultiSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        optRedioByReference = new javax.swing.JRadioButton();
        optRedioBySurName = new javax.swing.JRadioButton();
        optRedioByFirstName = new javax.swing.JRadioButton();
        btnPrintGeneralSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGeneralSearchBenficiary = new javax.swing.JTable(){

            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        jSeparator1 = new javax.swing.JSeparator();
        tabRegVulnerableAdult = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblViewStudentCourse = new javax.swing.JTable(){

            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }

            public Component prepareRenderer(TableCellRenderer renderer, int row, int column){

                Component c = super.prepareRenderer(renderer, row, column);
                //  Color row based on a cell value

                if (!isRowSelected(row))
                {
                    c.setBackground(getBackground());
                    int modelRow = convertRowIndexToModel(row);
                    String type = String.valueOf(getModel().getValueAt(modelRow, 2));
                    if ("Passed".equals(type)) c.setBackground(Color.GREEN);
                    if ("Fail".equals(type)) c.setBackground(Color.RED);
                    if ("Absent".equals(type)) c.setBackground(Color.YELLOW);
                    if ("Scheduled".equals(type)) c.setBackground(Color.MAGENTA);
                    if ("Attending".equals(type)) c.setBackground(Color.cyan);

                }

                return c;
            }
        };
        cboTargateNameSearch = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cboCourseNameInTarg = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        btnPrintTakenCourse = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblCertificate = new javax.swing.JTable();
        dtDateCollected = new com.toedter.calendar.JDateChooser();
        cboRecivingStatus = new javax.swing.JComboBox();
        cboIsReadyWaiting = new javax.swing.JComboBox();
        cboCertificateType = new javax.swing.JComboBox();
        btnCertificateUpdate = new javax.swing.JButton();
        btnSaveCourseAssignment = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnViewPassedCourse = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        cboExamStatus = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblViewStudentCourseExamSchedule = new javax.swing.JTable(){

            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }

            public Component prepareRenderer(TableCellRenderer renderer, int row, int column){

                Component c = super.prepareRenderer(renderer, row, column);
                //  Color row based on a cell value

                if (!isRowSelected(row))
                {
                    c.setBackground(getBackground());
                    int modelRow = convertRowIndexToModel(row);
                    String type = String.valueOf(getModel().getValueAt(modelRow, 2));

                    if ("Fail".equals(type)) c.setBackground(Color.RED);
                    if ("Absent".equals(type)) c.setBackground(Color.YELLOW);
                    if ("Scheduled".equals(type)) c.setBackground(Color.MAGENTA);
                    if ("Attending".equals(type)) c.setBackground(Color.cyan);

                }

                return c;
            }
        };
        btnExamSchedulePrint = new javax.swing.JButton();
        dtExamDate = new com.toedter.calendar.JDateChooser();
        btnLoadTakenCourse = new javax.swing.JButton();
        btnExamScheduleSave = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblVewVulnHistory = new javax.swing.JTable(){

            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        jScrollPane6 = new javax.swing.JScrollPane();
        txtDescriptionVuln = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtWhomReport = new javax.swing.JTextArea();
        btnLoadVulHistory = new javax.swing.JButton();
        btnVulPrint = new javax.swing.JButton();
        dtVulDate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        btnVulSave = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(jTable5);

        popMnuEditBasicInfo.setSelected(true);
        popMnuEditBasicInfo.setText("Edit Basic Information");
        jPopupMenu1.add(popMnuEditBasicInfo);

        popMnuEditBackInfo.setSelected(true);
        popMnuEditBackInfo.setText("Edit Background Information");
        jPopupMenu1.add(popMnuEditBackInfo);

        popMnuEditPersonalInfo.setSelected(true);
        popMnuEditPersonalInfo.setText("Edit Personal Information");
        jPopupMenu1.add(popMnuEditPersonalInfo);

        popMnuEqualityInfo.setSelected(true);
        popMnuEqualityInfo.setText("Edit Equality and Other");
        jPopupMenu1.add(popMnuEqualityInfo);

        mnuDeleteAssignCourse.setText("Delete Assigned Course");
        mnuDeleteAssignCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteAssignCourseActionPerformed(evt);
            }
        });
        popMenuMangeCourse.add(mnuDeleteAssignCourse);

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setIconifiable(true);
        setTitle("Mange Student Course");
        setToolTipText("");
        setName("IntFrameSearchBenForm"); // NOI18N
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

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        groupRedioButtonSearch.add(optRedioByReference);
        optRedioByReference.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optRedioByReference.setSelected(true);
        optRedioByReference.setText("By Reference ID");
        optRedioByReference.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRedioByReferenceActionPerformed(evt);
            }
        });

        groupRedioButtonSearch.add(optRedioBySurName);
        optRedioBySurName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optRedioBySurName.setText("By SurName");
        optRedioBySurName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRedioBySurNameActionPerformed(evt);
            }
        });

        groupRedioButtonSearch.add(optRedioByFirstName);
        optRedioByFirstName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optRedioByFirstName.setText("By Given Name");
        optRedioByFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRedioByFirstNameActionPerformed(evt);
            }
        });

        btnPrintGeneralSearch.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnPrintGeneralSearch.setText("Print");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(optRedioByReference)
                        .addGap(18, 18, 18)
                        .addComponent(optRedioBySurName)
                        .addGap(11, 11, 11)
                        .addComponent(optRedioByFirstName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtMultiSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrintGeneralSearch)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPrintGeneralSearch)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optRedioByReference)
                            .addComponent(optRedioBySurName)
                            .addComponent(optRedioByFirstName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(txtMultiSearch))))
                .addContainerGap())
        );

        tblGeneralSearchBenficiary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "REFERENCE_NO", "SURNAME", "GIVEN NAME", "SEX"
            }
        ));
        jScrollPane1.setViewportView(tblGeneralSearchBenficiary);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabRegVulnerableAdult.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabRegVulnerableAdult.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tabRegVulnerableAdult.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabRegVulnerableAdultStateChanged(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        tblViewStudentCourse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblViewStudentCourse.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tblViewStudentCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "REFERENCE NO", "COURSE NAME", "COURSE STATUS"
            }
        ));
        tblViewStudentCourse.setComponentPopupMenu(popMenuMangeCourse);
        jScrollPane4.setViewportView(tblViewStudentCourse);

        cboTargateNameSearch.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboTargateNameSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Target Name");

        cboCourseNameInTarg.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboCourseNameInTarg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboCourseNameInTarg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCourseNameInTargActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Course Name");

        btnPrintTakenCourse.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        btnPrintTakenCourse.setText("Print");

        tblCertificate.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tblCertificate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "COURSE ID", "CERTIFICATE TYPE", "IS CERT READY", "STATUS", "DATE COLLECTED"
            }
        ));
        jScrollPane10.setViewportView(tblCertificate);

        dtDateCollected.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N
        dtDateCollected.setPreferredSize(new java.awt.Dimension(96, 22));

        cboRecivingStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboRecivingStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cboIsReadyWaiting.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboIsReadyWaiting.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cboCertificateType.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboCertificateType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCertificateUpdate.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnCertificateUpdate.setText("Update Certificate");
        btnCertificateUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificateUpdateActionPerformed(evt);
            }
        });

        btnSaveCourseAssignment.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        btnSaveCourseAssignment.setForeground(new java.awt.Color(255, 0, 0));
        btnSaveCourseAssignment.setText("Save");
        btnSaveCourseAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCourseAssignmentActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        jLabel1.setText("Accreditation");

        jLabel2.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel2.setText("Certificate Type");

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel3.setText("Is certificate ready");

        jLabel6.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel6.setText("Collecting Status");

        jLabel7.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel7.setText("Date Collected");

        btnViewPassedCourse.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnViewPassedCourse.setText("View Passed Course");
        btnViewPassedCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPassedCourseActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Assign  Course to the Students :-");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCertificateUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(cboTargateNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cboCourseNameInTarg, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSaveCourseAssignment)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrintTakenCourse))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewPassedCourse))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCertificateType, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboRecivingStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboIsReadyWaiting, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtDateCollected, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboCourseNameInTarg, cboTargateNameSearch});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboCourseNameInTarg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSaveCourseAssignment)
                        .addComponent(btnPrintTakenCourse))
                    .addComponent(cboTargateNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnViewPassedCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboCertificateType, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(cboRecivingStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboIsReadyWaiting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtDateCollected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(btnCertificateUpdate)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboCertificateType, cboCourseNameInTarg, cboIsReadyWaiting, cboRecivingStatus, cboTargateNameSearch});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 363, Short.MAX_VALUE)
        );

        tabRegVulnerableAdult.addTab("Course Assignment", jPanel4);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        cboExamStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboExamStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Passed", "Fail", "Absent", "Scheduled", "Completed" }));
        cboExamStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel5.setText("Exam Status");

        jLabel4.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel4.setText("Exam Date");

        tblViewStudentCourseExamSchedule.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblViewStudentCourseExamSchedule.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tblViewStudentCourseExamSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "REFERENCE NO", "COURSE ID", "COURSE STATUS"
            }
        ));
        jScrollPane9.setViewportView(tblViewStudentCourseExamSchedule);

        btnExamSchedulePrint.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnExamSchedulePrint.setText("Print");

        dtExamDate.setPreferredSize(new java.awt.Dimension(96, 22));

        btnLoadTakenCourse.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnLoadTakenCourse.setText("Load Taken Course");
        btnLoadTakenCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadTakenCourseActionPerformed(evt);
            }
        });

        btnExamScheduleSave.setText("Save");
        btnExamScheduleSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExamScheduleSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(dtExamDate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(cboExamStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExamScheduleSave))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(148, 148, 148)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnLoadTakenCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExamSchedulePrint, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboExamStatus, dtExamDate});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadTakenCourse)
                    .addComponent(btnExamSchedulePrint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtExamDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboExamStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExamScheduleSave)))
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabRegVulnerableAdult.addTab("Exam Schedule and Result", jPanel2);

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        tblVewVulnHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblVewVulnHistory.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tblVewVulnHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "DATE", "DESCRIPTION", "WHOM REPORT"
            }
        ));
        jScrollPane8.setViewportView(tblVewVulnHistory);

        txtDescriptionVuln.setColumns(20);
        txtDescriptionVuln.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtDescriptionVuln.setRows(5);
        jScrollPane6.setViewportView(txtDescriptionVuln);

        jLabel11.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel11.setText("Description");

        jLabel12.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel12.setText("Whom Report");

        txtWhomReport.setColumns(20);
        txtWhomReport.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtWhomReport.setRows(5);
        jScrollPane5.setViewportView(txtWhomReport);

        btnLoadVulHistory.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnLoadVulHistory.setText("Load History");
        btnLoadVulHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadVulHistoryActionPerformed(evt);
            }
        });

        btnVulPrint.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnVulPrint.setText("Print");

        dtVulDate.setPreferredSize(new java.awt.Dimension(96, 22));

        jLabel13.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel13.setText("Date ");

        btnVulSave.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnVulSave.setText("Save");
        btnVulSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVulSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtVulDate, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(btnVulSave))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(btnLoadVulHistory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVulPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane5, jScrollPane6});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadVulHistory)
                    .addComponent(btnVulPrint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13))
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane6)
                    .addComponent(dtVulDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVulSave, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(3, 3, 3))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane5, jScrollPane6});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabRegVulnerableAdult.addTab("Register Vulnerable Adult", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabRegVulnerableAdult, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabRegVulnerableAdult))
        );

        setBounds(0, 0, 791, 640);
    }// </editor-fold>//GEN-END:initComponents
     
     private void set_CertificateType(){ certificate_Type=cboCertificateType.getSelectedItem().toString();}
     private String  get_CertificateType(){ return certificate_Type;}
     
     private void set_Status(){ status=cboRecivingStatus.getSelectedItem().toString();}
     private String  get_Status(){ return status;}
     
     private void set_IsCertificateReady(){ isCertificateReady=cboIsReadyWaiting.getSelectedItem().toString();}
     private String  get_IsCertificateReady(){ return isCertificateReady;}
          
     private void set_DateCollected(){
        try{
            String  feachDate=dateFormat.format(dtDateCollected.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            date_Collected= feachdate;
        }catch(Exception ex){
            utilObj.setToolTip(dtDateCollected, " Date Collected error ! Error :" + ex);
        }  
    }
     private Date get_DateCollected(){return date_Collected;}
     
     private void set_ExamStatus(){exam_Status=cboExamStatus.getSelectedItem().toString().trim(); }
     private String get_ExamStatus(){ return exam_Status;}
     
     private void set_DateExam(){
        try{
            String  feachDate=dateFormat.format(dtExamDate.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            date_Exam= feachdate;
        }catch(Exception ex){
            utilObj.setToolTip(dtExamDate, "Exam Date error ! Error :" + ex);
        }  
    }
     private Date get_DateExam(){return date_Exam;}
    
     private void set_DateVulnerble(){
        try{
            String  feachDate=dateFormat.format(dtVulDate.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            date_VulRegisterd= feachdate;
        }catch(Exception ex){
            utilObj.setToolTip(dtExamDate, "Vulnrable Date error ! Error :" + ex);
        }  
    }
     private Date get_DateVulnerble(){return date_VulRegisterd;}
     
     private void set_DateExamRegister(){
        try{
            Date todayDate= new Date();
            String  feachDate=dateFormat.format(todayDate.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            date_Exam_Registration= feachdate;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "Exam Register Date error ! Error :" + ex);
        }  
    }
     private Date get_DateExamRegister(){return date_Exam_Registration;}
    
     private void set_VulnDescription(){vulDescrition=txtDescriptionVuln.getText().toString(); }
     private String get_VulnDescription(){return vulDescrition;}
    
     private void set_VulWhomeReport(){ vulWhomeReport=txtWhomReport.getText().toString();}
     private String get_VulWhomReport(){return vulWhomeReport;}
        
    private void txtMultiSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMultiSearchFocusGained
        // TODO add your handling code here:
    
    }//GEN-LAST:event_txtMultiSearchFocusGained
    public void JcomboSelection(final JComboBox combo){
            combo.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
            busObj.targetName =String.valueOf(combo.getSelectedItem()).trim();
                cboCourseNameInTarg.removeAllItems();
                // Fill Course Combo
                selectCombo(cboCourseNameInTarg);
                 busObj.pop_Combo(cboCourseNameInTarg, proc_CourseInTarget, "cboCourseNameInTarg");
                   // if(cboCourseNameInTarg.getItemCount() != 0)cboCourseNameInTarg.setSelectedIndex(0);
                 
            }
            });
    }

    private void txtMultiSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMultiSearchFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtMultiSearchFocusLost
 
    private void optRedioByReferenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optRedioByReferenceActionPerformed
       JRadioButton button = (JRadioButton) evt.getSource();
 
        if (button == optRedioByReference)  {
            txtMultiSearch.setText("");
            PromptSupport.setPrompt("Enter student reference No...", txtMultiSearch);
            flag=0;            
        }
    }//GEN-LAST:event_optRedioByReferenceActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       
        if(flag==0) {
            
          // Fill Table
            busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryByReferenceNo(?,?)", 
                                txtMultiSearch.getText().trim());
            jScrollPane1.getViewport().add(tblGeneralSearchBenficiary);
        
        }else if(flag==1) {
            
          // Fill Table
            busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryBySurName(?,?)", 
                                txtMultiSearch.getText().trim());
            jScrollPane1.getViewport().add(tblGeneralSearchBenficiary);
        
        }else{
            
         // Fill Table
            busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryByGivenName(?,?)", 
                                txtMultiSearch.getText().trim());
            jScrollPane1.getViewport().add(tblGeneralSearchBenficiary);
        }
            
    }//GEN-LAST:event_btnSearchActionPerformed

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

    private void tabRegVulnerableAdultStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabRegVulnerableAdultStateChanged
          
    }//GEN-LAST:event_tabRegVulnerableAdultStateChanged

    private void btnLoadTakenCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadTakenCourseActionPerformed
       
               busObj.pop_Talbe(tblViewStudentCourseExamSchedule,"select_Data_Package.get_CourseTakenExceptPassed(?,?)",
                                StudentReference_No);
               jScrollPane9.getViewport().add(tblViewStudentCourseExamSchedule);
               hide_Column();
         
    }//GEN-LAST:event_btnLoadTakenCourseActionPerformed

    private void btnLoadVulHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadVulHistoryActionPerformed
                // Fill Table
                 busObj.pop_Talbe(tblVewVulnHistory, "select_Data_Package.get_Vulnerablity(?,?)", 
                 StudentReference_No);
                 jScrollPane8.getViewport().add(tblVewVulnHistory);  
    }//GEN-LAST:event_btnLoadVulHistoryActionPerformed

    private void btnVulSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVulSaveActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
         try{
            
                    if(!(StudentReference_No.isEmpty() || dtVulDate.getDate()==null|| txtDescriptionVuln.getText()==""||txtWhomReport.getText()==""))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameSearchAssignCourses.this, "Do you want to Update the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          
                        if (response == JOptionPane.YES_OPTION) {
                            
                           
                            set_VulnDescription();
                            set_DateVulnerble();
                            set_VulWhomeReport();
                            
                            busObj.insert_Vulnerablity(StudentReference_No,
                                                       get_VulnDescription(),
                                                       utilObj.sql_Date(get_DateVulnerble()),
                                                       get_VulWhomReport());
                         
                            JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "Data saved Successfully ! ","Data insertion",JOptionPane.INFORMATION_MESSAGE);
                            
                            // Fill Table
                             busObj.pop_Talbe(tblVewVulnHistory, "select_Data_Package.get_Vulnerablity(?,?)", 
                             StudentReference_No);
                             jScrollPane8.getViewport().add(tblVewVulnHistory);  
                          
                        }
                    } else JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this,
                            "Student,date,Vulnerable description and whom report data should be set !","Data Insertion",JOptionPane.ERROR_MESSAGE);
            
          
            
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "Please check the Missing Filed,");
          }
    }//GEN-LAST:event_btnVulSaveActionPerformed

    private void btnExamScheduleSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExamScheduleSaveActionPerformed
       JDialog.setDefaultLookAndFeelDecorated(true);
         try{
            
                    if(!(StudentReference_No.isEmpty() || course_IDForExam==0 || selectedRow==-1))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameSearchAssignCourses.this, "Do you want to Update the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
  
                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_ExamStatus();
                            set_DateExamRegister();
                            set_DateExam();
                            
                            busObj.update_CourseExam(StudentReference_No,
                                                       course_IDForExam,
                                                       get_ExamStatus(),
                                                       utilObj.sql_Date(get_DateExamRegister()),
                                                       utilObj.sql_Date(get_DateExam()));
                            if (get_ExamStatus()=="Passed"){
                            busObj.insert_Certificate(StudentReference_No,
                                                      course_IDForExam,
                                                      null,
                                                      null,
                                                      "Needs Clame",
                                                      null);
                            
                            // Fill Table
                            busObj.pop_Talbe(tblCertificate,"select_Data_Package.get_Certificate(?,?)",
                            StudentReference_No);
                            jScrollPane10.getViewport().add(tblCertificate);
                            
                            }
                            
                            JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "Data saved Successfully ! ","Data insertion",JOptionPane.INFORMATION_MESSAGE);
                            
                            // Fill Table
                            busObj.pop_Talbe(tblViewStudentCourseExamSchedule,"select_Data_Package.get_CourseTakenExceptPassed(?,?)",
                            StudentReference_No);
                            jScrollPane9.getViewport().add(tblViewStudentCourseExamSchedule);
                            hide_Column();
                          
                        }
                    } else JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this,
                            "Course,Student,exam date and status should be selected !","Data Insertion",JOptionPane.ERROR_MESSAGE);
            
          
            
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "Please check the Missing Filed,");          }
    }//GEN-LAST:event_btnExamScheduleSaveActionPerformed

    private void btnSaveCourseAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCourseAssignmentActionPerformed
       // insert_CourseTaken
        JDialog.setDefaultLookAndFeelDecorated(true);
         try{
                          
                    if(!(StudentReference_No.isEmpty() || cboCourseNameInTarg.getSelectedItem().toString()=="Select..." || cboTargateNameSearch.getSelectedItem().toString()=="Select..." ))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameSearchAssignCourses.this, "Do you want to save the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                         if (response == JOptionPane.YES_OPTION) {
                                    course_ID=Integer.parseInt(IDholder_CourseName.get(cboCourseNameInTarg.getSelectedIndex()).toString());
                                    boolean foudFlag=false;
                                        for (int j=0;j<tblViewStudentCourse.getRowCount();j++) {
                                            if (String.valueOf(tblViewStudentCourse.getModel().getValueAt(j, 1)).equals(String.valueOf(course_ID)))
                                            {    
                                                foudFlag=true; 
                                                break;
                                              
                                             }
                                            else foudFlag=false;
                                        }
                                        
                                        if (!(foudFlag)) {
                                        busObj.insert_CourseTaken(StudentReference_No,
                                                                   course_ID);
                                         busObj.insert_CourseeExam(StudentReference_No,
                                                                course_ID,
                                                                "Attending",
                                                                null,
                                                                null);
                                        JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "Data saved Successfully ! ","Data insertion",JOptionPane.INFORMATION_MESSAGE);

                                        // Fill Table
                                        busObj.pop_Talbe(tblViewStudentCourse, "select_Data_Package.get_CourseTaken(?,?)", 
                                        StudentReference_No);
                                        jScrollPane4.getViewport().add(tblViewStudentCourse); 

                                        }else JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this,
                            "The selected course ID "+ course_ID + " has already been assigned to this Student, Please tray another !","Duplicate assignment",JOptionPane.ERROR_MESSAGE);
                       
                            
                        }
                    } else JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this,
                            "Target , Course and Student should be selected !","Data Insertion",JOptionPane.ERROR_MESSAGE);
          
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "Missing field , please try to select.. ");
          }
         
    }//GEN-LAST:event_btnSaveCourseAssignmentActionPerformed

    private void cboCourseNameInTargActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCourseNameInTargActionPerformed
        
    }//GEN-LAST:event_cboCourseNameInTargActionPerformed

    private void btnCertificateUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificateUpdateActionPerformed
        //update_Certificate
        JDialog.setDefaultLookAndFeelDecorated(true);
         try{
            
                    if(!(StudentReference_No.isEmpty() || course_IDforCertificate==0))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameSearchAssignCourses.this, "Do you want to Update the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
 
                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_IsCertificateReady();
                            set_CertificateType();
                            set_Status();
                            set_DateCollected();
                            busObj.update_Certificate(course_IDforCertificate,
                                                      get_IsCertificateReady(),
                                                      get_CertificateType(),
                                                      get_Status(),
                                                      utilObj.sql_Date(get_DateCollected()));
                          
                            JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "Data Update Successfully ! ","Data insertion",JOptionPane.INFORMATION_MESSAGE);
                        
                            // Fill Table
                            busObj.pop_Talbe(tblCertificate,"select_Data_Package.get_Certificate(?,?)",
                            StudentReference_No);
                            jScrollPane10.getViewport().add(tblCertificate);
                            
                          
                        }
                    } else JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this,
                            " Student, course and collected date should be selected !","Data Updating",JOptionPane.ERROR_MESSAGE);
            
          
            
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "Please check the Missing Filed,");
          }
    }//GEN-LAST:event_btnCertificateUpdateActionPerformed

    private void btnViewPassedCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPassedCourseActionPerformed
             // Fill Table
        try{
            busObj.pop_Talbe(tblCertificate,"select_Data_Package.get_Certificate(?,?)",
            StudentReference_No);
            jScrollPane10.getViewport().add(tblCertificate);
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this,
                "Please find and select the sudent first! Error : " + ex);}
    }//GEN-LAST:event_btnViewPassedCourseActionPerformed

    private void txtMultiSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMultiSearchKeyPressed
       if(evt.getKeyCode() == evt.VK_ENTER) {
           if(flag==0) {
            
          // Fill Table
            busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryByReferenceNo(?,?)", 
                                txtMultiSearch.getText().trim());
            jScrollPane1.getViewport().add(tblGeneralSearchBenficiary);
        
        }else if(flag==1) {
            
          // Fill Table
            busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryBySurName(?,?)", 
                                txtMultiSearch.getText().trim());
            jScrollPane1.getViewport().add(tblGeneralSearchBenficiary);
        
        }else{
            
         // Fill Table
            busObj.pop_Talbe(tblGeneralSearchBenficiary, "select_Data_Package.get_BeneficiaryByGivenName(?,?)", 
                                txtMultiSearch.getText().trim());
            jScrollPane1.getViewport().add(tblGeneralSearchBenficiary);
        } 
           txtMultiSearch.setText(null);
           txtMultiSearch.grabFocus();
        }
    }//GEN-LAST:event_txtMultiSearchKeyPressed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
            utilObj.flag2=false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void mnuDeleteAssignCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteAssignCourseActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
         try{
             if(!(tblViewStudentCourse.getRowCount()==0)){
                if(!(courseID_assigned==0))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameSearchAssignCourses.this, "Do you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                         if (response == JOptionPane.YES_OPTION) {
                             
                             if("Attending".equals(attendStatus)){ 
                                 busObj.delete_AssignedCourse(StudentReference_No,courseID_assigned, proc_deleteCourseAssi); 
                                 JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "Record delete Successfully ! ","Deleting Record",JOptionPane.INFORMATION_MESSAGE);

                                // Fill Table
                                busObj.pop_Talbe(tblViewStudentCourse, "select_Data_Package.get_CourseTaken(?,?)", 
                                StudentReference_No);
                                jScrollPane4.getViewport().add(tblViewStudentCourse); 
                            }else JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "This course cant be deleted");
                         }
                }
            }else JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this,"Empty record cant be deleted");
         }catch(Exception ex){
             JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this,ex);
         }
    }//GEN-LAST:event_mnuDeleteAssignCourseActionPerformed
    
    private void hide_Column(){
               
        tblViewStudentCourseExamSchedule.removeColumn(tblViewStudentCourseExamSchedule.getColumnModel().getColumn(3));
        tblViewStudentCourseExamSchedule.removeColumn(tblViewStudentCourseExamSchedule.getColumnModel().getColumn(3));
    }
    
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
                              
                              if (!(tbl_Name=="tblViewStudentCourse" || tblGeneralSearchBenficiary.getRowCount()==0)){
                                 
                                // Fill Table
                                 busObj.pop_Talbe(tblViewStudentCourse, "select_Data_Package.get_CourseTaken(?,?)", 
                                 StudentReference_No);
                                 jScrollPane4.getViewport().add(tblViewStudentCourse);  
                              }
                   
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
             
             if (tbl_Name=="tblViewStudentCourseExamSchedule" ){
                 //StudentReference_No=String.valueOf(model.getValueAt(selcted_Row, 0).toString());
                 course_IDForExam=Integer.parseInt(model.getValueAt(selcted_Row, 1).toString());
             }else if (tbl_Name=="tblCertificate" ){
                 course_IDforCertificate=Integer.parseInt(model.getValueAt(selcted_Row,0).toString());
             }else if (tbl_Name=="tblViewStudentCourse" ){
                 courseID_assigned=Integer.parseInt(model.getValueAt(selcted_Row,1).toString());
                 attendStatus=String.valueOf(model.getValueAt(selcted_Row, 2).toString());
             }else {
                 StudentReference_No=String.valueOf(model.getValueAt(selcted_Row, 0).toString());
             }
             
        }catch(Exception ex){
            JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "The table is Empety ");
        }
  }
    
    public  void prit_TblData(final JTable table,JButton print_Button){
   
         ActionListener printAction = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            try {
                Date d= new Date();
              //jTable2.print(JTable.PrintMode.NORMAL);
                MessageFormat headerFormat = new MessageFormat("Kensington Community Learning Center");
              MessageFormat footerFormat = new MessageFormat("- {0} -");
                     
              table.print(JTable.PrintMode.FIT_WIDTH, headerFormat,footerFormat, true, new  HashPrintRequestAttributeSet(), true);
            } catch (PrinterException pe) {
                JOptionPane.showMessageDialog(IntFrameSearchAssignCourses.this, "Error printing: " + pe.getMessage() );
             
            }
          }
        };
        print_Button.addActionListener(printAction);

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
    private javax.swing.JButton btnCertificateUpdate;
    private javax.swing.JButton btnExamSchedulePrint;
    private javax.swing.JButton btnExamScheduleSave;
    private javax.swing.JButton btnLoadTakenCourse;
    private javax.swing.JButton btnLoadVulHistory;
    private javax.swing.JButton btnPrintGeneralSearch;
    private javax.swing.JButton btnPrintTakenCourse;
    private javax.swing.JButton btnSaveCourseAssignment;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewPassedCourse;
    private javax.swing.JButton btnVulPrint;
    private javax.swing.JButton btnVulSave;
    private javax.swing.JComboBox cboCertificateType;
    private javax.swing.JComboBox cboCourseNameInTarg;
    private javax.swing.JComboBox cboExamStatus;
    private javax.swing.JComboBox cboIsReadyWaiting;
    private javax.swing.JComboBox cboRecivingStatus;
    private javax.swing.JComboBox cboTargateNameSearch;
    private com.toedter.calendar.JDateChooser dtDateCollected;
    private com.toedter.calendar.JDateChooser dtExamDate;
    private com.toedter.calendar.JDateChooser dtVulDate;
    private javax.swing.ButtonGroup groupRedioButtonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable5;
    private javax.swing.JMenuItem mnuDeleteAssignCourse;
    private javax.swing.ButtonGroup optGroupModificaton;
    private javax.swing.ButtonGroup optGroupeSearch;
    private javax.swing.JRadioButton optRedioByFirstName;
    private javax.swing.JRadioButton optRedioByReference;
    private javax.swing.JRadioButton optRedioBySurName;
    private javax.swing.JPopupMenu popMenuMangeCourse;
    private javax.swing.JRadioButtonMenuItem popMnuEditBackInfo;
    private javax.swing.JRadioButtonMenuItem popMnuEditBasicInfo;
    private javax.swing.JRadioButtonMenuItem popMnuEditPersonalInfo;
    private javax.swing.JRadioButtonMenuItem popMnuEqualityInfo;
    private org.jdesktop.swingx.painter.ShapePainter shapePainter1;
    private javax.swing.JTabbedPane tabRegVulnerableAdult;
    private javax.swing.JTable tblCertificate;
    private javax.swing.JTable tblGeneralSearchBenficiary;
    private javax.swing.JTable tblVewVulnHistory;
    private javax.swing.JTable tblViewStudentCourse;
    private javax.swing.JTable tblViewStudentCourseExamSchedule;
    private javax.swing.JTextArea txtDescriptionVuln;
    private javax.swing.JTextField txtMultiSearch;
    private javax.swing.JTextArea txtWhomReport;
    // End of variables declaration//GEN-END:variables
}
