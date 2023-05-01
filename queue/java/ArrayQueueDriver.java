public class ArrayQueueDriver {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 2; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 2; i++) {
            queue.dequeue();
        }
        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 6; i++) {
            queue.dequeue();
        }
    }
}
