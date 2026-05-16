/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2_app;

/**
 *
 * @author home
 */
/**
 * Represents a single applicant loaded from the text file.
 * This class stores all raw data from the file.
 */
public class Applicant {

    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private double salary;
    private String department;
    private String position;
    private String jobTitle;
    private String company;

    public Applicant(String firstName, String lastName, String gender, String email,
                     double salary, String department, String position,
                     String jobTitle, String company) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    /** Returns full name (first + last). */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGender() { return gender; }
    public String getEmail() { return email; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public String getPosition() { return position; }
    public String getJobTitle() { return jobTitle; }
    public String getCompany() { return company; }

    @Override
    public String toString() {
        return "Applicant{" +
                "fullName='" + getFullName() + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}


