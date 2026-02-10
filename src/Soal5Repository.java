import java.util.Scanner;

public class Soal5Repository {
    public static void execute(Scanner sc) {
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
