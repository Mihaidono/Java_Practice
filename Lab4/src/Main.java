import java.util.*;

public class Main {
     public static void main(String[] args)
        {
            Graph g = new Graph();
            g = g.createGraph();
            Dijkstra(g);
            g.showGraph();
        }
        static void Dijkstra(Graph g)
        {
            ArrayList<String> Q = new ArrayList<>();
            HashMap<String, Double> dist = new HashMap<String,Double>();
            for (String s : g.getAdjVertices().keySet() ) {
                Q.add(s);
                dist.put(s, Double.MAX_VALUE);
            }
            dist.put("A", 0.0);

            while(Q.size()>0)
            {
                //u ← vertex in Q with min dist[u]
                double min = Double.MAX_VALUE;
                int minindex =0,i = 0;
                for (String s: Q) {
                    if (dist.get(s) < min)
                    {
                        min = dist.get(s);
                        minindex = i;
                    }
                    i++;
                }
                String u = Q.get(minindex);
                System.out.println("Removing " + u);
                Q.remove(u);
                Map<Vertex,Double> map = g.getAdjVerticesForOne(u);
                for(Vertex v : map.keySet())
                {
                    if (Q.contains(v.getLabel())) {
                        Double alt = dist.get(u) + map.get(v);
                        if (alt < dist.get(v.getLabel()))
                        {
                            dist.put(v.getLabel(), alt);
                        }
                    }
                }
            }
        }
    }