import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class AESAlgorithm {

    public static void main(String[] args) {
        try {
            // Step 1: Generate a key
            SecretKey key = generateKey();

            // Step 2: Create a Cipher object
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // Step 3: Initialize the Cipher for encryption
            cipher.init(Cipher.ENCRYPT_MODE, key);

            // Step 4: Encrypt the data
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the plaintext:");
            String plaintext = scanner.nextLine();
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted: " + encryptedText);

            // Step 5: Initialize the Cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, key);

            // Step 6: Decrypt the data
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            String decryptedText = new String(decryptedBytes);
            System.out.println("Decrypted: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // AES key size, can be 128, 192, or 256
        return keyGenerator.generateKey();
    }
}
