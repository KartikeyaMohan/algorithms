/**
 * Leetcode 840: Magic Squares In Grid
 * 
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 * Given a row x col grid of integers, how many 3 x 3 magic square subgrids are there?
 * Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.
 */
class MagicSquaresInGrid {

    private int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length - 2; i++) {
            for(int j = 0; j < grid[i].length - 2; j++) {
                int[][] subGrid = {
                    {grid[i][j], grid[i][j + 1], grid[i][j + 2]},
                    {grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2]},
                    {grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2]}
                };
                if (isMagicSquare(subGrid)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid) {
        return areSumsEqual(grid) && allDistinctNumbers(grid);
    }

    private boolean allDistinctNumbers(int[][] grid) {
        Set<Integer> number = new HashSet<>();
        boolean flag = false;
        outer: for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 9 || grid[i][j] < 1) {
                    flag = true;
                    break outer;
                }
                number.add(grid[i][j]);
            }
        }
        if (flag) {
            return false;
        }
        return number.size() == 9;
    }

    private boolean areSumsEqual(int[][] grid) {
        int row1 = grid[0][0] + grid[0][1] + grid[0][2];
        int row2 = grid[1][0] + grid[1][1] + grid[1][2];
        int row3 = grid[2][0] + grid[2][1] + grid[2][2];
        int col1 = grid[0][0] + grid[1][0] + grid[2][0];
        int col2 = grid[0][1] + grid[1][1] + grid[2][1];
        int col3 = grid[0][2] + grid[1][2] + grid[2][2];
        int diag1 = grid[0][0] + grid[1][1] + grid[2][2];
        int diag2 = grid[0][2] + grid[1][1] + grid[2][0];
        return row1 == row2 && row1 == row3 && row1 == col1 &&
               row1 == col2 && row1 == col3 && row1 == diag1 &&
               row1 == diag2;
    }

    public static void main(String[] args) {
        MagicSquaresInGrid object = new MagicSquaresInGrid();
        int[][] grid = {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
        System.out.println(object.numMagicSquaresInside(grid));
    }
}