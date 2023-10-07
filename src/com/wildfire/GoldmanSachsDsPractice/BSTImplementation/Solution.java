package com.wildfire.GoldmanSachsDsPractice.BSTImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        final BST searchTree = new BST();

        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);
        if(Arrays.asList(1,2,3,5).equals(searchTree.InOrderTraversal())
                && !searchTree.contains(0)
                && searchTree.contains(1)
                && searchTree.contains(2)
                && searchTree.contains(3)
                && !searchTree.contains(4)
                && searchTree.contains(5)
                && !searchTree.contains(6)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
    }

    static class BST{

        //each leaf of the tree will represent the node class object
        private  static class Node{
            Integer value;
            Node left;
            Node right;
        }

        //root node of the tree - starting point of tree
        private Node root;

       //Constructor
        public BST() {
            this.root = new Node();
        }

        //add node with value in tree
        public void put(int val){
            putInTree(root, val);
        }

        // Get tree root from this class and get parameterized node value from put method
        private void putInTree(Node node, int val){
            if(node.value == null){
                node.value = val;
                return;
            }

            if(node.value < val){
                if(node.right == null){
                    Node p = new Node();
                    node.right = p;
                    p.value = val;
                    return;
                }
                else{
                    putInTree(node.right, val);
                }
            }
            else{
                if(node.left == null){
                    Node p = new Node();
                    node.left = p;
                    p.value = val;
                    return;
                }
                else{
                    putInTree(node.left, val);
                }
            }
        }

        //Sub method to find a value exist in tree
        // with reference of node value of root of the tree
        private Boolean findVal(Node node, int value){
            if(node == null)
                return false;
            if(node.value == value)
                return true;

            return (findVal(node.left, value) || findVal(node.right, value));
        }

        //Find a value exist in tree or not
        private Boolean contains(int val){
            return findVal(root, val);
        }

        //In Order traversal of the BST
        public List<Integer> InOrderTraversal(){
            final ArrayList<Integer> inOrderTraversedArr = new ArrayList<>();
            inOrderTraversal(root, inOrderTraversedArr);
            return inOrderTraversedArr;
        }

        private void inOrderTraversal(Node root, ArrayList<Integer> acc){
            if(root == null)
                return;

            inOrderTraversal(root.left, acc);
            acc.add(root.value);
            inOrderTraversal(root.right,acc);

        }
    }
}
