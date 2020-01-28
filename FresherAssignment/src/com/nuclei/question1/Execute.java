package com.nuclei.question1;

import java.util.Scanner;

import static com.nuclei.question1.BusinessLogic.calculateTax;

/**
 * The type Execute.
 */
public class Execute {

    private int count;

    /**
     * Run app.
     */
    public static void runApp() {
        ApplicationState state = ApplicationState.getInstance();
        Scanner input = new Scanner(System.in);
        Item items[] = new Item[Constants.MAXIMUM_RECORDS_LIMIT];
        char choice = 'y';

        do {
            switch (choice) {
                case 'y':
                    items[state.getCount()] = new Item();
                    Utilities.entry(items[state.getCount()]);            //Call to enter details
                    calculateTax(items[state.getCount()]);     //Call to calculate tax
                    Utilities.display(items, state.getCount());          //Call to display inventory
                    state.incrementCount();
                    break;

                case 'n':
                    System.exit(0);

                default:
                    try {
                        throw new ApplicationException(ExceptionType.INVALID_INPUT);
                    } catch (ApplicationException e) {
                        e.printStackTrace();
                        e.printEvent("Invalid option! Please enter one of the right options");
                    }
            }
            System.out.print("\nDo you want to enter details of any other item(y/n): ");
            choice = input.next().charAt(0);

        } while (true);
    }

}
