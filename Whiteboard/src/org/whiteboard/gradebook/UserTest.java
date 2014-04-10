package org.whiteboard.gradebook;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UserTest {
    
    /** A Student used for testing */
    private Student s0;
    /** A Student used for testing */
    private Student s1;
    /** A Teacher used for testing */
    private Teacher t0;
    /** A Teacher used for testing */
    private Teacher t1;
    
    /**
     * Initializes public fields used for testing
     */
    @Before
    public void initialize() {
        s0 = new Student("George", "1", "password");
        s1 = new Student("Fred", "2", "password");
        t0 = new Teacher("George", "1", "password");
        t1 = new Teacher("Fred", "2", "password");
    }
    
    /**
     * Testing for User.getName()
     */
    @Test
    public void testGetName() {
        assertEquals(s0.getName(), "George");
        assertEquals(s1.getName(), "Fred");
        assertEquals(t0.getName(), "George");
        assertEquals(t1.getName(), "Fred");
    }
    
    /**
     * Testing for User.setName()
     */
    @Test
    public void testSetName() {
        s0.setName("Ron");
        s1.setName("Ginny");
        t0.setName("Ron");
        t1.setName("Ginny");
        assertEquals(s0, new Student("Ron", "1", "password"));
        assertEquals(s1, new Student("Ginny", "2", "password"));
        assertEquals(t0, new Teacher("Ron", "1", "password"));
        assertEquals(t1, new Teacher("Ginny", "2", "password"));
    }
    

    /**
     * Testing for User.getID()
     */
    @Test
    public void testGetID() {
        assertTrue(s0.getID() == "1");
        assertTrue(s1.getID() == "2");
        assertTrue(t0.getID() == "1");
        assertTrue(t1.getID() == "2");
    }
    
    /**
     * Testing for User.setID()
     */
    @Test
    public void testSetID() {
        s0.setID("3");
        s1.setID("4");
        t0.setID("3");
        t1.setID("4");
        assertEquals(s0, new Student("George", "3", "password"));
        assertEquals(s1, new Student("Fred", "4", "password"));
        assertEquals(t0, new Teacher("George", "3", "password"));
        assertEquals(t1, new Teacher("Fred", "4", "password"));
    }
    
    /**
     * Testing for User.getPassword()
     */
    @Test
    public void testGetPassword() {
        assertEquals(s0.getPassword(), "password");
        assertEquals(s1.getPassword(), "password");
        assertEquals(t0.getPassword(), "password");
        assertEquals(t1.getPassword(), "password");
    }
    
    /**
     * Testing for User.setID()
     */
    @Test
    public void testSetPassword() {
        s0.setPassword("password0");
        s1.setPassword("password1");
        t0.setPassword("password2");
        t1.setPassword("password3");
        assertEquals(s0, new Student("George", "1", "password0"));
        assertEquals(s1, new Student("Fred", "2", "password1"));
        assertEquals(t0, new Teacher("George", "1", "password2"));
        assertEquals(t1, new Teacher("Fred", "2", "password3"));
    }
    
    /**
     * Testing for User.equals()
     */
    @Test
    public void testEquals() {
        assertTrue(s0.equals(new Student("George", "1", "password")));
        assertTrue(s1.equals(new Student("Fred", "2", "password")));
        assertTrue(t0.equals(new Teacher("George", "1", "password")));
        assertTrue(t1.equals(new Teacher("Fred", "2", "password")));
        assertFalse(s0.equals(t0));
        assertFalse(s0.equals(s1));
        assertFalse(s1.equals(t1));
    }
    
    /**
     * Testing for User.hashCode()
     */
    @Test
    public void testHashCode() {
        assertTrue(s0.hashCode() == 
                new Student("George", "1", "password").hashCode());
        assertTrue(s1.hashCode() == 
                new Student("Fred", "2", "password").hashCode());
        assertTrue(t0.hashCode() == 
                new Teacher("George", "1", "password").hashCode());
        assertTrue(t1.hashCode() == 
                new Teacher("Fred", "2", "password").hashCode());
    }
    
    /**
     * Testing for User.toString()
     */
    @Test
    public void testToString() {
        assertEquals(s0.toString(), "This User is a Student whose name is "
                + "George and ID number is 1");
        assertEquals(s1.toString(), "This User is a Student whose name is "
                + "Fred and ID number is 2");
        assertEquals(t0.toString(), "This User is a Teacher whose name is "
                + "George and ID number is 1");
        assertEquals(t1.toString(), "This User is a Teacher whose name is "
                + "Fred and ID number is 2");
    }
    
    
}
