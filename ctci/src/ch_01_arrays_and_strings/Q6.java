package ch_01_arrays_and_strings;

public class Q6 {
    public static void main(String[] args) {
        Q6 q6 = new Q6();
        String[] inputs = {"abcdefg", "aabcccccaaa", "aaaaaaaa", "", "a", "aa", "aaa"};

        for (String s : inputs) {
            System.out.printf("%s: %s\n", s, q6.pressString(s));
        }
    }

    // Time: O(N)
    // Space: O(N)
    public String pressString(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (i != 0 && prev != curr) {
                sb.append("" + curr + count);
                count = 1;
            } else {
                count++;
            }
            prev = curr;
        }

        sb.append("" + prev + count);
        return s.length() < sb.length() ? s : sb.toString();
    }
}
