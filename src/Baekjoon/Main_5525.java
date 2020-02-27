/*
송지은_백준 알고리즘 5525번_시간초과
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5525 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int M = Integer.parseInt(bufferedReader.readLine());
		String S = bufferedReader.readLine();

		String find = "IOI";
		for (int i = 1; i < N; i++) {
			find = find + "OI";
		}

		int count = 0;
		while (S.length() >= find.length()) {
			for (int i = 0; i <= S.length() - find.length(); i++) {
				if (S.charAt(i) == 'I') {
					String temp = S.substring(i, i + find.length());
					if (temp.equals(find)) {
						count++;
						S = S.substring(i + 2);
					} else {
						int j;
						for (j = 1; j < temp.length(); j++) {
							if (temp.charAt(j) == 'I') {
								break;
							}
						}
						S = S.substring(j);
					}

					break;
				} else if (S.length() == find.length() && S.charAt(i) != 'I') {
					System.out.print(count);
					return;
				}
			}
		}

		System.out.print(count);
	}
}
