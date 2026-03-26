import java.util.Scanner;

public class task4 {
    public static int power(int b, int n) {
        if (n == 0) {
            return 1;
        }
        return b * power(b, n - 1);
    }
    public static int sumOfPowers(int b, int n) {
        if (n == 0) {
            return 1;
        }
        return power(b, n) + sumOfPowers(b, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base b: ");
        int b = scanner.nextInt();
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        int result = sumOfPowers(b, n);
        for (int i = 0; i <= n; i++) {
            System.out.print(b + "^" + i);
            if (i < n) {
                System.out.print(" + ");
            }
        }
        System.out.println(" = " + result);

        scanner.close();
    }
}
