import java.util.Arrays;

public class Quick {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;

        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;

                i++;
            }
        }

        int swap = arr[i];
        arr[i] = arr[high];
        arr[high] = swap;

        return i;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);

            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static void demonstratePartition(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int pivot = arr[low];

        System.out.println("Pivot chosen: arr[0] = " + pivot);
        System.out.println("Array before partition: " + Arrays.toString(arr));

        int pivotIndex = partition(arr, low, high);

        System.out.println("Array after partition:  " + Arrays.toString(arr));
        System.out.println("Pivot " + pivot + " is now at index " + pivotIndex);

        System.out.print("Left of pivot  (≤ " + pivot + "): [");
        for (int i = 0; i < pivotIndex; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println("]");

        System.out.print("Right of pivot (> " + pivot + "): [");
        for (int i = pivotIndex + 1; i < arr.length; i++) {
            if (i > pivotIndex + 1) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] data = {43, 42, 90, 74, 10, 29, 68, 73, 75, 62};
        System.out.println("====== Partitioning Step Demonstration ======");
        System.out.println("Original array: " + Arrays.toString(data));
        System.out.println();
        demonstratePartition(data);

        int[] dataCopy = {43, 42, 90, 74, 10, 29, 68, 73, 75, 62};
        System.out.println("\n\n====== Full Quick Sort ======");
        System.out.println("Before sorting: " + Arrays.toString(dataCopy));
        quickSort(dataCopy, 0, dataCopy.length - 1);
        System.out.println("After sorting:  " + Arrays.toString(dataCopy));
    }
}
