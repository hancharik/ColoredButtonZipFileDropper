/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classy;


import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Mark
 */
//public class SmartButton extends RoundButton{
public class SmartButton extends JButton{   
  public ArrayList<String> files;// = new ArrayList<String>();
    private int number;
    private String name;
    
    
  
    public SmartButton(){
        super();
        this.setVisible(true);
        files = new ArrayList<String>();
    }
    
   public void setId(int n){
       number = n;
   }
   
   
 
    public int getId(){
       return number;
   }
   
   
     
   public void setName(String n){
       name = n;
   }
   
   
 
    public String getName(){
       return name;
   }
   
   
    
}  // end 
