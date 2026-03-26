import java.util.Scanner;

public class task6 {
    public static void reverseStrings(Scanner scanner, int n) {
        if (n == 0) {
            return;
        }
        char[] line = scanner.nextLine().toCharArray();
        reverseStrings(scanner, n - 1);
        System.out.println(new String(line));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        reverseStrings(scanner, n);

        scanner.close();
    }
}
