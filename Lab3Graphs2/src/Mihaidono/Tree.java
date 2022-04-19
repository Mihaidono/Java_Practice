package Mihaidono;

import javax.swing.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    public ArrayList<Node> nodeVector = new ArrayList();

    private Node root = null;
    private ArrayList<Node> children = null;

    public void displayTree() {
        for (int i = 0; i < nodeVector.size(); i++) {
            if (nodeVector.get(i).children.size() != 0) {
                System.out.println(nodeVector.get(i));
            }
            for (int j = 0; j < nodeVector.get(i).children.size(); j++) {
                System.out.println("    ->" + nodeVector.get(i).children.get(j));
            }
        }
    }

    public void displayNodeArray() {
        for (Node n : nodeVector) {
            System.out.print(n.value + " ");
        }
    }

    public int getNodeKey(int value) {
        for (int i = 0; i < nodeVector.size(); i++) {
            if (nodeVector.get(i).value == value)
                return i + 1;
        }
        return -1;
    }

    public int calculateDepth() {
        int maxDepth = 0;
        if (root != null) {
            for(int it=nodeVector.size()-1;it>0;it--){
                int depth=0;
                Node auxNode=nodeVector.get(it);
                while(auxNode.parent!=null){
                    depth++;
                    auxNode=auxNode.parent;
                }
                if(depth>maxDepth){
                    maxDepth=depth;
                }
            }
        }
        return maxDepth;
    }

    public void addRoot(int value) {
        if (root == null) {
            Node newRoot = new Node(value);
            root = newRoot;
            nodeVector.add(newRoot);
        } else try {
            throw new Exception("Root already initialised");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Node getNode(int value) {
        for (int i = 0; i < nodeVector.size(); i++) {
            if (nodeVector.get(i).value == value)
                return nodeVector.get(i);
        }
        return null;
    }

    public void addNode(Integer parentValue, int value) {
        for (Node n : nodeVector) {
            if (n.value == value) {
                return;
            }
        }
        Node parent = getNode(parentValue);
        if (parent == null && root == null) {
            addRoot(value);
        } else if (parent == null && root != null) {
            try {
                throw new Exception("Invalid Operation- Parent can't be NULL! ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Node childrenNode = new Node(value);
            parent.children.add(childrenNode);
            childrenNode.parent = parent;
            nodeVector.add(childrenNode);
        }
    }
}
