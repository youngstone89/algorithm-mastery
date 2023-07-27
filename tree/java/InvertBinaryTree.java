class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree ibt = new InvertBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        ibt.invert(root);
        ibt.preorderTraversal(root);
    }

    private void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    private void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);
    }
}
