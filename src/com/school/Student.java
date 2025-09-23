package com.school;

public class Student extends Person implements Storable {
    private String gradeLevel;

    public Student(String name, String gradeLevel) {
        super(name);
        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public void displayDetails() {
        System.out.println("Student -> ID: " + getId() + ", Name: " + getName() + ", Grade Level: " + gradeLevel);
    }

    @Override
    public String toDataString() {
        return getId() + "," + getName() + "," + gradeLevel;
    }
}
