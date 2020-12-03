/*
 * CS2365 FALL 2020 GRROUP PROJECT 3
 * Members: Javier Vasquez, Blane Brown, David Hoefs, Cole Townsend, Zach Hunt 
 *
 * This class was created by: David Hoefs
 */
package myproject3;

import java.util.Random;

/**
 * Is the object blueprint of the OldSaloon Dice
 * @author David Hoefs
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
        
        if(this.type == "coward"){
             String[] rollTypes = {"Return Arrow","Dynamite","Shoot 1 Space","Arrow","Double Beer","Beer"};
             return rollTypes[roll];
        }else{
            String[] rollTypes = {"Arrow","Dynamite","Lose Life Point","Double Shoot 1 Space","Double Shoot 2 Spaces","Gatling Gun"};
            return rollTypes[roll];
        }
        
       
        
    }
    
    //returns the value of a 5 dice roll as a string
    @Override
    public String getRollsString(int n){
        if(n >= 0){
            if(this.type == "coward"){
                String[] rollTypes = {"Return Arrow","Dynamite","Shoot 1 Space","Arrow","Double Beer","Beer"};
                return rollTypes[n];
            }else{
                 String[] rollTypes = {"Arrow","Dynamite","Lose Life Point","Double Shoot 1 Space","Double Shoot 2 Spaces","Gatling Gun"};
                return rollTypes[n];
            }
        }else
            return "";
        
    } 
    
    
    
}
