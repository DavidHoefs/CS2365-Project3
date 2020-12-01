/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject3;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Cole Townsend
 */
public class MyDiceTest {
    
    public MyDiceTest() {
    }
    
    /**
     * Test of getRolls method, of class MyDice.
     */
    @Test
    public void testGetRolls() {
        int n = 100; //number of rolls
        MyDice instance = new MyDice(n);
        int[] result = instance.getRolls();
        assertTrue(result.length == n);
        for(int i = 0; i < n; i++) {
            assertTrue(result[i] >= 0 && result[i] < 6);
        }
    }

    /**
     * Test of getRoll method, of class MyDice.
     */
    @Test
    public void testGetRoll() {
        MyDice instance = new MyDice();
        int result = instance.getRoll();
        assertTrue(result >= 0 && result < 6);
    }

    /**
     * Test of getRollString method, of class MyDice.
     */
    @Test
    public void testGetRollString() {
        MyDice instance = new MyDice();
        String[] rollTypes = {"Arrow", "Dynamite", "Shoot 1 Space", "Shoot 2 Spaces", "Gatling Gun", "Beer"};
        List<String> list = Arrays.asList(rollTypes);
        String result = instance.getRollString();
        assertTrue(list.contains(result));
    }

    /**
     * Test of getRollsString method, of class MyDice.
     */
    @Test
    public void testGetRollsString() {
        int n = 100;
        MyDice instance = new MyDice(n);
        String[] rollTypes = {"Arrow", "Dynamite", "Shoot 1 Space", "Shoot 2 Spaces", "Gatling Gun", "Beer"};
        List<String> list = Arrays.asList(rollTypes);
        int[] rolls = instance.getRolls();
        String result;
        for(int i = 0; i < n; i++) {
            result = instance.getRollsString(rolls[i]);
            assertEquals(rollTypes[rolls[i]], result);
        }
    }
    
}
