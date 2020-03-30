package Hyundai_NGV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_02 {
    static Boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        visited = new Boolean[N + 1];

        int temp;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(stringTokenizer.nextToken());
            tree[temp].add(i + 1);
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int p = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());

            Arrays.fill(visited, false);
            count = 0;
            for (int j = 0; j < tree[p].size(); j++) {
                if (tree[p].get(j) != c) {
                    DFS(c);
                    result += count;
                }
            }
            result += 1;
        }

        System.out.print(result);
        System.exit(0);
    }

    public static void DFS(int V) {
        count++;
        visited[V] = true;

        for (int i = 0; i < tree[V].size(); i++) {
            if (!visited[tree[V].get(i)]) {
                DFS(tree[V].get(i));
            }
        }
    }
}
