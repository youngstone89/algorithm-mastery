// O(n) for time
// O(n) for space
public class PowerOfNumberRecursive {

    public static long power(int x, int n){
        if (n == 0) {
            return 1;
        }

        if (x == 0) {
            return 0;
        }
        return x * power(x, n - 1);
    }
    
    public static void main(String[] args) {
        int x = 2;
        int n = 3;
        System.out.println(power(x, n));
    }
}
