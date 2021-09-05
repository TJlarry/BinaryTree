package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class BinaryTreeTest {

    @Test
    public void insert(){
        BinaryTree binaryTree = new BinaryTree();
        List<Integer> integers = Stream.of(1, 3, 4, 5, 6).collect(Collectors.toList());
        integers.forEach(binaryTree::insert);

    }

}