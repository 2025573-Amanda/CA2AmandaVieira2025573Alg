/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2_app;

import java.util.List;

/**
 * Provides recursive and non-recursive searching algorithms for Applicants.
 */
public class SearchingServiceApplicants {

    /** Recursive Binary Search by full name. */
    public static int searchByName(List<Applicant> list, String target, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        String midName = list.get(mid).getFullName().toLowerCase();

        int cmp = target.compareTo(midName);

        if (cmp == 0) return mid;
        else if (cmp < 0) return searchByName(list, target, low, mid - 1);
        else return searchByName(list, target, mid + 1, high);
    }

    /** Linear search by email. */
    public static Applicant searchByEmail(List<Applicant> list, String email) {
        for (Applicant a : list) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                return a;
            }
        }
        return null;
    }

    /** Linear search by department. */
    public static List<Applicant> searchByDepartment(List<Applicant> list, String department) {
        return list.stream()
                .filter(a -> a.getDepartment().equalsIgnoreCase(department))
                .toList();
    }
}

