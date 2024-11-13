import java.util.Scanner;

public class NumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size array 1: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];
        System.out.print("Enter size array 2: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];

        System.out.println("Enter element array 1: ");
        for (int i = 0; i < size1; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array1[i] = scanner.nextInt();
        }
        System.out.println("Enter element array 2: ");
        for (int i = 0; i < size2; i++){
            System.out.print("Element " + (i + 1) + ": " );
            array2[i] = scanner.nextInt();
        }
        int[] mergeArray = new int[size1 + size2];
        for (int i = 0; i < size1; i++){
            mergeArray[i] = array1[i];
        }
        for (int i = 0; i < size2; i++){
            mergeArray[i + size1] = array2[i];
        }
        System.out.println("Merged array: ");
        for (int element : mergeArray){
            System.out.print(element + "\t");
        }
    }
}
