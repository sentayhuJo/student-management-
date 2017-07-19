/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages;

import formPackages.classPackages.utility;
import javax.swing.JOptionPane;

/**
 *
 * @author jo
 */
public class ConnectionSettingFrm extends javax.swing.JFrame {

    /**
     * Creates new form ConnectionSettingFrm
     */
    utility utilityObj=new utility(); 
    
    public ConnectionSettingFrm() {
        initComponents();
     
        lblTextConnDescription.setText("<html>This form tends to be enable you that connect to the database server reside"
                + "<br> on the main server on the network. So that it needs the following credential"
                + "<br> in order to connect to the database server.<html>");
        //btnOkSaveConnectionXml.enable(false);
        String [] configData=new String[5];
        configData = utilityObj.getConnectionValue();
        
        txtServerName.setText(configData[0]);
        txtOraServerName.setText(configData[1]);
        txtOraPortNo.setText(configData[2]);
        txtOraUserName.setText(configData[3]);
        txtOraUserPassword.setText(configData[4]);
        
        btnOkSaveConnectionXml.setEnabled(false);
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lblTextConnDescription = new javax.swing.JLabel();
        lblConnIcon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtServerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtOraServerName = new javax.swing.JTextField();
        txtOraUserName = new javax.swing.JTextField();
        txtOraPortNo = new javax.swing.JTextField();
        txtOraUserPassword = new javax.swing.JPasswordField();
        btnTestConnection = new javax.swing.JButton();
        lblTestConnection = new javax.swing.JLabel();
        btnOkSaveConnectionXml = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Database Connection Setting ");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTextConnDescription.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        lblConnIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DbConnection.png"))); // NOI18N
        lblConnIcon.setText("jLabel2");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel3.setText("Server Name/IP Address");

        jLabel4.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel4.setText("Oracle Server Name");

        jLabel5.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel5.setText("Oracle User Name");

        jLabel6.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel6.setText("Oracle User Password");

        txtServerName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        jLabel7.setText("Oracle Port No.");

        txtOraServerName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        txtOraUserName.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        txtOraPortNo.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N

        txtOraUserPassword.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        txtOraUserPassword.setText("jPasswordField1");

        btnTestConnection.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnTestConnection.setText("Test Connection");
        btnTestConnection.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTestConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestConnectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTestConnection)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtServerName)
                            .addComponent(txtOraServerName, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(txtOraPortNo)
                            .addComponent(txtOraUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(txtOraUserPassword))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtServerName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOraServerName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOraPortNo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtOraUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtOraUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTestConnection)
                .addGap(73, 73, 73))
        );

        lblTestConnection.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        lblTestConnection.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnOkSaveConnectionXml.setFont(new java.awt.Font("DejaVu Serif", 0, 11)); // NOI18N
        btnOkSaveConnectionXml.setText("Ok");
        btnOkSaveConnectionXml.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOkSaveConnectionXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkSaveConnectionXmlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTestConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTextConnDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblConnIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnOkSaveConnectionXml, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTextConnDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConnIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTestConnection, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOkSaveConnectionXml, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(605, 407));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTestConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestConnectionActionPerformed
                         
        try{
       
              utilityObj.testDbConnection(txtServerName.getText(),txtOraServerName.getText(),
                      txtOraPortNo.getText(),txtOraUserName.getText(),txtOraUserPassword.getText());
              
              if (utilityObj.flag==1)
              {
                lblTestConnection.setText("Success !" );
                btnOkSaveConnectionXml.setEnabled(true);              }
              else
                lblTestConnection.setText("Fail !");
               
         
            }catch (Exception ex){
            lblTestConnection.setText("Test fail ! : " + ex.getMessage().toString());
            }
   
    }//GEN-LAST:event_btnTestConnectionActionPerformed

    private void btnOkSaveConnectionXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkSaveConnectionXmlActionPerformed
         
            try{
                    utilityObj.writeConfigFile(txtServerName.getText(),txtOraServerName.getText(),txtOraPortNo.getText()
                                                  ,txtOraUserName.getText(),txtOraUserPassword.getText());
                    JOptionPane.showMessageDialog(null, "Database connection setting seccessfully saved");
                    btnOkSaveConnectionXml.setEnabled(false);
                }
            catch( Exception confException)
                {
                
                    JOptionPane.showMessageDialog(ConnectionSettingFrm.this,"Unable to save the database connection string , Error : "+confException.getMessage());
                    
                 }
           
        
             // TODO add your handling code here:
    }//GEN-LAST:event_btnOkSaveConnectionXmlActionPerformed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
               
    }//GEN-LAST:event_formWindowDeactivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConnectionSettingFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectionSettingFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectionSettingFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectionSettingFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectionSettingFrm().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOkSaveConnectionXml;
    private javax.swing.JButton btnTestConnection;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblConnIcon;
    private javax.swing.JLabel lblTestConnection;
    private javax.swing.JLabel lblTextConnDescription;
    private javax.swing.JTextField txtOraPortNo;
    private javax.swing.JTextField txtOraServerName;
    private javax.swing.JTextField txtOraUserName;
    private javax.swing.JPasswordField txtOraUserPassword;
    private javax.swing.JTextField txtServerName;
    // End of variables declaration//GEN-END:variables
}
