public class PowerOfNumberDivideNConquer {

    public static int power(int x, int n) {

        if (n == 0) {
            return 1;
            // even
        } else if (n % 2 == 0) {
            return power(x, n / 2) * power(x, n / 2);
            // odd
        } else {
            return x * power(x, n / 2) * power(x, n / 2);
        }
    }
    

    public static void main(String[] args) {
        int x = 2;
        int n = 3;
        System.err.println(power(x,n));
    }
    
}
