### Algorithm:

Key Square Generation:

Create a 5x5 matrix (5x5 key square) with unique letters from the key, followed by the remaining letters of the alphabet.
Handle the case where 'I' and 'J' are treated as the same letter.

Playfair Encryption:
1. Break the plaintext into digraphs (pairs of two letters).
2. For each digraph:
   - a. If the letters are in the same row, replace each letter with the letter to its right (wrap around if necessary).
   - b. If the letters are in the same column, replace each letter with the letter below it (wrap around if necessary).
   - c. If the letters form a rectangle, replace each letter with the letter in the same row but from the column of the other letter.
   - d. If the letters are different and not in the same row or column, form a rectangle and replace each letter with the letter in the same row but from the column of the other letter.

Playfair Decryption:

Follow the same rules as for encryption but in reverse.





### Pseudocode:
```
function generateKeySquare(key):
    create a 5x5 matrix
    fill the matrix with unique letters from the key, followed by the remaining letters of the alphabet (excluding 'I/J')

function encrypt(plaintext, keySquare):
    break plaintext into digraphs
    for each digraph:
        if letters are in the same row:
            replace each letter with the letter to its right
        else if letters are in the same column:
            replace each letter with the letter below it
        else:
            form a rectangle and replace each letter with the letter in the same row but from the column of the other letter
    concatenate the encrypted digraphs

function decrypt(ciphertext, keySquare):
    follow the same rules as for encryption but in reverse

```
