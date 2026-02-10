import java.util.Scanner;

public class Soal1Repository {
    public static void execute(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // Check for overflow without using long or try-catch
        // If signs are the same and result has different sign, overflow occurred
        if (a > 0 && b > 0 && (Integer.MAX_VALUE - a) < b) {
            System.out.println("OVERFLOW");
        } else if (a < 0 && b < 0 && (Integer.MIN_VALUE - a) > b) {
            System.out.println("OVERFLOW");
        } else {
            System.out.println(a + b);
        }
    }
}
