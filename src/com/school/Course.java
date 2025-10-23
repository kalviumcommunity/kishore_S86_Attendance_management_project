package com.school;

public class Course {
    private String courseId;
    private String courseName;

    // ✅ Correct constructor
    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Getters
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    // Display course details
    public void displayCourse() {
        System.out.println("Course ID: " + courseId + ", Course Name: " + courseName);
    }
}
