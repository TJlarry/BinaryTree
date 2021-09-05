package com.example.demo;

import com.example.demo.Util.FileReader;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeService {
    private final FileReader fileReader;
    private final BinaryTree binaryTree;
    private final Gson gson;

    public TreeService(FileReader fileReader, BinaryTree binaryTree, Gson gson) {
        this.fileReader = fileReader;
        this.binaryTree = binaryTree;
        this.gson = new Gson();
    }

    public String getTree() throws FileNotFoundException {
        List<List<String>> csvRecords = fileReader.getCSVRecords();

        List<String> strings = csvRecords.stream().flatMap(Collection::stream).collect(Collectors.toList());

        for(int i=2; i<strings.size(); i++){
            String str = strings.get(i);
            String[] stringArray = str.split(" ");
            binaryTree.insert(Integer.parseInt(String.valueOf(stringArray[3].charAt(1))));
        }

        return gson.toJson(binaryTree.inorder(), List.class);
    }
}
