import java.util.ArrayList;
import java.util.List;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List dataList = new ArrayList<>();

        preorder(dataList, root);
        
        return dataList;
    }

    private void preorder(List<T> list, TreeNode<T> root){
        if (root == null){
            return;
        }
        list.add(root.getData());
        preorder(list, root.getLeft());
        preorder(list, root.getRight());
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List dataList = new ArrayList();
        inorder(dataList,root);
        return dataList;
    }
    private void inorder(List<T> list, TreeNode<T> root){
        if (root == null){
            return;
        }
        inorder(list, root.getLeft());
        list.add(root.getData());
        inorder(list, root.getRight());
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> dataList = new ArrayList();
        postorder(dataList,root);
        return dataList;
    }

    private void postorder(List<T> dataList, TreeNode<T> root) {
        if (root == null){
            return;
        }
        postorder(dataList, root.getLeft());
        postorder(dataList, root.getRight());
        dataList.add(root.getData());
    }
}