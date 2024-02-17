import java.util.Arrays;
import java.util.Random;

public class QuickSortExperiment {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            // Recursively sort the sub-arrays
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] elements = new int[100]; // Change the size of the array as needed
        Random random = new Random();

        // Generate random elements
        for (int i = 0; i < elements.length; i++) {
            elements[i] = random.nextInt(1000);
        }

        System.out.println("Original array: " + Arrays.toString(elements));

        // Measure sorting time
        long startTime = System.nanoTime();
        quickSort(elements, 0, elements.length - 1);
        long endTime = System.nanoTime();

        System.out.println("Sorted array: " + Arrays.toString(elements));
        double timeTaken = (endTime - startTime) / 1e6; // Convert to milliseconds
        System.out.println("Time taken: " + timeTaken + " ms");
    }
}
