import java.util.Arrays;

public class Bubble {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(arr));

            if (!swapped) {
                System.out.println("Early Exit! No swaps in pass " + (i + 1) + " → array is sorted.");
                return;
            }
        }
    }

    public static void traceThreePasses(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < 3; i++) {
            System.out.println("\n--- Pass " + (i + 1) + " ---");

            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print("  Compare arr[" + j + "]=" + arr[j]
                        + " and arr[" + (j + 1) + "]=" + arr[j + 1]);

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;

                    System.out.println(" → SWAP");
                } else {
                    System.out.println(" → no swap");
                }
            }

            System.out.println("Array after pass " + (i + 1) + ": " + Arrays.toString(arr));

            if (!swapped) {
                System.out.println("Early Exit! No swaps were needed in this pass.");
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {43, 42, 90, 74, 10, 29, 68, 73, 75, 62};
        System.out.println("Original array: " + Arrays.toString(data));
        System.out.println("\n====== Detailed Trace of First 3 Passes ======");
        traceThreePasses(data);

        int[] dataCopy = {43, 42, 90, 74, 10, 29, 68, 73, 75, 62};
        System.out.println("\n\n====== Full Bubble Sort ======");
        System.out.println("Before sorting: " + Arrays.toString(dataCopy));
        bubbleSort(dataCopy);
        System.out.println("Final sorted:   " + Arrays.toString(dataCopy));

        int[] sorted = {10, 29, 42, 43, 62, 68, 73, 74, 75, 90};
        System.out.println("\n\n====== Early Exit Demo (already sorted) ======");
        System.out.println("Input: " + Arrays.toString(sorted));
        bubbleSort(sorted);

        System.out.println("\n--- Early Exit Explanation ---");
        System.out.println("The 'Early Exit' condition works like this:");
        System.out.println("Before each pass, we set a flag 'swapped = false'.");
        System.out.println("If we go through the entire pass without swapping,");
        System.out.println("it means every adjacent pair is already in order,");
        System.out.println("which means the whole array is sorted. So we stop.");
    }
}
