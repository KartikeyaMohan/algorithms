/**
 * Leetcode 66
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer. The digits are 
 * ordered from most significant to least significant in left-to-right order. 
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */
class PlusOne {
    private int[] plusOne(int[] digits) {
        if (checkIfAllNines(digits)) {
            int[] output = new int[digits.length + 1];
            output[0] = 1;
            for(int i = 1; i < output.length; i++) {
                output[i] = 0;
            }
            return output;
        }
        else {
            for(int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] + 1 > 9) {
                    digits[i] = 0;
                }
                else {
                    digits[i] = digits[i] + 1;
                    break;
                }
            }
            return digits;
        }
    }

    private boolean checkIfAllNines(int[] digits) {
        int count = 0;
        for(int i = 0; i < digits.length; i++) {
            if (digits[i] == 9) {
                count++;
            }
        }
        return count == digits.length;
    }

    public static void main(String args[]) {
        PlusOne object = new PlusOne();
        int[] digits = {4, 3, 2, 1};
        int[] output = object.plusOne(digits);
        for(int i = 0; i < output.length; i++) {
            if (i == output.length - 1) {
                System.out.println(output[i]);
            }
            else {
                System.out.print(output[i] + ", ");
            }
        }
    }
}