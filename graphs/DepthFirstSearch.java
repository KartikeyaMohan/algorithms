import java.util.Stack;

class DepthFirstSearch {

    private int[] traversal(int[][] graph) {
        int[] traversed = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(index);
        visited[index] = true;
        while (index < graph.length) {
            if (!stack.isEmpty()) {
                int node = stack.pop();
                traversed[index] = node;
                for(int i = 0; i < graph[index].length; i++) {
                    if (!visited[graph[index][i]]) {
                        visited[graph[index][i]] = true;
                        stack.add(graph[index][i]);
                    }
                }
                index++;
            }
            else {
                stack.add(index);
                visited[index] = true;
            }
        }
        return traversed;   
    }

    public static void main(String[] args) {
        DepthFirstSearch object = new DepthFirstSearch();
        int[][] graph = {{2, 3}, {2}, {0, 1}, {0}, {5}, {4}};
        int[] output = object.traversal(graph);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + (i == output.length - 1 ? "" : ", "));
        }
    }
}