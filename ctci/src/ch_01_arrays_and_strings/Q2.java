package ch_01_arrays_and_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        String[][] inputs = {{"", ""}, {"abc", "ac"}, {"abcded", "dabced"}, {"abcdef", "abcdeg"}};
        int max = 1_000;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            String[] input = q2.createLongPalindrome(i);

            if (!q2.isPalindromeSort(input[0], input[1])) {
                System.out.println("Map Solution is incorrect!");
            }
        }

        for (int i = 0; i < inputs.length; i++) {
            System.out.print(Arrays.toString(inputs[i]) + " -> " + q2.isPalindromeSort(inputs[i][0], inputs[i][1]) + "\n");
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.printf("Sort solution: %d secs\n\n", duration);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            String[] input = q2.createLongPalindrome(i);
            if (!q2.isPalindromeMap(input[0], input[1])) {
                System.out.println("Map Solution is incorrect!");
            }
        }
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(Arrays.toString(inputs[i]) + " -> " + q2.isPalindromeMap(inputs[i][0], inputs[i][1]) + "\n");
        }
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.printf("Map solution: %d secs\n\n", duration);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            String[] input = q2.createLongPalindrome(i);
            if (!q2.isPalindromeAscii(input[0], input[1])) {
                System.out.println("ASCII Solution is incorrect!");
            }
        }
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(Arrays.toString(inputs[i]) + " -> " + q2.isPalindromeAscii(inputs[i][0], inputs[i][1]) + "\n");
        }
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.printf("ASCII solution: %d secs\n", duration);
    }

    public boolean isPalindromeSort(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return String.valueOf(c1).equals(String.valueOf(c2));
    }

    public boolean isPalindromeMap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        return true;
    }

    public boolean isPalindromeAscii(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] checker = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            checker[s1.charAt(i)]++;
            checker[s2.charAt(i)]--;
        }

        for (int n : checker) {
            if (n != 0) {
                return false;
            }
        }

        return true;
    }

    private String[] createLongPalindrome(int length) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char) (r.nextInt(26) + 'a'));
        }
        String s1 = sb.toString();
        String s2 = s1;
        for (int i = 0; i < length; i++) {
            int index = r.nextInt(length);
            s2 = s2.substring(index, length) + s2.substring(0, index);
        }

        return new String[]{s1, s2};
    }
}
