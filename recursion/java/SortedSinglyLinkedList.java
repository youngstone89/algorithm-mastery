public class SortedSinglyLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private int size;

    public SortedSinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else if (head.data.compareTo(data) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && current.next.data.compareTo(data) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void removeDuplicates() {
        if (head != null) {
            removeDuplicates(head, head.next);
        }
    }

    private void removeDuplicates(Node<T> previous, Node<T> current) {
        if (current == null) {
            return;
        }
        if (previous.data.compareTo(current.data) == 0) {
            previous.next = current.next;
            size--;
            removeDuplicates(previous, previous.next);
        } else {
            removeDuplicates(current, current.next);
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }
}
