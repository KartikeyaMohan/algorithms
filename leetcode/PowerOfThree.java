/**
 * Leetcode 326
 * Given an integer n, return true if it is a power
 * of three. Otherwise, return false.
 * An integer n is a power of three, if there
 * exists an integer x such that n == 3^x.
 */
class PowerOfThree {

    private boolean isPowerOfThree(int n) {
        boolean output = true;
        if (n % 3 != 0) {
            if (n == 1) {
                return true;
            }
            return false;
        }
        else if (n == 0) {
            return false;
        }
        output = output && isPowerOfThree(n / 3);
        return output;
    }

    public static void main(String[] args) {
        PowerOfThree object = new PowerOfThree();
        System.out.println(object.isPowerOfThree(27));
        System.out.println(object.isPowerOfThree(24));
    }
}