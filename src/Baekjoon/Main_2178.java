/*
송지은_백준 알고리즘 2178번
*/

package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2178 {
    static int n, m;
    static int[][] map, check;
    static boolean[][] visit;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = Integer.MAX_VALUE;

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        visit = new boolean[n][m];
        map = new int[n][m];
        check = new int[n][m];

        String[] word;
        for (int i = 0; i < n; i++) {
            word = input.next().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(word[j]);
                check[i][j] = max;
            }
        }

        check[0][0] = 1;
        BFS(0, 0);
        System.out.println(check[n - 1][m - 1]);
    }

    public static void BFS(int x, int y) {
        Queue<Pair> q = new <Pair>LinkedList();

        q.offer(new Pair(x, y));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1 && visit[nx][ny] == false) {
                        q.offer(new Pair(nx, ny));
                        visit[nx][ny] = true;
                        check[nx][ny] = Math.min(check[nx][ny], check[p.x][p.y] + 1);
                    }
                }
            }
        }
    }
}