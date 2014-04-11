/**
 * 
 */
package org.whiteboard.gradebook;

/** Class representing a Teacher
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014 */
public class Teacher extends User {
    /**
     * Creates a new Teacher with given parameters 
     * @param n The Teacher's name
     * @param i The Teacher's ID number
     * @param pass The Teacher's password
     */
    protected Teacher(String fn, String ln, String i, String pass) {
        this.firstName = fn;
        this.lastName = ln;
        this.id = i;
        this.password = pass;
    }
    
    /**
     * Checks if this User is a Teacher
     * @return true if User is a Teacher, else false
     */
    protected boolean isTeacher() {
        return true;
    }
}
