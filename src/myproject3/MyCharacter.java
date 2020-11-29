/*
 * CS2365 FALL 2020 GRROUP PROJECT 3
 * Members: Javier Vasquez, Blane Brown, David Hoefs, Cole, Zach Hunt 
 */
package myproject3;

/**
 *
 * @author David Hoefs
 */
public class MyCharacter {
    //Data members
    String name;
    int hp;
    
    //Constructor
    public MyCharacter(String name){
        this.name = name;
        switch(name){
            case "El Gringo":
                this.hp = 7;
                break;
            case "Jourdonnais":
                this.hp = 7;
                break;
            case "Jesse Jones":
                this.hp = 9;
                break;
            case "Vulture Sam":
                this.hp = 9;
                break;
            case "Paul Regret":
                this.hp = 9;
                break;
            case "Willy The Kid":
                this.hp = 8;
                break;
            case "Suzy Lafayette":
                this.hp = 8;
                break;
            case "Pedro Ramirez":
                this.hp = 8;
                break;
            case "Jose Delgado":
                this.hp = 7;
                break;
            case "Tequila Joe":
                this.hp = 7;
                break;
            case "Belle Star" :
                this.hp = 8;
                break;
            case "Greg Digger" :
                this.hp = 7;
                break;
        }
    }
}
