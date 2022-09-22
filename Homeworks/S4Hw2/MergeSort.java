package Homeworks.S4Hw2;

import java.util.Scanner;

class MergeSort {

    static int inputNaturalNumber(Scanner in) {
        int number = 0;
        boolean checkNegative = false;

        while (!checkNegative) {
            System.out.printf("Введите натуральное число %s: ", "(размер массива для сортировки слиянием)");

            while (!in.hasNextInt()) {
                System.out.println("Вы ввели не число, повторите ввод!");
                in.next();
            }
            number = in.nextInt();

            if (number <= 0)
                System.out.println("Вы ввели не натуральное число, повторите ввод!");
            else
                checkNegative = true;
        }
        return number;
    }

    static int[] inputArray(int arrayLength, Scanner in) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            System.out.printf("Введите элемент массива %d: ", i);
            while (!in.hasNextInt()) {
                System.out.println("Вы ввели не число, повторите ввод!");
                in.next();
            }
            array[i] = in.nextInt();
        }
        return array;
    }
    static void intArrayPrinter(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) System.out.print(i + " ");
        System.out.print("]\n");
    }
    static void merge (int[] array, int left, int right, int middle) {
        int size_of_temp1, size_of_temp2, i, j, k;

        size_of_temp1 = (middle-left)+1;
        size_of_temp2 = (right-middle);

        int[] temp1 = new int[size_of_temp1];
        int[] temp2 = new int[size_of_temp1];

        for(i=0; i<size_of_temp1; i++)
            temp1[i] = array[left+i];

        for(i=0; i<size_of_temp2; i++)
            temp2[i] = array[middle+1+i];

        i=0;
        j=0;
        k=left;

        while (i < size_of_temp1 && j < size_of_temp2) {
            if (temp1[i] < temp2[j]) {
                array[k] = temp1[i];
                i++;
            } else if (temp2[j] < temp1[i]) {
                array[k] = temp2[j];
                j++;
            }
            k++;
        }

        while (i<size_of_temp1) {
            array[k] = temp1[i];
            k++;
            i++;
        }

        while (j<size_of_temp2) {
            array[k] = temp2[j];
            k++;
            j++;
        }
    }
    static void mergeSort (int[] ar, int left, int right) {
        if (left < right) {
            int middle = (left+right)/2;

            mergeSort(ar, left, middle);
            mergeSort(ar, middle+1, right);
            merge(ar, left, right, middle);
        }
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int arrayLength = inputNaturalNumber(in);
        int[] array = inputArray(arrayLength, in);
        in.close();
        System.out.println("Массив до сортировки слиянием:");
        intArrayPrinter(array);
        mergeSort(array, 0, (arrayLength - 1));
        System.out.println("Массив после сортировки слиянием:");
        intArrayPrinter(array);
    }
}