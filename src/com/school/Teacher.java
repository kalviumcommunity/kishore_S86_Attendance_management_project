package com.school;

public class Teacher extends Person implements Storable {
    private String subjectTaught;

    public Teacher(String name, String subjectTaught) {
        super(name);
        this.subjectTaught = subjectTaught;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + getId() + ", Name: " + getName());
        System.out.println("Role: Teacher, Subject: " + subjectTaught);
    }

    @Override
    public String toDataString() {
        return getId() + "," + getName() + "," + subjectTaught;
    }
}
