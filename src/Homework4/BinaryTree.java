package Homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class: BinaryTree
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 4/12/2021
 * <p>
 * This class:
 * <p>
 * Purpose:
 */
public class BinaryTree {
    //private fields
    private Node root;
    private LinkedList<Word> wordList = new LinkedList<>();

    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();

        theTree.readFile();

        theTree.reverseSort();

        theTree.printLinkedList();
    }

    /**
     * This method calls the sort method from the Collections class. Due to the implementation of the compareTo method
     * in the Word class, the list gets sorted in reverse order (z at the top, a at the bottom)
     */
    public void reverseSort() {
        //Call to sort method
        Collections.sort(wordList);
    }

    /**
     * This method prints the linked list in a readable format
     */
    public void printLinkedList() {
        String format = "%-15s %5s %n";
        System.out.printf(format, "Word", "Count");
        for (Word w : wordList) {
            System.out.printf(format, w.getaWord(), w.getCount());
        }
    }

    /**
     * This method reads the assigned text files and adds nodes to the tree. It also adds the same nodes to a
     * linked list
     */
    public void readFile() {
        //Initialize Scanner
        Scanner in = null;

        //Try to read text file
        try {
            in = new Scanner(new File("C:\\Users\\kevin\\IntelliJIDEAProjects\\ITEC3150\\src\\Homework4\\CarlAndTheCottonGin.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Iterate through the text file
        while (in.hasNext()) {
            //Take the current line, trim, and replace all numbers and symbols with a blank space so it can be easy to split
            String currentLine = in.nextLine().replaceAll("[0-9]|_*_|\\W+", " ").trim();

            //Take the leftover blank spaces inside the current line and replace it with a single blank space
            currentLine = currentLine.replaceAll(" +", " ");

            //Check to see if current line is an empty line
            if (currentLine.length() == 0) {
                continue;
            } else {
                //Split current line into array
                String[] splitLine = currentLine.split(" ");

                //Add nodes to the tree and the linked list
                for (String s : splitLine) {
                    addNode(s, wordList);
                }
            }
        }

        //Close scanner
        in.close();
    }

    /**
     * This method iterates through the all the nodes in the tree until it finds the
     * node with the specified key
     *
     * @param key word that is to be searched in all nodes
     * @return Node object from tree if key is found
     */
    public Node findNode(String key) {
        //Set root as current node
        Node focusNode = root;

        //Iterate through tree for as long as there isn't a match
        while (!focusNode.data.getaWord().equals(key)) {
            //if word is less than key parameter, focus on left child
            if (key.compareTo(focusNode.data.getaWord()) < 0) {
                focusNode = focusNode.leftChild;
            } else {
                //turn focus to right child
                focusNode = focusNode.rightChild;
            }

            //If none found
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    /**
     * This method traverses through the tree in an "InOrder" fashion from the current node
     *
     * @param focusNode current Node being traversed
     */
    public void inOrderTraverseTree(Node focusNode) {
        //InOrder: LNR
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);

            System.out.println(focusNode);

            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    /**
     * This method traverses through the tree in a "PreOrder" fashion from the current node
     *
     * @param focusNode current Node being traversed
     */
    public void preOrderTraverseTree(Node focusNode) {
        //PreOrder: NLR
        if (focusNode != null) {
            System.out.println(focusNode);

            preOrderTraverseTree(focusNode.leftChild);

            preOrderTraverseTree(focusNode.rightChild);
        }

    }

    /**
     * This method traverses through the tree in a "PostOrder" fashion from the current node
     *
     * @param focusNode current Node being traversed
     */
    public void postOrderTraverseTree(Node focusNode) {
        //Post Order: LRN
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);

            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }

    /**
     * This method removes a node from the tree.
     *
     * @param key Key to be deleted
     * @return true if node was deleted successfully, false if is not in the tree
     */
    public boolean remove(String key) {
        //Start at the top of tree
        Node focusNode = root;
        Node parent = root;

        //When searching for a Node, this will show whether to search to right or left
        boolean isItALeftChild = true;

        //While keys don't match, keep searching
        while (!focusNode.data.getaWord().equals(key)) {
            parent = focusNode;

            //If key is less than focus node....
            if (key.compareTo(focusNode.data.getaWord()) < 0) {
                isItALeftChild = true;

                //Shift focus to left child
                focusNode = focusNode.leftChild;
            } else {
                //Key is greater than focus node, so search right
                isItALeftChild = false;

                //Shift focus to right node
                focusNode = focusNode.rightChild;
            }

            //Node wasn't found
            if (focusNode == null) {
                return false;
            }
        }

        //If node doesn't have children, delete it
        if (focusNode.leftChild == null && focusNode.rightChild == null) {

            //Remove root
            if (focusNode == root) {
                root = null;
            }

            //If marked as left child of parent, delete it from parent node
            else if (isItALeftChild) {
                parent.leftChild = null;
            }

            //Vice versa for the right child
            else {
                parent.rightChild = null;
            }
        }

        //If no right child
        else if (focusNode.rightChild == null) {
            if (focusNode == root) {
                root = focusNode.leftChild;
            }

            //If focus node was on left of parent, move focus node's left child up to parent node
            else if (isItALeftChild) {
                parent.leftChild = focusNode.leftChild;
            }

            //Vice versa for right child
            else {
                parent.rightChild = focusNode.leftChild;
            }
        }

        //If no left child...
        else if (focusNode.leftChild == null) {
            if (focusNode == root) {
                root = focusNode.rightChild;
            }

            //If focus node was on left of parent, move focus node's right child up to parent node
            else if (isItALeftChild) {
                parent.leftChild = focusNode.rightChild;
            }

            //Vice versa for left child
            else {
                parent.rightChild = focusNode.rightChild;
            }
        }

        // 2 Children so, need to find replacement for deleted nodes
        else {
            Node replacement = getReplacementNode(focusNode);

            // If focus is on root, replace root with replacement
            if (focusNode == root) {
                root = replacement;
            }

            // If deleted node was a left child, assign replacement to left child
            else if (isItALeftChild) {
                parent.leftChild = replacement;
            }

            // Vice versa for right child
            else {
                parent.rightChild = replacement;
            }
            replacement.leftChild = focusNode.leftChild;
        }
        return true;
    }

    /**
     * This method finds the Node that will replace the deleted Node
     *
     * @param replaceableNode Node that is a candidate to replace the deleted Node
     * @return best candidate Node that will replace old node
     */
    private Node getReplacementNode(Node replaceableNode) {
        Node replacementParent = replaceableNode;
        Node replacement = replaceableNode;
        Node focusNode = replaceableNode.rightChild;

        // While there are no more left children
        while (focusNode != null) {
            replacementParent = replacement;

            replacement = focusNode;

            focusNode = focusNode.leftChild;
        }

        // If replacement isn't the right child, move replacement into parent's left child field and move replaced node's
        // right child into the replacement's right child.
        if (replacement != replaceableNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replaceableNode.rightChild;
        }
        return replacement;
    }

    /**
     * This method adds a Node into the tree
     *
     * @param key  String that will become the key in the new Node
     * @param list LinkedList that will be populated with new unique Nodes
     */
    public void addNode(String key, LinkedList<Word> list) {
        //Create new Node using lowercase key
        String lowerCased = key.toLowerCase();
        Node newNode = new Node(new Word(lowerCased));

        //Check if there is root node and add to list
        if (root == null) {
            root = newNode;
            list.add(newNode.data);
        } else {
            //Locate parent node
            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;

                //If key matches with focus Node, add 1 to count
                if (newNode.data.getaWord().equals(parent.data.getaWord())) {
                    parent.data.setCount(parent.data.getCount() + 1);
                    return;
                }

                //Check if param key is less than the key(word) in focus node
                if (lowerCased.compareTo(focusNode.data.getaWord()) < 0) {
                    //Focus on left child of current Node
                    focusNode = focusNode.leftChild;

                    //If focus node (left child) doesn't exist...
                    if (focusNode == null) {
                        //Assign newNode to leftChild field of parent Node
                        parent.leftChild = newNode;

                        //Add to list
                        list.add(parent.leftChild.data);
                        return;
                    }
                } else {
                    //Focus on right child of current Node
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        //Assign new Node to rightChild field of parent Node
                        parent.rightChild = newNode;

                        //Add to list
                        list.add(parent.rightChild.data);
                        return;
                    }
                }
            }
        }
    }
}