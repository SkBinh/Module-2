import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter elements of array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        System.out.println("Array after sorting: " + Arrays.toString(array));
        System.out.println("Enter element to search: ");
        int element = scanner.nextInt();
        int result = binarySearch(array, 0, array.length - 1, element);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
    public static int binarySearch(int[] array, int left, int right, int element) {
        if (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == element) {
                return middle;
            } else if (array[middle] < element) {
                return binarySearch(array, middle + 1, right, element);
            } else {
                return binarySearch(array, left, middle - 1, element);
            }
        }
        return -1;
    }

}

