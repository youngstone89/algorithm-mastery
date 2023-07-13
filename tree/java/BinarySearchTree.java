// Recursive

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    public int FindMinDepth() {

        return findMinDepth(root);
    }

    private int findMinDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return findMinDepth(root.right) + 1;
        }
        if (root.right == null) {
            return findMinDepth(root.left) + 1;
        }

        return Math.min(findMinDepth(root.left), findMinDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("the minimum depth of the tree is " + tree.FindMinDepth());
        /*
         * 1
         * / \
         * 2 3
         * / \
         * 4 5
         */

    }
}
