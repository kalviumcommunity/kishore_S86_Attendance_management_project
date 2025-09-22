package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");
        System.out.println("=== Part 5: Inheritance Hierarchy ===\n");

        // Students (Student extends Person)
        Student s1 = new Student("Alice Wonderland", "10th Grade");
        Student s2 = new Student("Bob The Builder", "11th Grade");
        Student s3 = new Student("Charlie Brown", "12th Grade");

        // Teachers
        Teacher t1 = new Teacher("Mr. John", "Mathematics");
        Teacher t2 = new Teacher("Ms. Mary", "Physics");

        // Staff
        Staff st1 = new Staff("David", "Clerk");
        Staff st2 = new Staff("Sophia", "Librarian");

        // Display Students
        System.out.println("Registered Students:");
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();

        // Display Teachers
        System.out.println("\nTeachers:");
        t1.displayDetails();
        t2.displayDetails();

        // Display Staff
        System.out.println("\nNon-Teaching Staff:");
        st1.displayDetails();
        st2.displayDetails();

        // Courses
        Course c1 = new Course("Intro to Programming");
        Course c2 = new Course("Linear Algebra");
        Course c3 = new Course("Data Structures");

        // Display Courses
        System.out.println("\nAvailable Courses:");
        c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();

        // Attendance Records
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(s1.getId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(s2.getId(), c2.getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(s3.getId(), c3.getCourseId(), "Late")); // invalid status

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("\nPart 5: Inheritance Hierarchy Complete.");
    }
}
