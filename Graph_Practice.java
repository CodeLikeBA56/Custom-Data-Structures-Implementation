import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_Practice {

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 3, 3));
        graph[3].add(new Edge(3, 4, 5));
    }

    public static void BFS(ArrayList<Edge> graph[], int startVertex) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            ArrayList<Edge> edges = graph[vertex];
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                int destVertex = edge.dest;

                if (!visited[destVertex]) {
                    visited[destVertex] = true;
                    queue.add(destVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertex = 5;
        ArrayList<Edge> graph[] = new ArrayList[vertex];

        createGraph(graph);

        System.out.println("Breadth-First Traversal starting from vertex 0:");
        BFS(graph, 0);
    }
}

class Edge {
    int src;
    int dest;
    int weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
