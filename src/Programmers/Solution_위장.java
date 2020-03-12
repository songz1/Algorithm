/*
송지은_프로그래머스 알고리즘 위장

HashMap에 Key:옷 종류, Value:종류 수 저장
-> 조합 계산

ex) A:3개 B:3개 C:2개
A: (3개 + 안입는 경우) 중 1개 선택 => 조합 4C1
B: (3개 + 안입는 경우) 중 1개 선택 => 조합 4C1
C: (2개 + 안입는 경우) 중 1개 선택 => 조합 3C1
====> (4C1 * 4C1 * 3C1) - (아무것도 안입는 경우 1)
*/

package Programmers;

import java.util.HashMap;
import java.util.Set;

public class Solution_위장 {
	public static void main(String[] args) {

	}

	public int solution(String[][] clothes) {
		HashMap<String, Integer> clothes_list = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			if (clothes_list.containsKey(clothes[i][1])) {
				int temp = clothes_list.get(clothes[i][1]);
				clothes_list.replace(clothes[i][1], temp + 1);
			} else {
				clothes_list.put(clothes[i][1], 1);
			}
		}

		Set<String> set = clothes_list.keySet();
		int answer = 1;

		for (String s : set) {
			answer *= clothes_list.get(s) + 1;
		}

		return answer - 1;
	}
}
