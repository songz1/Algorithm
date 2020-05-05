/*
송지은_백준 알고리즘 16637번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_16637 {
    static int[] operation;
    static char[] operator;
    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        String str = bufferedReader.readLine();

        operation = new int[N / 2 + 1];
        operator = new char[N / 2];
        int operationIdx = 0;
        int operatorIdx = 0;

        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*') {
                operator[operatorIdx++] = str.charAt(i);
            } else {
                operation[operationIdx++] = str.charAt(i) - '0';
            }
        }

        DFS(0, operation[0]);

        System.out.print(max);
    }

    public static void DFS(int idx, int res) {
        if (idx >= N / 2) {
            max = Math.max(max, res);
            return;
        }

        int ret = cal(res, operator[idx], operation[idx + 1]);
        DFS(idx + 1, ret);

        if (idx + 1 < N / 2) {
            ret = cal(res, operator[idx], cal(operation[idx + 1], operator[idx + 1], operation[idx + 2]));
            DFS(idx + 2, ret);
        }
    }

    public static int cal(int a, char m, int b) {
        if (m == '+') {
            return a + b;
        } else if (m == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }
}
