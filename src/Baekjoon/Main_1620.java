/*
송지은_백준 알고리즘 1620번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1620 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());

		Map<Integer, String> poketmonIndex = new HashMap<>(N);
		Map<String, Integer> poketmonName = new HashMap<>(N);
		for (int i = 1; i <= N; i++) {
			String name = bufferedReader.readLine();
			poketmonIndex.put(i, name);
			poketmonName.put(name, i);
		}

		String input;
		int num = 0;
		Boolean check;
		for (int i = 0; i < M; i++) {
			check = false;
			input = bufferedReader.readLine();

			if (input.charAt(0) == '1' || input.charAt(0) == '2' || input.charAt(0) == '3' || input.charAt(0) == '4' || input.charAt(0) == '5' || input.charAt(0) == '6' || input.charAt(0) == '7' || input.charAt(0) == '8' || input.charAt(0) == '9') {
				num = Integer.parseInt(input);
				check = true;
			}
			/*for (char ch : input.toCharArray()) {
				if (Character.isDigit(ch) == true) {
					check = true;
					break;
				}
			}*/

			if (check) {
				System.out.println(poketmonIndex.get(num));
			} else {
				System.out.println(poketmonName.get(input));
			}
		}
	}
}
