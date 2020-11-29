/*
 * CS2365 FALL 2020 GRROUP PROJECT 3
 * Members: Javier Vasquez, Blane Brown, David Hoefs, Cole, Zach Hunt 
 */
package myproject3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Javier Vasquez, Blane Brown, Zac Hunt
 */
public class MyProject3 {
    //Data members
    private ArrayList<MyPlayer> players;
    private int playerCount = 0;
    
    //Constructor 
    public MyProject3(int n,String expansion){
        this.playerCount = n;
        this.players = populateGame(playerCount, expansion);
    }
    
    
    
    //Accessor
    //gets the array of players
    public ArrayList<MyPlayer> getPlayers(){
        return this.players;
    }
    
    //Accessor
    //gets the number of players
    public int getPlayerCount(){
        return this.playerCount;
    }
    
    //creates n players to be given a role and name and put in the player array
    private ArrayList<MyPlayer> populateGame(int n,String expansion){
        ArrayList<MyPlayer> players = new ArrayList<>();
        
        String[] Chars = getChars(expansion);
         String[] Roles = setRoles(n);
        
       
        
        ArrayList<String> characters = new ArrayList<>();
        characters.addAll(Arrays.asList(shuffleString(Chars)));
        
        ArrayList<String> roles = new ArrayList<>();
        roles.addAll(Arrays.asList(Roles));
        
        //So now we have an arraylist of character names and roles filled, we 
        //now will use these list to create player objects to put in arraylist
        
        //The first player will always be the human player
        MyCharacter p1 = new MyCharacter(characters.get(0));
        MyPlayer human = new MyPlayer(roles.get(0), p1);
        human.setHuman();
        players.add(human);
        
        for(int i = 1; i < n; i++){
            MyCharacter temp = new MyCharacter(characters.get(i));
            players.add(new MyPlayer(roles.get(i), temp));
        }
        
        return players;
    }
    
    private String[] getChars(String expansion){
        
       
        if(expansion == "Old Saloon"){
            String [] Chars = {"El Gringo", "Jesse Jones", "Jourdonnais",
                "Paul Regret", "Pedro Ramirez", "Suzy Lafayette", "Vulture Sam", 
                "Willy The Kid","Jose Delgado","Tequila Joe"};
            return Chars;
        }
        else if(expansion == "Undead Or Alive"){
            String [] Chars = {"El Gringo", "Jesse Jones", "Jourdonnais",
                "Paul Regret", "Pedro Ramirez", "Suzy Lafayette", "Vulture Sam", 
                "Willy The Kid","Belle Star","Greg Digger"};
            return Chars;
        }
        else{
            String [] Chars = {"El Gringo", "Jesse Jones", "Jourdonnais",
                "Paul Regret", "Pedro Ramirez", "Suzy Lafayette", "Vulture Sam", 
                "Willy The Kid"};
            return Chars;
        }
    }
    //shuffle an array of strings
    private String[] shuffleString(String[] string){
        Random rand = new Random();

        for (int i = 0; i < string.length; i++) {
                int randomIndexToSwap = rand.nextInt(string.length);
                String temp = string[randomIndexToSwap];
                string[randomIndexToSwap] = string[i];
                string[i] = temp;
        }
        
        return string;
    }
    
    //creates a shuffled array with all the roles based on the number of players
    //used to assign players a role
    private String[] setRoles(int players){
        String[] roles = new String[players];
        switch(players){
            case 4:
                String[] r4 = {"Sheriff", "Renegade", "Outlaw", "Outlaw"};
                roles = r4;
                break;
            case 5:
                String[] r5 = {"Sheriff", "Renegade", "Outlaw", "Outlaw", "Deputy"};
                roles = r5;
                break;
            case 6:
                String[] r6 = {"Sheriff", "Renegade", "Outlaw", "Outlaw", "Outlaw", "Deputy"};
                roles = r6;
                break;
            case 7:
                String[] r7 = {"Sheriff", "Renegade", "Outlaw", "Outlaw", "Outlaw", "Deputy", "Deputy"};
                roles = r7;
                break;
            case 8:
                String[] r8 = {"Sheriff", "Renegade", "Renegade", "Outlaw", "Outlaw", "Outlaw", "Deputy", "Deputy"};
                roles = r8;
                break;
        }
        
        return shuffleString(roles);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
    }
    
}
