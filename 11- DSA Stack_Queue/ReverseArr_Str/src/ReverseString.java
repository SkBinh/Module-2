import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello World Java Stack";
        System.out.println("Original String: " + str);

        String reversed = reverseString(str);
        System.out.println("Reversed String: " + reversed);
    }

    private static String reverseString(String str) {
        Stack<String> stack = new Stack<>();

        for (String word : str.split(" ")) {
            stack.push(word);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
            reversed.append(" ");
        }

        return reversed.toString().trim();


    }
}
