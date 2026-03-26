import java.util.Scanner;

public class task9 {
    public static void permute(char[] arr, int start, int end) {
        if (start == end) {
            System.out.println(new String(arr));
            return;
        }
        for (int i = start; i <= end; i++) {
            char temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            permute(arr, start + 1, end);
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] arr = input.toCharArray();
        permute(arr, 0, arr.length - 1);

        scanner.close();
    }
}
