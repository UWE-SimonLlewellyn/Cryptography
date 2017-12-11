/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbow_table;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Scuff
 */
public class RainbowTable implements Serializable {

    public String alphabet;
    public int maxLength;
    public int chainLength;
    public HashMap pairs = new HashMap<>();

    public RainbowTable() {
    }

    public RainbowTable(String alphabet, int maxLength, int chainLength, HashMap pairs) {
        this.alphabet = alphabet;
        this.maxLength = maxLength;
        this.chainLength = chainLength;
        this.pairs = pairs;
    }

    public void setPairs(HashMap pairs) {
        this.pairs = pairs;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
    
    public void setChainLength(int chainLength) {
        this.chainLength = chainLength;
    }

    public HashMap getPairs() {
        return pairs;
    }
}
