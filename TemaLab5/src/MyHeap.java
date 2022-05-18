public class MyHeap {

    public int myHeap[]={3,2,7,4,1,5,6};
    MyHeap(){

    }
    public void percolate(int T[], int i) {
        int k = i, j;
        do {
            j = k;
            if (j > 0 && T[j / 2] < T[k]) {
                k = j / 2;
            }
            int aux = T[j];
            T[j] = T[k];
            T[k] = aux;
        } while (j != k);
    }

    public void siftDown(int T[], int i) {
        int k = i, j;
        do {
            j = k;
            if (2 * j <= T.length && T[2 * j] > T[k]) {
                k = j * 2;
            }
            if (2 * j < T.length && T[2 * j + 1] > T[k]) {
                k = j * 2 + 1;
            }
            int aux = T[j];
            T[j] = T[k];
            T[k] = aux;
        } while (j != k);
    }

    public void makeHeap(int T[]) {
        for (int i = T.length / 2; i >= 1; i--) {
            siftDown(T,i);
        }
    }

    public void slowMakeHeap(int T[]){
        for(int i=1;i<=T.length;i++){
            percolate(T,i);
        }
    }

    public void alterHeap(int T[],int i,int value){
        int x=T[i];
        T[i]=value;
        if(value<x){
            siftDown(T,i);
        } else {
            percolate(T,i);
        }
    }

    public void insert(int T[],int value){
        T[T.length+1]=value;
        siftDown(T,1);
    }

    public void printHeap(){
        System.out.println("\nThe heap is: ");
        for(int it:myHeap){
            System.out.print(it+" ");
        }
    }
}
