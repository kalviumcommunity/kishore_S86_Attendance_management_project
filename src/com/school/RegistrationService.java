package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses;
    private FileStorageService storage;

    public RegistrationService(FileStorageService storage) {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.storage = storage;
    }

    public Student registerStudent(String name, String gradeLevel) {
        Student student = new Student(name, gradeLevel);
        students.add(student);
        return student;
    }

    public Teacher registerTeacher(String name, String subject) {
        Teacher teacher = new Teacher(name, subject);
        teachers.add(teacher);
        return teacher;
    }

    public Staff registerStaff(String name, String role) {
        Staff staff = new Staff(name, role);
        staffMembers.add(staff);
        return staff;
    }

    public Course createCourse(String courseId, String courseName, int capacity) {
        Course course = new Course(courseId, courseName, capacity);
        courses.add(course);
        return course;
    }

    public boolean enrollStudentInCourse(Student student, Course course) {
        boolean success = course.addStudent(student);
        if (success) {
            System.out.println(student.getName() + " enrolled in " + course.getCourseName());
        } else {
            System.out.println("Cannot enroll " + student.getName() + " in " + course.getCourseName() + ": capacity full");
        }
        return success;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Person> getAllPeople() {
        List<Person> all = new ArrayList<>();
        all.addAll(students);
        all.addAll(teachers);
        all.addAll(staffMembers);
        return all;
    }

    public Student findStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public Course findCourseById(String courseId) {
        return courses.stream().filter(c -> c.getCourseId().equals(courseId)).findFirst().orElse(null);
    }

    public void saveAllRegistrations() {
        storage.saveData(students, "students.txt");
        storage.saveData(teachers, "teachers.txt");
        storage.saveData(staffMembers, "staff.txt");
        storage.saveData(courses, "courses.txt");
    }
}
