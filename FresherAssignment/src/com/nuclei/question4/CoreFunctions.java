package com.nuclei.question4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoreFunctions {

    ApplicationState state = ApplicationState.getInstance();
    static boolean valueSet = false;
    static ArrayList<Item> items = new ArrayList<>();

    synchronized public void fetchFromDB(Item item) {

        while (valueSet) {
            try {
                wait();
                System.out.println("Fetch from DB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        items.add(item);
        state.incrementCount();
        valueSet = true;
        notify();

    }

    synchronized public void computeTax() {

        while (!valueSet) {

            try {
                wait();
                System.out.println("computeTax");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (items.size() != 0) {
            Item item = items.get(items.size() - 1);
            item.setTax(BusinessLogic.calculateTax(item));
            state.addToItemsWithTax(item);
        }
        valueSet = false;
        notify();

    }


}
