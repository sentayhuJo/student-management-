
package formPackages;

import formPackages.classPackages.businessLayer;
import formPackages.classPackages.utility;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.awt.print.PrinterException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 * @author jo
 */
public class IntFrameProjectEventCourse extends javax.swing.JInternalFrame {

        private String proc_TargetNames="SELECT_DATA_PACKAGE.get_Blf_ProjectTarget(?)"; 
        private static final String NOT_SELECTABLE_OPTION="Select...";
        private int target_ID;
        private String target_Name;
        private int course_ID;
        private String course_Name;
        private float itq_Point;
        private String course_Description;
        private int shceduleID;
        
        private int event_ID;
        private String event_Name;
        private Date date_Event_Start;
        private String speaker;
        private static int evetTarget_ID;
                
        private boolean dot = false;
        private static int flag=0;
        
        private boolean ALLOW_ROW_SELECTION ;
        private int selectedRow;
        
        private String week_Day;
        private String session_Start;
        private String Session_End;
        private String roomNo;
        private int course_ID_Schedule;
        private SimpleDateFormat format;
                
        businessLayer busObj=new businessLayer();
        utility utilObj=new utility();
        
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        
        
    public IntFrameProjectEventCourse() {
        initComponents();
        selectCombo(cboTargetNames);
        busObj.pop_Combo(cboTargetNames, proc_TargetNames, "cboTargetNames");
           //if(cboTargetNames.getItemCount() != 0)cboTargetNames.setSelectedIndex(0);
           
        // Fill the default COURSE AND TARGET data to the table 
           
        busObj.pop_Talbe(tblTargetCourseSearched, "select_Data_Package.get_CourseInTargets(?,?)", 
        cboTargetNames.getSelectedItem().toString());
        jScrollPane1.getViewport().add(tblTargetCourseSearched);
                          
        txtProjectIDEvent.setText(busObj.IDholder_TargetNames.get(6).toString());
        hide_Column();
        
            
        // Fill the new inserted data to the table 
        busObj.pop_Talbe(tblCourseSchedule, "select_Data_Package.get_ClassSchedule(?)","tblCourseSchedule"); 
        jScrollPane2.getViewport().add(tblCourseSchedule);
        tblCourseSchedule.removeColumn(tblCourseSchedule.getColumnModel().getColumn(0));
       
        
        PromptSupport.setPrompt("Enter Course No...", txtSearchCourseID);
        PromptSupport.setPrompt("Enter Event Name...", txtSearchEvent);
                
        prit_TblData(tblEventList,mnuPopEventPrint);
        prit_TblData(tblEventList,popMnuPrintCourseTbl);
        prit_TblData(tblCourseSchedule,popMnuPrint);
         
        btnUpdateCourse.setVisible(false);
        btnDeleteCourse.setVisible(false);
        
        btnDeleteSchedule.setVisible(false);
      
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optBtnGroupSearchby = new javax.swing.ButtonGroup();
        popMenuEventTbl = new javax.swing.JPopupMenu();
        popMenuChkEditMode = new javax.swing.JCheckBoxMenuItem();
        mnuPopEventPrint = new javax.swing.JMenuItem();
        popMenuCourseTargetTbl = new javax.swing.JPopupMenu();
        popMenuChkEditCourseTargetTbl = new javax.swing.JCheckBoxMenuItem();
        popMnuPrintCourseTbl = new javax.swing.JMenuItem();
        popMnuSchedule = new javax.swing.JPopupMenu();
        popMnuCheckSchedule = new javax.swing.JCheckBoxMenuItem();
        popMnuPrint = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTargetCourseSearched = new javax.swing.JTable();
        tabProCourseEvent = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTargetID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNewProectTarget = new javax.swing.JTextField();
        btnNewTarget = new javax.swing.JButton();
        btnUpdateTarget = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnListCourse = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
        txtITQPoint = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCourseID = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCourseDescription = new javax.swing.JTextArea();
        btnUpdateCourse = new javax.swing.JButton();
        btnDeleteCourse = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblEventList = new javax.swing.JTable(){

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
                    String type = String.valueOf(getModel().getValueAt(modelRow, 5));
                    if ("Waiting".equals(type)) c.setBackground(Color.GREEN);

                }

                return c;
            }
        };
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtProjectIDEvent = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEventID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtEventNmae = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dtEventStartDate = new com.toedter.calendar.JCalendar();
        btnSaveEvent = new javax.swing.JButton();
        txtSearchEvent = new javax.swing.JTextField();
        btnSearchEvent = new javax.swing.JButton();
        btnUpdateEvent = new javax.swing.JButton();
        cboServiceSource = new javax.swing.JComboBox();
        btnDeleteEvent = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cboDaySchedule = new javax.swing.JComboBox();
        Date dt=new Date();
        SpinnerDateModel sm=new SpinnerDateModel(dt,null,null,Calendar.HOUR_OF_DAY);
        JSTime1 = new javax.swing.JSpinner(sm);
        jLabel15 = new javax.swing.JLabel();
        lblCourseID = new javax.swing.JLabel();
        lblCourseName = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtRoomNo = new javax.swing.JTextField();
        Date dt2=new Date();
        SpinnerDateModel sm2=new SpinnerDateModel(dt2,null,null,Calendar.HOUR_OF_DAY);
        JSTime2 = new javax.swing.JSpinner(sm2);
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCourseSchedule = new javax.swing.JTable(){

            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }
        };
        btnSaveSchedule = new javax.swing.JButton();
        btnDeleteSchedule = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cboTargetNames = new javax.swing.JComboBox();
        txtSearchCourseID = new javax.swing.JTextField();
        btnSearchCourseID = new javax.swing.JButton();
        btnAddCourse = new javax.swing.JButton();
        optByCourseID = new javax.swing.JRadioButton();
        optByCourseName = new javax.swing.JRadioButton();

        popMenuChkEditMode.setText("Change to Edit Mode");
        popMenuChkEditMode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                popMenuChkEditModeItemStateChanged(evt);
            }
        });
        popMenuChkEditMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuChkEditModeActionPerformed(evt);
            }
        });
        popMenuEventTbl.add(popMenuChkEditMode);

        mnuPopEventPrint.setText("Print");
        mnuPopEventPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPopEventPrintActionPerformed(evt);
            }
        });
        popMenuEventTbl.add(mnuPopEventPrint);

        popMenuChkEditCourseTargetTbl.setText("Change to Edit Mode");
        popMenuChkEditCourseTargetTbl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                popMenuChkEditCourseTargetTblItemStateChanged(evt);
            }
        });
        popMenuChkEditCourseTargetTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuChkEditCourseTargetTblActionPerformed(evt);
            }
        });
        popMenuCourseTargetTbl.add(popMenuChkEditCourseTargetTbl);

        popMnuPrintCourseTbl.setText("Print");
        popMnuPrintCourseTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuPrintCourseTblActionPerformed(evt);
            }
        });
        popMenuCourseTargetTbl.add(popMnuPrintCourseTbl);

        popMnuCheckSchedule.setText("Delete Mode");
        popMnuCheckSchedule.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                popMnuCheckScheduleItemStateChanged(evt);
            }
        });
        popMnuCheckSchedule.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                popMnuCheckScheduleStateChanged(evt);
            }
        });
        popMnuCheckSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuCheckScheduleActionPerformed(evt);
            }
        });
        popMnuSchedule.add(popMnuCheckSchedule);

        popMnuPrint.setText("Print Schedule");
        popMnuSchedule.add(popMnuPrint);

        setClosable(true);
        setIconifiable(true);
        setTitle("Manage Course and Event/Service");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectTarget.png"))); // NOI18N
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

        tblTargetCourseSearched.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblTargetCourseSearched.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tblTargetCourseSearched.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTargetCourseSearched.setComponentPopupMenu(popMenuCourseTargetTbl);
        tblTargetCourseSearched.setEnabled(false);
        jScrollPane1.setViewportView(tblTargetCourseSearched);

        tabProCourseEvent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabProCourseEvent.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tabProCourseEvent.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabProCourseEventStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel1.setText("Targat ID");

        txtTargetID.setEditable(false);
        txtTargetID.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtTargetID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTargetIDKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel2.setText("Targate Name");

        txtNewProectTarget.setEditable(false);
        txtNewProectTarget.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        btnNewTarget.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnNewTarget.setText("New Target");
        btnNewTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTargetActionPerformed(evt);
            }
        });

        btnUpdateTarget.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnUpdateTarget.setText("Update Target");
        btnUpdateTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTargetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTargetID, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNewProectTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNewTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTargetID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNewProectTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNewTarget)
                        .addComponent(btnUpdateTarget))
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        btnListCourse.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnListCourse.setText("Save ");
        btnListCourse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnListCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListCourseActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel6.setText("Course Description");

        txtCourseName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtCourseName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCourseNameKeyTyped(evt);
            }
        });

        txtITQPoint.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtITQPoint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtITQPointKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel5.setText("IT Q Point");

        jLabel4.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel4.setText("Course Name");

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel3.setText("Course ID");

        txtCourseID.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtCourseID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCourseIDKeyTyped(evt);
            }
        });

        txtCourseDescription.setColumns(20);
        txtCourseDescription.setRows(5);
        jScrollPane3.setViewportView(txtCourseDescription);

        btnUpdateCourse.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnUpdateCourse.setText("Update");
        btnUpdateCourse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCourseActionPerformed(evt);
            }
        });

        btnDeleteCourse.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnDeleteCourse.setText("Delete");
        btnDeleteCourse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtITQPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(192, 192, 192))
                            .addComponent(jScrollPane3))))
                .addGap(323, 323, 323))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCourseID, txtCourseName, txtITQPoint});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtITQPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListCourse)
                    .addComponent(btnUpdateCourse)
                    .addComponent(btnDeleteCourse))
                .addGap(10, 10, 10))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCourseID, txtCourseName, txtITQPoint});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 747, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabProCourseEvent.addTab("Register New Project Targates and Courses", jPanel1);

        jPanel2.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        tblEventList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEventList.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        tblEventList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Event ID", "Event Name", "Speaker", "Event Date", "# Attendee"
            }
        ));
        tblEventList.setComponentPopupMenu(popMenuEventTbl);
        tblEventList.setEnabled(false);
        jScrollPane5.setViewportView(tblEventList);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel7.setText("Project Target ID ");

        txtProjectIDEvent.setEditable(false);
        txtProjectIDEvent.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        jLabel8.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel8.setText("Service/Event ID");

        txtEventID.setEditable(false);
        txtEventID.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtEventID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEventIDKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Description");

        txtEventNmae.setColumns(20);
        txtEventNmae.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtEventNmae.setRows(5);
        jScrollPane6.setViewportView(txtEventNmae);

        jLabel12.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Source");

        jLabel10.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel10.setText("Event Start Date");

        btnSaveEvent.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnSaveEvent.setText("New Event");
        btnSaveEvent.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSaveEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEventActionPerformed(evt);
            }
        });

        txtSearchEvent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtSearchEvent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchEventKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchEventKeyPressed(evt);
            }
        });

        btnSearchEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SearchSmall.png"))); // NOI18N
        btnSearchEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEventActionPerformed(evt);
            }
        });

        btnUpdateEvent.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnUpdateEvent.setText("Update");
        btnUpdateEvent.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEventActionPerformed(evt);
            }
        });

        cboServiceSource.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboServiceSource.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3rd Party Activity", "Direct Via Reception", "Via Our Website", "Other KCLC Activity", "No Shows" }));

        btnDeleteEvent.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnDeleteEvent.setText("Delete");
        btnDeleteEvent.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEventActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtSearchEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnSearchEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtEventID, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProjectIDEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addComponent(cboServiceSource, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtEventStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnDeleteEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtEventStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveEvent)
                            .addComponent(btnUpdateEvent)
                            .addComponent(btnDeleteEvent)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(txtSearchEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(167, 167, 167))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtProjectIDEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(txtEventID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(btnSearchEvent)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboServiceSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)))))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtEventID, txtProjectIDEvent, txtSearchEvent});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(116, 116, 116))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabProCourseEvent.addTab("Register Accessing Info, Events and Service", jPanel2);

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Time/Period");

        jLabel14.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Day");

        cboDaySchedule.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboDaySchedule.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" }));

        JSpinner.DateEditor de=new JSpinner.DateEditor(JSTime1,"HH:mm");
        JSTime1.setEditor(de);
        JSTime1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        jLabel15.setText("To");

        lblCourseID.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        lblCourseName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        jLabel16.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Room No.");

        txtRoomNo.setPreferredSize(new java.awt.Dimension(64, 22));

        JSpinner.DateEditor de2=new JSpinner.DateEditor(JSTime2,"HH:mm");
        JSTime2.setEditor(de2);
        JSTime2.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JSTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboDaySchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRoomNo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JSTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRoomNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(cboDaySchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JSTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {JSTime1, JSTime2});

        tblCourseSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Week Day", "Session Start Time", "Session End Time", "Course Given"
            }
        ));
        tblCourseSchedule.setComponentPopupMenu(popMnuSchedule);
        tblCourseSchedule.setEnabled(false);
        jScrollPane2.setViewportView(tblCourseSchedule);

        btnSaveSchedule.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnSaveSchedule.setText("Save");
        btnSaveSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveScheduleActionPerformed(evt);
            }
        });

        btnDeleteSchedule.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnDeleteSchedule.setText("Delete");
        btnDeleteSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteScheduleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(613, 613, 613)
                        .addComponent(btnDeleteSchedule)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSaveSchedule)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveSchedule)
                    .addComponent(btnDeleteSchedule))
                .addContainerGap())
        );

        tabProCourseEvent.addTab("Weeklly Course Schedule", jPanel7);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel11.setText("Existing Targets");

        cboTargetNames.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        cboTargetNames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTargetNamesItemStateChanged(evt);
            }
        });
        cboTargetNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTargetNamesActionPerformed(evt);
            }
        });

        txtSearchCourseID.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtSearchCourseID.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtSearchCourseID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchCourseIDKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchCourseIDKeyPressed(evt);
            }
        });

        btnSearchCourseID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SearchSmall.png"))); // NOI18N
        btnSearchCourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCourseIDActionPerformed(evt);
            }
        });

        btnAddCourse.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnAddCourse.setText("View and Add Course");
        btnAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCourseActionPerformed(evt);
            }
        });

        optBtnGroupSearchby.add(optByCourseID);
        optByCourseID.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optByCourseID.setSelected(true);
        optByCourseID.setText("By Course ID");
        optByCourseID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optByCourseIDActionPerformed(evt);
            }
        });

        optBtnGroupSearchby.add(optByCourseName);
        optByCourseName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        optByCourseName.setText("By Course Name");
        optByCourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optByCourseNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cboTargetNames, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddCourse)))
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSearchCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(optByCourseID)
                        .addGap(18, 18, 18)
                        .addComponent(optByCourseName)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(optByCourseID)
                    .addComponent(optByCourseName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTargetNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCourseID)
                    .addComponent(btnAddCourse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboTargetNames, txtSearchCourseID});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addComponent(tabProCourseEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabProCourseEvent)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void set_RoomNo(){ roomNo=txtRoomNo.getText();}
    private String get_RoomNo(){return roomNo;}
    
    private void set_WeekDay(){week_Day=cboDaySchedule.getSelectedItem().toString();} 
    private String get_weekDay(){return week_Day;}
    
    private void set_SessionStart(){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        session_Start=String.valueOf(format.format(JSTime1.getValue()));
    } 
    private String get_SessionStart(){return session_Start;}
    
    private void set_SessionEnd(){
         SimpleDateFormat format = new SimpleDateFormat("HH:mm");
         Session_End=String.valueOf(format.format(JSTime2.getValue()));
        
    } 
    private String get_SessionEnd(){return Session_End;}
    
    
    private void set_TargetID(){target_ID=Integer.parseInt(txtTargetID.getText());}
    private int get_TargetID(){return target_ID;}
    
    private void set_TargeName(){target_Name=txtNewProectTarget.getText();}
    private String get_TargetName(){return target_Name;}
    
    private void set_CourseID(){course_ID=Integer.parseInt(txtCourseID.getText());}
    private int get_CourseID(){return course_ID;}
    
    private void set_CourseName(){course_Name=txtCourseName.getText();}
    private String get_CourseName(){return course_Name;}
    
    private void set_itqPoint(){ 
        if(!(txtITQPoint.getText().isEmpty())) itq_Point=Float.parseFloat(txtITQPoint.getText());
        else txtITQPoint.setText(null);
        }
    private float get_itqPoint(){return itq_Point;}
    
    private void set_CourseDescription(){course_Description=txtCourseDescription.getText();}
    private String get_CourseDescription(){return course_Description;}
    
    private void set_EventID(){event_ID=Integer.parseInt(txtEventID.getText());}
    private int get_EventID(){return event_ID;}
    
    private void set_EventName(){event_Name=txtEventNmae.getText();}
    private String get_EventName(){return event_Name;}
    
    private void set_DateEventStart(){
        try{
            String  feachDate=dateFormat.format(dtEventStartDate.getDate());
            Date feachdate=dateFormat.parse(feachDate);
            date_Event_Start= feachdate;
        }catch(Exception ex){
            utilObj.setToolTip(dtEventStartDate, "Registration Date error ! Error :" + ex);
        }  
    }
    private Date get_DateEventStart(){return date_Event_Start;}
    
    private void set_Speaker(){speaker=cboServiceSource.getSelectedItem().toString();}
    private String get_Speaker(){return speaker;}
    
    private void set_EventTargetID(){evetTarget_ID= Integer.parseInt(txtProjectIDEvent.getText());}
    private int get_EventTargetID(){return evetTarget_ID;}
       
    private void hide_Column(){
               
        tblTargetCourseSearched.removeColumn(tblTargetCourseSearched.getColumnModel().getColumn(0));
        tblTargetCourseSearched.removeColumn(tblTargetCourseSearched.getColumnModel().getColumn(3));
    }
    private void cboTargetNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTargetNamesActionPerformed
   
    }//GEN-LAST:event_cboTargetNamesActionPerformed

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
       
        if(cboTargetNames.getItemCount()!=0){
        txtTargetID.setText(busObj.IDholder_TargetNames.get(cboTargetNames.getSelectedIndex()).toString());
        txtNewProectTarget.setText(cboTargetNames.getSelectedItem().toString() );
        txtTargetID.setEditable(false);
        txtNewProectTarget.setEditable(false);
        
        // Fill Table
        busObj.pop_Talbe(tblTargetCourseSearched, "select_Data_Package.get_CourseInTargets(?,?)", 
                            cboTargetNames.getSelectedItem().toString());
        jScrollPane1.getViewport().add(tblTargetCourseSearched);
        hide_Column();
        
        }
        
         
        
        
    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void clear_Fields(){
        
        btnListCourse.setText("Save");
       
        txtCourseID.setText("");
        txtCourseName.setText("");
        txtITQPoint.setText("");
        txtCourseDescription.setText("");
        txtCourseID.grabFocus();
        
    }
    
    private void clear_EventFields()
    {
        btnSaveEvent.setText("Save");
        
        txtEventID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
        txtEventNmae.setText("");
        //txtSpeaker.setText("");
        txtEventID.grabFocus();
       
    }
    private void clear_EventFieldsUdateOff()
    {
        btnSaveEvent.setText("New Event");
        txtEventID.setText("");
        txtEventNmae.setText("");
        //txtSpeaker.setText("");
        //txtEventID.grabFocus();
       
    }
    private void btnListCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListCourseActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
         try{
            if(!(btnListCourse.getText()=="Add Next")){
                    if(!(txtTargetID.getText().isEmpty() || txtCourseName.getText().isEmpty() || txtCourseID.getText().isEmpty()))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameProjectEventCourse.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_TargetID();
                            set_CourseID();
                            set_CourseName();
                            set_itqPoint();
                            set_CourseDescription();
                            busObj.insert_Course(get_CourseID(), 
                                                 get_TargetID(), 
                                                 get_CourseName(), 
                                                 get_itqPoint(), 
                                                 get_CourseDescription());
                            
                            JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnListCourse.setText("Add Next");
                            
                            // Fill the new inserted data to the table 
                            busObj.pop_Talbe(tblTargetCourseSearched, "select_Data_Package.get_CourseInTargets(?,?)", 
                            cboTargetNames.getSelectedItem().toString());
                            jScrollPane1.getViewport().add(tblTargetCourseSearched);
                           hide_Column();
                           
                        }
                    } else JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Targate ID, Target Name , " 
                            + "Course ID and Course Name should not be NULL !","Data Insertion",JOptionPane.ERROR_MESSAGE);
            
            }else clear_Fields();
            
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Missing Field, try to select the target in order to insert the new course");
                }
        
    }//GEN-LAST:event_btnListCourseActionPerformed

    private void txtCourseIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCourseIDKeyTyped
        
         char vChar = evt.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE))) {
                        utilObj.showErrorMessage(txtCourseID, "Only number allowed ! ");
                        evt.consume();
                    }
            
    }//GEN-LAST:event_txtCourseIDKeyTyped

    private void txtITQPointKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtITQPointKeyTyped
            
            char vChar = evt.getKeyChar();
            if (txtITQPoint.getText().equals(""))
                dot = false;
            if (dot == false){
                if (vChar == '.') dot = true;
                else if (!(Character.isDigit(vChar)
                        || (vChar == KeyEvent.VK_BACK_SPACE)
                        || (vChar == KeyEvent.VK_DELETE))) {
                        utilObj.showErrorMessage(txtCourseID, "Only number allowed ! ");
                        evt.consume();
                }
            } else {
                if (!(Character.isDigit(vChar)
                        || (vChar == KeyEvent.VK_BACK_SPACE)
                        || (vChar == KeyEvent.VK_DELETE))) {
                        utilObj.showErrorMessage(txtCourseID, "Only number allowed ! ");
                        evt.consume();
                }
            }
    }//GEN-LAST:event_txtITQPointKeyTyped

    private void txtCourseNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCourseNameKeyTyped
        
        
    }//GEN-LAST:event_txtCourseNameKeyTyped

    private void btnNewTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTargetActionPerformed
         
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        if(!(btnNewTarget.getText()=="New Target")){
            if(!(txtTargetID.getText().isEmpty() || txtNewProectTarget.getText().isEmpty() ))  {
                int response = JOptionPane.showConfirmDialog(IntFrameProjectEventCourse.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_TargetID();
                            set_TargeName();
                            busObj.insert_Target(get_TargetID(),
                                                 get_TargetName());
                            
                            JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnNewTarget.setText("New Target");
                            
                            cboTargetNames.removeAllItems();
                            busObj.pop_Combo(cboTargetNames, proc_TargetNames, "cboTargetNames");
                            if(cboTargetNames.getItemCount() != 0)cboTargetNames.setSelectedIndex(1);
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Targate ID, Target Name shoud not be NULL !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
           
        }else {
            txtTargetID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
            txtNewProectTarget.setText("");
            txtTargetID.setEditable(false);
            txtNewProectTarget.setEditable(true);
            btnNewTarget.setText("Save Target");
          
        }
    }//GEN-LAST:event_btnNewTargetActionPerformed

    private void txtTargetIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTargetIDKeyTyped
       char vChar = evt.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE))) {
                        utilObj.showErrorMessage(txtTargetID, "Only number allowed ! ");
                        evt.consume();
                    }
    }//GEN-LAST:event_txtTargetIDKeyTyped

    private void btnSaveEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEventActionPerformed
       
        JDialog.setDefaultLookAndFeelDecorated(true);
         try{
            if(!(btnSaveEvent.getText()=="New Event")){
                    if(!(txtProjectIDEvent.getText().isEmpty() || txtEventID.getText().isEmpty() || txtEventNmae.getText().isEmpty()))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameProjectEventCourse.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_EventID();
                            set_EventTargetID();
                            set_EventName();
                            set_DateEventStart();
                            set_Speaker();
                           
                            busObj.insert_Event( get_EventID(), 
                                                 get_EventTargetID(), 
                                                 get_EventName(), 
                                                 utilObj.sql_Date(get_DateEventStart()), 
                                                 get_Speaker());
                            
                            busObj.insert_EventAttendance( get_EventID(),
                                                           0 );
                            
                            JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                             
                            // Fill the Event table by the new Data
                            String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
                            busObj.pop_Talbe(tblEventList, "select_Data_Package.get_EventsByCurrentYear(?,?)",year.substring(2, 4) );
                            jScrollPane5.getViewport().add(tblEventList);
                            
                            
                            btnSaveEvent.setText("New Event");
                           
                           
                        }
                    } else JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Targate ID, Event ID , " 
                            + "Event Name should not be NULL !","Data Insertion",JOptionPane.ERROR_MESSAGE);
            
            }else clear_EventFields();
            
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Missing Field, Check the input");
                }
    }//GEN-LAST:event_btnSaveEventActionPerformed

    private void txtEventIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEventIDKeyTyped
       char vChar = evt.getKeyChar();
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE))) {
                        utilObj.showErrorMessage(txtEventID, "Only number allowed ! ");
                        evt.consume();
                    }
    }//GEN-LAST:event_txtEventIDKeyTyped

    private void cboTargetNamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTargetNamesItemStateChanged
        if (evt.getStateChange() == evt.SELECTED) {
                   
           }

    }//GEN-LAST:event_cboTargetNamesItemStateChanged

    private void optByCourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optByCourseNameActionPerformed
       JRadioButton button = (JRadioButton) evt.getSource(); 
       if (button == optByCourseName) {
            txtSearchCourseID.setText("");
            PromptSupport.setPrompt("Enter Course Name...", txtSearchCourseID);
            flag=1;
        }
    
 
    }//GEN-LAST:event_optByCourseNameActionPerformed

    private void txtSearchCourseIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCourseIDKeyTyped
        char vChar = evt.getKeyChar();
        
        if (flag==0){
            
                    if (!(Character.isDigit(vChar)
                            || (vChar == KeyEvent.VK_BACK_SPACE)
                            || (vChar == KeyEvent.VK_DELETE))) {
                        utilObj.showErrorMessage(txtSearchCourseID, "Only number allowed ! ");
                        evt.consume();
                    }
        }
        
    }//GEN-LAST:event_txtSearchCourseIDKeyTyped

    private void optByCourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optByCourseIDActionPerformed
        JRadioButton button = (JRadioButton) evt.getSource();
 
        if (button == optByCourseID)  {
            txtSearchCourseID.setText("");
            PromptSupport.setPrompt("Enter Course No...", txtSearchCourseID);
            flag=0;            
        }
    }//GEN-LAST:event_optByCourseIDActionPerformed

    private void btnSearchCourseIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCourseIDActionPerformed
        if(flag==0) {
            // Fill Table
            busObj.pop_Talbe(tblTargetCourseSearched, "select_Data_Package.get_CourseWithID(?,TO_NUMBER(?))", 
                                txtSearchCourseID.getText().trim());
            jScrollPane1.getViewport().add(tblTargetCourseSearched);
             hide_Column();
            
        }else {
                // Fill Table
            busObj.pop_Talbe(tblTargetCourseSearched, "select_Data_Package.get_CourseWithName(?,?)", 
                                txtSearchCourseID.getText().trim());
            jScrollPane1.getViewport().add(tblTargetCourseSearched);
             hide_Column();
           
        }
    }//GEN-LAST:event_btnSearchCourseIDActionPerformed

    private void tabProCourseEventStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabProCourseEventStateChanged
         
          JTabbedPane sourceTabbedPane = (JTabbedPane) evt.getSource();
          int index = sourceTabbedPane.getSelectedIndex();
          
          if(index==1){
               // fill the default EVENT data to the table

               String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

               busObj.pop_Talbe(tblEventList, "select_Data_Package.get_EventsByCurrentYear(?,?)",year.substring(2, 4) );
               jScrollPane5.getViewport().add(tblEventList);
               
               // Hide the Event ID Columnn 
               tblEventList.removeColumn(tblEventList.getColumnModel().getColumn(0));
               btnUpdateEvent.setVisible(false);
                btnDeleteEvent.setVisible(false);
          }
        
    }//GEN-LAST:event_tabProCourseEventStateChanged

    private void btnSearchEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEventActionPerformed
               
               busObj.pop_Talbe(tblEventList, "select_Data_Package.get_EventsByName(?,?)",txtSearchEvent.getText());
               jScrollPane5.getViewport().add(tblEventList);
               tblEventList.removeColumn(tblEventList.getColumnModel().getColumn(0));
               
    }//GEN-LAST:event_btnSearchEventActionPerformed

    private void popMenuChkEditModeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_popMenuChkEditModeItemStateChanged
       
        if (popMenuChkEditMode.isSelected()){
            tblEventList.setEnabled(true);
            ALLOW_ROW_SELECTION = true;
            btnUpdateEvent.setVisible(true);
            btnDeleteEvent.setVisible(true);
            btnSaveEvent.setEnabled(false);
            
            
            Tbl_SelectionMode(tblEventList,btnSaveEvent,"tblEventList");
        
            
        }else{
            tblEventList.setEnabled(false);
            ALLOW_ROW_SELECTION = false;
            btnUpdateEvent.setVisible(false);
            btnDeleteEvent.setVisible(false);
            btnSaveEvent.setEnabled(true);
          
            
            clear_EventFieldsUdateOff();
          
        }
            
    }//GEN-LAST:event_popMenuChkEditModeItemStateChanged

    private void popMenuChkEditModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuChkEditModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popMenuChkEditModeActionPerformed

    private void popMenuChkEditCourseTargetTblItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_popMenuChkEditCourseTargetTblItemStateChanged
        if (popMenuChkEditCourseTargetTbl.isSelected()){
            tblTargetCourseSearched.setEnabled(true);
            ALLOW_ROW_SELECTION = true;
            btnUpdateCourse.setVisible(true);
            btnUpdateTarget.setVisible(true);
            btnDeleteCourse.setVisible(true);
            
            btnListCourse.setEnabled(false);
            btnNewTarget.setEnabled(false);
          
            txtNewProectTarget.setEditable(true);
            
            txtTargetID.setText("");
            txtNewProectTarget.setText("");
            btnNewTarget.setText("New Target");
            Tbl_SelectionMode(tblTargetCourseSearched,btnListCourse,"tblTargetCourseSearched");
            
            
        }else{
            tblTargetCourseSearched.setEnabled(false);
            ALLOW_ROW_SELECTION = false;
            btnUpdateCourse.setVisible(false);
            btnDeleteCourse.setVisible(false);
            btnListCourse.setEnabled(true);
            clear_Fields();
            btnNewTarget.setEnabled(true);
            btnUpdateTarget.setVisible(false);
             
            txtNewProectTarget.setEditable(false);
            
            
        }
    }//GEN-LAST:event_popMenuChkEditCourseTargetTblItemStateChanged

    private void btnUpdateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEventActionPerformed
       JDialog.setDefaultLookAndFeelDecorated(true);
         try{
            
                    if(!(txtEventID.getText().isEmpty() || txtEventNmae.getText().isEmpty()))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameProjectEventCourse.this, "Do you want to Update the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_EventID();
                            set_EventName();
                            set_DateEventStart();
                            set_Speaker();
                           
                            busObj.update_Event( get_EventID(), 
                                                 get_EventName(), 
                                                 utilObj.sql_Date(get_DateEventStart()), 
                                                 get_Speaker());
                          
                            JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Data Update Successfully ! ","Data Update",JOptionPane.INFORMATION_MESSAGE);
                             
                            // Fill the Event table by the new Data
                            String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
                            busObj.pop_Talbe(tblEventList, "select_Data_Package.get_EventsByCurrentYear(?,?)",year.substring(2, 4) );
                            jScrollPane5.getViewport().add(tblEventList);
                            
                           tblEventList.removeColumn(tblEventList.getColumnModel().getColumn(0));
                           
                           
                        }
                    } else JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Targate ID, Event ID , " 
                            + "Event Name should not be NULL !","Data Insertion",JOptionPane.ERROR_MESSAGE);
            
          
            
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, ex);
                }
    }//GEN-LAST:event_btnUpdateEventActionPerformed

    private void btnUpdateCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCourseActionPerformed
       JDialog.setDefaultLookAndFeelDecorated(true);
         
       try{
           
                    if(!(txtCourseName.getText().isEmpty() || txtCourseID.getText().isEmpty()))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameProjectEventCourse.this, "Do you want to Update the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_CourseID();
                            set_CourseName();
                            set_itqPoint();
                            set_CourseDescription();
                            busObj.update_Course(get_CourseID(), 
                                                 get_CourseName(), 
                                                 get_itqPoint(), 
                                                 get_CourseDescription());
                            
                            JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Data Update Successfully ! ","Data Update",JOptionPane.INFORMATION_MESSAGE);
                          
                            
                            // Fill the new inserted data to the table 
                            busObj.pop_Talbe(tblTargetCourseSearched, "select_Data_Package.get_CourseInTargets(?,?)", 
                            cboTargetNames.getSelectedItem().toString());
                            jScrollPane1.getViewport().add(tblTargetCourseSearched);
                            hide_Column();
                           
                        }
                    } else JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Targate ID, Target Name , " 
                            + "Course ID and Course Name should not be NULL !","Data Insertion",JOptionPane.ERROR_MESSAGE);
           
            
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, ex);
                }
    }//GEN-LAST:event_btnUpdateCourseActionPerformed

    private void btnUpdateTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTargetActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        
            if(!(txtTargetID.getText().isEmpty() || txtNewProectTarget.getText().isEmpty() ))  {
                int response = JOptionPane.showConfirmDialog(IntFrameProjectEventCourse.this, "Do you want to Update the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_TargetID();
                            set_TargeName();
                            busObj.update_Target(get_TargetID(),
                                                 get_TargetName());
                            
                            JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Data Update Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                           
                            cboTargetNames.removeAllItems();
                            busObj.pop_Combo(cboTargetNames, proc_TargetNames, "cboTargetNames");
                            if(cboTargetNames.getItemCount() != 0)cboTargetNames.setSelectedIndex(1);
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Targate ID, Target Name shoud not be NULL !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_btnUpdateTargetActionPerformed

    private void popMnuPrintCourseTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuPrintCourseTblActionPerformed
       
    }//GEN-LAST:event_popMnuPrintCourseTblActionPerformed

    private void mnuPopEventPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPopEventPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuPopEventPrintActionPerformed

    private void btnSaveScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveScheduleActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
         
       try{
           
                    if(!(lblCourseID.getText().isEmpty()))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameProjectEventCourse.this, "Do you want to Save the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                                                      
                            set_WeekDay();
                            set_SessionStart();
                            set_SessionEnd();
                            set_RoomNo();
                            busObj.insert_CourseSchedule(course_ID_Schedule, 
                                                 get_weekDay(), 
                                                 get_SessionStart(), 
                                                 get_SessionEnd(),
                                                 get_RoomNo());
                            
                            JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Data Save Successfully ! ","Data Update",JOptionPane.INFORMATION_MESSAGE);
                          
                            
                            // Fill the new inserted data to the table 
                            busObj.pop_Talbe(tblCourseSchedule, "select_Data_Package.get_ClassSchedule(?)","tblCourseSchedule"); 
                            jScrollPane2.getViewport().add(tblCourseSchedule);
                            tblCourseSchedule.removeColumn(tblCourseSchedule.getColumnModel().getColumn(0));
                           
                           
                        }
                    } else JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, 
                             "The Course should be selected !","Data Insertion",JOptionPane.ERROR_MESSAGE);
           
            
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Missing Field, try to select the course in order to schadule the course ");
                }
    }//GEN-LAST:event_btnSaveScheduleActionPerformed

    private void btnDeleteScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteScheduleActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
         
       try{
           
                    if(!(shceduleID==0))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameProjectEventCourse.this, "Do you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                           
                            busObj.delete_Schedule(shceduleID,"call Update_Data_Package.delete_Schedule(?,?)"); 
                                              
                            
                            JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Data delete Successfully ! ","Data deletion",JOptionPane.INFORMATION_MESSAGE);
                          
                            // Fill the new inserted data to the table 
                            busObj.pop_Talbe(tblCourseSchedule, "select_Data_Package.get_ClassSchedule(?)","tblCourseSchedule"); 
                            jScrollPane2.getViewport().add(tblCourseSchedule);
                            tblCourseSchedule.removeColumn(tblCourseSchedule.getColumnModel().getColumn(0));
                           
                           if(tblCourseSchedule.getRowCount()==0){
                                btnDeleteSchedule.setVisible(false);
                                btnSaveSchedule.setEnabled(true);
                                popMnuCheckSchedule.setSelected(false);
                                tblCourseSchedule.setEnabled(false);
                           }else{
                                btnSaveSchedule.setEnabled(true);
                                btnDeleteSchedule.setVisible(false);
                           }
                        }
                    } else JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, 
                             "The Course should be selected !","Data Insertion",JOptionPane.ERROR_MESSAGE);
           
           
               
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, ex);
                }
    }//GEN-LAST:event_btnDeleteScheduleActionPerformed

    private void popMenuChkEditCourseTargetTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuChkEditCourseTargetTblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popMenuChkEditCourseTargetTblActionPerformed

    private void popMnuCheckScheduleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_popMnuCheckScheduleStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_popMnuCheckScheduleStateChanged

    private void popMnuCheckScheduleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_popMnuCheckScheduleItemStateChanged
         if (popMnuCheckSchedule.isSelected()){
            tblCourseSchedule.setEnabled(true);
            ALLOW_ROW_SELECTION = true;
            btnDeleteSchedule.setVisible(true);
            btnSaveSchedule.setEnabled(false);
                       
            Tbl_SelectionMode(tblCourseSchedule,btnDeleteSchedule,"tblCourseSchedule");
        
            
        }else{
            tblCourseSchedule.setEnabled(false);
            ALLOW_ROW_SELECTION = false;
            btnDeleteSchedule.setVisible(false);
            btnSaveSchedule.setEnabled(true);
           
           
          
        }
    }//GEN-LAST:event_popMnuCheckScheduleItemStateChanged

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
            utilObj.flag3=false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void txtSearchEventKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchEventKeyTyped
               
    }//GEN-LAST:event_txtSearchEventKeyTyped

    private void txtSearchEventKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchEventKeyPressed
            if(evt.getKeyCode() == evt.VK_ENTER) {  
                busObj.pop_Talbe(tblEventList, "select_Data_Package.get_EventsByName(?,?)",txtSearchEvent.getText().toString().trim() );
               jScrollPane5.getViewport().add(tblEventList);
               tblEventList.removeColumn(tblEventList.getColumnModel().getColumn(0));
            }      
    }//GEN-LAST:event_txtSearchEventKeyPressed

    private void txtSearchCourseIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCourseIDKeyPressed
          if(evt.getKeyCode() == evt.VK_ENTER) { 
                if(flag==0) {
                    // Fill Table
                    busObj.pop_Talbe(tblTargetCourseSearched, "select_Data_Package.get_CourseWithID(?,TO_NUMBER(?))", 
                                        txtSearchCourseID.getText().trim());
                    jScrollPane1.getViewport().add(tblTargetCourseSearched);
                     hide_Column();

                }else {
                        // Fill Table
                    busObj.pop_Talbe(tblTargetCourseSearched, "select_Data_Package.get_CourseWithName(?,?)", 
                                        txtSearchCourseID.getText().trim());
                    jScrollPane1.getViewport().add(tblTargetCourseSearched);
                     hide_Column();

                }
          }
    }//GEN-LAST:event_txtSearchCourseIDKeyPressed

    private void popMnuCheckScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuCheckScheduleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popMnuCheckScheduleActionPerformed

    private void btnDeleteEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEventActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
         
       try{
           
                    if(!("".equals(txtEventID.getText())))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameProjectEventCourse.this, "Do you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                           
                            busObj.delete_Event(Integer.valueOf(txtEventID.getText()),"call Update_Data_Package.delete_Event(?,?)"); 
                                              
                            
                            JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Data delete Successfully ! ","Data deletion",JOptionPane.INFORMATION_MESSAGE);
                          txtEventID.setText("");
                          txtEventNmae.setText("");
                        }
                    } else JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, 
                             "The Event should be selected !","Deleting Data",JOptionPane.ERROR_MESSAGE);
           
           
               
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, ex);
                }
    }//GEN-LAST:event_btnDeleteEventActionPerformed

    private void btnDeleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCourseActionPerformed
         JDialog.setDefaultLookAndFeelDecorated(true);
         
       try{
           
                    if(!("".equals(txtCourseID.getText())))  {

                        int response = JOptionPane.showConfirmDialog(IntFrameProjectEventCourse.this, "Do you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                           
                            busObj.delete_Course(Integer.valueOf(txtCourseID.getText()),"call Update_Data_Package.delete_Course(?,?)"); 
                                              
                            
                            JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Data delete Successfully ! ","Data deletion",JOptionPane.INFORMATION_MESSAGE);
                          // Fill the new inserted data to the table 
                            busObj.pop_Talbe(tblTargetCourseSearched, "select_Data_Package.get_CourseInTargets(?,?)", 
                            cboTargetNames.getSelectedItem().toString());
                            jScrollPane1.getViewport().add(tblTargetCourseSearched);
                            hide_Column();
                            
                          txtCourseID.setText("");
                          txtCourseName.setText("");
                          txtCourseDescription.setText("");
                          txtITQPoint.setText("");
                          if(tblTargetCourseSearched.getRowCount()==0){
                                btnUpdateCourse.setVisible(false);
                                btnDeleteCourse.setVisible(false);
                                btnListCourse.setEnabled(true);
                          }
                        }
                    } else JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, 
                             "The Course should be selected !","Deleting Data",JOptionPane.ERROR_MESSAGE);
           
           
               
          }catch(Exception ex) { 
                JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, ex);
                }
    }//GEN-LAST:event_btnDeleteCourseActionPerformed

    private void Tbl_SelectionMode(final JTable table,final JButton button,final String tbl_Name){
           
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
                          printDebugData(table,selectedRow,button,tbl_Name);
                            
                      }
                          
                    }
                  });
                } else {
                  table.setRowSelectionAllowed(false);
                }
             
    }
    
    private void printDebugData(JTable table,int selcted_Row,JButton button,String tbl_Name) {
       try{ 
       // int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
           if(tbl_Name=="tblEventList"){
                 txtEventID.setText(String.valueOf(model.getValueAt(selcted_Row, 0).toString()));
                 txtEventNmae.setText(String.valueOf(model.getValueAt(selcted_Row, 1).toString()));
                // txtSpeaker.setText(String.valueOf(model.getValueAt(selcted_Row, 2).toString()));
                // button.setText("Save");
            }else if (tbl_Name=="tblCourseSchedule"){
                 shceduleID=Integer.parseInt(String.valueOf(model.getValueAt(selcted_Row, 0).toString()));
            }else{
                 
               txtTargetID.setText(String.valueOf(model.getValueAt(selcted_Row, 0).toString()));
               txtNewProectTarget.setText(String.valueOf(model.getValueAt(selcted_Row, 1).toString()));
               txtCourseID.setText(String.valueOf(model.getValueAt(selcted_Row, 2).toString()));
               txtCourseName.setText(String.valueOf(model.getValueAt(selcted_Row, 3).toString()));
               txtITQPoint.setText(String.valueOf(model.getValueAt(selcted_Row, 4).toString()));
               txtCourseDescription.setText(String.valueOf(model.getValueAt(selcted_Row, 5)));
               
               lblCourseID.setText("Course ID: "+String.valueOf(model.getValueAt(selcted_Row, 2).toString()));
               lblCourseName.setText("Course Name: "+String.valueOf(model.getValueAt(selcted_Row, 3).toString()));
               
               course_ID_Schedule=Integer.parseInt(String.valueOf(model.getValueAt(selcted_Row, 2).toString()));
               
           }
               
       }catch(Exception ex){JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, ex);}
  }
    
    public  void prit_TblData(final JTable table,JMenuItem print_Button){
   
         ActionListener printAction = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            try {
             MessageFormat headerFormat = new MessageFormat("Kensington Community Learning Center");
              MessageFormat footerFormat = new MessageFormat("- {0} -");
          
              table.print(JTable.PrintMode.FIT_WIDTH, headerFormat,footerFormat, true, new  HashPrintRequestAttributeSet(), true);
            } catch (PrinterException pe) {
                JOptionPane.showMessageDialog(IntFrameProjectEventCourse.this, "Error printing: " + pe.getMessage() );
             
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
    private javax.swing.JSpinner JSTime1;
    private javax.swing.JSpinner JSTime2;
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnDeleteCourse;
    private javax.swing.JButton btnDeleteEvent;
    private javax.swing.JButton btnDeleteSchedule;
    private javax.swing.JButton btnListCourse;
    private javax.swing.JButton btnNewTarget;
    private javax.swing.JButton btnSaveEvent;
    private javax.swing.JButton btnSaveSchedule;
    private javax.swing.JButton btnSearchCourseID;
    private javax.swing.JButton btnSearchEvent;
    private javax.swing.JButton btnUpdateCourse;
    private javax.swing.JButton btnUpdateEvent;
    private javax.swing.JButton btnUpdateTarget;
    private javax.swing.JComboBox cboDaySchedule;
    private javax.swing.JComboBox cboServiceSource;
    private javax.swing.JComboBox cboTargetNames;
    private com.toedter.calendar.JCalendar dtEventStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCourseID;
    private javax.swing.JLabel lblCourseName;
    private javax.swing.JMenuItem mnuPopEventPrint;
    private javax.swing.ButtonGroup optBtnGroupSearchby;
    private javax.swing.JRadioButton optByCourseID;
    private javax.swing.JRadioButton optByCourseName;
    private javax.swing.JCheckBoxMenuItem popMenuChkEditCourseTargetTbl;
    private javax.swing.JCheckBoxMenuItem popMenuChkEditMode;
    private javax.swing.JPopupMenu popMenuCourseTargetTbl;
    private javax.swing.JPopupMenu popMenuEventTbl;
    private javax.swing.JCheckBoxMenuItem popMnuCheckSchedule;
    private javax.swing.JMenuItem popMnuPrint;
    private javax.swing.JMenuItem popMnuPrintCourseTbl;
    private javax.swing.JPopupMenu popMnuSchedule;
    private javax.swing.JTabbedPane tabProCourseEvent;
    private javax.swing.JTable tblCourseSchedule;
    private javax.swing.JTable tblEventList;
    private javax.swing.JTable tblTargetCourseSearched;
    private javax.swing.JTextArea txtCourseDescription;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtEventID;
    private javax.swing.JTextArea txtEventNmae;
    private javax.swing.JTextField txtITQPoint;
    private javax.swing.JTextField txtNewProectTarget;
    private javax.swing.JTextField txtProjectIDEvent;
    private javax.swing.JTextField txtRoomNo;
    private javax.swing.JTextField txtSearchCourseID;
    private javax.swing.JTextField txtSearchEvent;
    private javax.swing.JTextField txtTargetID;
    // End of variables declaration//GEN-END:variables
}
