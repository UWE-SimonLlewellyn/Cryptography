/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbows;

import java.math.BigInteger;

/**
 *
 * @author simon
 */
public class Reduction {

    String alphabet;
    BigInteger passwordSpace;
    BigInteger p;
    int maxLength;

    public Reduction() {

        this.alphabet = "0123456789";
        this.maxLength = 8;
        this.passwordSpace = TableGenerator.passwordSpace(alphabet.length(), maxLength);
        this.p = passwordSpace.nextProbablePrime();

    }
    
    
    public Reduction(String alphabet) {

        this.alphabet = alphabet;
        this.maxLength = 8;
        this.passwordSpace = TableGenerator.passwordSpace(this.alphabet.length(), this.maxLength);
        this.p = passwordSpace.nextProbablePrime();

    }

    public String reduce(String hashed, int pos) {
        // change hash to big int change
        // adding pos means the reduce funtion has changed on each poitn of the cahine

        BigInteger bigPos = BigInteger.valueOf(pos);
        BigInteger n = asciiCount(hashed).multiply(bigPos);
        n = n.mod(p);

        return intToString(n.intValue(), alphabet);

    }

    /// this is just an example of a start of ascii code 
    //the example shwo that it s the sum of all ASCII codes within a hashed password. 
    // Ascii count Sum of ascii might be too small
    public static BigInteger asciiCount(String hashed) {
        BigInteger count = new BigInteger("1");

        for (int i = 0; i < hashed.length(); i++) {
            int c = hashed.charAt(i);
            BigInteger temp = new BigInteger("" + c);
            count = count.multiply(temp);
        }
        return count;
    }

    public static String intToString(int n, String alphabet) {
        int base = alphabet.length();
        int r;
        String s = "";

        while (n > 0) {
            r = n % base;
            n = n / base;
            s = alphabet.charAt(r) + s;
            n = n - 1;
        }
        return s;
    }

}
