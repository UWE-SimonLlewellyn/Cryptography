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
//                            '0','1','2','3','4','5','6','7','8','9'};
       

//String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
//            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
//            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        //  new_string(s, original, alphabet, index);
           String test = nextString(s, alphabet, index);
    //    new_string(s, original, alphabet, index);

    

    }
    /////////////////////////////////////////////
//  public static String getnext(String w){
//      System.out.println(w);
//      int n;
//      char c;
//      n = w.length();
//      
//      if(n ==0) return "a";
//      if(w.charAt(n-1) <'z'){
//          c = (char)((int)w.charAt(n-1)+1);
//          return w.substring(0,n-1)+String.valueOf(c);
//      }
//      else{
//          
//          return getnext("a") + "a";
//      }
//  }
    
    
    ////////////////////////////////////////////
    public static String nextString(String s, String alphabet , int index ){
        System.out.println(s);
        int n  = s.length();
        String lhs = "", rhs = "";
   
        if(n == 0) {
              s += alphabet.charAt(n);         
             return nextString( s, alphabet , ++index);
        }
               
     
        if(n>1){
            lhs = s.substring(0, n-2);               
        }
        rhs = s.substring(n-1);
        
        
        
        if(rhs.equals(alphabet.substring(alphabet.length()-1))){            
             rhs = "" + alphabet.charAt(0);
             //curenrelt loops here as it will constantly send a "" as the lhs
            return nextString(lhs,alphabet, 0) + rhs;
        }
        else{
            rhs = "" + alphabet.charAt(index);
            return nextString(rhs,alphabet, ++index) ;
        }

    }
    

//    public static String new_string(String s, String original, String[] alphabet, int index) {
//        String lhs = "", rhs = "", test = ""; // l= left hand sid of string, r = right side (the last char)
//        System.out.println(s);
//
//        // ADD check 's' has against original
//        // check if s is empty
//        if (s.length() > 0) {
//            index = index % alphabet.length; // mod index by length of alphabet
//            if (s.length() > 1) {
//                lhs = s.substring(0, (s.length() - 1));
//            }
//            rhs.equals(s.substring(s.length() - 1));
//
//            //if rhs is not equal to last in the alaphbet
//            if (rhs.equals(alphabet[alphabet.length - 1])) {
//                index++;
//                return new_string(lhs + alphabet[index], original, alphabet, index);
//            } else {
//                String s1 = lhs;
//                if (index > 0 && s1.length() >1) {
//                    lhs = s1.substring(0, (s1.length() - 1));
//                    rhs =s1.substring(s1.length() - 1);
//                }
//                index++;
//                new_string(lhs + alphabet[index], original, alphabet, index);
//            }
//
//        } else {
//            return new_string(s + alphabet[index], original, alphabet, index++);
//        }

  
  
  
  
        //
        // test out the current string
//        try {
//            test = SHA1(s);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(Practical5.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        if(test == original)
//            return s;
//        else return new_string(s, original, alphabet);
//        return s;
//    }

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
