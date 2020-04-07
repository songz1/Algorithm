/*
송지은_백준 알고리즘 10819번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819 {
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        perm(arr, new int[N], new boolean[N], 0, N, N);

        System.out.print(max);
    }

    public static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int k) {
        if (depth == k) {
            max = Math.max(sum(output), max);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];

                perm(arr, output, visited, depth + 1, n, k);

                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length-1; i++) {
            sum += Math.abs(arr[i]-arr[i+1]);
        }
        return sum;
    }
}
