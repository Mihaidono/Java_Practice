package Mihaidono;

enum Algorithms {
    INSERTION_SORT, SELECTION_SORT, EUCLID,
    FIBO_RECURSIV, FIBO_ITERATIV, PRODUS_MATRICI,
    RUSSE
}

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Filework fw = new Filework();

        int[] vec = new int[fw.vectorSize];
        int[][] mat1 = new int[fw.firstMatrixRows][fw.firstMatrixColumns];
        int[][] mat2 = new int[fw.secondMatrixRows][fw.secondMatrixColumns];

        int euclidVar1 = 102; //variables used
        int euclidVar2 = 18;  //for Euclid's algorithm

        int fiboVar = 12; //variable for Fibonacci

        int russeVar1 = 52;  //variables for
        int russeVar2 = 15;  //Russe multiplication

        vec = fw.vectorInitialization().clone(); //initialized vector
        mat1 = fw.matrixInitialization("MatrixValues1.txt").clone(); //initialized matrix
        mat2 = fw.matrixInitialization("MatrixValues2.txt").clone(); //initialized second matrix

        Algorithms algorithmsChoice = Algorithms.PRODUS_MATRICI; //change this to change the algorithm used

        switch (algorithmsChoice) {
            case INSERTION_SORT:
                System.out.println("Before INSERTION_SORT");
                for (int i : vec) {
                    System.out.print(i + " ");
                }
                sol.INSERTION_SORT(vec);

                System.out.println("\nAfter INSERTION_SORT");
                for (int i : vec) {
                    System.out.print(i + " ");
                }
                break;
            case SELECTION_SORT:
                System.out.println("\n\nBefore SELECTION_SORT");
                for (int i : vec) {
                    System.out.print(i + " ");
                }
                sol.SELECTION_SORT(vec);

                System.out.println("\nAfter SELECTION_SORT");
                for (int i : vec) {
                    System.out.print(i + " ");
                }
                break;
            case EUCLID:
                System.out.println("\nCMMDC pentru " + euclidVar1 + " si " + euclidVar2 +
                        " folosing algoritmul lui Euclid\nRezultatul: " + sol.EUCLID(euclidVar1, euclidVar2));
                break;
            case FIBO_ITERATIV:
                System.out.println("Fibonacii Iterativ pentru " + fiboVar + " este " + sol.FIBO_ITERATIV(fiboVar));
                break;
            case FIBO_RECURSIV:
                System.out.println("Fibonacii Recursiv pentru " + fiboVar + " este " + sol.FIBO_RECURSIV(fiboVar));
                break;
            case PRODUS_MATRICI:
                System.out.println("Matrix A:");
                for (int i = 0; i < fw.firstMatrixRows; i++) {
                    for (int j = 0; j < fw.firstMatrixColumns; j++) {
                        System.out.print(mat1[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println("\nMatrix B:");
                for (int i = 0; i < fw.secondMatrixRows; i++) {
                    for (int j = 0; j < fw.secondMatrixColumns; j++) {
                        System.out.print(mat2[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println("\nA*B:");
                sol.PRODUS_MATRICI(mat1, mat2, fw.firstMatrixRows, fw.secondMatrixRows, fw.secondMatrixColumns);
                break;
            case RUSSE:
                System.out.println("Inmultirea normala: " + russeVar1 * russeVar2);
                System.out.println("Inmultirea a la Russe: " + sol.RUSSE(russeVar1, russeVar2));
                break;

        }

    }
}
