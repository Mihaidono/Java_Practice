package Mihaidono;

import java.util.ArrayList;

public class Solution {
    public void INSERTION_SORT(int[] vector) {
        int key;
        int i;
        for (int j = 1; j < vector.length; j++) {
            key = vector[j];
            i = j - 1;
            while (i >= 0 && vector[i] > key) {
                vector[i + 1] = vector[i];
                i--;
            }
            vector[i + 1] = key;
        }
    }

    public void SELECTION_SORT(int[] vector) {
        int minj, minx;
        for (int i = 0; i < vector.length - 1; i++) {
            minj = i;
            minx = vector[i];
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[j] < minx) {
                    minj = j;
                    minx = vector[j];
                }
            }
            vector[minj] = vector[i];
            vector[i] = minx;
        }
    }

    public int EUCLID(int m, int n) {
        int auxiliar;
        while (n != 0) {
            auxiliar = n;
            n = m % n;
            m = auxiliar;
        }
        return m;
    }

    public int FIBO_RECURSIV(int n) {
        if (n < 2)
            return n;
        return FIBO_RECURSIV(n - 1) + FIBO_RECURSIV(n - 2);
    }

    public int FIBO_ITERATIV(int n) {
        int i = 0, j = 1, s = 1;
        for (int k = 1; k <= n; k++) {
            i = j;
            j = s;
            s = i + j;
        }
        return i;
    }

    public void PRODUS_MATRICI(int[][] A, int[][] B, int m, int n, int p) {
        int[][] C = new int[m][p];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < p; j++)
                for (int k = 0; k < n; k++)
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int RUSSE(int a, int b) {
        ArrayList<Integer> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();
        int i = 0;
        X.add(a);
        Y.add(b);

        while (X.get(i) > 1) {
            X.add(X.get(i) / 2);
            Y.add(Y.get(i) + Y.get(i));
            i++;
        }
        int prod = 0;
        while (i >= 0) {
            if (X.get(i) % 2 == 1) {
                prod += Y.get(i);
            }
            i--;
        }
        return prod;
    }
}
