/*
송지은_백준 알고리즘 11559번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11559_2 {
    static char[][] puyo = new char[12][6];
    static boolean[][] visited = new boolean[12][6];
    static int N = 12, M = 6;
    static int[] dirN = {1, -1, 0, 0};
    static int[] dirM = {0, 0, 1, -1};
    static boolean check;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            String temp = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                puyo[i][j] = temp.charAt(j);
            }
        }

        int result = 0;

        while (true) {
            check = false;

            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (puyo[i][j] != '.') {
                        BFS(i, j);
                    }
                }
            }

            if (check) {
                down();
                result += 1;
            } else {
                break;
            }
        }

        System.out.print(result);
    }

    public static void BFS(int n, int m) {
        Queue<Pop> pops = new LinkedList<>();
        LinkedList<Pop> count = new LinkedList<>();

        pops.add(new Pop(n, m));
        count.add(new Pop(n, m));
        visited[n][m] = true;

        while (!pops.isEmpty()) {
            Pop pop = pops.poll();
            char color = puyo[n][m];

            for (int i = 0; i < 4; i++) {
                int nTemp = pop.n + dirN[i];
                int mTemp = pop.m + dirM[i];

                if ((nTemp >= 0 && nTemp < N) && (mTemp >= 0 && mTemp < M)) {
                    if (!visited[nTemp][mTemp] && puyo[nTemp][mTemp] == color) {
                        pops.add(new Pop(nTemp, mTemp));
                        count.add(new Pop(nTemp, mTemp));
                        visited[nTemp][mTemp] = true;
                    }
                }
            }
        }

        if (count.size() >= 4) {
            check = true;

            for (int i = 0; i < count.size(); i++) {
                puyo[count.get(i).n][count.get(i).m] = '.';
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

    public static void down() {
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j > 0; j--) {
                if (puyo[j][i] == '.') {
                    for (int k = j; k >= 0; k--) {
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
}
