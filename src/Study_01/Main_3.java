/*
송지은_1부터 n까지의 합(재귀)
*/

package Study_01;

public class Main_3 {
    public static void main(String[] args) {
        for (int i = 3; i <= 10; i++)
            System.out.printf("%d %d\n", i, sum(i));
    }

    public static int sum(int n) {
        if (n <= 1)
            return 1;
        return n + sum(n - 1);
    }
}
