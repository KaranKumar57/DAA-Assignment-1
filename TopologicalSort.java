import java.util.*;

public class TopologicalSort {
    private Map<Character, List<Character>> adj = new HashMap<>();

    public void addEdge(char u, char v) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adj.putIfAbsent(v, new ArrayList<>());
    }

    public void topologicalSort() {
        Stack<Character> stack = new Stack<>();
        Set<Character> visited = new HashSet<>();

        for (char vertex : adj.keySet()) {
            if (!visited.contains(vertex)) {
                dfs(vertex, visited, stack);
            }
        }

        System.out.println("topological sort order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private void dfs(char v, Set<Character> visited, Stack<Character> stack) {
        visited.add(v);
        for (char neighbor : adj.get(v)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, stack);
            }
        }
        stack.push(v);
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort();

        graph.addEdge('m', 'q'); graph.addEdge('m', 'r'); graph.addEdge('m', 'x');
        graph.addEdge('n', 'q'); graph.addEdge('n', 'o'); graph.addEdge('n', 'u');
        graph.addEdge('o', 'r'); graph.addEdge('o', 'v'); graph.addEdge('o', 's');
        graph.addEdge('p', 'o'); graph.addEdge('p', 's'); graph.addEdge('p', 'z');
        graph.addEdge('q', 't');
        graph.addEdge('r', 'u'); graph.addEdge('r', 'y');
        graph.addEdge('s', 'r');
        graph.addEdge('u', 't');
        graph.addEdge('v', 'x'); graph.addEdge('v', 'w');
        graph.addEdge('w', 'z');
        graph.addEdge('y', 'v');

        graph.topologicalSort();
    }
}
