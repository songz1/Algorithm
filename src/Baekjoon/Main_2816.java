/*
송지은_백준 알고리즘 2816번

방법 1)
KBS 찾을때까지 아래로 이동
-> 찾으면 위로 이동

틀려서 방법 수정

방법 2)
KBS 인덱스 계산
-> KBS1은 인덱스만큼 1출력, 4출력
-> if. KBS1 인덱스 < KBS2인덱스 >> KBS2는 인덱스만큼 1출력, 인덱스-1만큼 4출력
-> if. KBS1 인덱스 > KBS2인덱스 >> KBS2는 인덱스+1만큼 1출력, 인덱스만큼 4출력
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2816 {
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		String channel;
		int idx1 = 0, idx2 = 0;

		for (int i = 0; i < N; i++) {
			channel = bufferedReader.readLine();

			if (channel.equals("KBS1")) {
				idx1 = i;
			} else if (channel.equals("KBS2")) {
				idx2 = i;
			}
		}

		int p = idx1 > idx2 ? 1 : 0;

		for (int i = 0; i < idx1; i++) {
			System.out.print(1);
		}
		for (int i = 0; i < idx1; i++) {
			System.out.print(4);
		}
		for (int i = 0; i < idx2 + p; i++) {
			System.out.print(1);
		}
		for (int i = 0; i < idx2 - 1 + p; i++) {
			System.out.print(4);
		}

/* 방법 1
		String temp;
		for (int i = 1; i < N; i++) {
			System.out.print("1");
			if (channel[i].equals("KBS1")) {
				for (int j = i; j > 0; j--) {
					temp = channel[j];
					channel[j] = channel[j - 1];
					channel[j - 1] = temp;

					System.out.print("4");
				}
				break;
			}
		}

		for (int i = 1; i < N; i++) {
			System.out.print("1");
			if (channel[i].equals("KBS2")) {
				for (int j = i; j > 1; j--) {
					temp = channel[j];
					channel[j] = channel[j - 1];
					channel[j - 1] = temp;

					System.out.print("4");
				}
				break;
			}
		}*/
	}
}
