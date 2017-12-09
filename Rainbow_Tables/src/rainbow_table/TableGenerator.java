/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbow_table;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author simon
 */
public class TableGenerator {

    String alphabet;
    static Reduction redman = new Reduction();

    public TableGenerator() {

    }

    public TableGenerator(String alphabet) {
        this.alphabet = alphabet;
        this.redman = new Reduction(alphabet);
    }

    HashMap pairs;

    /*   Password Space
    	a = sizeOfAlphabet;
    	k = MaxLengthOfPassword;
	space = a^k + a^(k-1) + a^(k-2) + … + a^0;
     */
    public static BigInteger passwordSpace(int sizeOfAlphabet, int maxLengthPassword) {
        BigInteger space = new BigInteger("0"); // set to 
        for (int i = maxLengthPassword; i > 0; i--) {
            BigInteger temp = new BigInteger("" + (int) Math.pow(sizeOfAlphabet, i));
            space = space.add(temp);
        }
        return space;
    }

    public static BigInteger numberOfChains(BigInteger space, int chainLength) {
        return space.divide(BigInteger.valueOf(chainLength));
    }

    public static String createStartValues(BigInteger space) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String random = "", hashed = "";
        BigInteger r;
        Random rnd = new Random();
        do {
            r = new BigInteger(space.bitLength(), rnd);
        } while (r.compareTo(space) >= 0);
        return r.toString();
    }

    public static String buildChain(String start, int chainLength) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String end = start;
        for (int i = 1; i <= chainLength; i++) {
            end = redman.reduce(Sha_1.SHA1(end), i);
        }
        return end;
    }

    public  HashMap createMap(int maxLength, int chainLength) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        BigInteger space = passwordSpace(alphabet.length(), maxLength);
        int num = numberOfChains(space, chainLength).intValue();
        HashMap start = new HashMap<>();
        HashMap pairs = new HashMap<>();

        String tempStart, tempEnd;
        for (int i = num; i > 0; i--) {
            // Create a random start point for chain between 0 - size Of Password Space
            tempStart = createStartValues(space);
            if (start.containsKey(tempStart)) {
                i++; // start exsists in start map add 1 to count to make up for lost itteration
            } else {
                // if start point unique add to start table
                start.put(tempStart, 0);
                // build chain from start point
                tempEnd = buildChain(tempStart, chainLength);
                // check if end point of chain is unique
                if (pairs.containsKey(tempEnd)) {
                    // if end point already exists replace lost itternation
                    // and remove start value from start map 
                    i++;
                    start.remove(tempStart);
                } else {
                    // if both start and end are unquie store in table
                    pairs.put(tempEnd, tempStart);
                }
            }
        }
        return pairs;
    }

}
