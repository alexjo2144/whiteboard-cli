/**
 * 
 */
package org.whiteboard.gradebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** Course contains information related to the users contained within it, as
 * well as methods for modifying fields directly contained within it.
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014 */
public class MyGradeBook {
    private String name;
    private String description;
    private Integer sectionID;
    
    private Map<String, Student> students;
    private Map<String, Assignment> assignments;
    
    private MyGradeBook() {
        students = new HashMap<String, Student>();
        name = "";
        description = "";
        sectionID = 0;
    }
    
    /** Get a list of all assignments stored in MyGradeBook
     * 
     * @return a list of all assignments in MyGradeBook */
    protected Map<String, Assignment> getAssignments() {
        return assignments;
    }
    
    /** Get an Assignment object by its name in string form.
     * Case-insensitive.
     * 
     * @param name
     *            the name of the assignment.
     * @return the resulting assignment, or throws a NoSuchElementException
     *         if the assignment does not exist. */
    protected Assignment getAssignment(String name) {
        for (Assignment a : assignments) {
            if (a.getName().toLowerCase().equals(name.toLowerCase())) {
                return a;
            }
        }
        throw new NoSuchElementException(
                "No assignment defined for that name");
    }
    
    protected boolean addStudent(Student student) {
        return students.add(student);
    }
    
    protected boolean dropStudent(Student student) {
        return students.remove(student);
    }
    
    protected boolean addAssignment(Assignment assignment) {
        return assignments.add(assignment);
    }
    
    protected boolean dropAssignment(Assignment assignment) {
        return assignments.remove(assignment);
    }
    
    protected Student getStudent(String id) {
        return students.get(id);
    }
    
    /** Factory method to construct an empty MyGradebook
     * 
     * @return an empty MyGradeBook */
    public static MyGradeBook initialize() {
        return new MyGradeBook();
    }
    
    /** Factory method to construct a MyGradebook that contains the grade
     * book from filename
     * 
     * @param filename
     *            the filename for the file that contains the initial grade
     *            book, which is formatted like initial.txt
     * @return a MyGradebook that contains the grade book from filename
     * @throws FileNotFoundException */
    public static MyGradeBook initializeWithFile(String filename)
            throws FileNotFoundException {
        MyGradeBook defaultBook = MyGradeBook.initialize();
        
        File f = new File(filename);
        Scanner s = new Scanner(f);
        // Get header
        if (s.hasNextLine() && s.nextLine().equals("GRADEBOOK")) {
            
        } else {
            throw new RuntimeException("Not a valid gradebook file.");
        }
        boolean assignmentSection = true;
        while (s.hasNextLine() && assignmentSection) {
            if ()
        }
        while (s.hasNextLine()) {
            String currentLine = s.nextLine();
            String[] values = currentLine.split("\t");
            for (int i = 0; i < values.length; i++) {
                // ID
                values[i] 
                        
            }
            
            System.out.print(currentLine);
            System.out.println("kay ");
        }
        
        return defaultBook;
    }
    
    /** Factory method to construct a MyGradebook that contains the grade
     * book from startingString
     * 
     * @param startingString
     *            String that contains the initial grade book, which is
     *            formatted like initial.txt
     * @return a MyGradebook that contains the grade book from
     *         startingString */
    public static MyGradeBook initializeWithString(String startingString) {
        
    }
    
    /** Parses header and returns the rest of the string minus the header.
     * 
     * @param string
     * @return */
    private String parseHeader(String string) {
        
    }
    
    /** Add to the state of this grade book---new assignments, new students,
     * new grades---by processing filename
     * 
     * @param filename
     *            the filename for a file that contains information that
     *            will be added to the grade book. The file could contain
     *            several different types of information---new assignments,
     *            new students, new grades. The file will be formatted like
     *            addAssignments.txt, addStudents.txt,
     *            gradesForAssignment1.txt, and gradesForStudent.txt. */
    public void processFile(String filename) {
        
    }
    
    /** Add to the state of this grade book---new assignments, new students,
     * new grades---by processing additionalString
     * 
     * @param additionalString
     *            String that contains information that will be added to the
     *            grade book. The String could contain several different
     *            types of information---new assignments, new students, new
     *            grades. The String will be formatted like
     *            addAssignments.txt, addStudents.txt,
     *            gradesForAssignment1.txt, and gradesForStudent.txt. */
    public void processString(String additionalString) {
        
    }
    
    /** Changes the assignment (named assignmentName) grade for student
     * (whose username is equal to username) to newGrade
     * 
     * @param assignmentName
     *            name of the assignment
     * @param username
     *            username for the student
     * @param newGrade
     *            the new grade for the given assignment and student
     * @return whether there was a grade to change. Returns true if the
     *         given assignment/student combination exists, returns false
     *         otherwise */
    public boolean changeGrade(String assignmentName, String username,
            double newGrade) {
        if (assignments.containsKey(assignmentName)) {
            assignments.get(assignmentName).setGrade(username, newGrade);
            return true;
        }
        else {
            throw new NoSuchElementException("Assignment name not defined");
        }
    }
    
    /** Calculates the average across all students for a given assignment
     * 
     * @param assignmentName
     *            name of the assignment
     * @return the average across all students for assignmentName */
    public double average(String assignmentName) {
        return getAssignment(assignmentName).calculateAverage();
    }
    
    /** Calculates the median across all students for a given assignment
     * 
     * @param assignmentName
     *            name of the assignment
     * @return the median across all students for assignmentName */
    public double median(String assignmentName) {
        return getAssignment(assignmentName).calculateMedian();
    }
    
    /** Calculates the min across all students for a given assignment
     * 
     * @param assignmentName
     *            name of the assignment
     * @return the min across all students for assignmentName */
    public double min(String assignmentName) {
        return getAssignment(assignmentName).getMin();
    }
    
    /** Calculates the max across all students for a given assignment
     * 
     * @param assignmentName
     *            name of the assignment
     * @return the max across all students for assignmentName */
    public double max(String assignmentName) {
        return getAssignment(assignmentName).getMax();
    }
    
    /** Calculates the current grade for the given student
     * 
     * @param username
     *            username for the student
     * @return the current grade for student with username. The current
     *         grade is calculated based on the current assignment grades,
     *         assignment total points, assignment percent of semester. The
     *         current grade for a student is the sum of the relative
     *         assignment grades divided by the current percent of semester
     *         time 100. Since all grades may not currently be entered, we
     *         have to divide by the current percent. The relative
     *         assignment grade is the student's assignment grade divide by
     *         total point value for the assignment times the percent of
     *         semester. */
    public double currentGrade(String username) {
        return students.get(username).calculateCourseGrade();
    }
    
    /** Calculates the current grade for all students
     * 
     * @return HashMap of the current grades for all students. The key of
     *         the HashMap is the username of the student. The value is the
     *         current grade for the associated student. The current grade
     *         is calculated based on the current assignment grades,
     *         assignment total points, assignment percent of semester. The
     *         current grade for a student is the sum of the relative
     *         assignment grades divided by the current percent of semester
     *         time 100. Since all grades may not currently be entered, we
     *         have to divide by the current percent. The relative
     *         assignment grade is the student's assignment grade divide by
     *         total point value for the assignment times the percent of
     *         semester. */
    public HashMap<String, Double> currentGrades() {
        HashMap<String, Double> currentGrades = new HashMap<String, Double>();
        for (String studentID : students.keySet()) {
            currentGrades.put(studentID, students.get(studentID).calculateCourseGrade());
        }
        return currentGrades;
    }
    
    /** Provides the grade earned by the given student for the given
     * assignment
     * 
     * @param assignmentName
     *            name of the assignment
     * @param username
     *            username for the student
     * @return the grade earned by username for assignmentName */
    public double assignmentGrade(String assignmentName, String username) {
        return assignments.get(username).getGrade(username);
    }
    
    /** Provide a String that contains the current grades of all students in
     * the course
     * 
     * @return a String that contains the current grades of all students in
     *         the course. The String should be formatted like
     *         currentGrades.txt---CURRENT_GRADES heading and each row:
     *         username followed by tab and current grade. The usernames
     *         will be listed alphabetically. */
    public String outputCurrentGrades() {
        
    }
    
    /** Provide a String that contains the current grades of the given
     * student
     * 
     * @param username
     *            username for student
     * @return a String that contains the current grades of username. The
     *         String should be formatted like
     *         studentGrades.txt---STUDENT_GRADES heading, student info,
     *         dividers, each assignment (assignment name followed by tab
     *         and assignment grade), and current grade. Assignments are to
     *         remain in the same order as given. */
    public String outputStudentGrades(String username) {
        
    }
    
    /** Provide a String that contains the assignment grades of all students
     * in the course for the given assignment
     * 
     * @param assignName
     *            name of the assignment
     * @return a String that contains the assignment grades of all students
     *         in the course for assignName. The String should be formatted
     *         like assignmentGrade.txt---ASSIGNMENT_GRADES heading,
     *         assignment info, dividers, each student (username followed by
     *         tab and assignment grade), and assignment stats. The
     *         usernames will be listed alphabetically while assignments are
     *         to remain in the same order as given. */
    public String outputAssignmentGrades(String assignName) {
        
    }
    
    /** Provide a String that contains the current grade book. This String
     * could be used to initialize a new grade book.
     * 
     * @return a String that contains the current grade book. This String
     *         could be used to initialize a new grade book. The String
     *         should be formatted like gradebook.txt. The usernames will be
     *         listed alphabetically. */
    public String outputGradebook() {
        
    }
}
