package Mihaidono;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Filework {

    public int vectorSize = 0;
    public int firstMatrixColumns = 0;
    public int secondMatrixColumns = 0;
    public int firstMatrixRows = 0;
    public int secondMatrixRows = 0;

    public int[] vectorInitialization() {
        try (BufferedReader br = new BufferedReader(new FileReader("VectorValues.txt"))) {
            String line;
            ArrayList<Integer> values = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                for (String s : parts) {
                    if (s.equals(" ")) {
                        s = "0";
                    }
                    values.add(Integer.parseInt(s));
                }
            }
            br.close();
            vectorSize = values.size();
            int[] vector = new int[values.size()];
            for (int i = 0; i < values.size(); i++) {
                vector[i] = values.get(i);
            }
            return vector;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return new int[0];
    }

    public int[][] matrixInitialization(String filename) {
        int[][] intMatrix = new int[0][0];
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int matrixColumns = 0;
            int matrixRows = 0;
            ArrayList<ArrayList<Integer>> values = new ArrayList<ArrayList<Integer>>();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                ArrayList<Integer> row = new ArrayList<>();
                for (String s : parts) {
                    if (s.equals(" ")) {
                        s = "0";
                    }
                    row.add(Integer.parseInt(s));
                }
                values.add(row);
                matrixColumns = row.size();
            }
            br.close();

            matrixRows = values.size();

            if (filename.equals("MatrixValues1.txt")) {
                firstMatrixRows=matrixRows;
                firstMatrixColumns = matrixColumns;
                intMatrix = new int[firstMatrixRows][firstMatrixColumns];
            } else if (filename.equals("MatrixValues2.txt")) {
                secondMatrixRows=matrixRows;
                secondMatrixColumns = matrixColumns;
                intMatrix = new int[secondMatrixRows][secondMatrixColumns];
            }

            if (filename.equals("MatrixValues1.txt")) {
                for (int i = 0; i < firstMatrixRows; i++) {
                    for (int j = 0; j < firstMatrixColumns; j++) {
                        intMatrix[i][j] = values.get(i).get(j);
                    }
                }
            } else if (filename.equals("MatrixValues2.txt")) {
                for (int i = 0; i < secondMatrixRows; i++) {
                    for (int j = 0; j < secondMatrixColumns; j++) {
                        intMatrix[i][j] = values.get(i).get(j);
                    }
                }
            }
            return intMatrix;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return intMatrix;
    }
}
