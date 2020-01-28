package com.nuclei.question2;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Set;

/**
 * The type Student info.
 */
class StudentInfo implements Comparable<StudentInfo>, Serializable {
    private String fullName;
    private int age;
    private String address;
    private int rollNumber;
    private Set<Character> courses;

    /**
     * Gets courses.
     *
     * @return the courses
     */
    public String getCourses() {
        return Utilities.convertSetToString(courses);
    }

    /**
     * Sets courses.
     *
     * @param courses the courses
     */
    public void setCourses(Set<Character> courses) {
        this.courses = courses;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets full name.
     *
     * @param fullName the full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets roll number.
     *
     * @return the roll number
     */
    public int getRollNumber() {
        return rollNumber;
    }

    /**
     * Sets roll number.
     *
     * @param rollNumber the roll number
     */
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public int compareTo(StudentInfo student) {
        int name = this.fullName.compareTo(student.fullName);
        if (name == 0) {
            return (this.rollNumber - student.rollNumber);
        }
        return name;
    }

    @Override
    public String toString() {
        return "Student [fullName=" + fullName + ", age=" + age + ", address=" + address + ", rollNumber=" + rollNumber + ", courses=" + courses + " ]";
    }
}
