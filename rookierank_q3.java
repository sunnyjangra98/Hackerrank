package hackerrank_problems;

import java.util.Scanner;

class rookierank_q3 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		char[] c = { 'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k' };
		int h = 0;
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			h = 0;
			for (int i = 0; i < s.length(); i++) {

				if (h == 10)
					break;
				if (s.charAt(i) == c[h]) {
					h++;
				}
			}
			if (h == 10) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
		in.close();

	}

}
