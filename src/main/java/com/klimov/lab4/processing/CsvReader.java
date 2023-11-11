package com.klimov.lab4.processing;

import com.klimov.lab4.entities.Department;
import com.klimov.lab4.entities.Person;
import com.klimov.lab4.enums.Gender;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * CsvReader class is responsible for parsing CSV files containing information
 * about persons and their departments. It uses OpenCSV library for parsing.
 * @author s.a.klimov
 */
public class CsvReader {
    /**
     * Flag indicating whether the CSV file has been parsed.
     */
    private boolean fileParsed;

    /**
     * The path to the CSV file to be parsed.
     */
    private String filePath = "src/main/resources/foreign_names.csv";

    /**
     * The field separator used in the CSV file.
     */
    private char fieldSeparator = ';';

    /**
     * List to store the parsed persons.
     */
    private LinkedList<Person> personList = new LinkedList<>();

    /**
     * Set to store unique departments.
     */
    private HashSet<Department> departmentSet = new HashSet<>();

    /**
     * CSV parser using OpenCSV library with the specified field separator.
     */
    private CSVParser csvParser = new CSVParserBuilder().withSeparator(fieldSeparator).build();

    /**
     * Parses the CSV file and populates the personList and departmentSet.
     *
     * @throws IOException            if an I/O error occurs.
     * @throws CsvValidationException if a CSV validation error occurs.
     */
    public void parseCsv() throws IOException, CsvValidationException {
        if (fileParsed) {
            System.out.println("The file was already parsed");
            return;
        }

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(csvParser)
                .withSkipLines(1)
                .build()) {

            if (reader == null) {
                throw new FileNotFoundException(filePath);
            }

            String[] line;
            while ((line = reader.readNext()) != null) {
                Department division = findOrCreateDepartment(line[4]);
                Gender gender = parseGender(line[2]);

                Person person = new Person(
                        Integer.parseInt(line[0]),
                        line[1],
                        gender,
                        division,
                        Double.parseDouble(line[5]),
                        line[3]
                );
                personList.add(person);
            }
        }
        fileParsed = true;
    }

    /**
     * Finds or creates a department based on the given name.
     *
     * @param name The name of the department.
     * @return The Department object.
     */
    private Department findOrCreateDepartment(String name) {
        for (Department department : departmentSet) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        Department newDepartment = new Department(name);
        departmentSet.add(newDepartment);
        return newDepartment;
    }

    /**
     * Parses the gender string and returns the corresponding Gender enum.
     *
     * @param genderString The string representation of gender.
     * @return The Gender enum.
     */
    private Gender parseGender(String genderString) {
        return "Male".equalsIgnoreCase(genderString) ? Gender.Male : Gender.Female;
    }

    /**
     * Prints the parsed CSV data to the console.
     */
    public void printParsedCsv() {
        if (fileParsed) {
            for (Person person : personList) {
                System.out.println(person.toString());
            }
        } else {
            System.out.println("The file was not parsed yet");
        }
    }

    /**
     * Gets a copy of the list of parsed persons.
     *
     * @return A copy of the list of parsed persons.
     */
    public LinkedList<Person> getPersonList() {
        return new LinkedList<>(personList);
    }
}
