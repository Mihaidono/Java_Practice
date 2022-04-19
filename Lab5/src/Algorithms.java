import java.util.ArrayList;

public class Algorithms {
    public void makeHeap(ArrayList<Integer> T){
        for(int i=2;i<=T.size();i++){
            percolate(T,i);
        }
    }

    public void percolate(ArrayList<Integer> T, int i) {
        int k = i, j = k;
        do {
            if (j > 1 && T.get(j / 2) < T.get(k)) {
                k = j / 2;
            }
            int aux = T.get(j);
            T.set(j, T.get(k));
            T.set(k, aux);
            j = k;
        } while (j != k);
    }

    public void siftDown(ArrayList<Integer> T, int i) {
        int k = i, j = k;
        do {
            if (2*j < T.size() && T.get(2*j) > T.get(k)) {
                k = 2*j;
            }
            if (2*j < T.size() && T.get(2*j+1) > T.get(k)) {
                k = 2*j+1;
            }
            int aux = T.get(j);
            T.set(j, T.get(k));
            T.set(k, aux);
            j = k;
        } while (j != k);
    }
}
