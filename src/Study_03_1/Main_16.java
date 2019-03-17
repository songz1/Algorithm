/*
송지은_홀수 짝수 분리
입력: 정수 배열 int[]
출력: 짝수들이 배열의 앞부분에, 홀수들은 배열의 뒷부분에 위치 (순서는 무관)
*/

package Study_03_1;

import java.util.Arrays;

public class Main_16 {
    public static void main(String[] args) {
        int[] arr = {1, 21, 92, 18, 109, 26, 11, 298, 99, 45};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sort(int[] arr, int start, int end) {
        while (start < end) {
            while (arr[start] % 2 == 0) ++start;
            while (arr[end] % 2 == 1) --end;
            if (start < end) {
                swap(arr, start, end);
                ++start;
                --end;
            }
        }
    }
}
