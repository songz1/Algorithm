/*
송지은_프로그래머스 괄호 변환
*/

package Programmers;

import java.util.Stack;

public class Solution_괄호변환 {
	public static void main(String[] args) {
		System.out.println(solution("(()())()"));
		System.out.println(solution(")("));
		System.out.println(solution("()))((()"));

		System.out.println(solution(""));
		System.out.println(solution("()"));
		System.out.println(solution("(((()))))("));

		System.out.println(solution("))(("));
	}

	public static String solution(String p) {
		if (p.isEmpty() || check(p)) {
			return p;
		}

		int countL = 0, countR = 0;
		for (char c : p.toCharArray()) {
			if (c == '(') {
				countL++;
			} else {
				countR++;
			}

			if (countL == countR) {
				break;
			}
		}

		String u = p.substring(0, countL + countR);
		String v = p.substring(countL + countR);

		if (check(u)) {
			u = u + solution(v);

			return u;
		}


		String temp = "(";
		temp = temp + solution(v);
		temp = temp + ")";
		u = u.substring(1, u.length() - 1);

		String temp2 = "";
		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == '(') {
				temp2 += ')';
			} else {
				temp2 += '(';
			}
		}
		u = temp2;

		temp = temp + u;

		return temp;
	}

	public static Boolean check(String p) {
		Stack<Character> stack = new Stack<>();

		for (char c : p.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else if (stack.isEmpty()) {
				return false;
			} else if (!stack.isEmpty()) {
				stack.pop();
			}
		}

		if (!stack.isEmpty()) {
			return false;
		}

		return true;
	}
}
