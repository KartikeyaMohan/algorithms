import java.util.LinkedList;
import java.util.Queue;

class BreadthFirstSearch {

    private int[] traversal(int[][] graph) {
        int[] traversed = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(index < graph.length) {
            if (!queue.isEmpty()) {
                int node = queue.poll();
                traversed[index++] = node;
                for (int i = 0; i < graph[node].length; i++) {
                    if (!visited[graph[node][i]]) {
                        visited[graph[node][i]] = true;
                        queue.add(graph[node][i]);
                    }
                }
            }
            else {
                queue.add(index);
                visited[index] = true;
            }
        }
        return traversed;
    }

    public static void main(String[] args) {
        BreadthFirstSearch object = new BreadthFirstSearch();
        int[][] connectedGraph = {{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}};
        int[][] disconnectedGraph = {{2, 3}, {2}, {0, 1}, {0}, {5}, {4}};
        int[] connectedGraphOutput = object.traversal(connectedGraph);
        int[] disconnectedGraphOutput = object.traversal(disconnectedGraph);
        System.out.print("Connected Graph output: ");
        for (int i = 0; i < connectedGraphOutput.length; i++) {
            System.out.print(connectedGraphOutput[i] + (i == connectedGraphOutput.length - 1 ? "" : ", "));
        }
        System.out.println();
        System.out.print("Disconnected Graph output: ");
        for (int i = 0; i < disconnectedGraphOutput.length; i++) {
            System.out.print(disconnectedGraphOutput[i] + (i == disconnectedGraphOutput.length - 1 ? "" : ", "));
        }
    }
}