import java.util.Scanner;

public class Task1 {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length;
        int expectedSum = (n + 1) * (n + 2) / 2;
        int actualSum = 0;
        for (int i = 0; i < n; i++) {
            actualSum += arr[i];
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array (N): ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " distinct numbers from 1 to " + (n + 1) + " (one missing):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int missing = findMissingNumber(arr);
        System.out.println("The missing number is: " + missing);

        scanner.close();
    }
}