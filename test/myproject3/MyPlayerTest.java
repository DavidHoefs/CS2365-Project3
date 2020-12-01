/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cole Townsend
 */
public class MyPlayerTest {
    
    /**
     * Test of getName method, of class MyPlayer.
     */
    @Test
    public void testGetName() {
        MyPlayer instance = new MyPlayer("doesn't matter", new MyCharacter("El Gringo"));
        String result = instance.getName();
        assertEquals("El Gringo", result);
    }

    /**
     * Test of getRole method, of class MyPlayer.
     */
    @Test
    public void testGetRole() {
        MyPlayer instance = new MyPlayer("Sheriff", new MyCharacter("El Gringo"));
        String result = instance.getRole();
        assertEquals("Sheriff", result);
    }

    /**
     * Test of getHp method, of class MyPlayer.
     */
    @Test
    public void testGetHp() {
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("El Gringo"));
        int expResult = 7;
        int result = instance.getHp();
        assertEquals(expResult, result);
        instance = new MyPlayer("Sheriff", new MyCharacter("El Gringo"));
        expResult = 9;
        result = instance.getHp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxHp method, of class MyPlayer.
     */
    @Test
    public void testGetMaxHp() {
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        int expResult = 8;
        int result = instance.getMaxHp();
        assertEquals(expResult, result);
        instance = new MyPlayer("Sheriff", new MyCharacter("Willy The Kid"));
        expResult = 10;
        result = instance.getMaxHp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCharacter method, of class MyPlayer.
     */
    @Test
    public void testGetCharacter() {
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        MyCharacter expResult = new MyCharacter("Willy The Kid");
        MyCharacter result = instance.getCharacter();
        assertEquals(expResult.name, result.name);
        assertEquals(expResult.hp, result.hp);
    }

    /**
     * Test of getCharacterName method, of class MyPlayer.
     */
    @Test
    public void testGetCharacterName() {
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        String result = instance.getCharacterName();
        assertEquals("Willy The Kid", result);
    }

    /**
     * Test of getArrows method, of class MyPlayer.
     */
    @Test
    public void testGetArrows() {
        System.out.println("getArrows");
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        int expResult = 0;
        int result = instance.getArrows();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHuman method, of class MyPlayer.
     */
    @Test
    public void testGetHuman() {
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        boolean expResult = false;
        boolean result = instance.getHuman();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHealOther method, of class MyPlayer.
     */
    @Test
    public void testGetHealOther() {
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        int expResult = 0;
        int result = instance.getHealOther();
        assertEquals(expResult, result);
    }

    /**
     * Test of setArrows method, of class MyPlayer.
     */
    @Test
    public void testSetArrows() {
        int newArrows = 13;
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        instance.setArrows(newArrows);
        assertEquals(newArrows, instance.getArrows()); //Since we have already tested getArrows() it should be fine to use it here
    }

    /**
     * Test of setHuman method, of class MyPlayer.
     */
    @Test
    public void testSetHuman() {
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        instance.setHuman();
        assertTrue(instance.getHuman()); //already tested getHuman()
    }

    /**
     * Test of increaseHealOther method, of class MyPlayer.
     */
    @Test
    public void testIncreaseHealOther() {
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        instance.increaseHealOther();
        assertEquals(1, instance.getHealOther());
    }

    /**
     * Test of decreaseHealOther method, of class MyPlayer.
     */
    @Test
    public void testDecreaseHealOther() {
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        instance.decreaseHealOther();
        assertEquals(-1, instance.getHealOther());
    }

    /**
     * Test of setHp method, of class MyPlayer.
     */
    @Test
    public void testSetHp() {
        int newHp = 1375498;
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        instance.setHp(newHp);
        assertEquals(newHp, instance.getHp());
    }

    /**
     * Test of gainHp method AND loseHp method, of class MyPlayer.
     */
    @Test
    public void testGainHp() { 
        MyPlayer instance = new MyPlayer("Renegade", new MyCharacter("Willy The Kid"));
        instance.loseHp(4);
        assertEquals(instance.getMaxHp() - 4, instance.getHp());
        instance.gainHp(2);
        assertEquals(instance.getMaxHp() - 2, instance.getHp());
    }

    
}
