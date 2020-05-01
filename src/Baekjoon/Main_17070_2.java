/*
송지은_백준 알고리즘 17070번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_2 {
    static int N;
    static int[][] house;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        house = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3];

        for (int i = 1; i < N + 1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j < N + 1; j++) {
                house[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dp[1][2][0] = 1;
        DP();

        System.out.print(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }

    public static void DP() {
        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if (house[i][j] == 0) {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                    if (i != 1) {
                        dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                        if (house[i - 1][j] == 0 && house[i][j - 1] == 0) {
                            dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                        }
                    }
                }
            }
        }
    }
}
