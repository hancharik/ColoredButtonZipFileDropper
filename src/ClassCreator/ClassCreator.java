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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A simple example showing how to use {@link FileDrop}
 * @author Robert Harder, rob@iharder.net
 */
public class ClassCreator {

        static DropPanel p;// = new DropPanel();
 
    
    /** Runs a sample program that shows dropped files */
    public static void main( String[] args )
    {
        
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        
        
        javax.swing.JFrame frame = new javax.swing.JFrame( "Class Creator Demo" );
        javax.swing.border.TitledBorder dragBorder = new javax.swing.border.TitledBorder( "Drop 'em" );
      
        p = new DropPanel();
        
        frame.getContentPane().add( 
            new javax.swing.JScrollPane( p ), 
            java.awt.BorderLayout.CENTER );
        frame.setBounds( 100, 100, 600, 800 );
        frame.setDefaultCloseOperation( frame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }   // end main

 

} // end
