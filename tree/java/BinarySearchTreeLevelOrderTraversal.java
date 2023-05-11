import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Item {
    Node node;
    int depth;

    Item(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

public class BinarySearchTreeLevelOrderTraversal {

    Node root;

    int findMinDepth() {
        return findMinDepth(root);
    }

    private int findMinDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Item> queue = new LinkedList<>();
        Item item = new Item(root, 1);
        queue.add(item);
        while (!queue.isEmpty()) {
            item = queue.peek();
            queue.remove();
            Node node = item.node;
            int depth = item.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                item.node = node.left;
                item.depth = depth + 1;
                queue.add(item);
            }
            if (node.right != null) {
                item.node = node.right;
                item.depth = depth + 1;
                queue.add(item);
            }
        }

        return 0;
    }

    static Node newNode(int data) {
        Node temp = new Node(data);
        return temp;
    }

    public static void main(String[] args) {

        BinarySearchTreeLevelOrderTraversal tree = new BinarySearchTreeLevelOrderTraversal();
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        System.out.println("Mininum depth of the tree is " + tree.findMinDepth());
    }
}
