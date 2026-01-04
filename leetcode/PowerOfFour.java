/**
 * Leetcode 342
 * Given an integer n, return true if it is a power of four.
 * Otherwise, return false.
 * An integer n is a power of four, if there exists an
 * integer x such that n == 4^x.
 */
class PowerOfFour {

    private boolean isPowerOfFour(int n) {
        boolean output = true;
        if (n % 4 != 0) {
            if (n == 1) {
                return true;
            }
            return false;
        }
        else if (n == 0) {
            return false;
        }
        output = output && isPowerOfFour(n / 4);
        return output;
    }

    public static void main(String[] args) {
        PowerOfFour object = new PowerOfFour();
        System.out.println(object.isPowerOfFour(64));
        System.out.println(object.isPowerOfFour(28));
    }
}