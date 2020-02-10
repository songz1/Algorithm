/*
송지은_카카오 블라인드 코딩테스트_1번 비밀 지도
*/

package Training.Kakao_BlindTest_2018;

public class Solution_01 {
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};

		String[] answer = solution(n, arr1, arr2);
		for (int i = 0; i < n; i++) {
			System.out.println(answer[i]);
		}
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			answer[i] = "";
		}

		for (int i = 0; i < n; i++) {
			String temp1 = "";
			while (temp1.length() != n) {
				if (arr1[i] % 2 == 1) {
					temp1 += "#";
				} else {
					temp1 += " ";
				}
				arr1[i] = arr1[i] / 2;
			}

			String temp2 = "";
			while (temp2.length() != n) {
				if (arr2[i] % 2 == 1) {
					temp2 += "#";
				} else {
					temp2 += " ";
				}
				arr2[i] = arr2[i] / 2;
			}

			for (int j = n - 1; j >= 0; j--) {
				if (temp1.charAt(j) == '#' || temp2.charAt(j) == '#') {
					answer[i] += "#";
				} else {
					answer[i] += " ";
				}
			}
		}

		return answer;
	}
}
