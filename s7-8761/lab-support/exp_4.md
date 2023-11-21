### Algorithm:



Key Generation:
- Use KeyGenerator to generate an AES key.

Encryption:
- Create a Cipher object for encryption using the AES algorithm in Electronic Codebook (ECB) mode with PKCS5 padding.
- Initialize the cipher for encryption with the generated key.
- Encrypt the plaintext data.
- Base64 encode the encrypted bytes for easy representation.

Decryption:
- Create a Cipher object for decryption using the AES algorithm in ECB mode with PKCS5 padding.
- Initialize the cipher for decryption with the generated key.
- Decode the Base64-encoded ciphertext.
- Decrypt the ciphertext.
- Convert the decrypted bytes back to the original plaintext.

### Pseudocode:

```
function generateKey():
    keyGenerator = getKeyGenerator("AES")
    keyGenerator.init(128)  // AES key size, can be 128, 192, or 256
    return keyGenerator.generateKey()

function encrypt(plaintext, key):
    cipher = createCipher("AES/ECB/PKCS5Padding")
    initializeCipher(cipher, Cipher.ENCRYPT_MODE, key)
    encryptedBytes = cipher.doFinal(plaintext.getBytes())
    encryptedText = encodeBase64(encryptedBytes)
    return encryptedText

function decrypt(encryptedText, key):
    cipher = createCipher("AES/ECB/PKCS5Padding")
    initializeCipher(cipher, Cipher.DECRYPT_MODE, key)
    decryptedBytes = cipher.doFinal(decodeBase64(encryptedText))
    decryptedText = createString(decryptedBytes)
    return decryptedText

```