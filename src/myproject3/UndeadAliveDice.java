/*
 * CS2365 FALL 2020 GRROUP PROJECT 3
 * Members: Javier Vasquez, Blane Brown, David Hoefs, Cole, Zach Hunt 
 */
package myproject3;

import java.util.Random;

/**
 *
 * @author zhunt, hoeffs
 */
public class UndeadAliveDice extends MyDice {
    
    private int roll;
    
    public UndeadAliveDice(String type){
        Random rnd = new Random();
        this.roll = rnd.nextInt(6);
    }
    
    @Override
    public int getRoll(){
        return this.roll;
    }
    
     //returns the value of a dice roll as a string,
    @Override
    public String getRollString(){
        
        String[] rollTypes = {"Arrow","Dynamite","Whiskey","Gatling Gun","Duel","Duel" };
        return rollTypes[roll];
    }
    
    
    
    //returns the value of a 5 dice roll as a string
    @Override
    public String getRollsString(int n){
        String[] rollTypes = {"Arrow","Dynamite","Whiskey","Gatling Gun","Duel","Duel" };
        return rollTypes[n];
    } 
    
}
