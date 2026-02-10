import java.util.*;

public class Main {
    private static final String INTEGER_PATTERN = "-?\\d+";
    private static final String DECIMAL_PATTERN = "-?\\d+\\.\\d+";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] tokens = line.trim().split("\\s+");
        
        Scanner inputScanner = null;
        
        try {
            // Check if input starts with "Soal" identifier
            if (tokens[0].startsWith("Soal")) {
                inputScanner = new Scanner(line.substring(tokens[0].length()).trim());
                switch (tokens[0]) {
                    case "Soal1":
                        Soal1Repository.execute(inputScanner);
                        break;
                    case "Soal2":
                        Soal2Repository.execute(inputScanner);
                        break;
                    case "Soal3":
                        Soal3Repository.execute(inputScanner);
                        break;
                    case "Soal4":
                        Soal4Repository.execute(inputScanner);
                        break;
                    case "Soal5":
                        Soal5Repository.execute(inputScanner);
                        break;
                    default:
                        // Unknown Soal identifier - do nothing
                        break;
                }
            } else {
                inputScanner = new Scanner(line);
                // Auto-detect based on input pattern (for test.sh)
                if (tokens.length == 1) {
                    // Single token - could be Soal3 (int) or Soal4 (string)
                    if (tokens[0].matches(INTEGER_PATTERN)) {
                        // It's an integer
                        Soal3Repository.execute(inputScanner);
                    } else {
                        // It's a string
                        Soal4Repository.execute(inputScanner);
                    }
                } else if (tokens.length == 2) {
                    // Two tokens - could be Soal1 (two ints) or Soal2 (two doubles)
                    // Check if either token is a decimal number
                    boolean hasDecimal = tokens[0].matches(DECIMAL_PATTERN) || 
                                        tokens[1].matches(DECIMAL_PATTERN);
                    if (hasDecimal) {
                        Soal2Repository.execute(inputScanner);
                    } else {
                        Soal1Repository.execute(inputScanner);
                    }
                } else if (tokens.length == 3) {
                    // Three tokens - Soal5 (int, double, boolean)
                    Soal5Repository.execute(inputScanner);
                }
            }
        } finally {
            if (inputScanner != null) {
                inputScanner.close();
            }
            sc.close();
        }
    }
}
