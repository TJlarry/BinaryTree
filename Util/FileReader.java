package com.example.demo.Util;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class FileReader {
    private static final String COMMA_DELIMITER = ",";

    String path = "C:\\Users\\akfre\\Downloads\\Lanre\\demo\\src\\main\\java\\com\\example\\demo\\Util\\tree_data.csv";

    public List<List<String>>  getCSVRecords() throws FileNotFoundException {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
        return records;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
