package Mihaidono;

public class Main {

    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.nodeList.display();
        System.out.println("\nSearch by key:\n"+tree.searchByKey(tree.nodeList.getNode(7),1));
        System.out.println("===========================");
        System.out.println("Tree before adding value 12 at node 4: ");
        tree.printTree();
        System.out.println("\nTree after adding value 12 at node 4: ");
        tree.insertNew(tree.nodeList,4,12);
        tree.printTree();
        System.out.println("\n===========================");
    }
}
