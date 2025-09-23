package com.school;

public class AttendanceRecord implements Storable {
    private int studentId;
    private String courseId;
    private String status;

    public AttendanceRecord(int studentId, String courseId, String status) {
        if (!status.equalsIgnoreCase("Present") && !status.equalsIgnoreCase("Absent")) {
            this.status = "Invalid";
            System.out.println("Warning: Invalid status provided for studentId " + studentId + " and courseId " + courseId);
        } else {
            this.status = status;
        }
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    public void displayDetails() {
        System.out.println("Student ID: S" + studentId + ", Course ID: " + courseId + ", Status: " + status);
    }

    @Override
    public String toDataString() {
        return studentId + "," + courseId + "," + status;
    }
}
