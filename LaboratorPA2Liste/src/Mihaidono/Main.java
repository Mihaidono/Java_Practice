package Mihaidono;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyChainedList mcl=new MyChainedList();
        mcl.addNode(5);
        mcl.addNode(6);
        mcl.addNode(7);
        mcl.addNode(8);
        mcl.addNode(9);

        mcl.display();
        mcl.delete(1);
        System.out.println("\nAfter Delete of index 1: ");
        mcl.display();
        System.out.println("\nAfter insertion in the middle: ");
        mcl.InsertPos(mcl.size()/2,12);
        mcl.display();
    }
}
