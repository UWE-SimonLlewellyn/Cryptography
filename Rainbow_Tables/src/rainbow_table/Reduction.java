/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbow_table;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author simon
 */
public class Reduction {

    String alphabet = "0";
    int maxLength = 1;
    BigInteger passwordSpace = TableGenerator.passwordSpace(alphabet.length(), maxLength);
    BigInteger p = passwordSpace.nextProbablePrime();
    int chainLength = 1;

    public Reduction() {

    }

    public Reduction(String alphabet, int maxLength, int chainLength) {

        this.alphabet = alphabet;
        this.maxLength = maxLength;
        this.chainLength = chainLength;
        this.passwordSpace = TableGenerator.passwordSpace(this.alphabet.length(), this.maxLength);
        this.p = passwordSpace.nextProbablePrime();

    }

    public String reduce(String hashed, int pos) {
        // change hash to big int change
        // adding pos means the reduce funtion has changed on each poitn of the cahine

       // BigInteger bigPos = BigInteger.valueOf(pos+1);
        BigInteger n = processHash(hashed, pos);        
        n = n.mod(p);
//        n= n.multiply(bigPos);     
//        n = n.mod(p);

        return intToString(n.intValue(), alphabet);

    }

    public String chainReduce(String hash, int pos, int chainLength) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String pwd = reduce(hash, pos);
        while (pos != chainLength) {
            pos++;
            pwd = reduce(Sha_1.SHA1(pwd), pos);              
        }
        return pwd;
    }

    /// this is just an example of a start of ascii code 
    //the example shwo that it s the sum of all ASCII codes within a hashed password. 
    // Ascii count Sum of ascii might be too small
    // multiplying the doesn't seem to be the best method as repeat values
    // e.g. (a*b*c) == (b*a*c) == (c*b*a) etc
    public static BigInteger asciiCount(String hashed) {
        BigInteger count = new BigInteger("1");

        for (int i = 0; i < hashed.length(); i++) {
            int c = hashed.charAt(i);
            BigInteger temp = new BigInteger("" + c);
            count = count.multiply(temp);
        }
        return count;
    }

    // To make the reduction function more unique I have taken the ascii values 
    // of each char and concatinated to a string so the string is equal to the 
    // ascci value of each hash. This should avoid duplicate BigIntegers values
    // eg a = 10, b = 15, c = 21
    // abc = 101521, bca = 152110, cba = 211510
    public static BigInteger processHash(String hashed, int pos) {
        String c = "";
        for (int i = 0; i < hashed.length(); i++) {
            c = c + (int) hashed.charAt(i);
        }
       // c = pos + c; // added the current pos on to fron tof the number
        BigInteger count = new BigInteger(c);
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
