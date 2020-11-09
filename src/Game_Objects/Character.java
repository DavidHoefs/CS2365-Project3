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
public enum Character {
    PAUL("Paul Regret"),
    JOUR("Jourdonnais"),
    BLACK("Black Jack"),
    SLAB("Slab the Killer"),
    EL("El Gringo"),
    JESSE("Jesse Jones"),
    SUZY("Suzy Lafayette"),
    WILLY("Willy the Kid"),
    ROSE("Rose Doolan"),
    PEDRO("Pedro Ramirez"),
    SID("Sid Ketchum"),
    LUCKY("Lucky Duke"),
    VULTURE("Vulture Sam"),
    CALAMITY("Calamity Janet"),
    KIT("Kit Carlson"),
    BART("Bart Cassidy");
    private String value;

    Character(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}
