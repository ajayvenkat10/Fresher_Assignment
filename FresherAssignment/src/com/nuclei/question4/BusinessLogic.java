package com.nuclei.question4;

public class BusinessLogic {

    // Function to calculate tax according to specified instructions

    /**
     * Calculate surcharge double.
     *
     * @param itemCost    the item cost
     * @param import_duty the import duty
     * @return the double
     */
    public static double calculateSurcharge(double itemCost, double import_duty) {
        double finalCost = itemCost + import_duty;
        double surcharge;
        if (finalCost <= Constants.MINIMUM_FINAL_COST) {
            surcharge = 5;
        } else if (finalCost > Constants.MINIMUM_FINAL_COST && finalCost <= Constants.MAXIMUM_FINAL_COST) {
            surcharge = 10;
        } else {
            surcharge = 0.05 * finalCost;
        }
        return surcharge;
    }

    /**
     * Calculate tax.
     *
     * @param items the items
     */
// todo: read and implement strategy pattern
    public static double calculateTax(Item items) {
        double itemCost = items.getPrice();
        double common = 0.125 * itemCost;
        double tax = 0.0;                                               //Common equation involved in first two types
        switch (ItemType.valueOf(items.getType().toUpperCase())) {
            case RAW:
                tax = common;
                break;

            case MANUFACTURED:
                tax =  (common + (0.02 * (itemCost + common)));
                break;

            case IMPORTED:
                double import_duty = 0.1 * itemCost;
                tax = import_duty + calculateSurcharge(itemCost, import_duty);
                break;

            default:
                try {
                    throw new ApplicationException(ExceptionType.INVALID_INPUT);
                } catch (ApplicationException e) {
                    ;
                    e.printEvent("Invalid input for type");
                }
        }
        return tax;
    }
}
