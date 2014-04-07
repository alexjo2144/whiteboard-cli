/**
 * 
 */
package org.whiteboard.gradebook;

import java.util.Map;

/** Assignment contains information related to a single assignment and
 * methods related to all grades for that assignment.
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014 */
public abstract class Assignment {
    /** String representing the title for this assignment */
    private String name;
    /** String used as a short description of this assignment */
    private String description;
    private String kind;
    private Integer totalPointsPossible;
    
    private Map<Integer, Grade> grades;

    public abstract Grade getGrade(User actor, Integer studentID);
    public abstract Double calculateAverage(User actor);
    public abstract Double calculateMedian(User actor);
    public abstract Double calculateStandardDeviation(User actor);
    
    protected String getName() {
        return this.name;
    }
    
    protected void setName(String n) {
        this.name = n;
    }

    protected String getDescription() {
        return this.description;
    }
    
    protected void setDescription(String d) {
        this.description = d;
    }
    
    protected String getKind() {
        return this.kind;
    }
    
    protected void setKind(String k) {
        this.kind = k;
    }
    
    protected int getTotalPointsPossible() {
        return this.totalPointsPossible;
    }
    
    protected void setTotalPointsPossible(int p) {
        this.totalPointsPossible = p;
    }
}
