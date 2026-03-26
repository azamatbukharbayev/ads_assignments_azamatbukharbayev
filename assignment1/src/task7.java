import java.util.Scanner;

public class task7 {
    public static int fillSpiral(int[][] matrix, int n, int layer, int num) {
        if (layer >= n - layer) {
            return num;
        }
        for (int i = layer; i < n - layer; i++) {
            matrix[layer][i] = num;
            num++;
        }
        for (int i = layer + 1; i < n - layer; i++) {
            matrix[i][n - layer - 1] = num;
            num++;
        }
        for (int i = n - layer - 2; i >= layer; i--) {
            matrix[n - layer - 1][i] = num;
            num++;
        }
        for (int i = n - layer - 2; i > layer; i--) {
            matrix[i][layer] = num;
            num++;
        }
        return fillSpiral(matrix, n, layer + 1, num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        fillSpiral(matrix, n, 0, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}
