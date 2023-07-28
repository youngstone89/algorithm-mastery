class MaximumDepthTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        MaximumDepthTree mdt = new MaximumDepthTree();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        System.out.println(mdt.maxDepth(root));
    }
}