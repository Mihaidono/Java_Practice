package Mihaidono;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Tree tree=new Tree();
        tree.addRoot(7);
        tree.addNode(7,3);
        tree.addNode(7,10);
        tree.addNode(7,4);

        tree.addNode(4,7);  //these two shouldn't work
        tree.addNode(4,10); //they are test calls for testing code

        tree.addNode(3,8);
        tree.addNode(3,12);
        tree.addNode(10,11);
        tree.addNode(4,2);

        tree.addNode(8,6);
        tree.addNode(8,5);
        tree.addNode(12,1);

        tree.addNode(5,9);


        tree.displayTree();
        System.out.println("Values Vector: ");
        tree.displayNodeArray();
        System.out.println("\nFor example: the number 5 Node has the key: "+ tree.getNodeKey(5));
        System.out.println("And for 7 is: "+tree.getNodeKey(7));
        System.out.println("And for 4 is: "+tree.getNodeKey(4));

        System.out.println("\nGraph's depth is: "+tree.calculateDepth());
    }
}
