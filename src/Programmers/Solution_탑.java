/*
송지은_프로그래머스 알고리즘 탑
*/

package Programmers;

public class Solution_탑 {
	public static void main(String[] args) {

	}

	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		answer[0] = 0;

		for (int i = heights.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
			}
		}

		return answer;
	}
}
