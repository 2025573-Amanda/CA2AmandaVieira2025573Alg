/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2_app;

/**
 * Represents an Employee in the bank system.
 * Each employee has:
 * - A full name
 * - A ManagerType (enum)
 * - A DepartmentType (enum)
 *
 * This class is used when creating Employee records
 * and when inserting them into the Binary Tree.
 */
public class Employee {

    // Stores the full name of the employee
    private String fullName;

    // Stores the manager type (enum) assigned to the employee
    private ManagerType managerType;

    // Stores the department (enum) where the employee works
    private DepartmentType departmentType;

    /**
     * Constructor used to create a new Employee object.
     *
     * @param fullName The employee's full name
     * @param managerType The type of manager supervising the employee
     * @param departmentType The department where the employee works
     */
    public Employee(String fullName, ManagerType managerType, DepartmentType departmentType) {
        this.fullName = fullName;
        this.managerType = managerType;
        this.departmentType = departmentType;
    }

    /**
     * Returns the employee's full name.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Returns the manager type assigned to the employee.
     */
    public ManagerType getManagerType() {
        return managerType;
    }

    /**
     * Returns the department where the employee works.
     */
    public DepartmentType getDepartmentType() {
        return departmentType;
    }

    /**
     * Returns a formatted string representation of the Employee object.
     */
    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", managerType=" + managerType +
                ", departmentType=" + departmentType +
                '}';
    }
}

