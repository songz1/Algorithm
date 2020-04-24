/*
송지은_프로그래머스 알고리즘 네트워크
*/

package Programmers;

import java.util.Arrays;

public class Solution_네트워크 {
    public static void main(String[] args) {

    }

    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public void DFS(int num, int[][] computers) {
        visited[num] = true;

        for (int i = 0; i < computers[num].length; i++) {
            if (i != num && computers[num][i] == 1 && !visited[i]) {
                DFS(i, computers);
            }
        }
    }
}
