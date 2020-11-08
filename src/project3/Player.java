/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author Blane Brown
 */
public class Player {
    
    //private data memebers
    //strings name and role will be assigned after a player has chosen their
    //character and role, hp is then assigned for that specific character and if
    //it is a sheriff they get +2 added to their hp
    private String name = "";
    private String role = "";
    private int hp = 0;
    
    //constructor
    //creates a player object, each player will have one of these
    public Player(String name, String role, int lifePoints){
        this.name = name;
        this.role = role;
        this.hp = lifePoints;
        
        if("sheriff".equals(role)){
            this.hp = this.hp + 2;
        }
    }
    
    //accessors
    //gets the name of the character so we know what their ability is, gets the
    //role so when they die it can be revealed and gets hp so we know their
    //their current health
    public String getName(){
        return this.name;
    }
    
    public String getRole(){
        return this.role;
    }
    
    public int getHp(){
        return this.hp;
    }
    
    //mutators 
    //changes the hp of the player
    public void setHp(int newHp){
        this.hp = newHp;
    }
}