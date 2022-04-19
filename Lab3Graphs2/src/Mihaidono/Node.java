package Mihaidono;

import java.util.ArrayList;

public class Node {
    public int value;
    public Node parent;
    public ArrayList<Node> children=null;

    Node(int value){
        this.parent=null;
        this.value=value;
        this.children=new ArrayList<>(0);
    }

    @Override
    public String toString() {
        return "Node(" + value +") ";
    }
}
