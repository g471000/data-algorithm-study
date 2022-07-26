package ch_01_arrays_and_strings;

import java.util.Arrays;

public class Q5 {
    public static void main(String[] args) {
        Q5 q5 = new Q5();
        String[][] inputs = {{"pale", "ple"}, {"pales", "pale"}, {"pale", "bale"}, {"pale", "bake"}};

        for (String[] input : inputs) {
            System.out.printf("%s: %b\n", Arrays.toString(input), q5.isOneEdit(input[0], input[1]));
        }
    }

    public boolean isOneEdit(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        boolean edited = false;
        int p1 = 0;
        int p2 = 0;

        while (p1 < s1.length() && p2 < s2.length()) {
            if (s1.charAt(p1) != s2.charAt(p2)) {
                if (edited) {
                    return false;
                } else {
                    edited = true;
                    if (s1.length() == s2.length()) {
                        p1++;
                        p2++;
                    } else if (s1.length() < s2.length()) {
                        p2++;
                    } else {
                        p1++;
                    }
                }
            } else {
                p1++;
                p2++;
            }
        }
        if (p1 < s1.length() || p2 < s2.length()) {
            return !edited;
        }
        return true;
    }
}
