package com.nuclei.question4;

import java.util.ArrayList;

public class ApplicationState {
    private static ApplicationState instance;

    private int count;
    private ArrayList<Item> itemsFetched = new ArrayList<>();
    private ArrayList<Item> itemsWithTax = new ArrayList<>();
    private boolean terminate;

    private ApplicationState() {
        try {
            terminate = false;
            if (instance != null)
                throw new IllegalAccessException();
            itemsWithTax.clear();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    public void decrementCount() {
        count--;
    }

    public static ApplicationState getInstance() {
        if (instance == null) {
            instance = new ApplicationState();
        }
        return instance;
    }

    public ArrayList<Item> getItemsFetched() {
        return itemsFetched;
    }

    public void addToItemsFetched(Item item) {
        itemsFetched.add(item);
    }

    public ArrayList<Item> getItemsWithTax() {
        return itemsWithTax;
    }

    public void addToItemsWithTax(Item item) {
        itemsWithTax.add(item);
    }

    public void setTerminate(boolean terminate) {
        this.terminate = terminate;
    }

    public boolean getTerminate() {
        return terminate;
    }
}
