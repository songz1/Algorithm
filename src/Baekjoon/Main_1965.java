/*
송지은_백준 알고리즘 1965번

LCS 알고리즘
box 배열 : 박스의 크기 저장
dp 배열 : 앞에 나온 더 작은 크기의 박스 개수 저장(본인 포함)

이중 반복문 돌면서
1.box 배열의 크기가 본인보다 작고,
2.dp+1 크기가 본인보다 크면
dp+1 해줌
&& count 최대값으로 갱신
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1965 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] box = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(stringTokenizer.nextToken());
            dp[i] = 1;
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i] > box[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            count = count > dp[i] ? count : dp[i];
        }

        System.out.print(count);
    }
}
