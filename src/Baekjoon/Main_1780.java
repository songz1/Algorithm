/*
송지은_백준 알고리즘 1780번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {
    static int[][] paper;
    static int[] count = new int[3];  // 0:-1, 1:0, 2:1

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        division(0, 0, N);

        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }

    public static void division(int x, int y, int size) {
        if (check(x, y, size)) {
            count[paper[x][y] + 1]++;
        } else {
            size = size / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    division(x + size * i, y + size * j, size);
                }
            }
        }
    }

    public static Boolean check(int x, int y, int size) {
        int num = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (num != paper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
