package com.nuclei.question3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The type Inputs.
 */
public class Inputs {

    /**
     * The Id mismatch.
     */
    static boolean ID_MISMATCH;
    /**
     * The Input.
     */
    static Scanner input = new Scanner(System.in);

    /**
     * Enter id int.
     *
     * @return the int
     */
    public static int enterID() {
        int id = 0;
        ID_MISMATCH = true;
        while (ID_MISMATCH) {
            Logger.logp("Enter node ID: ");
            try {
                id = input.nextInt();
                ID_MISMATCH = false;
            } catch (InputMismatchException e) {
                Logger.log("Entered ID value is not a number! Please enter a number!");
                input.next();
            }
        }
        return id;
    }

    /**
     * Enter id int.
     *
     * @param dependencyType the dependency type
     * @return the int
     */
    public static int enterID(String dependencyType) {
        int id = 0;
        ID_MISMATCH = true;
        while (ID_MISMATCH) {
            Logger.logp("Enter " + dependencyType + " node ID: ");
            try {
                id = input.nextInt();
                ID_MISMATCH = false;
            } catch (InputMismatchException e) {
                Logger.log("Entered ID value is not a number! Please enter a number!");
                input.next();
            }
        }
        return id;
    }

}
