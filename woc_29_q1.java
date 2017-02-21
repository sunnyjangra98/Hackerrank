package hackerrank_problems;

import java.util.Scanner;

public class woc_29_q1 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int year=in.nextInt();
		if (isLeap(year))
			System.out.println("12.09."+year);
		else
			System.out.println("13.09."+year);
		in.close();

	}
	public static boolean isLeap(int year){
		if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
            return true;
		else
            return false;
	}

}
