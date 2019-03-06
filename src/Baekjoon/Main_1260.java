/*
송지은_백준 알고리즘 1260번
*/

package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260 {
    static boolean visit[];
    static boolean visit2[];
    static int[][] a;
    static int n;

    public static void main(String[] args) {
        // write your code here

        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int m = input.nextInt();
        int v = input.nextInt();

        a = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        visit2 = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int n1 = input.nextInt();
            int n2 = input.nextInt();

            a[n1][n2] = 1;
            a[n2][n1] = 1;
        }

        // DFS
        for (int j = 1; j < n + 1; j++) {
            if (a[v][j] == 1 && !visit[v]) {
                System.out.print(v + " ");
                visit[v] = true;
                DFS(v, j);
            }
        }

        System.out.println();
        // BFS
        BFS(v);
    }

    public static void DFS(int i, int j) {
        visit[j] = true;

        System.out.print(j + " ");
        for (int k = 1; k < n + 1; k++) {
            if (a[j][k] == 1 && !visit[k]) {
                DFS(j, k);
            }
        }
    }

    public static void BFS(int i) {
        Queue<Integer> q = new <Integer>LinkedList();

        q.offer(i);
        visit2[i] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");

            for (int j = 1; j < n + 1; j++) {
                if (a[temp][j] == 1 && !visit2[j]) {
                    q.offer(j);
                    visit2[j] = true;
                }
            }
        }
    }
}

