/*
송지은_2차 배열 출력(재귀)
*/

package Study;

public class Main_11 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print1(a);
        System.out.println();
        print2(a, 0, 0);
    }

    static void print1(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a[i].length; ++j) System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    static void print2(int[][] a, int i, int j) {
        if (i >= a.length) return;
        if (j >= a[i].length) {
            System.out.println();
            print2(a, ++i, 0);
        } else {
            System.out.print(a[i][j] + " ");
            print2(a, i, ++j);
        }
    }
}

