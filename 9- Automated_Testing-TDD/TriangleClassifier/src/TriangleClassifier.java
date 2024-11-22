public class TriangleClassifier {
    public String classifyTriangle(int a, int b, int c) {
        if (a < b + c && b < a + c && c < a + b) {
            if (a == b && b == c) {
                return "TriangleEquilateral";
            } else if (a == b || b == c || a == c) {
                return "TriangleIsosceles";
            } else {
                return "TriangleScalene";
            }
        } else {
            return "NotTriangle";
        }
    }
}
