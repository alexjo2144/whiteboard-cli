/**
 * 
 */
package org.whiteboard.gradebook;

/** Grade contains information related to a single student's grade on an
 * assignment
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014 */
public abstract class Grade {
    private Double points;
    private String description;
    
    public abstract Double getPoints(User actor);
    
    public abstract boolean setPoints(User actor, Double points);
    
    public abstract String getDescription(User actor);
    
    public abstract boolean setDescription(User actor, String description);
}
