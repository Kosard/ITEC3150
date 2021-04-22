package Homework4;

/**
 * Class: TEST.Node
 *
 * @author Kevin Figueroa
 * @version 1.0
 * Course: ITEC 3150 Spring 2021
 * Date Written: 4/12/2021
 * <p>
 * This class: now describe what the class does
 * <p>
 * Purpose: Describe the purpose of this class
 */
public class Node {
    Word data;
    Node leftChild;
    Node rightChild;

    public Node(Word word) {
        this.data = word;
    }

    @Override
    public String toString() {
        return "word=" + data.getaWord() + ", count=" + data.getCount();
    }
}
