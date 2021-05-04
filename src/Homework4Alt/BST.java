package Homework4Alt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class: BST
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 4/12/2021
 * <p>
 * This class is the shortened framework for the BinarySearchTree implementation. It has methods to read a text file,
 * add nodes to the tree, and print the nodes using recursion.
 * <p>
 * Purpose: To show how to modify a method to check for duplicates while also reading a file and adding nodes based on
 * the text of the file.
 */
public class BST {
    private Node root;

    public BST(){
        root = null;
    }

    /**
     * This method reads the assigned text file and adds nodes to the tree.
     * @param fileName String path to the text file
     */
    public void readFile(String fileName){
        //Initialize Scanner
        Scanner in = null;

        //Try to read file
        try {
            in = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Read only alphabetical words
        in.useDelimiter("[^a-zA-Z]+");

        //While there is still text left, add the lowercase string to a node
        while (in.hasNext()) {
            String lowerCased = in.next().toLowerCase();
            insertText(lowerCased);
        }
    }

    /**
     * This method adds a Node into the tree
     *
     * @param node  String that will become the key in the new Node
     * @param textWord LinkedList that will be populated with new unique Nodes
     * @return Node used to recursively traverse tree
     */
    public Node insert(Node node, String textWord) {
        //Create Word object to compare
        Word word = new Word(textWord);

        //If node with textword does not exist, create a new one
        if (node == null){
            node = new Node(word);
        } else {
            //Compare Word objects to see if node goes on the left of tree
            if (word.compareTo(node.data) < 0){
                node.leftChild = insert(node.leftChild, textWord);
            }

            //Compare Word objects to see if node goes on the right of tree
            else if (word.compareTo(node.data) > 0){
                node.rightChild = insert(node.rightChild, textWord);
            }

            //Update count of current node since it already exists
            else {
                node.data.setCount(node.data.getCount() + 1);
            }
        }
        return node;
    }

    /**
     * This a wrapper method for the root of the tree
     * @param text String used to create root node
     */
    public void insertText(String text){
        //Call to insert method for root node
        root = insert(root, text);
    }

    /**
     * This method prints all the nodes in the tree starting with root
     */
    public void printTree() {
        printNodes(root);
    }

    /**
     * This method recursively prints each node in the tree in a readable format
     * @param node Node object used to traverse each node and print their left and right children
     */
    public void printNodes(Node node) {
        //Format used to print to console
        String format = "%-15s %5s %n";

        //Recursive printing
        if (node != null){
            printNodes(node.leftChild);
            System.out.printf(format, node.data.getaWord(), node.data.getCount());
            printNodes(node.rightChild);
        }
    }

    /**
     * This method prints the header to the console in a readable format
     */
    public void printHeader(){
        String format = "%-15s %5s %n";
        System.out.printf(format, "Word", "Count");
    }
}
