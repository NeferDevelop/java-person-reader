package com.klimov.lab4;

import com.klimov.lab4.entities.Person;
import com.klimov.lab4.processing.CsvReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author s.a.klimov
 */
public class CsvReaderTest {

    /**
     * The CsvReader instance to be used in test cases.
     */
    private CsvReader csvReader;

    /**
     * Set up the CsvReader instance before each test case.
     */
    @BeforeEach
    void setUp() {
        csvReader = new CsvReader();
    }

    /**
     * Test case to ensure that CsvReader can parse CSV data successfully.
     *
     * @throws IOException            If an I/O error occurs.
     * @throws CsvValidationException If a CSV validation error occurs.
     */
    @Test
    void parseCsv_shouldParseAllData() throws IOException, CsvValidationException {
        csvReader.parseCsv();

        // Retrieve the list of Person objects parsed from the CSV
        LinkedList<Person> personList = csvReader.getPersonList();

        // Ensure that the list is not empty
        assertFalse(personList.isEmpty());

        // Check each Person object in the list for non-null values
        for (Person person : personList) {
            assertNotNull(person.getId(), "Person ID should not be null");
            assertNotNull(person.getName(), "Person name should not be null");
            assertNotNull(person.getGender(), "Person gender should not be null");
            assertNotNull(person.getSalary(), "Person salary should not be null");
        }
    }
}
