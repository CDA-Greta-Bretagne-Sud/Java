package fr.cda.disquesvyniles.test;

import fr.cda.disquesvyniles.scrol.Calcul;
import junit.framework.TestCase;
import org.junit.Test;

public class CalculTest extends TestCase {
    @Test
    public void testMulti(){
        assertEquals(4, Calcul.multi(2,2));
    }
    @Test
    public void testAdd(){
        assertEquals(5,Calcul.add(3,2));
    }
    @Test
    public void testSous(){
        assertEquals(1,Calcul.sous(3,2));

    }
}
