/*
송지은_백준 알고리즘 1302번

HashMap에 Key:책이름, Value:팔린수량 저장
-> Hashmap 돌면서 가장 많이 팔린 책 찾기
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class Main_1302 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		HashMap<String, Integer> book = new HashMap<>();
		String input = "";

		for (int i = 0; i < N; i++) {
			input = bufferedReader.readLine();

			if (book.containsKey(input)) {
				book.put(input, book.get(input) + 1);
			} else {
				book.put(input, 1);
			}
		}

		int max = 0;
		String result = input;
		Set<String> set = book.keySet();

		for (String s : set) {
			if (max < book.get(s)) {
				max = book.get(s);
				result = s;
			} else if (max == book.get(s)) {
				result = s.compareTo(result) < 0 ? s : result;
			}
		}

		System.out.print(result);
	}
}
