public class Fibonacci {
    public static void main(String[] args) {
        int n = 35;
        printFibonacciSequence(n);
    }

    private static void printFibonacciSequence(int n) {
        /* Store Fibonacci numbers in array. */
        int[] f = new int[n + 1];
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;

        if (n > 0) {
            f[1] = 1;

            for (i = 2; i <= n; i++) {
                /* Add the previous 2 numbers in the series and store it */
                f[i] = f[i - 1] + f[i - 2];
            }
        }
        System.out.println("The " + n + "th fibonacci number is : " + f[n]);
    }
}
