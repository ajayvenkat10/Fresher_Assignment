package com.nuclei.question2;

import java.util.*;

/**
 * The type Validation.
 */
public class Validation {
    /**
     * The Br.
     */
    static Scanner br = new Scanner(System.in);

    /**
     * Validate name string.
     *
     * @return the string
     */
    public static String validateFullName() {
        br = new Scanner(System.in);
        String fullName = br.nextLine();
        while (!fullName.matches("^[A-Za-z\\s]+$")) {
            try {
                throw new ApplicationException(ExceptionType.INVALID_INPUT, "Invalid input! Alphabets only!");
            } catch (ApplicationException e) {
                e.printEvent();
            }

            System.out.print("Full Name: ");
            fullName = br.nextLine();
        }
        return fullName;
    }

    /**
     * Validate age double.
     *
     * @return the double
     */
    public static int validateAge() {
        int age = 0;
        boolean flag = true;
        while (flag) {
            try {
                age = br.nextInt();
                flag = false;
            } catch (Exception e) {
                e.printStackTrace();
                Logger.log("Invalid input! Numbers only!");
                br.next();
                System.out.print("Age: ");
            }
        }
        return age;
    }

    /**
     * Validate quantity int.
     *
     * @return the int
     */
    public static String validateAddress() {
        br = new Scanner(System.in);
        String address = br.nextLine();
        return address;
    }

    /**
     * Validate type int.
     *
     * @return the int
     */
    public static int validateRollNumber() {
        int rollNumber = 0;
        ApplicationState state = ApplicationState.getInstance();
        boolean flag = true;
        while (flag) {
            try {
                rollNumber = br.nextInt();
                flag = false;
                if (!state.getMap().containsKey(rollNumber)) {
                    state.addToMap(rollNumber);
                } else {
                    Logger.log("User with this roll number already exists!");
                    Logger.log("Please enter an un registered roll number!");
                    flag = true;
                }

            } catch (Exception e) {
                e.printStackTrace();
                Logger.log("Invalid input! Numbers only!");
                br.next();
            }

            if (flag) {
                System.out.print("Roll Number: ");
            }
        }
        return rollNumber;
    }

    /**
     * Validate courses set.
     *
     * @return the set
     */
    public static Set<Character> validateCourses() {
        Set<Character> coursesSet = new HashSet<Character>();
        for (int i = 1; i <= Constants.MAXIMUM_NUMBER_OF_COURSES; i++) {
            boolean flag = true;
            while (flag) {
                System.out.print("Course " + i + ": ");
                char chosenCourse = br.next().toUpperCase().charAt(0);
                if ((int) chosenCourse >= Constants.ASCII_VALUE_OF_A && (int) chosenCourse <= Constants.ASCII_VALUE_OF_F) {
                    if (!coursesSet.contains(chosenCourse)) {
                        flag = false;
                        coursesSet.add(chosenCourse);
                    } else {
                        Logger.log("Duplicate entry!");
                    }
                } else {
                    Logger.log("Invalid course!");
                    Logger.log("The available courses are: \nA B C D E F");
                }

                if (flag) {
                    Logger.log("Please enter a new course out of the remaining " + (Constants.MAXIMUM_NUMBER_OF_AVAILABLE_COURSES - (i - 1)) + " courses.");
                }
            }

            if (i < Constants.MAXIMUM_NUMBER_OF_COURSES) {
                Logger.log((i + " down, " + (Constants.MAXIMUM_NUMBER_OF_COURSES - i) + " to go."));
            } else {
                Logger.log("Successfully entered all courses!");
            }
        }
        return coursesSet;
    }
}

