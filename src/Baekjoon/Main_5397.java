/*
송지은_백준 알고리즘 5397번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main_5397 {
	public static void main(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(bufferedReader.readLine());

		for (int i = 0; i < testNum; i++) {
			String str = bufferedReader.readLine();
			LinkedList<Character> key = new LinkedList<>();
			ListIterator iterator = key.listIterator();

			for (char c : str.toCharArray()) {
				switch (c) {
					case '<':
						if (iterator.hasPrevious()) {
							iterator.previous();
						}
						break;
					case '>':
						if (iterator.hasNext()) {
							iterator.next();
						}
						break;
					case '-':
						if (iterator.hasPrevious()) {
							iterator.previous();
							iterator.remove();
						}
						break;
					default:
						iterator.add(c);
				}
			}

			StringBuilder result = new StringBuilder();
			for (char c : key) {
				result.append(c);
			}
			System.out.println(result);
		}
	}
}
