public class PlayfairCipher {
    private char[][] keySquare;

    public PlayfairCipher(String key) {
        generateKeySquare(key);
    }

    private void generateKeySquare(String key) {
        keySquare = new char[5][5];
        String keyWithoutDuplicates = removeDuplicateCharacters(key + "ABCDEFGHIKLMNOPQRSTUVWXYZ");

        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                keySquare[i][j] = keyWithoutDuplicates.charAt(k);
                k++;
            }
        }
    }

    private String removeDuplicateCharacters(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (result.indexOf(String.valueOf(input.charAt(i))) == -1) {
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }

    public String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();
        String preparedText = prepareText(plaintext);

        for (int i = 0; i < preparedText.length() - 1; i += 2) {
            char first = preparedText.charAt(i);
            char second = preparedText.charAt(i + 1);

            int[] firstPos = findPosition(first);
            int[] secondPos = findPosition(second);

            int rowDiff = firstPos[0] - secondPos[0];
            int colDiff = firstPos[1] - secondPos[1];

            if (rowDiff == 0) {
                encryptedText.append(keySquare[firstPos[0]][calculateModulus((firstPos[1] + 1), 5)]);
                encryptedText.append(keySquare[secondPos[0]][calculateModulus((secondPos[1] + 1), 5)]);
            } else if (colDiff == 0) {
                encryptedText.append(keySquare[calculateModulus((firstPos[0] + 1), 5)][firstPos[1]]);
                encryptedText.append(keySquare[calculateModulus((secondPos[0] + 1), 5)][secondPos[1]]);
            } else {
                encryptedText.append(keySquare[firstPos[0]][secondPos[1]]);
                encryptedText.append(keySquare[secondPos[0]][firstPos[1]]);
            }
        }

        return encryptedText.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();
        String preparedText = prepareText(ciphertext);

        for (int i = 0; i < preparedText.length() - 1; i += 2) {
            char first = preparedText.charAt(i);
            char second = preparedText.charAt(i + 1);

            int[] firstPos = findPosition(first);
            int[] secondPos = findPosition(second);

            int rowDiff = firstPos[0] - secondPos[0];
            int colDiff = firstPos[1] - secondPos[1];

            if (rowDiff == 0) {
                decryptedText.append(keySquare[firstPos[0]][calculateModulus((firstPos[1] - 1 + 5), 5)]);
                decryptedText.append(keySquare[secondPos[0]][calculateModulus((secondPos[1] - 1 + 5), 5)]);
            } else if (colDiff == 0) {
                decryptedText.append(keySquare[calculateModulus((firstPos[0] - 1 + 5), 5)][firstPos[1]]);
                decryptedText.append(keySquare[calculateModulus((secondPos[0] - 1 + 5), 5)][secondPos[1]]);
            } else {
                decryptedText.append(keySquare[firstPos[0]][secondPos[1]]);
                decryptedText.append(keySquare[secondPos[0]][firstPos[1]]);
            }
        }

        return decryptedText.toString();
    }

    private String prepareText(String text) {
        // Remove non-alphabetic characters and convert to uppercase
        return text.replaceAll("[^A-Z]", "").toUpperCase();
    }

    private int calculateModulus(int a, int b) {
        return (a % b + b) % b;
    }

    private int[] findPosition(char target) {
        int[] position = new int[2];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keySquare[i][j] == target) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }

        // Handle case where target is not found (optional)
        // You might want to throw an exception or return a special value.
        return position;
    }

    public static void main(String[] args) {
        String key = "GOOGLE";
        String plaintext = "PIXEL";

        PlayfairCipher playfairCipher = new PlayfairCipher(key);
        String encryptedText = playfairCipher.encrypt(plaintext);
        String decryptedText = playfairCipher.decrypt(encryptedText);

        System.out.println("Original Text: " + plaintext);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
