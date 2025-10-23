package com.school;

public class Staff extends Person implements Storable {
    private String role;

    public Staff(String name, String role) {
        super(name);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public void displayDetails() {
        System.out.println("ID: " + getId() + ", Name: " + getName());
        System.out.println("Role: Staff, Position: " + role);
    }

    @Override
    public String toDataString() {
        return getId() + "," + getName() + "," + role;
    }
}
