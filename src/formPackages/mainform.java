/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package formPackages;
import formPackages.classPackages.businessLayer;
import javax.swing.JDesktopPane;
import javax.swing.tree.TreePath;
import javax.swing.JInternalFrame;
import formPackages.classPackages.utility;
import javax.swing.JOptionPane;



/**
 *
 * @author jo
 */
public class mainform extends javax.swing.JFrame {

    
    businessLayer busObj=new businessLayer();
    utility utilObj=new utility();  
        
    public mainform() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelMain = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        lblTotalNumberofStudent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTotlaNumberStudent = new javax.swing.JLabel();
        lblTotlaVol = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblAccessLevel = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        DPanelParent = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Browser");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("frmParent"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jSplitPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSplitPane1.setDividerSize(20);
        jSplitPane1.setDoubleBuffered(true);

        jPanelMain.setBackground(new java.awt.Color(18, 30, 49));
        jPanelMain.setPreferredSize(new java.awt.Dimension(300, 689));

        jTree1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTree1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jTree1.putClientProperty("JTree.lineStyle", "Horizontal");
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Beneficiary Management System");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Manage Beneficiaries");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Register Student");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Search Student");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Manage Student Course");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Manage Student");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Manage Attendance");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Options");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Manage Course and Event");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Manage Additional Parameters");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Tools");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Generate Student/Volunteer ID");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Manage System User");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Database Connection Setting");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Generate Reports");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("View All Beneficiary");
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        lblTotalNumberofStudent.setBackground(new java.awt.Color(18, 30, 49));
        lblTotalNumberofStudent.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blf.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel2.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Beneficiary Statistics:");

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Number of Beneficiary:");

        jLabel4.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Number of Vol.:");

        lblTotlaNumberStudent.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        lblTotlaNumberStudent.setForeground(new java.awt.Color(255, 255, 255));
        lblTotlaNumberStudent.setText("Total");

        lblTotlaVol.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        lblTotlaVol.setForeground(new java.awt.Color(255, 255, 255));
        lblTotlaVol.setText("Total");

        jLabel6.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Current Login Account");

        jLabel7.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("System User : ");

        jLabel8.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Access Level : ");

        lblUserName.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(255, 255, 255));
        lblUserName.setText("Total");

        lblAccessLevel.setFont(new java.awt.Font("DejaVu Serif", 1, 11)); // NOI18N
        lblAccessLevel.setForeground(new java.awt.Color(255, 255, 255));
        lblAccessLevel.setText("Total");

        btnLogout.setBackground(new java.awt.Color(18, 30, 49));
        btnLogout.setFont(new java.awt.Font("DejaVu Serif Condensed", 0, 12)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblTotalNumberofStudentLayout = new javax.swing.GroupLayout(lblTotalNumberofStudent);
        lblTotalNumberofStudent.setLayout(lblTotalNumberofStudentLayout);
        lblTotalNumberofStudentLayout.setHorizontalGroup(
            lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblTotalNumberofStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblTotalNumberofStudentLayout.createSequentialGroup()
                        .addGroup(lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotlaNumberStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(lblTotlaVol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(lblTotalNumberofStudentLayout.createSequentialGroup()
                        .addGroup(lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel6))
                            .addGroup(lblTotalNumberofStudentLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAccessLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblTotalNumberofStudentLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        lblTotalNumberofStudentLayout.setVerticalGroup(
            lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblTotalNumberofStudentLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTotlaNumberStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTotlaVol, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblTotalNumberofStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAccessLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotalNumberofStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalNumberofStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanelMain);

        DPanelParent.setBorder(new javax.swing.border.MatteBorder(null));
        DPanelParent.setName("desktopPanel"); // NOI18N

        javax.swing.GroupLayout DPanelParentLayout = new javax.swing.GroupLayout(DPanelParent);
        DPanelParent.setLayout(DPanelParentLayout);
        DPanelParentLayout.setHorizontalGroup(
            DPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );
        DPanelParentLayout.setVerticalGroup(
            DPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(DPanelParent);
        DPanelParent.getAccessibleContext().setAccessibleName("desktopPanel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1))
        );

        getAccessibleContext().setAccessibleName("MainForm");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
        String node="";
        TreePath[] path= evt.getPaths();
        for(int i=0; i < path.length;i++)
        {
            if (evt.isAddedPath(i))
            {
                 lblTotlaNumberStudent.setText(String.valueOf(busObj.get_TotlaStudent()));
                 lblTotlaVol.setText(String.valueOf(busObj.get_TotlavolOnly()));
                 
                node= path[i].getLastPathComponent().toString();
               
                break;

            }
            else
            {   
                
                break;
            }
        }
  
                switch (node) {
                    case "Register Student":
                
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                if(!(utility.flag1)){
                                IntFrameEnrolment enrolmentForm =new IntFrameEnrolment();
                                //if(DPanelParent.getAllFrames().equals(node)) System.out.println("Active");
                                DPanelParent.add(enrolmentForm);
                                //enrolmentForm.setVisible(true);
                                setFormPositionCenter(enrolmentForm,DPanelParent);
                                enrolmentForm.setVisible(true);
                                utility.flag1=true;
                                
                                }else JOptionPane.showMessageDialog(mainform.this, "The Form Allready Open");
                         }
                            jTree1.clearSelection();
                        break;
                    case "Manage Student Course":
                        
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                if(!(utility.flag2)){
                                    IntFrameSearchAssignCourses searchRegisterFrm =new IntFrameSearchAssignCourses();
                                    DPanelParent.add(searchRegisterFrm);
                                    setFormPositionCenter(searchRegisterFrm,DPanelParent);
                                    searchRegisterFrm.setVisible(true);
                                    utility.flag2=true;
                                }else JOptionPane.showMessageDialog(mainform.this, "The Form Allready Open");
                        }
                        jTree1.clearSelection();
                                break;
                        
                    case "Manage Course and Event":
                       
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                if(!(utility.flag3)){
                                    IntFrameProjectEventCourse projectEventCourseFrm =new IntFrameProjectEventCourse();
                                    DPanelParent.add(projectEventCourseFrm);
                                    setFormPositionCenter(projectEventCourseFrm,DPanelParent);
                                    projectEventCourseFrm.setVisible(true);
                                    utility.flag3=true;
                                }else JOptionPane.showMessageDialog(mainform.this, "The Form Allready Open");
                        }
                        jTree1.clearSelection();
                                break;
                    case "Manage Attendance":
                        
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                if(!(utility.flag4)){
                                    IntFrameAttandance attendanceFrm =new IntFrameAttandance();
                                    DPanelParent.add(attendanceFrm);
                                    setFormPositionCenter(attendanceFrm,DPanelParent);
                                    attendanceFrm.setVisible(true);
                                    utility.flag4=true;
                                }else JOptionPane.showMessageDialog(mainform.this, "The Form Allready Open");
                            }
                        jTree1.clearSelection();
                                    break;
                    case "Manage Additional Parameters":
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                if(!(utility.flag5)){
                                    IntFrameAdditionalParamaters additionalParameterFrm =new IntFrameAdditionalParamaters();
                                    DPanelParent.add(additionalParameterFrm);
                                    setFormPositionCenter(additionalParameterFrm,DPanelParent);
                                    additionalParameterFrm.setVisible(true);
                                    utility.flag5=true;
                                }else JOptionPane.showMessageDialog(mainform.this, "The Form Allready Open");
                        }
                        jTree1.clearSelection();
                                break;
                    case "Manage System User":
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                if(!(utility.flag6)){
                                    IntFrameUserManagment userManagmentFrm =new IntFrameUserManagment();
                                    DPanelParent.add(userManagmentFrm);
                                    setFormPositionCenter(userManagmentFrm,DPanelParent);
                                    userManagmentFrm.setVisible(true);
                                    utility.flag6=true;
                                }else JOptionPane.showMessageDialog(mainform.this, "The Form Allready Open");
                        }
                        jTree1.clearSelection();
                                break;

                    case "Database Connection Setting":
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                ConnectionSettingFrm dbConnectionFrm=new ConnectionSettingFrm();
                                //DPanelParent.add(dbConnectionFrm);
                                dbConnectionFrm.setVisible(true);
                                dbConnectionFrm.toFront();
                                this.setVisible(false);
                        }
                        jTree1.clearSelection();
                                break;
                    case "Generate Reports":
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                if(!(utility.flag7)){
                                    IntFrameReportParameter frmReport=new IntFrameReportParameter();
                                    DPanelParent.add(frmReport);
                                    setFormPositionCenter(frmReport,DPanelParent);
                                    frmReport.setVisible(true);
                                    utility.flag7=true;
                                }else JOptionPane.showMessageDialog(mainform.this, "The Form Allready Open");
                        }
                        jTree1.clearSelection();
                                break;
                    case "Manage Student":
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                if(!(utility.flag10)){
                                    IntFrameEditBeneficiary frmManageBeneficiary=new IntFrameEditBeneficiary();
                                    DPanelParent.add(frmManageBeneficiary);
                                    setFormPositionCenter(frmManageBeneficiary,DPanelParent);
                                    frmManageBeneficiary.setVisible(true);
                                    utility.flag10=true;
                                }else JOptionPane.showMessageDialog(mainform.this, "The Form Allready Open");
                        }
                        jTree1.clearSelection();
                                break;
                    case "Generate Student/Volunteer ID":
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                if(!(utility.flag8)){
                                    IntFrameGenerateStudentID frmGenerateID=new IntFrameGenerateStudentID();
                                    DPanelParent.add(frmGenerateID);
                                    setFormPositionCenter(frmGenerateID,DPanelParent);
                                    frmGenerateID.setVisible(true);
                                    utility.flag8=true;
                                }else JOptionPane.showMessageDialog(mainform.this, "The Form Allready Open");
                        }
                        jTree1.clearSelection();
                                break;
                    case "Search Student":
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                if(!(utility.flag9)){
                                    IntFrameGeneralSearch frmSearch=new IntFrameGeneralSearch();
                                    DPanelParent.add(frmSearch);
                                    setFormPositionCenter(frmSearch,DPanelParent);

                                    frmSearch.setVisible(true);
                                    utility.flag9=true;
                                }else JOptionPane.showMessageDialog(mainform.this, "The Form Allready Open");
                        }
                        jTree1.clearSelection();
                                break;
                        case "View All Beneficiary":
                        if(!(hasContent(utilObj.accessContent,node)))
                            JOptionPane.showMessageDialog(mainform.this, "You have insufficient access privileges for this operation !");
                        else{
                                if(!(utility.flag11)){
                                   try{
                                    IntFramViewAllBenf frmAllBenef=new IntFramViewAllBenf();
                                    DPanelParent.add(frmAllBenef);
                                    setFormPositionCenter(frmAllBenef,DPanelParent);
                                    frmAllBenef.setMaximum(true);
                                    frmAllBenef.setVisible(true);
                                    utility.flag11=true;
                                   }catch(Exception ex){}
                                }else JOptionPane.showMessageDialog(mainform.this, "The Form Allready Open");
                        }
                        jTree1.clearSelection();
                                break;
                }
  
    }//GEN-LAST:event_jTree1ValueChanged
    public static boolean hasContent(String[] arr, String targetValue) {
	for(String s: arr){
		if(s.equals(targetValue))
			return true;
	}
	return false;
    }
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       lblTotlaNumberStudent.setText(String.valueOf(busObj.get_TotlaStudent()));
       lblTotlaVol.setText(String.valueOf(busObj.get_TotlavolOnly()));
       lblUserName.setText(utilObj.UserName);
       lblAccessLevel.setText(utilObj.userPrivilage);
     
    }//GEN-LAST:event_formWindowActivated

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
       
       new frmLogin().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed
    public void setFormPositionCenter(JInternalFrame intFrm,JDesktopPane desFrm){
        
            int width = (desFrm.getWidth() - intFrm.getWidth()) / 2;
            int height = (desFrm.getHeight()- intFrm.getHeight()) / 2;
            intFrm.setLocation(width, height);    
           
    }
            
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings({"Convert2Lambda", "CallToThreadDumpStack", "BroadCatchBlock", "TooBroadCatch", "UseSpecificCatch"})
    public static void main(String args[]) {
          
        /* Create and display the form */
        //utility utiObj=new utility();
        try {
           // 
         
           
        } catch (Exception ex) {
           ex.printStackTrace();
       }
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainform().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DPanelParent;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lblAccessLevel;
    private javax.swing.JPanel lblTotalNumberofStudent;
    private javax.swing.JLabel lblTotlaNumberStudent;
    private javax.swing.JLabel lblTotlaVol;
    private javax.swing.JLabel lblUserName;
    // End of variables declaration//GEN-END:variables
}
