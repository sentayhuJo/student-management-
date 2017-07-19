
package formPackages.classPackages;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;



public class BarcodeGenerator {
   
     DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     Date date = new Date();
     utility utilObj=new utility();
     
     public void BarcodeGeneratorOpen(String fileName,String studentRef){
         try{
         generateBarcode128(fileName,studentRef);
         }catch(Exception ex) {JOptionPane.showMessageDialog(null, ex);}
     }
     public void  barcodeImages(String studetnIDName,PdfWriter writer,Document document){
           
                try{     
                    Font font1 = new Font(Font.FontFamily.TIMES_ROMAN , 10, Font.NORMAL);
                    Font font2 = new Font(Font.FontFamily.TIMES_ROMAN , 8, Font.NORMAL);
                  
                    URL url = this.getClass().getResource("/image/kclc.jpg");

                    Image img = Image.getInstance(url);
                    String issuedDate = dateFormat.format(date);
                    
                    String singleLine="";
                    String[] tokens = studetnIDName.split(Pattern.quote(","));
                    String[] subTokens;
                        for (int j=0;j<tokens.length;j++){
                                singleLine=tokens[j].toString();
                                     subTokens = singleLine.split(Pattern.quote("-"));
                                        
                                               document.add(img);
                          
                                               document.add(new Paragraph (subTokens[1] + " , " + subTokens[2],font1));
                                               document.add(new Paragraph ("Issued Date : " +issuedDate,font1));
                                               Barcode128 code128 = new Barcode128();

                                               code128.setCodeType(Barcode128.CODE128);
                                               code128.setGenerateChecksum(true);
                                               code128.setCode(subTokens[0]);    

                                               document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));

                                               document.add(new Phrase("291-299 Kensington, Lverpool L7 2RG",font2));
                                               document.add(Chunk.NEWLINE);
                                               document.add(new Phrase("Tel. 0151 260 1006, ",font2));
                                               document.add(new Phrase("Facsimile: 0151 260 8664, ",font2));
                                               document.add(Chunk.NEWLINE);
                                               document.add(new Phrase("Email: info@kclc.co.uk",font2));
                                               document.add(new Paragraph(Chunk.NEWLINE));
                           
                         }
                     
                }catch(Exception ex){System.out.println(ex + "error 1");}
                

                       
     }
     
     public void generateBarcode128(String pdfFilename,String studentRef)throws FileNotFoundException, DocumentException,IOException{
              
                try {
                        Font font1 = new Font(Font.FontFamily.TIMES_ROMAN , 8, Font.ITALIC);
                     
                        File newPdfFile=new File(pdfFilename);
                        OutputStream output = new FileOutputStream(newPdfFile);
                        Document document = new Document(new Rectangle(PageSize.LETTER));
                        PdfWriter docWriter = PdfWriter.getInstance(document ,output);
                        
                        document.open();
                        docWriter.open();
                        barcodeImages(studentRef,docWriter,document);
                        document.close();
                        docWriter.close();
                        output.close();
                    
                        try {
                          
                            if (newPdfFile.exists()) {
                                if (Desktop.isDesktopSupported()) {
                                    Desktop.getDesktop().open(newPdfFile);
                                } else {
                                    System.out.println("PDF Viewer is not supported!");
                                }
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                }catch (DocumentException dex){
                   dex.printStackTrace();
                }catch (Exception ex){
                   ex.printStackTrace();
                }                 
     }
 
    
}
