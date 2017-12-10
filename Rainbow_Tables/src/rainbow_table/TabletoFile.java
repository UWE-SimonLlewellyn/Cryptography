/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbow_table;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author simon
 */
public class TableToFile {
    
    
    public TableToFile(){}
    
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
            HashMap rainbowTable = new HashMap<>();
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
    public static void saveHashMapToFile(HashMap r, String file) {
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
    
    
        public HashMap loadRainbowTable(String file) {
        HashMap rainbowTable;
        try {
            // read object from file
            FileInputStream fis = new FileInputStream(file);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                rainbowTable = (HashMap<String,String>) ois.readObject();
            }

            return rainbowTable;

        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }
    
    
}
