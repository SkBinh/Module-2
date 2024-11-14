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
        System.out.print("Enter the column index to sum: ");
        int colIndex = scanner.nextInt();
        double sum = 0;
        for (int i = 0; i < rows; i++ ){
            sum += matrix[i][colIndex];
        }
        System.out.println("The sum of column " + colIndex + " is: " + sum);
    }
}
