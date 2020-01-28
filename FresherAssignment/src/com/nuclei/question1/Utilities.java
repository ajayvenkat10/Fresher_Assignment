package com.nuclei.question1;

import java.util.Scanner;

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
     * Round off double.
     *
     * @param number the number
     * @return the double
     */
    public static double roundOff(double number) {
        return (Math.round(number * Constants.ROUND_OFF_CONSTANT) / Constants.ROUND_OFF_CONSTANT);
    }


    /**
     * Entry.
     *
     * @param items the items
     */
// Input function
    public static void entry(Item items) {
        Scanner br = new Scanner(System.in);
        Logger.log("Enter the item details: ");
        System.out.print("-name: ");
        items.setName(Validation.validateName());
        System.out.print("-price: ");
        items.setPrice(Validation.validatePrice());
        System.out.print("-quantity: ");
        items.setQuantity(Validation.validateQuantity());
        Logger.log("-type: \n1.raw \n2.manufactured \n3.imported ");
        System.out.print("Enter the type of the item by choosing the number associated with it: ");
        items.setType(Validation.validateType());
        Logger.log("\nItem entry successful!");

    }


    /**
     * Display.
     *
     * @param items the items
     * @param count the count
     */
//Output function
    public static void display(Item items[], int count) {
        for (int j = 0; j <= count; j++) {
            printBorder();
            Logger.log();
            Logger.log("Item Name: " + items[j].getName());
            Logger.log("Item Price: " + items[j].getPrice());
            //Rounding off to two decimal places
            Logger.log("Sales Tax Liability Per Term: " + roundOff(items[j].getTax()));
            Logger.log("Final Price: " + roundOff(items[j].getPrice() + items[j].getTax()));
            printBorder();
            Logger.log();
        }

    }
}
