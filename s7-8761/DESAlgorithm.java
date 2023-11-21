import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;

public class DESAlgorithm {

    public static void main(String[] args) {
        try {
            // Step 1: Generate a key
            String keyString = "secretKey"; // Replace with your key
            DESKeySpec keySpec = new DESKeySpec(keyString.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);

            // Step 2: Create a Cipher object
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Step 3: Initialize the Cipher for encryption
            cipher.init(Cipher.ENCRYPT_MODE, key);

            // Step 4: Encrypt the data
            String plaintext = "Hello, DES!";
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
}
