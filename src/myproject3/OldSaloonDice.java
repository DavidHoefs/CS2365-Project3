/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject3;

import java.util.Random;

/**
 * Is the object blueprint of the OldSaloon Dice
 * @author hoefs
 */
public class OldSaloonDice extends MyDice {
    
    
    private int roll;
  
    // loudmouth or coward
    private String type;
    
    /**
     * Creates the Old Saloon version of the Dice
     * @param type sets the type of the dice
     */
    public OldSaloonDice(String type){
        Random rnd = new Random();
        this.roll = rnd.nextInt(6);
        this.type = type;
        
        
        
    }
    
    //Accessors
   
    @Override
    public int getRoll(){
        return this.roll;
    }
    
    //returns the value of a dice roll as a string,
    @Override
    public String getRollString(){
        String[] rollTypes = {"Return Arrow","Lose Life Point","Shoot 1 Space","Shoot 2 Spaces","Double Beer","Gatling Gun"};
       
        return rollTypes[roll];      
    }
    
    //returns the value of a 5 dice roll as a string
    @Override
    public String getRollsString(int n){
        String[] rollTypes = {"Return Arrow","Lose Life Point","Shoot 1 Space","Shoot 2 Spaces","Double Beer","Gatling Gun"};
        return rollTypes[n];
    } 
    
    
    
}
