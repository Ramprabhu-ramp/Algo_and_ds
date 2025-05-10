package org.assignment;

public class App {

    // QuickSort function (uses recursion and partitioning to sort in place)
    public void QuickSort(int[] arr, int low, int high) {
        // Base condition: if there are more than one elements to sort
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before the pivot
            QuickSort(arr, low, pivotIndex - 1);

            // Recursively sort elements after the pivot
            QuickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition function: places pivot at its correct sorted position
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choose the last element as pivot
        int i = low - 1;        // Index for smaller element

        // Navigating through the array from low to high - 1
        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot
            if (arr[j] < pivot) {
                i++; // moving the boundary of smaller elements

                // Swapping arr[i] with arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Finally, swapping pivot to its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Counting sort function (efficient for small integer values)
    public int[] CountingSort(int[] arr) {
        // Handle empty array
        if (arr.length == 0) return arr;

        // Step 1: Finding the maximum value in the array
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // Step 2: Creating count array and initialize to 0
        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++; // Count each number's frequency
        }

        // Step 3: Building the sorted array using the count array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i; // Add i to original array as many times as it occurred
                count[i]--;
            }
        }

        return arr; // Return the sorted array
    }

    // Main method: Entry point of the program
    public static void main(String[] args) {
        App sorter = new App(); // Create instance of App

        // Testing QuickSort
        int[] QuickArr = {5968, 3850, 2857, 1956, 9826, 6554};
        System.out.println("Original array (quicksort):");
        PrintArray(QuickArr);

        sorter.QuickSort(QuickArr, 0, QuickArr.length - 1); // Sort using QuickSort
        System.out.println("Sorted array (quicksort):");
        PrintArray(QuickArr);

        // Testing CountingSort
        int[] countArr = {5968, 9826, 5968, 1956, 9826, 6554};
        System.out.println("\nOriginal array (counting sort):");
        PrintArray(countArr);

        sorter.CountingSort(countArr); // Sort using CountingSort
        System.out.println("Sorted array (counting sort):");
        PrintArray(countArr);
    }

    // Utility function to print an array
    public static void PrintArray(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}