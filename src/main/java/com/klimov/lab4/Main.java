package com.klimov.lab4;

import com.klimov.lab4.processing.CsvReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;


/**
 * @author s.a.klimov
 */
public class Main {
    public static void main(String[] args) {
        CsvReader reader = new CsvReader();
        try {
            reader.parseCsv();
            reader.printParsedCsv();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}

