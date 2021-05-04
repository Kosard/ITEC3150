package Homework4Alt;

/**
 * Class: Node
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 4/12/2021
 * <p>
 * This class represents a single node in the tree, this node contains the important Word object as its member variable.
 * <p>
 * Purpose: To show how a custom class connects to a tree via the Node class
 */
public class Node {
    //Instance variables
    Word data;
    Node leftChild;
    Node rightChild;

    //Constructor
    public Node(Word word) {
        this.data = word;
    }
}
