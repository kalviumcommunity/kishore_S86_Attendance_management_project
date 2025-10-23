package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog = new ArrayList<>();
    private FileStorageService storage;
    private RegistrationService registrationService;

    public AttendanceService(FileStorageService storage, RegistrationService registrationService) {
        this.storage = storage;
        this.registrationService = registrationService;
    }

    // Overloaded markAttendance
    public void markAttendance(Student student, Course course, String status) {
        attendanceLog.add(new AttendanceRecord(student, course, status));
    }

    public void markAttendance(int studentId, String courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);
        if (student != null && course != null) {
            markAttendance(student, course, status);
        } else {
            System.out.println("Warning: Could not find student or course for attendance record");
        }
    }

    // Display
    public void displayAttendanceLog() {
        System.out.println("--- All Attendance Records ---");
        for (AttendanceRecord ar : attendanceLog) {
            ar.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("--- Attendance for Student: " + student.getName() + " ---");
        for (AttendanceRecord ar : attendanceLog) {
            if (ar.getStudent().equals(student)) {
                ar.displayRecord();
            }
        }
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("--- Attendance for Course: " + course.getCourseName() + " ---");
        for (AttendanceRecord ar : attendanceLog) {
            if (ar.getCourse().equals(course)) {
                ar.displayRecord();
            }
        }
    }

    public void saveAttendanceData() {
        storage.saveData(attendanceLog, "attendance_log.txt");
    }
}
