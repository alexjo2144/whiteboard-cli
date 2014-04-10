package org.whiteboard.gradebook;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/** Assignment contains information related to a single assignment and
 * methods related to all grades for that assignment.
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014 */
public class Assignment {
    
    protected Assignment(String n, String d, String k, double tpp, double w) {
        this.name = n;
        this.description = d;
        this.kind = k;
        this.totalPointsPossible = tpp;
        this.weight = w;
        this.grades = new HashMap<String, Double>();
    }
    
    /////////////////////////////  Constants //////////////////////////////////
    /** String representing the title for this assignment */
    private String name;
    /** String used as a short description of this assignment */
    private String description;
    /** String representing this assignment's type, 
     * eg. test, quiz, homework, etc */
    private String kind;
    /** double representing the total points this assignemt is scored out of */
    private double totalPointsPossible;
    /** A Map that maps a student's ID number to their associated grade */
    private HashMap<String, Double> grades;
    /** an double representing the weighting for this assignment out of 100 
     * an Assignment with a weight of 5 would count as 5% of a total grade */
    private double weight;
    
    /////////////////////Non-trivial methods///////////////////////////////////
    /**
     * Gets the grade for a specific student on this assignment
     * @param student a User representing the Student whose grade is 
     * being retrieved.
     * @return an Double representing the student's score
     * out of this.possiblePoints.
     * @throws a NoSuchElementException if given User, student, does not 
     * have a grade for this assignment.  
     */
    protected Double getGrade(String id) {
        if (grades.containsKey(id)) {
            return grades.get(id);
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
        for(Double i : grades.values()) {
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
        List<Double> sorted = new ArrayList<Double>();
        for(Double i : this.grades.values()) {
            sorted.add(i);
        }
        Collections.sort(sorted);
        int size = sorted.size();
        if(sorted.size() % 2 == 0) {
            return ((sorted.get(size/2) + sorted.get((size/2) - 1)) / 2.0);
        }
        else {
            return sorted.get(size/2) / 1.0;
        }
    }
    
    /**
     * Calculates the lowest score on this assignment
     * @return an Double, the lowest score a student received
     */
    protected Double getMin() {
        double lowest = this.totalPointsPossible;
        for(Double i : grades.values()) {
            if(i < lowest) {
                lowest = i;
            }
        }
        return lowest;
    }
    
    /**
     * Calculates the highest score on this assignment
     * @return an Double, the highest score a student received
     */
    protected Double getMax() {
        double highest = 0;
        for(Double i : grades.values()) {
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
        for(Double i : grades.values()) {
            sum = sum + (assignmentAverage - i);
        }
        return sum / grades.size();
    }
    
    /**
     * Adds a new Student and their grade to this assignment
     * If the student already has a grade, the old one is overridden
     * @param id the User's id whose grade is being added
     * @param score the grade the student received out of totalPossiblePoints
     */
    protected void addGrade(String id, double score) {
        grades.put(id, score);
    }
    
    /**
     * sets given Student's grade for this assignment to given double
     * If the student doesn't have a grade, this one is inserted
     * @param id the User's id whose grade is being added
     * @param score the grade the student received out of totalPossiblePoints
     */
    protected void setGrade(String id, double score) {
        grades.put(id, score);
    }
    
    /**
     * Checks if this Assignment is equal to the given object
     * @param obj The Object equality is being checked against
     * @return true if the given Object is equal to this Assignment,
     * otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Assignment) {
            Assignment temp = (Assignment)obj;
            if(temp.getName().equals(this.name)
                    && temp.getTotalPointsPossible() == this.totalPointsPossible 
                    && temp.getDescription().equals(this.description)
                    && temp.getKind().equals(this.kind)
                    && temp.getAllGrades().equals(this.grades)) {
                return true;
            }
            
            else {
                return false;
            }
        }
        else {
            return false;
        }
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
     * @return a double representing the total points possible for this assignment
     */
    protected double getTotalPointsPossible() {
        return this.totalPointsPossible;
    }
    
    /**
     * Sets the total points possible for this assignment to given double, p.
     * @param d a double representing the new total points for this assignment.
     */
    protected void setTotalPointsPossible(double p) {
        this.totalPointsPossible = p;
    }
    
    /**
     * Gets this Assignment's weight
     * @return an double representing this Assignment's weight out of 100
     */
    protected double getWeight() {
        return this.weight;
    }
    
    /**
     * Sets this Assignment's weight to given double, w
     * @param w the new Weight for this Assignment
     */
    protected void setWeight(double w) {
        this.weight = w;
    }
    
    /**
     * Gets a map representing the grades for all students on this assignment.
     * @return A map from student ID numbers, as an int, to grades, as an int.
     */
    protected HashMap<String, Double> getAllGrades() {
        return this.grades;
    }
}
