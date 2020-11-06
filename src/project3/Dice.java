/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.util.Random;

/**
 *
 * @author Blane Brown
 */
public class Dice {
    
    //private data members
    //the rolls of the dice stored in an array
    private final int[] rolls;

    //constructor
    //Dice value will be a number 0 - 5, where 0 = arrow, 1 = dynamite, 
    //2 = one shot, 3 = two shot, 4 = gatling gun, 5 = beer, this can be seen 
    //in toString, n is the number of dice to be rolled 
    Dice(int n){
        Random rnd = new Random();
        this.rolls = new int[n];
        for(int i = 0; i < n; i++){
            rolls[i] = rnd.nextInt(6);
        }
    } 
    
    //accessor
    //gets the array of dice roll values
    public int[] getRolls(){
        return this.rolls;
    }
    
    //other methods
    //toString makes the array of rolls a easier to read list
    @Override
    public String toString(){
        String[] faces = {"Arrow", "Dynamite", "One Shot", "Two Shot", "Gatling Gun", "Beer"};
        String output = "";
        for(int i = 0; i < rolls.length; i++){
            output = output + faces[rolls[i]] + ", ";
        }
        String finalOutput = output.substring(0, output.lastIndexOf(", "));
        return finalOutput;
    }
}
