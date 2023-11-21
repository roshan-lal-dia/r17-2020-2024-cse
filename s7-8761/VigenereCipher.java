import java.util.Scanner;

public class VigenereCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Read the key from the user
        System.out.println("Enter the key:");
        String key = scanner.nextLine().toUpperCase();

        // Step 2: Read the message string from the user
        System.out.println("Enter the message string:");
        String message = scanner.nextLine().toUpperCase();

        // Step 3: Encryption
        String encryptedMessage = encrypt(message, key);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Step 4: Decryption
        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted Message: " + decryptedMessage);

        scanner.close();
    }

    private static String encrypt(String message, String key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0, j = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (Character.isAlphabetic(currentChar)) {
                // Determine the case of the current character
                char baseChar = Character.isUpperCase(currentChar) ? 'A' : 'a';

                // Calculate the shift value for the current character in the key
                char keyChar = key.charAt(j % key.length());
                int shift = keyChar - 'A';

                // Apply the Vigenere cipher encryption
                char encryptedChar = (char) ((currentChar - baseChar + shift) % 26 + baseChar);

                encryptedText.append(encryptedChar);

                // Move to the next character in the key
                j++;
            } else {
                // Non-alphabetic characters remain unchanged
                encryptedText.append(currentChar);
            }
        }

        return encryptedText.toString();
    }

    private static String decrypt(String encryptedMessage, String key) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0, j = 0; i < encryptedMessage.length(); i++) {
            char currentChar = encryptedMessage.charAt(i);

            if (Character.isAlphabetic(currentChar)) {
                // Determine the case of the current character
                char baseChar = Character.isUpperCase(currentChar) ? 'A' : 'a';

                // Calculate the shift value for the current character in the key
                char keyChar = key.charAt(j % key.length());
                int shift = keyChar - 'A';

                // Apply the Vigenere cipher decryption
                char decryptedChar = (char) ((currentChar - baseChar - shift + 26) % 26 + baseChar);

                decryptedText.append(decryptedChar);

                // Move to the next character in the key
                j++;
            } else {
                // Non-alphabetic characters remain unchanged
                decryptedText.append(currentChar);
            }
        }

        return decryptedText.toString();
    }
}
