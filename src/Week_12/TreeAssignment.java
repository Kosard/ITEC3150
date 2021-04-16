package Week_12;

/**
 * Class: TreeAssignment
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 4/6/2021
 * <p>
 * This class: This is a driver class, which means it contains the main method.
 * <p>
 * Purpose: To call methods from the blueprint class in order to visually show a binary tree
 */

public class TreeAssignment {
    // DO NOT CHANGE LINES IN MAIN- YOU MAY ADD AT BOTTOM BUT NOT REMOVE ANY LINES
    public static void main(String[] args) {
        // create int tree with 10 random elements
        // you may make this smaller for testing
        IntTree theTree = new IntTree(3);

        // print the tree
        theTree.printStructure();

        // call already developed routine to count even branches - this
        // counts branches with even nodes, not even leaf nodes
        int evenCount = theTree.countEvenBranches();
        System.out.println("There are " + evenCount + " even branches");

        // call user developed routine to count left Nodes
        int leftNodes = theTree.countLeftNodes();
        System.out.println("The number of left nodes is " + leftNodes);

        // call second user developed routine to sum the values of all the integers in the tree
        int totalSum = theTree.sumNodes();
        System.out.println("The total sum is " + totalSum);

    }

}
