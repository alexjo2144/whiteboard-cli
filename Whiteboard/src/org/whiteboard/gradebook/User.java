/**
 * 
 */
package org.whiteboard.gradebook;

/** User
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014 */
public abstract class User {
    private String firstName;
    private String middleName;
    private String lastName;
    private String id;
    private String password;
    
    protected abstract String getName();
    
    protected abstract String getID();
}
