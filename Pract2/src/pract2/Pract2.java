/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pract2;

import java.util.Scanner;

/**
 *
 * @author sa-llewellyn
 */
public class Pract2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] d = new int[10];

        System.out.println("Please enter a 6 digit sequence: ");
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
            d[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        d = tenSix(d);
        s = "";
        for (int i = 0; i < d.length; i++) {
            if (d[i] < 10) {
                s = s + d[i];
            } else {
                s = "unusable number";
                break;
            }
        }
        System.out.println(s + "\n");
        int[] syn = syndromes(d);

        for (int i = 0; i < syn.length; i++) {
            System.out.print(syn[i]);
        }
        System.out.println("\n");

    }

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
            System.out.print("S" + (i+1) + " = "); //prints out the multiples for the index
            for (int j = 0; j < 10; j++) {
                power = (int) ((Math.pow(j+1, i)) % 11); 
                System.out.print(power + " ");
                temp = temp + (d[j] * power);
            }
            System.out.println("");
            syn[i] = (temp % 11);
            temp = 0;
        }

        return syn;
    }

}
