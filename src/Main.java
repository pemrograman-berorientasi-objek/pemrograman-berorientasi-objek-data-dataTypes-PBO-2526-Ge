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
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // Check for overflow without using long or try-catch
        if (a > 0 && b > 0 && (Integer.MAX_VALUE - a) < b) {
            System.out.println("OVERFLOW");
        } else if (a < 0 && b < 0 && (Integer.MIN_VALUE - a) > b) {
            System.out.println("OVERFLOW");
        } else {
            System.out.println(a + b);
        }
    }
    
    // Soal 2: Float vs Double Precision
    private static void executeSoal2(Scanner sc) {
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        
        // Calculate using float
        float sumFloat = (float)x + (float)y;
        
        // Calculate using double
        double sumDouble = x + y;
        
        // Calculate absolute difference
        double difference = Math.abs(sumFloat - sumDouble);
        
        // Print with 6 decimal places
        System.out.printf("%.6f%n", difference);
    }
    
    // Soal 3: Primitive vs Wrapper Comparison
    private static void executeSoal3(Scanner sc) {
        int N = sc.nextInt();
        
        // Store N in Integer a
        Integer a = N;
        
        // Copy value to Integer b
        Integer b = a;
        
        // Add 1 to a (this creates a new Integer object)
        a = a + 1;
        
        // Compare using ==
        boolean refEqual = (a == b);
        System.out.println("==: " + refEqual);
        
        // Compare using equals()
        boolean valueEqual = a.equals(b);
        System.out.println("equals: " + valueEqual);
    }
    
    // Soal 4: String Immutability & Reference
    private static void executeSoal4(Scanner sc) {
        String S = sc.next();
        
        // Create String a = S
        String a = S;
        
        // Create String b = new String(S)
        String b = new String(S);
        
        // Concatenate "X" to a (creates a new String)
        a = a + "X";
        
        // Compare using ==
        boolean refEqual = (a == b);
        System.out.println("==: " + refEqual);
        
        // Compare using equals()
        boolean valueEqual = a.equals(b);
        System.out.println("equals: " + valueEqual);
    }
    
    // Soal 5: Parsing & Type Safety
    private static void executeSoal5(Scanner sc) {
        int intValue = sc.nextInt();
        double doubleValue = sc.nextDouble();
        boolean boolValue = sc.nextBoolean();
        
        // Calculate integer × double
        double result = intValue * doubleValue;
        
        // If boolean is false, multiply by -1
        if (!boolValue) {
            result = result * -1;
        }
        
        // Print with 2 decimal places
        System.out.printf("%.2f%n", result);
    }
}
