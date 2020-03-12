/*
송지은_백준 알고리즘 10815번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_10815 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bufferedReader.readLine());
		HashSet get = new HashSet();
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++) {
			get.add(Integer.parseInt(stringTokenizer.nextToken()));
		}

		int M = Integer.parseInt(bufferedReader.readLine());
		int[] check = new int[M];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < M; i++) {
			check[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		for (int i = 0; i < M; i++) {
			if (get.contains(check[i])) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
		}
	}
}
