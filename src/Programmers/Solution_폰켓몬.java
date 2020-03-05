/*
송지은_프로그래머스 나누어 떨어지는 숫자 배열
*/

package Programmers;

import java.util.HashSet;

public class Solution_폰켓몬 {
	public static void main(String[] args) {

	}

	public int solution(int[] nums) {
		int answer;
		HashSet<Integer> ponketmon = new HashSet();

		for (int i = 0; i < nums.length; i++) {
			ponketmon.add(nums[i]);
		}

		if (ponketmon.size() < nums.length / 2) {
			answer = ponketmon.size();
		} else {
			answer = nums.length / 2;
		}

		return answer;
	}
}
