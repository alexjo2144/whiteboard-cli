/**
 * 
 */
package org.whiteboard.gradebook;

/** Teacher
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
    protected Teacher(String fn, String mn, String ln, String i, String pass) {
        this.firstName = fn;
        this.middleName = mn;
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
