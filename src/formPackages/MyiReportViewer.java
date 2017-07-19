/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages;

import formPackages.classPackages.persisitanceLayer;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.InputStream;
import java.util.HashMap;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author jo
 */
public class MyiReportViewer extends javax.swing.JInternalFrame {

    persisitanceLayer persistanceObj = new persisitanceLayer();
    
    private MyiReportViewer()
       {
            super("Report Viewer",true,true,true,true);
            initComponents();
            setBounds(10,10,600,500);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    
    public MyiReportViewer(InputStream fileName,HashMap parameter)
        {
                this();
            try
            {             
                    /*JasperPrint print = JasperFillManager.fillReport(
                    fileName, parameter, persistanceObj.get_conn());*/
                    JasperPrint print = JasperFillManager.fillReport(fileName,parameter,persistanceObj.get_conn());
                                        
                    JRViewer viewer=new JRViewer(print);
                    Container c=getContentPane();
                    c.setLayout(new BorderLayout());
                    c.add(viewer);
            }catch(Exception sqle){sqle.printStackTrace();
            } 

        }
    
    public MyiReportViewer(InputStream fileName)
        {
            this(fileName,null);
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 819, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
