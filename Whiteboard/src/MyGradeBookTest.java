import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import org.whiteboard.gradebook.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.JUnit4;

/**
 * Testing suite for Black Box tests
 * 
 * @author jacobginsparg <jgins@ccs.neu.edu>
 * @version 4/11/2014
 */
@RunWith(JUnit4.class)
public class MyGradeBookTest {

    //////////////////////////Private Fields /////////////////////////////////

    private Assignment myAss0;
    private Assignment myAss1;
    private Assignment myAss2;
    private Assignment myAss3;
    private Assignment myAss4;

    /**
     * An Empty kool GradeBook
     */
    private MyGradeBook kGB0;
    /**
     * A kool GradeBook from initial.txt
     */
    private MyGradeBook kGB1;
    /**
     * A kool GradeBook with assignments from addAssignments.txt
     */
    private MyGradeBook kGB2;
    /**
     * A kool GradeBook with students from addStudents.txt
     */
    private MyGradeBook kGB3;
    /**
     * A kool GradeBook with both
     */
    private MyGradeBook kGB4;

    /**
     * Sets initials
     */
    @Before
    public void initials() {
        
        // Gradebooks
        try {
            this.kGB0 = MyGradeBook.initialize();
            this.kGB1 = MyGradeBook.initializeWithFile("initial.txt");
        }
        catch (FileNotFoundException e) {
            // The file was not found
            assertTrue(false);
        }
        
        // Assignments
        
        
        // Grades
    }
    
    /**
     * Tests the initial GradeBook
     */
    @Test
    public void testInitialize() {
        assertTrue(this.kGB0.equals(MyGradeBook.initialize()));
        assertFalse(this.kGB1.equals(MyGradeBook.initialize()));
    }
    
    /**
     * Tests the processing methods
     */
    @Test
    public void testProcessFile() {
        try {
            assertTrue(this.kGB0.initializeWithFile(
                    "initial.txt").equals(this.kGB1));
            assertTrue(this.kGB1.outputGradebook().equals(
                    MyGradeBook.initializeWithFile(
                            "initial.txt").outputGradebook()));
        }
        catch (FileNotFoundException e) {
            assertTrue(false);
        }
    }
    
    /**
     * Tests the changeGrade method
     */
    @Test
    public void testChangeGrade() {
        try {
            assertTrue(this.kGB1.changeGrade("A2", "abetaylor", 100));
            assertFalse(this.kGB0.changeGrade("HW1", "Bobby", 10));
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }
    
    /**
     * Tests the average method
     */
    @Test
    public void testAverage() {
        assertEquals(this.kGB1.average("A2"), 81.82352941176471, .01);
    }
    
    /**
     * Tests for the median method
     */
    @Test
    public void testMedian() {
        assertEquals(this.kGB1.median("A2"), 83.0, 0);
    }
    
    /**
     * Tests for the min method
     */
    @Test
    public void testMin() {
        assertEquals(this.kGB1.min("A2"), 50.0, 0);
    }
    
    /**
     * Tests for the max method
     */
    @Test
    public void testMax() {
        assertEquals(this.kGB1.max("A2"), 100.0, 0);
    }
    
    /**
     * Tests for the currentGrade method
     */
    @Test
    public void testCurrentGrade() {
        
    }

}