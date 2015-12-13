/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassCreator;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * A simple example showing how to use {@link FileDrop}
 * @author Robert Harder, rob@iharder.net
 */
public class ClassCreator {


     public static ArrayList<String> contents = new ArrayList<String>();
    
    
    /** Runs a sample program that shows dropped files */
    public static void main( String[] args )
    {
        javax.swing.JFrame frame = new javax.swing.JFrame( "Class Creator Demo" );
        javax.swing.border.TitledBorder dragBorder = new javax.swing.border.TitledBorder( "Drop 'em" );
      
        
        final javax.swing.JTextArea text = new javax.swing.JTextArea();
        
        
        
        
        
        
        
        
        
        
        frame.getContentPane().add( 
            new javax.swing.JScrollPane( text ), 
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
                      // this sets a new text color for every file drop  
                      text.setForeground(randomColor1);
                       text.setBackground(randomColor2);
                       // text.append( "r " + R + "g " + G + "b " + B + "\n" );    
                     text.append( "Here's the created class "  + "\n" );    


                        
                        for(int k = 0; k < contents.size(); k++){
                            
                           text.append( contents.get(k) + "\n" ); 
                        }
                        
                        
                        
                        
                       
                    }   // end try
                    catch( java.io.IOException e ) {}
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener

        frame.setBounds( 100, 100, 600, 800 );
        frame.setDefaultCloseOperation( frame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }   // end main

 

}
