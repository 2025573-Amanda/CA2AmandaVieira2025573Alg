/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ca2_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main application logic for the CA2 Bank Management System.
 * This class provides a menu that allows the user to:
 * - Load applicants from file
 * - Sort applicants
 * - Search applicants
 * - Create a Binary Tree of Employees
 * - Print the Binary Tree
 */
public class CA2_App {
    
    private List<Applicant> applicants = new ArrayList<>();
    private BinaryTree employeeTree = new BinaryTree();
    private Scanner scanner = new Scanner(System.in);
     /**
     * Displays the main menu and handles user input.
     */
    
    public void start() {
        int choice;

        do {
            System.out.println("\n===== CA2 BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Load Applicants from File");
            System.out.println("2. Sort Applicants by Name");
            System.out.println("3. Search Applicant by Name (Binary Search)");
            System.out.println("4. Search Applicant by Email");
            System.out.println("5. Search Applicants by Department");
            System.out.println("6. Create Binary Tree of Employees");
            System.out.println("7. Print Binary Tree (In-Order)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> loadApplicants();
                case 2 -> sortApplicants();
                case 3 -> searchByName();
                case 4 -> searchByEmail();
                case 5 -> searchByDepartment();
                case 6 -> createBinaryTree();
                case 7 -> printBinaryTree();
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid option. Try again.");
            }

        } while (choice != 0);
    }

    /**
     * Loads applicants from the text file using FileReaderService.
     */
    private void loadApplicants() {
        FileReaderService service = new FileReaderService();
        applicants = service.readApplicants();

        System.out.println("\nApplicants loaded: " + applicants.size());
    }

    /**
     * Sorts applicants alphabetically by full name.
     */
    private void sortApplicants() {
        if (applicants.isEmpty()) {
            System.out.println("No applicants loaded.");
            return;
        }

        SortingServiceApplicants.mergeSort(applicants, 0, applicants.size() - 1);
        System.out.println("Applicants sorted successfully.");
    }

    /**
     * Searches for an applicant by name using recursive binary search.
     */
    private void searchByName() {
        if (applicants.isEmpty()) {
            System.out.println("No applicants loaded.");
            return;
        }

        System.out.print("Enter full name to search: ");
        String name = scanner.nextLine().toLowerCase();

        int index = SearchingServiceApplicants.searchByName(applicants, name, 0, applicants.size() - 1);

        if (index == -1) {
            System.out.println("Applicant not found.");
        } else {
            System.out.println("Applicant found: " + applicants.get(index));
        }
    }

    /**
     * Searches for an applicant by email using linear search.
     */
    private void searchByEmail() {
        if (applicants.isEmpty()) {
            System.out.println("No applicants loaded.");
            return;
        }

        System.out.print("Enter email to search: ");
        String email = scanner.nextLine();

        Applicant result = SearchingServiceApplicants.searchByEmail(applicants, email);

        if (result == null) {
            System.out.println("Applicant not found.");
        } else {
            System.out.println("Applicant found: " + result);
        }
    }

    /**
     * Searches for applicants by department using stream filtering.
     */
    private void searchByDepartment() {
        if (applicants.isEmpty()) {
            System.out.println("No applicants loaded.");
            return;
        }

        System.out.print("Enter department: ");
        String dept = scanner.nextLine();

        List<Applicant> results = SearchingServiceApplicants.searchByDepartment(applicants, dept);

        if (results.isEmpty()) {
            System.out.println("No applicants found in this department.");
        } else {
            System.out.println("Applicants found:");
            results.forEach(System.out::println);
        }
    }

    /**
     * Creates a Binary Tree of Employees using the loaded applicants.
     */
    private void createBinaryTree() {
        if (applicants.isEmpty()) {
            System.out.println("No applicants loaded.");
            return;
        }

        for (Applicant a : applicants) {
            Employee emp = new Employee(
                    a.getFullName(),
                    ManagerType.JUNIOR, // default for CA2
                    DepartmentType.IT   // default for CA2
            );
            employeeTree.insert(emp);
        }

        System.out.println("Binary Tree created successfully.");
    }

    /**
     * Prints the Binary Tree in alphabetical order.
     */
    private void printBinaryTree() {
        System.out.println("\n===== EMPLOYEE BINARY TREE =====");
        employeeTree.printInOrder();
    }
}
    

