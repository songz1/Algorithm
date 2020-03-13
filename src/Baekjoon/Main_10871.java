/*
송지은_백준 알고리즘 10871번

입력 받으면서 X보다 작은지 확인
-> 작으면 바로 출력
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10871 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int X = Integer.parseInt(stringTokenizer.nextToken());

		int temp;
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(stringTokenizer.nextToken());

			if (temp < X) {
				System.out.print(temp + " ");
			}
		}
	}
}
