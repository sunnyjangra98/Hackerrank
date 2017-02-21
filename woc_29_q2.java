package hackerrank_problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class woc_29_q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger[] unsorted = new BigInteger[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            BigInteger number = new BigInteger(in.next());
            unsorted[unsorted_i] =number;
        }
        // your code goes here
        Arrays.sort(unsorted);
        for (int i=0;i<n;i++)
            System.out.println(unsorted[i]);
    }
}