package hackerrank_problems;

import java.util.Arrays;
import java.util.Scanner;

class rookierank_q2 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		for (int i=0;i<n;i++)
			a[i]=in.nextInt();
		Arrays.sort(a);
		int value = Integer.MAX_VALUE;
		for(int i=1;i<n;i++){
	        if(Math.abs((a[i-1]-a[i])) < value)
	            value = Math.abs((a[i-1]-a[i]));
	    }
	    System.out.println(value);
		in.close();

	}

}
