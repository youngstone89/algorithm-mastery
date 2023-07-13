// Time complexity : O(h), where h is the height of BST
// height means the # of nodes to traverse to reach root from leaf node
// Space complexity : O(h), maximum amount of space to store the recursion stack
public class BinarySearchTreeSearch {
    Node root;

    public static void main(String[] args) {
        BinarySearchTreeSearch tree = new BinarySearchTreeSearch();
        tree.root = new Node(6);
        tree.root.left = new Node(3);
        tree.root.right = new Node(9);
        System.out.println(tree.Search(3));
        System.out.println(tree.Search(9));
    }

    private boolean Search(int i) {
        boolean result = false;
        result = search(root, i);
        return result;
    }

    private boolean search(Node root, int i) {
        boolean result = false;
        if (root == null) {
            return result;
        }
        if (i < root.data) {
            result = search(root.left, i);
        } else if (i > root.data) {
            result = search(root.right, i);
        } else {
            result = true;
        }
        return result;
    }
}
