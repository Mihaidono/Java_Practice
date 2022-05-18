import java.lang.*;
import java.util.*;

public class Algorithms {
    //------------------PRIM----------------------------------------------------------
    private static int vertices;

    int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < vertices; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    void primMST(int graph[][]) {
        vertices = graph.length;

        int parent[] = new int[vertices];

        int key[] = new int[vertices];

        Boolean mstSet[] = new Boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < vertices; v++)
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        printMST(parent, graph);
    }

    //------------------KRUSKAL----------------------------------------------------------
    static class Graph {
        class Edge implements Comparable<Edge> {
            int src, dest, weight;

            public int compareTo(Edge compareEdge) {
                return this.weight - compareEdge.weight;
            }
        }

        class subset {
            int parent, rank;
        }

        int V, E;
        Edge edge[];

        // Creates a graph with V vertices and E edges
        Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }

        int find(subset subsets[], int i) {
            if (subsets[i].parent != i)
                subsets[i].parent = find(subsets, subsets[i].parent);
            return subsets[i].parent;
        }

        void Union(subset subsets[], int x, int y) {
            int xRoot = find(subsets, x);
            int yRoot = find(subsets, y);

            // Attach smaller rank tree under root
            // of high rank tree (Union by Rank)
            if (subsets[xRoot].rank
                    < subsets[yRoot].rank)
                subsets[xRoot].parent = yRoot;
            else if (subsets[xRoot].rank
                    > subsets[yRoot].rank)
                subsets[yRoot].parent = xRoot;
            else {
                subsets[yRoot].parent = xRoot;
                subsets[xRoot].rank++;
            }
        }

        void KruskalMST() {
            Edge result[] = new Edge[V];

            int e = 0;

            for (int i = 0; i < V; ++i)
                result[i] = new Edge();

            Arrays.sort(edge);

            subset subsets[] = new subset[V];
            for (int i = 0; i < V; ++i)
                subsets[i] = new subset();

            // Create V subsets with single elements
            for (int v = 0; v < V; ++v) {
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }

            int i = 0;

            while (e < V - 1) {
                Edge next_edge = edge[i++];

                int x = find(subsets, next_edge.src);
                int y = find(subsets, next_edge.dest);

                if (x != y) {
                    result[e++] = next_edge;
                    Union(subsets, x, y);
                }
            }

            System.out.println("\nFollowing are the edges in "
                    + "the constructed MST");
            int minimumCost = 0;
            for (i = 0; i < e; ++i) {
                System.out.println(result[i].src + " -- "
                        + result[i].dest
                        + " == " + result[i].weight);
                minimumCost += result[i].weight;
            }
            System.out.println("Minimum Cost Spanning Tree "
                    + minimumCost);
        }
    }

    //------------------DIJKSTRA----------------------------------------------------------
    public static class GFG {
        static class Node implements Comparator<Node> {
            public int node;
            public int cost;

            public Node() {
            }

            public Node(int node, int cost) {
                this.node = node;
                this.cost = cost;
            }

            @Override
            public int compare(Node node1, Node node2) {
                if (node1.cost < node2.cost)
                    return -1;
                if (node1.cost > node2.cost)
                    return 1;
                return 0;
            }
        }

        public int dist[];
        public Set<Integer> settled;
        public PriorityQueue<Node> pq;
        private int vert2;
        List<List<Node>> adj;

        public GFG(int V) {

            this.vert2 = V;
            dist = new int[V];
            settled = new HashSet<Integer>();
            pq = new PriorityQueue<Node>(V, new Node());
        }

        public void dijkstra(List<List<Node>> adj, int src) {
            this.adj = adj;
            for (int i = 0; i < vert2; i++)
                dist[i] = Integer.MAX_VALUE;
            pq.add(new Node(src, 0));
            dist[src] = 0;
            while (settled.size() != vert2) {
                if (pq.isEmpty())
                    return;
                int u = pq.remove().node;
                if (settled.contains(u))
                    continue;
                settled.add(u);
                e_Neighbours(u);
            }
        }

        private void e_Neighbours(int u) {

            int edgeDistance = -1;
            int newDistance = -1;

            for (int i = 0; i < adj.get(u).size(); i++) {
                Node v = adj.get(u).get(i);

                if (!settled.contains(v.node)) {
                    edgeDistance = v.cost;
                    newDistance = dist[u] + edgeDistance;

                    if (newDistance < dist[v.node])
                        dist[v.node] = newDistance;

                    pq.add(new Node(v.node, dist[v.node]));
                }
            }
        }
    }

}