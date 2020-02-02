/*
송지은_SW 알고리즘 2072번
*/

package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2072 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());

		for (int i = 0; i < T; i++) {
			int n;
			int sum = 0;

			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < 10; j++) {
				n = Integer.parseInt(stringTokenizer.nextToken());

				if (n % 2 != 0) {
					sum += n;
				}
			}

			System.out.println("#" + (i + 1) + " " + sum);
		}
	}
}
