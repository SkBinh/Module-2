public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        System.out.println("Adding elements to the list:");
        list.add(1);
        list.add(2);
        list.add(3);
        list.printList();

        System.out.println("Size of the list: " + list.size());

        System.out.println("Adding 0 at the beginning:");
        list.addFirst(0);
        list.printList();

        System.out.println("Does the list contain 2? " + list.contains(2));
        System.out.println("Does the list contain 4? " + list.contains(4));

        System.out.print("Index of 2: ");
        list.indexOf(2);
        System.out.print("Index of 4: ");
        list.indexOf(4);

        System.out.println("Removing element 2:");
        list.remove(2);
        list.printList();

        System.out.println("Size of the list after removal: " + list.size()); // Expected: 3

        System.out.println("Clearing the list:");
        list.clear();
        System.out.println("Size of the list after clearing: " + list.size()); // Expected: 0

        System.out.println("Cloning the list:");
        list.add(1);
        list.add(2);
        list.add(3);
        MyLinkedList<Integer> clonedList = (MyLinkedList<Integer>) list.clone();
        clonedList.printList();

        System.out.println("Element at index 1: " + list.get(1));
    }
}