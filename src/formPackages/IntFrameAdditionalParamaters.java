/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages;

/**
 *
 * @author jo
 */
import formPackages.classPackages.businessLayer;
import formPackages.classPackages.utility;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.swingx.prompt.PromptSupport;

public class IntFrameAdditionalParamaters extends javax.swing.JInternalFrame {

    /**
    * Procedure variable declaration in order to load up the Combo box and list box
    */       
        private String proc_Benefit="SELECT_DATA_PACKAGE.get_Benefit(?)"; 
        private String proc_DisabilityNature="SELECT_DATA_PACKAGE.get_DisabilityNature(?)"; 
        private String proc_EmployementStatus="SELECT_DATA_PACKAGE.get_EmployementStatus(?)"; 
        private String proc_EqualityInfo="SELECT_DATA_PACKAGE.get_EqualityInformation(?)"; 
        private String proc_Ethnicity="SELECT_DATA_PACKAGE.get_Ethnicity(?)"; 
        private String proc_EthniBackground="SELECT_DATA_PACKAGE.get_EthinicityBackground(?,?)"; 
        private String proc_HouseHoldIncome="SELECT_DATA_PACKAGE.get_HouseHoldIncome(?)"; 
        private String proc_LivingIn="SELECT_DATA_PACKAGE.get_LivingIn(?)"; 
        private String proc_Qualification="SELECT_DATA_PACKAGE.get_Qualification(?)"; 
        private String proc_Relegion="SELECT_DATA_PACKAGE.get_Relegion(?)"; 
       
        private String proc_AddIncome="{call data_Entry_Package.add_New_H_Income(?,?,?)}";
        private String proc_AddQualification="{call data_Entry_Package.add_New_Qualification(?,?,?)}";
        private String proc_AddLiveIn="{call data_Entry_Package.add_New_LivingIN(?,?,?)}";
        private String proc_AddBenefit="{call data_Entry_Package.add_New_Benefits(?,?,?)}";
        private String proc_AddEthenic="{call data_Entry_Package.add_New_EthnicityInfo(?,?,?)}";
        private String proc_AddEthnicBg="{call data_Entry_Package.add_New_Ethnicity_BgInfo(?,?,?,?)}";
        private String proc_AddDisabilityNature="{call data_Entry_Package.add_New_Disability(?,?,?)}";
        private String proc_AddEquality="{call data_Entry_Package.add_New_EqualityInfo(?,?,?)}";
        private String proc_AddRelegion="{call data_Entry_Package.add_New_Relegion(?,?,?)}";
        private String proc_AddEmpStatus="{call data_Entry_Package.add_New_EmpStatus(?,?,?)}";
        
        private String proc_DeleteIncome="{call Update_Data_Package.delete_Income(?,?)}";
        private String proc_DeleteQualification="{call Update_Data_Package.delete_Qualification(?,?)}";
        private String proc_DeleteLiveIn="{call Update_Data_Package.delete_LivinIn(?,?)}";
        private String proc_DeleteBenefit="{call Update_Data_Package.delete_Benefit(?,?)}";
        private String proc_DeleteEthenic="{call Update_Data_Package.delete_Ethnic(?,?)}";
        private String proc_DeleteEthnicBg="{call Update_Data_Package.delete_EthnicBg(?,?)}";
        private String proc_DeleteDisabilityNature="{call Update_Data_Package.delete_DisabilityNature(?,?)}";
        private String proc_DeleteEquality="{call Update_Data_Package.delete_Equality(?,?)}";
        private String proc_DeleteRelegion="{call Update_Data_Package.delete_Relegion(?,?)}";
        private String proc_DeleteEmpStatus="{call Update_Data_Package.delete_EmpStatus(?,?)}";
        
        private String income_Range;
        private String qualification;
        private String liveIn;
        private String benefit;
        private String ethnicity;
        private String ethnicity_Bg;
        private String disability_Nature;
        private String equality;
        private String relegion;
        private String emp_Status;
        
        private static String valueEdit;
        
        businessLayer busObj = new businessLayer();
        utility utilObj =new utility();
    /**
     * Creates new form IntFrameAdditionalParamaters
     */
    public IntFrameAdditionalParamaters() {
        initComponents();
        
       // utilObj.connect();
        
        PromptSupport.setPrompt("Enter new income range ...", txtNewIncomeRange);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, txtNewIncomeRange);
        PromptSupport.setFontStyle(5, txtNewIncomeRange);
        
        PromptSupport.setPrompt("Enter new qualification ...", txtNewQualification);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, txtNewQualification);
        PromptSupport.setFontStyle(5, txtNewQualification);
         
        PromptSupport.setPrompt("Enter new lives in ...", txtnewLiveIN);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, txtnewLiveIN);
        PromptSupport.setFontStyle(5, txtnewLiveIN);
        
        PromptSupport.setPrompt("Enter new benefit ...", txtNewBenefit);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, txtNewBenefit);
        PromptSupport.setFontStyle(5, txtNewBenefit);
        
        PromptSupport.setPrompt("Enter new ethnic group ...", txtNewEthnicGroup);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, txtNewEthnicGroup);
        PromptSupport.setFontStyle(5, txtNewEthnicGroup);
        
           
        PromptSupport.setPrompt("Enter new ethnic background ...", txtNewEthnicBackground);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, txtNewEthnicBackground);
        PromptSupport.setFontStyle(5, txtNewEthnicBackground);
        
        PromptSupport.setPrompt("Enter new nature of disability ...", txtNewDisability);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, txtNewDisability);
        PromptSupport.setFontStyle(5, txtNewDisability);
        
        PromptSupport.setPrompt("Enter new disadvantage group ...", txtNewDisadvantageGroup);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, txtNewDisadvantageGroup);
        PromptSupport.setFontStyle(5, txtNewDisadvantageGroup);
        
        PromptSupport.setPrompt("Enter new Relegion...", txtNewRelegion);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, txtNewRelegion);
        PromptSupport.setFontStyle(5, txtNewRelegion);
        
        PromptSupport.setPrompt("Enter new employement status...", txtEmployementStatus);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, txtEmployementStatus);
        PromptSupport.setFontStyle(5, txtEmployementStatus);
        
        /**
         * Fill the data to all lists 
         */
        
        busObj.pop_List(lstIncomeRange,proc_HouseHoldIncome,1);
        busObj.pop_List(lstNewQualification,proc_Qualification,1);
        busObj.pop_List(lstNewLivenIn,proc_LivingIn,1);
        busObj.pop_List(lstNewBenefit,proc_Benefit,1);
        busObj.pop_List(lstNatureDisability,proc_DisabilityNature,0);
        busObj.pop_List(lstDisadvantageGroup,proc_EqualityInfo,0);
        busObj.pop_List(lstRelegion,proc_Relegion,1);
        busObj.pop_List(lstEmployementStatus,proc_EmployementStatus,1); 
        busObj.pop_List(lstEthnicGroup,proc_Ethnicity,3);
        
        listSelection(lstEthnicGroup);
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popDeleteIncomeParameter = new javax.swing.JPopupMenu();
        popMnuDeleteInocmeRange = new javax.swing.JRadioButtonMenuItem();
        popMenuEditIncomeRange = new javax.swing.JRadioButtonMenuItem();
        popDeleteQualificationParameter = new javax.swing.JPopupMenu();
        popMnuDeleteParameter1 = new javax.swing.JRadioButtonMenuItem();
        popMenueEditQualification = new javax.swing.JRadioButtonMenuItem();
        popDeleteLiviInParameter = new javax.swing.JPopupMenu();
        popMnuDeleteParameter2 = new javax.swing.JRadioButtonMenuItem();
        popMenuEditLiviIN = new javax.swing.JRadioButtonMenuItem();
        popDeleteBenefitParameter = new javax.swing.JPopupMenu();
        popMnuDeleteParameter3 = new javax.swing.JRadioButtonMenuItem();
        popMenuEditBenefit = new javax.swing.JRadioButtonMenuItem();
        popDeleteEthnicParameter = new javax.swing.JPopupMenu();
        popMnuDeleteParameter4 = new javax.swing.JRadioButtonMenuItem();
        popMenuEditEthnicity = new javax.swing.JRadioButtonMenuItem();
        popDeleteEthnicBgParameter = new javax.swing.JPopupMenu();
        popMnuDeleteParameter5 = new javax.swing.JRadioButtonMenuItem();
        popMenuEditEthnBkg = new javax.swing.JRadioButtonMenuItem();
        popDeleteDisabilityNatureParameter = new javax.swing.JPopupMenu();
        popMnuDeleteParameter6 = new javax.swing.JRadioButtonMenuItem();
        popMenuEditDisabilityNature = new javax.swing.JRadioButtonMenuItem();
        popDeleteEqualityParameter = new javax.swing.JPopupMenu();
        popMnuDeleteParameter7 = new javax.swing.JRadioButtonMenuItem();
        popMenuEditDisadvantage = new javax.swing.JRadioButtonMenuItem();
        popDeleteRelegionParameter = new javax.swing.JPopupMenu();
        popMnuDeleteParameter8 = new javax.swing.JRadioButtonMenuItem();
        popMenuEditRelegion = new javax.swing.JRadioButtonMenuItem();
        popDeleteEmpStatusParameter = new javax.swing.JPopupMenu();
        popMnuDeleteParameter9 = new javax.swing.JRadioButtonMenuItem();
        popMenuEditEmpStatus = new javax.swing.JRadioButtonMenuItem();
        buttonGroupIncomeRange = new javax.swing.ButtonGroup();
        buttonGroupQualification = new javax.swing.ButtonGroup();
        buttonGroupLiveIn = new javax.swing.ButtonGroup();
        buttonGroupBenefit = new javax.swing.ButtonGroup();
        buttonGroupEthnicity = new javax.swing.ButtonGroup();
        buttonGroupEthneicityBkg = new javax.swing.ButtonGroup();
        buttonGroupDisability = new javax.swing.ButtonGroup();
        buttonGroupDisadvantage = new javax.swing.ButtonGroup();
        buttonGroupRelegion = new javax.swing.ButtonGroup();
        buttonGroupEmpStatus = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txtNewIncomeRange = new javax.swing.JTextField();
        btnAddIncomeRange = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstIncomeRange = new javax.swing.JList();
        btnNewLivenIn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstNewLivenIn = new javax.swing.JList();
        txtNewQualification = new javax.swing.JTextField();
        btnNewQualification = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstNewQualification = new javax.swing.JList();
        txtNewBenefit = new javax.swing.JTextField();
        btnNewBenefit = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstNewBenefit = new javax.swing.JList();
        txtnewLiveIN = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtNewEthnicGroup = new javax.swing.JTextField();
        btnNewEthenicGroup = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstEthnicGroup = new javax.swing.JList();
        txtNewEthnicBackground = new javax.swing.JTextField();
        btnNewEthnicBackground = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        lstEthnicBackground = new javax.swing.JList();
        txtNewDisability = new javax.swing.JTextField();
        btnNewNatureDisability = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        lstNatureDisability = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        txtNewDisadvantageGroup = new javax.swing.JTextField();
        btnNewDisadvantageGroup = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        lstDisadvantageGroup = new javax.swing.JList();
        txtNewRelegion = new javax.swing.JTextField();
        btnNewRelegion = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        lstRelegion = new javax.swing.JList();
        jScrollPane10 = new javax.swing.JScrollPane();
        lstEmployementStatus = new javax.swing.JList();
        txtEmployementStatus = new javax.swing.JTextField();
        btnEmployementStatus = new javax.swing.JButton();

        buttonGroupIncomeRange.add(popMnuDeleteInocmeRange);
        popMnuDeleteInocmeRange.setText("Delete");
        popMnuDeleteInocmeRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuDeleteInocmeRangeActionPerformed(evt);
            }
        });
        popDeleteIncomeParameter.add(popMnuDeleteInocmeRange);

        buttonGroupIncomeRange.add(popMenuEditIncomeRange);
        popMenuEditIncomeRange.setSelected(true);
        popMenuEditIncomeRange.setText("Edit Household Income");
        popMenuEditIncomeRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuEditIncomeRangeActionPerformed(evt);
            }
        });
        popDeleteIncomeParameter.add(popMenuEditIncomeRange);

        buttonGroupQualification.add(popMnuDeleteParameter1);
        popMnuDeleteParameter1.setSelected(true);
        popMnuDeleteParameter1.setText("Delete Qualification");
        popMnuDeleteParameter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuDeleteParameter1ActionPerformed(evt);
            }
        });
        popDeleteQualificationParameter.add(popMnuDeleteParameter1);

        buttonGroupQualification.add(popMenueEditQualification);
        popMenueEditQualification.setText("Edit Qualification");
        popMenueEditQualification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenueEditQualificationActionPerformed(evt);
            }
        });
        popDeleteQualificationParameter.add(popMenueEditQualification);

        buttonGroupLiveIn.add(popMnuDeleteParameter2);
        popMnuDeleteParameter2.setSelected(true);
        popMnuDeleteParameter2.setText("Delete Live In");
        popMnuDeleteParameter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuDeleteParameter2ActionPerformed(evt);
            }
        });
        popDeleteLiviInParameter.add(popMnuDeleteParameter2);

        buttonGroupLiveIn.add(popMenuEditLiviIN);
        popMenuEditLiviIN.setText("Edit Live In");
        popMenuEditLiviIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuEditLiviINActionPerformed(evt);
            }
        });
        popDeleteLiviInParameter.add(popMenuEditLiviIN);

        buttonGroupBenefit.add(popMnuDeleteParameter3);
        popMnuDeleteParameter3.setSelected(true);
        popMnuDeleteParameter3.setText("Delete Recipt Benefit");
        popMnuDeleteParameter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuDeleteParameter3ActionPerformed(evt);
            }
        });
        popDeleteBenefitParameter.add(popMnuDeleteParameter3);

        buttonGroupBenefit.add(popMenuEditBenefit);
        popMenuEditBenefit.setText("Edit Recipt of Benefit");
        popMenuEditBenefit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuEditBenefitActionPerformed(evt);
            }
        });
        popDeleteBenefitParameter.add(popMenuEditBenefit);

        buttonGroupEthnicity.add(popMnuDeleteParameter4);
        popMnuDeleteParameter4.setSelected(true);
        popMnuDeleteParameter4.setText("Delete Ethnicity");
        popMnuDeleteParameter4.setToolTipText("");
        popMnuDeleteParameter4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuDeleteParameter4ActionPerformed(evt);
            }
        });
        popDeleteEthnicParameter.add(popMnuDeleteParameter4);

        buttonGroupEthnicity.add(popMenuEditEthnicity);
        popMenuEditEthnicity.setText("Edit Ethnicity");
        popMenuEditEthnicity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuEditEthnicityActionPerformed(evt);
            }
        });
        popDeleteEthnicParameter.add(popMenuEditEthnicity);

        buttonGroupEthneicityBkg.add(popMnuDeleteParameter5);
        popMnuDeleteParameter5.setSelected(true);
        popMnuDeleteParameter5.setText("Delete Ethnicity Background");
        popMnuDeleteParameter5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuDeleteParameter5ActionPerformed(evt);
            }
        });
        popDeleteEthnicBgParameter.add(popMnuDeleteParameter5);

        buttonGroupEthneicityBkg.add(popMenuEditEthnBkg);
        popMenuEditEthnBkg.setText("Edit Ethnicity Background");
        popMenuEditEthnBkg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuEditEthnBkgActionPerformed(evt);
            }
        });
        popDeleteEthnicBgParameter.add(popMenuEditEthnBkg);

        buttonGroupDisability.add(popMnuDeleteParameter6);
        popMnuDeleteParameter6.setSelected(true);
        popMnuDeleteParameter6.setText("Delete Disability Nature");
        popMnuDeleteParameter6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuDeleteParameter6ActionPerformed(evt);
            }
        });
        popDeleteDisabilityNatureParameter.add(popMnuDeleteParameter6);

        buttonGroupDisability.add(popMenuEditDisabilityNature);
        popMenuEditDisabilityNature.setText("Edit Disability Nature");
        popMenuEditDisabilityNature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuEditDisabilityNatureActionPerformed(evt);
            }
        });
        popDeleteDisabilityNatureParameter.add(popMenuEditDisabilityNature);

        buttonGroupDisadvantage.add(popMnuDeleteParameter7);
        popMnuDeleteParameter7.setSelected(true);
        popMnuDeleteParameter7.setText("Delete Disadvantage Group");
        popMnuDeleteParameter7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuDeleteParameter7ActionPerformed(evt);
            }
        });
        popDeleteEqualityParameter.add(popMnuDeleteParameter7);

        buttonGroupDisadvantage.add(popMenuEditDisadvantage);
        popMenuEditDisadvantage.setText("Edit Disadvantage Group");
        popMenuEditDisadvantage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuEditDisadvantageActionPerformed(evt);
            }
        });
        popDeleteEqualityParameter.add(popMenuEditDisadvantage);

        buttonGroupRelegion.add(popMnuDeleteParameter8);
        popMnuDeleteParameter8.setSelected(true);
        popMnuDeleteParameter8.setText("Delete Relegion");
        popMnuDeleteParameter8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuDeleteParameter8ActionPerformed(evt);
            }
        });
        popDeleteRelegionParameter.add(popMnuDeleteParameter8);

        buttonGroupRelegion.add(popMenuEditRelegion);
        popMenuEditRelegion.setText("Edit Relegion");
        popMenuEditRelegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuEditRelegionActionPerformed(evt);
            }
        });
        popDeleteRelegionParameter.add(popMenuEditRelegion);

        buttonGroupEmpStatus.add(popMnuDeleteParameter9);
        popMnuDeleteParameter9.setSelected(true);
        popMnuDeleteParameter9.setText("Delete Employment Status");
        popMnuDeleteParameter9.setToolTipText("");
        popMnuDeleteParameter9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMnuDeleteParameter9ActionPerformed(evt);
            }
        });
        popDeleteEmpStatusParameter.add(popMnuDeleteParameter9);

        buttonGroupEmpStatus.add(popMenuEditEmpStatus);
        popMenuEditEmpStatus.setText("Edit Employment Status");
        popMenuEditEmpStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuEditEmpStatusActionPerformed(evt);
            }
        });
        popDeleteEmpStatusParameter.add(popMenuEditEmpStatus);

        setClosable(true);
        setIconifiable(true);
        setTitle("Manage Additional Parameters");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/AdditionalPara.png"))); // NOI18N
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

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        txtNewIncomeRange.setEditable(false);
        txtNewIncomeRange.setToolTipText("");
        txtNewIncomeRange.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnAddIncomeRange.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnAddIncomeRange.setText("Add New");
        btnAddIncomeRange.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddIncomeRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddIncomeRangeActionPerformed(evt);
            }
        });

        lstIncomeRange.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstIncomeRange.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstIncomeRange.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstIncomeRange.setComponentPopupMenu(popDeleteIncomeParameter);
        jScrollPane1.setViewportView(lstIncomeRange);

        btnNewLivenIn.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnNewLivenIn.setText("Add New");
        btnNewLivenIn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNewLivenIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewLivenInActionPerformed(evt);
            }
        });

        lstNewLivenIn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstNewLivenIn.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstNewLivenIn.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstNewLivenIn.setComponentPopupMenu(popDeleteLiviInParameter);
        jScrollPane2.setViewportView(lstNewLivenIn);

        txtNewQualification.setEditable(false);
        txtNewQualification.setToolTipText("");
        txtNewQualification.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnNewQualification.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnNewQualification.setText("Add New");
        btnNewQualification.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNewQualification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewQualificationActionPerformed(evt);
            }
        });

        lstNewQualification.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstNewQualification.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstNewQualification.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstNewQualification.setComponentPopupMenu(popDeleteQualificationParameter);
        jScrollPane3.setViewportView(lstNewQualification);

        txtNewBenefit.setEditable(false);
        txtNewBenefit.setToolTipText("");
        txtNewBenefit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnNewBenefit.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnNewBenefit.setText("Add New");
        btnNewBenefit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNewBenefit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBenefitActionPerformed(evt);
            }
        });

        lstNewBenefit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstNewBenefit.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstNewBenefit.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstNewBenefit.setComponentPopupMenu(popDeleteBenefitParameter);
        jScrollPane4.setViewportView(lstNewBenefit);

        txtnewLiveIN.setEditable(false);
        txtnewLiveIN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewIncomeRange, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(txtnewLiveIN, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddIncomeRange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewLivenIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNewQualification)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNewBenefit)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewBenefit)
                    .addComponent(btnNewQualification))
                .addGap(42, 42, 42))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNewBenefit, btnNewQualification});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2, jScrollPane3, jScrollPane4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtNewIncomeRange, txtnewLiveIN});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewIncomeRange, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddIncomeRange))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewQualification, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewQualification))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewLivenIn)
                            .addComponent(txtnewLiveIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewBenefit, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewBenefit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2, jScrollPane3, jScrollPane4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtNewIncomeRange, txtnewLiveIN});

        jTabbedPane1.addTab("Background", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        txtNewEthnicGroup.setEditable(false);
        txtNewEthnicGroup.setToolTipText("");
        txtNewEthnicGroup.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnNewEthenicGroup.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnNewEthenicGroup.setText("Add New");
        btnNewEthenicGroup.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNewEthenicGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewEthenicGroupActionPerformed(evt);
            }
        });

        lstEthnicGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstEthnicGroup.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstEthnicGroup.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEthnicGroup.setComponentPopupMenu(popDeleteEthnicParameter);
        jScrollPane5.setViewportView(lstEthnicGroup);

        txtNewEthnicBackground.setEditable(false);
        txtNewEthnicBackground.setToolTipText("");
        txtNewEthnicBackground.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnNewEthnicBackground.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnNewEthnicBackground.setText("Add New");
        btnNewEthnicBackground.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNewEthnicBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewEthnicBackgroundActionPerformed(evt);
            }
        });

        lstEthnicBackground.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstEthnicBackground.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstEthnicBackground.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEthnicBackground.setComponentPopupMenu(popDeleteEthnicBgParameter);
        jScrollPane6.setViewportView(lstEthnicBackground);

        txtNewDisability.setEditable(false);
        txtNewDisability.setToolTipText("");
        txtNewDisability.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnNewNatureDisability.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnNewNatureDisability.setText("Add New");
        btnNewNatureDisability.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNewNatureDisability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewNatureDisabilityActionPerformed(evt);
            }
        });

        lstNatureDisability.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstNatureDisability.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstNatureDisability.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstNatureDisability.setComponentPopupMenu(popDeleteDisabilityNatureParameter);
        jScrollPane7.setViewportView(lstNatureDisability);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNewEthnicGroup)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewEthenicGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtNewEthnicBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewEthnicBackground))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNewDisability)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewNatureDisability)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNewEthenicGroup, btnNewEthnicBackground, btnNewNatureDisability});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewEthnicBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewEthnicBackground))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewEthnicGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewEthenicGroup))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNewDisability, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewNatureDisability))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane5, jScrollPane6, jScrollPane7});

        jTabbedPane1.addTab("Personal Information", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setFont(new java.awt.Font("DejaVu Serif", 0, 12)); // NOI18N

        txtNewDisadvantageGroup.setEditable(false);
        txtNewDisadvantageGroup.setToolTipText("");
        txtNewDisadvantageGroup.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnNewDisadvantageGroup.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnNewDisadvantageGroup.setText("Add New");
        btnNewDisadvantageGroup.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNewDisadvantageGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewDisadvantageGroupActionPerformed(evt);
            }
        });

        lstDisadvantageGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstDisadvantageGroup.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstDisadvantageGroup.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstDisadvantageGroup.setComponentPopupMenu(popDeleteEqualityParameter);
        jScrollPane8.setViewportView(lstDisadvantageGroup);

        txtNewRelegion.setEditable(false);
        txtNewRelegion.setToolTipText("");
        txtNewRelegion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnNewRelegion.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnNewRelegion.setText("Add New");
        btnNewRelegion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNewRelegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRelegionActionPerformed(evt);
            }
        });

        lstRelegion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstRelegion.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstRelegion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstRelegion.setComponentPopupMenu(popDeleteRelegionParameter);
        jScrollPane9.setViewportView(lstRelegion);

        lstEmployementStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstEmployementStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lstEmployementStatus.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEmployementStatus.setComponentPopupMenu(popDeleteEmpStatusParameter);
        jScrollPane10.setViewportView(lstEmployementStatus);

        txtEmployementStatus.setEditable(false);
        txtEmployementStatus.setToolTipText("");
        txtEmployementStatus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnEmployementStatus.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnEmployementStatus.setText("Add New");
        btnEmployementStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEmployementStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployementStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(txtNewDisadvantageGroup))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewDisadvantageGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(txtEmployementStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEmployementStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNewRelegion, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewRelegion)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEmployementStatus, btnNewDisadvantageGroup});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNewDisadvantageGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNewDisadvantageGroup, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewRelegion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewRelegion, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmployementStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmployementStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Equality", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void set_EthnicityID(){ busObj.ethnicity_ID=busObj.IDHolder_Ethnicity.get(lstEthnicGroup.getSelectedIndex());}

    
    private void set_Income(){income_Range=txtNewIncomeRange.getText();}
    private String get_Income(){return income_Range;}
    
    private void set_Qualification(){qualification=txtNewQualification.getText();}
    private String get_Qualification(){return qualification;}
    
    private void set_LiviIn(){liveIn=txtnewLiveIN.getText();}
    private String get_LiviIn(){return liveIn;}
    
    private void set_Benefit(){benefit=txtNewBenefit.getText();}
    private String get_Benefit(){return benefit;}
    
    private void set_Ethnic(){ethnicity=txtNewEthnicGroup.getText();}
    private String get_Ethnic(){return ethnicity;}
    
    private void set_Ethnic_Bg(){ethnicity_Bg=txtNewEthnicBackground.getText();}
    private String get_Ethnic_Bg(){return ethnicity_Bg;}
    
    private void set_Disabiliity_Nature(){disability_Nature=txtNewDisability.getText();}
    private String get_Disabiliity_Nature(){return disability_Nature;}
    
    private void set_Equality(){equality=txtNewDisadvantageGroup.getText();}
    private String get_Equality(){return equality;}
    
    private void set_Relegion(){relegion=txtNewRelegion.getText();}
    private String get_Relegion(){return relegion;}
    
    private void set_EmpStatus(){emp_Status=txtEmployementStatus.getText();}
    private String get_EmpStatus(){return emp_Status;}
    
    private void btnAddIncomeRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddIncomeRangeActionPerformed
       JDialog.setDefaultLookAndFeelDecorated(true);
        
        if(!(btnAddIncomeRange.getText()=="Add New"||btnAddIncomeRange.getText()=="Edit")){
            if(!(txtNewIncomeRange.getText().isEmpty() ))  {
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_Income();
                            busObj.insert_AdditinalParameter( busObj.set_SeqNextVal(2),
                                                              get_Income(),
                                                              proc_AddIncome);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnAddIncomeRange.setText("Add New");
                            txtNewIncomeRange.setEditable(false);
                            txtNewIncomeRange.setText("");
                                 
                            lstIncomeRange.removeAll();
                            busObj.pop_List(lstIncomeRange, proc_HouseHoldIncome,1);
                            
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Income Range shoud NOT be NULL !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
           
        }else if(btnAddIncomeRange.getText()=="Edit") {
            
            JDialog.setDefaultLookAndFeelDecorated(true);
                try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to Edit the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_Income();
                            
                            busObj.update_Parameter("HOUSE_HOLD_INCOME","INCOME_DESC",get_Income(),lstIncomeRange.getSelectedValue().toString());
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Update Successfully ! ","Update Data",JOptionPane.INFORMATION_MESSAGE);
                           lstIncomeRange.setEnabled(true);
                            btnAddIncomeRange.setText("Add New");
                            txtNewIncomeRange.setEditable(false);
                            txtNewIncomeRange.setText("");
                            lstEmployementStatus.removeAll();
                            busObj.pop_List(lstIncomeRange, proc_HouseHoldIncome,1);
                            lstIncomeRange.setEnabled(true);
                        }
                        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
        }else {
            //txtTargetID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
            txtNewIncomeRange.setText("");
            txtNewIncomeRange.setEditable(true);
            btnAddIncomeRange.setText("Save");
          
        }
    }//GEN-LAST:event_btnAddIncomeRangeActionPerformed

    private void btnNewQualificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewQualificationActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        if(!(btnNewQualification.getText()=="Add New"||btnNewQualification.getText()=="Edit")){
            if(!(txtNewQualification.getText().isEmpty() ))  {
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_Qualification();
                            busObj.insert_AdditinalParameter( busObj.set_SeqNextVal(3),
                                                              get_Qualification(),
                                                              proc_AddQualification);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnNewQualification.setText("Add New");
                             txtNewQualification.setEditable(false);
                           txtNewQualification.setText("");
                            lstNewQualification.removeAll();
                            busObj.pop_List(lstNewQualification, proc_Qualification,1);
                            
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Income Range shoud NOT be NULL !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
           
        }else if(btnNewQualification.getText()=="Edit") {
            
            JDialog.setDefaultLookAndFeelDecorated(true);
                try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to Edit the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_Qualification();
                            
                            busObj.update_Parameter("QUALIFICATION","QUALIFICATION",get_Qualification(),lstNewQualification.getSelectedValue().toString());
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Update Successfully ! ","Update Data",JOptionPane.INFORMATION_MESSAGE);
                           lstNewQualification.setEnabled(true);
                            btnNewQualification.setText("Add New");
                            txtNewQualification.setEditable(false);
                            txtNewQualification.setText("");
                            lstNewQualification.removeAll();
                            busObj.pop_List(lstNewQualification, proc_Qualification,1);
                            lstNewQualification.setEnabled(true);
                        }
                        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
        }else {
            //txtTargetID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
            txtNewQualification.setText("");
            txtNewQualification.setEditable(true);
            btnNewQualification.setText("Save");
          
        }
    }//GEN-LAST:event_btnNewQualificationActionPerformed

    private void btnNewLivenInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewLivenInActionPerformed
       JDialog.setDefaultLookAndFeelDecorated(true);
        
        if(!(btnNewLivenIn.getText()=="Add New"||btnNewLivenIn.getText()=="Edit")){
            if(!(txtnewLiveIN.getText().isEmpty() ))  {
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_LiviIn();
                            busObj.insert_AdditinalParameter( busObj.set_SeqNextVal(2),
                                                              get_LiviIn(),
                                                              proc_AddLiveIn);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnNewLivenIn.setText("Add New");
                            txtnewLiveIN.setEditable(false);
                            txtnewLiveIN.setText("");
                            lstNewLivenIn.removeAll();
                            busObj.pop_List(lstNewLivenIn, proc_LivingIn,1);
                            
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Income Range shoud NOT be NULL !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
           
        }else if(btnNewLivenIn.getText()=="Edit") {
            
            JDialog.setDefaultLookAndFeelDecorated(true);
                try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to Edit the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_LiviIn();
                            
                            busObj.update_Parameter("LIVING_IN","LIVING_DESC",get_LiviIn(),lstNewLivenIn.getSelectedValue().toString());
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Update Successfully ! ","Update Data",JOptionPane.INFORMATION_MESSAGE);
                           lstNewLivenIn.setEnabled(true);
                            btnNewLivenIn.setText("Add New");
                            txtnewLiveIN.setEditable(false);
                            txtnewLiveIN.setText("");
                            lstNewLivenIn.removeAll();
                            busObj.pop_List(lstNewLivenIn, proc_LivingIn,1);
                            lstNewLivenIn.setEnabled(true);
                        }
                        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
        }else {
            //txtTargetID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
            txtnewLiveIN.setText("");
            txtnewLiveIN.setEditable(true);
            btnNewLivenIn.setText("Save");
          
        }
    }//GEN-LAST:event_btnNewLivenInActionPerformed

    private void btnNewBenefitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBenefitActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        if(!(btnNewBenefit.getText()=="Add New" || btnNewBenefit.getText()=="Edit")){
            if(!(txtNewBenefit.getText().isEmpty() ))  {
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_Benefit();
                            busObj.insert_AdditinalParameter( busObj.set_SeqNextVal(5),
                                                              get_Benefit(),
                                                              proc_AddBenefit);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnNewBenefit.setText("Add New");
                            txtNewBenefit.setEditable(false);
                            txtNewBenefit.setText("");
                            lstNewBenefit.removeAll();
                            busObj.pop_List(lstNewBenefit, proc_Benefit,1);
                            
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Income Range shoud NOT be NULL !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
           
        }else if(btnNewBenefit.getText()=="Edit") {
            
            JDialog.setDefaultLookAndFeelDecorated(true);
                try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to Edit the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_Benefit();
                            
                            busObj.update_Parameter("BENEFITS","BENEFIT_DESC",get_Benefit(),lstNewBenefit.getSelectedValue().toString().trim());
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Update Successfully ! ","Update Data",JOptionPane.INFORMATION_MESSAGE);
                           lstNewBenefit.setEnabled(true);
                            btnNewBenefit.setText("Add New");
                            txtNewBenefit.setEditable(false);
                            txtNewBenefit.setText("");
                            lstNewBenefit.removeAll();
                            busObj.pop_List(lstNewBenefit, proc_Benefit,1);
                            lstNewBenefit.setEnabled(true);
                        }
                        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
        }else {
            //txtTargetID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
            txtNewBenefit.setText("");
            txtNewBenefit.setEditable(true);
            btnNewBenefit.setText("Save");
          
        }
    }//GEN-LAST:event_btnNewBenefitActionPerformed

    private void btnNewEthenicGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewEthenicGroupActionPerformed
       JDialog.setDefaultLookAndFeelDecorated(true);
        
        if(!(btnNewEthenicGroup.getText()=="Add New"||btnNewEthenicGroup.getText()=="Edit")){
            if(!(txtNewEthnicGroup.getText().isEmpty() ))  {
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_Ethnic();
                            busObj.insert_AdditinalParameter( busObj.set_SeqNextVal(6),
                                                              get_Ethnic(),
                                                              proc_AddEthenic);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnNewEthenicGroup.setText("Add New");
                            txtNewEthnicGroup.setEditable(false);
                            txtNewEthnicGroup.setText("");
                            lstEthnicGroup.removeAll();
                            busObj.pop_List(lstEthnicGroup, proc_Ethnicity,3);
                            
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Income Range shoud NOT be NULL !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
           
        }else if(btnNewEthenicGroup.getText()=="Edit") {
            
            JDialog.setDefaultLookAndFeelDecorated(true);
                try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to Edit the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_Ethnic();
                            
                            busObj.update_Parameter("ETHNICITY","ETHN_NAME",get_Ethnic(),lstEthnicGroup.getSelectedValue().toString().trim());
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Update Successfully ! ","Update Data",JOptionPane.INFORMATION_MESSAGE);
                           lstEthnicGroup.setEnabled(true);
                            btnNewEthenicGroup.setText("Add New");
                            txtNewEthnicGroup.setEditable(false);
                            txtNewEthnicGroup.setText("");
                            lstEthnicGroup.removeAll();
                            busObj.pop_List(lstEthnicGroup, proc_Ethnicity,1);
                            lstEthnicGroup.setEnabled(true);
                        }
                        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
        }else {
            //txtTargetID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
            txtNewEthnicGroup.setText("");
            txtNewEthnicGroup.setEditable(true);
            btnNewEthenicGroup.setText("Save");
          
        }
    }//GEN-LAST:event_btnNewEthenicGroupActionPerformed

    private void btnNewEthnicBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewEthnicBackgroundActionPerformed
       JDialog.setDefaultLookAndFeelDecorated(true);
       
        if(!(btnNewEthnicBackground.getText()=="Add New"||btnNewEthnicBackground.getText()=="Edit")){
            if(!(txtNewEthnicBackground.getText().isEmpty() ||lstEthnicGroup.isSelectionEmpty()))  {
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_EthnicityID();
                            set_Ethnic_Bg();
                            busObj.insert_AdditinalParameter( busObj.set_SeqNextVal(7),
                                                              get_Ethnic_Bg(),
                                                              proc_AddEthnicBg);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnNewEthnicBackground.setText("Add New");
                            txtNewEthnicBackground.setEditable(false);
                            txtNewEthnicBackground.setText("");
                            lstEthnicBackground.removeAll();
                            busObj.pop_List(lstEthnicBackground, proc_EthniBackground,1);
                            
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Ethnic Background shoud NOT be NULL and Ethnicity should be selected !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
           
        }else if(btnNewEthnicBackground.getText()=="Edit") {
            
            JDialog.setDefaultLookAndFeelDecorated(true);
                try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to Edit the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_Ethnic_Bg();
                            
                            busObj.update_Parameter("ETHNICITY_BG","ETHN_BAK_NAME",get_Ethnic_Bg(),lstEthnicBackground.getSelectedValue().toString().trim());
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Update Successfully ! ","Update Data",JOptionPane.INFORMATION_MESSAGE);
                           lstEthnicBackground.setEnabled(true);
                            btnNewEthnicBackground.setText("Add New");
                            txtNewEthnicBackground.setEditable(false);
                            txtNewEthnicBackground.setText("");
                            lstEthnicBackground.removeAll();
                            busObj.pop_List(lstEthnicBackground, proc_EthniBackground,1);
                            lstEthnicBackground.setEnabled(true);
                        }
                        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
        }else {
            //txtTargetID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
            txtNewEthnicBackground.setText("");
            txtNewEthnicBackground.setEditable(true);
            btnNewEthnicBackground.setText("Save");
          
        }
    }//GEN-LAST:event_btnNewEthnicBackgroundActionPerformed

    private void btnNewNatureDisabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewNatureDisabilityActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        
        if(!(btnNewNatureDisability.getText()=="Add New"||btnNewNatureDisability.getText()=="Edit")){
            if(!(txtNewDisability.getText().isEmpty() ))  {
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_Disabiliity_Nature();
                            busObj.insert_AdditinalParameter( busObj.set_SeqNextVal(8),
                                                              get_Disabiliity_Nature(),
                                                              proc_AddDisabilityNature);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnNewNatureDisability.setText("Add New");
                            txtNewDisability.setEditable(false);
                            txtNewDisability.setText("");
                            lstNatureDisability.removeAll();
                            busObj.pop_List(lstNatureDisability, proc_DisabilityNature,0);
                            
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Income Range shoud NOT be NULL !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
           
        }else if(btnNewNatureDisability.getText()=="Edit") {
            
            JDialog.setDefaultLookAndFeelDecorated(true);
                try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to Edit the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_Disabiliity_Nature();
                            
                            busObj.update_Parameter("DISABILITY_NATURE","DISABILITY_NATURE",get_Disabiliity_Nature(),lstNatureDisability.getSelectedValue().toString().trim());
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Update Successfully ! ","Update Data",JOptionPane.INFORMATION_MESSAGE);
                           lstNatureDisability.setEnabled(true);
                            btnNewNatureDisability.setText("Add New");
                            txtNewDisability.setEditable(false);
                            txtNewDisability.setText("");
                            lstNatureDisability.removeAll();
                            busObj.pop_List(lstNatureDisability, proc_DisabilityNature,0);
                            lstNatureDisability.setEnabled(true);
                        }
                        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
        }else {
            //txtTargetID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
            txtNewDisability.setText("");
            txtNewDisability.setEditable(true);
            btnNewNatureDisability.setText("Save");
          
        }
    }//GEN-LAST:event_btnNewNatureDisabilityActionPerformed

    private void btnNewDisadvantageGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewDisadvantageGroupActionPerformed
         JDialog.setDefaultLookAndFeelDecorated(true);
        
        if(!(btnNewDisadvantageGroup.getText()=="Add New"||btnNewDisadvantageGroup.getText()=="Edit")){
            if(!(txtNewDisadvantageGroup.getText().isEmpty() ))  {
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_Equality();
                            busObj.insert_AdditinalParameter( busObj.set_SeqNextVal(9),
                                                              get_Equality(),
                                                              proc_AddEquality);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnNewDisadvantageGroup.setText("Add New");
                            txtNewDisadvantageGroup.setEditable(false);
                            txtNewDisadvantageGroup.setText("");
                            lstDisadvantageGroup.removeAll();
                            busObj.pop_List(lstDisadvantageGroup, proc_EqualityInfo,0);
                            
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Income Range shoud NOT be NULL !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
           
        }else if(btnNewDisadvantageGroup.getText()=="Edit") {
            
            JDialog.setDefaultLookAndFeelDecorated(true);
                try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to Edit the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_Equality();
                            
                            busObj.update_Parameter("EQUALITY_INFO","EQUAL_DESC",get_Equality(),lstDisadvantageGroup.getSelectedValue().toString().trim());
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Update Successfully ! ","Update Data",JOptionPane.INFORMATION_MESSAGE);
                           lstDisadvantageGroup.setEnabled(true);
                            btnNewDisadvantageGroup.setText("Add New");
                            txtNewDisadvantageGroup.setEditable(false);
                            txtNewDisadvantageGroup.setText("");
                            lstDisadvantageGroup.removeAll();
                            busObj.pop_List(lstDisadvantageGroup, proc_EqualityInfo,0);
                            lstDisadvantageGroup.setEnabled(true);
                        }
                        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
        }else {
            //txtTargetID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
            txtNewDisadvantageGroup.setText("");
            txtNewDisadvantageGroup.setEditable(true);
            btnNewDisadvantageGroup.setText("Save");
          
        }
    }//GEN-LAST:event_btnNewDisadvantageGroupActionPerformed

    private void btnNewRelegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRelegionActionPerformed
         JDialog.setDefaultLookAndFeelDecorated(true);
        
        if(!(btnNewRelegion.getText()=="Add New"||btnNewRelegion.getText()=="Edit")){
            if(!(txtNewRelegion.getText().isEmpty() ))  {
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_Relegion();
                            busObj.insert_AdditinalParameter( busObj.set_SeqNextVal(10),
                                                              get_Relegion(),
                                                              proc_AddRelegion);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnNewRelegion.setText("Add New");
                            txtNewRelegion.setEditable(false);
                            txtNewRelegion.setText("");
                            lstRelegion.removeAll();
                            busObj.pop_List(lstRelegion, proc_Relegion,1);
                            
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Income Range shoud NOT be NULL !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
           
        }else if(btnNewRelegion.getText()=="Edit") {
            
            JDialog.setDefaultLookAndFeelDecorated(true);
                try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to Edit the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_Relegion();
                            
                            busObj.update_Parameter("RELIGION","RELIGION",get_Relegion(),lstRelegion.getSelectedValue().toString().trim());
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Update Successfully ! ","Update Data",JOptionPane.INFORMATION_MESSAGE);
                           lstRelegion.setEnabled(true);
                            btnNewRelegion.setText("Add New");
                            txtNewRelegion.setEditable(false);
                            txtNewRelegion.setText("");
                            lstRelegion.removeAll();
                            busObj.pop_List(lstRelegion, proc_Relegion,1);
                            lstRelegion.setEnabled(true);
                        }
                  }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
        }else {
            //txtTargetID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
            txtNewRelegion.setText("");
            txtNewRelegion.setEditable(true);
            btnNewRelegion.setText("Save");
          
        }
    }//GEN-LAST:event_btnNewRelegionActionPerformed

    private void btnEmployementStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployementStatusActionPerformed
         JDialog.setDefaultLookAndFeelDecorated(true);
        
        if(!(btnEmployementStatus.getText()=="Add New"||btnEmployementStatus.getText()=="Edit")){
            if(!(txtEmployementStatus.getText().isEmpty() ))  {
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Do you want to SAVE the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            set_EmpStatus();
                            busObj.insert_AdditinalParameter( busObj.set_SeqNextVal(11),
                                                              get_EmpStatus(),
                                                              proc_AddEmpStatus);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Saved Successfully ! ","Data Insertion",JOptionPane.INFORMATION_MESSAGE);
                            btnEmployementStatus.setText("Add");
                            txtEmployementStatus.setEditable(false);
                            txtEmployementStatus.setText("");
                                    
                            lstEmployementStatus.removeAll();
                            busObj.pop_List(lstEmployementStatus, proc_EmployementStatus,1);
                            
                        }
                
            }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Employement Status shoud NOT be NULL !" , 
                            "Data Insertion",JOptionPane.ERROR_MESSAGE);
           
        }else if(btnEmployementStatus.getText()=="Edit") {
            
            JDialog.setDefaultLookAndFeelDecorated(true);
                try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to Edit the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            set_EmpStatus();
                            
                            busObj.update_Parameter("EMPLOYMENT_STATUS","EMP_STATUS",get_EmpStatus(),lstEmployementStatus.getSelectedValue().toString().trim());
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Update Successfully ! ","Update Data",JOptionPane.INFORMATION_MESSAGE);
                           lstEmployementStatus.setEnabled(true);
                            btnEmployementStatus.setText("Add New");
                            txtEmployementStatus.setEditable(false);
                            txtEmployementStatus.setText("");
                            lstEmployementStatus.removeAll();
                            busObj.pop_List(lstEmployementStatus, proc_EmployementStatus,1);
                            lstEmployementStatus.setEnabled(true);
                        }
                  }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
        }else {
            //txtTargetID.setText(String.valueOf(busObj.set_SeqNextVal(0)));
            txtEmployementStatus.setText("");
            txtEmployementStatus.setEditable(true);
            btnEmployementStatus.setText("Save");
          
        }
    }//GEN-LAST:event_btnEmployementStatusActionPerformed

    private void popMnuDeleteInocmeRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuDeleteInocmeRangeActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        try{
           if(!(lstIncomeRange.isSelectionEmpty())){
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            busObj.delet_AdditionalParameter( lstIncomeRange.getSelectedValue().toString(),
                                                              proc_DeleteIncome);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Delete Successfully ! ","Deleting Data",JOptionPane.INFORMATION_MESSAGE);
                           
                            lstIncomeRange.removeAll();
                            busObj.pop_List(lstIncomeRange, proc_HouseHoldIncome,1);
                            txtNewIncomeRange.setText("");
                        }
           }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Please select the item you want to delete");
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
    }//GEN-LAST:event_popMnuDeleteInocmeRangeActionPerformed

    private void popMnuDeleteParameter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuDeleteParameter1ActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                           
                            busObj.delet_AdditionalParameter( lstNewQualification.getSelectedValue().toString(),
                                                              proc_DeleteQualification);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Delete Successfully ! ","Deleting Data",JOptionPane.INFORMATION_MESSAGE);
                           
                            lstNewQualification.removeAll();
                            busObj.pop_List(lstNewQualification, proc_Qualification,1);
                            txtNewQualification.setText("");
                        }
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
    }//GEN-LAST:event_popMnuDeleteParameter1ActionPerformed

    private void popMnuDeleteParameter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuDeleteParameter2ActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            busObj.delet_AdditionalParameter( lstNewLivenIn.getSelectedValue().toString(),
                                                              proc_DeleteLiveIn);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Delete Successfully ! ","Deleting Data",JOptionPane.INFORMATION_MESSAGE);
                           
                            lstNewLivenIn.removeAll();
                            busObj.pop_List(lstNewLivenIn, proc_LivingIn,1);
                            txtnewLiveIN.setText("");
                        }
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
    }//GEN-LAST:event_popMnuDeleteParameter2ActionPerformed

    private void popMnuDeleteParameter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuDeleteParameter3ActionPerformed
       JDialog.setDefaultLookAndFeelDecorated(true);
        try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                          
                            busObj.delet_AdditionalParameter( lstNewBenefit.getSelectedValue().toString(),
                                                              proc_DeleteBenefit);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Delete Successfully ! ","Deleting Data",JOptionPane.INFORMATION_MESSAGE);
                           
                            lstNewBenefit.removeAll();
                            busObj.pop_List(lstNewBenefit, proc_Benefit,1);
                            txtNewBenefit.setText("");
                        }
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
    }//GEN-LAST:event_popMnuDeleteParameter3ActionPerformed

    private void popMnuDeleteParameter4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuDeleteParameter4ActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                           
                            busObj.delet_AdditionalParameter( lstEthnicGroup.getSelectedValue().toString(),
                                                              proc_DeleteEthenic);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Delete Successfully ! ","Deleting Data",JOptionPane.INFORMATION_MESSAGE);
                           
                            lstEthnicGroup.removeAll();
                            busObj.pop_List(lstEthnicGroup, proc_Ethnicity,3);
                            txtNewEthnicGroup.setText("");
                        }
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
    }//GEN-LAST:event_popMnuDeleteParameter4ActionPerformed

    private void popMnuDeleteParameter5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuDeleteParameter5ActionPerformed
       JDialog.setDefaultLookAndFeelDecorated(true);
        try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                           
                            busObj.delet_AdditionalParameter( lstEthnicBackground.getSelectedValue().toString(),
                                                              proc_DeleteEthnicBg);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Delete Successfully ! ","Deleting Data",JOptionPane.INFORMATION_MESSAGE);
                           
                            lstEthnicBackground.removeAll();
                            busObj.pop_List(lstEthnicBackground, proc_EthniBackground,1);
                            txtNewEthnicBackground.setText("");
                        }
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
    }//GEN-LAST:event_popMnuDeleteParameter5ActionPerformed

    private void popMnuDeleteParameter6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuDeleteParameter6ActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            busObj.delet_AdditionalParameter( lstNatureDisability.getSelectedValue().toString(),
                                                              proc_DeleteDisabilityNature);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Delete Successfully ! ","Deleting Data",JOptionPane.INFORMATION_MESSAGE);
                           
                            lstNatureDisability.removeAll();
                            busObj.pop_List(lstNatureDisability, proc_DisabilityNature,0);
                            txtNewDisability.setText("");
                        }
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
    }//GEN-LAST:event_popMnuDeleteParameter6ActionPerformed

    private void popMnuDeleteParameter7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuDeleteParameter7ActionPerformed
       JDialog.setDefaultLookAndFeelDecorated(true);
        try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                           
                            busObj.delet_AdditionalParameter( lstDisadvantageGroup.getSelectedValue().toString(),
                                                              proc_DeleteEquality);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Delete Successfully ! ","Deleting Data",JOptionPane.INFORMATION_MESSAGE);
                           
                            lstDisadvantageGroup.removeAll();
                            busObj.pop_List(lstDisadvantageGroup, proc_EqualityInfo,0);
                            txtNewDisadvantageGroup.setText("");
                        }
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
    }//GEN-LAST:event_popMnuDeleteParameter7ActionPerformed

    private void popMnuDeleteParameter8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuDeleteParameter8ActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            busObj.delet_AdditionalParameter( lstRelegion.getSelectedValue().toString().trim(),
                                                              proc_DeleteRelegion);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Delete Successfully ! ","Deleting Data",JOptionPane.INFORMATION_MESSAGE);
                           
                            lstRelegion.removeAll();
                            busObj.pop_List(lstRelegion, proc_Relegion,1);
                            txtNewRelegion.setText("");
                        }
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
    }//GEN-LAST:event_popMnuDeleteParameter8ActionPerformed

    private void popMnuDeleteParameter9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMnuDeleteParameter9ActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        try{
           
                int response = JOptionPane.showConfirmDialog(IntFrameAdditionalParamaters.this, "Are you shure you want to delete the record?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            
                            busObj.delet_AdditionalParameter( lstEmployementStatus.getSelectedValue().toString(),
                                                              proc_DeleteEmpStatus);
                            
                            JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Data Delete Successfully ! ","Deleting Data",JOptionPane.INFORMATION_MESSAGE);
                           
                            lstEmployementStatus.removeAll();
                            busObj.pop_List(lstEmployementStatus, proc_EmployementStatus,1);
                            txtEmployementStatus.setText("");
                        }
        }catch(Exception ex){ JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this,"Null selection! Error: " + ex);}
    }//GEN-LAST:event_popMnuDeleteParameter9ActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        utilObj.flag5=false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void popMenuEditIncomeRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuEditIncomeRangeActionPerformed
        if(!(lstIncomeRange.getSelectedValue().toString()==null)){
        txtNewIncomeRange.setText(lstIncomeRange.getSelectedValue().toString());
        btnAddIncomeRange.setText("Edit");
        txtNewIncomeRange.setEditable(true);
        lstIncomeRange.setEnabled(false);
        }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Please select the item you are going to EDIIT");
        
    }//GEN-LAST:event_popMenuEditIncomeRangeActionPerformed

    private void popMenueEditQualificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenueEditQualificationActionPerformed
       if(!(lstNewQualification.getSelectedValue().toString()==null)){
        txtNewQualification.setText(lstNewQualification.getSelectedValue().toString());
        btnNewQualification.setText("Edit");
        txtNewQualification.setEditable(true);
        lstNewQualification.setEnabled(false);
        }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Please select the item you are going to EDIIT");
        
    }//GEN-LAST:event_popMenueEditQualificationActionPerformed

    private void popMenuEditLiviINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuEditLiviINActionPerformed
        if(!(lstNewLivenIn.getSelectedValue().toString()==null)){
        txtnewLiveIN.setText(lstNewLivenIn.getSelectedValue().toString());
        btnNewLivenIn.setText("Edit");
        txtnewLiveIN.setEditable(true);
        lstNewLivenIn.setEnabled(false);
        }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Please select the item you are going to EDIIT");
    }//GEN-LAST:event_popMenuEditLiviINActionPerformed

    private void popMenuEditBenefitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuEditBenefitActionPerformed
        if(!(lstNewBenefit.getSelectedValue().toString()==null)){
        txtNewBenefit.setText(lstNewBenefit.getSelectedValue().toString());
        btnNewBenefit.setText("Edit");
        txtNewBenefit.setEditable(true);
        lstNewBenefit.setEnabled(false);
        }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Please select the item you are going to EDIIT");
    }//GEN-LAST:event_popMenuEditBenefitActionPerformed

    private void popMenuEditEthnicityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuEditEthnicityActionPerformed
        if(!(lstEthnicGroup.getSelectedValue().toString()==null)){
        txtNewEthnicGroup.setText(lstEthnicGroup.getSelectedValue().toString());
        btnNewEthenicGroup.setText("Edit");
        txtNewEthnicGroup.setEditable(true);
        lstEthnicGroup.setEnabled(false);
        }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Please select the item you are going to EDIIT");
    }//GEN-LAST:event_popMenuEditEthnicityActionPerformed

    private void popMenuEditEthnBkgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuEditEthnBkgActionPerformed
       if(!(lstEthnicBackground.getSelectedValue().toString()==null)){
        txtNewEthnicBackground.setText(lstEthnicBackground.getSelectedValue().toString());
        btnNewEthnicBackground.setText("Edit");
        txtNewEthnicBackground.setEditable(true);
        lstEthnicBackground.setEnabled(false);
        }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Please select the item you are going to EDIIT");
    }//GEN-LAST:event_popMenuEditEthnBkgActionPerformed

    private void popMenuEditDisabilityNatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuEditDisabilityNatureActionPerformed
        if(!(lstNatureDisability.getSelectedValue().toString()==null)){
        txtNewDisability.setText(lstNatureDisability.getSelectedValue().toString());
        btnNewNatureDisability.setText("Edit");
        txtNewDisability.setEditable(true);
        lstNatureDisability.setEnabled(false);
        }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Please select the item you are going to EDIIT");
    }//GEN-LAST:event_popMenuEditDisabilityNatureActionPerformed

    private void popMenuEditDisadvantageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuEditDisadvantageActionPerformed
        if(!(lstDisadvantageGroup.getSelectedValue().toString()==null)){
        txtNewDisadvantageGroup.setText(lstDisadvantageGroup.getSelectedValue().toString());
        btnNewDisadvantageGroup.setText("Edit");
        txtNewDisadvantageGroup.setEditable(true);
        lstDisadvantageGroup.setEnabled(false);
        }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Please select the item you are going to EDIIT");
    }//GEN-LAST:event_popMenuEditDisadvantageActionPerformed

    private void popMenuEditRelegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuEditRelegionActionPerformed
       if(!(lstRelegion.getSelectedValue().toString()==null)){
        txtNewRelegion.setText(lstRelegion.getSelectedValue().toString());
        btnNewRelegion.setText("Edit");
        txtNewRelegion.setEditable(true);
        lstRelegion.setEnabled(false);
        }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Please select the item you are going to EDIIT");
    }//GEN-LAST:event_popMenuEditRelegionActionPerformed

    private void popMenuEditEmpStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuEditEmpStatusActionPerformed
        if(!(lstEmployementStatus.getSelectedValue().toString()==null)){
        txtEmployementStatus.setText(lstEmployementStatus.getSelectedValue().toString());
        btnEmployementStatus.setText("Edit");
        txtEmployementStatus.setEditable(true);
        lstEmployementStatus.setEnabled(false);
        }else JOptionPane.showMessageDialog(IntFrameAdditionalParamaters.this, "Please select the item you are going to EDIIT");
    }//GEN-LAST:event_popMenuEditEmpStatusActionPerformed

    private void listSelection(JList lstcomp){
        
         ListSelectionListener listSelectionListener = new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent listSelectionEvent) {
        //System.out.print("First index: " + listSelectionEvent.getFirstIndex());
        //System.out.print(", Last index: " + listSelectionEvent.getLastIndex());
        boolean adjust = listSelectionEvent.getValueIsAdjusting();
        //System.out.println(", Adjusting? " + adjust);
        if (!adjust) {
          JList list = (JList) listSelectionEvent.getSource();
          int selections[] = list.getSelectedIndices();
          Object selectionValues[] = list.getSelectedValues();
          for (int i = 0, n = selections.length; i < n; i++) {
            
           // System.out.print(selections[i] + "/" + selectionValues[i] + " ");
              busObj.ethnicity=String.valueOf(selectionValues[i]);
              busObj.pop_List(lstEthnicBackground,proc_EthniBackground,1);
             
          }
          
        }
      }
    };
    lstcomp.addListSelectionListener(listSelectionListener);
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddIncomeRange;
    private javax.swing.JButton btnEmployementStatus;
    private javax.swing.JButton btnNewBenefit;
    private javax.swing.JButton btnNewDisadvantageGroup;
    private javax.swing.JButton btnNewEthenicGroup;
    private javax.swing.JButton btnNewEthnicBackground;
    private javax.swing.JButton btnNewLivenIn;
    private javax.swing.JButton btnNewNatureDisability;
    private javax.swing.JButton btnNewQualification;
    private javax.swing.JButton btnNewRelegion;
    private javax.swing.ButtonGroup buttonGroupBenefit;
    private javax.swing.ButtonGroup buttonGroupDisability;
    private javax.swing.ButtonGroup buttonGroupDisadvantage;
    private javax.swing.ButtonGroup buttonGroupEmpStatus;
    private javax.swing.ButtonGroup buttonGroupEthneicityBkg;
    private javax.swing.ButtonGroup buttonGroupEthnicity;
    private javax.swing.ButtonGroup buttonGroupIncomeRange;
    private javax.swing.ButtonGroup buttonGroupLiveIn;
    private javax.swing.ButtonGroup buttonGroupQualification;
    private javax.swing.ButtonGroup buttonGroupRelegion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList lstDisadvantageGroup;
    private javax.swing.JList lstEmployementStatus;
    private javax.swing.JList lstEthnicBackground;
    private javax.swing.JList lstEthnicGroup;
    private javax.swing.JList lstIncomeRange;
    private javax.swing.JList lstNatureDisability;
    private javax.swing.JList lstNewBenefit;
    private javax.swing.JList lstNewLivenIn;
    private javax.swing.JList lstNewQualification;
    private javax.swing.JList lstRelegion;
    private javax.swing.JPopupMenu popDeleteBenefitParameter;
    private javax.swing.JPopupMenu popDeleteDisabilityNatureParameter;
    private javax.swing.JPopupMenu popDeleteEmpStatusParameter;
    private javax.swing.JPopupMenu popDeleteEqualityParameter;
    private javax.swing.JPopupMenu popDeleteEthnicBgParameter;
    private javax.swing.JPopupMenu popDeleteEthnicParameter;
    private javax.swing.JPopupMenu popDeleteIncomeParameter;
    private javax.swing.JPopupMenu popDeleteLiviInParameter;
    private javax.swing.JPopupMenu popDeleteQualificationParameter;
    private javax.swing.JPopupMenu popDeleteRelegionParameter;
    private javax.swing.JRadioButtonMenuItem popMenuEditBenefit;
    private javax.swing.JRadioButtonMenuItem popMenuEditDisabilityNature;
    private javax.swing.JRadioButtonMenuItem popMenuEditDisadvantage;
    private javax.swing.JRadioButtonMenuItem popMenuEditEmpStatus;
    private javax.swing.JRadioButtonMenuItem popMenuEditEthnBkg;
    private javax.swing.JRadioButtonMenuItem popMenuEditEthnicity;
    private javax.swing.JRadioButtonMenuItem popMenuEditIncomeRange;
    private javax.swing.JRadioButtonMenuItem popMenuEditLiviIN;
    private javax.swing.JRadioButtonMenuItem popMenuEditRelegion;
    private javax.swing.JRadioButtonMenuItem popMenueEditQualification;
    private javax.swing.JRadioButtonMenuItem popMnuDeleteInocmeRange;
    private javax.swing.JRadioButtonMenuItem popMnuDeleteParameter1;
    private javax.swing.JRadioButtonMenuItem popMnuDeleteParameter2;
    private javax.swing.JRadioButtonMenuItem popMnuDeleteParameter3;
    private javax.swing.JRadioButtonMenuItem popMnuDeleteParameter4;
    private javax.swing.JRadioButtonMenuItem popMnuDeleteParameter5;
    private javax.swing.JRadioButtonMenuItem popMnuDeleteParameter6;
    private javax.swing.JRadioButtonMenuItem popMnuDeleteParameter7;
    private javax.swing.JRadioButtonMenuItem popMnuDeleteParameter8;
    private javax.swing.JRadioButtonMenuItem popMnuDeleteParameter9;
    private javax.swing.JTextField txtEmployementStatus;
    private javax.swing.JTextField txtNewBenefit;
    private javax.swing.JTextField txtNewDisability;
    private javax.swing.JTextField txtNewDisadvantageGroup;
    private javax.swing.JTextField txtNewEthnicBackground;
    private javax.swing.JTextField txtNewEthnicGroup;
    private javax.swing.JTextField txtNewIncomeRange;
    private javax.swing.JTextField txtNewQualification;
    private javax.swing.JTextField txtNewRelegion;
    private javax.swing.JTextField txtnewLiveIN;
    // End of variables declaration//GEN-END:variables
}
