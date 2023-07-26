public class Palindrome {
    public boolean isPalindrome(String s) {
        // left most index
        int i = 0;
        // right most index
        int j = s.length() - 1;
        // we can compare two opposing characters
        // we can't compare the identical middle character
        while (i < j) {
            // increment left index as long as character is alphanumberic
            Character start = s.charAt(i);
            Character end = s.charAt(j);

            // move index until we find alphanumeric character
            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }
            // compare when we found left and right side of alphanumeric characters
            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }
            // move up and down index along the way after a comparison to reach middle
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        String s = "a_b,a";
        System.out.println(p.isPalindrome(s));
    }
}
