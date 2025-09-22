package com.school;

public class Student extends Person {
    private String gradeLevel;

    public Student(String name, String gradeLevel) {
        super(name); // Call Person constructor for auto-id and name
        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public void displayDetails() {
        System.out.println("Student -> ID: " + getId() + ", Name: " + getName() + ", Grade Level: " + gradeLevel);
    }
}
