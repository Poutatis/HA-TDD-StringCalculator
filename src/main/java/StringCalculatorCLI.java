import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StringCalculatorCLI {

    private final InputStream inputStream;
    private final OutputStream outputStream;

    public StringCalculatorCLI(){
        inputStream = System.in;
        outputStream = System.out;
    }

    public StringCalculatorCLI(InputStream inputStream, OutputStream outputStream){
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void run() {
        Scanner scanner = new Scanner(inputStream);
        PrintStream out = new PrintStream(outputStream);

        out.println("Welcome to String Calculator!");

        StringCalculator calculator = new StringCalculator(new LoggerStub());

        // Loopar tills användaren skriver "exit"
        while (true) {
            out.println("Please enter numbers to calculate (type 'exit' to quit):");
            String input = scanner.nextLine(); // läser nästa line input

            // Checkar om användaren vill exita programmet
            if ("exit".equalsIgnoreCase(input)) {
                break; // Exitar loopen
            }

            // Processar inputten
            try {
                int result = calculator.add(input);
                out.println("The result is: " + result);
            } catch (IllegalArgumentException e) {
                out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        out.println("Exiting...");
    }

}
