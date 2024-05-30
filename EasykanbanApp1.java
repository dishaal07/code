/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.easykanbanapp1;

import com.mycompany.easykanbanapp1.TaskClass.Task;
import javax.swing.JOptionPane;

/**
 *
 * @author disha
 */
public class EasykanbanApp1 {


    


public class EasyKanbanApp {

    public static void main(String[] args) {
        // Variable declarations
        String userName;
        String password;
        String firstName;
        String lastName;
        
        // Getting user input for username, password, first name, and last name
        userName = JOptionPane.showInputDialog("Please Enter Your Username");
        password = JOptionPane.showInputDialog("Please Enter Your Password");
        firstName = JOptionPane.showInputDialog("Please Enter Your First Name");
        lastName = JOptionPane.showInputDialog("Please Enter Your Last Name");

        // Checking if username format is correct
        if (isValidUsername(userName)) {
            JOptionPane.showMessageDialog(null, "Username Successfully Captured");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        }

        // Checking if password format is correct
        if (isValidPassword(password)) {
            JOptionPane.showMessageDialog(null, "Password Successfully Captured");
        } else {
            JOptionPane.showMessageDialog(null, "Password not correctly formatted, please ensure that password contains at least 8 characters, a capital letter, a number, and a special character");
        }
    }

    // Method to check if username is valid
    private static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    // Method to check if password is valid
    private static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()].*");
        return hasUppercase && hasNumber && hasSpecialChar;
    }
}



    // Static variables to keep track of total duration and task number
    public static int totalDuration = 0;
    public static int taskNumber = 0;

    public static void main(String[] args) {
        // Welcome message
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Getting number of tasks
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks"));

        OUTER:
        while (true) {
            String[] options = {"Add tasks", "Show report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option", "EasyKanban", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0:
                    // Adding tasks
                    for (int i = 0; i < numTasks; i++) {
                        addTask();
                    }
                    break;
                case 1:
                    // Showing report (coming soon)
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case 2:
                    // Quit
                    break OUTER;
                default:
                    break;
            }
        }

        // Displaying total duration
        JOptionPane.showMessageDialog(null, "Total task duration: " + totalDuration + " hours");
    }

   private static void addTask() {
    // Getting task details
    String taskName = JOptionPane.showInputDialog("Enter task name");
    String taskDescription = JOptionPane.showInputDialog("Enter task description");
    if (taskDescription.length() > 50) {
        JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
        return;
    }
    String developerDetails = JOptionPane.showInputDialog("Enter developer details");
    int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration"));
    String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose task status", "Task Status", JOptionPane.DEFAULT_OPTION, null, new String[]{"To Do", "Done", "Doing"}, "To Do");

    // Creating Task object
    Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);  

    // Increment task number and total duration
    taskNumber++;
    totalDuration += taskDuration;

    // Displaying task details
    JOptionPane.showMessageDialog(null, "Task Status: " + task.getTaskStatus() + "\n" +
            "Developer Details: " + task.getDeveloperDetails() + "\n" +
            "Task Number: " + taskNumber + "\n" +
            "Task Name: " + task.getTaskName() + "\n" +
            "Task Description: " + task.getTaskDescription() + "\n" +
            "Task ID: " + task.getTaskID() + "\n" +
            "Duration: " + task.getTaskDuration() + " hours");
}
}