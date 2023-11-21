### Algorithm:
Encryption:

Input:

Original text plaintext.

Integer shift representing the shift value.

Procedure:

- Initialize an empty string encryptedText.
- For each character character in plaintext:
- If character is an alphabetical character:
- Determine the case of character (uppercase or lowercase).
- Calculate the shifted character using the formula:        shifted_char = (original_char + shift - base_char) % 26 + base_char.
- Append the shifted character to encryptedText.
- Else, append character to encryptedText unchanged.
Output:

The encrypted text encryptedText.

Decryption:

Input:

Encrypted text encryptedText.

Integer shift representing the shift value.

Procedure:

- Initialize an empty string decryptedText.
- For each character character in encryptedText:
- If character is an alphabetical character:
- Determine the case of character (uppercase or lowercase).
- Calculate the shifted character using the formula: shifted_char = (original_char - shift - base_char + 26) % 26 + base_char.
- Append the shifted character to decryptedText.
- Else, append character to decryptedText unchanged.

Output:

The decrypted text decryptedText.