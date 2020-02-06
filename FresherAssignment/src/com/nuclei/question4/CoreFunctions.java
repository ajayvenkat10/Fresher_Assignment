package com.nuclei.question4;

import java.util.ArrayList;

public class CoreFunctions {

    ApplicationState state = ApplicationState.getInstance();
    static boolean valueSet = false;
    static ArrayList<Item> items = new ArrayList<>();

    public synchronized void fetchFromDB(Item item) {
        if (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                ;
            }
        }
        Logger.log("Fetch from DB");
        items.add(item);
        valueSet = true;
        notify();
    }


    public synchronized void computeTax() {
        if (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                ;
            }
        }
        Logger.log("Compute Tax");
        if (items.size() != 0) {
            Item item = items.get(items.size() - 1);
            item.setTax(BusinessLogic.calculateTax(item));
            state.addToItemsWithTax(item);
        }

        valueSet = false;
        notify();
    }
}
