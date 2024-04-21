import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

    @Test
    public void testEmptyStringReturnsZero() {
        Assertions.assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumber() {
        Assertions.assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        Assertions.assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void testMultipleNumbers() {
        Assertions.assertEquals(15, calculator.add("1,2,3,4,5"));
    }
    @Test
    public void testNewLineDelimiter() {
        Assertions.assertEquals(6, calculator.add("1\n2,3"));
    }
    @Test
    public void testDifferentDelimiter() {
        StringCalculator calc = new StringCalculator();
        Assertions.assertEquals(3, calc.add("//;\n1;2"));
    }
    @Test
    public void testNegativeNumber() {
        StringCalculator calc = new StringCalculator();
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> calc.add("1,-2,3"));
        Assertions.assertEquals("Negatives not allowed: [-2]", exception.getMessage());
    }


}

