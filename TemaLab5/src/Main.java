import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Algorithms t = new Algorithms();
        int graphic1[][] = new int[][]{    // Prim
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };
        // Print the solution
        t.primMST(graphic1);

        //Kruskal

        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Algorithms.Graph graph = new Algorithms.Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        // Function call
        graph.KruskalMST();


        //Dijkstra

        int varf = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges by declaring List class object
        // Declaring object of type List<Node>
        List<List<Algorithms.GFG.Node>> adj
                = new ArrayList<List<Algorithms.GFG.Node> >();

        // Initialize list for every node
        for (int i = 0; i < varf; i++) {
            List<Algorithms.GFG.Node> item = new ArrayList<Algorithms.GFG.Node>();
            adj.add(item);
        }

        // Inputs for the GFG(dpq) graph
        adj.get(0).add(new Algorithms.GFG.Node(1, 9));
        adj.get(0).add(new Algorithms.GFG.Node(2, 6));
        adj.get(0).add(new Algorithms.GFG.Node(3, 5));
        adj.get(0).add(new Algorithms.GFG.Node(4, 3));

        adj.get(2).add(new Algorithms.GFG.Node(1, 2));
        adj.get(2).add(new Algorithms.GFG.Node(3, 4));

        // Calculating the single source shortest path
        Algorithms.GFG dpq = new Algorithms.GFG(varf);
        dpq.dijkstra(adj, source);

        // Printing the shortest path to all the nodes
        // from the source node
        System.out.println("\nDIJKSTRA:\nThe shorted path from node :");

        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.dist[i]);

        //HEAPS:
        // Display message for better readability
        System.out.println("The Max Heap is ");

        Heaps maxHeap = new Heaps(15);

        // Inserting nodes
        // Custom inputs
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9); //am format heapul cu elementele: 5,3,17,10,84,19,6,22,9

        // Calling maxHeap() as defined above
        maxHeap.print();

        // Print and display the maximum value in heap
        System.out.println("The max val is "
                + maxHeap.extractMax());
    }
}