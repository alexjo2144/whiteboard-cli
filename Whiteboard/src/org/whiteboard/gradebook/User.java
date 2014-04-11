package org.whiteboard.gradebook;

/** A User of the MyGradebook, either a Student or a Teacher.
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Mar 30, 2014 */
public abstract class User {
    /** The user's first name, as a String */
    protected String firstName;
    /** The User's last name as a String */
    protected String lastName;
    /** The User's id number, much be unique to the user */
    protected String id;
    /** A String representing the User's password, used for logging into the
     * system */
    protected String password;
    
    /** Checks if this User is a Teacher
     * 
     * @return true if User is a Teacher, else false */
    protected abstract boolean isTeacher();
    
    /** Sets this User's name to given String, n
     * 
     * @param n
     *            this User's new name */
    protected void setFirstName(String n) {
        this.firstName = n;
    }
    
    /** Gets this user's name
     * 
     * @return a String, this user's name */
    protected String getFirstName() {
        return firstName;
    }

    /** Gets this User's last name
     * 
     * @return a String, this User's last name */
    protected String getLastName() {
        return this.lastName;
    }
    
    /** Sets this User's last name to given String
     * 
     * @param ln */
    protected void setLastName(String ln) {
        this.lastName = ln;
    }
    
    /** Sets this user's ID number to given int, i
     * 
     * @param i
     *            this user's new ID number */
    protected void setID(String i) {
        this.id = i;
    }
    
    /** Gets this User's ID number
     * 
     * @return an Integer, this user's ID number */
    protected String getID() {
        return id;
    }
    
    /** Sets this user's password to given String, p
     * 
     * @param p
     *            this User's new password */
    protected void setPassword(String p) {
        this.password = p;
    }
    
    /** Gets this User's password
     * 
     * @return a String, this User's password */
    protected String getPassword() {
        return password;
    }
    
    /** Tests if two Users are the same, two Users are the same if they have
     * the same name, ID, and password
     * 
     * @param The
     *            object being compared for equality
     * @return True if the object is equal to this User, else false */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User temp = (User) obj;
            if (this.firstName.equals(temp.getFirstName())
                    && this.lastName.equals(temp.getLastName())
                    && this.id.equals(temp.getID())
                    && this.password.equals(temp.getPassword())
                    && this.isTeacher() == (temp.isTeacher())) {
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
    
    @Override
    public String toString() {
        String ret = "This User is a ";
        if (this.isTeacher()) {
            ret += "Teacher ";
        }
        else {
            ret += "Student ";
        }
        ret +=
                "whose name is " + this.firstName + " " + this.lastName +
                " and ID number is " + this.id;
        return ret;
    }
    
    @Override
    public int hashCode() {
        int ret = 0;
        ret += this.firstName.hashCode() * 173;
        ret += this.id.hashCode() * 787;
        return ret;
    }
    
}
