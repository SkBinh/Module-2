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
        array = new int[size + 1];
        for (int i = 0; i < size; i++){
            System.out.print("Enter element: " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.printf("%-20s%s","Element in array: ","" );
        for (int i = 0; i < size; i++){
            System.out.print(array[i] + "\t");
        }
        System.out.println();

        System.out.println("Enter element to add ");
        int x = scanner.nextInt();
        System.out.println("Enter position to add ");
        int index = scanner.nextInt();

        if (index < 0 || index > size){
            System.out.print("OUT OF SIZE");
        } else {
            for (int i = size; i > index; i--){
                array[i] = array[i - 1];
            }
        }
        array[index] = x;
        System.out.printf("%-20s%s","Array after add element: ","" );
        for (int i = 0; i <= size; i++){
            System.out.print(array[i] + "\t");
        }
    }
}
