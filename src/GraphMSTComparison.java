import java.util.HashSet;
import java.util.Set;

/*
* Classe statica para comparação
* TODO: printar aresta de acordo com sua inserção do arquivo txt Ex: aresta 1 ao
*  invés de aresta 1-2
* TODO: Descobrir a "aresta que entrou no grafo (Possível alteração nas demais classes)"
* TODO: Printar output bonitinho
* */
public class GraphMSTComparison {
    public static void printExcludedEdges(EdgeWeightedGraph G, KruskalMST mst) {
        Set<Edge> mstEdges = new HashSet<>();
        for (Edge e : mst.edges()) {
            mstEdges.add(e);
        }
        int V = G.V();
        for (int v = 0; v < V; v++) {
            for (Edge e : G.adj(v)) {
                int other = e.other(v);
                if (v < other) {
                    if (!mstEdges.contains(e)) {
                        System.out.println("Edge " + e + " is excluded from MST.");
                    }
                }
            }
        }
    }
}