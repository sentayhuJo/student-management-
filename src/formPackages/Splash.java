/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formPackages;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import formPackages.classPackages.utility;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jo
 */
public class Splash extends JFrame{
    private JLabel imglabel;
    private ImageIcon img;
    private static JProgressBar pbar;
    Thread t = null;
    static utility utilObj=new utility();
    
    public Splash() {
        super("Splash");
        setSize(638, 236);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        img = new ImageIcon(getClass().getResource("/image/splashImage.jpg"));
        imglabel = new JLabel(img);
        add(imglabel);
        setLayout(null);
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setStringPainted(true);
        pbar.setForeground(Color.blue);
        imglabel.setBounds(0, 0, 638, 236);
        add(pbar);
        pbar.setPreferredSize(new Dimension(310, 30));
        pbar.setBounds(0, 215, 638, 20);
 
        Thread t = new Thread() {
 
            public void run() {
                utilObj.connect();
                int i = 0;
                while (i <= 100) {
                    pbar.setValue(i);
                    try {
                        sleep(50);
                         
               
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        t.start();
    }
    
    public static void main(String[] args)throws Exception {
      
        Splash s=new Splash();
        s.setVisible(true);
        Thread t=Thread.currentThread();
        t.sleep(5000);
        s.dispose();
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
               
                try{
                    //UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
                    //UIManager.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());
                    //UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
                    UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel()); // good
                    //UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());
                    // UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel()); // not good look
                    //UIManager.setLookAndFeel(new SyntheticaMauveMetallicLookAndFeel());
                    ///UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
                        if(!(utilObj.flag==1))
                            new ConnectionSettingFrm().setVisible(true);
                        else
                            new frmLogin().setVisible(true);
                        
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
               
            }
        });
        
    }
}
