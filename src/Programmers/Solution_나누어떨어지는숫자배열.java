/*
송지은_프로그래머스 나누어 떨어지는 숫자 배열
*/

package Programmers;

import java.util.ArrayList;

public class Solution_나누어떨어지는숫자배열 {
	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		int[] arr2 = {2, 36, 1, 3};
		int[] arr3 = {3, 2, 6};

		System.out.println(solution(arr, 5));
		System.out.println(solution(arr2, 1));
		System.out.println(solution(arr3, 10));
	}

	public static int[] solution(int[] arr, int divisor) {
		ArrayList<Integer> arrayList = new ArrayList();
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				arrayList.add(arr[i]);
				count++;
			}
		}

		arrayList.sort(null);
		int[] answer;

		if (count == 0) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			answer = new int[count];
			for (int i = 0; i < count; i++) {
				answer[i] = arrayList.get(i);
			}
		}

		return answer;
	}
}
