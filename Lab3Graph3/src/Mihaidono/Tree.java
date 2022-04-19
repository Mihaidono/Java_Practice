package Mihaidono;

import java.util.ArrayList;

public class Tree {

    DLList nodeList = new DLList();

    Tree(){
        nodeList.addNode(7,null);
        nodeList.addNode(3,7);
        nodeList.addNode(10,7);
        nodeList.addNode(4,7);
        nodeList.addNode(8,3);
        nodeList.addNode(12,3);
        nodeList.addNode(11,10);
        nodeList.addNode(2,4);
        nodeList.addNode(6,8);
        nodeList.addNode(5,8);
        nodeList.addNode(1,12);
        nodeList.addNode(9,5);
        nodeList.initiateChildren();
    }

    public void printTree(){
        Node auxNode=nodeList.head;
        while(auxNode!=nodeList.tail){
            if(auxNode.children.size()!=0) {
                System.out.print(auxNode + " -> ");
                for (Node child : auxNode.children) {
                    System.out.print(child + " ");
                }
                System.out.println();
            }
            auxNode=auxNode.next;
        }
    }

    public void insertNew(DLList nodes, int key, int newValue) {
        Node newNode = new Node(newValue);
        Node node = searchByKey(nodes.head, key);
        newNode.parent = node;
        node.children.add(newNode);
    }

    public Node searchByKey(Node node, int key) {
        ArrayList<Node> children = node.children;
        int pos = 0;
        while (pos < children.size() && children.get(pos) != null) {
            if (children.get(pos).value == key) {
                return children.get(pos);
            }
            Node newNode = searchByKey(children.get(pos), key);
            if (newNode.value == key) {
                return newNode;
            }
            pos++;
        }
        return new Node(-1);
    }
}
