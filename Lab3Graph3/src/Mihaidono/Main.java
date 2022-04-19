package Mihaidono;

public class Main {

    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.nodeList.display();
        System.out.println("\n===========================");
        System.out.println("Tree before adding value 12 at node 4: ");
        tree.printTree();
        System.out.println("\n===========================");
        System.out.println("\nTree after adding value 12 at node 4: ");
        tree.insertNew(tree.nodeList,4,12);
        tree.printTree();
    }
}
