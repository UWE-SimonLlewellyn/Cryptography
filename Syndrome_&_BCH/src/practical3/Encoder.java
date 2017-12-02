/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical3;

/**
 *
 * @author sa-llewellyn
 */
public class Encoder {
    
 public static int[] tenSix(int[] d) {

        d[6] = ((4 * d[0]) + (10 * d[1]) + (9 * d[2]) + (2 * d[3]) + d[4] + (7 * d[5])) % 11;
        d[7] = ((7 * d[0]) + (8 * d[1]) + (7 * d[2]) + (d[3]) + (9 * d[4]) + (6 * d[5])) % 11;
        d[8] = ((9 * d[0]) + (d[1]) + (7 * d[2]) + (8 * d[3]) + (7 * d[4]) + (7 * d[5])) % 11;
        d[9] = ((d[0]) + (2 * d[1]) + (9 * d[2]) + (10 * d[3]) + (4 * d[4]) + (d[5])) % 11;

        return d;

    }
 
 public static int[] syndromes(int[] d) {
        int[] syn = new int[4];
        int temp = 0, power = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                power = (int) ((Math.pow(j+1, i)) % 11); 
                temp = temp + (d[j] * power);
            }
            syn[i] = (temp % 11);
            temp = 0;
        }

        return syn;
    }

}