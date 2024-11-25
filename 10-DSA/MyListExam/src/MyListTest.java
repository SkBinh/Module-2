public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        myList.add(10);
        myList.add(20);
        myList.add(30);

        System.out.println("Size after adding elements: " + myList.getSize());

        System.out.println("Element at index 1: " + myList.get(1));

        myList.remove(1);
        System.out.println("Size after removing element at index 1: " + myList.getSize());

        System.out.println("Element at index 1 after removal: " + myList.get(1));

        MyList<Integer> clonedList = myList.clone();
        System.out.println("Cloned list size: " + clonedList.getSize());
        System.out.println("Element at index 0 in cloned list: " + clonedList.get(0));

        System.out.println("Is original list empty? " + myList.isEmpty());

        myList.clear();
        System.out.println("Size after clearing the list: " + myList.getSize());
        System.out.println("Is original list empty after clearing? " + myList.isEmpty());
    }
}