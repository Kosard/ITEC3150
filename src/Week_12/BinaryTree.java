package Week_12;

/**
 * Class: BinaryTree
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
public class BinaryTree {
    Node root;

    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();

        theTree.addNode(50, "Boss");
        theTree.addNode(25, "Vice President");
        theTree.addNode(15, "Office Manager");
        theTree.addNode(2, "Intern");
        theTree.addNode(18, "Data Entry");
        theTree.addNode(30, "Secretary");
        theTree.addNode(75, "Sale Manager");
        theTree.addNode(85, "Salesman 1");

        System.out.println("In Order");
        theTree.inOrderTraverseTree(theTree.root);

        System.out.println("\nPre Order");
        theTree.preOrderTraverseTree(theTree.root);

        System.out.println("\nPost Order");
        theTree.postOrderTraverseTree(theTree.root);

        System.out.println("\nSearch for 30");
        System.out.println(theTree.findNode(30));

        System.out.println("\nRemoving key 25....");
        theTree.remove(25);
        theTree.preOrderTraverseTree(theTree.root);
    }

    public Node findNode(int key) {
        Node focusNode = root;

        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);

            System.out.println(focusNode);

            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);

            preOrderTraverseTree(focusNode.leftChild);

            preOrderTraverseTree(focusNode.rightChild);
        }

    }

    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);

            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);
        }
    }

    public boolean remove(int key) {
        Node focusNode = root;
        Node parent = root;

        boolean isItALeftChild = true;

        while (focusNode.key != key) {
            parent = focusNode;

            if (key < focusNode.key) {
                isItALeftChild = true;

                focusNode = focusNode.leftChild;
            } else {
                isItALeftChild = false;

                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return false;
            }
        }
        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root) {
                root = null;
            } else if (isItALeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (focusNode.rightChild == null) {
            if (focusNode == root) {
                root = focusNode.leftChild;
            } else if (isItALeftChild) {
                parent.leftChild = focusNode.leftChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        } else if (focusNode.leftChild == null) {
            if (focusNode == root) {
                root = focusNode.rightChild;
            } else if (isItALeftChild) {
                parent.leftChild = focusNode.rightChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        } else {
            Node replacement = getReplacementNode(focusNode);

            if (focusNode == root) {
                root = replacement;
            } else if (isItALeftChild) {
                parent.leftChild = replacement;
            } else {
                parent.rightChild = replacement;
            }
            replacement.leftChild = focusNode.leftChild;
        }
        return true;
    }

    private Node getReplacementNode(Node replaceableNode) {
        Node replacementParent = replaceableNode;
        Node replacement = replaceableNode;

        Node focusNode = replaceableNode.rightChild;

        while (focusNode != null) {
            replacementParent = replacement;

            replacement = focusNode;

            focusNode = focusNode.leftChild;
        }

        if (replacement != replaceableNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replaceableNode.rightChild;
        }
        return replacement;
    }

    public void addNode(int key, String name) {
        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;

            Node parent;

            while (true) {
                parent = focusNode;

                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
}

class Node {
    int key;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " has a key " + key;
    }

    public int sumAll(Node x, int num) {
        int sum = 0;
        if (x == null) {
            return sum;
        }
        //Preorder
        sum += num + x.key;

        sum += sumAll(x.leftChild, num);

        sum += sumAll(x.rightChild, num);

        return sum;
    }

}
