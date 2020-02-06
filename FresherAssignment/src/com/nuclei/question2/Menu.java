package com.nuclei.question2;

import java.util.Scanner;

/**
 * The type Menu.
 */
public class Menu {

    /**
     * Menu.
     */
    public static void menu() {
        ApplicationState state = ApplicationState.getInstance();
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                Logger.log();
                Logger.log();
                Logger.log("Student database");
                Logger.log("1.Add User Details \n2.Display User Details \n3.Delete User Details \n4.Save User Details \n5.Exit");
                Logger.logp("Enter your choice: ");
                choice = input.nextInt();
                Logger.log();
                Logger.log();
                switch (choice) {
                    case 1:
                        StudentInfo student = new StudentInfo();
                        CoreOperations.enterDetails(student);
                        break;

                    case 2:
                        CoreOperations.displayDetails();
                        break;

                    case 3:
                        CoreOperations.deleteDetails();
                        break;

                    case 4:
                        CoreOperations.saveToDisk();
                        break;

                    case 5:
                        CoreOperations.onExit();
                        System.exit(0);
                        break;

                    default:
                        Utilities.invalidExceptionCall();
                }
            } catch (Exception e) {
                ;
            }
        }
    }
}
