import java.util.Arrays;

public class Heap {
    public static void siftDown(int[] arr, int n, int i) {
        int largest = i;
        int left  = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            siftDown(arr, n, largest);
        }
    }

    public static void buildMaxHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, n, i);
        }
    }

    public static int extractMax(int[] arr, int heapSize) {
        int maxValue = arr[0];

        arr[0] = arr[heapSize - 1];

        siftDown(arr, heapSize - 1, 0);

        return maxValue;
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        buildMaxHeap(arr, n);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            siftDown(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] data = {43, 42, 90, 74, 10, 29, 68, 73, 75, 62};

        System.out.println("Original array:          " + Arrays.toString(data));

        int n = data.length;
        buildMaxHeap(data, n);

        System.out.println("After heapification:     " + Arrays.toString(data));

        int max = extractMax(data, n);
        n = n - 1;

        System.out.println("Extracted max value:     " + max);
        System.out.println("After first extract-max: " + Arrays.toString(data));
        System.out.println("(Heap occupies indices 0.." + (n - 1) + "; index " + n + " holds the extracted max)");

        int[] dataCopy = {43, 42, 90, 74, 10, 29, 68, 73, 75, 62};
        System.out.println("\n--- Full Heap Sort Demo ---");
        System.out.println("Before sorting: " + Arrays.toString(dataCopy));
        heapSort(dataCopy);
        System.out.println("After sorting:  " + Arrays.toString(dataCopy));
    }
}
