import java.security.*;
import java.security.spec.*;

public class DSASignatureStandard {

    public static void main(String[] args) {
        try {
            // Generate key pair (public and private keys)
            KeyPair keyPair = generateKeyPair();

            // Create a message to be signed
            String message = "Hello, DSS!";
            System.out.println("Original Message: " + message);

            // Generate digital signature for the message
            byte[] signature = generateDigitalSignature(message, keyPair.getPrivate());
            System.out.println("Digital Signature: " + bytesToHex(signature));

            // Verify the digital signature
            boolean isSignatureValid = verifyDigitalSignature(message, signature, keyPair.getPublic());
            System.out.println("Signature Verification: " + isSignatureValid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(1024); // You can adjust the key size as needed
        return keyPairGenerator.generateKeyPair();
    }

    private static byte[] generateDigitalSignature(String message, PrivateKey privateKey)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        return signature.sign();
    }

    private static boolean verifyDigitalSignature(String message, byte[] signature, PublicKey publicKey)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature verifier = Signature.getInstance("SHA256withDSA");
        verifier.initVerify(publicKey);
        verifier.update(message.getBytes());
        return verifier.verify(signature);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
