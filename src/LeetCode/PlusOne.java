package LeetCode;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {

        int[] digits = {9, 2, 9};
        System.out.println(Arrays.toString(plusOne(digits)));

    }

    private static int[] plusOne(int[] digits) {
        int pt = digits.length - 1;
        while (pt >= 0) {
            boolean inc = (digits[pt] + 1 == 10);

            digits[pt] = (digits[pt] + 1) % 10;

            if (!inc) {
                break;
            }
            pt--;
        }

        if (pt == -1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        return digits;
    }


}
