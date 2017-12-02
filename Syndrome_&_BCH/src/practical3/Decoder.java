
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
public class Decoder {
//Modular modMan = new Modular();

    public static String error(int[] code, int[] syn) {
        String s = "";
        int mod = 11;
        boolean iIsValid;

        // Calculate P,Q,R : Sn == syn[n-1]
        //P = (S2^2)  - (S1*S3) mod 11    
        //Q = (S1*S4) - (S2*S3) mod 11    	
        //R = (S3^2)  - (S2*S4) mod 11    
        int p = Modular.checkNegative((Modular.multiply(syn[1], syn[1], mod) - Modular.multiply(syn[0], syn[2], mod)), mod);
        int q = Modular.checkNegative((Modular.multiply(syn[0], syn[3], mod) - Modular.multiply(syn[1], syn[2], mod)), mod);
        int r = Modular.checkNegative((Modular.multiply(syn[2], syn[2], mod) - Modular.multiply(syn[1], syn[3], mod)), mod);

        // P=Q=R=0 : IF all three are equal to 0 menas there is a single error
        if ((p == q) && (q == r) && (r == 0)) {
            int i = Modular.checkNegative((Modular.divide(syn[1], syn[0], mod)), mod);
            if (i > 0) {
                iIsValid = correct(code, i, syn[0], mod);
                if (iIsValid == true) {
                    s = s + "\nOutput : " + codeString(code);
                    s = s + "\nsingle_err(i=" + i + ", a=" + syn[0] + ", syn(" + syn[0] + "," + syn[1] + "," + syn[2] + "," + syn[3] + "))";
                } else {
                    s = greaterThanTwoString(syn, p, q, r);
                }
            } else {
                s = greaterThanTwoString(syn, p, q, r);
            }
        } else {
            // code for double error
            // quad = Q*Q – 4PR 
            int quad = Modular.checkNegative(((Modular.multiply(q, q, mod) - Modular.multiply(4, Modular.multiply(p, r, mod), mod))), mod);
            // sqrt(quad) returns int value is exisits or -1 if not
            quad = Modular.sqrt(quad); //sqrt current only returns mod 11 examples

            int i = Modular.checkNegative((Modular.divide(((0 - q) + quad), Modular.multiply(2, p, mod), mod)), mod);
            int j = Modular.checkNegative((Modular.divide(((0 - q) - quad), Modular.multiply(2, p, mod), mod)), mod);

            // If sqrt of quad exsits 
            // AND
            // if i & j are greater than 0
            // AND
            // if i and j do not point to the same position
            if ((quad != -1) && ((i > 0) && (j > 0)) && (i != j)) {

                // b = (i*s1 - s2) / (i - j) 	: s1 = syn[0], s2 = syn[1]
                // a = s1 – b     
                int b = Modular.checkNegative((Modular.divide((Modular.multiply(i, syn[0], mod) - syn[1]), (i - j), mod)), mod);
                int a = Modular.checkNegative((syn[0] - b), mod);

                // Correct the code and the new digit isnt a 10
                iIsValid = correct(code, i, a, mod);
                boolean jIsValid = correct(code, j, b, mod);

                // is corrected sequence doesn't contains a 10
                if ((iIsValid == true) && (jIsValid == true)) {
                    // Add results to String
                    s = s + "\nOutput : " + codeString(code);
                    s = s + "\ndouble_err(i=" + i + ", a=" + a + ", j=" + j + ", b=" + b + ", syn(" + syn[0] + "," + syn[1] + "," + syn[2] + "," + syn[3] + "), "
                            + "pqr(" + p + "," + q + "," + r + "))";
                } else {
                    s = greaterThanTwoString(syn, p, q, r);
                }
            } else {
                s = greaterThanTwoString(syn, p, q, r);
            }
        }

        return s;
    }

    // Takes in the int array and will correct using 
    // i = position of error
    // a = magnitued of error
    // checks isn't a 10 
    public static boolean correct(int[] x, int i, int a, int mod) {
        i = i - 1;
        x[i] = Modular.checkNegative((x[i] - a), mod);
        return x[i] != 10; // returns flase if == 10
    }

    // Convert the int array into to string
    public static String codeString(int[] x) {
        String s = "";
        for (int i = 0; i < x.length; i++) {
            s = s + x[i];
        }
        return s;
    }

    // Return string stating there were more than 2 errors within the code. 
    // Requires syndrome, p, q, and r passed into it to display within the message
    public static String greaterThanTwoString(int[] syn, int p, int q, int r) {
        String s = "\nOutput : ( ?? )";
        s = s + "\nmorethan2_no_sqrt(syn(" + syn[0] + "," + syn[1] + "," + syn[2] + "," + syn[3] + "), "
                + "pqr(" + p + "," + q + "," + r + "))";
        return s;
    }

}
