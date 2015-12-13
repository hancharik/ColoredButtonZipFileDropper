/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassCreator;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A simple example showing how to use {@link FileDrop}
 * @author Robert Harder, rob@iharder.net
 */
public class ClassCreator {


     public static ArrayList<String> contents = new ArrayList<String>();
      public static final javax.swing.JTextArea text = new javax.swing.JTextArea();
        
        
        
       public static JPanel p = new JPanel(); 
         public static JButton[] studentButtonArray;
         public static JPanel colored;
    
    /** Runs a sample program that shows dropped files */
    public static void main( String[] args )
    {
        javax.swing.JFrame frame = new javax.swing.JFrame( "Class Creator Demo" );
        javax.swing.border.TitledBorder dragBorder = new javax.swing.border.TitledBorder( "Drop 'em" );
      
        
      
        p.setLayout(new GridLayout(2 ,1));
        
        p.add(text);
        colored = new JPanel();
        colored.setLayout(new GridLayout(1 ,1));
        colored.setBackground(Color.red);
    //  colored = createResultButtons(4);
        p.add(colored);
        frame.getContentPane().add( 
            new javax.swing.JScrollPane( p ), 
            java.awt.BorderLayout.CENTER );
        
        new FileDrop( System.out, text, /*dragBorder,*/ new FileDrop.Listener()
        {   public void filesDropped( java.io.File[] files )
            {   for( int i = 0; i < files.length; i++ )
                {   try
                    { 
                        
                        
                            text.setText(null);     
                            contents.clear();
     
    ZipFile zipFile = new ZipFile(files[i].getCanonicalPath());
    Enumeration<? extends ZipEntry> entries = zipFile.entries();
    while(entries.hasMoreElements()){
        ZipEntry entry = entries.nextElement();
        contents.add(entry.toString());
    }
    
    
    
    
    

       
    
                        
                        
                        
                        
                    
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


                        
                        for(int k = 0; k < contents.size(); k++){
                            
                          text.append( contents.get(k) + "\n" ); 
                       }
                        
                        colored.removeAll();
                        colored.add(createResultButtons(contents.size()));
                        
                        //colored.setBackground(randomColor3);//.removeAll();
                     //   p.repaint();
                     //colored = createResultButtons(6);   
                 //colored = createResultButtons(contents.size());
                  // frame.getContentPane().remove(text);      
                        
                   
                  // p.add(createResultButtons(contents.size()));
                   
                   
                   
                   
                      //   frame.getContentPane().add( p , java.awt.BorderLayout.CENTER );
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                       
                    }   // end try
                    catch( java.io.IOException e ) {}
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener

        frame.setBounds( 100, 100, 600, 800 );
        frame.setDefaultCloseOperation( frame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }   // end main

    
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
    studentButtonArray = new JButton[numberOfStudents];
    for(int i = 0; i < studentButtonArray.length; i++){
        JButton b = new JButton();
       // b.setText(contents.get(i));
        // b.setText("" + i);
           
                        int R = (int) (Math.random( )*256);
                        int G = (int)(Math.random( )*256);
                        int B= (int)(Math.random( )*256);
                        Color randomButtonColor = new Color(R, G, B);
                        b.setText( R + "," + G + "," + B );  // this is informativ if you are interested in a particular color, shos the values
        b.setBackground(randomButtonColor);
       // b.addActionListener(new RunConfiguration.StudentButtonListener());
        studentButtonArray[i] = b;
        p1.add(b);
    }
     
     
     return p1;
                
              
 }  // end create result buttons   
    
    
    
    
    

} // end
