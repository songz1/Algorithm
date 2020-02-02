package Lotte;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int[] arr = new int[N];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int num = Integer.parseInt(stringTokenizer.nextToken());
		if (num == 1) {
			int k = Integer.parseInt(stringTokenizer.nextToken());

			// 팩토리얼 계산
			int i = 2;
			for (; i < N; i++) {
				int j = i - 1;
				int fac = i;

				while (j > 0) {
					fac = fac * j--;
				}

				// k 범위
				if (fac > k) {
					break;
				}
			}



		} else {

		}
	}

}
