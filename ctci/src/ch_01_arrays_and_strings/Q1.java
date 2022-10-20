package ch_01_arrays_and_strings;

import java.util.HashSet;
import java.util.Arrays;
import java.util.Random;

public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        String[] uniques = {"", "a", "abc", q1.createUniqueLongString()};
        String[] notUniques = {"aa", "abca", q1.createLongString(200_000_000)};

        long startTime = System.currentTimeMillis();
        for (String s : uniques) {
            System.out.println(q1.isUniqueHashSet(s));
        }
        for (String s : notUniques) {
            System.out.println(q1.isUniqueHashSet(s));
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("HashSet: " + duration);
        System.out.println();

        startTime = System.currentTimeMillis();
        for (String s : uniques) {
            System.out.println(q1.isUniqueSort(s));
        }
        for (String s : notUniques) {
            System.out.println(q1.isUniqueSort(s));
        }
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Sort: " + duration);
        System.out.println();

        startTime = System.currentTimeMillis();
        for (String s : uniques) {
            System.out.println(q1.isUniqueAscii(s));
        }
        for (String s : notUniques) {
            System.out.println(q1.isUniqueAscii(s));
        }
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Ascii: " + duration);
        System.out.println();
    }

    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public boolean isUniqueHashSet(String s){
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    // Time Complexity: O(NlogN)
    // Space Complexity: O(1)
    public boolean isUniqueSort(String s) {
        if (s.length() < 2) {
            return true;
        }
        char[] array = s.toCharArray();
        Arrays.sort(array);
        for (int i = 0; i < s.length() - 1; i++) {
            if (array[i] == array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isUniqueAscii(String s) {
        int[] checker = new int[128];
        for (char c : s.toCharArray()) {
            if (checker[c]++ > 0) {
                return false;
            }
        }
        return true;
    }

    private String createLongString(int length){
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            sb.append((char) r.nextInt(128));
        }
        return sb.toString();
    }

    private String createUniqueLongString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            sb.append((char) i);
        }
       return sb.toString();
    }
}
