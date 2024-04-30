import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorCLITests {
    @Test
    public void testEmptyNumberString() {
        String input = "scalc ''" + System.lineSeparator() + "exit";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        StringCalculatorCLI calculator = new StringCalculatorCLI(inputStream, outputStream);
        calculator.run();

        assertEquals("0" + System.lineSeparator() + "Exiting..." + System.lineSeparator(), outputStream.toString());
    }

    @Test
    public void testEmptyNumberString2() {
        String input = "scalc ''" + System.lineSeparator() + "exit";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StringCalculatorCLI calculator = new StringCalculatorCLI();
        calculator.run();

        assertEquals("0" + System.lineSeparator() + "Exiting..." + System.lineSeparator(), outputStream.toString());
    }
}
