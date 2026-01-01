/**
 * Leetcode 1351
 * Given a m x n matrix grid which is sorted in non-increasing order both
 * row-wise and column-wise, return the number of negative numbers in grid.
 */

class CountNegatives {

    private int output(int[][] grid) {
        int count = 0;
        for(int i = grid.length - 1; i >= 0; i--) {
            boolean flag = false;
            for(int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    flag = true;
                    count++;
                }
                else {
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountNegatives object = new CountNegatives();
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(object.output(grid));
    }
}