import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] tokens = line.trim().split("\\s+");
        
        // Check if input starts with "Soal" identifier
        if (tokens[0].startsWith("Soal")) {
            switch (tokens[0]) {
                case "Soal1":
                    executeSoal1(new Scanner(line.substring(6)));
                    break;
                case "Soal2":
                    executeSoal2(new Scanner(line.substring(6)));
                    break;
                case "Soal3":
                    executeSoal3(new Scanner(line.substring(6)));
                    break;
                case "Soal4":
                    executeSoal4(new Scanner(line.substring(6)));
                    break;
                case "Soal5":
                    executeSoal5(new Scanner(line.substring(6)));
                    break;
            }
        } else {
            // Auto-detect based on input pattern (for test.sh)
            if (tokens.length == 1) {
                // Single token - could be Soal3 (int) or Soal4 (string)
                try {
                    int n = Integer.parseInt(tokens[0]);
                    executeSoal3(new Scanner(line));
                } catch (NumberFormatException e) {
                    executeSoal4(new Scanner(line));
                }
            } else if (tokens.length == 2) {
                // Two tokens - could be Soal1 (two ints) or Soal2 (two doubles)
                if (tokens[0].contains(".") || tokens[1].contains(".")) {
                    executeSoal2(new Scanner(line));
                } else {
                    executeSoal1(new Scanner(line));
                }
            } else if (tokens.length == 3) {
                // Three tokens - Soal5 (int, double, boolean)
                executeSoal5(new Scanner(line));
            }
        }
        
        sc.close();
    }
    
    // Soal 1: Integer Overflow Detection
    private static void executeSoal1(Scanner sc) {
        Soal1Repository.execute(sc);
    }
    
    // Soal 2: Float vs Double Precision
    private static void executeSoal2(Scanner sc) {
        Soal2Repository.execute(sc);
    }
    
    // Soal 3: Primitive vs Wrapper Comparison
    private static void executeSoal3(Scanner sc) {
        Soal3Repository.execute(sc);
    }
    
    // Soal 4: String Immutability & Reference
    private static void executeSoal4(Scanner sc) {
        Soal4Repository.execute(sc);
    }
    
    // Soal 5: Parsing & Type Safety
    private static void executeSoal5(Scanner sc) {
        Soal5Repository.execute(sc);
    }
}
