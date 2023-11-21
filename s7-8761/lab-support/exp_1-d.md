### Algorithm:

### Encryption:

Read the key and message string.

Initialize an empty string for the encrypted message.

For each character in the message:
   - Determine the case of the character (uppercase or lowercase).
   - Calculate the shift value based on the corresponding character in the key.
   - Apply the Vigenere cipher encryption formula.
   - Append the encrypted character to the result string.


Decryption:

Read the key and encrypted message.

Initialize an empty string for the decrypted message.

For each character in the encrypted message:
- Determine the case of the character (uppercase or lowercase).
- Calculate the shift value based on the corresponding character in the key.
- Apply the Vigenere cipher decryption formula.
- Append the decrypted character to the result string.

### Pseudocode:
```
function encrypt(message, key):
    encryptedText = ""
    j = 0
    for i from 0 to length(message) - 1:
        currentChar = message[i]
        if isAlphabetic(currentChar):
            baseChar = determineBaseChar(currentChar)
            keyChar = key[j % length(key)]
            shift = keyChar - 'A'  // Convert to uppercase
            encryptedChar = (currentChar - baseChar + shift) % 26 + baseChar
            encryptedText += encryptedChar
            j++
        else:
            encryptedText += currentChar
    return encryptedText

function decrypt(encryptedMessage, key):
    decryptedText = ""
    j = 0
    for i from 0 to length(encryptedMessage) - 1:
        currentChar = encryptedMessage[i]
        if isAlphabetic(currentChar):
            baseChar = determineBaseChar(currentChar)
            keyChar = key[j % length(key)]
            shift = keyChar - 'A'  // Convert to uppercase
            decryptedChar = (currentChar - baseChar - shift + 26) % 26 + baseChar
            decryptedText += decryptedChar
            j++
        else:
            decryptedText += currentChar
    return decryptedText

```
