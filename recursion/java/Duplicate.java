public class Duplicate<T> {
    private Node<T> head;

    Duplicate() {
        head = new Node(0);
        head.next = new Node(1);
    }

    public void userMethod() {
        head = privateMethod(head);
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private class Node<T> {
        T data;
        Node<T> next;
        
        private Node(T data){
            this.data = data;
        }
    }
    
    
    private Node<T> privateMethod(Node<T> curr) {
        if (curr == null) {
            return null;
        } else {
            Node<T> temp = new Node<>(curr.data);
            temp.next = curr;
            curr.next = privateMethod(curr.next);
            return temp;
        }
    }

    public static void main(String[] args) {
        Duplicate dup = new Duplicate();
        dup.userMethod();
        dup.print();
   } 
}
