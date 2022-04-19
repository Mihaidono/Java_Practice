package Mihaidono;

import java.util.ArrayList;

public class Node {

    public Node next;
    public int value;
    public Node parent;
    public ArrayList<Node> sons;

    Node(int value) {
        this.value = value;
        this.next = null;
        this.sons = new ArrayList<>(0);
        this.parent=null;
    }

    @Override
    public String toString() {
        return "Node("  + value + ')';
    }
}
