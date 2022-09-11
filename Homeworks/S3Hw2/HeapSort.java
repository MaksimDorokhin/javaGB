/*
 * Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */
package Homeworks.S3Hw2;

public class HeapSort {
    static void sort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heap(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr, i, 0);
        }
    }

    static void heap(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heap(arr, n, largest);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { -3, 12324, 12, 54, 6, 7 };
        System.out.println("Массив до сортировки:");
        printArray(arr);
        sort(arr);
        System.out.println("Массив, отсортированный алгоритмом пирамидальной сортировки:");
        printArray(arr);
    }
}
