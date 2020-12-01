/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject3;


import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author c4tow
 */
public class MyCharacterTest {
 
    /**
     * Test of MyCharacter constructor, of class MyCharacter.
     */
    @Test
    public void testCreation() {
        MyCharacter tester0 = new MyCharacter("Willy The Kid");
        assertEquals("Willy The Kid", tester0.name);
        assertEquals(8, tester0.hp);
        MyCharacter tester1 = new MyCharacter("Tequila Joe");
        assertEquals("Tequila Joe", tester1.name);
        assertEquals(7, tester1.hp);
        MyCharacter tester2 = new MyCharacter("El Gringo");
        assertEquals("El Gringo", tester2.name);
        assertEquals(7, tester2.hp);
        MyCharacter tester3 = new MyCharacter("Jesse Jones");
        assertEquals("Jesse Jones", tester3.name);
        assertEquals(9, tester3.hp);
    }
    
}
