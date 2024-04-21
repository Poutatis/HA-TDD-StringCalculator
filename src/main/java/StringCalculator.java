import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String delimiter = ",";
            if (numbers.startsWith("//")) {
                int delimiterIndex = numbers.indexOf("\n");
                delimiter = numbers.substring(2, delimiterIndex);
                numbers = numbers.substring(delimiterIndex + 1);
            }
            String[] nums = numbers.split("[,\n" + delimiter + "]");
            int sum = 0;
            List<Integer> negatives = new ArrayList<>();
            for (String num : nums) {
                int n = Integer.parseInt(num);
                if (n < 0) {
                    negatives.add(n);
                }
                sum += n;
            }
            if (!negatives.isEmpty()) {
                throw new IllegalArgumentException("Negatives not allowed: " + negatives);
            }
            return sum;
        }
    }
}
