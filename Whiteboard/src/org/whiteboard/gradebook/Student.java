/**
 * 
 */
package org.whiteboard.gradebook;

/** Class representing a Student
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014 */
public class Student extends User {
    /** Graduation year of the student */
    protected String graduationYear;
    
    /** Creates a new Student with given parameters
     * 
     * @param n the Student's name
     * @param i the Student's ID number
     * @param pass the Student's password */
    protected Student(String fn, String mn, String ln, String i, String grad,
            String pass) {
        this.firstName = fn;
        this.middleName = mn;
        this.lastName = ln;
        this.id = i;
        this.graduationYear = grad;
        this.password = pass;
    }
    
    /** Checks if this User is a Teacher
     * 
     * @return true if User is a Teacher, else false */
    protected boolean isTeacher() {
        return false;
    }
    
    /** Get the User's graduation year
     * 
     * @return a String, representing */
    protected String getGraduationYear() {
        return graduationYear;
    }
    
    /** Set the student's graduation year with a String (e.g. "2017")
     * 
     * @param gradYear
     *            the year to set graduation year to */
    protected void setGraduationYear(String grad) {
        graduationYear = grad;
    }
}
