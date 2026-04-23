import java.util.Arrays;

public class DivideAndConquer {
    static int comparisonCount = 0;

    public static int[] findMaxMinDC(int[] arr, int low, int high) {
        int[] result = new int[2];

        if (low == high) {
            result[0] = arr[low];
            result[1] = arr[low];
            System.out.println("  Base case: arr[" + low + "] = " + arr[low]
                    + " → max=" + result[0] + ", min=" + result[1]);
            return result;
        }

        if (high == low + 1) {
            comparisonCount++;
            if (arr[low] > arr[high]) {
                result[0] = arr[low];
                result[1] = arr[high];
            } else {
                result[0] = arr[high];
                result[1] = arr[low];
            }
            System.out.println("  Base case: arr[" + low + "]=" + arr[low]
                    + ", arr[" + high + "]=" + arr[high]
                    + " → max=" + result[0] + ", min=" + result[1]);
            return result;
        }

        int mid = (low + high) / 2;

        System.out.println("  Divide: [" + low + ".." + mid + "] and [" + (mid + 1) + ".." + high + "]");

        int[] leftResult = findMaxMinDC(arr, low, mid);
        int[] rightResult = findMaxMinDC(arr, mid + 1, high);

        comparisonCount++;
        if (leftResult[0] > rightResult[0]) {
            result[0] = leftResult[0];
        } else {
            result[0] = rightResult[0];
        }

        comparisonCount++;
        if (leftResult[1] < rightResult[1]) {
            result[1] = leftResult[1];
        } else {
            result[1] = rightResult[1];
        }

        System.out.println("  Combine [" + low + ".." + high + "]: max="
                + result[0] + ", min=" + result[1]);

        return result;
    }

    public static int[] findMaxMinNaive(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int comparisons = 0;

        for (int i = 1; i < arr.length; i++) {
            comparisons++;
            if (arr[i] > max) {
                max = arr[i];
            }

            comparisons++;
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("  Naive approach: max=" + max + ", min=" + min);
        System.out.println("  Naive comparisons: " + comparisons);

        return new int[]{max, min};
    }

    public static void main(String[] args) {
        int[] data = {43, 42, 90, 74, 10, 29, 68, 73, 75, 62};

        System.out.println("====== Divide and Conquer: Find Range (Max - Min) ======");
        System.out.println("Dataset: " + Arrays.toString(data));
        System.out.println();

        System.out.println("--- Divide and Conquer Approach ---");
        comparisonCount = 0;

        int[] dcResult = findMaxMinDC(data, 0, data.length - 1);

        int max = dcResult[0];
        int min = dcResult[1];
        int range = max - min;

        System.out.println();
        System.out.println("D&C Result:");
        System.out.println("  Maximum: " + max);
        System.out.println("  Minimum: " + min);
        System.out.println("  Range (Max - Min): " + max + " - " + min + " = " + range);
        System.out.println("  D&C comparisons: " + comparisonCount);

        System.out.println();
        System.out.println("--- Naive Iterative Approach ---");
        int[] naiveResult = findMaxMinNaive(data);

        int naiveRange = naiveResult[0] - naiveResult[1];
        System.out.println("  Range (Max - Min): " + naiveResult[0] + " - " + naiveResult[1] + " = " + naiveRange);

        System.out.println();
        System.out.println("--- Efficiency Comparison ---");
        System.out.println("  Array size N = " + data.length);
        System.out.println("  Naive approach:  2*(N-1) = " + (2 * (data.length - 1)) + " comparisons");
        System.out.println("  D&C approach:    ~3N/2-2 = " + comparisonCount + " comparisons");
        System.out.println("  D&C saves about " + (2 * (data.length - 1) - comparisonCount) + " comparisons!");
        System.out.println();
        System.out.println("  Both give the same answer, but D&C uses fewer comparisons.");
        System.out.println("  Naive Time: O(N), Space: O(1)");
        System.out.println("  D&C   Time: O(N), Space: O(log N) due to recursion stack");
    }
}
