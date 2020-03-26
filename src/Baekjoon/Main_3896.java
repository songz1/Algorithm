/*
송지은_백준 알고리즘 3896번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3896 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        Boolean[] prime = new Boolean[1299710];
        Arrays.fill(prime, false);

        for (int i = 2; i < 1299710; i++) {
            for (int j = i; i * j > 2 && i * j < 1299710; j++) {
                prime[i * j] = true;
            }
        }

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(bufferedReader.readLine());
            int idxL=k, idxR=k;

            // k보다 작은 소수
            while (idxL > 0 && prime[idxL]) {
                idxL--;
            }

            // k보다 큰 소수
            while (idxR < 1299710 && prime[idxR]) {
                idxR++;
            }

            System.out.println(idxR-idxL);
        }
    }
}
