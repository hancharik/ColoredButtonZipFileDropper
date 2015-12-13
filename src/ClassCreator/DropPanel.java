/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassCreator;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JPanel;

/**
 *
 * @author Mark
 */
public class DropPanel extends JPanel{
    
          public static ArrayList<String> contents = new ArrayList<String>();
      public static final javax.swing.JTextArea text = new javax.swing.JTextArea();
        
       public static String  rootFolder = "";
       public static String  tempFolder = " C:\\Users\\Mark\\AppData\\Local\\Temp\\";
       
      // public static JPanel p;// = new JPanel(); 
         public static SmartButton[] studentButtonArray;
         public static JPanel colored;
    
    
    public DropPanel(){
        
        super();
        
        createPanel();
        
        
    }  // end constructor
    
    
       
   private static JPanel createResultButtons(int numberOfStudents){
    
     
  
             
    JPanel p1 = new JPanel(); 
    int rowNumber = 7;
    int dividedBySeven = (numberOfStudents/rowNumber) + 1;
    //p.setLayout(new GridLayout((numberOfStudents/7)+1,7));
    if(numberOfStudents == 7){
       p1.setLayout(new GridLayout(1,7));  
    }else{
    p1.setLayout(new GridLayout(dividedBySeven ,rowNumber));
    }
    studentButtonArray = new SmartButton[numberOfStudents];
    for(int i = 0; i < studentButtonArray.length; i++){
        SmartButton b = new SmartButton();
       // b.setText(contents.get(i));
        // b.setText("" + i);
           
                        int R = (int) (Math.random( )*256);
                        int G = (int)(Math.random( )*256);
                        int B= (int)(Math.random( )*256);
                        Color randomButtonColor = new Color(R, G, B);
                        b.setText( R + "," + G + "," + B );  // this is informativ if you are interested in a particular color, shos the values
                        b.setName(contents.get(i));
                       //    b.setName(shortenString(rootFolder)+ "\\" + tempFolder + contents.get(i));
                        b.setBackground(randomButtonColor);
                        b.addActionListener(new DropPanel.StudentButtonListener());
                        studentButtonArray[i] = b;
                        p1.add(b);
    }
     
     
     return p1;
                
              
 }  // end create result buttons   

    private  void createPanel() {
                
      
       setLayout(new GridLayout(2 ,1));
        
       add(text);
        colored = new JPanel();
        colored.setLayout(new GridLayout(1 ,1));
        colored.setBackground(Color.red);
    //  colored = createResultButtons(4);
        add(colored);
    
        
        new FileDrop( System.out, text, /*dragBorder,*/ new FileDrop.Listener()
        {   public void filesDropped( java.io.File[] files )
            {   for( int i = 0; i < files.length; i++ )
                {   try
                    { 
                        
                        
                           
                            rootFolder = files[i].getCanonicalPath();
    
                        readZipFile(files[i].getCanonicalPath());
       
                        createButtons();
                        
                        
                        
                        
     
                        
                        
                        
                        
                        
                        
                        
                        
                       
                    }   // end try
                    catch( java.io.IOException e ) {}
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener
    }
    
    
    
 // i just cut and pasted the control button listener and adapted it for the student button array
     public static class StudentButtonListener implements ActionListener{ // i'm pretty sure this is from Fred's IST 311 class
        public void actionPerformed(ActionEvent evt){
          
            SmartButton thisButton = (SmartButton) evt.getSource();
            try {
                readZipFile(shortenString(rootFolder)+ "\\" + thisButton.getName());
            } catch (IOException ex) {
                Logger.getLogger(ClassCreator.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    } // end studentButtonListener
 
 
  public static void readZipFile(String file) throws IOException{
      
                            text.setText(null);     
                            contents.clear();
               
    ZipFile zipFile = new ZipFile(file);
    Enumeration<? extends ZipEntry> entries = zipFile.entries();
    while(entries.hasMoreElements()){
        ZipEntry entry = entries.nextElement();
        contents.add(entry.toString());
    }
    
        for(int k = 0; k < contents.size(); k++){
                            
                          text.append( contents.get(k) + "\n" ); 
                       }
                       
          
  }  // end read zip file 
   
  
    public static void createButtons(){
                        //http://mathbits.com/MathBits/Java/Graphics/Color.htm
                        int R = (int) (Math.random( )*256);
                        int G = (int)(Math.random( )*256);
                        int B= (int)(Math.random( )*256);
                        Color randomColor1 = new Color(13, 222, 61);
                        Color randomColor2 = new Color(0, 0, 0);
                         Color randomColor3 = new Color(R, G, B);
                      // this sets a new text color for every file drop  
                      text.setForeground(randomColor1);
                       text.setBackground(randomColor2);
                       // text.append( "r " + R + "g " + G + "b " + B + "\n" );    
                     text.append( "Here's the created class ("  + contents.size() + " students)\n" );    


                        
                     
                        colored.removeAll();
                        colored.add(createResultButtons(contents.size()));
                        
                        //colored.setBackground(randomColor3);//.removeAll();
                     //   p.repaint();
                     //colored = createResultButtons(6);   
                 //colored = createResultButtons(contents.size());
                  // frame.getContentPane().remove(text);      
                        
                   
                  // p.add(createResultButtons(contents.size()));
                   
                   
                   
                   
                      //   frame.getContentPane().add( p , java.awt.BorderLayout.CENTER );
                        
                        
                        
       }  // end create buttons                 
  
      

    
  
  public static String shortenString(String input){
      
      String shorterString = input.substring(0, input.length()-4);
      
      
      
      return shorterString;
  }  // end shorthen string
    
    
    
}  // end
