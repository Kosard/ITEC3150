package Homework4Alt;

/**
 * Class: BSTDriver
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 4/12/2021
 * <p>
 * This class is a driver class, meaning it only contains either initialization of other classes and/or calls to methods
 * from other classes.
 * <p>
 * Purpose: To show how to print a tree in a readable format
 */
public class BSTDriver {
    public static void main(String[] args) {
        BST myTree = new BST();
        myTree.readFile("C:\\Users\\kevin\\IdeaProjects\\ITEC3150\\src\\Homework4\\CarlAndTheCottonGin");

        myTree.printHeader();
        myTree.printTree();
    }
}
