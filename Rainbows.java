/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbow_table;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Rainbows {

    public static String rainbowtable = "RainbowTable.ser";
    public static FileToTable deserializer = new FileToTable();

    /**
     * @param args
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        FileToTable.fileAvailble(rainbowtable);
        HashMap start = deserializer.loadRainbowTable(rainbowtable);
        String alphabet = "0123456789";
        int maxLength = 8, chainLength = 5000;
        if (start.size() < 1) {
            TableGenerator tableMan = new TableGenerator(alphabet, maxLength);
            start = tableMan.createMap(maxLength, chainLength);
            FileToTable.saveHashMapToFile(start,rainbowtable);
        }
        TableGenerator tableMan2 = new TableGenerator(alphabet, maxLength);
        String t = tableMan2.buildChain("77389036",5000);
        
        System.out.println("df");

    }

}
