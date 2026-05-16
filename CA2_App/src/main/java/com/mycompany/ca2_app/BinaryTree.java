/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2_app;

/**
 *
 * @author home
 * * Represents a Binary Search Tree (BST) used to store Employee objects.
 * The tree is ordered alphabetically by the employee's full name.
 *
 * Supports:
 * - Inserting employees
 * - In-order traversal (alphabetical print)
 */
public class BinaryTree {
    // Root node of the tree
    private TreeNode root;

    /**
     * Inserts a new employee into the Binary Search Tree.
     *
     * @param employee The employee to insert
     */
    public void insert(Employee employee) {
        root = insertRecursive(root, employee);
    }

    /**
     * Recursive insertion method.
     *
     * @param current  The current node in the tree
     * @param employee The employee to insert
     * @return Updated node after insertion
     */
    private TreeNode insertRecursive(TreeNode current, Employee employee) {

        // Base case: empty position found
        if (current == null) {
            return new TreeNode(employee);
        }

        // Compare names alphabetically
        int comparison = employee.getFullName()
                .compareToIgnoreCase(current.getEmployee().getFullName());

        if (comparison < 0) {
            // Insert into left subtree
            current.setLeft(insertRecursive(current.getLeft(), employee));
        } else if (comparison > 0) {
            // Insert into right subtree
            current.setRight(insertRecursive(current.getRight(), employee));
        }
        // If equal, do nothing (no duplicates allowed)

        return current;
    }

    /**
     * Prints all employees in alphabetical order using in-order traversal.
     */
    public void printInOrder() {
        printInOrderRecursive(root);
    }

    /**
     * Recursive in-order traversal.
     *
     * @param node The current node
     */
    private void printInOrderRecursive(TreeNode node) {
        if (node == null) return;

        printInOrderRecursive(node.getLeft());
        System.out.println(node.getEmployee());
        printInOrderRecursive(node.getRight());
    }
}

