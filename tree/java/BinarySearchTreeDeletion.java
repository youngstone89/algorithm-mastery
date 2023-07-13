
// BST class to operate deletion on Tree
public class BinarySearchTreeDeletion {
    private Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }
        return root;
    }

    // inorder traversal
    public void inorderTraversal() {
        // traverse left subtree
        // visit root
        // traverse right subtree
        inorderTraversal(root);
    }

    // left - center - right
    private void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTreeDeletion tree = new BinarySearchTreeDeletion();
        tree.insert(100);
        tree.insert(200);
        tree.inorderTraversal();
    }
}
