### Algorithm:

Key Generation:
- Create a key string (replace with a secure key generation mechanism in a real-world scenario).
- Convert the key string into a DESKeySpec.
- Use SecretKeyFactory to generate a SecretKey from the key specification.

Encryption:
- Create a Cipher object for encryption using the DES algorithm in Electronic Codebook (ECB) mode with PKCS5 padding.
- Initialize the cipher for encryption with the generated key.
- Encrypt the plaintext data.
- Base64 encode the encrypted bytes for easy representation.

Decryption:
- Create a Cipher object for decryption using the DES algorithm in ECB mode with PKCS5 padding.
- Initialize the cipher for decryption with the generated key.
- Decode the Base64-encoded ciphertext.
- Decrypt the ciphertext.
- Convert the decrypted bytes back to the original plaintext.


### Pseudocode:

```
function generateKey():
    keyString = "secretKey"  // Replace with a secure key generation mechanism
    keySpec = createDESKeySpec(keyString)
    key = generateSecretKey(keySpec)
    return key

function encrypt(plaintext, key):
    cipher = createCipher("DES/ECB/PKCS5Padding")
    initializeCipher(cipher, Cipher.ENCRYPT_MODE, key)
    encryptedBytes = cipher.doFinal(plaintext.getBytes())
    encryptedText = encodeBase64(encryptedBytes)
    return encryptedText

function decrypt(encryptedText, key):
    cipher = createCipher("DES/ECB/PKCS5Padding")
    initializeCipher(cipher, Cipher.DECRYPT_MODE, key)
    decryptedBytes = cipher.doFinal(decodeBase64(encryptedText))
    decryptedText = createString(decryptedBytes)
    return decryptedText


```