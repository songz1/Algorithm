/*
송지은_백준 알고리즘 11559번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11559 {
    public static int N = 12, M = 6, ans = 0;
    public static char[][] puyo;
    public static ArrayList<Pop> pops;
    public static boolean[][] visited;
    public static int[] dirX = new int[]{0, 0, -1, 1};
    public static int[] dirY = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        puyo = new char[N][M];
        pops = new ArrayList<>();
        visited = new boolean[N][M];
        int count = 0;

        for (int i = 0; i < 12; i++) {
            String temp = bufferedReader.readLine();
            for (int j = 0; j < 6; j++) {
                puyo[i][j] = temp.charAt(j);
            }
        }

        while (true) {
            boolean check = false;
            for (int i = 0; i < visited.length; i++) {
                Arrays.fill(visited[i], false);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && puyo[i][j] != '.') {
                        BFS(i, j);
                    }

                    if (pops.size() >= 4) {
                        check = true;
                        for (int k = 0; k < pops.size(); k++) {
                            puyo[pops.get(k).n][pops.get(k).m] = '.';
                        }
                    }
                    pops.clear();
                }
            }

            downPuyo();

            if (check) {
                count++;
            } else {
                break;
            }
        }

        System.out.print(count);
    }

    public static void BFS(int a, int b) {
        Queue<Pop> queue = new LinkedList<>();

        char color = puyo[a][b];
        visited[a][b] = true;

        Pop pop = new Pop(a, b);
        queue.offer(pop);
        pops.add(pop);

        while (!queue.isEmpty()) {
            pop = queue.poll();
            int n = pop.n;
            int m = pop.m;

            for (int i = 0; i < 4; i++) {
                int dn = n + dirX[i];
                int dm = m + dirY[i];

                if ((dn >= 0 && dn < N) && (dm >= 0 && dm < M)) {
                    if (!visited[dn][dm] && puyo[dn][dm] == color) {
                        pop = new Pop(dn, dm);
                        pops.add(pop);
                        queue.offer(pop);
                        visited[dn][dm] = true;
                    }
                }
            }
        }
    }

    public static void downPuyo() {
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j > 0; j--) {
                if (puyo[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (puyo[k][i] != '.') {
                            puyo[j][i] = puyo[k][i];
                            puyo[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public static class Pop {
        int n, m;

        public Pop(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
