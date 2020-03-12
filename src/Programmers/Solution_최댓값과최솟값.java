/*
송지은_프로그래머스 알고리즘 최댓값과 최솟값

배열로 받아서 sort
-> 양 끝 값 반환
*/

package Programmers;

import java.util.Arrays;

public class Solution_최댓값과최솟값 {
	public static void main(String[] args) {

	}

	public String solution(String s) {
		String[] str = s.split(" ");
		int[] arr = new int[str.length];

		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		Arrays.sort(arr);

		String answer = arr[0] + " " + arr[arr.length - 1];

		return answer;
	}
}
