package hackerrank_problems;

import java.util.Scanner;

class rookierank_q1 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];
		for (int i=0;i<n;i++)
			a[i]=in.nextInt();
		int c1=0,c2=1,c3=2,c4=3,c5=4;
		int[] b=new int[5];
		for (int i=0;i<n;i++){
			switch(a[i]){
			case 1:
				b[c1]++;
				break;
			case 2:
				b[c2]++;
				break;
			case 3:
				b[c3]++;
				break;
			case 4:
				b[c4]++;
				break;
			case 5:
				b[c5]++;
				break;
			}
		}
		int max=b[0];
		int index=0;
		for (int i=1;i<5;i++){
			if (max<b[i]){
				max=b[i];
				index=i;
			}
		}
		System.out.println(index+1);
		in.close();

	}

}
