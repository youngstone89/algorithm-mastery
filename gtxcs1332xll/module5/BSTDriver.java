public class BSTDriver {

    public static void main(String[] args) {
        BST tree = new BST();
        Comparable person1 = new ComparablePerson("Bob", 20);
        tree.add(person1);
        Comparable person2 = new ComparablePerson("kim", 19);
        tree.add(person2);
        Comparable person3 = new ComparablePerson("chin", 21);
        tree.add(person3);
        System.out.println(tree.size());

        tree.remove(person3);

        // traverse
        BSTNode root = tree.getRoot();
        preorderTraversal(root);
        System.out.println(tree.size());

    }

    private static void preorderTraversal(BSTNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        preorderTraversal(root.getLeft());
        preorderTraversal(root.getRight());
    }
}
