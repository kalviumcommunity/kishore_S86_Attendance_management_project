Attendance Management Project

Welcome to my Attendance Management Project repository!
This project is part of the Kalvium OOP course.

Project Structure
Kishore_S86_Attendance_management_project/
├── src/
│   └── com/
│       └── school/
│           ├── Main.java
│           ├── Student.java
│           ├── Course.java
│           └── AttendanceRecord.java
└── README.md

How to Run

Navigate to the project root directory (the one containing src and README.md).

Compile all Java files:

javac src/com/school/*.java


Run the program:

java -cp src com.school.Main

Part 1: Project Setup

Created project folder and initial structure.

Added Main.java, Student.java, and Course.java.

Verified basic compilation and execution of Java files.

Part 2: Core Domain Modelling

Defined Student class with studentId, name, and displayDetails() method.

Defined Course class with courseId, courseName, and displayDetails() method.

Used arrays to manage multiple students and courses in Main.java.

Demonstrated the use of this keyword.

Part 3: Constructor Initialization & Auto-ID Generation

Added parameterized constructors in Student and Course classes.

Implemented automatic unique ID generation using private static variables.

Removed setDetails() methods.

Updated Main.java to create multiple students and courses showing auto-incrementing IDs.

Part 4: Data Encapsulation & Attendance Recording Validation

Applied encapsulation to Student and Course classes by making fields private and adding public getters.

Introduced a new AttendanceRecord class with private fields, a constructor, and getters to store attendance data.

Implemented basic validation in the AttendanceRecord constructor for the attendance status (allowing only "Present" or "Absent").

Used an ArrayList in Main.java to store and display AttendanceRecord objects.

Demonstrated retrieving IDs using getters (e.g., student1.getStudentId()) when creating records.

Part 5: Establishing Students, Teaching and Non Teaching Staff Hierarchy

Created a base class Person.java with common attributes id and name, a universal auto ID generator, and a displayDetails method.

Modified Student.java to inherit from Person, using super to call the parent constructor and overriding displayDetails to add student specific information such as grade level.

Created Teacher.java extending Person, adding a subjectTaught attribute and its own displayDetails method.

Created Staff.java extending Person, adding a role attribute and its own displayDetails method.

Demonstrated creation and display of Student, Teacher, and Staff objects in Main.java.

Updated AttendanceRecord creation to use the inherited getId method.

## Part 6: Interface-Driven Persistence with Storage

- Defined a Storable interface with a toDataString() method.
- Modified Student, Course, and AttendanceRecord to implement Storable and return CSV-like data.
- Created FileStorageService with saveData(List<? extends Storable> items, String filename).
- Used try-with-resources for safe file writing.
- Demonstrated saving students, courses, and attendance records into separate files.

### How to Run
1. Navigate to the project root directory.
2. Compile: javac src/com/school/*.java
3. Run: java -cp src com.school.Main
4. Check the generated files: students.txt, courses.txt, attendance_log.txt


Part 7: Polymorphic Behaviour in Attendance and Displaying Reports

- Enhanced AttendanceRecord to store full Student and Course objects instead of just IDs.
- Implemented runtime polymorphism by looping through a List<Person> and invoking displayDetails() on each object.
- Updated AttendanceRecord display to show student names and course titles.
- Demonstrated polymorphic behaviour using Student, Teacher, and Staff instances.
- Maintained file persistence using the FileStorageService from Part 6.
- Validated attendance input and ensured data is still saved in text files.
