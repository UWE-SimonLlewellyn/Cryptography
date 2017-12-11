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
    int chainLength;
    int maxLength;
    HashMap pairs = new HashMap<>();
    static Reduction redman = new Reduction();

    public TableGenerator() {

    }

    public TableGenerator(String alphabet, int maxLength, int chainLength) {
        this.alphabet = alphabet;
        this.chainLength = chainLength;
        this.maxLength=maxLength;
        this.redman = new Reduction(alphabet, maxLength, chainLength);
    }

    

    /*   Password Space
    	a = sizeOfAlphabet;
    	k = MaxLengthOfPassword;
	space = a^k + a^(k-1) + a^(k-2) + … + a^0;
     */
    public static BigInteger passwordSpace(int sizeOfAlphabet, int maxLengthPassword) {
        BigInteger space = new BigInteger("0"); // set to 
        for (int i = maxLengthPassword; i >= 0; i--) {
            BigInteger temp = new BigInteger("" + (int) Math.pow(sizeOfAlphabet, i));
            space = space.add(temp);
        }
        return space;
    }

    public static BigInteger numberOfChains(BigInteger space, int chainLength) {
        return space.divide(BigInteger.valueOf(chainLength));
    }

    public static String createStartValues(BigInteger space) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String random = "";
        BigInteger r;
        Random rnd = new Random();
        do {
            r = new BigInteger(space.bitLength(), rnd);
        } while (r.compareTo(space) >= 0);
        random = r.toString();
        return redman.reduce(Sha_1.SHA1(random), 1);

    }

    public static String buildChain(String start, int chainLength) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        HashMap chain = new HashMap<>(); //stores values in chain for check if preexisiting pair in chain 
        String end = start, temp = "";

        /*
            Chain stores values to check if a pair of values in chain 
            Will avoid cirles within chain.
            Eg.         a=>b, b=>c, c=>d, d=>e
            Error if:   a=>b, b=>c, c=>a, a=>b 
        */
        end = redman.reduce(Sha_1.SHA1(start), 1);
        for (int i = 2; i <= chainLength; i++) {
            temp = redman.reduce(Sha_1.SHA1(end), i);
            if ((chain.containsKey(end))
                    && (temp.equals(chain.get(end).toString()))) {
                return "False";
            } else {
                chain.put(end, temp);
            }
            end = temp;
        }
        return end;
    }

    public HashMap createMap(int maxLength, int chainLength) throws NoSuchAlgorithmException, UnsupportedEncodingException {
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
                // returns False if chain has duplicate values within
                tempEnd = buildChain(tempStart, chainLength);
                if (!tempEnd.equals("False")) {
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
                } else {
                    i++;
                    start.remove(tempStart);
                }
            }
        }
        return pairs;
    }

}
