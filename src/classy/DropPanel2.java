/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classy;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
public class DropPanel2 extends JPanel{
    
          public  ArrayList<String> contents = new ArrayList<String>();
      public  final javax.swing.JTextArea text = new javax.swing.JTextArea();
       String zipFilePath = "";
      
          String workingDirectoryUpOne = System.getProperty("user.dir"); // get the working directory
          
         
      
        public  String destDirectory = "";
        UnzipUtility unzipper = new UnzipUtility();
        
        
        
       public  String  rootFolder = "";
      // public static String  tempFolder = " C:\\Users\\Mark\\AppData\\Local\\Temp\\";
       
      // public static JPanel p;// = new JPanel(); 
         public  SmartButton[] studentButtonArray;
         public  JPanel colored;
    
    
    public DropPanel2(){
        
        super();
         workingDirectoryUpOne = workingDirectoryUpOne.replace( "ClassCreator", "");
         destDirectory = workingDirectoryUpOne  + "bucket";//destDirectory = workingDirectoryUpOne + "\\" + "bucket";
         System.out.println("bucket created at: " + destDirectory);
        createPanel();
        
        
    }  // end constructor
    
    
       
   private  JPanel createResultButtons(int numberOfStudents){
    
     
  
             
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
                       // b.setBackground(randomButtonColor);
                        int hundred = (int)(Math.random( )*100 + 1);
                       // b.setBackground(intToCol(i*(100/studentButtonArray.length)));
                       // b.setBackground(intToCol(100)); // test for black
                         b.setBackground(intToCol(0)); // test for white
                        b.setBorderPainted(false);
                        b.addActionListener(new DropPanel2.StudentButtonListener());
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
        colored.setBackground(Color.blue);
    //  colored = createResultButtons(4);
        add(colored);
    
        
        new FileDrop( System.out, text, /*dragBorder,*/ new FileDrop.Listener()
        {   public void filesDropped( java.io.File[] files )
            {   for( int i = 0; i < files.length; i++ )
                {   try
                    { 
                        
                        // studentprogramtester.App.thisIsWhereYouPutTheMainFile = files[i].getCanonicalPath() +  "\\"; // need to add the slash here or it breaks
                           
                        rootFolder = files[i].getCanonicalPath();
                         rootFolder = rootFolder.replace(File.separator, "/"); 
                        classy.ClassCreator.namBre = shortenString(getTopFileFromString(rootFolder));
                         System.out.println("Get namBre from string: " + getTopFileFromString(classy.ClassCreator.namBre));
                         System.out.println("OUR OLD CLASS NAME IS: " + rootFolder);
                       //   rootFolder = getTopFileFromString(rootFolder);
                       //  System.out.println("OUR nEW CLASS NAME IS: (classy.ClassCreator.namBre) " + classy.ClassCreator.namBre);
                        zipFilePath = rootFolder;
                        
                        createClassFolder();
    
                        readZipFile(files[i].getCanonicalPath());
       
                        createButtons();
                        
                        
                        
                        
     
                        
                        
                        
                        
                        
                        
                        
                        
                       
                    }   // end try
                    catch( java.io.IOException e ) {}
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener
    }
    
    
    
 // i just cut and pasted the control button listener and adapted it for the student button array
     public  class StudentButtonListener implements ActionListener{ // i'm pretty sure this is from Fred's IST 311 class
        public void actionPerformed(ActionEvent evt){
          
            SmartButton thisButton = (SmartButton) evt.getSource();
            try {
                String temp1 = destDirectory + "\\" + thisButton.getName();
                
                System.out.println("Contents of " + destDirectory + "\\" + thisButton.getName() + ":");
                String tempString = destDirectory + "\\" + thisButton.getName();
                tempString = tempString.split("/", 2)[0];
           
               System.out.println("Contents of tempstring: " + tempString);
               System.out.println("Contents of temp1: " + temp1);
                  temp1 = temp1.replace(tempString, "");
                 System.out.println("Updated Contents of temp1: " + temp1);
                readZipFile(destDirectory + "\\" + thisButton.getName());
                
                System.out.println("Get namBre from string: " + getTopFileFromString(classy.ClassCreator.namBre));
                //readZipFile(shortenString(rootFolder)+ "\\" + thisButton.getName());
            } catch (IOException ex) {
                Logger.getLogger(ClassCreator.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    } // end studentButtonListener
 
 
  public void readZipFile(String file) throws IOException{
      
                            text.setText(null);     
                            contents.clear();
             
    ZipFile zipFile = new ZipFile(file);
    Enumeration<? extends ZipEntry> entries = zipFile.entries();
    while(entries.hasMoreElements()){
        ZipEntry entry = entries.nextElement();
        contents.add(entry.toString());
    }
    //text.append( "contents of " +contents.get(0) + "\n" ); 
        for(int k = 0; k < contents.size(); k++){// for(int k = 1; k < contents.size(); k++){
                            
                          text.append( contents.get(k) + "\n" ); // text.append( getTopFileFromString(contents.get(k)) + "\n" ); 
                          String fullZipFile = destDirectory + "\\" + contents.get(k);
                          System.out.println("Unzipping "  + fullZipFile);
                         unzipper.unzip(fullZipFile, destDirectory + "\\testClass1");
                       
        }
                       
          
  }  // end read zip file 
   
  
  
  
    public void createButtons(){
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
           
                        
       }  // end create buttons                 
  
      
public void unZipInnerFiles(){
    
    for(int i = 0; i < contents.size(); i++){
       
        
        
        
    }
    
}
    
  
  public String shortenString(String input){
      
      String shorterString = input.substring(0, input.length()-4);
      
      
      
      return shorterString;
  }  // end shorthen string
 
  
  // this unzips the file and creates a folder under the main working program directory
    public void createClassFolder(){
      
      try {
            unzipper.unzip(zipFilePath, destDirectory);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
  }  // end shorthen string
 
    public String getTopFileFromString(String temp1){
        
          String temp11 = temp1;
               // for (int i = 0; i < 3; i++){ 
                while (temp11.contains("/")){
                
                
                String tempString2 = temp11;
                tempString2 = tempString2.split("/", 2)[0]; //get everything before the first slash
                tempString2 = tempString2 + "/";  // add the slash
                temp11 = temp11.replace(tempString2, ""); //remove the first folder including the slash
                
                }
            return temp11;
    } // end get top file from string
    
    
  public void unzipEverythingInside(String file){
      
      
  }  
    
    
   // http://stackoverflow.com/questions/2780546/converting-a-number-to-a-greyscale-color-in-java
    // this takes an int and converts it to a grayscale, 0 is white, 100 is black
Color intToCol(int colNum)
{
  int rgbNum = 255 - (int) ((colNum/100.0)*255.0);
  return new Color (rgbNum,rgbNum,rgbNum);
}
    
}  // end
