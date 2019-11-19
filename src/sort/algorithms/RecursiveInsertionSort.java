package sort.algorithms;

import java.util.Arrays;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        recursiveFunction(intArray, intArray.length);
        System.out.println(Arrays.toString(intArray));
    }

    private static void recursiveFunction(int[] input, int numItems) {
        if (numItems < 2) {
            return;
        }

        recursiveFunction(input, numItems - 1);
        int newElement = input[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;
    }


}
