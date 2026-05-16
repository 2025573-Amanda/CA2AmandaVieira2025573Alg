/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2_app;

/**
 * Represents a single node in the Binary Tree.
 * Each node stores:
 * - An Employee object
 * - A reference to the left child
 * - A reference to the right child
 * This class is used by the BinaryTree class.
 */
/**
 *
 * @author home
 */
public class TreeNode {
    // The employee stored in this node
    private Employee employee;

    // Left child node
    private TreeNode left;

    // Right child node
    private TreeNode right;

    /**
     * Constructor to create a new TreeNode.
     *
     * @param employee The employee object stored in this node
     */
    public TreeNode(Employee employee) {
        this.employee = employee;
        this.left = null;
        this.right = null;
    }

    public Employee getEmployee() {
        return employee;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

