package gradebook;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Handles the user interface of the gradebook
 * 
 * @author Patrick Fox fox.pat@husky.neu.edu
 * @version 1.0
 */
public class Console {

    /**
     * The gradebook representing this class
     */
    private MyGradeBook gb;
    /**
     * The scanner used to receive user input
     */
    Scanner s;

    /**
     * Creates a new Console with a scanner but no gradebook(null)
     */
    public Console() {
        s = new Scanner(System.in);
        gb = null;
    }

    /**
     * Runs the program
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        Console c = new Console();
        c.runMain();
    }

    /**
     * Runs the initial prompt for a user
     */
    private void runMain() {
        String[] prompts = {
            "Welcome to the gradebook!",
            "Enter 'quit' at any time without "
                + "the quotes to close the program.",
            "Please enter a file name to import a gradebook from,",
            "Or type 'empty' to create a new one from scratch",
            "Please make a choice and hit enter: " };
        for (String str : prompts) {
            System.out.println(str);
        }
        System.out.println();
        String gbInit = getInput();
        if (gbInit.equalsIgnoreCase("empty")) {
            gb = MyGradeBook.initialize();
            System.out.println("New empty GradeBook created");
        }
        else {
            System.out.println("Initializing from a file...");
            try {
                gb = MyGradeBook.initializeWithFile(gbInit);
            }
            catch (FileNotFoundException e) {
                System.out.println("No such file found."
                    + " Please re-run the program.");
                s.close();
                System.exit(0);
            }
        }
        runOptions();
    }

    /**
     * Runs the secondary list of options to modify a gradebook
     */
    private void runOptions() {
        String[] prompts = { "(1) Add students", "(2) Add assignments",
            "(3) Add a grade", "(4) Change student grades",
            "(5) Calculate statistics for an assignment",
            "(6) Get information for a student",
            "(7) Output entire gradebook to a file",
            "(8) Output Assignment information to a file",
            "(9) Output Student information to a file",
            "(10) Output Grade Information to a file",
            "(11) Print entire gradebook to console",
            "Please make a choice and hit enter: " };

        System.out.println("What would you like to do?");
        for (String str : prompts) {
            System.out.println(str);
        }
        int in = getInputInt(1, 11);
        switch (in) {
            case 1:
                addStudents();
                break;
            case 2:
                addAssignments();
                break;
            case 3:
                addGrade();
                break;
            case 4:
                changeGrade();
                break;
            case 5:
                calcStats();
                break;
            case 6:
                getStudentInfo();
                break;
            case 7:
                outputGradeBook();
                break;
            case 8:
                outputAssignment();
                break;
            case 9:
                outputStudent();
                break;
            case 10:
                outputGrades();
                break;
            case 11:
                printGradeBook();
                break;
            default:
                break;
        }
        System.out.println("Done! Returning to the main menu...\n\n");
        runOptions();
    }

    /**
     * Gets a single line of user input and Closes the program if 'quit' is
     * entered (case insensitive)
     * 
     * @return the next line of input as a string
     */
    private String getInput() {
        String in = s.nextLine();
        if (in.equalsIgnoreCase("quit")) {
            System.out.println("Goodbye.");
            s.close();
            System.exit(0);
        }
        return in;
    }

    /**
     * Gets user input as an int. Re-prompts the user if the input is not an int
     * or is not between min and max
     * 
     * @param min
     *            the minimum value for the input
     * @param max
     *            the maximum value for the input
     * @return the inputed integer
     */
    private int getInputInt(int min, int max) {
        boolean flag = true;
        int in = 0;
        do {
            try {
                String inputString = getInput();
                in = Integer.parseInt(inputString);
                if (in > max || in < min) {
                    System.out.println("Invaid input. Please try again");
                    flag = true;
                }
                else {
                    flag = false;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invaid input. Please try again");
                flag = true;
            }
        }
        while (flag);
        return in;
    }

    /**
     * Prompts the user to input student information and processes it
     */
    private void addStudents() {
        System.out.println("Would you like to: \n"
            + "(1) input Student information manually\n"
            + "(2) Import Student information from a file");
        int in = getInputInt(1, 2);
        if (in == 1) {
            String newStudent = "STUDENT\n";
            System.out.println("Enter the desired Username:");
            newStudent += getInput() + "\n";
            System.out.println("Enter the first name:");
            newStudent += getInput() + "\n";
            System.out.println("Enter the last name:");
            newStudent += getInput() + "\n";
            System.out.println("Enter the advsior's name:");
            newStudent += getInput() + "\n";
            System.out.println("Enter the graduation year:");
            newStudent += getInput() + "\n";
            try {
                gb.processString(newStudent);
            }
            catch (RuntimeException e) {
                System.out.println("Information is not formatted correctly.");
            }
        }
        else {
            System.out.println("Please enter the file name:");
            String inString = getInput();
            try {
                gb.processFile(inString);
            }
            catch (RuntimeException e) {
                System.out.println("Not a valid file name. Please try again.");
            }
        }
    }

    /**
     * Prompts the user to input assignment information and processes it
     */
    private void addAssignments() {
        System.out.println("Would you like to: \n"
            + "(1) input Assignment information manually\n"
            + "(2) Import Assigment information from a file");
        int in = getInputInt(1, 2);
        if (in == 1) {
            String newAssignment = "ASSIGNMENT\n";
            System.out.println("Enter the name of the assignment:");
            newAssignment += getInput() + "\n";
            System.out.println("Enter the total points:");
            newAssignment += getInput() + "\n";
            System.out.println("Enter the percent of the total grade:");
            newAssignment += getInput() + "\n";
            try {
                gb.processString(newAssignment);
            }
            catch (RuntimeException e) {
                System.out.println("Information is not formatted correctly.");
                System.out.println(e.getLocalizedMessage());
            }
        }
        else {
            System.out.println("Please enter the file name:");
            String inString = getInput();
            try {
                gb.processFile(inString);
            }
            catch (RuntimeException e) {
                System.out.println("Not a valid file name. Please try again.");
            }
        }
    }

    /**
     * Prompts the user to input grade information and processes it
     */
    private void addGrade() {
        System.out.println("Would you like to:\n(1) initialize from a file\n"
            + "(2) Enter grades manually for a student\n"
            + "(3) Enter grades manually for an assignment");
        int choice = getInputInt(1, 3);
        if (choice == 1) {
            System.out.println("Please enter the file name:");
            try {
                gb.processFile(getInput());
            }
            catch (RuntimeException e) {
                System.out.println(e.getStackTrace());
                System.out.println(e.getMessage());
                System.out.println("Not a valid file name invalid data. "
                    + "Please try again.");
            }
        }
        else if (choice == 2) {
            String inputString = "GRADES_FOR_STUDENT\n";
            System.out.println("Enter the username:");
            inputString += getInput() + "\n";
            boolean moreAssignments = true;
            while (moreAssignments) {
                System.out.println("Enter an assignment name or 'done':");
                String assName = getInput();
                if (assName.equalsIgnoreCase("done")) {
                    moreAssignments = false;
                }
                else {
                    System.out.println("Enter a grade for that assignment: ");
                    String assScore = getInput();
                    try {
                        assName = assName + "\n";
                        String in = inputString + assName + assScore;
                        System.out.println(in);
                        gb.processString(in);
                    }
                    catch (RuntimeException e) {
                        System.out.println("Invalid input. Try again.");
                    }
                }
            }
        }
        else {
            String inputString = "GRADES_FOR_ASSIGNMENT\n";
            System.out.println("Enter the Assignment name:");
            inputString += getInput() + "\n";
            boolean moreStudents = true;
            while (moreStudents) {
                System.out.println("Enter an Student username or 'done':");
                String studName = getInput();
                if (studName.equalsIgnoreCase("done")) {
                    moreStudents = false;
                }
                else {
                    System.out.println("Enter a grade for that assignment: ");
                    String assScore = getInput();
                    try {
                        studName = studName + "\n";
                        String in = inputString + studName + assScore;
                        System.out.println(in);
                        gb.processString(in);
                    }
                    catch (RuntimeException e) {
                        System.out.println("Invalid input. Try again.");
                    }
                }
            }
        }
    }

    /**
     * Prompts the user to input grade information for one student and
     * assignment and processes it
     */
    private void changeGrade() {
        boolean flag = false;
        do {
            System.out.println("Please enter the student's username:");
            String stud = getInput();
            System.out.println("Please enter the assignment name:");
            String ass = getInput();
            double newGrade = 0.0;
            System.out.println("Please enter the new grade:");
            try {
                newGrade = Double.parseDouble(getInput());
                gb.changeGrade(ass, stud, newGrade);
                flag = false;
            }
            catch (NumberFormatException e) {
                System.out.println("The grade was not a valid decimal");
                flag = true;
            }
            catch (NoSuchElementException e) {
                System.out.println("Invalid student or assignment name");
                flag = true;
            }
        }
        while (flag);
    }

    /**
     * Prompts the user for an assignment, calculates common stats and prints
     * them out
     */
    private void calcStats() {
        System.out.println("Which assignment would you like to know about?");
        boolean flag = false;
        do {
            String assName = getInput();
            double average;
            double median;
            double max;
            double min;
            try {
                min = gb.min(assName);
                max = gb.max(assName);
                average = gb.average(assName);
                median = gb.median(assName);
                System.out.println("Here are the stats for " + assName);
                System.out.println("Mean: " + average);
                System.out.println("Median: " + median);
                System.out.println("Min: " + min);
                System.out.println("Max: " + max);
                flag = false;
            }
            catch (NoSuchElementException e) {
                System.out
                    .println("Not a valid assignment name. Please try again.");
                flag = true;
            }
        }
        while (flag);
    }

    /**
     * Prompts for a student name and outputs that student's information
     */
    private void getStudentInfo() {
        System.out.println("Please enter the student's username: ");
        boolean flag = false;
        String name;
        do {
            name = getInput();
            try {
                System.out.println(gb.outputStudentGrades(name));
                flag = false;
            }
            catch (NoSuchElementException e) {
                System.out.println("Not a valid name. Please try again.");
                flag = true;
            }
        }
        while (flag);
    }

    /**
     * Writes content to a file
     * 
     * @param content
     *            what is to be written
     * @param fileName
     *            the file name to be written to
     */
    private void writeToFile(String content, String fileName) {
        File f = new File(fileName);
        PrintStream ps = null;
        try {
            ps = new PrintStream(f);
            ps.println(content);
        }
        catch (FileNotFoundException e) {
            System.out.println("Error in creating the file");
        }
        finally {
            if (ps != null) {
                ps.close();
            }
        }

    }

    /**
     * Prompts the user to enter a filename and saves current grade information
     * to that file.
     */
    private void outputGrades() {
        System.out.println("What would you like the file to be called? "
            + "(no .txt suffix)");
        String name = getInput() + ".txt";
        String str = gb.outputCurrentGrades();
        writeToFile(str, name);
    }

    /**
     * Prompts the user to enter a student name and filename, then prints the
     * student's information to the file
     */
    private void outputStudent() {
        boolean flag = false;
        do {
            System.out.println("What is the student's name?");
            String name = getInput();
            System.out.println("What would you like the student's "
                + "file to be called? (no .txt suffix)");
            String fileName = getInput() + ".txt";
            String str;
            try {
                str = gb.outputStudentGrades(name);
                writeToFile(str, fileName);
                flag = false;
            }
            catch (NoSuchElementException e) {
                System.out.println("Not a valid student name. "
                    + "Please try again.");
                flag = true;

            }
        }
        while (flag);
    }

    /**
     * Prompts the user for a filename, then writes the entire
     *  gradebook to that
     * file
     */
    private void outputGradeBook() {
        System.out.println("What would you like the file to be called?"
            + " (no .txt suffix)");
        String name = getInput() + ".txt";
        String str = gb.outputGradebook();
        writeToFile(str, name);
    }

    /**
     * Prompts the user for a filename and an assignment Writes information
     * about the assignment to the file
     */
    private void outputAssignment() {
        boolean flag = false;
        do {
            System.out.println("Which assignment are you outputting?");
            String ass = getInput();
            System.out.println("What would you like the assignment "
                + "file to be called? (no .txt suffix)");
            String name = getInput() + ".txt";
            try {
                String str = gb.outputAssignmentGrades(ass);
                writeToFile(str, name);
                flag = false;
            }
            catch (NoSuchElementException e) {
                System.out.println("No such file found.");
                flag = true;
            }
        }
        while (flag);
    }

    /**
     * Prints out the entire gradebook to the console
     */
    private void printGradeBook() {
        String str = gb.outputGradebook();
        System.out.println(str);
    }
}