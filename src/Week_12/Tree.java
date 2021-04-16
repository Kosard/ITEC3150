package Week_12;

/**
 * Class: Tree
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
public interface Tree<E> extends Iterable<E> {
    /**
     * Return true if the element is in the tree
     */
    public boolean search(E e);

    /**
     * Insert element o into the binary tree
     * Return true if the element is inserted successfully
     */
    public boolean insert(E e);

    /**
     * Delete the specified element from the tree
     * Return true if the element is deleted successfully
     */
    public boolean delete(E e);

    /**
     * Inorder traversal from the root
     */
    public void inorder();

    /**
     * Postorder traversal from the root
     */
    public void postorder();

    /**
     * Preorder traversal from the root
     */
    public void preorder();

    /**
     * Get the number of nodes in the tree
     */
    public int getSize();

    /**
     * Return true if the tree is empty
     */
    public boolean isEmpty();
}
