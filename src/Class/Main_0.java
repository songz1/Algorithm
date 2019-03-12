/*
송지은_홀수 짝수 분리

입력: 정수 배열 int[]
출력: 짝수들이 배열의 앞부분에, 홀수들은 배열의 뒷부분에 위치해야 함
짝수들 순서, 홀수들 순서는 무관
*/

package Class;

import java.util.Scanner;

public class Main_0 {
    public static void main(String args){
        Scanner input = new Scanner(System.in);

        int[] arr = new int[10];
        for(int i=0; i<arr.length; i++)
            arr[i] = input.nextInt();




    }

    /*
    while(start<end){
    while(start 짝수) start++
    while(end 홀수) end--
    swap(start, end)
    }


    퀵소트 파티션
     */
    static void sort(int[] arr, int start, int end){
        if(start < end) {
            int middle = (start + end) / 2;
            sort(arr, start, middle);
            sort(arr, middle + 1, end);

        }



    }
}
