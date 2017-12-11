package rainbow_table;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Scuff
 */
public class FileToTable {
    
    public FileToTable(){}
     
     /*
     fileAvailble()
     Checks to see file in the directory
     IF true do nothing
     ELSE create new file in directory ready to be written to.
     */
    public static void fileAvailble(String s) {
        java.io.File p = new java.io.File(s);
        if (p.exists()) {
            // do something
        } else {
            RainbowTable rainbowTable = new RainbowTable();
            saveHashMapToFile(rainbowTable, s);
        }
        
    }
    
     /*
     saveHashMapToFile()
     Report r = Report to save
     String file = file name to save to
     Saves report to a external file to all easy saving and loading 
     of records in the system.
     */
    public static void saveHashMapToFile(RainbowTable r, String file) {
        try {
            // write object to file
            FileOutputStream fos = new FileOutputStream(file);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(r);
            }

        } catch (FileNotFoundException e) {
            e.toString();
        } catch (IOException e) {
            e.toString();
        }
    }
    
    
        public RainbowTable loadRainbowTable(String file) {
        RainbowTable rainbowTable;
        try {
            // read object from file
            FileInputStream fis = new FileInputStream(file);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                rainbowTable = (RainbowTable) ois.readObject();
            }

            return rainbowTable;

        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }
    
    
}
