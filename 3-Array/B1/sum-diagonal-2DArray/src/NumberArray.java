import java.util.Scanner;

public class NumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of square: ");
        int size = scanner.nextInt();

        double[][] matrix = new double[size][size];
        System.out.println("Enter element of the matrix:");
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print("Element at [" + i + "][" + j + "]:");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        double sum = 0;
        for (int i = 0; i < size; i++ ){
            sum += matrix[i][i];
        }
        System.out.println("The sum of diagonal is: " + sum);
    }
}
