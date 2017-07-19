/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages;

import formPackages.classPackages.businessLayer;
import formPackages.classPackages.utility;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author jo
 */
public class IntFramViewAllBenf extends javax.swing.JInternalFrame {

    /**
     * Creates new form IntFramViewAllBenf
     */
    businessLayer busObj=new businessLayer();
    utility utilObj=new utility();
    public IntFramViewAllBenf() {
        initComponents();
       
          tblAllBeneficiary.setVisibleRowCount(100);
          tblAllBeneficiary.setVisibleColumnCount(10);
          tblAllBeneficiary.setHorizontalScrollEnabled(true);
          tblAllBeneficiary.setColumnControlVisible(true);
         
        busObj.pop_Talbe(tblAllBeneficiary, "select_Data_Package.get_AllBeneficiaryData(?)", "jXTable1");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        popMenuExportData = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllBeneficiary = new org.jdesktop.swingx.JXTable();

        popMenuExportData.setText("Export All");
        popMenuExportData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popMenuExportDataActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popMenuExportData);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("All Beneficiary in the Database ");
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

        tblAllBeneficiary.setBorder(new javax.swing.border.MatteBorder(null));
        tblAllBeneficiary.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblAllBeneficiary);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       utilObj.flag11=false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void popMenuExportDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popMenuExportDataActionPerformed
        try{
                 toExcel(tblAllBeneficiary);
                 JOptionPane.showMessageDialog(IntFramViewAllBenf.this,"Data Export Successfully !");
        }catch(Exception ex){JOptionPane.showMessageDialog(IntFramViewAllBenf.this,"Data Export Error : error"+ex);}
    }//GEN-LAST:event_popMenuExportDataActionPerformed

   public void toExcel(JXTable table)throws IOException{
        
        JFileChooser jfc = new JFileChooser();
        //set it to be a save dialog
        jfc.setDialogType(JFileChooser.SAVE_DIALOG);
        //set a default filename (this is where you default extension first comes in)
        jfc.setSelectedFile(new File("allBeneficiaryData.xls"));
        //Set an extension filter, so the user sees other XML files
        jfc.setFileFilter(new FileNameExtensionFilter("xls file","xls"));
             
        
        if(jfc.showSaveDialog(this) == jfc.APPROVE_OPTION){
           
           String filename = jfc.getSelectedFile().toString();
            if (!filename .endsWith(".xls"))
                filename += ".xls";

            TableModel model = table.getModel();
            FileWriter out = new FileWriter(filename);
            String groupExport = "";
            for (int i = 0; i < (model.getColumnCount()); i++) {//* disable export from TableHeaders
                groupExport = String.valueOf(model.getColumnName(i));
                out.write(String.valueOf(groupExport) + "\t");
            }
            out.write("\n");
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < (model.getColumnCount()); j++) {
                   if (model.getValueAt(i, j) == null) {
                       out.write("null" + "\t");
                    } else {
                        groupExport = String.valueOf(model.getValueAt(i, j));
                        out.write(String.valueOf(groupExport) + "\t");
                 }
             }
                out.write("\n");
            }
            out.close();
        }
   }
           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem popMenuExportData;
    private org.jdesktop.swingx.JXTable tblAllBeneficiary;
    // End of variables declaration//GEN-END:variables

}
