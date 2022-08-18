package ch_01_arrays_and_strings;

public class Q9 {
    public static void main(String[] args) {
        Q9 q9 = new Q9();
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        System.out.printf("isRotation(%s, %s): %b\n", s1, s2, q9.isRotation(s1, s2));

        s1 = "";
        s2 = "";
        System.out.printf("isRotation(%s, %s): %b\n", s1, s2, q9.isRotation(s1, s2));

        s1 = "water";
        s2 = "terwat";
        System.out.printf("isRotation(%s, %s): %b\n", s1, s2, q9.isRotation(s1, s2));
    }

    public boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String addStr = s1 + s1;
        return isSubstring(addStr, s2);
    }

    public boolean isSubstring(String s1, String s2) {
        return s1.indexOf(s2) != -1;
    }
}
