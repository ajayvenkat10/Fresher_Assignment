package com.nuclei.question1;

/**
 * The type Application state.
 */
public class ApplicationState {

    private static ApplicationState instance;

    private int count;

    private ApplicationState(){
        try {
            if(instance != null)
                throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            ;
        }
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ApplicationState getInstance() {
        if (instance == null) {
            instance = new ApplicationState();
        }
        return instance;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * Increment count.
     */
    public void incrementCount() {
        count++;
    }

    /**
     * Decrement count.
     */
    public void decrementCount() {
        count--;
    }
}
