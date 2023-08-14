package ch_05_bit_manipulation.q03_flip;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        int input = 1775;
        System.out.println(input);
        System.out.println(FindMaxLengthByFlipABitBFS(1775));
        System.out.println(FindMaxLengthByFlipABitOneLoop(1775));
        System.out.println(FindMaxLengthByFlipABit(1775));
    }


    public static int FindMaxLengthByFlipABit(int input) {

        // ~ 을 하면 모든 bit를 뒤집는다. 만약 모두가 1이면, 32를 리턴한다.
        if (~input == 0) {
            return Integer.BYTES * 8;
        }

        int currLen = 0;
        int prevLen = 0;
        int maxLen = 1;

        while(input != 0){
            if((input & 1) == 1){
                // current last bit is 1
                currLen++;
            } else if ((input & 1) == 0){
                prevLen = (input & 2) == 0 ? 0 : currLen;
                currLen = 0;
            }
            maxLen = Math.max(prevLen + currLen + 1, maxLen);
            input >>>= 1;
        }
        return maxLen;
    }

    /**
     * O(N)
     * @param input input integer
     * @return max length after flip a bit
     */
    public static int FindMaxLengthByFlipABitOneLoop(int input) {
        // ~ 을 하면 모든 bit를 뒤집는다. 만약 모두가 1이면, 32를 리턴한다.
        if (~input == 0) {
            return Integer.BYTES * 8;
        }

        String binaryString = Integer.toBinaryString(input);
        int binLen = binaryString.length();
        ArrayList<Integer> lenList = new ArrayList<>();

        int currLen = 0;
        for (int i = 0; i < binLen; i++) {
            if (binaryString.charAt(i) == '1') {
                currLen++;
                if (i == binLen - 1) {
                    lenList.add(currLen);
                }
            } else {
                if (currLen > 0) {
                    lenList.add(currLen);
                    currLen = 0;
                }
            }
        }

        int maxLength = 0;
        int left = 0, right = 1;
        while (right < lenList.size()) {
            maxLength = Math.max(maxLength, lenList.get(left) + lenList.get(right) + 1);
            left++;
            right++;
        }

        return maxLength;
    }

    /**
     * O(N^2)
     * @param input input integer
     * @return max length after flip a bit
     */
    public static int FindMaxLengthByFlipABitBFS(int input) {
        // ~ 을 하면 모든 bit를 뒤집는다. 만약 모두가 1이면, 32를 리턴한다.
        if (~input == 0) {
            return Integer.BYTES * 8;
        }


        String binaryString = Integer.toBinaryString(input);
        int binLen = binaryString.length();
        if (binaryString.length() < 2) {
            return binaryString.length();
        }

        int left = 0;
        int right = 0;
        int zeroIndex = -1;
        int maxLength = 0;
        boolean hasMetZero = false;


        System.out.println(binaryString);

        while (left < binLen) {
            if (right == binLen - 1) {
                maxLength = Math.max(maxLength, right - left + 1);
                break;
            } else if (binaryString.charAt(right) == '0') {
                if (hasMetZero) {
                    maxLength = Math.max(maxLength, right - left + 1);
                    left = zeroIndex + 1;
                    right = left;
                    hasMetZero = false;
                } else {
                    hasMetZero = true;
                    zeroIndex = right;
                }
            }
            right++;
        }

        maxLength = Math.max(maxLength, right - left);

        return maxLength;
    }
}
