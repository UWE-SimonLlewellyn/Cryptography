/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical.pkg5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class Practical5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "", original = "simon";

        int index = 0;

      String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
      
      
//         char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
//                            'n','o','p','q','r','s','t','u','v','w','x','y','z',
//                            '0','1','2','3','4','5','6','7','8','9'   };
       

//String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
//            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
//            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

       
       while(!s.equals(original)) {
           s = nextString(s, alphabet, index++);
           System.out.println(s);
        }

   
    }

    
    ////////////////////////////////////////////
    public static String nextString(String s, String alphabet , int index ){
        index = index % alphabet.length(); // only ever 0-35 = to pos in alphabet
        int n  = s.length();
        String lhs = "", rhs = "";
   
        // returns a if empty string
        if(n == 0) {
              return  "" + alphabet.charAt(index);                  
        }
               
     
        // if string larger than 2 split into lhs an drhs
        // eg s = "simon", n = 5, lhs = "simo", rhs = "n"
        if(n>1){
            lhs = s.substring(0, n-1);               
        }
        rhs = s.substring(n-1);
        
        
        // if check rhs = "9" 
        if(rhs.equals(alphabet.substring(alphabet.length()-1))){            
             rhs = "" + alphabet.charAt(index);
             // unable to keep track of lhs position in call
             //            
             return nextString(lhs, alphabet, index) + rhs;
        }
        else{
            rhs = "" + alphabet.charAt(index);  
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
