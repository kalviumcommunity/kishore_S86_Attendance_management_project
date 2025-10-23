package com.school;

import java.util.*;
import java.io.*;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    // --- Overloaded markAttendance methods ---

    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    public void markAttendance(int studentId, int courseId, String status,
                               List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(allStudents, studentId);
        Course course = findCourseById(allCourses, courseId);
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("Warning: Could not find student or course for provided IDs.");
        }
    }

    // --- Helper methods ---

    private Student findStudentById(List<Student> students, int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(List<Course> courses, int id) {
        for (Course c : courses) {
            if (c.getCourseId().equals("C" + id)) return c;
        }
        return null;
    }

    // --- Display methods (overloaded) ---

    public void displayAttendanceLog() {
        System.out.println("\n--- All Attendance Records ---");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\n--- Attendance for Student: " + student.getName() + " ---");
        attendanceLog.stream()
            .filter(r -> r.getStudent().equals(student))
            .forEach(AttendanceRecord::displayRecord);
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\n--- Attendance for Course: " + course.getCourseName() + " ---");
        attendanceLog.stream()
            .filter(r -> r.getCourse().equals(course))
            .forEach(AttendanceRecord::displayRecord);
    }

    // --- Save Data ---

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
