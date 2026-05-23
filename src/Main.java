import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        //long startTime = System.nanoTime();
        //String file_path = "dados/input.txt";
        //In in = new In(file_path);

        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int M = scanner.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            double weight = scanner.nextDouble();
            boolean isEthan = (i < V - 1);
            Edge edge = new Edge(i+1, v, w, weight, isEthan);
            edges.add(edge);
        }
        scanner.close();
        EdgeWeightedGraph graph = new EdgeWeightedGraph(V + 1);
        for (Edge edge : edges) {
            graph.addEdge(edge);
        }


        //EdgeWeightedGraph graph = new EdgeWeightedGraph(in);

        //EdgeWeightedGraph temp = new EdgeWeightedGraph(graph);

        //temp.addEdge();

//        System.out.println("verice " + graph.V());
//        System.out.println("arestas " + graph.E());
//        System.out.println();
//        System.out.print(graph.toString());

        KruskalMST mst =  new KruskalMST(graph);
//        int count=1;
//        for (Edge e : mst.edges()) {
//            //StdOut.println(count);
//            StdOut.println(e);
//            StdOut.println(e.isEthan());
//            StdOut.println(e.id());
//
//
//        }
        //StdOut.printf("%.5f\n", mst.weight());

        int count=0;
        int id_saida= GraphMSTComparison.printExcludedEdges(graph, mst);
        count++;
        //StdOut.println(id_saida);
        int id_entrada = GraphMSTComparison.findInputvertex(mst);
        //StdOut.println(id_entrada);
        count++;
        StdOut.println(count/2);
        StdOut.println(id_saida + " "+ id_entrada);

//        long endTime = System.nanoTime();
//        double duration = (endTime - startTime) / 1_000_000.0;
//        System.out.println("-------------------------------");
//        System.out.printf("Tempo de execução: %.4f ms\n", duration);
//        System.out.println("-------------------------------");

    }

}
