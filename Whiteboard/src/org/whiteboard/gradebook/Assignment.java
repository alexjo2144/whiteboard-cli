/**
 * 
 */
package org.whiteboard.gradebook;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/** Assignment contains information related to a single assignment and
 * methods related to all grades for that assignment.
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014 */
public abstract class Assignment {
    /////////////////////////////  Constants //////////////////////////////////
    /** String representing the title for this assignment */
    private String name;
    /** String used as a short description of this assignment */
    private String description;
    /** String representing this assignment's type, 
     * eg. test, quiz, homework, etc */
    private String kind;
    /** int representing the total points this assignemt is scored out of */
    private int totalPointsPossible;
    /** A Map that maps a student's ID number to their associated grade */
    private HashMap<Integer, Integer> grades;

    /////////////////////Non-trivial methods///////////////////////////////////
    /**
     * Gets the grade for a specific student on this assignment
     * @param actor a User representing the Student whose grade is 
     * being retrieved.
     * @return an Integer representing the actor's score
     * out of this.possiblePoints.
     * @throws a NoSuchElementException if given User, actor, does not 
     * have a grade for this assignment.  
     */
    protected Integer getGrade(User actor) {
        if (grades.containsKey(actor.getID())) {
            return grades.get(actor.getID());
        }
        else {
            throw new NoSuchElementException();
        }
    }
    
    
    /**
     * Calculates the mean grade for this assignment.
     * @return a Double representing the mean grade out of this.possiblePoints
     */
    protected Double calculateAverage() {
        double count = 0;
        double sum = 0;
        for(Integer i : grades.values()) {
            count++;
            sum+=i;
        }
        return sum / count; 
    }
    
    /**
     * Calculates the median grade for this assignment
     * @return a Double representing the median grade
     */
    protected Double calculateMedian() {
        List<Integer> sorted = (List<Integer>)grades.values();
        Collections.sort(sorted);
        int size = sorted.size();
        if(sorted.size() % 2 == 0) {
            return (sorted.get(size/2) + sorted.get(1 + size/2) / 2.0);
        }
        else {
            return sorted.get(size/2) / 1.0;
        }
    }
    
    /**
     * Calculates the lowest score on this assignment
     * @return an Integer, the lowest score a student received
     */
    protected Integer getMin() {
        int lowest = this.totalPointsPossible;
        for(Integer i : grades.values()) {
            if(i < lowest) {
                lowest = i;
            }
        }
        return lowest;
    }
    
    /**
     * Calculates the highest score on this assignment
     * @return an Integer, the highest score a student received
     */
    protected Integer getMax() {
        int highest = 0;
        for(Integer i : grades.values()) {
            if(i > highest) {
                highest = i;
            }
        }
        return highest;
    }
    
    /**
     * Calculates the Standard Deviation on this assignment
     * @return a Double representing the SD
     */
    protected Double calculateStandardDeviation() {
        Double assignmentAverage = this.calculateAverage();
        double sum = 0;
        for(Integer i : grades.values()) {
            sum = sum + (assignmentAverage - i);
        }
        return sum / grades.size();
    }
    
    ////////////////////Setters and Getters////////////////////////////////////
    /**
     * Gets the name of this assignment
     * @return A String representing the name of this assignment
     */
    protected String getName() {
        return this.name;
    }
    
    /**
     * Sets the name of this assignment to the given String, n.
     * @param n a String containing the new name for this assignment
     */
    protected void setName(String n) {
        this.name = n;
    }

    /**
     * Gets a short description of this assignment
     * @return a String description of this assignment
     */
    protected String getDescription() {
        return this.description;
    }
    
    /**
     * Sets the description of this assignment to given String, d.
     * @param d a String containing the new description for this assignment.
     */
    protected void setDescription(String d) {
        this.description = d;
    }
    
    /**
     * Gets the kind for this assignment, eg. test, quiz, homework, etc.
     * @return a String containing this assignment's type.
     */
    protected String getKind() {
        return this.kind;
    }
    
    /**
     * Sets the Kind of this assignment to given String, k.
     * @param d a String containing the new type for this assignment.
     */
    protected void setKind(String k) {
        this.kind = k;
    }
    
    /**
     * Gets the total number of points for this assignment.
     * @return a int representing the total points possible for this assignment
     */
    protected int getTotalPointsPossible() {
        return this.totalPointsPossible;
    }
    
    /**
     * Sets the total points possible for this assignment to given int, p.
     * @param d an int representing the new total points for this assignment.
     */
    protected void setTotalPointsPossible(int p) {
        this.totalPointsPossible = p;
    }
    
    /**
     * Gets a map representing the grades for all students on this assignment.
     * @return A map from student ID numbers, as an int, to grades, as an int.
     */
    protected Map<Integer, Integer> getAllGrades() {
        return this.grades;
    }
}
