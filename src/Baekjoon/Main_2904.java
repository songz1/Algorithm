/*
송지은_백준 알고리즘 2904번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2904 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		int[] num = new int[101];
		int[] prime = new int[1000001];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(stringTokenizer.nextToken());
			int temp = num[i];

			for (int j = 2; j <= num[i]; j++) {
				while (temp % j == 0) {
					prime[j]++;
					temp = temp / j;
				}
			}
		}

		int score = 1;
		for (int i = 0; i < prime.length; i++) {
			if (prime[i] != 0 && (prime[i] / n) > 0) {
				for (int j = 0; j < (prime[i] / n); j++) {
					score *= i;
				}
			}
			prime[i] = prime[i] / n;
		}

		int count = 0;
		int[] primeTemp = new int[1000001];
		for (int i = 0; i < n; i++) {
			int temp = num[i];
			for (int j = 0; j < primeTemp.length; j++) {
				primeTemp[j] = 0;
			}

			for (int j = 2; j <= num[i]; j++) {
				while (temp % j == 0) {
					primeTemp[j]++;
					temp = temp / j;
				}
			}

			for (int j = 0; j < prime.length; j++) {
				if (prime[j] != 0 && (primeTemp[j] < prime[j])) {
					while (prime[j] != primeTemp[j]) {
						primeTemp[j]++;
						count++;
					}
				}
			}
		}

		if (score == 0) {
			score = 1;
		}
		System.out.println(score + " " + count);
	}
}
