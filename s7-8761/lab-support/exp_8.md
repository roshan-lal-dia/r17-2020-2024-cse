### Algorithm:


## Key Pair Generation (DSA):
Use `KeyPairGenerator` to generate a key pair.

## Digital Signature Generation (DSA):
1. Initialize `Signature` with SHA-256 and DSA.
2. Initialize with private key.
3. Update with the byte array of the message.
4. Sign the message.

## Digital Signature Verification (DSA):
1. Initialize `Signature` with SHA-256 and DSA.
2. Initialize with public key.
3. Update with the byte array of the original message.
4. Verify the signature.


### Pseudocode:

```
function generateKeyPair():
    keyPairGenerator = KeyPairGenerator.getInstance("DSA")
    keyPairGenerator.initialize(1024) // You can adjust the key size as needed
    return keyPairGenerator.generateKeyPair()

function generateDigitalSignature(message, privateKey):
    signature = Signature.getInstance("SHA256withDSA")
    signature.initSign(privateKey)
    signature.update(message.getBytes())
    return signature.sign()

function verifyDigitalSignature(message, signature, publicKey):
    verifier = Signature.getInstance("SHA256withDSA")
    verifier.initVerify(publicKey)
    verifier.update(message.getBytes())
    return verifier.verify(signature)


```

## Sample Input:

Original Message: "Hello, DSA!"

## Sample Output:

Original Message: Hello, DSA!

Digital Signature: 304502202166171a3e53ea091ed730e0582a02f7778490a14a7e643b1a1bfda24c4a6063022100d15ad2a7685ac7446d0b38ccdb12f2a26cb6319e3e8a207f075d0dbd3e2ee2b1

Signature Verification: true

