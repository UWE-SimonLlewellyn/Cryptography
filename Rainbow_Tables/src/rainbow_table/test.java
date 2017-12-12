/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbow_table;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


/**
 *
 * @author Scuff
 */
public class test {

    
    
    
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String alphabet = "0123456789";
        int maxLength = 8;
         int chainLength = 5000;
     Reduction test = new Reduction(alphabet,maxLength,chainLength);
        
        
        test(alphabet, maxLength, chainLength,  test);
    }

    public static void test( String alphabet,int maxLength,int chainLength, Reduction test ) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        String start = "25000100";

         String s = buildChain(start, chainLength, test );
         System.out.println(s);
    }

    public static String buildChain(String start, int chainLength , Reduction test) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        HashMap chain = new HashMap<>(); //stores values in chain for check if preexisiting pair in chain 
        String end = start, temp = "";
        /*
            Chain stores values to check if a pair of values in chain 
            Will avoid cirles within chain.
            Eg.         a=>b, b=>c, c=>d, d=>e
            Removes if: a=>b, b=>c, c=>a, a=>b 
         */
        System.out.println(end);
        end = test.reduce(Sha_1.SHA1(start), 0);
        for (int i = 1; i < chainLength; i++) {
            System.out.println(end);
            temp = test.reduce(Sha_1.SHA1(end), i);
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
}
