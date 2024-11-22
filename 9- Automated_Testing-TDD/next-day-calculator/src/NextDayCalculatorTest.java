import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NextDayCalculatorTest {
    @Test
    void getNextDayTest() {
        assertEquals("2/1/2018", NextDayCalculator.getNextDay(1, 1, 2018));
    }

    @Test
    void getNextDayTest2() {
        assertEquals("1/2/2018", NextDayCalculator.getNextDay(31, 1, 2018));
    }

    @Test
    void getNextDayTest3() {
        assertEquals("1/5/2018", NextDayCalculator.getNextDay(30, 4, 2018));
    }

    @Test
    void getNextDayTest4() {
        assertEquals("1/3/2018", NextDayCalculator.getNextDay(28, 2, 2018));
    }

    @Test
    void getNextDayTest5() {
        assertEquals("1/3/2020", NextDayCalculator.getNextDay(29, 2, 2020));
    }

    @Test
    void getNextDayTest6() {
        assertEquals("1/1/2019", NextDayCalculator.getNextDay(31, 12, 2018));
    }
}