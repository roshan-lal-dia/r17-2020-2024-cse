//ex.1.a) Caesar Cipher
public class CaesarCipher {
    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isAlphabetic(character)) {
                char shiftedChar = (char) (((Character.toUpperCase(character) + shift - 'A') % 26 + 'A'));
                encryptedText.append(Character.isLowerCase(character) ? Character.toLowerCase(shiftedChar) : shiftedChar);
            } else {
                encryptedText.append(character);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, int shift) {
        return encrypt(encryptedText, -shift);
    }

    public static void main(String[] args) {
        String plaintext = "Hello, World!";
        int shift = 3;

        String encryptedText = encrypt(plaintext, shift);
        String decryptedText = decrypt(encryptedText, shift);

        System.out.println("Original Text: " + plaintext);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}


