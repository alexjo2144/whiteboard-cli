package org.whiteboard.gradebook;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.File;
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
                "Enter 'quit' at any time without the quotes to close the program.",
                "Please enter a file name to import a gradebook from,",
                "Or type 'empty' to create a new one from scratch",
                "Please make a choice and hit enter: " };
        for (String s : prompts) {
            System.out.println(s);
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
                "(3) Add a grade for an assignment",
                "(4) Change student grades",
                "(5) Calculate statistics for an assignment",
                "(6) Get information for a student",
                "(7) Output entire gradebook to a file",
                "(8) Output Assignment information to a file",
                "(9) Output Student information to a file",
                "(10) Output Grade Information to a file",
                "(11) Print entire gradebook to console",
                "Please make a choice and hit enter: " };

        System.out.println("What would you like to do?");
        for (String s : prompts) {
            System.out.println(s);
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
            outputAss();
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
     * Tell the gradebook to add a grade, assignment, or student
     * 
     * @param classification
     *            either "Grade", "Assignment", or "Student"
     */
    private void add(String classification) {
        System.out.println("Would you like to: \n" + "(1) input "
                + classification + " information manually\n" + "(2) Import "
                + classification + " information from a file");
        int in = getInputInt(1, 2);
        if (in == 1) {
            System.out.println("Please enter the " + classification
                    + " information: ");
            String input = "";
            while(s.hasNextLine()) {
                input += s.nextLine() + "\t";
            }
            try {
                gb.processString(input);
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
     * Prompts the user to input student information and processes it
     */
    private void addStudents() {
        add("Student");
    }

    /**
     * Prompts the user to input assignment information and processes it
     */
    private void addAssignments() {
        add("Assignment");
    }

    /**
     * Prompts the user to input grade information and processes it
     */
    private void addGrade() {
        add("Grade");
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
            System.out
                    .println("Please enter the new grade, formatted as a decimal(ie 50.0): ");
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

    private void calcStats() {
        System.out.println("Which assignment would you like to know about?");
        boolean flag = false;
        do {
            String assName = getInput();
            double average, median, min, max;
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
                System.out.println("Not a valid file name.");
                flag = true;
            }
        }
        while (flag);
    }

    private void getStudentInfo() {
        System.out.println("Please enter the student's username: ");
        String name = getInput();
        try {
            System.out.println(gb.outputStudentGrades(name));
        }
        catch (NoSuchElementException e) {
            System.out.println("Not a valid name");
        }
    }

    private void writeToFile(String content, String fileName) {
        File f = new File(fileName);
        try {
            PrintStream ps = new PrintStream(f);
            ps.println(content);
            ps.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error in creating the file");
        }

    }

    private void outputGrades() {
        System.out
                .println("What would you like the file to be called? (no .txt suffix)");
        String name = getInput() + ".txt";
        String str = gb.outputCurrentGrades();
        writeToFile(str, name);
    }

    private void outputStudent() {
        System.out.println("What is the student's name?");
        String name = getInput() + ".txt";
        System.out.println("What would you like the student's "
                + "file to be called? (no .txt suffix)");
        String fileName = getInput() + ".txt";
        String str;
        str = gb.outputStudentGrades(name);
        writeToFile(str, fileName);
    }

    private void outputGradeBook() {
        System.out
                .println("What would you like the file to be called? (no .txt suffix)");
        String name = getInput() + ".txt";
        String str = gb.outputGradebook();
        writeToFile(str, name);
    }

    private void outputAss() {
        System.out
                .println("What would you like the assignment file to be called? (no .txt suffix)");
        String name = getInput() + ".txt";
        String str = gb.outputAssignmentGrades(name);
        writeToFile(str, name);
    }
    private void printGradeBook() {
        String str = gb.outputGradebook();
        System.out.println(str);
    }
}
