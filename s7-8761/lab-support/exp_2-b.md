### Algorithm:

Encryption:

- Read the key (permutation) and message string.
- Create a matrix based on the key and the length of the message.
- Fill the matrix with characters from the message.
- Rearrange the matrix based on the key.
- Construct the encrypted message from the rearranged matrix.

Decryption:

- Read the key (permutation) and encrypted message.
- Create a matrix based on the key and the length of the encrypted message, filled with placeholders.
- Rearrange the matrix based on the key and fill it with characters from the encrypted message.
- Reconstruct the original message from the rearranged matrix.

### Pseudocode:

```
function encrypt(message, key):
    rows = length(key)
    cols = ceil(length(message) / rows)
    matrix = createMatrix(rows, cols, message)
    rearrangeMatrix(matrix, key)
    encryptedText = constructEncryptedText(matrix)
    return encryptedText

function decrypt(encryptedMessage, key):
    rows = length(key)
    cols = ceil(length(encryptedMessage) / rows)
    matrix = createMatrix(rows, cols, "")
    rearrangeAndFillMatrix(matrix, key, encryptedMessage)
    decryptedText = reconstructOriginalText(matrix)
    return decryptedText

```