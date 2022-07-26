package ch_01_arrays_and_strings;

public class Q4 {
    public static void main(String[] args) {
        String[] inputs = {"", "a", "Aa", "Tact Coa", "atco cta"};
        Q4 q4 = new Q4();

        for (String s : inputs) {
            System.out.println(s + ": " + q4.isPalindrome(s));
        }
    }

    // Time: O(N)
    // Space: O(1)
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == ' ') {
               left++;
            } else if (s.charAt(right) == ' ') {
                right--;
            } else {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
