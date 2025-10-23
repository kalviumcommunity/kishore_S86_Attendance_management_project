package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Staff> staffMembers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    private FileStorageService storage;

    private static int courseCounter = 101;

    public RegistrationService(FileStorageService storage) {
        this.storage = storage;
    }

    // Register and create entities
    public void registerStudent(Student student) {
        students.add(student);
    }

    public void registerTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void registerStaff(Staff staff) {
        staffMembers.add(staff);
    }

    public void createCourse(String courseName) {
        String courseId = "C" + courseCounter++;
        courses.add(new Course(courseId, courseName));
    }

    // Lookup
    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public Course findCourseById(String courseId) {
        for (Course c : courses) {
            if (c.getCourseId().equals(courseId)) return c;
        }
        return null;
    }

    // Getters
    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    public List<Person> getAllPeople() {
        List<Person> all = new ArrayList<>();
        all.addAll(students);
        all.addAll(teachers);
        all.addAll(staffMembers);
        return all;
    }

    // Save
    public void saveAllRegistrations() {
        storage.saveData(students, "students.txt");
        storage.saveData(teachers, "teachers.txt");
        storage.saveData(staffMembers, "staff.txt");
        storage.saveData(courses, "courses.txt");
    }
}
