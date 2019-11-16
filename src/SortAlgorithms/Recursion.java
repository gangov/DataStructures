package SortAlgorithms;

public class Recursion {
    // merge sort, quick sort, counting sort and radix sort use recursion. Here we will look at it.
    public static void main(String[] args) {
        System.out.println(recursiveFactorial(9));
        System.out.println(iterativeFactorial(9));
    }

    private static int recursiveFactorial(int num) {

        if (num == 0) {
            return 1;
        }

        return num * recursiveFactorial(num - 1);
    }

    private static int iterativeFactorial(int num) {
        if (num == 0) {
            return 1;
        }

        int factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
