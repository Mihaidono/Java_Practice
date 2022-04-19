package Mihaidono;

import java.util.ArrayList;

public class Node {
    public int value;
    public Node prev;
    public Node next;
    public Node parent;
    ArrayList<Node> children;

    public Node(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
        this.parent = null;
        this.children = new ArrayList<>(0);
    }

    @Override
    public String toString() {
        return "Node("  + value + ')';
    }
}
