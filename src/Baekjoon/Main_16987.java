/*
송지은_백준 알고리즘 16987번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16987 {
    static int N;
    static int[] S;
    static int[] W;
    static int count = 0;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        S = new int[N];  // 내구도
        W = new int[N];  // 무게

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            S[i] = Integer.parseInt(stringTokenizer.nextToken());
            W[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        backTraking(0);

        System.out.print(result);
    }

    public static void backTraking(int pick) {
        result = Math.max(result, count);

        if (pick == N) {
            return;
        }

        if (S[pick] > 0) {
            for (int i = 0; i < N; i++) {
                if (i != pick && S[i] > 0) {
                    S[i] -= W[pick];
                    S[pick] -= W[i];

                    int countTemp = count;
                    count = S[i] > 0 ? count : count + 1;
                    count = S[pick] > 0 ? count : count + 1;

                    backTraking(pick + 1);

                    S[i] += W[pick];
                    S[pick] += W[i];
                    count = countTemp;
                }
            }
        } else {
            backTraking(pick + 1);
        }
    }
}
