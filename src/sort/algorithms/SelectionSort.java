package sort.algorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastInsorted = intArray.length - 1; lastInsorted > 0; lastInsorted--) {
            int largest = 0;

            for (int i = 1; i <= lastInsorted; i++) {
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }

            swap(intArray, largest, lastInsorted);
        }

        System.out.println(Arrays.toString(intArray));
    }

    // swap method
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

