import java.util.*;

public class Graph {
    public static void main(String[] args) {
        int vertices = 4;

        // 1. ADJACENCY MATRIX using a primitive 2D integer array
        int[][] adjMatrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i != j) {
                    adjMatrix[i][j] = 1;
                }
            }
        }

        // 2. ADJACENCY LIST using an ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
            for (int j = 0; j < vertices; j++) {
                if (i != j) {
                    adjList.get(i).add(j);
                }
            }
        }

        printMatrix(adjMatrix);
        printList(adjList);
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("Adjacency Matrix (complete graph K4)");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void printList(ArrayList<ArrayList<Integer>> list) {
        System.out.println("\nAdjacency List (complete graph K4)");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Vertex " + i + " is connected to: " + list.get(i));
        }
    }
}
