import java.math.BigInteger;

/**
 * Leetcode 1411
 * You have a grid of size n x 3 and you want to paint each
 * cell of the grid with exactly one of the three colors:
 * Red, Yellow, or Green while making sure that no two adjacent
 * cells have the same color (i.e., no two cells that share
 * vertical or horizontal sides have the same color).
 * Given n the number of rows of the grid, return the number
 * of ways you can paint this grid. As the answer may grow
 * large, the answer must be computed modulo 10^9 + 7.
 */
class NumberOfWaysToPaint {

    private int numOfWays(int n) {
        BigInteger MODULO = BigInteger.valueOf(1000_000_007);
        // 3 * 2       Color combination type: R Y R
        BigInteger approachOne = BigInteger.valueOf(6);
        // 3 * 2 * 1   Color combination type: R Y G
        BigInteger approachTwo = BigInteger.valueOf(6);
        for(int i = 2; i <= n; i++) {
            BigInteger countOne =
                    approachOne.multiply(BigInteger.valueOf(3))
                            .add(approachTwo.multiply(BigInteger.valueOf(2)));
            BigInteger countTwo =
                    approachOne.multiply(BigInteger.valueOf(2))
                            .add(approachTwo.multiply(BigInteger.valueOf(2)));
            approachOne = countOne;
            approachTwo = countTwo;
        }
        return (approachOne.add(approachTwo)).mod(MODULO).intValue();
    }

    public static void main(String[] args) {
        NumberOfWaysToPaint object = new NumberOfWaysToPaint();
        int n = 5000;
        System.out.println(object.numOfWays(n));
    }
}