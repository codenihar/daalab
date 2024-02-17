import java.util.Arrays;
import java.util.Random;

public class MergeSortExperiment {

    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
            int[] rightHalf = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(leftHalf);
            mergeSort(rightHalf);

            int i = 0, j = 0, k = 0;

            while (i < leftHalf.length && j < rightHalf.length) {
                if (leftHalf[i] < rightHalf[j]) {
                    arr[k++] = leftHalf[i++];
                } else {
                    arr[k++] = rightHalf[j++];
                }
            }

            while (i < leftHalf.length) {
                arr[k++] = leftHalf[i++];
            }

            while (j < rightHalf.length) {
                arr[k++] = rightHalf[j++];
            }
        }
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
        mergeSort(elements);
        long endTime = System.nanoTime();

        System.out.println("Sorted array: " + Arrays.toString(elements));
        double timeTaken = (endTime - startTime) / 1e6; // Convert to milliseconds
        System.out.println("Time taken: " + timeTaken + " ms");
    }
}
