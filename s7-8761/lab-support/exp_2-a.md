### Algorithm:

Encryption:

- Read the number of rails and message string.
- Initialize a rail matrix with the given number of rails and the length of the message.
- Traverse the matrix in a zigzag pattern, filling it with characters from the message.
- Construct the encrypted message from the filled rail matrix.

Decryption:

- Read the number of rails and the encrypted message.
- Initialize a rail matrix with the given number of rails and the length of the encrypted message, filled with placeholders.
- Traverse the matrix in a zigzag pattern, filling it with characters from the encrypted message.
- Reconstruct the original message from the filled rail matrix.

### Pseudocode:
```
function encrypt(message, numRails):
    railMatrix = initializeRailMatrix(numRails, length(message))
    downward = false
    row = 0
    col = 0
    for i from 0 to length(message) - 1:
        if row == 0 or row == numRails - 1:
            downward = not downward
        railMatrix[row][col] = message[i]
        col++
        row += downward ? 1 : -1
    encryptedText = constructEncryptedText(railMatrix)
    return encryptedText

function decrypt(encryptedMessage, numRails):
    railMatrix = initializeRailMatrix(numRails, length(encryptedMessage))
    downward = false
    row = 0
    col = 0
    for i from 0 to length(encryptedMessage) - 1:
        if row == 0 or row == numRails - 1:
            downward = not downward
        railMatrix[row][col] = ' '
        col++
        row += downward ? 1 : -1
    fillRailMatrix(railMatrix, encryptedMessage)
    decryptedText = reconstructOriginalText(railMatrix)
    return decryptedText


```
