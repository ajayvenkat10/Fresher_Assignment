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
                e.printStackTrace();
                e.printEvent("Invalid input! Alphabets and numbers only!");
            }

            System.out.print("-name: ");
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
        boolean flag = true;
        while (flag) {
            try {
                price = br.nextDouble();
                flag = false;
            } catch (Exception e) {
                e.printStackTrace();
                Logger.log("Invalid input! Numbers only!");
                br.next();
                System.out.print("-price: ");
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
        boolean flag = true;
        while (flag) {
            try {
                quantity = br.nextInt();
                flag = false;
            } catch (Exception e) {
                e.printStackTrace();
                Logger.log("Invalid input! Numbers only!");
                br.next();
                System.out.print("-quantity: ");
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
        boolean flag = true;
        while (flag) {
            try {
                type = br.nextInt();
                flag = false;
                if (type > Constants.MAXIMUM_TYPE_VALUE || type < Constants.MINIMUM_TYPE_VALUE) {
                    Logger.log("Invalid option! Please enter a number between 1-3 only!");
                    flag = true;
                }

            } catch (Exception e) {
                e.printStackTrace();
                Logger.log("Invalid input! Numbers only!");
                br.next();
            }

            if (flag) {
                Logger.log("-type: \n1.raw \n2.manufactured \n3.imported ");
                System.out.print("Enter the type of the item by choosing the number associated with it: ");
            }
        }
        return type;
    }
}
