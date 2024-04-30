import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorCLITests {
    @Test
    public void testEmptyNumberString() {

        String input = "scalc ''\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        assertEquals("0\nExiting...\n", outputStream.toString());
    }

    @Test
    public void testEmptyNumberString2() {
        String input = "scalc ''\nexit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertEquals("0\nExiting...\n", outputStream.toString());

    }

    @Test
    public void testStringCalculatorCLI() {
        String input = "1,2,3\nexit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculatorCLI = new StringCalculatorCLI(inputStream, outputStream);
        calculatorCLI.run();

        String expectedOutput = "Welcome to String Calculator!\nPlease enter numbers to calculate (type 'exit' to quit):\nThe result is: 6\nExiting...\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

}