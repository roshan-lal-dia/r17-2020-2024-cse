### Problem Statement:



Walter wants to send a secret message to Jessie. Hank is trying to intercept the message transfer. So, they decided to use Diffie-Hellman Key Exchange Algorithm to securely transfer secret key.

Walter and Jessie publicly agreed to use prime q = 191. Walter chooses private key 73 and Jessie chooses private key 51. Find the public and secret keys in this scenario.


### Algorithm:

### Key Generation:
1. Choose a prime number `q`.
2. Dynamically find a primitive root `g` within the range `[2, q-1]`.
3. Each user (Walter and Jessie) chooses a private key (`a` and `b`).

### Public Key Calculation:
1. Calculate `A = g^a mod q` for Walter.
2. Calculate `B = g^b mod q` for Jessie.

### Secret Key Calculation:
1. Walter computes the shared secret key `K_Walter = B^a mod q`.
2. Jessie computes the shared secret key `K_Jessie = A^b mod q`.

### Pseudocode:

```
function findPrimitiveRoot(q):
    for g in range(2, q-1):
        if isPrimitiveRoot(g, q):
            return g

function isPrimitiveRoot(g, q):
    for i in range(1, q-1):
        if (g^i) mod q == 1:
            return false
    return true

function diffieHellmanKeyExchange():
    q = getPrimeFromUser()
    g = findPrimitiveRoot(q)

    a = getPrivateKeyFromUser()
    b = getPrivateKeyFromUser()

    A = g^a mod q
    B = g^b mod q

    secretKeyWalter = B^a mod q
    secretKeyJessie = A^b mod q

    print("Walter's public key (A):", A)
    print("Jessie's public key (B):", B)
    print("Walter's shared secret key:", secretKeyWalter)
    print("Jessie's shared secret key:", secretKeyJessie)

diffieHellmanKeyExchange()


```