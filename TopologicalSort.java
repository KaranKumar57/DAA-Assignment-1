import java.util.*;

public class TopologicalSort {

    enum Color { WHITE, GRAY, BLACK }

    static class Node {
        char id;
        Color color;
        int discoveryTime, finishingTime;
        Node parent;

        Node(char id) {
            this.id = id;
            this.color = Color.WHITE;
            this.parent = null;
        }
    }

    private Map<Character, Node> nodes = new LinkedHashMap<>();
    private Map<Character, List<Character>> adj = new HashMap<>();
    private Stack<Character> topologicalOrder = new Stack<>();
    private int time = 0;

    public void addEdge(char u, char v) {
        nodes.putIfAbsent(u, new Node(u));
        nodes.putIfAbsent(v, new Node(v));
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adj.putIfAbsent(v, new ArrayList<>());
    }


    public void dfs() {
        for (Node u : nodes.values()) {
            u.color = Color.WHITE;
            u.parent = null;
        }
        time = 0;
        for (Node u : nodes.values()) {
            if (u.color == Color.WHITE) {
                dfsVisit(u);
            }
        }
    }

    
    private void dfsVisit(Node u) {
        time = time + 1;
        u.discoveryTime = time;
        u.color = Color.GRAY;

        for (char neighborId : adj.get(u.id)) {
            Node v = nodes.get(neighborId);
            if (v.color == Color.WHITE) {
                v.parent = u;
                dfsVisit(v);
            }
        }

        u.color = Color.BLACK;
        time = time + 1;
        u.finishingTime = time;
        
        topologicalOrder.push(u.id);
    }

    public void printTopologicalSort() {
        System.out.println("topological sort:");
        while (!topologicalOrder.isEmpty()) {
            System.out.print(topologicalOrder.pop() + " ");
        }
        System.out.println();
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

        graph.dfs();
        graph.printTopologicalSort();
    }
}
