import static org.junit.Assert.*;
import gradebook.MyGradeBook;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.JUnit4;

/** Testing suite for Black Box tests
 * 
 * @author jacobginsparg <jgins@ccs.neu.edu>
 * @version 4/11/2014 */
@RunWith(JUnit4.class)
public class MyGradeBookTest {
    
    // ////////////////////////Private Fields
    // /////////////////////////////////
    
    /** An Empty kool GradeBook */
    private MyGradeBook kGB0;
    /** A kool GradeBook from initial.txt */
    private MyGradeBook kGB1;
    /** Sets initials */
    @Before
    public void initials() {
        
        // Gradebooks
        this.kGB0 = MyGradeBook.initialize();
        this.kGB1 = MyGradeBook.initializeWithFile("initial.txt");
        MyGradeBook.initialize();
    }
    
    /** Tests the initial GradeBook */
    @Test
    public void testInitialize() {
        assertTrue(this.kGB0.equals(MyGradeBook.initialize()));
        assertFalse(this.kGB1.equals(MyGradeBook.initialize()));
    }
    
    /** Tests the processing methods */
    @Test
    public void testProcessFile() {
        assertTrue(this.kGB0.initializeWithFile("initial.txt").equals(
                this.kGB1));
        assertTrue(this.kGB1.outputGradebook().equals(
                MyGradeBook.initializeWithFile("initial.txt")
                        .outputGradebook()));
    }
    
    /** Tests the processing strings method */
    @Test
    public void testProcessString() {
        
        // addAssignments.txt
        this.kGB1.processFile("addAssignments.txt");
        this.kGB1.changeGrade("Test", "abetaylor", 100.0);
        assertEquals(this.kGB1.average("Test"), 5.88, 0.1);
        
        // addStudents.txt
        this.kGB1.processFile("addStudents.txt");
        assertEquals(this.kGB1.currentGrade("iaartinez"), 0.0, 0);
        this.kGB1.changeGrade("Test", "iaartinez", 100.0);
        assertEquals(this.kGB1.assignmentGrade("Test", "iaartinez"), 100.0, 0);
        
        // assignmentGrade1.txt
        this.kGB1.processFile("gradesForAssignment1.txt");
        assertEquals(
                this.kGB1.assignmentGrade("Opening Assignment", "illines"),
                9.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Opening Assignment", "xaod"),
                6.0, 0);
        
        // assignmentGrade2.txt
        this.kGB1.processFile("gradesForAssignment2.txt");
        assertEquals(this.kGB1.assignmentGrade("A2", "illines"), 52.0, 0);
        assertEquals(this.kGB1.assignmentGrade("A2", "xaod"), 98.0, 0);
        
        // assignmentGrade3.txt
        this.kGB1.processFile("gradesForAssignment3.txt");
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "abetaylor"),
                82.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "abethes"),
                92.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "acit"),
                122.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "ahrown"),
                146.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "amller"),
                100.0, 0);
        assertEquals(this.kGB1.assignmentGrade("First Group Project", "are"),
                99.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "enwilson"),
                123.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "gailarti"),
                132.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "iaartinez"),
                79.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "illines"),
                128.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "marson"),
                136.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "michaeia"),
                121.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "mijacks"),
                93.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "oliviaas"),
                78.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "onon"),
                136.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "onson"),
                133.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "thms"),
                111.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "vaern"),
                137.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "xaod"),
                93.0, 0);
        assertEquals(
                this.kGB1.assignmentGrade("First Group Project", "ydenavi"),
                134.0, 0);
        
        // assignmentGrade4.txt
        this.kGB1.processFile("gradesForAssignment4.txt");
        assertEquals(this.kGB1.assignmentGrade("Test", "abetaylor"), 65.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "abethes"), 88.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "acit"), 85.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "ahrown"), 57.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "amller"), 82.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "are"), 68.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "enwilson"), 97.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "gailarti"), 73.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "iaartinez"), 50.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "illines"), 79.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "marson"), 54.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "michaeia"), 58.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "mijacks"), 83.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "oliviaas"), 61.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "onon"), 51.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "onson"), 71.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "thms"), 92.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "vaern"), 83.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "xaod"), 91.0, 0);
        assertEquals(this.kGB1.assignmentGrade("Test", "ydenavi"), 84.0, 0);
        
        // gradesForStudent.txt
        this.kGB1.processFile("gradesForStudent.txt");
        assertEquals(
                this.kGB1.assignmentGrade("Opening Assignment", "iaartinez"),
                6.0, 0);
        assertEquals(this.kGB1.assignmentGrade("A2", "iaartinez"), 51.0, 0);
    }
    
    /** Tests the changeGrade method */
    @Test
    public void testChangeGrade() {
        try {
            assertTrue(this.kGB1.changeGrade("A2", "abetaylor", 100.0));
            assertFalse(this.kGB0.changeGrade("HW1", "Bobby", 10.0));
        }
        catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }
    
    /** Tests the average method */
    @Test
    public void testAverage() {
        assertEquals(this.kGB1.average("A2"), 81.82352941176471, .01);
    }
    
    /** Tests for the median method */
    @Test
    public void testMedian() {
        assertEquals(this.kGB1.median("A2"), 83.0, 0);
    }
    
    /** Tests for the min method */
    @Test
    public void testMin() {
        assertEquals(this.kGB1.min("A2"), 50.0, 0);
    }
    
    /** Tests for the max method */
    @Test
    public void testMax() {
        assertEquals(this.kGB1.max("A2"), 100.0, 0);
    }
    
    /** Tests for the currentGrade method */
    @Test
    public void testCurrentGrade() {
        assertEquals(this.kGB1.currentGrade("abetaylor"), 72.5, 0);
    }
    
    /** Tests for the currentGrades method */
    @Test
    public void testCurrentGrades() {
        assertSame(this.kGB1.currentGrades().size(), 17);
    }
    
    /** Tests for the assignmentGrade method */
    @Test
    public void testAssignmentGrade() {
        assertEquals(this.kGB1.assignmentGrade("A2", "abetaylor"), 71.0, 0);
        assertEquals(this.kGB1.assignmentGrade("A2", "abethes"), 90.0, 0);
        assertEquals(this.kGB1.assignmentGrade("A2", "acit"), 79.0, 0);
        assertEquals(this.kGB1.assignmentGrade("A2", "ahrown"), 85.0, 0);
        assertEquals(this.kGB1.assignmentGrade("A2", "amller"), 74.0, 0);
        assertEquals(this.kGB1.assignmentGrade("A2", "are"), 58.0, 0);
    }
    
    /** Tests for the outputCurrentGrades method */
    @Test
    public void testOutputCurrentGrades() {
        assertFalse(this.kGB1.outputCurrentGrades().equals(
                this.kGB0.outputCurrentGrades()));
    }
    
    /** Tests for the outputCurrentGrades method */
    @Test
    public void testOutputAssignmentGrades() {
        assertFalse(this.kGB1.outputAssignmentGrades("A2").equals(
                this.kGB0.outputCurrentGrades()));
    }
    
    /** Tests for the outputCurrentGrades method */
    @Test
    public void testOutputGradebook() {
        assertFalse(this.kGB1.outputGradebook().equals(
                this.kGB0.outputCurrentGrades()));
    }
    
    /** Tests for the outputCurrentGrades method */
    @Test
    public void testOutputStudentGrades() {
        assertFalse(this.kGB1.outputStudentGrades("abetaylor").equals(
                this.kGB0.outputCurrentGrades()));
    }
    
}