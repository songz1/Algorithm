/*
송지은_카카오 블라인드 코딩테스트_2번 실패율
*/

package Training.Kakao_BlindTest_201909;

public class Solution_02 {
	public static void main(String[] args) {
		int[] result = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
		for (int temp : result) {
			System.out.print(temp + " ");
		}
		System.out.println();

		result = solution(4, new int[]{4, 4, 4, 4, 4});
		for (int temp : result) {
			System.out.print(temp + " ");
		}
	}

	public static int[] solution(int N, int[] stages) {
		double[] count = new double[N + 2];
		int user = 0;
		int fail_user;

		for (int stage : stages) {
			count[stage]++;
			user++;
		}

		for (int i = 1; i <= N; i++) {
			if (user == 0) {
				while (i <= N) {
					count[i] = 0;
					i++;
				}
			}
			fail_user = (int) count[i];
			count[i] = (double) fail_user / user;
			user = user - fail_user;
		}

		int[] answer = new int[N];
		int temp = 1;
		for (int j = 0; j < answer.length; j++) {
			for (int i = 2; i <= N; i++) {
				temp = count[temp] >= count[i] ? temp : i;
			}
			answer[j] = temp;
			count[temp] = -1;
			temp = 1;
		}

		return answer;
	}
}
