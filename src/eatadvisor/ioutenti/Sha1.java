package eatadvisor.ioutenti;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * La classe Sha1 permette la criptazione di una stringa in
 * input di grandezza arbitraria, producendo in uscita una stringa hash di lunghezza fissa
 *
 * @author Alex Vellone
 */
public class Sha1 {

    /**
     * Hashing with SHA1
     *
     * @param input String to hash
     * @return String hashed
     */
    public static String sha1(String input) {
        input = "Eat-C1A0-" + input + "-EatAdvisor"; // Avoid rainbow tables attacks
        StringBuilder sha1 = new StringBuilder();
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA1");
            byte[] result = mDigest.digest(input.getBytes());
            for (byte b : result) {
                sha1.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error digest SHA1");
        }
        return sha1.toString();
    }
}
