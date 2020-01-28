package com.nuclei.question2;

import java.util.Comparator;

/**
 * The type Roll number comparator.
 */
public class RollNumberComparator implements Comparator<StudentInfo> {
    @Override
    public int compare(StudentInfo student1, StudentInfo student2) {
        return student1.getRollNumber() - student2.getRollNumber();
    }
}
