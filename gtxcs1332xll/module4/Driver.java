import java.util.List;

public class Driver<T> {
    public static void main(String[] args){
        
        TreeNode root = new TreeNode(50);

        TreeNode node25 = new TreeNode(25);
        root.setLeft(node25);

        TreeNode node10 = new TreeNode(10);
        node25.setLeft(node10);
        
        TreeNode node100 = new TreeNode(100);
        root.setRight(node100);

        TreeNode node75 = new TreeNode(75);
        node100.setLeft(node75);

        TreeNode node125 = new TreeNode(125);
        node100.setRight(node125);

        TreeNode node110 = new TreeNode(110);
        node125.setRight(node110);

        
        Traversals traversals = new Traversals<>();
        
        List dataList = traversals.preorder(root);
        for (Object data : dataList) {
            System.out.println(data);
        }
    }
    
}
