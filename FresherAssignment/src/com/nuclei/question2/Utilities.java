package com.nuclei.question2;

import java.util.ArrayList;
import java.util.Set;

/**
 * The type Utilities.
 */
public class Utilities {
    /**
     * Print border.
     */
    public static void printBorder() {
        for (int i = 0; i < Constants.BORDER_LENGTH; i++)
            System.out.print("_");
    }

    /**
     * Convert set to string string.
     *
     * @param courses the courses
     * @return the string
     */
    public static String convertSetToString(Set<Character> courses) {
        String coursesString = "";
        for (Character course : courses)
            coursesString += (course + ",");
        coursesString = coursesString.substring(0, coursesString.length() - 1);
        return coursesString;
    }

    /**
     * Display format.
     *
     * @param students the students
     */
    public static void displayFormat(ArrayList<StudentInfo> students) {
        printBorder();
        Logger.log();
        System.out.format("%30s%20s%10s%70s%30s\n", "Name", "Roll Number", "Age", "Address", "Courses");
        Utilities.printBorder();
        Logger.log();

        for (StudentInfo student : students) {
            System.out.format("%30s%20d%10d%70s%30s\n", student.getFullName(), student.getRollNumber(), student.getAge(), student.getAddress(), student.getCourses());
        }
    }

    /**
     * Invalid exception call.
     */
    public static void invalidExceptionCall() {
        try {
            throw new ApplicationException(ExceptionType.INVALID_INPUT, Constants.INVALID_EXCEPTION_MESSAGE);
        } catch (ApplicationException e) {
            e.printEvent();
        }
    }
}
