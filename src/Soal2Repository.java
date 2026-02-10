import java.util.Scanner;

public class Soal2Repository {
    public static void execute(Scanner sc) {
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
}
