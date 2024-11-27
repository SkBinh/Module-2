public class Main {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);

        System.out.println("Queue after enQueue operation  ");
        queue.display();

        System.out.println("DeQueue: " + queue.deQueue());
        System.out.println("DeQueue: " + queue.deQueue());

        System.out.println("Queue after DeQueue operation  ");
        queue.display();

        queue.enQueue(50);
        System.out.println("Queue after adding another element  ");
        queue.display();
    }
}