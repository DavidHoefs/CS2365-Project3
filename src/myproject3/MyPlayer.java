/*
 * CS2365 FALL 2020 GRROUP PROJECT 3
 * Members: Javier Vasquez, Blane Brown, David Hoefs, Cole, Zach Hunt 
 */
package myproject3;

/**
 *
 * @author Blane Brown, Javier Vasquez
 */
public class MyPlayer {
    //Private data memebers
    //character is what will give a player hp and a name
    //arrows keeps track of the number of arrows on a player
    //maxHp is so the player cant overheal
    //healOther keeps track of how much a player has helped the sheriff
    private final String name;
    private final String role;
    private int hp;
    private int maxHp;
    private int healOther;
    private int arrows;
    private final MyCharacter character;
    private boolean human = false;
    
    //Constructor
    //creates a player object, each player will have one of these
    public MyPlayer(String role, MyCharacter character){
        this.name = character.name;
        this.role = role;
        this.arrows = 0;
        this.character = character;
        this.healOther = 0;
        
        //adds base character hp;
        this.hp = this.character.hp;
        this.maxHp = this.character.hp;
        
        //if the player is the sheriff they get an extra 2 hp
        if("Sheriff".equals(this.role)){
            this.hp = this.character.hp + 2;
            this.maxHp = this.character.hp + 2;
        }    
    }
    
    //Accessors
    //gets the name of the character so we know what their ability is
    //gets the role so when they die it can be revealed
    //gets hp so we know their current health
    //gets arrows so we know how many they got hit by
    //gets how much they have helped the sheriff
    public String getName(){
        return this.name;
    }
    
    public String getRole(){
        return this.role;
    }
    
    public int getHp(){
        return this.hp;
    }
    
    public int getMaxHp(){
        return this.maxHp;
    }
    
    public MyCharacter getCharacter(){
        return character;
    }
    
    public String getCharacterName(){
        return character.name;
    }
    
    public int getArrows(){
        return this.arrows;
    }
    
    public boolean getHuman(){
        return this.human;
    }
    
    public int getHealOther(){
        return this.healOther;
    }
    
    //Mutators 
    //changes the hp of the player
    //changes the number of arrows on a player
    //decreases heal others if they shoot the sheriff
    public void setArrows(int newArrows){
        this.arrows = newArrows;
    }
    
    public void setHuman(){
        this.human = true;
    }
    
    public void increaseHealOther(){
        healOther = healOther + 1;
    }
    
    public void decreaseHealOther(){
        healOther = healOther - 1;
    }
    
    public void setHp(int newHp){
        this.hp = newHp;
    }
    
    public void gainHp(int n){
        if(!(hp + n > maxHp)){  
            hp = hp + n;
        }
    }

    public void loseHp(int n){
        hp = hp - n;
    }
}
