import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import static java.lang.System.in;
import javax.swing.filechooser.FileNameExtensionFilter;

public class biodata extends JFrame {

 JFrame f;
 JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
 JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
 JTextArea ta1;
  JButton b1,b2,b3;


 public biodata() {
  f=new JFrame("BIODATA");
  l=new JLabel("BioData");
  l.setFont(new Font("Algerian",Font.BOLD,40));
  l1=new JLabel("Name                         :");
  l2=new JLabel("Address                       :");
  l3=new JLabel("Father's Name                   :");
  l4=new JLabel("Contact Number         :");
  l5=new JLabel("E-Mail Address           :");
  l6=new JLabel("Date OF Birth               :");
  l7=new JLabel("Marital Status             :");
  l8=new JLabel("Gender                          :");
  l9=new JLabel("Nationality                    :");
  l10=new JLabel("Known Language       :");
  l11=new JLabel("Qualification                :");
  l12=new JLabel("Candidate's photo    :");
  t1=new JTextField(20);
  ta1=new JTextArea(20,20);
  int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
  int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
  JScrollPane s=new JScrollPane(ta1,v,h);
  t2=new JTextField(20);
  t3=new JTextField(20);
  t4=new JTextField(20);
  t5=new JTextField(20);
  t6=new JTextField(20);
  t7=new JTextField(20);
  t8=new JTextField(20);
  t9=new JTextField(20);
  t10=new JTextField(20);
  b1=new JButton("Submit");
  
   b3=new JButton("Browse image");
   b2=new JButton("Generate PDF");
  JPanel p=new JPanel();
  p.setLayout(null);

  l.setBounds(200,30,200,50);
  l1.setBounds(80,80,150,30);
  l2.setBounds(80,130,150,30);
  l3.setBounds(80,180,150,30);
  l4.setBounds(80,220,150,30);
  l5.setBounds(80,260,150,30);
  l6.setBounds(80,300,150,30);
  l7.setBounds(80,340,150,30);
  l8.setBounds(80,380,150,30);
  l9.setBounds(80,420,150,30);
  l10.setBounds(80,460,150,30);
  l11.setBounds(80,500,150,30);
  l12.setBounds(80,550,150,30);

  t1.setBounds(250,80,200,25);
  s.setBounds(250,120,200,50);
  t2.setBounds(250,180,200,25);
  t3.setBounds(250,220,200,25);
  t4.setBounds(250,260,200,25);
  t5.setBounds(250,300,200,25);
  t6.setBounds(250,340,200,25);
  t7.setBounds(250,380,200,25);
  t8.setBounds(250,420,200,25);
  t9.setBounds(250,460,200,25);
   t10.setBounds(250,500,200,25);
  b1.setBounds(200,600,100,30);
  b2.setBounds(350,600,100,30);
   b3.setBounds(250,560,200,25);
  
  p.add(l);
  p.add(l1);p.add(l2);
  p.add(l3);
  p.add(l4);p.add(l5);
  p.add(l6);
  p.add(l7);p.add(l8);
  p.add(l9);p.add(l10);
  p.add(l11);p.add(l12);
  p.add(t1);
  p.add(s);p.add(t2);
  p.add(t3);p.add(t4);
  p.add(t5);p.add(t6);
  p.add(t7);p.add(t8);
  p.add(t9);p.add(t10);
  p.add(b3);
  p.add(b1);p.add(b2);

  f.add(p,BorderLayout.CENTER);
  f.add(p);
  
  f.setSize(650,780);
  f.setVisible(true);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
b1.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae)  {
     try {
   Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root",""); {
             PreparedStatement st = con.prepareStatement("Insert into data values(?,?,?,?,?,?,?,?,?,?,?,?)");
             st.setString(1,t1.getText());
             st.setString(2,ta1.getText());
             st.setString(3,t2.getText());
             st.setString(4,t3.getText());
             st.setString(5,t4.getText());
             st.setString(6,t5.getText());
             st.setString(7,t6.getText());
             st.setString(8,t7.getText());
             st.setString(9,t8.getText());
             st.setString(10,t9.getText());
             st.setString(11,t10.getText());
             st.setBlob(12,in);
             st.execute();
         }
           }
       catch(Exception e){ System.err.println(e);
}
              }
   }); 

  b2.addActionListener(new ActionListener(){
      @Override
       public void actionPerformed(ActionEvent ae) {
          try{
              String file_name ="C:\\Users\\USER\\Java_programs\\Generate_pdf\\BioData.pdf";
              Document document = new Document();
              PdfWriter.getInstance(document,new FileOutputStream(file_name));
              document.open();
            String img="C:\\Users\\USER\\Documents\\NetBeansProjects\\quiz1\\src\\photot.jpg";
            Image data = Image.getInstance(img);
           data.setAbsolutePosition(400,700);
           data.scaleAbsoluteHeight(100);
            data.scaleAbsoluteWidth(100);
            document.add(data);
              Paragraph para = new Paragraph("BIODATA");
              document.add(para);
  	       document.add(new Paragraph("   "));
  	      document.add(new Paragraph("Name                 :  "    +t1.getText()));
            	 document.add(new Paragraph("Address           :  "    +ta1.getText()));
            	 document.add(new Paragraph("Father's Name   :  "    +t2.getText()));
            	 document.add(new Paragraph("contact number  :  "    +t3.getText()));
            	 document.add(new Paragraph("E-Mail ID         :  "    +t4.getText()));
            	 document.add(new Paragraph("DOB               :  "    +t5.getText()));
            	 document.add(new Paragraph("Marital status   :  "    +t6.getText()));
            	 document.add(new Paragraph("Gender            :  "    +t7.getText()));
                 document.add(new Paragraph("Nationality       :  "    +t8.getText()));
            	 document.add(new Paragraph("Known language    :  "    +t9.getText()));
            	 document.add(new Paragraph("Qualification     :  "    +t10.getText()));
            	 document.close();
        }
          catch(Exception e){
              System.err.println(e);
}  
          }
     
  });
  
  
b3.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent ae)  {
           JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
          file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
          }
          else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
          }
}
      });


       
  }
  public static void main(String args[]){
   biodata b=new biodata(); 
 }
}