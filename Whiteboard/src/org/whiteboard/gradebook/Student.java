/**
 * 
 */
package org.whiteboard.gradebook;

/** Student
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014
 *
 */
public abstract class Student extends User {
    public abstract Double calculateCourseGrade(User actor);
}
