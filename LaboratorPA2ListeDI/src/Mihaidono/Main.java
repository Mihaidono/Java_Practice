package Mihaidono;

public class Main {

    public static void main(String[] args) {
        MyDChainedList list = new MyDChainedList();
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);

        list.display();
        System.out.println("\nList after second index is deleted: ");
        list.delete(4);
        list.display();
        System.out.println("\nList after insertion in the middle: ");
        list.insertPos(list.size()/2,12);
        list.display();

    }
}
