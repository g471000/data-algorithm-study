package ch_01_arrays_and_strings;

import java.util.HashSet;

public class Q0 {
    public static void main(String[] args) {
        Q0 q0 = new Q0();
        System.out.println(q0.hasNoDuplicate("ABCA"));
        System.out.println(q0.hasNoDuplicate2("ABCA"));
        System.out.println(q0.hasNoDuplicate3("ABCA"));
        
        System.out.println(q0.hasNoDuplicate("ABC"));
        System.out.println(q0.hasNoDuplicate2("ABC"));
        System.out.println(q0.hasNoDuplicate3("ABC"));

        System.out.println(q0.hasNoDuplicate(""));
        System.out.println(q0.hasNoDuplicate2(""));
        System.out.println(q0.hasNoDuplicate3(""));
    }

    // O(N)
    // Space O(N)
    public boolean hasNoDuplicate(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    // O(N^2)
    // O(1)
    public boolean hasNoDuplicate2(String s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasNoDuplicate3(String s) {
        int[] checker = new int[128];
        for (char c : s.toCharArray()) {
            int cNum = (int) c;
            if(checker[cNum] != 0){
                return false;
            }
            checker[cNum]++;
        }
        return true;
    }
}
