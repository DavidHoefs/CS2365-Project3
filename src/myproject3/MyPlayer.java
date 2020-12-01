/*
 * CS2365 FALL 2020 GRROUP PROJECT 3
 * Members: Javier Vasquez, Blane Brown, David Hoefs, Cole Townsend, Zach Hunt 
 */
package myproject3;

/**
 * Is the object blueprint for a player.
 * Stores things such as name, role, health-points, maximum health-points,
 * arrows, what character they are, and if they are a human player or not
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
    public boolean zombie = false;
    
    //Constructor
    //creates a player object, each player will have one of these
    /**
     * Creates a player object. Each player will have one of these assigned to them.
     * @param role is used to assign what role the player is
     * @param character is used to assign what character the player is playing as
     */
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
  
    /**
     * gets the name of the character so we know what their ability is
     * @return the name of the player
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * gets the role so when they die it can be revealed
     * @return the role of the player
     */
    public String getRole(){
        return this.role;
    }
    
    /**
     * gets hp so we know their current health
     * @return the current hp of the player
     */
    public int getHp(){
        return this.hp;
    }
    
    /**
     * Gets the maximum healthpoints this player can have. 
     * @return the maxHp of the player
     */
    public int getMaxHp(){
        return this.maxHp;
    }
    
    /**
     * Gets the character that the player is playing as.
     * @return the character of the player
     */
    public MyCharacter getCharacter(){
        return character;
    }
    
    /**
     * Gets the character name that the player is playing as
     * @return a string of the name of the character
     */
    public String getCharacterName(){
        return character.name;
    }
    
    /**
     * gets arrows so we know how many they got hit by
     * @return the number of arrows the player has
     */
    public int getArrows(){
        return this.arrows;
    }
    
    /**
     * Sees if the player is human or not
     * @return a boolean describing whether or not the player is human
     */
    public boolean getHuman(){
        return this.human;
    }
    
    /**
     * gets how much they have helped the sheriff
     * @return how much the player has healed another player
     */
    public int getHealOther(){
        return this.healOther;
    }
    
    //Mutators 
    
    /**
     * Changes the number of arrows the player has. 
     * @param newArrows 
     */
    public void setArrows(int newArrows){
        this.arrows = newArrows;
    }
    
    /**
     * Turns this player into a human player
     *
     */
    public void setHuman(){
        this.human = true;
    }
    
    /**
     * Increases the counter for how much you have healed others
     */
    public void increaseHealOther(){
        healOther = healOther + 1;
    }
    
    /**
     * Decreases the counter for for much you have healed others 
     * for if they shoot the sheriff
     */
    public void decreaseHealOther(){
        healOther = healOther - 1;
    }
    
    /**
     * Sets the hp of the player
     * @param newHp
     */
    public void setHp(int newHp){
        this.hp = newHp;
    }
    
    /**
     * Increases the health of the player by 'n'
     * @param n
     */
    public void gainHp(int n){
        if(!(hp + n > maxHp)){  
            hp = hp + n;
        }
    }

    /**
     * Decreases the health of the player by 'n'
     * @param n
     */
    public void loseHp(int n){
        hp = hp - n;
    }
}
