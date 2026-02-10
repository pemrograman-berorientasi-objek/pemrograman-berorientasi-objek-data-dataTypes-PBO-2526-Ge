import java.util.Scanner;

public class Soal4Repository {
    public static void execute(Scanner sc) {
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
}
