package Mihaidono;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphSolution {
    public ChainedList adjList = new ChainedList();
    public ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();

    GraphSolution() {
        setAdjMatrix();
        setAdjList();
    }

    public void printAdjMatrix() {
        for (int i = 0; i < adjMatrix.size(); i++) {
            System.out.println(adjMatrix.get(i));
        }
    }

    public void printAdjList(){
        for(int i=1;i<adjList.size();i++){
            System.out.print(adjList.getNode(i));
            for(int j=0;j<adjList.getNode(i).sons.size();j++){
                System.out.print("->"+adjList.getNode(i).sons.get(j));
            }
            System.out.println("");
        }
    }

    private void setAdjList() {
        for (int i = 0; i < adjMatrix.size(); i++) {
            adjList.addNode(i+1);
        }

        for (int i = 0; i < adjMatrix.size(); i++) {
            for (int j = 0; j < adjMatrix.size(); j++) {
                if (adjMatrix.get(i).get(j) != 0) {
                    adjList.addSon(adjList.getNode(i+1), adjList.getNode(j+1));
                }
            }
        }
    }

    private void setAdjMatrix() {

        ArrayList<Edge> edgeList = new ArrayList<>();
        int sizeCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("MatAdj.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[()]", "");
                String[] parts = line.split(";");
                for (String pt : parts) {
                    String[] smallParts = pt.split(",");
                    Edge newEdge = new Edge(Integer.parseInt(smallParts[0]), Integer.parseInt(smallParts[1]));
                    if (newEdge.firstNode > newEdge.secondNode && newEdge.firstNode > sizeCount) {
                        sizeCount = newEdge.firstNode;
                    } else if (newEdge.firstNode < newEdge.secondNode && newEdge.secondNode > sizeCount) {
                        sizeCount = newEdge.secondNode;
                    }
                    edgeList.add(newEdge);
                }

                int[][] mat = new int[sizeCount][sizeCount];
                try {
                    for (int i = 0; i < mat.length; i++) {
                        for (int j = 0; j < mat.length; j++) {
                            mat[i][j] = 0;
                        }
                    }
                    for (int i = 0; i < edgeList.size(); i++) {
                        mat[edgeList.get(i).firstNode - 1][edgeList.get(i).secondNode - 1] = 1;
                    }
                    ArrayList<Integer> row;
                    for (int i = 0; i < mat.length; i++) {
                        row = new ArrayList<>();
                        for (int j = 0; j < mat.length; j++) {
                            row.add(mat[i][j]);
                        }
                        adjMatrix.add(row);
                    }
                } catch (IndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
