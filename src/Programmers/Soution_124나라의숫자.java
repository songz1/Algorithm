/*
송지은_프로그래머스 124 나라의 숫자
*/

package Programmers;

public class Soution_124나라의숫자 {
	public static void main(String[] args) {
		for (int i = 10; i < 21; i++) {
			System.out.println("**************i=" + i);
			System.out.println("ans= " + solution(i));
			System.out.println();
		}
	}

	public static String solution(int n) {
		String answer = "";
		int remainder;

		while (n > 0) {
			remainder = (n % 3 == 0 ? 4 : n % 3);
			n = (remainder == 4 ? n / 3 - 1 : n / 3);
			answer = remainder + answer;
		}

		return answer;
	}
}
