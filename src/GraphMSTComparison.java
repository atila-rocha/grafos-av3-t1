import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphMSTComparison {

    public static List<int[]> findChanges(EdgeWeightedGraph G, KruskalMST mst, List<Edge> edges, int V, int M) {
        boolean[] inMST = new boolean[M + 1];

        /*
         * Marca quais arestas fazem parte da MST final.
         */
        for (Edge e : mst.edges()) {
            inMST[e.id()] = true;
        }

        boolean[] inCurrentTree = new boolean[M + 1];

        ArrayList<Edge>[] currentAdj = (ArrayList<Edge>[]) new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            currentAdj[i] = new ArrayList<>();
        }

        /*
         * A árvore atual começa com as primeiras V - 1 arestas,
         * que são a árvore inicial do Ethan.
         */
        for (int i = 0; i < V - 1; i++) {
            Edge e = edges.get(i);

            inCurrentTree[e.id()] = true;

            int v = e.either();
            int w = e.other(v);

            currentAdj[v].add(e);
            currentAdj[w].add(e);
        }

        List<int[]> changes = new ArrayList<>();

        /*
         * Para cada aresta que deveria estar na MST,
         * mas ainda não está na árvore atual,
         * fazemos uma troca.
         */
        for (Edge edgeToAdd : mst.edges()) {
            if (!inCurrentTree[edgeToAdd.id()]) {
                int edgeToRemove = findEdgeToRemove(
                        edgeToAdd,
                        currentAdj,
                        inCurrentTree,
                        inMST,
                        V
                );

                changes.add(new int[]{edgeToRemove, edgeToAdd.id()});

                inCurrentTree[edgeToRemove] = false;
                inCurrentTree[edgeToAdd.id()] = true;

                int v = edgeToAdd.either();
                int w = edgeToAdd.other(v);

                currentAdj[v].add(edgeToAdd);
                currentAdj[w].add(edgeToAdd);
            }
        }

        return changes;
    }

    private static int findEdgeToRemove(
            Edge edgeToAdd,
            ArrayList<Edge>[] currentAdj,
            boolean[] inCurrentTree,
            boolean[] inMST,
            int V
    ) {
        int start = edgeToAdd.either();
        int end = edgeToAdd.other(start);

        Edge[] parent = new Edge[V + 1];
        //int[] parentEdge = new int[V + 1];
        boolean[] visited = new boolean[V + 1];

        //Arrays.fill(parent, -1);

        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (current == end) {
                break;
            }

            for (Edge e : currentAdj[current]) {
                if (!inCurrentTree[e.id()]) {
                    continue;
                }

                int next = e.other(current);

                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = e;
                    //parentEdge[next] = e.id();
                    stack.push(next);
                }
            }
        }

        /*
         * Ao adicionar edgeToAdd, forma-se um ciclo.
         * Dentro desse ciclo, precisamos remover uma aresta
         * que NÃO pertence à MST final.
         */
        int vertex = end;

        while (vertex != start) {
            Edge edge = parent[vertex];
            int edgeId=edge.id();

            if (!inMST[edgeId]) {
                return edgeId;
            }

            vertex = edge.other(vertex);
        }

        return -1;
    }
}
