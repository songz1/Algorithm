/*
송지은_백준 알고리즘 1965번
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
