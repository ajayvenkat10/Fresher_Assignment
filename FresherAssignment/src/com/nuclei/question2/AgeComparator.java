package com.nuclei.question2;

import java.util.Comparator;

/**
 * The type Age comparator.
 */
public class AgeComparator implements Comparator<StudentInfo> {
    @Override
    public int compare(StudentInfo student1, StudentInfo student2) {
        int age = student1.getAge() - student2.getAge();
        if(age == 0){
            return student1.getRollNumber() - student2.getRollNumber();
        }
        return age;
    }
}
