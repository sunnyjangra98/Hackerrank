package hackerrank_problems;

import java.util.Scanner;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class rookierank_q5{

    public static Set<String> results = new HashSet<>();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] s = new String[n];
        
        long result = 0;
        
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.next();
        }
        
        Arrays.sort(s);//sorting array
        
        for (int a = 0; a < n ;a++) {
            //System.out.println(s[a]); // when uncommented shows sorted list of elements
            ArrayList<String> aInB = new ArrayList<>();
            int minVal = 12;
            for (int b = a+1; b < n; b++) {
                if (s[b].startsWith(s[a])) { // makes a list will all the B's that contain A
                    aInB.add(s[b]);
                    if (s[b].length() < minVal) {//checks min value of all added B.
                        minVal = s[b].length();
                    }
                } else {
                    break; //since the list is sorted if it doesnt find any extra B containing A stop
                }                
            }
            for (int b = 0; b < aInB.size(); b++) { //
                if (aInB.get(b).length() > minVal) {//checks the size of the current B against the lowest: if true it means that the A and B are not Neighbors
                    //addToResults("", s[a]); //when uncommented only test cases lower than 5 passes but seems to be necesarry for cases like A AA AAB so it return A AAB instead of only AAB so I'm consused
                } else {
                    addToResults(s[a], aInB.get(b));//if false it means that they are neighbors and if the lowest value is already present it removes it from the results and then adds the mayor value
                }
            }
            if (aInB.isEmpty()){//for when there is no A in B
                addToResults("", s[a]);
            }
        }
        
        
        for (String str: results) {
            //System.out.println(str); //when uncommented shows all added
            result+=calculateValue(str);
            
        }
        
        System.out.println(result);
        
    }
    
    public static int calculateValue(String str) {
        int result = 0;
        //System.out.println("result: " + str);
        for (int x = 0; x < str.length(); x++) {
            result += str.charAt(x);
        }
        //System.out.println(result);
        return result;
    }
    
    public static void addToResults(String toReplace, String add) {
        if (results.contains(toReplace)) {
            results.remove(toReplace);
            results.add(add);
        } else {
            results.add(add);
        }
    }
        
}
