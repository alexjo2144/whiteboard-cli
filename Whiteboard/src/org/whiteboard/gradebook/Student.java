/**
 * 
 */
package org.whiteboard.gradebook;

/** Student
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014
 *
 */
public class Student extends User {
    /**
     * Creates a new Student with given parameters
     * @param n the Student's name
     * @param i the Student's ID number
     * @param pass the Student's password
     */
    protected Student(String n, String i, String pass) {
        this.name = n;
        this.id = i;
        this.password = pass;
    }
    
    /**
     * Checks if this User is a Teacher
     * @return true if User is a Teacher, else false
     */
    protected boolean isTeacher() {
        return false;
    }
}
