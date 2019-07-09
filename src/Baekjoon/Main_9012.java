/*
송지은_백준 알고리즘 9012번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9012 {
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(input.readLine());
			String str = stringTokenizer.nextToken();
			int count = 0;
			boolean vps = true;

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					count++;
				} else if (str.charAt(j) == ')') {
					if (count <= 0) {
						vps = false;
						break;
					} else {
						count--;
					}
				}
			}

			if (!vps || count != 0) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
