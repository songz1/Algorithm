/*
송지은_버블 정렬(bubble sort)
*/

package Study;

import java.util.Arrays;

public class Main_14 {
    public static void main(String[] args) {
        int[] a = {17, 14, 11, 19, 13, 15, 20, 12, 16, 18};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    // 배열 a에서 i 위치와 j 위치의 값을 서로 바꾼다
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // bubble sort
    static void bubbleSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            boolean finish = true;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    finish = false;
                }
            }
            if (finish == true) break;
        }
    }
}

