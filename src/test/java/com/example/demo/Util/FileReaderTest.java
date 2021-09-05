package com.example.demo.Util;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class FileReaderTest {

    public FileReader fileReader = new FileReader();

    @Test
    public void getCSVRecords() throws FileNotFoundException {

        List<List<String>> csvRecords = fileReader.getCSVRecords();
        List<String> strings = csvRecords.stream().flatMap(Collection::stream).collect(Collectors.toList());

      for(int i=2; i<strings.size(); i++){
          String str = strings.get(i);
          Pattern p = Pattern.compile("description [0-9]+");
          Matcher matcher = p.matcher(str);
          if (matcher.find()) {
              String group = matcher.group();

              System.out.println(group.split(" ")[1]); // second matched digits
          }
      }
    }
}