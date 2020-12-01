/*
 * CS2365 FALL 2020 GRROUP PROJECT 3
 * Members: Javier Vasquez, Blane Brown, David Hoefs, Cole, Zach Hunt 
 */
package myproject3;

import java.util.Random;

/**
 * Is the object blueprint of the set of dice. On creation the dice are rolled and the values of the rolls are stored in an array. 
 * @author Blane Brown
 */
public class MyDice {
    //Private data members
    //the rolls of the dice stored in an array
    //a single roll for re-roll purposes
    private int roll;
    private int[] rolls;

    /**
     * Constructor for single dice roll. The single role object is used for re-roll purposes. 
     * Dice value will be a number 0 - 5, where 0 = arrow, 1 = dynamite, 2 = one shot,
     * 3 = two shot, 4 = gatling gun, 5 = beer, this can be seen in toString,
     * n is the number of dice to be rolled 
     */
    public MyDice(){
        Random rnd = new Random();
        this.roll = rnd.nextInt(6);
    } 
    
    /**
     * Constructor for multiple dice roll. All 'n' rolls will be stored in an array. 
     * @param n 'n' is the number of dice that will be rolled and stored in an array
     */
    public MyDice(int n){
        Random rnd = new Random();
        this.rolls = new int[n];
        for(int i = 0; i < n; i++){
            this.rolls[i] = rnd.nextInt(6);
        }
        
    }
    
    /**
     * Accessor to the array of roll values
     * @return the current array that is storing the rolls
     */
    public int[] getRolls(){
        return this.rolls;
    }
    
    /**
     * Accessor to the integer that is storing the single roll value. 
     * @return the current value of the variable that is storing the roll
     */
    public int getRoll(){
        return this.roll;
    }
    
    //returns the value of a dice roll as a string
    /**
     * @return the value of a dice roll as a string
     */
    public String getRollString(){
        String[] rollTypes = {"Arrow", "Dynamite", "Shoot 1 Space", "Shoot 2 Spaces", "Gatling Gun", "Beer"};
        return rollTypes[roll];      
    }
    
    /**
     * @param n the index of the array that is holding the roll values
     * @return the value of a dice roll as a string at index 'n' in the array of rolls
     */
    public String getRollsString(int n){
        String[] rollTypes = {"Arrow", "Dynamite", "Shoot 1 Space", "Shoot 2 Spaces", "Gatling Gun", "Beer"};
        return rollTypes[n];
    } 
    
}

