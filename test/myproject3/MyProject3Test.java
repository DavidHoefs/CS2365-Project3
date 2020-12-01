/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject3;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cole Townsend
 */
public class MyProject3Test {
    
    /**
     * Test of getPlayers method, of class MyProject3.
     */
    @Test
    public void testGetPlayers() {
        String[] expAsArray =  {"El Gringo", "Jesse Jones", "Jourdonnais",
                "Paul Regret", "Pedro Ramirez", "Suzy Lafayette", "Vulture Sam", 
                "Willy The Kid"};
        MyProject3 instance = new MyProject3(expAsArray.length, "Default");
        ArrayList<MyPlayer> result = instance.getPlayers();
        System.out.println(result);
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0; i < result.size(); i++) {
         names.add(result.get(i).getName());
            System.out.println(names.get(i));
        }
        for (String character : expAsArray) {
            assertTrue(names.contains(character));
        }
    }

    /**
     * Test of getPlayerCount method, of class MyProject3.
     */
    @Test
    public void testGetPlayerCount() {
        int expResult = 7;
        MyProject3 instance = new MyProject3(expResult, "Default");
        int result = instance.getPlayerCount();
        assertEquals(expResult, result);
    }
    
}
