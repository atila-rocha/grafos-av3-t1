public class Main {

    static void main() {
        long startTime = System.nanoTime();
        String file_path = "dados/input.txt";
        In in = new In(file_path);

        EdgeWeightedGraph graph = new EdgeWeightedGraph(in);

//        System.out.println("verice " + graph.V());
//        System.out.println("arestas " + graph.E());
//        System.out.println();
//        System.out.print(graph.toString());

        KruskalMST mst =  new KruskalMST(graph);
//        int count=1;
//        for (Edge e : mst.edges()) {
//            StdOut.println(count);
//            StdOut.println(e);
//            count++;
//        }
        StdOut.printf("%.5f\n", mst.weight());


        GraphMSTComparison.printExcludedEdges(graph, mst);

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0;
        System.out.println("-------------------------------");
        System.out.printf("Tempo de execução: %.4f ms\n", duration);
        System.out.println("-------------------------------");

    }

}
