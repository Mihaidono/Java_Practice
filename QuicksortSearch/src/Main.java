import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Solution sol=new Solution();
        ArrayList<Integer> myArray=new ArrayList<>();

        myArray.add(5);
        myArray.add(3);
        myArray.add(2);
        myArray.add(1);
        myArray.add(4);
        myArray.add(6);
        myArray.add(5);
        myArray.add(7);
        System.out.println("Original array: ");
        for(int i:myArray){
            System.out.print(i+" ");
        }
        System.out.println("\nAfter quicksort:");
        sol.QUICKSORT(myArray,0,myArray.size()-1);
        for(int i:myArray){
            System.out.print(i+" ");
        }
        System.out.println("\nBinary search normal: caut 2 in sir si il gaseste pe pozitia: "+ (sol.BINSEARCH(myArray,2)+1));

        System.out.println("\nBinary search recursiv: caut 8 in sir si il gaseste pe pozitia: "+
                (sol.BINSEARCHRECURSIVE(myArray,8,myArray.get(0),myArray.get(myArray.size()-1))+1));
    }
}