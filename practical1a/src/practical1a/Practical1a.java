/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical1a;

import java.util.Scanner;

/**
 *
 * @author sa-llewellyn
 */
public class Practical1a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter x value: ");
        int x = sc.nextInt();

        System.out.print("Please enter y value: ");
        int y = sc.nextInt();

        System.out.print("Please enter mod value: ");
        int mod = sc.nextInt();

        //10 int sum = ;
        System.out.println(x + " + " + y + " mod " + mod + " = " + add(x, y, mod));
        System.out.println(x + " * " + y + " mod " + mod + " = " + multiply(x, y, mod));
        System.out.println(x + " / " + y + " mod " + mod + " = " + divide(x, y, mod));

    }

    public static int add(int x, int y, int mod) {
        x = checkNegative(x, mod);
        y = checkNegative(y, mod);
        return (x + y) % mod;

    }

    public static int multiply(int x, int y, int mod) {
        x = checkNegative(x, mod);
        y = checkNegative(y, mod);
        return ((x % mod) * (y % mod)) % mod;
    }

    public static int divide(int x, int y, int mod) {
        x = checkNegative(x, mod);
        y = checkNegative(y, mod);

        y = inverse(y, mod);
        if (y < 0) {
            return y; // y = -1
        } else {
            return (x * y) % mod;
        }
    }

//    // My initial version 
//    public static int inverse(int x, int mod) {
//        for (int i = 1; i < mod; i++) {
//            if ((i * x) % mod == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }
    //taken from Rong Yang's lecture notes
    //Bsesed on Extended Euclidean Algorithm
    public static int inverse(int x, int mod) {
        int t = 0;
        int newt = 1;
        int r = mod;
        int newr = x;
        int q, temp;
        while (newr != 0) {
            q = r / newr;
            /* integer division */
            temp = newt;
            /* remember newt    */
            newt = t - q * newt;
            t = temp;
            temp = newr;
            /* remember newr    */
            newr = r - q * newr;
            r = temp;
        }
        if (r > 1) {
            return -1; /* not invertible */
        }
        if (t < 0) {
            t = t + mod; /* change to positive */
        }
        return t;
    }

    public static int checkNegative(int x, int mod) {
        while (x < 0) {
            x = x + mod;
        }

        return x;
    }

}
