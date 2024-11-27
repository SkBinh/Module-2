public class CircularQueue {
    private Node front;
    private Node rear;

    public CircularQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int value) {
        Node newNode = new Node(value);

        if (front == null) {
            front = rear = newNode;
            rear.next = front;
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
    }

    public int deQueue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value;

        if (front == rear) {
            value = front.data;
            front = rear = null;
        } else {
            value = front.data;
            front = front.next;
            rear.next = front;
        }
        return value;
    }

    public void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;
        System.out.print("Queue: ");

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);

        System.out.println();
    }
}
