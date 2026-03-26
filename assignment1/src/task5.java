import java.util.Scanner;

public class task5 {
    public static void reverseSequence(Scanner scanner, int n) {
        if (n == 0) {
            return;
        }
        int num = scanner.nextInt();
        reverseSequence(scanner, n - 1);
        System.out.print(num + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        reverseSequence(scanner, n);
        System.out.println();

        scanner.close();
    }
}
