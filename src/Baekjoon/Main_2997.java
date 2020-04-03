/*
송지은_백준 알고리즘 2997번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2997 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(arr);

        int a, b;
        a = arr[1] - arr[0];
        b = arr[2] - arr[1];

        if (a == b) {
            System.out.print(arr[2] + a);
        } else if (a > b) {
            System.out.print(arr[0] + b);
        } else {
            System.out.print(arr[1] + a);
        }
    }
}
