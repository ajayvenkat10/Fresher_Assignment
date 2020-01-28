package com.nuclei.question2;

import java.util.Comparator;

/**
 * The type Name comparator.
 */
public class NameComparator implements Comparator<StudentInfo> {

    @Override
    public int compare(StudentInfo student1, StudentInfo student2) {
        int name = student1.getFullName().compareTo(student2.getFullName());
        if (name == 0) {
            return student1.getRollNumber() - student2.getRollNumber();
        }
        return name;
    }
}
