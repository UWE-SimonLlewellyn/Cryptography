/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbows;

import java.math.BigInteger;


public class Rainbows {

    public static void main(String[] args) {

        
        char[] a = "0123456789".toCharArray();
        int minLen = 1;
        int maxLen = 1;
        
        long numCombinations = calcCombinations(a, minLen, maxLen);
        int asciiSum = asciiSum(a);
        
        System.out.println();
    }
    
    
    
    public static String intToString(int n, char[] alphabet) {
        int base = alphabet.length;
        int r;
        String s = "";

        while (n >= 0) {
            r = n % base;
            n = n / base;
            s = alphabet[r] + s;
            n = n - 1;
        }
        return s;
    }
    
    public static int asciiSum(char[] alphabet){       
        int count = 0;
        for (int i = 0; i < alphabet.length; i++) {
            count += alphabet[i];
        }  
        return count;
    }
    
    public static long calcCombinations(char[] alphabet, int minLen, int maxLen){ 
        long numChars = alphabet.length;
        long count = 0;
        
        for (int i = minLen; i <= maxLen; i++) {
            count += Math.pow(numChars, i);
        }  
        return count;
    }
    
//    public static long pickPrime(long num){
//        
//        return null;
//    }
    
    
//    public static BigInteger combinations(char[] alphabet, int minLen, int maxLen) {
//        long numChars = alphabet.length;
//        long count = 0;
//        BigInteger bigCount = BigInteger.valueOf(0);
//
//        for (int i = minLen; i < maxLen; i++) {
//            count = (long) Math.pow(numChars, i);
//            bigCount = bigCount.add(BigInteger.valueOf(count));
//        }
//        return bigCount;
//    }
    
    
    
}
