/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.util.Random;

/**
 *
 * @author blane
 */
public class Dice {
    
    //private data members
    //the face of the dice thats showing
    private final int face;

    //constructor
    //Dice value will be a number 0 - 5, where 0 = arrow, 1 = dynamite, 
    //2 = one shot, 3 = two shot, 4 = gatling gun, 5 = beer, this can be seen 
    //in toString 
    Dice(){
        Random rnd = new Random();
        this.face = rnd.nextInt(6);
    }
    
    //accessor
    //gets the dices current showing face
    public int getFace(){
        return this.face;
    }
    
    //other methods
    //toString makes the face value a word
    @Override
    public String toString(){
        String[] faces = {"Arrow", "Dynamite", "One Shot", "Two Shot", "Gatling Gun", "Beer"};
        String output = faces[this.face];
        return output;
    }
}
