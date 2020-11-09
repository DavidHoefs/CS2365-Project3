/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game_Objects;

/**
 *
 * @author David Hoefs
 */
public class Character{
    String name;
    String ability;
    String exceptions;
    int hp;
   
    
    public Character(String name){
        this.name = name;
        switch(name){
            case "el_gringo":
                this.hp = 7;
                break;
            case "jourdonnais":
                this.hp = 7;
                break;
            case "kit_carlson":
                this.hp = 7;
                break;
            case "jesse_jones":
                this.hp = 9;
                break;
            case "vulture_sam":
                this.hp = 9;
                break;
            case "rose_doolan":
                this.hp = 9;
                break;
            case "paul_regret":
                this.hp = 9;
            default:
                this.hp =8;
                break;
               
        }
    }
    
    
}
