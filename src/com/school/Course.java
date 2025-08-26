package com.school;

public class Course {
    private static int nextCourseIdCounter = 101; // auto-increment counter starting from 101
    private int courseId;
    private String courseName;

    // Constructor for initialization
    public Course(String cName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = cName;
    }

    public void displayDetails() {
        System.out.println("Course ID: C" + this.courseId + ", Name: " + this.courseName);
    }
}
