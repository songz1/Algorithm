/*
송지은_백준 알고리즘 16719번

slice >>
1. 시작 인덱스가 종료 인덱스보다 크면 리턴
2. 주어진 범위 내에서 가장 작은 알파벳 찾기
3. print 호출
4. 찾은 알파벳의 인덱스+1 부터 종료 인덱스까지 재귀
5. 오른쪽을 모두 확인했으면 왼쪽 확인 >> 시작 인덱스부터 인덱스-1까지

print >>
HashSet에 인덱스 번호 저장
-> 번호 있으면 출력
*/

package Baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class Main_16719 {
	static String s;
	static String result = "";
	static HashSet<Integer> idx = new HashSet<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		s = scanner.next();

		slice(0, s.length() - 1);
	}

	// 작은 알파벳 찾기
	public static void slice(int start, int end) {
		if (start > end) {
			return;
		}

		int min = Integer.MAX_VALUE;
		int index = 0;

		for (int i = start; i <= end; i++) {
			if (min > s.charAt(i) - '0') {
				min = s.charAt(i) - '0';
				index = i;
			}
		}

		idx.add(index);
		print();

		slice(index + 1, end);

		slice(start, index - 1);
	}

	// 출력
	public static void print() {
		for (int i = 0; i < s.length(); i++) {
			if (idx.contains(i)) {
				System.out.print(s.charAt(i));
			}
		}
		System.out.println();
	}
}
