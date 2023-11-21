import java.util.Scanner;

public class RailFenceCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the key (number of rails) from the user
        System.out.println("Enter the number of rails:");
        int numRails = scanner.nextInt();

        // Step 2: Read the message string from the user
        System.out.println("Enter the message string:");
        scanner.nextLine(); // Consume the newline character
        String message = scanner.nextLine();

        // Step 3: Encryption
        String encryptedMessage = encrypt(message, numRails);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Step 4: Decryption
        String decryptedMessage = decrypt(encryptedMessage, numRails);
        System.out.println("Decrypted Message: " + decryptedMessage);

        scanner.close();
    }

    private static String encrypt(String message, int numRails) {
        char[][] railMatrix = new char[numRails][message.length()];
        boolean downward = false;
        int row = 0, col = 0;

        for (int i = 0; i < message.length(); i++) {
            // Change direction if reaching the top or bottom rail
            if (row == 0 || row == numRails - 1) {
                downward = !downward;
            }

            // Fill the rail matrix with characters from the message
            railMatrix[row][col] = message.charAt(i);

            // Move to the next position
            col++;
            row += downward ? 1 : -1;
        }

        // Construct the encrypted message from the rail matrix
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < numRails; i++) {
            for (int j = 0; j < message.length(); j++) {
                if (railMatrix[i][j] != 0) {
                    encryptedText.append(railMatrix[i][j]);
                }
            }
        }

        return encryptedText.toString();
    }

private static String decrypt(String encryptedMessage, int numRails) {
    char[][] railMatrix = new char[numRails][encryptedMessage.length()];
    boolean downward = false;
    int row = 0, col = 0;

    // Construct the rail matrix with placeholders
    for (int i = 0; i < encryptedMessage.length(); i++) {
        railMatrix[row][col] = ' ';
        col++;

        // Change direction if reaching the top or bottom rail
        if (row == 0 || row == numRails - 1) {
            downward = !downward;
        }

        if (downward) {
            row++;
        } else {
            row--;
        }
    }

    // Fill the rail matrix with the characters from the encrypted message
    int index = 0;
    for (int i = 0; i < numRails; i++) {
        for (int j = 0; j < encryptedMessage.length(); j++) {
            if (railMatrix[i][j] == ' ' && index < encryptedMessage.length()) {
                railMatrix[i][j] = encryptedMessage.charAt(index++);
            }
        }
    }

    // Reconstruct the original message from the rail matrix
    StringBuilder decryptedText = new StringBuilder();
    row = 0;
    col = 0;
    downward = false; // Reset direction for decryption
    for (int i = 0; i < encryptedMessage.length(); i++) {
        decryptedText.append(railMatrix[row][col]);
        col++;

        // Change direction if reaching the top or bottom rail
        if (row == 0 || row == numRails - 1) {
            downward = !downward;
        }

        if (downward) {
            row++;
        } else {
            row--;
        }
    }

    return decryptedText.toString();
}

}
