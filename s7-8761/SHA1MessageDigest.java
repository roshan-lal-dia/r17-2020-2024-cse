import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1MessageDigest {

    public static void main(String[] args) {
        String inputText = "Hello, SHA-1!";
        calculateSHA1MessageDigest(inputText);
    }

    private static void calculateSHA1MessageDigest(String inputText) {
        try {
            // Convert input text to byte array
            byte[] inputBytes = inputText.getBytes();

            // Initialize SHA-1 algorithm
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");

            // Update algorithm with input bytes
            sha1.update(inputBytes);

            // Finalize algorithm to obtain message digest
            byte[] messageDigest = sha1.digest();

            // Convert message digest to hexadecimal string
            String hexDigest = convertByteArrayToHexString(messageDigest);

            // Print the result
            System.out.println("SHA-1 Message Digest: " + hexDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String convertByteArrayToHexString(byte[] byteArray) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : byteArray) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
