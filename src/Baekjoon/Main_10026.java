/*
송지은_백준 알고리즘 10026번
*/

package Baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {
    static int N;
    static char[][] area;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        area = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String t = bufferedReader.readLine();
            for (int j = 0; j < t.length(); j++) {
                area[i][j] = t.charAt(j);
            }
        }

        int answer1 = BFS();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] == 'R') {
                    area[i][j] = 'G';
                }
            }
        }

        visited = new boolean[N][N];
        int answer2 = BFS();

        System.out.print(answer1 + " " + answer2);
    }

    public static int BFS() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    Queue<Point> queue = new LinkedList<>();
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Point point = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int x = point.x + dx[k];
                            int y = point.y + dy[k];

                            if ((x >= 0 && x < N) && (y >= 0 && y < N) && !visited[x][y] && (area[point.x][point.y] == area[x][y])) {
                                visited[x][y] = true;
                                queue.add(new Point(x, y));
                            }
                        }
                    }

                    count++;
                }
            }
        }

        return count;
    }
}
