import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TriangleClassifierTest {
    @Test
    void testClassifyTriangle() {
        TriangleClassifier classifier = new TriangleClassifier();
        assertEquals("TriangleEquilateral", classifier.classifyTriangle(2, 2, 2));
    }

    @Test
    void testClassifyTriangle2() {
        TriangleClassifier classifier = new TriangleClassifier();
        assertEquals("TriangleIsosceles", classifier.classifyTriangle(2, 2, 3));
    }

    @Test
    void testClassifyTriangle3() {
        TriangleClassifier classifier = new TriangleClassifier();
        assertEquals("TriangleScalene", classifier.classifyTriangle(3, 4, 5));
    }

    @Test
    void testClassifyTriangle4() {
        TriangleClassifier classifier = new TriangleClassifier();
        assertEquals("NotTriangle", classifier.classifyTriangle(8, 2, 3));
    }

    @Test
    void testClassifyTriangle5() {
        TriangleClassifier classifier = new TriangleClassifier();
        assertEquals("NotTriangle", classifier.classifyTriangle(-1, 2, 1));
    }

    @Test
    void testClassifyTriangle6() {
        TriangleClassifier classifier = new TriangleClassifier();
        assertEquals("NotTriangle", classifier.classifyTriangle(0, 1, 1));
    }
}