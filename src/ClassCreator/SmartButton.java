/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassCreator;


import javax.swing.*;




public class SmartButton extends JButton{
   
 
    private int number;
    private String name;
    
    
  
    public SmartButton(){
        super();
        this.setVisible(true);
        
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
