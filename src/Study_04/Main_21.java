/*
송지은_선택 알고리즘(select algorithm)
*/

package Study_04;

import java.util.Arrays;
import java.util.Random;

public class Main_21 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i) a[i] = random.nextInt(20);
        System.out.println(Arrays.toString(a));
        System.out.printf("1 번째 작은 값 = %d\n", select(a, 0, a.length - 1, 1));
        System.out.printf("2 번째 작은 값 = %d\n", select(a, 0, a.length - 1, 2));
        System.out.printf("3 번째 작은 값 = %d\n", select(a, 0, a.length - 1, 3));
        System.out.printf("4 번째 작은 값 = %d\n", select(a, 0, a.length - 1, 4));
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int partition(int[] a, int start, int end) {
        int pivot = a[end];  // 기준값
        int i = start - 1;  // i는 1구역의 끝지점

        for (int j = start; j < end; j++)  // j는 3구역의 시작 지점
            if (a[j] < pivot)  // a[j] 값이 1구역에 속하면
                swap(a, ++i, j);  // a[j] 값을 1구역의 끝에 추가한다. 1구역 크기 1증가.
        swap(a, i + 1, end);  // 기준값인 a[end] 원소와 2구역의 시작 원소를 교환한다.

        return i + 1;  // 기준값 위치 리턴
    }

    // a 배열의 start~end 에서 nth 번째 작은 값을 리턴한다.
    static int select(int[] a, int start, int end, int nth) {
        if (start >= end) return a[start];  // 찾을 배열의 크기가 1 이면 리턴

        int middle = partition(a, start, end);  // 배열 나누기
        int middle_nth = middle - start + 1;  // middle 위치의 값이 start~end 에서 middle_nth 번째 작은 값

        if (middle_nth == nth) return a[middle];  // 찾았으면 리턴
        else if (middle_nth > nth) return select(a, start, middle - 1, nth);  // 앞 부분에서 찾는다.
        else return select(a, middle + 1, end, nth - middle_nth);  // 뒷 부분에서 찾는다.
    }
}
