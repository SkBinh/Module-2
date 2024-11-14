import java.util.Scanner;

public class NumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of cols: ");
        int cols = scanner.nextInt();

        double[][] matrix = new double[rows][cols];
        System.out.println("Enter element of the matrix:");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                System.out.print("Element at [" + i + "][" + j + "]:");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        double max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (matrix[i][j] > max){
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("The largest element is: " + max);
        System.out.println("Located at row " + maxRow + ", column " + maxCol);
    }
}
