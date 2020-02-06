package com.nuclei.question2;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * The type Application state.
 */
public class ApplicationState {

    private static ApplicationState instance;

    private int count;
    private boolean isChanged;

    private ArrayList<StudentInfo> listOfObjects = new ArrayList<>();
    private HashMap<Integer, Boolean> map = new HashMap<>();

    private ApplicationState() {
        isChanged = false;
        try {
            if (instance != null)
                throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            ;
        }
        try {

            listOfObjects.clear();
            listOfObjects = FileIO.readFromFile();
            for(StudentInfo object : listOfObjects){
                map.put(object.getRollNumber(), true);
            }
        }catch(Exception e){

        }
    }

    /**
     * Gets is changed.
     *
     * @return the is changed
     */
    public boolean getIsChanged() {
        return isChanged;
    }

    /**
     * Sets is changed.
     *
     * @param changed the changed
     */
    public void setIsChanged(boolean changed) {
        isChanged = changed;
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
    public HashMap<Integer, Boolean> getMap() {
        return map;
    }

    /**
     * Add to map.
     *
     * @param rollNumber the roll number
     */
    public void addToMap(int rollNumber) {
        map.put(rollNumber, true);
    }

    /**
     * Delete from map int.
     *
     * @param rollNumber the roll number
     * @return the int
     */
    public int deleteFromMap(int rollNumber) {
        try {
            map.remove(rollNumber);
        } catch (Exception e) {
            Logger.log("The entered roll number does not exist.");
            return -1;
        }
        return 1;
    }

    /**
     * Gets list of objects.
     *
     * @return the list of objects
     */
    public ArrayList<StudentInfo> getListOfObjects() {
        return listOfObjects;
    }

    /**
     * Add to list of objects.
     *
     * @param student the student
     */
    public void addToListOfObjects(StudentInfo student) {
        listOfObjects.add(student);
    }

    /**
     * Delete from list of objects boolean.
     *
     * @param rollNumber the roll number
     * @return the boolean
     */
    public boolean deleteFromListOfObjects(int rollNumber) {
        try {
            listOfObjects.removeIf(student -> (student.getRollNumber() == rollNumber));
        } catch (NullPointerException e) {
            return false;
        }
        return true;
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
