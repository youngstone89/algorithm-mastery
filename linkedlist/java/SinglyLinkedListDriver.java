public class SinglyLinkedListDriver {
    public static <T> void main(String[] args) {
        SinglyLinkedList<T> list = new SinglyLinkedList<T>();
        SinglyLinkedListNode<T> current = list.getHead();

        while (current != null && current.getNext() != null) {
            System.out.println(current.getData().toString());
            current = current.getNext();
        }

    }
}
