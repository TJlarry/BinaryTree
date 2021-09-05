package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileNotFoundException;

@Controller
public class TreeController {

    private final TreeService treeService;

    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @GetMapping("/tree")
    public String getTree() throws FileNotFoundException {
        return treeService.getTree();
    }
}
