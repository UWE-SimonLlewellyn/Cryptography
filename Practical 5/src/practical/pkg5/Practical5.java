/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical.pkg5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author simon
 */
public class Practical5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // TODO code application logic here
        String s = "", cypherText = "4bcc3a95bdd9a11b28883290b03086e82af90212", sha = "";

        String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
        
        long timer = System.currentTimeMillis();
        
        sha = SHA1(s); // check for empty string
        while (!sha.equals(cypherText)) {
            s = nextString(s, alphabet);
            sha = SHA1(s); //Bottle neck if commented out over 10 times faster 
        }
                  
        timer = System.currentTimeMillis() - timer;
        System.out.println("Time taken is " + timer/1000 + " seconds");
        System.out.println(sha); // print cyper text
        System.out.println(s); // print decoded message
        

    }

    ////////////////////////////////////////////
    public static String nextString(String s, String alphabet) {
        int n = s.length();
        String lhs = ""; // left hand side 
        char rhs; // right hand side
        char last = alphabet.charAt(alphabet.length() - 1);
        

        // returns a if empty string
        if (n == 0) {
            return "" + alphabet.charAt(0);
        }

        // if string larger than 2 split into lhs an drhs
        // eg s = "simon", n = 5, lhs = "simo", rhs = "n"
        if (n > 1) {
            lhs = s.substring(0, n - 1);
        }
        rhs = s.charAt(n - 1);
        int index = alphabet.indexOf(rhs) + 1;

        // if check rhs = "9" 
        if (rhs == last) {
            rhs =  alphabet.charAt(0);
            return nextString(lhs, alphabet) + rhs;
        } else {
            rhs = alphabet.charAt(index);
            return lhs + rhs;
        }

    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String SHA1(String text)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("SHA-1");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    }
    
}