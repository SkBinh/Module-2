public class Main {
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("Alice");
        student.setClasses("C03");

        System.out.println("Student name: " + student.getName());
        System.out.println("Student class: " + student.getClasses());
    }
}