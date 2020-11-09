/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_Objects;

/**
 *
 * @author Blane Brown
 */
public class Player {
    
    //private data memebers
    //strings name and role will be assigned after a player has chosen their
    //character and role, hp is then assigned for that specific character and if
    //it is a sheriff they get +2 added to their hp
    private final String name;
    private final String role;
    private int hp;
    private int arrows;
    
    //constructor
    //creates a player object, each player will have one of these
    public Player(String name, String role){
        this.name = name;
        this.role = role;
        this.arrows = 0;
        this.hp = 0;
        
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
    
    public int getArrows(){
        return this.arrows;
    }
    
    //mutators 
    //changes the hp of the player and # of arrows on them
    public void setHp(int newHp){
        this.hp = newHp;
    }
    
    public void setArrows(int newArrows){
        this.arrows = newArrows;
    }
}
