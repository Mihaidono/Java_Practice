package Mihaidono;

public class Edge {
    public int firstNode;
    public int secondNode;

    Edge(int firstNode,int secondNode){
        this.firstNode=firstNode;
        this.secondNode=secondNode;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "firstNode=" + firstNode +
                ", secondNode=" + secondNode +
                '}';
    }
}
