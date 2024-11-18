public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint point1 = new MovablePoint(5, 3, 10, 20);
        System.out.println(point1);
        point1.accelerate(2, 2);
        System.out.println(point1);
        point1.move();
        System.out.println(point1);
    }
}
