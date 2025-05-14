class Solution {
    private static final int M = 1_000_000_007;

    public int countVowelPermutation(int n) {
        // Initialize a count matrix with one row representing the counts of 'a', 'e', 'i', 'o', and 'u'.
        long[][] count = {{1, 1, 1, 1, 1}};
        long[][] finalMatrix;

        // If n is greater than 1, perform matrix operations to calculate the count.
        if (n > 1) {
            // Define the base transition matrix that represents the vowel transitions.
            long[][] base = {
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0}
            };

            // Calculate the final matrix by raising the base matrix to the power (n - 1).
            finalMatrix = matrixMul(count, matrixPow(base, n - 1));
        } else {
            finalMatrix = count; // If n is 1, the result is the same as the initial count matrix.
        }

        // Calculate the result by summing up the values in the finalMatrix and taking the modulo M.
        long result = 0;
        for (long l : finalMatrix[0]) {
            result += l;
        }
        result %= M;
        return Math.toIntExact(result);
    }

    // Function to calculate the matrix raised to a power using a recursive approach.
    private long[][] matrixPow(long[][] base, int pow) {
        if (pow == 1) {
            return base;
        }
        if (pow == 2) {
            return matrixMul(base, base);
        }
        long[][] matrixPow = matrixPow(base, pow / 2);
        long[][] matrix = matrixMul(matrixPow, matrixPow);
        if (pow % 2 == 0) {
            return matrix;
        } else {
            return matrixMul(matrix, base);
        }
    }

    // Function to perform matrix multiplication.
    private long[][] matrixMul(long[][] a, long[][] b) {
        int ai = a.length;
        int bi = b.length;
        int bj = b[0].length;
        long[][] result = new long[ai][bj];
        for (int i = 0; i < ai; i++) {
            for (int j = 0; j < bj; j++) {
                long sum = 0;
                for (int k = 0; k < bi; k++) {
                    sum += a[i][k] * b[k][j];
                    sum %= M;
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}