package org.whiteboard.gradebook;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.JUnit4;

/**
 * Testing suite for the Assignment class
 * @author Alex Jo <jo.al@husky.neu.edu>
 * @version 4/8/14
 *
 */

@RunWith(JUnit4.class) 
public class AssignmentTest {
    
    ////////////////////////// Private Fields /////////////////////////////////
    private Assignment ass0;
    private Assignment ass1;
    private Assignment ass2;
    private Assignment ass3;
    private Student s0;
    private Student s1;
    private Student s2;
    private Student s3;
    private Student s4;
    
    @Before
    public void initialize() {
        ass0 = new Assignment("Ass0", "Test", "A test", 100, 10);
        ass1 = new Assignment("Ass1", "Quiz", "A quiz", 25, 5);
        ass2 = new Assignment("Ass2", "HW", "A homework assignment", 10, 2);
        ass3 = new Assignment("Ass3", "Participation", 
                "in class participation", 15, 1);
        
        s0 = new Student("Fred", "G", "Weasley", "0", "password");
        s1 = new Student("George", "F", "Weasley", "1", "password");
        s2 = new Student("Ron", "G", "Weasley", "2", "password");
        s3 = new Student("Ginny", "G", "Weasley", "3", "password");
        s4 = new Student("Bill", "G", "Weasley", "4", "password");
        
        ass0.addGrade(s0, 100);
        ass0.addGrade(s1, 85);
        ass0.addGrade(s2, 90);
        ass0.addGrade(s3, 50);
        
        ass1.addGrade(s0, 25);
        ass1.addGrade(s1, 20);
        ass1.addGrade(s2, 10);
        ass1.addGrade(s3, 0);
        
        ass2.addGrade(s0, 10);
        ass2.addGrade(s1, 8);
        ass2.addGrade(s2, 5);
        ass2.addGrade(s3, 9);
        ass2.addGrade(s4, 10);
        
        ass3.addGrade(s0, 10);
        ass3.addGrade(s1, 9);
        ass3.addGrade(s2, 8);
        ass3.addGrade(s3, 7);
        ass3.addGrade(s4, 6);
    }
    
    /**
     * Testing for Assignment.getGrade()
     */
    @Test
    public void testGetGrade() {
        assertTrue(100 == ass0.getGrade(s0));
        assertTrue(85 == ass0.getGrade(s1));
        assertTrue(90 == ass0.getGrade(s2));
        assertTrue(50 == ass0.getGrade(s3));
        
        assertTrue(25 == ass1.getGrade(s0));
        assertTrue(20 == ass1.getGrade(s1));
        assertTrue(10 == ass1.getGrade(s2));
        assertTrue(0 == ass1.getGrade(s3));
    
        try {
            ass0.getGrade(s4);
        }
        catch(NoSuchElementException e) {
            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false);
        }
    }
    
    /**
     * Testing for Assignment.calculateAverage()
     */
    @Test
    public void testCalculateAverage() {
        assertEquals(ass0.calculateAverage(), 81.25, 0.01);
        assertEquals(ass1.calculateAverage(), 13.75, 0.01);
        assertEquals(ass2.calculateAverage(), 8.4, 0.01);
        assertEquals(ass3.calculateAverage(), 8, 0.01);
    }
    
    /**
     * Testing for Assignment.calculateMedian()
     */
    @Test
    public void testCalculateMedian() {
        assertEquals(ass0.calculateMedian(), 87.5, 0.01);
        assertEquals(ass1.calculateMedian(), 15, 0.01);
        assertEquals(ass2.calculateMedian(), 9, 0.01);
        assertEquals(ass3.calculateMedian(), 8, 0.01);
    }

    /**
     * Testing for Assignment.getMin()
     */
    @Test
    public void testGetMin() {
        assertTrue(ass0.getMin() == 50);
        assertTrue(ass1.getMin() == 0);
        assertTrue(ass2.getMin() == 5);
        assertTrue(ass3.getMin() == 6);
    }
    
    /**
     * Testing for Assignment.getMax()
     */
    @Test
    public void testGetMax() {
        assertTrue(ass0.getMax() == 100);
        assertTrue(ass1.getMax() == 25);
        assertTrue(ass2.getMax() == 10);
        assertTrue(ass3.getMax() == 10);
    }
}
