/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bruteforce;

/**
 *
 * @author simon
 */
public class NextString {

    public NextString() {
    }

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

}
