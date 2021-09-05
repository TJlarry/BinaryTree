package com.example.demo;

import com.example.demo.Util.FileReader;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class TreeService {
    private final FileReader fileReader;
    private final BinaryTree binaryTree;

    public TreeService(FileReader fileReader, BinaryTree binaryTree) {
        this.fileReader = fileReader;
        this.binaryTree = binaryTree;
    }

    public List<Integer> getTree() throws FileNotFoundException {
        List<List<String>> csvRecords = fileReader.getCSVRecords();

        List<String> strings = csvRecords.stream().flatMap(Collection::stream).collect(Collectors.toList());

        for(int i=0; i<strings.size(); i++){
            String str = strings.get(i);
            Pattern p = Pattern.compile("description [0-9]+");
            Matcher matcher = p.matcher(str);
            if (matcher.find()) {
                String group = matcher.group();
                binaryTree.insert(Integer.parseInt(group.split(" ")[1])); // second matched digits
            }
        }
        return binaryTree.inorder();
    }
}
