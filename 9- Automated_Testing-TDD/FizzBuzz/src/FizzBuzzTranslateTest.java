import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FizzBuzzTranslateTest {
    @Test
    void testTranslate() {
        assertEquals("Fizz", FizzBuzzTranslate.Translate(3));
    }

    @Test
    void testTranslate2() {
        assertEquals("Buzz", FizzBuzzTranslate.Translate(5));
    }

    @Test
    void testTranslate3() {
        assertEquals("FizzBuzz", FizzBuzzTranslate.Translate(15));
    }

    @Test
    void testTranslate4() {
        assertEquals("sixteen", FizzBuzzTranslate.Translate(16));
    }

    @Test
    void testTranslate5() {
        assertEquals("twenty six", FizzBuzzTranslate.Translate(26));
    }


}