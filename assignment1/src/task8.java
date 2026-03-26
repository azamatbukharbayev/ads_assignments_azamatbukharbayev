import java.util.Scanner;
public class task8 {
    public static void generateSequences(int[] sequence, int n, int k, int pos) {
        if (pos == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(sequence[i]);
                if (i < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            return;
        }
        for (int val = 1; val <= k; val++) {
            sequence[pos] = val;
            generateSequences(sequence, n, k, pos + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] sequence = new int[n];
        generateSequences(sequence, n, k, 0);

        scanner.close();
    }
}
