/*
송지은_카카오 블라인드 코딩테스트_4번 무지의 먹방 라이브
*/

package Training.Kakao_BlindTest_201909;

import java.util.Arrays;

public class Solution_04 {
	public static void main(String[] args) {
		int result = solution(new int[]{3, 1, 2}, 5);
		System.out.println(result);
	}

	public static int solution(int[] food_times, long k) {
		Food[] food_times_temp = new Food[food_times.length];

		for (int i = 0; i < food_times.length; i++) {
			food_times_temp[i] = new Food(food_times[i], i);
		}

		Arrays.sort(food_times_temp);

		long time = 0;
		long temp;
		int idx = 0;
		for (int i = 0; i < food_times.length; i++) {
			if (i == 0) {
				temp = (food_times.length - i) * (food_times_temp[i].getValue());
			} else {
				temp = (food_times.length - i) * (food_times_temp[i].getValue() - food_times_temp[i - 1].getValue());
			}

			if (temp + time > k) {
				idx = i;
				break;
			}

			time = time + temp;
			food_times[food_times_temp[i].getIdx()] = -1;
		}

		idx = min(food_times_temp, idx);
		int answer;
		boolean more = true;

		for (int i = 0; i < food_times.length; i++) {
			if (food_times[i] > 0) {
				more = false;
				break;
			}
		}
		if (more) {
			return -1;
		}

		while (true) {
			if (time > k) {
				answer = idx;
				break;
			}

			if (food_times[idx] > 0) {
				food_times[idx]--;
				time++;
			}

			idx = (idx + 1) >= food_times.length ? 0 : ++idx;
		}

		return answer;
	}

	public static int min(Food[] food, int start) {
		int minIdx = start;

		for (int i = start + 1; i < food.length; i++) {
			minIdx = minIdx < food[i].getIdx() ? minIdx : food[i].getIdx();
		}

		return minIdx;
	}
}

class Food implements Comparable<Food> {
	int value;
	int idx;

	public Food(int value, int idx) {
		this.value = value;
		this.idx = idx;
	}

	public int getValue() {
		return value;
	}

	public int getIdx() {
		return idx;
	}

	@Override
	public int compareTo(Food other) {
		return value - other.value;
	}
}
