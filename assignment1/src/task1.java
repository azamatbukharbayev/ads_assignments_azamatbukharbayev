import java.util.Scanner;

public class Task1 {
    public static int sumOfSquares(int n) {
        if (n == 0) {
            return 0;
        }
        return n * n + sumOfSquares(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        int result = sumOfSquares(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(i + "^2");
            if (i < n) {
                System.out.print(" + ");
            }
        }
        System.out.println(" = " + result);
        scanner.close();
    }
}
