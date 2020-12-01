/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject3;

import java.util.Random;

/**
 *
 * @author hoefs
 */


public class UndeadAliveCards {
    private int[] cards;
    private int card;
    private int cardsRemaining = 11;
    
    
    public UndeadAliveCards(int n){
        Random rnd = new Random();
        this.cards = new int[n];
        for(int i = 0; i < n; i++){
            this.cards[i] = rnd.nextInt(11);
        }
    }
    
    public int getCard(){
        return this.card;
    }
    
    public int[] getCards(){
        return this.cards;
    }
    
     //returns the value of a dice roll as a string,
    
    public String getCardString(){
        
        String[] rollTypes = {"Nothing","One","Two","Nothing","One","Two","Nothing","One","Two","Nothing","Nothing"};
        return rollTypes[card];
    }
    
    
    
    //returns the value of a 5 dice roll as a string
    
    public String getCardsString(int n){
        String[] rollTypes = {"Nothing","One","Two","Nothing","One","Two","Nothing","One","Two","Nothing","Nothing"};
        return rollTypes[n];
    } 
    
    public int drawCard(int i){
        cardsRemaining--;
        return cards[i];
    }
    
}
