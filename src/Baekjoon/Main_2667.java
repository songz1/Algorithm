/*
송지은_백준 알고리즘 2667번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main_2667 {
    static int N;
    static int[][] map;
    static int x, y;
    static int area = 0;
    static ArrayList<Integer> house = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        map = new int[N][N];

        String temp;
        for (int i = 0; i < N; i++) {
            temp = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        while (check()) {
            house.add(BFS(x, y));
        }

        Collections.sort(house);

        System.out.println(area);
        for (int i = 0; i < house.size(); i++) {
            System.out.println(house.get(i));
        }
    }

    public static int BFS(int x, int y) {
        area++;
        int cnt = 0;

        Queue<XY> queue = new ArrayDeque<>();

        queue.add(new XY(x, y));
        map[x][y] = 0;

        while (!queue.isEmpty()) {
            cnt++;

            XY xy = queue.poll();
            x = xy.getX();
            y = xy.getY();

            // 위
            if (x > 0 && map[x - 1][y] == 1) {
                queue.add(new XY(x - 1, y));
                map[x - 1][y] = 0;
            }

            //아래
            if (x < N - 1 && map[x + 1][y] == 1) {
                queue.add(new XY(x + 1, y));
                map[x + 1][y] = 0;
            }

            //왼쪽
            if (y > 0 && map[x][y - 1] == 1) {
                queue.add(new XY(x, y - 1));
                map[x][y - 1] = 0;
            }

            //오른쪽
            if (y < N - 1 && map[x][y + 1] == 1) {
                queue.add(new XY(x, y + 1));
                map[x][y + 1] = 0;
            }
        }

        return cnt;
    }

    public static Boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    x = i;
                    y = j;

                    return true;
                }
            }
        }

        return false;
    }

    public static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return this.x;
        }

        int getY() {
            return this.y;
        }
    }
}
