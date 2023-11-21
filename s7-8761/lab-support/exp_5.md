### Algorithm :

1. Create a html file and add the following code in it.
2.Add css code in the head tag.
3. Add javascript code in the head tag.

## Key Generation:

1. Select two large prime numbers, p and q.
2. Compute n = pq and ϕ = (p-1)(q-1).
3. Choose e such that 1 < e < ϕ and e is coprime to ϕ.
4. Calculate d as the modular multiplicative inverse of e mod ϕ.

## Encryption:

1. Represent the plaintext as a series of numerical values.
2. Use the recipient's public key (e, n) to encrypt the numerical values.

## Decryption:

1. Use the recipient's private key (d, n) to decrypt the ciphertext.


### Pseudocode:

```
Key Generation:

function generateKeyPair():
    p = generateNthPrime(randomNumber1)
    q = generateNthPrime(randomNumber2)
    n = p * q
    phi = (p - 1) * (q - 1)
    e = chooseE(phi)
    d = modInverse(e, phi)
    return (publicKey: (e, n), privateKey: (d, n))

Encryption:

function encrypt(message, publicKey):
    numericalValues = convertToNumericalValues(message)
    encryptedValues = [modPow(value, publicKey.e, publicKey.n) for value in numericalValues]
    return encryptedValues

Decryption:

function decrypt(encryptedValues, privateKey):
    decryptedValues = [modPow(value, privateKey.d, privateKey.n) for value in encryptedValues]
    return convertToPlainText(decryptedValues)

```