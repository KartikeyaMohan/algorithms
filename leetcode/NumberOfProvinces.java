import java.util.Stack;

/**
 * Leetcode 547
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected
 * directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and
 * no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1
 * if the ith city and the jth city are directly connected, and
 * isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 */
class NumberOfProvinces {

    private int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int start, int[][] isConnected, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int city = stack.pop();
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[city][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces object = new NumberOfProvinces();
        int[][] grid = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(object.findCircleNum(grid));
    }
}