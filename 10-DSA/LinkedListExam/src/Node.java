public class Node {
    Node next;
    private Object data;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }
}
