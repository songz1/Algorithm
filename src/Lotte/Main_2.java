package Lotte;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufferedReader.readLine());

		// 테스트케이스 갯수만큼
		while (t > 0) {
			int n = Integer.parseInt(bufferedReader.readLine());
			String[] number = new String[n];
			boolean yor = true;

			for (int i = 0; i < n; i++) {
				number[i] = bufferedReader.readLine();
			}

			// 전화번호 갯수 n번만큼
			for (int i = 0; i < n; i++) {
				int length = number[i].length();
				for (int j = 0; j < n; j++) {
					if (i != j && (length < number[j].length())) {
						String temp = number[j].substring(0, length);

						// 일관성 없는 경우
						if (temp.equals(number[i])) {
							yor = false;
							break;
						}

					}

				}
				if (!yor) {
					break;
				}

			}

			if (yor) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

			t--;
		}
	}
}
