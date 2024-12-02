public class InsertionSort {

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 4, 2};
        insertionSort(numbers);

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
