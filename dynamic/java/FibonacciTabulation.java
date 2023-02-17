class FibonacciTabulation {

    int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        FibonacciTabulation f = new FibonacciTabulation();
        int n = 9;
        System.out.println("Fibonacci number is " + f.fibonacci(n));
    }
    
}
