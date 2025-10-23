package com.school;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");
        System.out.println("=== Part 10: Capacity Management & Enrollment ===\n");

        FileStorageService storage = new FileStorageService();
        RegistrationService regService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, regService);

        // Register Students
        Student s1 = regService.registerStudent("Alice Wonderland", "10th Grade");
        Student s2 = regService.registerStudent("Bob The Builder", "11th Grade");
        Student s3 = regService.registerStudent("Charlie Brown", "12th Grade");

        // Register Teachers & Staff
        Teacher t1 = regService.registerTeacher("Mr. John", "Mathematics");
        Teacher t2 = regService.registerTeacher("Ms. Mary", "Physics");
        Staff st1 = regService.registerStaff("David", "Clerk");
        Staff st2 = regService.registerStaff("Sophia", "Librarian");

        // Create Courses with capacity
        Course c1 = regService.createCourse("C101", "Intro to Programming", 2);
        Course c2 = regService.createCourse("C102", "Linear Algebra", 2);
        Course c3 = regService.createCourse("C103", "Data Structures", 1);

        // Enroll Students
        regService.enrollStudentInCourse(s1, c1);
        regService.enrollStudentInCourse(s2, c1);
        regService.enrollStudentInCourse(s3, c1); // exceeds capacity
        regService.enrollStudentInCourse(s3, c3); // allowed

        // Display Courses
        List<Course> courses = regService.getCourses();
        for (Course course : courses) {
            course.displayDetails();
            System.out.println();
        }

        // Mark attendance
        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c1, "Absent");
        attendanceService.markAttendance(s3, c3, "Present");

        // Display attendance log
        System.out.println("--- All Attendance Records ---\n");
        attendanceService.displayAttendanceLog();

        // Save data
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nPart 10: Capacity management complete. Check output files.");
    }
}
