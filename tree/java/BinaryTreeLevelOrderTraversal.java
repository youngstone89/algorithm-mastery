import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        if (root == null)
            return res;

        q.add(root);
        // each iteration per level
        while (!q.isEmpty()) {

            // length for iteration per level
            int length = q.size();
            // sublist per level
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = q.poll();
                subList.add(node.data);

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            // add level sublist to response list
            res.add(subList);
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 0
         * / \
         * 1 3
         * /
         * 2
         */
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        System.out.println(BinaryTreeLevelOrderTraversal.levelOrderTraversal(root));
    }
}
