package ch_01_arrays_and_strings;

public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(q3.makeUrl("Ms Genie Chon", 17));
    }

    // Time: O(N)
    // Space: O(N)
    public String makeUrl(String s, int fullLength) {
        char[] result = new char[fullLength];
        int index = fullLength- 1;
        int sIndex = s.length() - 1;
        while(sIndex >= 0){
            if (s.charAt(sIndex) == ' ') {
                result[index] = '0';
                result[index - 1] = '2';
                result[index - 2] = '%';
                index -= 3;
            } else {
                result[index] = s.charAt(sIndex);
                index--;
            }
            sIndex--;
        }
        return String.valueOf(result);
    }
}
