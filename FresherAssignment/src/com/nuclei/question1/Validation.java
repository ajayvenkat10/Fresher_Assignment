package com.nuclei.question1;

import java.util.Scanner;

/**
 * The type Validation.
 */
public class Validation {
    /**
     * The Br.
     */
    static Scanner br = new Scanner(System.in);
    static boolean INPUT_TYPE_MISMATCH;
    /**
     * Validate name string.
     *
     * @return the string
     */
    public static String validateName() {
        br = new Scanner(System.in);
        String name = br.nextLine();
        while (!name.matches("^[A-Za-z0-9\\s]+$")) {
            try {
                throw new ApplicationException(ExceptionType.INVALID_INPUT);
            } catch (ApplicationException e) {
                e.printEvent("Invalid input! Alphabets and numbers only!");
            }

            Logger.logp("-name: ");
            name = br.nextLine();
        }
        return name;
    }

    /**
     * Validate price double.
     *
     * @return the double
     */
    public static double validatePrice() {
        double price = 0.0;
         INPUT_TYPE_MISMATCH= true;
        while (INPUT_TYPE_MISMATCH) {
            try {
                price = br.nextDouble();
                INPUT_TYPE_MISMATCH = false;
            } catch (Exception e) {
                Logger.log("Invalid input! Numbers only!");
                br.next();
                Logger.logp("-price: ");
            }
        }
        return price;
    }

    /**
     * Validate quantity int.
     *
     * @return the int
     */
    public static int validateQuantity() {
        int quantity = 0;
        INPUT_TYPE_MISMATCH = true;
        while (INPUT_TYPE_MISMATCH) {
            try {
                quantity = br.nextInt();
                INPUT_TYPE_MISMATCH = false;
            } catch (Exception e) {
                ;
                Logger.log("Invalid input! Numbers only!");
                br.next();
                Logger.logp("-quantity: ");
            }
        }
        return quantity;
    }

    /**
     * Validate type int.
     *
     * @return the int
     */
    public static int validateType() {
        int type = 0;
        INPUT_TYPE_MISMATCH = true;
        while (INPUT_TYPE_MISMATCH) {
            try {
                type = br.nextInt();
                INPUT_TYPE_MISMATCH = false;
                if (type > Constants.MAXIMUM_TYPE_VALUE || type < Constants.MINIMUM_TYPE_VALUE) {
                    Logger.log("Invalid option! Please enter a number between 1-3 only!");
                    INPUT_TYPE_MISMATCH = true;
                }

            } catch (Exception e) {
                ;
                Logger.log("Invalid input! Numbers only!");
                br.next();
            }

            if (INPUT_TYPE_MISMATCH) {
                Logger.log("-type: \n1.raw \n2.manufactured \n3.imported ");
                Logger.logp("Enter the type of the item by choosing the number associated with it: ");
            }
        }
        return type;
    }
}
