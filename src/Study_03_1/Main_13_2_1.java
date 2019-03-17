/*
송지은_선택 정렬(selection sort)_findMin01
*/

package Study_03_1;

public class Main_13_2_1 {
    public static void main(String[] args) {
        int[] a1 = {17, 14, 11, 19};
        int[] a2 = {-17, -14, -11, -19};
        int minIndex = findMin(a1);
        System.out.println(a1[minIndex]);
        minIndex = findMin(a2);
        System.out.println(a2[minIndex]);
    }

    // 배열 a에서 가장 작은 값의 위치(index)를 리턴한다.
    static int findMin(int[] a) {
        int min = 0;
        for (int i = 1; i < a.length; i++)
            if (a[min] > a[i]) min = i;

        return min;
    }
}
