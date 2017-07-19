/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages;

import formPackages.classPackages.BarcodeReader;
import formPackages.classPackages.businessLayer;
import formPackages.classPackages.utility;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author jo
 */
public class IntFrameAttandance extends javax.swing.JInternalFrame {

    //********** Declaring Barcode reader variables *********
    private static final long THRESHOLD = 100;
    private static final int MIN_BARCODE_LENGTH = 8;

    public interface BarcodeListener {

    void onBarcodeRead(String barcode);
    }
       
    private final StringBuffer barcode = new StringBuffer();
    private final List<BarcodeReader.BarcodeListener> listeners = new CopyOnWriteArrayList<BarcodeReader.BarcodeListener>();
    private long lastEventTimeStamp = 0L;
    //*************
    /**
     * Creates new form NewJInternalFrame
     */
    private String referenceNO;
    private String proc_CourseScheduleDay="select_Data_Package.get_ClassScheduleComp(?,?)";
    private String proc_CourseAttend="select_Data_Package.get_CourseTakenAttend(?,?)";
    private String proc_BeneficiaryType="select_Data_Package.get_BeneficiaryType(?,?)";
   
    private String weekDay;
    private String timeIN;
    private String timeOut;
    private String toatlTime;
    private int courseId;
    private int flag=0;
    private int flagSearch=0;
    private String timeInTbls; //Time in from the table
    private String startDate;
    private String endDate;
    private String refNoToAttendance;
    private String startDateEvent;
    private String endDateEvent;
    
    private String eventID;
    private String EventStat;
    
    Date today;
    
    private ArrayList<String> scheduleCourse;
    private ArrayList<String> courseAttend;
    private ArrayList<String> benefiType;
    private boolean ALLOW_ROW_SELECTION=true;
    private int selectedRow;
    
    
    SimpleDateFormat formatTimeInOut = new SimpleDateFormat("HH:mm");
    SimpleDateFormat formatToDay = new SimpleDateFormat("yy/MM/dd");
    
    businessLayer busObj=new businessLayer();
    utility utilObj=new utility();
    
    public IntFrameAttandance() {
        initComponents();
        
        String [] blfType={"BLF_NONAcc","BLF_VOL"};
        
        for(int i =0;i<blfType.length;i++){
            
               if (blfType[i].toString()=="BLF_NONAcc"){
                        busObj.pop_Talbe(tblStudentAttendance, "select_Data_Package.get_Attendance(?,?)", 
                                blfType[i].toString());
                        jScrollPane1.getViewport().add(tblStudentAttendance);
                        hide_ColumnStudent();
               }else if (blfType[i].toString()=="BLF_VOL" ){
                         busObj.pop_Talbe(tblVolunteerAttendance, "select_Data_Package.get_Attendance(?,?)", 
                            blfType[i].toString());
                         jScrollPane2.getViewport().add(tblVolunteerAttendance);
               }
           
           }
        
       //**************** Barcode keyboard listner ********
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
        @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() != KeyEvent.KEY_RELEASED) {
                    return false;
                }

                if (e.getWhen() - lastEventTimeStamp > THRESHOLD) {
                    barcode.delete(0, barcode.length());
                }

                lastEventTimeStamp = e.getWhen();

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (barcode.length() >= MIN_BARCODE_LENGTH) {
                        fireBarcode(barcode.toString());
                            set_ReferenceNo("BLF"+barcode.substring(6).toString().trim());
                            benfiType();
                    }
                    barcode.delete(0, barcode.length());
                } else {
                    barcode.append(e.getKeyChar());
                }
                return false;
            }
        });
    
    //************ End *******;
        
        DateFormat dateFormatter;
       
        dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);
        today = new Date();
        String dateOut = dateFormatter.format(today);
        lblTodayDate.setText(dateOut);
        
        lblCourseName.setEnabled(false);
        lblSession.setEnabled(false);
        lblRoom.setEnabled(false);
        
        
        
              
        String toDay=formatToDay.format(today.getTime());
        busObj.pop_Talbe(tblEventAttendance, "select_Data_Package.get_EventsByCurrentYear(?,?)",toDay);
        jScrollPane3.getViewport().add(tblEventAttendance);
       
        
        prit_TblData(tblStudentAttendance,btnPrintStudentOnlyAttendance);
        prit_TblData(tblVolunteerAttendance,btnPrintVolOnlyAttendance);
        
        prit_TblData(tblSearchedAttendance,btnPrintSearchedAttendance);
        prit_TblData(tblEventAttendance,btnPrintEventAttendance);
                
        PromptSupport.setPrompt("Enter Surname...", txtStudentVolSearchAttendance);
        
        Tbl_SelectionMode(tblEventAttendance);
        Tbl_SelectionMode(tblSearchedAttendance);
        
        chkUseDateInterval.setSelected(false);
        chkUseDateInterval.setEnabled(false);
        
        chkIncludeVolunteer.setSelected(false);
        chkIncludeVolunteer.setEnabled(false);
        
        dtStartDate.setEnabled(false);
        dtEndDate.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMnuPrintAttendance = new javax.swing.JPopupMenu();
        mnuButtonAddtoAttendance = new javax.swing.JRadioButtonMenuItem();
        OptGroupsurnameGivenName = new javax.swing.ButtonGroup();
        buttonGroupAttendance = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudentAttendance = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVolunteerAttendance = new javax.swing.JTable();
        btnPrintVolOnlyAttendance = new javax.swing.JButton();
        btnPrintStudentOnlyAttendance = new javax.swing.JButton();
        lblTodayDate = new javax.swing.JLabel();
        lblCourseName = new javax.swing.JLabel();
        lblSession = new javax.swing.JLabel();
        lblRoom = new javax.swing.JLabel();
        lblReferenceNo = new javax.swing.JLabel();
        lblWellcomeMsg = new javax.swing.JLabel();
        chkfreeSearch = new javax.swing.JRadioButton();
        dtStartDate = new com.toedter.calendar.JDateChooser();
        optSurname = new javax.swing.JRadioButton();
        optGivenName = new javax.swing.JRadioButton();
        chkUseDateInterval = new javax.swing.JCheckBox();
        chkIncludeVolunteer = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        dtEndDate = new com.toedter.calendar.JDateChooser();
        btnSearch = new javax.swing.JButton();
        btnPrintSearchedAttendance = new javax.swing.JButton();
        chkfreeSearch1 = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSearchedAttendance = new javax.swing.JTable();
        txtStudentVolSearchAttendance = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEventAttendance = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNoEventAttendee = new javax.swing.JTextField();
        btnSaveNoAttendee = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnSearchEventbydates = new javax.swing.JButton();
        dtStartDateEvent = new com.toedter.calendar.JDateChooser();
        dtEndDateEvent = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        btnPrintEventAttendance = new javax.swing.JButton();

        mnuButtonAddtoAttendance.setSelected(true);
        mnuButtonAddtoAttendance.setText("Add to Attendance table");
        mnuButtonAddtoAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuButtonAddtoAttendanceActionPerformed(evt);
            }
        });
        popMnuPrintAttendance.add(mnuButtonAddtoAttendance);

        setClosable(true);
        setIconifiable(true);
        setTitle("Manage Attendance");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Attendance.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
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

        jLabel2.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        jLabel2.setText("Student");

        tblStudentAttendance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblStudentAttendance.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tblStudentAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "REFERENCE NO", "FIRST NAME", "SURNAME", "IN TIME ", "OUT TIME", "COURSE_ID "
            }
        ));
        jScrollPane1.setViewportView(tblStudentAttendance);

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        jLabel3.setText("Volunteer/Employee");

        tblVolunteerAttendance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblVolunteerAttendance.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tblVolunteerAttendance.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblVolunteerAttendance);

        btnPrintVolOnlyAttendance.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnPrintVolOnlyAttendance.setText("Print");

        btnPrintStudentOnlyAttendance.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnPrintStudentOnlyAttendance.setText("Print");
        btnPrintStudentOnlyAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintStudentOnlyAttendanceActionPerformed(evt);
            }
        });

        lblTodayDate.setFont(new java.awt.Font("DejaVu Serif", 1, 12)); // NOI18N
        lblTodayDate.setForeground(new java.awt.Color(0, 0, 0));
        lblTodayDate.setText("Current Date");

        lblCourseName.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        lblCourseName.setText("Course Name");

        lblSession.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        lblSession.setText("Session");

        lblRoom.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        lblRoom.setText("Room");

        lblReferenceNo.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N

        lblWellcomeMsg.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N

        buttonGroupAttendance.add(chkfreeSearch);
        chkfreeSearch.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        chkfreeSearch.setSelected(true);
        chkfreeSearch.setText("Find Student/Volunteer ");
        chkfreeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkfreeSearchActionPerformed(evt);
            }
        });

        dtStartDate.setDateFormatString("dd/MM/yyyy");
        dtStartDate.setMinimumSize(new java.awt.Dimension(26, 17));
        dtStartDate.setPreferredSize(new java.awt.Dimension(96, 16));

        OptGroupsurnameGivenName.add(optSurname);
        optSurname.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optSurname.setSelected(true);
        optSurname.setText("By Surname");
        optSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optSurnameActionPerformed(evt);
            }
        });

        OptGroupsurnameGivenName.add(optGivenName);
        optGivenName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optGivenName.setText("By Given Name");
        optGivenName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optGivenNameActionPerformed(evt);
            }
        });

        chkUseDateInterval.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        chkUseDateInterval.setText("Date Between");
        chkUseDateInterval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUseDateIntervalActionPerformed(evt);
            }
        });

        chkIncludeVolunteer.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        chkIncludeVolunteer.setText("Volunteer(y/n)");

        jLabel10.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("And");

        dtEndDate.setDateFormatString("dd/MM/yyyy");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SearchSmall.png"))); // NOI18N
        btnSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnPrintSearchedAttendance.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnPrintSearchedAttendance.setText("Print");

        buttonGroupAttendance.add(chkfreeSearch1);
        chkfreeSearch1.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        chkfreeSearch1.setText("Find Attendance ");
        chkfreeSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkfreeSearch1ActionPerformed(evt);
            }
        });

        tblSearchedAttendance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblSearchedAttendance.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tblSearchedAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblSearchedAttendance.setComponentPopupMenu(popMnuPrintAttendance);
        jScrollPane5.setViewportView(tblSearchedAttendance);

        txtStudentVolSearchAttendance.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtStudentVolSearchAttendance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblReferenceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRoom)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSession, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblWellcomeMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(3, 3, 3)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(252, 252, 252)
                                                    .addComponent(lblTodayDate)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                                                    .addComponent(btnPrintStudentOnlyAttendance))
                                                .addComponent(jScrollPane1))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(optSurname)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(optGivenName, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txtStudentVolSearchAttendance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(chkfreeSearch))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chkfreeSearch1)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(chkUseDateInterval)
                                                    .addComponent(chkIncludeVolunteer))
                                                .addGap(5, 5, 5)
                                                .addComponent(dtStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3)
                                                .addComponent(dtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                .addGap(54, 54, 54)
                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPrintSearchedAttendance))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnPrintVolOnlyAttendance)))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dtEndDate, dtStartDate});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblReferenceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCourseName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSession))
                    .addComponent(lblWellcomeMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRoom)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblTodayDate)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrintStudentOnlyAttendance)))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(btnPrintVolOnlyAttendance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkfreeSearch1)
                    .addComponent(chkfreeSearch, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(optGivenName)
                                .addComponent(chkUseDateInterval, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(optSurname))
                            .addComponent(dtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkIncludeVolunteer, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStudentVolSearchAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10)
                    .addComponent(dtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnPrintSearchedAttendance)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dtEndDate, dtStartDate});

        jTabbedPane1.addTab("Regular Attendance", jPanel1);

        tblEventAttendance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEventAttendance.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tblEventAttendance.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblEventAttendance);

        jLabel6.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        jLabel6.setText("Today's Event");

        jLabel8.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel8.setText("# Attendee ");

        txtNoEventAttendee.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtNoEventAttendee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNoEventAttendeeKeyTyped(evt);
            }
        });

        btnSaveNoAttendee.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnSaveNoAttendee.setText("Save");
        btnSaveNoAttendee.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSaveNoAttendee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNoAttendeeActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Between");

        btnSearchEventbydates.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SearchSmall.png"))); // NOI18N
        btnSearchEventbydates.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSearchEventbydates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEventbydatesActionPerformed(evt);
            }
        });

        dtStartDateEvent.setDateFormatString("dd/MM/yyyy");

        dtEndDateEvent.setDateFormatString("dd/MM/yyyy");

        jLabel11.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("And");

        btnPrintEventAttendance.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnPrintEventAttendance.setText("Print");
        btnPrintEventAttendance.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPrintEventAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNoEventAttendee, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveNoAttendee, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(dtStartDateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dtEndDateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSearchEventbydates))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchEventbydates, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtEndDateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtStartDateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrintEventAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNoEventAttendee, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveNoAttendee, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(334, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Event Attendance", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void set_TimeIn(){
        Date timeIn= new Date();
        timeIN = formatTimeInOut.format(timeIn);
    }
    
    private String get_TimeIn(){return timeIN;}
    
    private void set_TimeOut(){
        Date timeOuts= new Date();
        timeOut= formatTimeInOut.format(timeOuts.getTime());
    }
    
    private String get_TimeOut(){return timeOut;}
    
    private void set_StartDate(){
        try{
            String  feachDate=formatToDay.format(dtStartDate.getDate());
            startDate= feachDate;
        }catch(Exception ex){
            utilObj.setToolTip(dtStartDate, "Start Date  ! Error :" + ex);
        } 
    }
    private String get_StartDate(){return startDate;}
    
    private void set_EndDate(){
        try{
            String  feachDate=formatToDay.format(dtEndDate.getDate());
            endDate= feachDate;
        }catch(Exception ex){
            utilObj.setToolTip(dtEndDate, "End Date  ! Error :" + ex);
        } 
    }
    
    private String get_EndDate(){return endDate;}
    
    private void set_StartDateEvent(){
        try{
            String  feachDate=formatToDay.format(dtStartDateEvent.getDate());
            startDateEvent= feachDate;
        }catch(Exception ex){
            utilObj.setToolTip(dtStartDateEvent, "Start Date  ! Error :" + ex);
        } 
    }
    
    private String get_StartDateEvent(){return startDateEvent;}
    
    private void set_EndDateEvent(){
        try{
            String  feachDate=formatToDay.format(dtEndDateEvent.getDate());
            endDateEvent= feachDate;
        }catch(Exception ex){
            utilObj.setToolTip(dtEndDateEvent, "End Date  ! Error :" + ex);
        } 
    }
    
    private String get_EndDateEvent(){return endDateEvent;}
    
    private void set_WeekDay(){ 
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        weekDay=new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
    }
    
    private String get_WeekDay(){return weekDay;}
    
    private void set_ReferenceNo(String referenceCode){
                referenceNO=referenceCode;}
    
    private String get_ReferenceNo(){return referenceNO;}
           
    private void hide_Column(){
               
        tblVolunteerAttendance.removeColumn(tblVolunteerAttendance.getColumnModel().getColumn(0));
        tblVolunteerAttendance.removeColumn(tblVolunteerAttendance.getColumnModel().getColumn(0));
    }
    
    private void hide_ColumnStudent(){
               
        tblStudentAttendance.removeColumn(tblStudentAttendance.getColumnModel().getColumn(0));
        
    }
    
    private void optSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optSurnameActionPerformed
         JRadioButton button = (JRadioButton) evt.getSource();
 
        if (button == optSurname)  {
            txtStudentVolSearchAttendance.setText("");
            PromptSupport.setPrompt("Enter Surname...", txtStudentVolSearchAttendance);
            flagSearch=0;            
        }
    }//GEN-LAST:event_optSurnameActionPerformed

    private void optGivenNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optGivenNameActionPerformed
        JRadioButton button = (JRadioButton) evt.getSource();
 
        if (button == optGivenName)  {
            txtStudentVolSearchAttendance.setText("");
            PromptSupport.setPrompt("Enter Given Name...", txtStudentVolSearchAttendance);
            flagSearch=1;            
        }
    }//GEN-LAST:event_optGivenNameActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(chkfreeSearch.isSelected()){
         
         if(!("".equals(txtStudentVolSearchAttendance.getText()))){
            if(flagSearch==0) {
                                 // Fill Table  "select_Data_Package.get_BeneficiaryBySurName(?,?)
                        busObj.pop_Talbe(tblSearchedAttendance, "select_Data_Package.get_BeneficiaryBySurName(?,?)", 
                                            txtStudentVolSearchAttendance.getText().trim());
                        jScrollPane5.getViewport().add(tblSearchedAttendance);
            }else{
                // Fill Table
                        busObj.pop_Talbe(tblSearchedAttendance, "select_Data_Package.get_BeneficiaryByGivenName(?,?)", 
                                            txtStudentVolSearchAttendance.getText());
                        jScrollPane5.getViewport().add(tblSearchedAttendance);
            }
         }else JOptionPane.showMessageDialog(IntFrameAttandance.this,"Name filed is NULL");
        
        }else {
            if(flagSearch==0) {
             
             if(!("".equals(txtStudentVolSearchAttendance.getText()))){
                    set_StartDate();
                    set_EndDate();
                if(chkIncludeVolunteer.isSelected() && chkUseDateInterval.isSelected()==false){
                     // Fill Table
                        busObj.pop_Talbe(tblSearchedAttendance, "select_Data_Package.get_BeneficiaryBySurNameVol(?,?)", 
                                            txtStudentVolSearchAttendance.getText());
                        jScrollPane5.getViewport().add(tblSearchedAttendance);

                }else if (chkIncludeVolunteer.isSelected()==false && chkUseDateInterval.isSelected()){


                     // Fill Table
                        busObj.pop_TalbeAttendance(tblSearchedAttendance, "select_Data_Package.get_BenefBySurNameStuDate(?,?,to_date(?,'yy/MM/dd'),to_date(?,'yy/MM/dd'))", 
                                            txtStudentVolSearchAttendance.getText().trim(),get_StartDate(),get_EndDate());
                        jScrollPane5.getViewport().add(tblSearchedAttendance);
                }else if (chkIncludeVolunteer.isSelected() && chkUseDateInterval.isSelected()){
                     // Fill Table
                        busObj.pop_TalbeAttendance(tblSearchedAttendance, "select_Data_Package.get_BenefBySurNameVolDate(?,?,to_date(?,'yy/MM/dd'),to_date(?,'yy/MM/dd'))", 
                                             txtStudentVolSearchAttendance.getText(),get_StartDate(),get_EndDate());
                        jScrollPane5.getViewport().add(tblSearchedAttendance);
                }
             }else JOptionPane.showMessageDialog(IntFrameAttandance.this,"Name filed is NULL");  

            }else {
              
             if(!("".equals(txtStudentVolSearchAttendance.getText()))){
                    set_StartDate();
                    set_EndDate();
                if(chkIncludeVolunteer.isSelected() && chkUseDateInterval.isSelected()==false){ 
                    // Fill Table
                       busObj.pop_Talbe(tblSearchedAttendance, "select_Data_Package.get_BeneficiaryByGivenNameVol(?,?)", 
                                            txtStudentVolSearchAttendance.getText());
                        jScrollPane5.getViewport().add(tblSearchedAttendance);
                        
                }else if (chkIncludeVolunteer.isSelected()==false && chkUseDateInterval.isSelected()){
                      // Fill Table
                        busObj.pop_TalbeAttendance(tblSearchedAttendance, "select_Data_Package.get_BenefByGivenNameStuDate(?,?,to_date(?,'yy/MM/dd'),to_date(?,'yy/MM/dd'))", 
                                            txtStudentVolSearchAttendance.getText().trim(),get_StartDate(),get_EndDate());
                        jScrollPane5.getViewport().add(tblSearchedAttendance);
                }else if (chkIncludeVolunteer.isSelected() && chkUseDateInterval.isSelected()){
                     // Fill Table
                        busObj.pop_TalbeAttendance(tblSearchedAttendance, "select_Data_Package.get_BenefByGivenNameVolDate(?,?,to_date(?,'yy/MM/dd'),to_date(?,'yy/MM/dd'))", 
                                            txtStudentVolSearchAttendance.getText().trim(),get_StartDate(),get_EndDate());
                        jScrollPane5.getViewport().add(tblSearchedAttendance);
                }
            }else JOptionPane.showMessageDialog(IntFrameAttandance.this,"Name filed is NULL");  
            }
        }      
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchEventbydatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEventbydatesActionPerformed
        set_StartDateEvent();
        set_EndDateEvent();
        busObj.pop_TalbeAttendance(tblEventAttendance, "select_Data_Package.get_EventsByDates(?,to_date(?,'yy/MM/dd'),to_date(?,'yy/MM/dd'))","tblEventAttendance"
        ,get_StartDateEvent(),get_EndDateEvent());
        jScrollPane3.getViewport().add(tblEventAttendance);
    }//GEN-LAST:event_btnSearchEventbydatesActionPerformed

    private void btnSaveNoAttendeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNoAttendeeActionPerformed
       JDialog.setDefaultLookAndFeelDecorated(true);
         try{
            
                    if(!(txtNoEventAttendee.getText().isEmpty() || selectedRow==-1))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameAttandance.this, "Do you want to Update the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                                                        
                            busObj.update_EventNoAttende( Integer.parseInt(eventID), 
                                                          Integer.parseInt(txtNoEventAttendee.getText()),
                                                          "Closed");
                                           
                          
                            JOptionPane.showMessageDialog(IntFrameAttandance.this, "Data Update Successfully ! ","Data Update",JOptionPane.INFORMATION_MESSAGE);
                             
                            // Fill the Event table by the new Data
                            String toDay=formatToDay.format(today.getTime());
                            busObj.pop_Talbe(tblEventAttendance, "select_Data_Package.get_EventsByCurrentYear(?,?)",toDay);
                            jScrollPane3.getViewport().add(tblEventAttendance);
                           
                           
                           
                        }
                    } else JOptionPane.showMessageDialog(IntFrameAttandance.this, "Number of attendee should not be null and event should be selected  , " 
                            + "Event Name should not be NULL !","Data Insertion",JOptionPane.ERROR_MESSAGE);
            
          
            
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameAttandance.this, ex);
                }
    }//GEN-LAST:event_btnSaveNoAttendeeActionPerformed

    private void txtNoEventAttendeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoEventAttendeeKeyTyped
        char vChar = evt.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == evt.VK_BACK_SPACE)
                            || (vChar == evt.VK_DELETE))) {
                        utilObj.showErrorMessage(txtNoEventAttendee, "Only number allowed ! ");
                        evt.consume();
                    }
    }//GEN-LAST:event_txtNoEventAttendeeKeyTyped

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        utilObj.flag4=false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
       // txtStudentReferenceID.grabFocus();
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnPrintStudentOnlyAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintStudentOnlyAttendanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintStudentOnlyAttendanceActionPerformed

    private void mnuButtonAddtoAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuButtonAddtoAttendanceActionPerformed
       if(!(refNoToAttendance.isEmpty() && tblSearchedAttendance.getRowCount()==0)){
            set_ReferenceNo(refNoToAttendance);
            benfiType();
       }else JOptionPane.showMessageDialog(IntFrameAttandance.this, "The Student not selected or the table is null");
    }//GEN-LAST:event_mnuButtonAddtoAttendanceActionPerformed

    private void chkUseDateIntervalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUseDateIntervalActionPerformed
      if(chkUseDateInterval.isSelected()){
          dtStartDate.setEnabled(true);
          dtEndDate.setEnabled(true);
      }else {
          dtStartDate.setEnabled(false);
          dtEndDate.setEnabled(false);
              }
    }//GEN-LAST:event_chkUseDateIntervalActionPerformed

    private void chkfreeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkfreeSearchActionPerformed
       
        JRadioButton button = (JRadioButton) evt.getSource();
 
        if (button == chkfreeSearch)  {
            chkUseDateInterval.setEnabled(false);
            chkIncludeVolunteer.setEnabled(false);
           
            dtStartDate.setEnabled(false);
            dtEndDate.setEnabled(false);
            //optGivenName.setEnabled(true);
        }
    }//GEN-LAST:event_chkfreeSearchActionPerformed

    private void chkfreeSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkfreeSearch1ActionPerformed
       JRadioButton button = (JRadioButton) evt.getSource();
 
        if (button == chkfreeSearch1)  {
            chkUseDateInterval.setEnabled(true);
            chkIncludeVolunteer.setEnabled(true);
            //optGivenName.setEnabled(false);
        }
    }//GEN-LAST:event_chkfreeSearch1ActionPerformed
    
    private String greetingMsg()
    {
        GregorianCalendar time = new GregorianCalendar();  
        int hour = time.get(Calendar.HOUR_OF_DAY);  
                   
            if (hour < 12)  
                return "Good Morning!";  
            else if (hour < 17 && !(hour == 12))  
                return "Good Afternoon";  
            else if (hour == 12)  
                return "Good Noon";  
            else  
                return "Good Evening";  
 
    }
    
    private void benfiType()
    {   
            try{
                benefiType=busObj.getBenefiType(proc_BeneficiaryType, get_ReferenceNo());
                if(!(benefiType.isEmpty())){
                    lblWellcomeMsg.setText(greetingMsg() + " " +benefiType.get(1) + " !");
                    String type=benefiType.get(3);

                    if (type.equals("BLF_NONAcc")){
                        
                        checkBeneficiary(tblStudentAttendance,get_ReferenceNo());
                        if(flag==1){
                            set_TimeOut(); 
                            busObj.update_Attendance(get_ReferenceNo(), get_TimeOut(), calculateTotaltime(get_TimeOut(),timeInTbls), 1);
                            //pop or reload from attendance to the table
                            busObj.pop_Talbe(tblStudentAttendance, "select_Data_Package.get_Attendance(?,?)",type);
                            jScrollPane1.getViewport().add(tblStudentAttendance);
                            hide_ColumnStudent();
                          
                         }else
                            isCourseExist(type);
                    }else {
                        checkBeneficiary(tblVolunteerAttendance,get_ReferenceNo());
                        if(flag==1){
                            set_TimeOut();
                            busObj.update_Attendance(get_ReferenceNo(), get_TimeOut(), calculateTotaltime(get_TimeOut(),timeInTbls), 1);
                             //pop or reload from attendance to the table
                            busObj.pop_Talbe(tblVolunteerAttendance, "select_Data_Package.get_Attendance(?,?)",type);
                            jScrollPane2.getViewport().add(tblVolunteerAttendance);
                            hide_Column();

                        }else{
                            //save to attendance tbl
                            set_TimeIn();
                            Date todays=new Date();
                            String todaystring=formatToDay.format(todays.getTime());
                            try{

                            busObj.insert_AttendaceVol(get_ReferenceNo(),
                                    utilObj.sql_Date(formatToDay.parse(todaystring)), get_TimeIn(),0);
                            }catch(Exception ex){}
                            //pop or reload from attendance to the table
                            busObj.pop_Talbe(tblVolunteerAttendance, "select_Data_Package.get_Attendance(?,?)", 
                                    type); //BLF_VOL
                            jScrollPane2.getViewport().add(tblVolunteerAttendance);
                            hide_Column();
                         }
                    
                    }
                          
              }else{
                        lblReferenceNo.setText(null);
                        lblCourseName.setText(null);
                        lblSession.setText(null);
                        lblRoom.setText(null);
                        
                        lblWellcomeMsg.setText("Wrong Reference No!, Please check");
                       
              }
                                    
            }catch(SQLException Sqlex){
            JOptionPane.showMessageDialog(IntFrameAttandance.this, "Error Retriving the course form the Database"+ Sqlex); 
            }
       
    }
    
    private String calculateTotaltime(String timeOut,String timeIn){
        String dates = "";
        DecimalFormat crunchifyFormatter = new DecimalFormat("##");
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long s ;
        long hrs;
        long rest1;
        long min;
        long diff ;
        
            try{
            
                Date date2=formatTimeInOut.parse(timeOut);
                Date date1=formatTimeInOut.parse(timeIn);

                diff = date2.getTime() - date1.getTime();
                s = timeUnit.convert(diff, TimeUnit.MILLISECONDS);
                hrs = s / (60 * 60);
                rest1 = s - (hrs * 60 * 60); 
                min = rest1 / 60;  

                dates += fill2((int) hrs) + "h ";
                dates += fill2((int) min) + "m ";
            }catch(Exception ex){ JOptionPane.showConfirmDialog(IntFrameAttandance.this, "Error, total time calculation :" + ex);}
            return dates ;  
    }
    
    public String fill2(int value){
        
        String ret = String.valueOf(value);
        if (ret.length() < 2)
            ret = "0" + ret;            
        return ret;
    }
    
    private void isCourseExist(String type){
        try{
            
            set_WeekDay();
                       
            String[] tokens;
            scheduleCourse=busObj.getCourseSchedule(proc_CourseScheduleDay,get_WeekDay());
            courseAttend=busObj.getCourseAttend(proc_CourseAttend, get_ReferenceNo());
            if (!(scheduleCourse.isEmpty() && courseAttend.isEmpty())){
          
                lblCourseName.setEnabled(true);
                lblSession.setEnabled(true);
                lblRoom.setEnabled(true);
                
                int colNo = 5; 
                tokens=new String[scheduleCourse.size()];
                System.out.println(scheduleCourse.size());
                int t=0;     
                   for ( int i = 0; i < scheduleCourse.size(); i++ ) {
                     //   if ( i % colNo == 0) {
                        if ( i % scheduleCourse.size() == 0) {
                            if(courseAttend.contains(scheduleCourse.get(i))){

                                    for(int l=i;l<scheduleCourse.size();l++) {
                                    tokens[t]=scheduleCourse.get(l);
                                    t++;
                                    }

                            }
                        }
                    }
                    
                        if (!(tokens[0]==null)){
                            courseId=Integer.parseInt(tokens[0]);
                            lblReferenceNo.setText(referenceNO);
                            lblCourseName.setText("Course ID : "+tokens[0]);
                            lblSession.setText("Sesstion : "+tokens[2]+ " to " + tokens[3]);
                            lblRoom.setText("Room : " +tokens[4]);

                            //save to attendance tbl
                            set_TimeIn();
                            Date todays=new Date();
                            String todaystring=formatToDay.format(todays.getTime());
                                try{
                                busObj.insert_Attendace(get_ReferenceNo(),courseId,
                                        utilObj.sql_Date(formatToDay.parse(todaystring)), get_TimeIn(),0);
                                }catch(Exception ex){}
                            //pop or reload from attendance to the table
                            busObj.pop_Talbe(tblStudentAttendance, "select_Data_Package.get_Attendance(?,?)",type);
                            jScrollPane1.getViewport().add(tblStudentAttendance);
                            hide_ColumnStudent();
                            
                        }else lblWellcomeMsg.setText("Sorry! you May not have Class this time !");
            
            }else{                                            
                        lblWellcomeMsg.setText("Sorry! you dont not have course or class this time!");
                        /*
                        //pop or reload from attendance to the table
                        busObj.pop_Talbe(tblStudentAttendance, "select_Data_Package.get_Attendance(?,?)",type);
                        jScrollPane1.getViewport().add(tblStudentAttendance);
                        hide_ColumnStudent();*/
                      
            }
        }catch(SQLException Sqlex)
        { JOptionPane.showMessageDialog(IntFrameAttandance.this, "Error Retriving the course form the Database"+ Sqlex);}
       
    }
    
    private void checkBeneficiary(JTable table, String refNo){
    DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object o;
            for (int i = 0; i < model.getRowCount(); i++){
                
                    o=model.getValueAt(i, 6);
                  if (model.getValueAt(i, 0).equals(refNo) &&  o==null){
                      try{
                      timeInTbls= formatTimeInOut.format(formatTimeInOut.parse(String.valueOf(model.getValueAt(i, 5))));     
                      flag=1;
                      }catch(Exception ex){JOptionPane.showConfirmDialog(IntFrameAttandance.this,"Error during selecting In time from the table : "+ex);}
                      break;
                  } else flag=0;

                }
    
    }
     
    private void Tbl_SelectionMode(final JTable table){
           
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
                          printDebugData(table,selectedRow);
                            
                      }
                          
                    }
                  });
                } else {
                  table.setRowSelectionAllowed(false);
                }
    }
    
    private void printDebugData(JTable table,int selcted_Row) {
       
        try{ 
       
            javax.swing.table.TableModel model = table.getModel();
        
             if (table.equals(tblEventAttendance)){
                 eventID = String.valueOf(model.getValueAt(selcted_Row, 0).toString());
                 EventStat= String.valueOf(model.getValueAt(selcted_Row, 5).toString());
             }else 
                 refNoToAttendance= String.valueOf(model.getValueAt(selcted_Row, 0).toString());
                 // button.setText("Save");
        }catch(Exception ex){JOptionPane.showMessageDialog(IntFrameAttandance.this, ex);}
  }
    
    public  void prit_TblData(final JTable table,JButton print_Button){
   
         ActionListener printAction = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            try {
              //jTable2.print(JTable.PrintMode.NORMAL);
              MessageFormat headerFormat = new MessageFormat("Kensington Community Learning Center");
              MessageFormat footerFormat = new MessageFormat("- {0} -");
              table.print(JTable.PrintMode.FIT_WIDTH, headerFormat,footerFormat, true, new  HashPrintRequestAttributeSet(), true);
            } catch (PrinterException pe) {
                JOptionPane.showMessageDialog(IntFrameAttandance.this, "Error printing: " + pe.getMessage() );
             
            }
          }
        };
        print_Button.addActionListener(printAction);

    }
    
    protected void fireBarcode(String barcode) {
        for (BarcodeReader.BarcodeListener listener : listeners) {
            listener.onBarcodeRead(barcode);
        }
    }

    public void addBarcodeListener(BarcodeReader.BarcodeListener listener) {
        listeners.add(listener);
    }

    public void removeBarcodeListener(BarcodeReader.BarcodeListener listener) {
        listeners.remove(listener);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup OptGroupsurnameGivenName;
    private javax.swing.JButton btnPrintEventAttendance;
    private javax.swing.JButton btnPrintSearchedAttendance;
    private javax.swing.JButton btnPrintStudentOnlyAttendance;
    private javax.swing.JButton btnPrintVolOnlyAttendance;
    private javax.swing.JButton btnSaveNoAttendee;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchEventbydates;
    private javax.swing.ButtonGroup buttonGroupAttendance;
    private javax.swing.JCheckBox chkIncludeVolunteer;
    private javax.swing.JCheckBox chkUseDateInterval;
    private javax.swing.JRadioButton chkfreeSearch;
    private javax.swing.JRadioButton chkfreeSearch1;
    private com.toedter.calendar.JDateChooser dtEndDate;
    private com.toedter.calendar.JDateChooser dtEndDateEvent;
    private com.toedter.calendar.JDateChooser dtStartDate;
    private com.toedter.calendar.JDateChooser dtStartDateEvent;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCourseName;
    private javax.swing.JLabel lblReferenceNo;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JLabel lblSession;
    private javax.swing.JLabel lblTodayDate;
    private javax.swing.JLabel lblWellcomeMsg;
    private javax.swing.JRadioButtonMenuItem mnuButtonAddtoAttendance;
    private javax.swing.JRadioButton optGivenName;
    private javax.swing.JRadioButton optSurname;
    private javax.swing.JPopupMenu popMnuPrintAttendance;
    private javax.swing.JTable tblEventAttendance;
    private javax.swing.JTable tblSearchedAttendance;
    private javax.swing.JTable tblStudentAttendance;
    private javax.swing.JTable tblVolunteerAttendance;
    private javax.swing.JTextField txtNoEventAttendee;
    private javax.swing.JTextField txtStudentVolSearchAttendance;
    // End of variables declaration//GEN-END:variables
}
