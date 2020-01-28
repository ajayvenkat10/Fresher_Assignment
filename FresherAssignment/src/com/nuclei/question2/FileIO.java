package com.nuclei.question2;

import java.io.*;
import java.util.*;

/**
 * The type File io.
 */
public class FileIO {

    /**
     * Write to file.
     *
     * @param students the students
     */
    public static void writeToFile(ArrayList<StudentInfo> students) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Constants.STUDENTS_DATA_FILE, false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Read from file array list.
     *
     * @return the array list
     * @throws Exception the exception
     */
    public static ArrayList<StudentInfo> readFromFile() throws Exception {
        ArrayList<StudentInfo> studentList = new ArrayList<>();
        try {
            File w = new File(Constants.STUDENTS_DATA_FILE);
            FileInputStream fileInputStream = new FileInputStream(w);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            studentList = (ArrayList) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            Logger.log("Class not found");
            c.printStackTrace();
        }
        return studentList;
    }
}
