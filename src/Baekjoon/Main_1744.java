/*
송지은_백준 알고리즘 1744번

배열에 입력 후 정렬하기
0. 작은 수부터 음수끼리 곱하기, 큰 수부터 양수끼리 곱하기
1. -1의 경우 -> 음수 or 0이랑 무조건 곱하기
2. 1의 경우 -> 무조건 더하기만
3. 0의 경우 -> 음수 중에 남은 값이 있다면 곱하기
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1744 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(arr);

        Boolean[] visited = new Boolean[N];
        Arrays.fill(visited, false);

        // 음수
        int result = 0;
        for (int i = 0; i < N - 1; i++) {
            if (!visited[i] && arr[i] < 0 && arr[i + 1] <= 0) {
                result += arr[i] * arr[i + 1];
                visited[i] = true;
                visited[i + 1] = true;
                i++;
            } else {
                break;
            }
        }

        // 양수 + 방문하지 않은 수들
        for (int i = N - 1; i >= 0; i--) {
            if (!visited[i] && i > 0 && arr[i] > 1 && arr[i - 1] > 1) {
                result += arr[i] * arr[i - 1];
                visited[i] = true;
                visited[i - 1] = true;
                i--;
            } else if (!visited[i]) {
                result += arr[i];
                visited[i] = true;
            } else {
                break;
            }
        }

        System.out.print(result);
    }
}
