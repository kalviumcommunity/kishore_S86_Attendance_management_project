package com.school;

public class Course implements Storable {
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }

    public void displayDetails() {
        System.out.println("Course ID: " + courseId + ", Name: " + courseName);
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName;
    }
}
