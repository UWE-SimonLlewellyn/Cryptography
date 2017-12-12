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
        c.add(t);
        for (int i = 0; i < count; i++){            
            c.add(String.valueOf(alphabet.charAt(i)));
        }
        count = c.size();
        String s = "";
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
        return "Not Found";
    }

}
