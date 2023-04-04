import java.util.Iterator;

public class LinkedListIterable<T> implements Iterable<T> {
    
    private Node<T> head;
    
    public LinkedListIterable() {
        head = null;
    }
    
    public void append(T data) {
        Node<T> new_node = new Node<>(data);
        if (head == null) {
            head = new_node;
        } else {
            Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new_node;
        }
    }
    
    private class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data) {
            this.data = data;
            next = null;
        }
    }
    
    private class LinkedListIterator implements Iterator<T> {
        private Node<T> curr;
        
        public LinkedListIterator() {
            curr = head;
        }
        
        public boolean hasNext() {
            return curr != null;
        }
        
        public T next() {
            T data = curr.data;
            curr = curr.next;
            return data;
        }
    }
    
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    
    public static void main(String[] args) {
        LinkedListIterable<String> list = new LinkedListIterable<>();
        list.append("Hello");
        list.append("World");
        list.append("!");
        
        for (String s : list) {
            System.out.println(s);
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object data = iterator.next();
            System.out.println(data);
        }
    }
}
