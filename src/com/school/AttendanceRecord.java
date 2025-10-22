package com.school;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;

        if (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent")) {
            this.status = status;
        } else {
            System.out.println("Warning: Invalid status provided for studentId " 
                + student.getId() + " and courseId " + course.getCourseId());
            this.status = "Invalid";
        }
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("Student ID: " + student.getId() +
                ", Name: " + student.getName() +
                ", Course: " + course.getCourseName() +
                ", Status: " + status);
    }

    @Override
    public String toDataString() {
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}
