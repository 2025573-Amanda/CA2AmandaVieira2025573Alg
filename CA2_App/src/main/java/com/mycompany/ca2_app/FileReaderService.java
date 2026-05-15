/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ca2_app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author home
 */
public class FileReaderService {
    
    // Reads the Applicants_Form file and returns a list of full names.
    public List<String> readApplicantNames() {

        List<String> names = new ArrayList<>();

        try {
            // Locate the Applicants_Form file inside the resources folder.
            File file = new File("src/main/Resources/Applicants_Form - Sample data file for read (2).txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            // Read each line of the file
            while ((line = reader.readLine()) != null) {

                // Split the line by comma
                String[] parts = line.split(",");

                if (parts.length >= 2) {
                    String firstName = parts[0].trim();
                    String lastName = parts[1].trim();

                    // Combine first and last name
                    String fullName = firstName + " " + lastName;

                    // Add to the list
                    names.add(fullName);
                }
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return names;
    }
}

