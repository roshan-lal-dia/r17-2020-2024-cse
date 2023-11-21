### Algorithm:


### Pseudocode:
```
1. Read a 2x2 key matrix from the user.
2. Read the message string from the user.
3. For encryption:
   a. Convert the message string to uppercase.
   b. Break the message into pairs of two characters.
   c. For each pair:
      i. Convert the pair to a 2x1 matrix.
      ii. Multiply the key matrix with the 2x1 matrix.
      iii. Take the result mod 26.
      iv. Convert the result back to a pair of characters.
   d. Print the encrypted message.

4. For decryption:
   a. Invert the key matrix.
   b. For each pair in the encrypted message:
      i. Convert the pair to a 2x1 matrix.
      ii. Multiply the inverted key matrix with the 2x1 matrix.
      iii. Take the result mod 26.
      iv. Convert the result back to a pair of characters.
   c. Print the decrypted message.


```
