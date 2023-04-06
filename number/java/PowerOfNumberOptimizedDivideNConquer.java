// Time Complexity: O(log n)
// Auxiliary Space: O(log n), for recursive call stack

public class PowerOfNumberOptimizedDivideNConquer {

    public static void main(String[] args) {
        int x = 2;
        int n = 3;
        System.err.println(power(x,n));
    }

    private static int power(int x, int n) {
        int temp;
        if (n == 0) {
            return 1;
        }
        temp = power(x, n / 2);   
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }
    
}
