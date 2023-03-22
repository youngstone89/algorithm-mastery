class FibonacciMemoized {

    private final int MAX = 100;
    private final int NIL = -1;

    private int[] lookup = new int[MAX];

    public FibonacciMemoized() {
        for (int i = 0; i < MAX; i++) {
            lookup[i] = NIL;
        }
    }

    int fibonacci(int n) {
        if (lookup[n] == NIL) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
        return lookup[n];
    }

    public static void main(String[] args) {
        FibonacciMemoized f = new FibonacciMemoized();
        int n = 40;
        System.out.println("Fibonacci number is " + f.fibonacci(n));
    }        
}
