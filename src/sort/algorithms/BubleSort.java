package sort.algorithms;

import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastinsorted = intArray.length - 1; lastinsorted > 0; lastinsorted--) {
            for (int i = 0; i < lastinsorted; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
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
