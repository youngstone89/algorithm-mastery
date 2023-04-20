public class SinglyLinkedListDriver {

    public static <T> void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        try {
            list.addToBack(1);
            list.addToBack(2);
            list.addToBack(3);
            list.addToBack(4);
            System.out.println(list.removeFromBack());
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        SinglyLinkedListNode<Integer> current = list.getHead();

        while (current != null) {
            System.out.print(current.getData());
            current = current.getNext();
        }

    }
}
