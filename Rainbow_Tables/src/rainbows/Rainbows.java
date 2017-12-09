/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbows;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Rainbows {

    
    // "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String alphabet = "0123456789";
        int maxLength = 8, chainLength = 5000;
        TableGenerator tableMan = new TableGenerator(alphabet);
        HashMap start = tableMan.createMap(maxLength, chainLength);
        
        System.out.println("df");
        

    }


}
