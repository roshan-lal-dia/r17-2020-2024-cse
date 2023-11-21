import java.util.Scanner;

public class RowColumnTransformation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Read the key (permutation keyword) from the user
            System.out.println("Enter the key (permutation keyword):");
            String keyInput = scanner.nextLine();
            int[] key = parseKey(keyInput);

            // Step 2: Read the message string from the user
            System.out.println("Enter the message string:");
            String message = scanner.nextLine();

            // Step 3: Encryption
            String encryptedMessage = encrypt(message, key);
            System.out.println("Encrypted Message: " + encryptedMessage);

            // Step 4: Decryption
            String decryptedMessage = decrypt(encryptedMessage, key);
            System.out.println("Decrypted Message: " + decryptedMessage);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int[] parseKey(String keyInput) {
        keyInput = keyInput.toUpperCase();
        int[] key = new int[keyInput.length()];
        for (int i = 0; i < keyInput.length(); i++) {
            key[i] = keyInput.charAt(i) - 'A';
        }
        return key;
    }

    private static String encrypt(String message, int[] key) {
        int length = message.length();
        int rows = key.length;

        // Repeat the key if its length is less than the message length
        if (length > rows) {
            int repeatFactor = (int) Math.ceil((double) length / rows);
            int[] repeatedKey = new int[repeatFactor * rows];
            for (int i = 0; i < repeatFactor; i++) {
                System.arraycopy(key, 0, repeatedKey, i * rows, rows);
            }
            key = repeatedKey;
        }

        int cols = (int) Math.ceil((double) length / rows);

        char[][] matrix = new char[rows][cols];

        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (k < length) ? message.charAt(k++) : ' ';
            }
        }

        StringBuilder encryptedText = new StringBuilder();
        for (int colIndex : key) {
            for (int i = 0; i < rows; i++) {
                encryptedText.append(matrix[i][colIndex]);
            }
        }

        return encryptedText.toString();
    }

    private static String decrypt(String encryptedMessage, int[] key) {
        int length = encryptedMessage.length();
        int rows = key.length;
        int cols = (int) Math.ceil((double) length / rows);

        char[][] matrix = new char[rows][cols];

        int index = 0;
        for (int colIndex : key) {
            for (int j = 0; j < rows; j++) {
                matrix[j][colIndex] = encryptedMessage.charAt(index++);
            }
        }

        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                decryptedText.append(matrix[i][j]);
            }
        }

        return decryptedText.toString().trim();
    }
}
