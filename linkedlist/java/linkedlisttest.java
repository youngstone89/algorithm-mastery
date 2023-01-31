import java.util.Iterator;
import java.util.LinkedList;

/**
 * linkedlisttest
 */
public class linkedlisttest {

    private static void SingleLinkedList() {
        LinkedList ll = new LinkedList<>();
        ll.add(1);

        Iterator iterator = ll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void LinkedListArray() {
        LinkedList[] linkedListArray = new LinkedList[1];
        for (LinkedList linkedList : linkedListArray) {
            linkedList = new LinkedList();
        }
    }

    public static void main(String[] args) {
        SingleLinkedList();
    }
}