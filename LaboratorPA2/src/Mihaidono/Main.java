package Mihaidono;

public class Main {

    public static void main(String[] args) {
        MyStack stack=new MyStack();

        if(stack.sEmpty()){
            System.out.println("Este goala");
        }
        else {
            System.out.println("Nu e goala");
            stack.printStack();
        }

        String line=new String("512 + 4 * +3-");

        System.out.println(stack.postFixed(line));
    }
}
