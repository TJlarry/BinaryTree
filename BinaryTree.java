package com.example.demo;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BinaryTree {

    private Node root;
    private List<Integer> result = new ArrayList<>();

    BinaryTree()
    {
        root = null;
    }

    public void insert(int key)
    {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key)
    {
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    public List<Integer> inorder()
    {
        return inorderRec(root);
    }

    public List<Integer> inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            result.add(root.key);
            inorderRec(root.right);
        }
        return result;
    }


    @Getter
    class Node{
        public Integer key;
        public Node left;
        public Node right;

        Node(Integer key) {
            this.key = key;
        }
    }
}
