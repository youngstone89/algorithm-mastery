public class BSTDriver {
    public static void main(String[] args) {
        BST tree = new BST();
        Comparable person1 = new ComparablePerson("Bob", 20);
        tree.add(person1);
        Comparable person2 = new ComparablePerson("kim", 19);
        tree.add(person2);
        System.out.println(tree.size());
    }
}
