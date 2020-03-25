/*
송지은_백준 알고리즘 1260번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260_2 {
    static ArrayList<Integer>[] list;
    static Boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int V = Integer.parseInt(stringTokenizer.nextToken());

        visited = new Boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int V1, V2;
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            V1 = Integer.parseInt(stringTokenizer.nextToken());
            V2 = Integer.parseInt(stringTokenizer.nextToken());

            list[V1].add(V2);
            list[V2].add(V1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        Arrays.fill(visited, false);
        DFS(V);

        System.out.println();
        Arrays.fill(visited, false);
        BFS(V);
    }

    public static void DFS(int V) {
        System.out.print(V + " ");

        visited[V] = true;

        for (int i = 0; i < list[V].size(); i++) {
            if (!visited[list[V].get(i)]) {
                DFS(list[V].get(i));
            }
        }
    }

    public static void BFS(int V) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            V = queue.poll();
            System.out.print(V + " ");

            for (int i = 0; i < list[V].size(); i++) {
                if (!visited[list[V].get(i)]) {
                    queue.add(list[V].get(i));
                    visited[list[V].get(i)] = true;
                }
            }
        }
    }
}
