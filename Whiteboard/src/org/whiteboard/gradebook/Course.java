/**
 * 
 */
package org.whiteboard.gradebook;

import java.util.List;

/** Course contains information related to the users contained within it, as
 * well as methods for modifying fields directly contained within it.
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014 */
public abstract class Course {
    private String name;
    private String description;
    private Integer sectionID;
    
    private List<User> users;
    private List<Assignment> assignments;
    
    public abstract List<Assignment> getAssignments(User actor);
    public abstract Assignment getAssignment(User actor, String name);
    
    public abstract boolean addStudent(User actor, Student student);
    public abstract boolean dropStudent(User actor, Student student);
    
    public abstract boolean addAssignment(User actor, Assignment assignment);
    public abstract boolean dropAssignment(User actor, Assignment assignment);
    
    public abstract User getUser(User actor, Integer id);
}
