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
    private String name;
    private String description;
    private String kind;
    private Integer totalPointsPossible;
    
    private Map<Integer, Grade> grades;

    public abstract Grade getGrade(User actor, Integer studentID);
    public abstract Double calculateAverage(User actor);
    public abstract Double calculateMedian(User actor);
    public abstract Double calculateStandardDeviation(User actor);
}
