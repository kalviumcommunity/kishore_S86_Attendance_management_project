package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        // Students
        Student s1 = new Student("Alice Wonderland");
        Student s2 = new Student("Bob The Builder");
        Student s3 = new Student("Charlie Brown");

        // Courses
        Course c1 = new Course("Intro to Programming");
        Course c2 = new Course("Linear Algebra");
        Course c3 = new Course("Data Structures");

        // Display Students
        System.out.println("\nRegistered Students:");
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();

        // Display Courses
        System.out.println("\nAvailable Courses:");
        c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();

        // Attendance Records
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(s2.getStudentId(), c2.getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(s3.getStudentId(), c3.getCourseId(), "Late")); // invalid status

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("\nPart 4: Data Encapsulation & Attendance Recording Complete.");
    }
}
