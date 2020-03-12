/*
송지은_백준 알고리즘 2975번

문자열 받아서 0 W 0 인지 확인
-> 맞으면 반복문 탈출
-> 아니면 진행
-> W면 뺄셈, D면 덧셈
-> 결과값 -200 미만인지 확인해서 출력
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2975 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String input = bufferedReader.readLine();

			if (input.equals("0 W 0")) {
				break;
			}

			String[] temp = input.split(" ");

			int before = Integer.parseInt(temp[0]);
			int after = Integer.parseInt(temp[2]);
			int result;

			if (temp[1].equals("W")) {
				result = before - after;
			} else {
				result = before + after;
			}

			if (result < -200) {
				System.out.println("Not allowed");
			} else {
				System.out.println(result);
			}
		}
	}
}
