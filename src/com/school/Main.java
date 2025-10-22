package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");
        System.out.println("=== Part 7: Polymorphic Behaviour & Reports ===");

        // Students
        Student s1 = new Student("Alice Wonderland", "10th Grade");
        Student s2 = new Student("Bob The Builder", "11th Grade");
        Student s3 = new Student("Charlie Brown", "12th Grade");

        // Teachers
        Teacher t1 = new Teacher("Mr. John", "Mathematics");
        Teacher t2 = new Teacher("Ms. Mary", "Physics");

        // Staff
        Staff st1 = new Staff("David", "Clerk");
        Staff st2 = new Staff("Sophia", "Librarian");

        // Courses
        Course c1 = new Course("Intro to Programming");
        Course c2 = new Course("Linear Algebra");
        Course c3 = new Course("Data Structures");

        // Combine all people for polymorphic display
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(s1);
        schoolPeople.add(s2);
        schoolPeople.add(s3);
        schoolPeople.add(t1);
        schoolPeople.add(t2);
        schoolPeople.add(st1);
        schoolPeople.add(st2);

        // Display directory (demonstrates polymorphism)
        displaySchoolDirectory(schoolPeople);

        // Attendance records using Student & Course objects
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(s1, c1, "Present"));
        attendanceLog.add(new AttendanceRecord(s2, c2, "Absent"));
        attendanceLog.add(new AttendanceRecord(s3, c3, "Late")); // invalid

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // Saving student data
        List<Student> studentList = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                studentList.add((Student) p);
            }
        }

        FileStorageService storage = new FileStorageService();
        storage.saveData(studentList, "students.txt");
        storage.saveData(List.of(c1, c2, c3), "courses.txt");
        storage.saveData(attendanceLog, "attendance_log.txt");

        System.out.println("\nPart 7: Polymorphism & Reporting complete. Check output files.");
    }

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n--- School Directory (Polymorphism Demo) ---");
        for (Person p : people) {
            p.displayDetails();  // polymorphic call
        }
    }
}
