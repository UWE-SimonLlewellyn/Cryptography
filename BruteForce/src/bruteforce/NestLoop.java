/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bruteforce;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author Scuff
 */
public class NestLoop {

    public NestLoop() {

    }

    public static String nestLoop(String alphabet, String hash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int count = alphabet.length();
        ArrayList<String> c = new ArrayList<>();
        String t = "";
        // Add empty string and all alphabet string chars to arraylist
        // c = {"",a,b,c,d...7,8,9}
        c.add(t);
        for (int i = 0; i < count; i++){            
            c.add(String.valueOf(alphabet.charAt(i)));
        }
        
        count = c.size();
        String s = "";
        // Start of loops to build string 
        // After each loop finishes the count for the one above ticks over which start all internal loops again
        // eg. s = "" + "" + "" + "" + "" + "" = "" 
        // n + 1 = "" + "" + "" + "" + "" + a = a 
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                for (int k = 0; k < count; k++) {
                    for (int l = 0; l < count; l++) {
                        for (int m = 0; m < count; m++) {
                            for (int n = 0; n < count; n++) {
                                if (Sha_1.SHA1(s).equals(hash)) {
                                    return s;
                                }
                                s = c.get(i) + c.get(j) + c.get(k) + c.get(l) + c.get(m) + c.get(n);
                                
                            }
                        }
                    }
                }
            }
        }
        return "Not Found";  // unable to find combination of alphabet 
    }

}
