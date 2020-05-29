/*
송지은_백준 알고리즘 5568번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_5568 {
    static HashSet<String> set = new HashSet<>();
    static boolean[] visited;
    static String[] card;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        int k = Integer.parseInt(bufferedReader.readLine());

        visited = new boolean[n];
        card = new String[n];
        for (int i = 0; i < n; i++) {
            card[i] = bufferedReader.readLine();
        }

        combination(k, "");
        System.out.print(set.size());
    }

    public static void combination(int k, String s) {
        if (k == 0) {
            if (!set.contains(s)) {
                set.add(s);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(k - 1, s + card[i]);
                visited[i] = false;
            }
        }
    }
}
