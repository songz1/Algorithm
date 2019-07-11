/*
송지은_백준 알고리즘 1406번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main_1406 {
	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		int n = Integer.parseInt(bf.readLine());

		LinkedList<Character> list = new LinkedList<>();
		for (char c : str.toCharArray()) {
			list.add(c);
		}

		ListIterator iterator = list.listIterator(list.size());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			str = st.nextToken();

			switch (str) {
				case "L":
					if (iterator.hasPrevious()) {
						iterator.previous();
					}
					break;
				case "D":
					if (iterator.hasNext()) {
						iterator.next();
					}
					break;
				case "B":
					if (iterator.hasPrevious()) {
						iterator.previous();
						iterator.remove();
					}
					break;
				case "P":
					iterator.add(st.nextToken().charAt(0));
					break;
			}
		}

		StringBuilder result = new StringBuilder();
		for (char c : list) {
			result.append(c);
		}
		System.out.println(result);
	}
}
