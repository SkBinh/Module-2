public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    public void add(Object data) {
        addLast(data);
    }

    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        numNodes++;
    }

    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void remove(Object o) {
        if (head == null) {
            return;
        }
        if (head.getData().equals(o)) {
            head = head.next;
            numNodes--;
            return;
        }
        Node current = head;
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.getData().equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public Object clone() {
        MyLinkedList<E> clonedList = new MyLinkedList<>();
        Node current = head;
        while (current != null) {
            clonedList.addLast(current.getData());
            current = current.next;
        }
        return clonedList;
    }
    public Object get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.getData();
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.next;
        }
    }

    public void indexOf(Object o) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.getData().equals(o)) {
                System.out.println(index);
                return;
            }
            current = current.next;
            index++;
        }
        System.out.println(-1);
    }
}
