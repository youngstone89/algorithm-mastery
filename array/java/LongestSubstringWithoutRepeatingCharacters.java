import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        String s = "geeksforgeeks";
        System.out.println(l.find(s));

    }

    private int find(String s) {
        List<Character> substringL = new ArrayList<>();
        int largestLength = 0;
        for (int right = 0; right < s.length(); right++) {
            // decrease window size from left to right
            // by deleting repeating characters from the left side
            if (substringL.contains(s.charAt(right))) {
                int idx = substringL.indexOf(s.charAt(right));
                substringL.remove(idx);
                substringL.subList(0, idx).clear();
            }
            substringL.add(s.charAt(right));
            largestLength = Math.max(largestLength, substringL.size());
        }
        System.out.println(substringL.toString());
        return largestLength;
    }
}
