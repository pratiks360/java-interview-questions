/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[]) throws Exception {
        int len =Integer.parseInt(args[0]);
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] ap = alphabets.toCharArray();
        for(int i=0;i<len;i++){
           print1(ap[i],len);

            if(i<len-1)
            System.out.println("");
        }

    }


    public static void print1(char a,int len) {
        for (int i = 0; i < len; i++) {
            if(i!=0){
                System.out.print(" ");

            }
            System.out.print(a);
        }
    }
}