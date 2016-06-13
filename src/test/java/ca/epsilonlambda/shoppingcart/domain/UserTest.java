package ca.epsilonlambda.shoppingcart.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by Kirill on 6/12/2016.
 */
public class UserTest {
    User u1, u1Clone, u2;
    Object differentObject;

    @Before
    public void setUp() {
        u1 = new User("kirill");
        u1Clone = new User("kirill");
        u2 = new User("ellen");
        differentObject = new String[] { "cheese" };
    }

    @Test
    public void equalsShouldReturnTrueForEqualUsers() {
        assertTrue(u1.equals(u1));
        assertTrue(u1.equals(u1Clone));
        assertTrue(u1Clone.equals(u1));
    }

    @Test
    public void equalsShouldReturnFalseForNonEqualUsers() {
        assertFalse(u1.equals(u2));
        assertFalse(u2.equals(u1));
    }

    @Test
    public void equalsShouldReturnFalseForDifferentTypes() {
        assertFalse(u1.equals(differentObject));
        assertFalse(u1Clone.equals(differentObject));
        assertFalse(u2.equals(differentObject));
    }
}
