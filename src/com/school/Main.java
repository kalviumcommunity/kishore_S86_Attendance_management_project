package com.school;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");
        System.out.println("=== Part 6: Interface-Driven Persistence ===");

        // Students
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice Wonderland", "10th Grade"));
        students.add(new Student("Bob The Builder", "11th Grade"));
        students.add(new Student("Charlie Brown", "12th Grade"));

        System.out.println("\nRegistered Students:");
        for (Student s : students) {
            s.displayDetails();
        }

        // Courses
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Intro to Programming"));
        courses.add(new Course("Linear Algebra"));
        courses.add(new Course("Data Structures"));

        System.out.println("\nAvailable Courses:");
        for (Course c : courses) {
            c.displayDetails();
        }

        // Attendance Records
        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(students.get(0).getId(), courses.get(0).getCourseId(), "Present"));
        records.add(new AttendanceRecord(students.get(1).getId(), courses.get(1).getCourseId(), "Absent"));
        records.add(new AttendanceRecord(students.get(2).getId(), courses.get(2).getCourseId(), "InvalidStatus"));

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord r : records) {
            r.displayDetails();
        }

        // Save to files
        FileStorageService storageService = new FileStorageService();
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(records, "attendance_log.txt");

        System.out.println("\nPart 6: Data persistence complete. Check output files.");
    }
}
