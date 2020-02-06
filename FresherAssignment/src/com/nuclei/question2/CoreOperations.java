package com.nuclei.question2;

import java.util.*;

/**
 * The type Core operations.
 */
public class CoreOperations {
    /**
     * The State.
     */
    static ApplicationState state = ApplicationState.getInstance();
    /**
     * The Br.
     */
    static Scanner br = new Scanner(System.in);

    /**
     * Enter details.
     *
     * @param student the student
     */
    public static void enterDetails(StudentInfo student) {
        Logger.log("Enter student details:");
        Logger.logp("Full Name: ");
        student.setFullName(Validation.validateFullName());
        Logger.logp("Age: ");
        student.setAge(Validation.validateAge());
        Logger.logp("Address: ");
        student.setAddress(Validation.validateAddress());
        Logger.logp("Roll Number: ");
        student.setRollNumber(Validation.validateRollNumber());
        Logger.logp("Courses: ");
        Logger.log("The available courses are: \nA B C D E F");
        Logger.log("Please choose 4 out of the given 6: ");
        student.setCourses(Validation.validateCourses());
        state.addToListOfObjects(student);
        state.setIsChanged(true);
    }

    /**
     * Delete details.
     */
    public static void deleteDetails() {
        int rollNumberToDelete;
        Logger.logp("Enter the roll number of the student you want to delete: ");
        rollNumberToDelete = br.nextInt();
        if (state.deleteFromListOfObjects(rollNumberToDelete)) {
            Logger.log("Student deleted.");
        } else {
            Logger.log("Student with the entered roll number does not exist.");
        }
        state.setIsChanged(true);
    }

    /**
     * Display details.
     */
    public static void displayDetails() {
        ArrayList<StudentInfo> students = state.getListOfObjects();
        if (students.size() == 0) {
            Logger.log("Student database is empty!\nNo records to display!");
        } else {
            Collections.sort(students);
            try {
                Logger.log("By default the records are sorted by name.");
                Logger.log("Do you want to sort by another field? (y/n)?: ");
                char option = br.next().toLowerCase().charAt(0);
                if (option == 'y') {
                    Logger.log("SortBy:\n1.Name \n2.Roll Number \n3.Age \n4.Address");
                    Logger.logp("Enter your choice: ");
                    int select = br.nextInt();

                    switch (select) {

                        case 1:
                            Logger.log("Sorted by Name: ");
                            NameComparator nameComparator = new NameComparator();
                            Collections.sort(students, nameComparator);
                            break;

                        case 2:
                            Logger.log("Sorted by Roll Number: ");
                            RollNumberComparator rollNumberComparator = new RollNumberComparator();
                            Collections.sort(students, rollNumberComparator);
                            break;

                        case 3:
                            Logger.log("Sorted by Age: ");
                            AgeComparator ageComparator = new AgeComparator();
                            Collections.sort(students, ageComparator);

                        case 4:
                            Logger.log("Sorted by Address: ");
                            AddressComparator addressComparator = new AddressComparator();
                            Collections.sort(students, addressComparator);

                        default:
                            Utilities.invalidExceptionCall();
                    }
                }
            } catch (InputMismatchException e) {
                Logger.log(e.toString());
            }

            Utilities.displayFormat(students);
        }

    }

    /**
     * Save to disk.
     */
    public static void saveToDisk() {
        ArrayList<StudentInfo> students = state.getListOfObjects();
        FileIO.writeToFile(students);
        Logger.log("Student data successfully saved to disk.");
        state.setIsChanged(false);
    }

    /**
     * On exit.
     */
    public static void onExit() {
        boolean flag = true;
        if(state.getIsChanged()){
            while (flag) {
                Logger.log("Do you want to save the changes before exiting (y/n)? ");
                char choice = br.next().toLowerCase().charAt(0);
                switch (choice) {
                    case 'y':
                        saveToDisk();
                        flag = false;

                    case 'n':
                        System.exit(0);

                    default:
                        Utilities.invalidExceptionCall();
                }
            }
        }
    }
}
