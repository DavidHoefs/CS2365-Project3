/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project3;

import Game_Objects.Player;
import Game_Objects.Dice;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Javier
 */
public class Porject3 {
    
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //get number of players between 3-8
        int playerNum = 0;
        while(playerNum < 3 || playerNum > 8){
            System.out.println("Welcome to the game BANG!\n"
                + "Please enter the number of players that will be participating:");
            
            playerNum = Integer.parseInt(reader.readLine());
        }
        
        Player[] players = setUpPlayers(playerNum); //create player objects
        
        for(int i = 0; i < playerNum; i++){
            System.out.println(players[i].getName() + " | " + players[i].getRole());
        }
    }
    
    //populates an array of player objects based on how many players there are
    //asks user for character name, and assigns a random role
    public static Player[] setUpPlayers(int players) throws IOException {
        //full list of available characters
        String[] Chars = {"bart_cassidy", "black_jack", "calamity_janet", 
            "el_gringo", "jesse_jones", "jourdonnais", "kit_carlson", "lucky_duke", 
            "paul_regret", "pedro_ramirez", "rose_doolan", "sid_ketchum",
            "slab_the_killer", "suzy_lafayette", "vulture_sam", "willy_the_kid"};
        List<String> chars = Arrays.asList(Chars);
        
        String[] roles = setRoles(players);//shuffled array of roles
        Player[] p = new Player[players];
        for(int i = 0; i < players; i++){
            System.out.println("Player " + (i + 1) + " enter your character name: ");
            String character = reader.readLine().replace(' ', '_').toLowerCase();
            
            while(!chars.contains(character)){//keep asking if the user input an invalid character
                System.out.println("Character not found.\nPlayer " + (i + 1) + " enter your character name: ");
                character = reader.readLine().replace(' ', '_').toLowerCase();
            }
            p[i] = new Player(character, roles[i]);//create player object
        }
        return p;
    }
    
    //creates a shuffled array with all the roles based on the number of players
    //used to assign players a role later
    public static String[] setRoles(int players){
        String[] roles = new String[players];
        switch(players){
            case 3:
                String[] r3 = {"deputy", "outlaw", "renegade"};
                roles = r3;
                break;
            case 4:
                String[] r4 = {"sheriff", "renegade", "outlaw", "outlaw"};
                roles = r4;
                break;
            case 5:
                String[] r5 = {"sheriff", "renegade", "outlaw", "outlaw", "deputy"};
                roles = r5;
                break;
            case 6:
                String[] r6 = {"sheriff", "renegade", "outlaw", "outlaw", "outlaw", "deputy"};
                roles = r6;
                break;
            case 7:
                String[] r7 = {"sheriff", "renegade", "outlaw", "outlaw", "outlaw", "deputy", "deputy"};
                roles = r7;
                break;
            case 8:
                String[] r8 = {"sheriff", "renegade", "renegade", "outlaw", "outlaw", "ourlaw", "deputy", "deputy"};
                roles = r8;
                break;
        }
        
        return shuffleString(roles);
    }
    
    //shuffle an array of strings
    public static String[] shuffleString(String[] string){
        Random rand = new Random();

        for (int i = 0; i < string.length; i++) {
                int randomIndexToSwap = rand.nextInt(string.length);
                String temp = string[randomIndexToSwap];
                string[randomIndexToSwap] = string[i];
                string[i] = temp;
        }
        
        return string;
    }
}
