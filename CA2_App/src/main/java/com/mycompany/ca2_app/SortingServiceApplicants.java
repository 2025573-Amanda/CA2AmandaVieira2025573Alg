/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2_app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class provides sorting algorithms for Applicant objects.
 * It includes:
 * - Recursive Merge Sort (required by the assignment)
 * - Non-recursive sorting by salary and department
 */
public class SortingServiceApplicants {

    /**
     * Sorts a list of Applicants by full name using recursive Merge Sort.
     * This is the required recursive algorithm for the assignment.
     */
    public static List<Applicant> sortByName(List<Applicant> list) {
        if (list.size() <= 1) return list; // Base case

        int mid = list.size() / 2;

        // Recursive calls
        List<Applicant> left = sortByName(list.subList(0, mid));
        List<Applicant> right = sortByName(list.subList(mid, list.size()));

        // Merge the two sorted halves
        return mergeByName(left, right);
    }

    /**
     * Merges two sorted lists of Applicants based on full name.
     */
    private static List<Applicant> mergeByName(List<Applicant> left, List<Applicant> right) {
        List<Applicant> result = new ArrayList<>();
        int i = 0, j = 0;

        // Compare elements from both lists
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getFullName().compareToIgnoreCase(right.get(j).getFullName()) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        // Add remaining elements
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }

    /**
     * Sorts Applicants by salary (non-recursive).
     */
    public static List<Applicant> sortBySalary(List<Applicant> list) {
        list.sort(Comparator.comparingDouble(Applicant::getSalary));
        return list;
    }

    /**
     * Sorts Applicants by department (non-recursive).
     */
    public static List<Applicant> sortByDepartment(List<Applicant> list) {
        list.sort(Comparator.comparing(Applicant::getDepartment));
        return list;
    }
}
