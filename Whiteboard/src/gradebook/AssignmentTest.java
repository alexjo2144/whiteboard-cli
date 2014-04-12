package gradebook;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.JUnit4;

/** Testing suite for the Assignment class
 * 
 * @author Alex Jo <jo.al@husky.neu.edu>
 * @version 4/8/14 */

@RunWith(JUnit4.class)
public class AssignmentTest {
    
    // //////////////////////// Private Fields
    // /////////////////////////////////
    private Assignment ass0;
    private Assignment ass1;
    private Assignment ass2;
    private Assignment ass3;
    private Assignment ass4;
    
    @Before
    public void initialize() {
        ass0 = new Assignment("Ass0", "A test", "Test", 100, 10);
        ass1 = new Assignment("Ass1", "A quiz", "Quiz", 25, 5);
        ass2 = new Assignment("Ass2", "A homework assignment", "HW", 10, 2);
        ass3 =
                new Assignment("Ass3", "In class participation",
                        "Participation", 15, 1);
        
        ass0.addGrade("Fred", 100);
        ass0.addGrade("George", 85);
        ass0.addGrade("Ron", 90);
        ass0.addGrade("Ginny", 50);
        
        ass1.addGrade("Fred", 25);
        ass1.addGrade("George", 20);
        ass1.addGrade("Ron", 10);
        ass1.addGrade("Ginny", 0);
        
        ass2.addGrade("Fred", 10);
        ass2.addGrade("George", 8);
        ass2.addGrade("Ron", 5);
        ass2.addGrade("Ginny", 9);
        ass2.addGrade("Bill", 10);
        
        ass3.addGrade("Fred", 10);
        ass3.addGrade("George", 9);
        ass3.addGrade("Ron", 8);
        ass3.addGrade("Ginny", 7);
        ass3.addGrade("Bill", 6);
    }
    
    /** Testing for Assignment.getGrade() */
    @Test
    public void testGetGrade() {
        assertTrue(100 == ass0.getGrade("Fred"));
        assertTrue(85 == ass0.getGrade("George"));
        assertTrue(90 == ass0.getGrade("Ron"));
        assertTrue(50 == ass0.getGrade("Ginny"));
        
        assertTrue(25 == ass1.getGrade("Fred"));
        assertTrue(20 == ass1.getGrade("George"));
        assertTrue(10 == ass1.getGrade("Ron"));
        assertTrue(0 == ass1.getGrade("Ginny"));
        
        try {
            ass0.getGrade("Bill");
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
        }
        catch (Exception e) {
            assertTrue(false);
        }
    }
    
    /** Testing for Assignment.calculateAverage() */
    @Test
    public void testCalculateAverage() {
        assertEquals(ass0.calculateAverage(), 81.25, 0.01);
        assertEquals(ass1.calculateAverage(), 13.75, 0.01);
        assertEquals(ass2.calculateAverage(), 8.4, 0.01);
        assertEquals(ass3.calculateAverage(), 8, 0.01);
    }
    
    /** Testing for Assignment.calculateMedian() */
    @Test
    public void testCalculateMedian() {
        assertEquals(ass0.calculateMedian(), 87.5, 0.01);
        assertEquals(ass1.calculateMedian(), 15, 0.01);
        assertEquals(ass2.calculateMedian(), 9, 0.01);
        assertEquals(ass3.calculateMedian(), 8, 0.01);
    }
    
    /** Testing for Assignment.getMin() */
    @Test
    public void testGetMin() {
        assertTrue(ass0.getMin() == 50);
        assertTrue(ass1.getMin() == 0);
        assertTrue(ass2.getMin() == 5);
        assertTrue(ass3.getMin() == 6);
    }
    
    /** Testing for Assignment.getMax() */
    @Test
    public void testGetMax() {
        assertTrue(ass0.getMax() == 100);
        assertTrue(ass1.getMax() == 25);
        assertTrue(ass2.getMax() == 10);
        assertTrue(ass3.getMax() == 10);
    }
    
    /** Testing for Assignment.addGrade() */
    @Test
    public void testSetGrade() {
        ass0.setGrade("Fred", 99);
        ass0.setGrade("Harry", 10);
        assertTrue(ass0.getGrade("Fred") == 99);
        assertTrue(ass0.getGrade("Harry") == 10);
    }
    
    /** Testing for Assignment.equals() */
    @Test
    public void testEquals() {
        ass4 = new Assignment("Ass0", "A test", "Test", 100, 10);
        ass4.addGrade("Fred", 100);
        ass4.addGrade("George", 85);
        ass4.addGrade("Ron", 90);
        ass4.addGrade("Ginny", 50);
        assertTrue(ass0.equals(ass4));
        assertFalse(ass0.equals(ass1));
        assertFalse(ass0.equals(ass2));
        assertFalse(ass0.equals(ass3));
    }
    
    /** Testing for Assignment.getName() */
    @Test
    public void testGetName() {
        assertEquals(ass0.getName(), "Ass0");
        assertEquals(ass1.getName(), "Ass1");
        assertEquals(ass2.getName(), "Ass2");
        assertEquals(ass3.getName(), "Ass3");
    }
    
    /** Testing for Assignment.getKind() */
    @Test
    public void testGetKind() {
        assertEquals(ass0.getKind(), "Test");
        assertEquals(ass1.getKind(), "Quiz");
        assertEquals(ass2.getKind(), "HW");
        assertEquals(ass3.getKind(), "Participation");
    }
    
    /** Testing for Assignment.getDescription() */
    @Test
    public void testGetDescription() {
        assertEquals(ass0.getDescription(), "A test");
        assertEquals(ass1.getDescription(), "A quiz");
        assertEquals(ass2.getDescription(), "A homework assignment");
        assertEquals(ass3.getDescription(), "In class participation");
    }
    
    /** Testing for Assignment.getTotalPointsPossible() */
    @Test
    public void testGetTotalPointsPossible() {
        assertTrue(ass0.getTotalPointsPossible() == 100);
        assertTrue(ass1.getTotalPointsPossible() == 25);
        assertTrue(ass2.getTotalPointsPossible() == 10);
        assertTrue(ass3.getTotalPointsPossible() == 15);
    }
    
    /** Testing for Assignment.getWeight() */
    @Test
    public void testGetWeight() {
        assertTrue(ass0.getWeight() == 10);
        assertTrue(ass1.getWeight() == 5);
        assertTrue(ass2.getWeight() == 2);
        assertTrue(ass3.getWeight() == 1);
    }
    
    /** Testing for Assignment.setName() */
    @Test
    public void testSetName() {
        ass4 = new Assignment("Ass4", "A test", "Test", 100, 10);
        ass4.addGrade("Fred", 100);
        ass4.addGrade("George", 85);
        ass4.addGrade("Ron", 90);
        ass4.addGrade("Ginny", 50);
        
        ass0.setName("Ass4");
        
        assertEquals(ass4, ass0);
    }
    
    /** Testing for Assignment.setDescription() */
    @Test
    public void testSetDescription() {
        ass4 = new Assignment("Ass0", "A Quiz", "Test", 100, 10);
        ass4.addGrade("Fred", 100);
        ass4.addGrade("George", 85);
        ass4.addGrade("Ron", 90);
        ass4.addGrade("Ginny", 50);
        
        ass0.setDescription("A Quiz");
        
        assertEquals(ass4, ass0);
    }
    
    /** Testing for Assignment.setName() */
    @Test
    public void testSetKind() {
        ass4 = new Assignment("Ass0", "A test", "Quiz", 100, 10);
        ass4.addGrade("Fred", 100);
        ass4.addGrade("George", 85);
        ass4.addGrade("Ron", 90);
        ass4.addGrade("Ginny", 50);
        
        ass0.setKind("Quiz");
        
        assertEquals(ass4, ass0);
    }
    
    /** Testing for Assignment.setTotalPointsPossible() */
    @Test
    public void testSetTotalPossiblePoints() {
        ass4 = new Assignment("Ass0", "A test", "Test", 150, 10);
        ass4.addGrade("Fred", 100);
        ass4.addGrade("George", 85);
        ass4.addGrade("Ron", 90);
        ass4.addGrade("Ginny", 50);
        
        ass0.setTotalPointsPossible(150);
        
        assertEquals(ass4, ass0);
    }
    
    /** Testing for Assignment.setWeight() */
    @Test
    public void testSetWeight() {
        ass4 = new Assignment("Ass0", "A test", "Test", 100, 5);
        ass4.addGrade("Fred", 100);
        ass4.addGrade("George", 85);
        ass4.addGrade("Ron", 90);
        ass4.addGrade("Ginny", 50);
        
        ass0.setWeight(5);
        
        assertEquals(ass4, ass0);
    }
    
}