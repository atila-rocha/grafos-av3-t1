import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int V = scanner.nextInt();
        int M = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            double weight = scanner.nextDouble();

            boolean isEthan = (i < V - 1);

            Edge edge = new Edge(i + 1, v, w, weight, isEthan);
            edges.add(edge);
        }

        scanner.close();

        EdgeWeightedGraph graph = new EdgeWeightedGraph(V + 1);

        for (Edge edge : edges) {
            graph.addEdge(edge);
        }

        KruskalMST mst = new KruskalMST(graph);

        List<int[]> changes = GraphMSTComparison.findChanges(graph, mst, edges, V, M);

        StdOut.println(changes.size());

        for (int[] change : changes) {
            StdOut.println(change[0] + " " + change[1]);
        }
    }
}
