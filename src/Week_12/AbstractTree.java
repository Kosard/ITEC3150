package Week_12;

/**
 * Class: AbstractTree
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
public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    /** Inorder traversal from the root*/
    public void inorder() {
    }

    @Override
    /** Postorder traversal from the root */
    public void postorder() {
    }

    @Override
    /** Preorder traversal from the root */
    public void preorder() {
    }

    @Override
    /** Return true if the tree is empty */
    public boolean isEmpty() {
        return getSize() == 0;
    }
}
