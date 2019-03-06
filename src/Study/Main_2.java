/*
송지은_배열 출력하기(재귀)
*/

package Study;

public class Main_2 {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        print(arr, 0);
    }

    public static void print(int[] arr, int i){
        if(arr.length <= i) return;
        System.out.print(arr[i] + " ");
        print(arr, i+1);
    }
}
