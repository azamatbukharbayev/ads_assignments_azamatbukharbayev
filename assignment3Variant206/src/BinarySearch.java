import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int step = 1;

        System.out.println("Searching for target: " + target);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println();

        while (low <= high) {
            int mid = (low + high) / 2;

            System.out.println("Step " + step + ":");
            System.out.println("  Low = " + low + ", High = " + high + ", Mid = " + mid);
            System.out.println("  arr[Mid] = arr[" + mid + "] = " + arr[mid]);

            if (arr[mid] == target) {
                System.out.println("  arr[" + mid + "] == " + target + " → FOUND!");
                return mid;
            } else if (target < arr[mid]) {
                System.out.println("  " + target + " < " + arr[mid] + " → search LEFT half (high = mid - 1 = " + (mid - 1) + ")");
                high = mid - 1;
            } else {
                System.out.println("  " + target + " > " + arr[mid] + " → search RIGHT half (low = mid + 1 = " + (mid + 1) + ")");
                low = mid + 1;
            }

            step++;
            System.out.println();
        }

        System.out.println("Target " + target + " was NOT found in the array.");
        return -1;
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);

        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        int[] leftArr = new int[sizeLeft];
        int[] rightArr = new int[sizeRight];

        for (int i = 0; i < sizeLeft; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < sizeLeft && j < sizeRight) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < sizeLeft) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < sizeRight) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] data = {43, 42, 90, 74, 10, 29, 68, 73, 75, 62};

        System.out.println("Original (unsorted) array: " + Arrays.toString(data));

        System.out.println("\n--- Sorting with Merge Sort ---");
        mergeSort(data, 0, data.length - 1);
        System.out.println("Sorted array:              " + Arrays.toString(data));
        System.out.println();

        int target = 75;
        System.out.println("====== Binary Search Trace for T2 = " + target + " ======");
        System.out.println();

        int resultIndex = binarySearch(data, target);

        if (resultIndex != -1) {
            System.out.println("\nResult: Target " + target + " found at index " + resultIndex + ".");
        } else {
            System.out.println("\nResult: Target " + target + " not found.");
        }
    }
}
