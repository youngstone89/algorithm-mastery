public class ArrayQueueDriver {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 9; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 1; i++) {
            queue.dequeue();
        }
        queue.enqueue(9);
    }
}
