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
        this.kGB0 = MyGradeBook.initialize();
        try {
            this.kGB1 = MyGradeBook.initializeWithFile("initial.txt");
        }
        catch (FileNotFoundException e) {
            // The file was not found
            assertTrue(false);
        }
        
        // Assignments
        
        
        // Grades
    }

}