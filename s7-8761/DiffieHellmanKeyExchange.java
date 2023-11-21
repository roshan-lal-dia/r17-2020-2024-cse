import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class DiffieHellmanKeyExchange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Given parameters
        System.out.println("Diffie-Hellman Key Exchange Algorithm");

        System.out.println("Enter value of q (PRIME):");
        BigInteger q = new BigInteger(scanner.nextLine());

        BigInteger g = findPrimitiveRoot(q);
        System.out.println("Computed value of alpha: " + g);

        System.out.println("Enter private key for A:");
        BigInteger a = new BigInteger(scanner.nextLine()); // Walter's private key

        System.out.println("Enter private key for B:");
        BigInteger b = new BigInteger(scanner.nextLine()); // Jessie's private key

        // Step 1: Public Key Calculation
        BigInteger A = g.modPow(a, q); // Walter's public key
        BigInteger B = g.modPow(b, q); // Jessie's public key

        // Step 2: Secret Key Calculation
        BigInteger secretKeyWalter = B.modPow(a, q); // Walter's shared secret key
        BigInteger secretKeyJessie = A.modPow(b, q); // Jessie's shared secret key

        // Display results
        System.out.println("\nPublic key for A is: " + A);
        System.out.println("Public Key for B is: " + B);

        System.out.println("\nSecret key for A is: " + secretKeyWalter);
        System.out.println("Secret Key for B is: " + secretKeyJessie);

        scanner.close();
    }

    private static BigInteger findPrimitiveRoot(BigInteger q) {
        for (BigInteger g = BigInteger.TWO; g.compareTo(q.subtract(BigInteger.ONE)) < 0; g = g.add(BigInteger.ONE)) {
            if (isPrimitiveRoot(g, q)) {
                return g;
            }
        }
        throw new IllegalArgumentException("No primitive root found for q: " + q);
    }

    private static boolean isPrimitiveRoot(BigInteger g, BigInteger q) {
        for (BigInteger i = BigInteger.ONE; i.compareTo(q.subtract(BigInteger.ONE)) < 0; i = i.add(BigInteger.ONE)) {
            if (g.modPow(i, q).equals(BigInteger.ONE)) {
                return false;
            }
        }
        return true;
    }
}

