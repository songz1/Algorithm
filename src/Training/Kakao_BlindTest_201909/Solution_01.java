/*
송지은_카카오 블라인드 코딩테스트_1번 오픈채팅방
*/

package Training.Kakao_BlindTest_201909;

import java.util.HashMap;
import java.util.Map;

public class Solution_01 {
	public static void main(String[] args) {
		String[] test = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
		for (String testTemp : test) {
			System.out.println(testTemp);
		}
	}

	public static String[] solution(String[] record) {
		Map<String, String> id = new HashMap<>();
		String[][] result = new String[record.length][2];
		int count = 0;

		for (String recordTemp : record) {
			String[] temp = recordTemp.split(" ");

			if (temp[0].equals("Enter")) {
				id.put(temp[1], temp[2]);
				result[count][0] = temp[0];
				result[count++][1] = temp[1];
			} else if (temp[0].equals("Change")) {
				id.put(temp[1], temp[2]);
			} else {
				result[count][0] = temp[0];
				result[count++][1] = temp[1];
			}
		}

		String[] answer = new String[count];
		for (int i = 0; i < count; i++) {
			if (result[i][0].equals("Enter")) {
				answer[i] = id.get(result[i][1]) + "님이 들어왔습니다.";
			} else {
				answer[i] = id.get(result[i][1]) + "님이 나갔습니다.";
			}
		}

		return answer;
	}
}
