import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private final Logger logger;

    public StringCalculator(){
        logger = new LoggerStub();
    }

    public StringCalculator(Logger logger){
        this.logger = logger;
    }
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String delimiter = ",";
            if (numbers.startsWith("//")) {
                Matcher matcher = Pattern.compile("//\\[(.*?)\\]").matcher(numbers);
                if (matcher.find()) {
                    delimiter = matcher.group(1);
                    numbers = numbers.substring(matcher.end() + 1);
                }
            }

            // Extractar flera delimiters
            Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(delimiter);
            StringBuilder delimitersRegex = new StringBuilder();
            while (matcher.find()) {
                if (delimitersRegex.length() > 0) {
                    delimitersRegex.append("|");
                }
                delimitersRegex.append(Pattern.quote(matcher.group(1)));
            }
            if (delimitersRegex.length() == 0) {
                delimitersRegex.append(",");
            }

            Pattern pattern = Pattern.compile("-?\\d+");
            Matcher numMatcher = pattern.matcher(numbers);

            int sum = 0;
            List<Integer> negatives = new ArrayList<>();
            while (numMatcher.find()) {
                int n = Integer.parseInt(numMatcher.group());
                if (n < 0) {
                    negatives.add(n);
                }
                sum += n;
                // Log nummer större än 1000
                if (n > 1000) {
                    logger.log(n);
                }
            }
            if (!negatives.isEmpty()) {
                throw new IllegalArgumentException("Negatives not allowed: " + negatives);
            }
            return sum;
        }
    }
}
