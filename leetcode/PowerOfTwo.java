/**
 * Leetcode 231
 * Given an integer n, return true if it is
 * a power of two. Otherwise, return false.
 * An integer n is a power of two, if there
 * exists an integer x such that n == 2^x.
 */
class PowerOfTwo {

    private boolean isPowerOfTwo(int n) {
        boolean output = true;
        if (n % 2 != 0) {
            if (n == 1) {
                return true;
            }
            return false;
        }
        else if (n == 0) {
            return false;
        }
        output = output && isPowerOfTwo(n / 2);
        return output;
    }

    public static void main(String[] args) {
        PowerOfTwo object = new PowerOfTwo();
        System.out.println(object.isPowerOfTwo(32));
        System.out.println(object.isPowerOfTwo(18));
    }
}