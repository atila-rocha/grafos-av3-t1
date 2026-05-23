import java.util.Scanner;

public class Main {

    static void main() {
        //long startTime = System.nanoTime();
        //String file_path = "dados/input.txt";
        //In in = new In(file_path);

        Scanner sc = new Scanner(System.in);

        EdgeWeightedGraph graph = new EdgeWeightedGraph(sc);


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
