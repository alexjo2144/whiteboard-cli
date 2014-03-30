/**
 * 
 */
package org.whiteboard.gradebook;

/** User
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014 */
public abstract class User {
    private String name;
    private Integer id;
    private String password;
    
    protected abstract String getName();
    
    protected abstract Integer getID();
}
