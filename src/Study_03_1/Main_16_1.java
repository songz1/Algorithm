/*
송지은_홀수 짝수 분리
입력: 정수 배열 int[]
출력: 짝수들이 배열의 앞부분에, 홀수들은 배열의 뒷부분에 위치
배열에는 0과 1만 들어있음
*/

package Study_03_1;

import java.util.Arrays;

public class Main_16_1 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1};
        int[] count = new int[2];

        for (int i = 0; i < arr.length; i++)
            ++count[arr[i]];

        int index = 0;
        for (int i = 0; i < count.length; i++)
            if (count[i] != 0)
                for (int j = 0; j < count[i]; j++)
                    arr[index++] = i;

        System.out.println(Arrays.toString(arr));
    }
}
