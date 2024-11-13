import java.util.Scanner;

public class NumberArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < array.length; i++){
            System.out.print("Enter element: " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.printf("%-20s%s","Element in array: ","" );
        for (int element: array){
            System.out.print(element + "\t");
        }
        System.out.println();
        System.out.println("Enter element to delete: ");
        int x = scanner.nextInt();
        int index_del = -1;
        for (int i = 0; i < array.length; i++){
            if (array[i] == x){
                index_del = i;
                break;
            }
        }
        if (index_del != -1){
            for (int i = index_del; i < array.length - 1; i++){
                array[i] = array[i + 1];
            }
            System.out.println("Array after delete: ");
            for (int i = 0; i < array.length - 1; i++){
                System.out.print(array[i] + "\t");
            }
        }else{
            System.out.print("Element " + x + " not found in the array");
        }
    }

}
