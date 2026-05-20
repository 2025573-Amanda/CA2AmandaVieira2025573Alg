/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main application logic for the CA2 Bank Management System.
 * This class provides a menu that allows the user to:
 * - Import applicants from file
 * - Sort applicants
 * - Search applicants
 * - Add new employees
 * - Generate a Binary Tree of Employees
 * - Print the Binary Tree (In-Order / Level-Order)
 * - Show tree height and node count
 */
public class CA2_App {

    private List<Applicant> applicants = new ArrayList<>();
    private BinaryTree employeeTree = new BinaryTree();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Starts the main menu using MenuOptionEnum.
     * The menu is generated dynamically based on the ENUM values.
     */
    public void start() {

       while (true) {
            System.out.println("\n=========================================");
            System.out.println("      BANK EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("=========================================");

            for (MenuOptionEnum option : MenuOptionEnum.values()) {
                System.out.println((option.ordinal() + 1) + ". " + option);
            }

            System.out.print("\nSelect an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice < 1 || choice > MenuOptionEnum.values().length) {
                System.out.println("Invalid option. Try again.");
                continue;
            }

            MenuOptionEnum selected = MenuOptionEnum.values()[choice - 1];

            switch (selected) {

                case IMPORT_APPLICANTS -> loadApplicants();
                case SORT_APPLICANTS -> sortApplicants();
                case SEARCH_APPLICANTS -> searchByName();
                case ADD_NEW_EMPLOYEE -> addEmployee();
                case GENERATE_BINARY_TREE -> createBinaryTree();

                case PRINT_TREE_IN_ORDER -> {
                    System.out.println("\n--- Binary Tree (In-Order Traversal) ---");
                    employeeTree.printInOrder();
                }

                case PRINT_TREE_LEVEL_ORDER -> {
                    System.out.println("\n--- Binary Tree (Level-Order Traversal) ---");
                    employeeTree.printLevelOrder();
                }

                case SHOW_TREE_HEIGHT -> {
                    System.out.println("\nTree Height: " + employeeTree.getHeight());
                }

                case SHOW_NODE_COUNT -> {
                    System.out.println("\nTotal Nodes in Tree: " + employeeTree.getNodeCount());
                }

                case EXIT_SYSTEM -> {
                    System.out.println("Exiting system...");
                    return;
                }
            }
        }
    }

    /**
     * Loads applicants from the text file.
     */
    private void loadApplicants() {
        FileReaderService service = new FileReaderService();
        applicants = service.readApplicants();
        System.out.println("\nApplicants loaded: " + applicants.size());
    }

    /**
     * Sorts applicants alphabetically and prints the first 20.
     */
    private void sortApplicants() {
        if (applicants.isEmpty()) {
            System.out.println("No applicants loaded.");
            return;
        }

        applicants = SortingServiceApplicants.sortByName(applicants);
        System.out.println("Applicants sorted successfully.");

        System.out.println("\n--- First 20 Applicants (Sorted Alphabetically) ---");

        for (int i = 0; i < Math.min(20, applicants.size()); i++) {
            System.out.println((i + 1) + ". " + applicants.get(i).getFullName());
        }
    }

    /**
     * Searches for an applicant by name.
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
     * Creates a Binary Tree of Employees.
     */
    private void createBinaryTree() {
        if (applicants.isEmpty()) {
            System.out.println("No applicants loaded.");
            return;
        }

        for (Applicant a : applicants) {

            Manager manager = new Manager(a.getFullName(), ManagerTypeEnum.JUNIOR);
            Department department = new Department(DepartmentType.CUSTOMER_SERVICE.name(), DepartmentType.CUSTOMER_SERVICE);

            Employee emp = new Employee(
                    a.getFullName(),
                    a.getEmail(),
                    manager,
                    department
            );

            employeeTree.insert(emp);
        }

        System.out.println("Binary Tree created successfully.");
    }

    /**
     * VALIDATION: Ask for a valid Manager Type.
     */
    private ManagerTypeEnum askManagerType() {
        while (true) {
            System.out.println("\nSelect Manager Type:");
            for (ManagerTypeEnum type : ManagerTypeEnum.values()) {
                System.out.println("- " + type);
            }

            System.out.print("Enter manager type: ");
            String input = scanner.nextLine().trim().toUpperCase();

            try {
                return ManagerTypeEnum.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid manager type. Please try again.");
            }
        }
    }

    /**
     * VALIDATION: Ask for a valid Department Type.
     */
    private DepartmentType askDepartmentType() {
        while (true) {
            System.out.println("\nSelect Department:");
            for (DepartmentType dept : DepartmentType.values()) {
                System.out.println("- " + dept);
            }

            System.out.print("Enter department: ");
            String input = scanner.nextLine().trim().toUpperCase();

            try {
                return DepartmentType.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid department. Please try again.");
            }
        }
    }

    /**
     * Adds a new employee with full validation.
     */
    private void addEmployee() {

        System.out.println("\n===== ADD NEW EMPLOYEE =====");

        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        ManagerTypeEnum managerType = askManagerType();
        DepartmentType departmentType = askDepartmentType();

        Manager manager = new Manager(fullName, managerType);
        Department department = new Department(departmentType.name(), departmentType);

        Employee employee = new Employee(fullName, email, manager, department);

        applicants.add(new Applicant(
                fullName.split(" ")[0],
                fullName.contains(" ") ? fullName.substring(fullName.indexOf(" ") + 1) : "",
                "N/A",
                email,
                0.0,
                departmentType.name(),
                managerType.name(),
                "N/A",
                "N/A"
        ));

        System.out.println("\nEmployee added successfully:");
        System.out.println(employee);
    }
}
