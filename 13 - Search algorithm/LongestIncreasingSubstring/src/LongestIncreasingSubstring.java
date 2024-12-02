import java.util.Scanner;

public class LongestIncreasingSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        String result = findIncreasingSubstring(input);
        System.out.println("Longest increasing substring: " + result);
    }

    public static String findIncreasingSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current >= result.charAt(result.length() - 1)) {
                result.append(current);
            }
        }

        return result.toString();
    }
}
