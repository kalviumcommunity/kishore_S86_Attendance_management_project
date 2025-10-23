package com.school;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");
        System.out.println("=== Part 8: Overloaded Commands ===\n");

        // Initialize file storage and attendance service
        FileStorageService storage = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storage);

        // === Create Students ===
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice Wonderland", "10th Grade"));
        students.add(new Student("Bob The Builder", "11th Grade"));
        students.add(new Student("Charlie Brown", "12th Grade"));

        // === Create Courses ===
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("C101", "Intro to Programming"));
        courses.add(new Course("C102", "Linear Algebra"));
        courses.add(new Course("C103", "Data Structures"));

        // === Demonstrate Overloaded markAttendance() ===
        System.out.println("--- Marking Attendance ---");
        attendanceService.markAttendance(students.get(0), courses.get(0), "Present");
        attendanceService.markAttendance(2, 102, "Absent", students, courses);
        attendanceService.markAttendance(3, 103, "Present", students, courses);

        // === Display Attendance Logs ===
        System.out.println("\n--- All Attendance Records ---");
        attendanceService.displayAttendanceLog();

        System.out.println("\n--- Attendance for Student: " + students.get(0).getName() + " ---");
        attendanceService.displayAttendanceLog(students.get(0));

        System.out.println("\n--- Attendance for Course: " + courses.get(1).getCourseName() + " ---");
        attendanceService.displayAttendanceLog(courses.get(1));

        // === Save Attendance Data ===
        attendanceService.saveAttendanceData();

        System.out.println("\nPart 8: Overloaded attendance operations complete.");
    }
}
