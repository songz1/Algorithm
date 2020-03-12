/*
송지은_백준 알고리즘 2975번
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
