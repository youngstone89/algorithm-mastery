public class ArrayQueueDriver {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.dequeue());
        }
    }
}
