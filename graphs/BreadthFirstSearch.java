import java.util.LinkedList;
import java.util.Queue;

class BreadthFirstSearch {

    private int[] traversal(int[][] graph) {
        int[] traversed = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while(index < graph.length) {
            if (!queue.isEmpty()) {
                int node = queue.poll();
                traversed[index] = node;
                for (int i = 0; i < graph[index].length; i++) {
                    if (!visited[graph[index][i]]) {
                        visited[graph[index][i]] = true;
                        queue.add(graph[index][i]);
                    }
                }
                index++;
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
        int[][] graph = {{2, 3}, {2}, {0, 1}, {0}, {5}, {4}};
        int[] output = object.traversal(graph);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + (i == output.length - 1 ? "" : ", "));
        }
    }
}