package com.andrei.test.models;

public class Student {
    //    private int [] results = new int[68];
    private String studentName;
    private String password;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
