/*
송지은_백준 알고리즘 17070번 시간초과
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17070 {
    static int N;
    static int[][] house;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(bufferedReader.readLine());
        house = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j < N + 1; j++) {
                house[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        BFS(1, 2);

        System.out.print(count);
    }

    public static void BFS(int r, int c) {
        Queue<Pipe> queue = new LinkedList();
        queue.offer(new Pipe(1, r, c));

        while (!queue.isEmpty()) {
            Pipe pipe = queue.poll();
            int rTemp = pipe.r;
            int cTemp = pipe.c;

            if (rTemp == N && cTemp == N) {
                count += 1;
                continue;
            }

            switch (pipe.dir) {
                case 1:  // 가로
                    if (check(rTemp, cTemp + 1) && house[rTemp][cTemp + 1] != 1) {
                        queue.offer(new Pipe(1, rTemp, cTemp + 1));
                    }

                    if (check(rTemp + 1, cTemp + 1) && (house[rTemp][cTemp + 1] != 1 && house[rTemp + 1][cTemp] != 1 && house[rTemp + 1][cTemp + 1] != 1)) {
                        queue.offer(new Pipe(3, rTemp + 1, cTemp + 1));
                    }

                    break;
                case 2:  // 세로
                    if (check(rTemp + 1, cTemp) && house[rTemp + 1][cTemp] != 1) {
                        queue.offer(new Pipe(2, rTemp + 1, cTemp));
                    }

                    if (check(rTemp + 1, cTemp + 1) && (house[rTemp][cTemp + 1] != 1 && house[rTemp + 1][cTemp] != 1 && house[rTemp + 1][cTemp + 1] != 1)) {
                        queue.offer(new Pipe(3, rTemp + 1, cTemp + 1));
                    }

                    break;
                case 3:  //  대각선
                    if (check(rTemp, cTemp + 1) && house[rTemp][cTemp + 1] != 1) {
                        queue.offer(new Pipe(1, rTemp, cTemp + 1));
                    }

                    if (check(rTemp + 1, cTemp) && house[rTemp + 1][cTemp] != 1) {
                        queue.offer(new Pipe(2, rTemp + 1, cTemp));
                    }

                    if (check(rTemp + 1, cTemp + 1) && (house[rTemp][cTemp + 1] != 1 && house[rTemp + 1][cTemp] != 1 && house[rTemp + 1][cTemp + 1] != 1)) {
                        queue.offer(new Pipe(3, rTemp + 1, cTemp + 1));
                    }

                    break;
            }
        }
    }

    public static boolean check(int r, int c) {
        return (r >= 0 && r <= N) && (c >= 0 && c <= N);
    }

    public static class Pipe {
        int dir;
        int r, c;

        public Pipe(int dir, int r, int c) {
            this.dir = dir;
            this.r = r;
            this.c = c;
        }
    }
}
