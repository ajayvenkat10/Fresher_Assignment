package com.nuclei.question2;

import java.util.Comparator;

/**
 * The type Address comparator.
 */
public class AddressComparator implements Comparator<StudentInfo> {
    @Override
    public int compare(StudentInfo student1, StudentInfo student2) {
        int address = student1.getAddress().compareTo(student2.getAddress());
        if(address == 0){
            return student1.getRollNumber() - student2.getRollNumber();
        }
        return address;
    }
}
