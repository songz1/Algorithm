/*
송지은_프로그래머스 정수 삼각형
*/

package Programmers;

public class Solution_정수삼각형 {
	public static void main(String[] args) {

		int[][] a = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

		System.out.print(solution(a));

	}

	public static int solution(int[][] triangle) {
		int[][] result = new int[triangle.length][triangle[triangle.length - 1].length];
		result[0][0] = triangle[0][0];

		for (int i = 0; i < triangle.length - 1; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j == 0) {
					result[i + 1][0] = result[i][0] + triangle[i + 1][0];
					result[i + 1][1] = result[i][0] + triangle[i + 1][1];
				} else {
					result[i + 1][j] = (result[i + 1][j] >= result[i][j] + triangle[i + 1][j] ? result[i + 1][j] : result[i][j] + triangle[i + 1][j]);
					result[i + 1][j + 1] = result[i][j] + triangle[i + 1][j + 1];
				}
			}
		}

		int max = 0;
		for (int i = 0; i < result.length; i++) {
			max = (max >= result[result.length - 1][i] ? max : result[result.length - 1][i]);
		}

		return max;
	}
}
