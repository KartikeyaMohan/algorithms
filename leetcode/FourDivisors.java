/**
 * Leetcode 1390
 * Given an integer array nums, return the sum of divisors
 * of the integers in that array that have exactly four
 * divisors. If there is no such integer in the array, return 0.
 */
class FourDivisors {

    private int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += sumOfDivisors(nums[i]);
        }
        return sum;
    }

    private int sumOfDivisors(int num) {
        int count = 0;
        int sum = 1 + num;
        for(int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                if (i != num / i) {
                    count += 2;
                    sum = sum + i + num / i;
                }
                else {
                    count++;
                    sum = sum + i;
                }
            }
        }
        if (count == 2) {
            return sum;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        FourDivisors object = new FourDivisors();
        int[] nums = {21, 4, 7};
        System.out.println(object.sumFourDivisors(nums));
    }
}