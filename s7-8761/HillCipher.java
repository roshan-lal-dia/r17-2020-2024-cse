import java.util.Scanner;

public class HillCipher {
    private static final int MATRIX_SIZE = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Read a 2x2 key matrix
        System.out.println("Enter the 2x2 key matrix (space-separated values, row by row):");
        int[][] keyMatrix = new int[MATRIX_SIZE][MATRIX_SIZE];
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                keyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Step 2: Read the message string
        System.out.println("Enter the message string:");
        scanner.nextLine(); // Consume the newline character
        String message = scanner.nextLine().toUpperCase();

        // Step 3: Encryption
        String encryptedMessage = encrypt(message, keyMatrix);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Step 4: Decryption
        String decryptedMessage = decrypt(encryptedMessage, keyMatrix);
        System.out.println("Decrypted Message: " + decryptedMessage);

        scanner.close();
    }

    private static String encrypt(String message, int[][] keyMatrix) {
        StringBuilder encryptedText = new StringBuilder();

        // Step 3: Encryption
        for (int i = 0; i < message.length(); i += MATRIX_SIZE) {
            // Extract a pair of characters
            String pair = message.substring(i, i + MATRIX_SIZE);

            // Convert the pair to a 2x1 matrix
            int[][] inputMatrix = convertToMatrix(pair);

            // Multiply the key matrix with the 2x1 matrix
            int[][] resultMatrix = multiplyMatrices(keyMatrix, inputMatrix);

            // Take the result mod 26
            resultMatrix = modMatrix(resultMatrix, 26);

            // Convert the result back to a pair of characters
            String encryptedPair = convertToString(resultMatrix);

            // Append the encrypted pair to the result
            encryptedText.append(encryptedPair);
        }

        return encryptedText.toString();
    }

    private static String decrypt(String encryptedMessage, int[][] keyMatrix) {
        StringBuilder decryptedText = new StringBuilder();

        // Step 4: Decryption
        int[][] keyMatrixInverse = invertMatrix(keyMatrix, 26);

        for (int i = 0; i < encryptedMessage.length(); i += MATRIX_SIZE) {
            // Extract a pair of characters
            String pair = encryptedMessage.substring(i, i + MATRIX_SIZE);

            // Convert the pair to a 2x1 matrix
            int[][] inputMatrix = convertToMatrix(pair);

            // Multiply the inverted key matrix with the 2x1 matrix
            int[][] resultMatrix = multiplyMatrices(keyMatrixInverse, inputMatrix);

            // Take the result mod 26
            resultMatrix = modMatrix(resultMatrix, 26);

            // Convert the result back to a pair of characters
            String decryptedPair = convertToString(resultMatrix);

            // Append the decrypted pair to the result
            decryptedText.append(decryptedPair);
        }

        return decryptedText.toString();
    }

    private static int[][] convertToMatrix(String text) {
        int[][] matrix = new int[MATRIX_SIZE][1];
        for (int i = 0; i < MATRIX_SIZE; i++) {
            matrix[i][0] = text.charAt(i) - 'A';
        }
        return matrix;
    }

    private static String convertToString(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < MATRIX_SIZE; i++) {
            result.append((char) (matrix[i][0] % 26 + 'A'));
        }
        return result.toString();
    }

    private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    private static int[][] modMatrix(int[][] matrix, int modValue) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (matrix[i][j] % modValue + modValue) % modValue;
            }
        }

        return result;
    }

    private static int[][] invertMatrix(int[][] matrix, int modValue) {
        int determinant = (matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]) % modValue;
        int determinantInverse = modInverse(determinant, modValue);

        int[][] result = new int[MATRIX_SIZE][MATRIX_SIZE];

        // Calculate the adjugate matrix
        result[0][0] = matrix[1][1];
        result[1][1] = matrix[0][0];
        result[0][1] = (matrix[0][1] * -1) % modValue;
        result[1][0] = (matrix[1][0] * -1) % modValue;

        // Multiply the adjugate matrix by the determinant inverse
        result = multiplyMatrices(result, new int[][]{{determinantInverse, 0}, {0, determinantInverse}});

        // Take the result mod 26
        result = modMatrix(result, 26);

        return result;
    }

    private static int modInverse(int a, int m) {
        // Extended Euclidean Algorithm to find the modular inverse
        int m0 = m, t, q;
        int x0 = 0, x1 = 1;

        if (m == 1) {
            return 0;
        }

        while (a > 1) {
            q = a / m;
            t = m;

            m = a % m;
            a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }

        if (x1 < 0) {
            x1 += m0;
        }

        return x1;
    }
}
