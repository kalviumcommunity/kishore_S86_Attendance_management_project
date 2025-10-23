package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");
        System.out.println("=== Part 9: SOLID Service Layer ===");

        FileStorageService storage = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, registrationService);

        // Register Students
        Student s1 = new Student("Alice Wonderland", "10th Grade");
        Student s2 = new Student("Bob The Builder", "11th Grade");
        Student s3 = new Student("Charlie Brown", "12th Grade");

        registrationService.registerStudent(s1);
        registrationService.registerStudent(s2);
        registrationService.registerStudent(s3);

        // Register Teachers
        Teacher t1 = new Teacher("Mr. John", "Mathematics");
        Teacher t2 = new Teacher("Ms. Mary", "Physics");
        registrationService.registerTeacher(t1);
        registrationService.registerTeacher(t2);

        // Register Staff
        Staff staff1 = new Staff("David", "Clerk");
        Staff staff2 = new Staff("Sophia", "Librarian");
        registrationService.registerStaff(staff1);
        registrationService.registerStaff(staff2);

        // Create Courses
        registrationService.createCourse("Intro to Programming");
        registrationService.createCourse("Linear Algebra");
        registrationService.createCourse("Data Structures");

        // Display School Directory
        displaySchoolDirectory(registrationService);

        // Mark Attendance using IDs
        attendanceService.markAttendance(1, "C101", "Present");
        attendanceService.markAttendance(2, "C102", "Absent");
        attendanceService.markAttendance(3, "C103", "Present");

        // Display Attendance Logs
        attendanceService.displayAttendanceLog();

        // Save all data
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nPart 9: SOLID Service Layer complete. Check output files.");
    }

    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory ---");
        List<Person> people = regService.getAllPeople();
        for (Person p : people) {
            p.displayDetails();
        }
    }
}
