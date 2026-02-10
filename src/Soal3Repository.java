import java.util.Scanner;

public class Soal3Repository {
    public static void execute(Scanner sc) {
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
}
