/*
 * CS2365 FALL 2020 GRROUP PROJECT 3
 * Members: Javier Vasquez, Blane Brown, David Hoefs, Cole, Zach Hunt 
 */
package myproject3;

import java.util.Random;

/**
 *
 * @author Blane Brown
 */
public class MyDice {
    //Private data members
    //the rolls of the dice stored in an array
    //a single roll for re-roll purposes
    private int roll;
    private int[] rolls;

    //Constructor
    //Dice value will be a number 0 - 5, where 0 = arrow, 1 = dynamite, 
    //2 = one shot, 3 = two shot, 4 = gatling gun, 5 = beer, this can be seen 
    //in toString, n is the number of dice to be rolled 
    public MyDice(){
        Random rnd = new Random();
        this.roll = rnd.nextInt(6);
    } 
    
    public MyDice(int n){
        Random rnd = new Random();
        this.rolls = new int[n];
        for(int i = 0; i < n; i++){
            this.rolls[i] = rnd.nextInt(6);
        }
        
    }
    
    //Accessors
    public int[] getRolls(){
        return this.rolls;
    }
    
    public int getRoll(){
        return this.roll;
    }
    
    //returns the value of a dice roll as a string
    public String getRollString(){
        String[] rollTypes = {"Arrow", "Dynamite", "Shoot 1 Space", "Shoot 2 Spaces", "Gatling Gun", "Beer"};
        return rollTypes[roll];      
    }
    
    //returns the value of a 5 dice roll as a string
    public String getRollsString(int n){
        String[] rollTypes = {"Arrow", "Dynamite", "Shoot 1 Space", "Shoot 2 Spaces", "Gatling Gun", "Beer"};
        return rollTypes[n];
    } 
    
}

