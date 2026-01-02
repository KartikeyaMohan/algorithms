import java.util.HashMap;

/**
 * Leetcode 961
 * You are given an integer array nums with the following properties:
 * nums.length == 2 * n.
 * nums contains n + 1 unique elements.
 * Exactly one element of nums is repeated n times.
 * Return the element that is repeated n times.
 */
class RepeatedNTimes {

    private int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int value = map.getOrDefault(nums[i], 0);
            value++;
            if (value == n) {
                return nums[i];
            }
            map.put(nums[i], value);
        }
        return -1;
    }

    public static void main(String[] args) {
        RepeatedNTimes object = new RepeatedNTimes();
        int[] arr = {5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(object.repeatedNTimes(arr));
    }
}