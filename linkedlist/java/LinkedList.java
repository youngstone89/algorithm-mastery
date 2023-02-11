class LinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void sortedInsert(Node newNode) {
        Node current;
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
        } else {
            current = head;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    Node newNode(int d) {
        Node newNode = new Node(d);
        return newNode;
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        Node newNode;
        newNode = llist.newNode(5);
        llist.sortedInsert(newNode);

        newNode = llist.newNode(10);
        llist.sortedInsert(newNode);

        newNode = llist.newNode(7);
        llist.sortedInsert(newNode);

        newNode = llist.newNode(3);
        llist.sortedInsert(newNode);

        newNode = llist.newNode(1);
        llist.sortedInsert(newNode);

        newNode = llist.newNode(9);
        llist.sortedInsert(newNode);
        System.out.println("created linked list");
        llist.printList();
    }

    private void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}
