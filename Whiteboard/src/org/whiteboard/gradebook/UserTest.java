package org.whiteboard.gradebook;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.JUnit4;

/**
 * Testing suite for the User, Student, and Teacher classes
 * @author Alex Jo
 * @version 4/11/14
 *
 */
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
        s0 = new Student("George", "F", "Weasley", "1", "2015", "password");
        s1 = new Student("Fred", "G", "Weasley", "2", "2018", "password");
        t0 = new Teacher("George", "Weasley", "1", "password");
        t1 = new Teacher("Fred", "Weasley", "2", "password");
    }
    
    /**
     * Testing for User.getFirstName()
     */
    @Test
    public void testGetFirstName() {
        assertEquals(s0.getFirstName(), "George");
        assertEquals(s1.getFirstName(), "Fred");
        assertEquals(t0.getFirstName(), "George");
        assertEquals(t1.getFirstName(), "Fred");
    }
    
    /**
     * Testing for User.setFirstName()
     */
    @Test
    public void testSetFirstName() {
        s0.setFirstName("Ron");
        s1.setFirstName("Ginny");
        t0.setFirstName("Ron");
        t1.setFirstName("Ginny");
        assertEquals(s0, 
                new Student("Ron", "F", "Weasley", "1", "2015", "password"));
        assertEquals(s1, 
                new Student("Ginny", "G", "Weasley", "2", "2018", "password"));
        assertEquals(t0, new Teacher("Ron", "Weasley", "1", "password"));
        assertEquals(t1, new Teacher("Ginny", "Weasley", "2", "password"));
    }
    
    /**
     * Testing for User.getAdvisor()
     */
    @Test
    public void testGetAdvisor() {
        assertEquals(s0.getAdvisor(), "Weasley");
        assertEquals(s1.getAdvisor(), "Weasley");
    }
    
    /**
     * Testing for User.setAdvisor()
     */
    @Test
    public void testSetAdvisor() {
        s0.setAdvisor("Bob");
        s1.setAdvisor("Bill");
        assertEquals(s0, 
                new Student("George", "F", "Bob", "1", "2015", "password"));
        assertEquals(s1, 
                new Student("Fred", "G", "Bill", "2", "2018", "password"));
    }
    
    /**
     * Testing for User.getLastName()
     */
    @Test
    public void testGetLastName() {
        assertEquals(s0.getLastName(), "F");
        assertEquals(s1.getLastName(), "G");
        assertEquals(t0.getLastName(), "Weasley");
        assertEquals(t1.getLastName(), "Weasley");
    }
    
    /**
     * Testing for User.setLastName()
     */
    @Test
    public void testSetLastName() {
        s0.setLastName("Potter");
        s1.setLastName("Granger");
        t0.setLastName("Potter");
        t1.setLastName("Granger");
        assertEquals(s0, 
                new Student("George", "Potter", "Weasley", "1", "2015", "password"));
        assertEquals(s1, 
                new Student("Fred", "Granger", "Weasley", "2", "2018", "password"));
        assertEquals(t0, new Teacher("George", "Potter", "1", "password"));
        assertEquals(t1, new Teacher("Fred", "Granger", "2", "password"));
    }
    
    /**
     * Testing for User.getID()
     */
    @Test
    public void testGetID() {
        assertTrue(s0.getID().equals("1"));
        assertTrue(s1.getID().equals("2"));
        assertTrue(t0.getID().equals("1"));
        assertTrue(t1.getID().equals("2"));
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
        assertEquals(s0, 
                new Student("George", "F", "Weasley", "3", "2015", "password"));
        assertEquals(s1, 
                new Student("Fred", "G", "Weasley", "4", "2018", "password"));
        assertEquals(t0, new Teacher("George", "Weasley", "3", "password"));
        assertEquals(t1, new Teacher("Fred", "Weasley", "4", "password"));
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
        assertEquals(s0, 
                new Student("George","F","Weasley","1","2015","password0"));
        assertEquals(s1, 
                new Student("Fred","G","Weasley","2","2018","password1"));
        assertEquals(t0, 
                new Teacher("George", "Weasley", "1", "password2"));
        assertEquals(t1, 
                new Teacher("Fred", "Weasley", "2", "password3"));
    }
    
    /**
     * Testing for User.equals()
     */
    @Test
    public void testEquals() {
        assertTrue(s0.equals(
                new Student("George","F","Weasley","1","2015","password")));
        assertTrue(s1.equals(
                new Student("Fred","G","Weasley","2","2018","password")));
        assertTrue(t0.equals(
                new Teacher("George", "Weasley", "1", "password")));
        assertTrue(t1.equals(
                new Teacher("Fred", "Weasley", "2", "password")));
        assertFalse(s0.equals(t0));
        assertFalse(s0.equals(s1));
        assertFalse(s1.equals(t1));
    }
    
    /**
     * Testing for User.hashCode()
     */
    @Test
    public void testHashCode() {
        assertTrue(s0.hashCode() == new Student(
                "George","F","Weasley","1","2015","password").hashCode());
        assertTrue(s1.hashCode() == new Student(
                "Fred", "G", "Weasley", "2", "2018", "password").hashCode());
        assertTrue(t0.hashCode() == 
                new Teacher("George", "Weasley","1","password").hashCode());
        assertTrue(t1.hashCode() == 
                new Teacher("Fred","Weasley","2","password").hashCode());
    }
    
    /**
     * Testing for User.toString()
     */
    @Test
    public void testToString() {
        assertEquals(s0.toString(), "This User is a Student whose name is "
                + "George F and ID number is 1");
        assertEquals(s1.toString(), "This User is a Student whose name is "
                + "Fred G and ID number is 2");
        assertEquals(t0.toString(), "This User is a Teacher whose name is "
                + "George Weasley and ID number is 1");
        assertEquals(t1.toString(), "This User is a Teacher whose name is "
                + "Fred Weasley and ID number is 2");
    }
    
    
}
