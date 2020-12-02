/*
 * CS2365 FALL 2020 GRROUP PROJECT 3
 * Members: Javier Vasquez, Blane Brown, David Hoefs, Cole, Zach Hunt 
 */
package myproject3;

import java.util.Random;

/**
 * Is the object blueprint of the UndeadAlive Dice
 * @author zhunt, hoeffs
 */
public class UndeadAliveDice extends MyDice {
    
    private int duelRoll;
    private int[] duelRolls;
    
    /**
     * Creates the UndeadAlive version of the Dice
     * @param n is the number of dice
     */
    public UndeadAliveDice(int n){
        Random rnd = new Random();
        this.duelRolls = new int[n];
        for(int i = 0; i < n; i++){
            this.duelRolls[i] = rnd.nextInt(6);
        }
        
    }
    
    @Override
    /**
     * Returns the single Roll
     */
    public int getRoll(){
        return this.duelRoll;
    }
    
     /**
     * Returns the array of Rolls
     */
    public int[] getRolls(){
        return this.duelRolls;
    }
    
     //returns the value of a dice roll as a string,
    @Override
    public String getRollString(){
        
        String[] rollTypes = {"Arrow","Dynamite","Whiskey","Gatling Gun","Duel","Duel" };
        return rollTypes[duelRoll];
    }
    
    
    
    //returns the value of a 5 dice roll as a string
    @Override
    public String getRollsString(int n){
        String[] rollTypes = {"Arrow","Dynamite","Whiskey","Gatling Gun","Duel","Duel" };
        return rollTypes[n];
    } 
    
}
