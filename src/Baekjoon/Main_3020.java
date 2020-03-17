/*
송지은_백준 알고리즘 3020번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3020 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int H = Integer.parseInt(stringTokenizer.nextToken());
        int[] cave = new int[H];
        int[] up = new int[H];
        int[] down = new int[H];

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(bufferedReader.readLine());

            if (i % 2 == 0) {
                down[H - temp]++;
            } else {
                up[temp - 1]++;
            }
        }

        // 짝수(down)
        for (int i = 1; i < H; i++) {
            down[i] += down[i - 1];
        }

        // 홀수(up)
        for (int i = H - 2; i >= 0; i--) {
            up[i] += up[i + 1];
        }

        // 총 합
        for (int i = 0; i < H; i++) {
            cave[i] = down[i] + up[i];
        }

        Arrays.sort(cave);

        int count = 1;
        for (int i = 1; i < H; i++) {
            if (cave[0] == cave[i]) {
                count++;
            } else {
                break;
            }
        }

        System.out.print(cave[0] + " " + count);
    }
}
