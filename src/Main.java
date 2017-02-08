import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inM = new Scanner(System.in);
        System.out.print("m = ");
        int m = inM.nextInt();
        Scanner inN = new Scanner(System.in);
        System.out.print("n = ");
        int n = inN.nextInt();
        int matrix[][] = new int[m][n];
        generateMatrix(matrix);
        printMatrix(snakeMatrix(matrix));

    }

    private static int[][] generateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Print matrix: ");
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printFinalMatrix(int[][] matrix) {
        System.out.println("Print final matrix: ");
        while (matrix[0][0] != 1) {
            rotateMatrix(matrix);
        }
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] rotateMatrix(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for (int i = newMatrix.length - 1; i >= 0; i--) {
            for (int j = 0; j <= newMatrix[0].length - 1; j++) {
                newMatrix[newMatrix.length - 1 - i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }

    private static int[][] snakeMatrix(int[][] matrix) {

        for (int step = 0, number = 0, temp = 0; step < matrix.length + matrix[0].length - 1; step++) {
//            System.out.println("Step " + (step + 1));
            if (step >= 4 && step % 4 == 0)
                temp++;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[temp][j] == 0) {
                        matrix[temp][j] = ++number;
                    }
//                    System.out.print(matrix[i][j] + "\t");
                }
//                System.out.println();
            }
            matrix = rotateMatrix(matrix);
//            System.out.println();
        }
        return matrix;
    }
}
