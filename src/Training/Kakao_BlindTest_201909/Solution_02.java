/*
송지은_카카오 블라인드 코딩테스트_2번 실패율
*/

package Training.Kakao_BlindTest_201909;

public class Solution_02 {
	public int[] solution(int N, int[] stages) {
		double[] count = new double[N + 2];
		int user = 0;
		int clear_user;

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
			clear_user = (int) count[i];
			count[i] = clear_user / user;
			user = user - clear_user;
		}

		int[] answer = new int[N];
		for(int i=1; i<N; i++){
			
		}




		return answer;
	}
}
