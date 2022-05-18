import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {

    public int Partition(ArrayList<Integer> arr, int p, int r) {
        int x = arr.get(p);
        int i = p - 1;
        int j = r + 1;
        while (true) {
            do {
                j--;
            } while (arr.get(j) > x);

            do {
                i++;
            } while (arr.get(i) < x);
            if (i < j) {
                int aux = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, aux);
            } else return j;
        }
    }

    public void QUICKSORT(ArrayList<Integer> arr, int p, int r) {
        if (p < r) {
            int q = Partition(arr, p, r);
            QUICKSORT(arr, p, q);
            QUICKSORT(arr, q + 1, r);
        }
    }

    public int BINSEARCH(ArrayList<Integer> sir, int value) {
        int low = 0, high = sir.get(sir.size() - 1), mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (value == sir.get(mid)) {
                return mid;
            } else if (value < sir.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int BINSEARCHRECURSIVE(ArrayList<Integer> sir, int value, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            if (value == sir.get(mid)) {
                return mid;
            } else if (value < sir.get(mid)) {
                BINSEARCHRECURSIVE(sir, value, low, mid - 1);
            } else {
                BINSEARCHRECURSIVE(sir, value, mid + 1, high);
            }
        }
        return -1;
    }
}
