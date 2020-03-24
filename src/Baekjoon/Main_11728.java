/*
송지은_백준 알고리즘 11728번

방법 1) 시간 초과
배열 두 개에 입력 받아서 앞에서부터 비교하면서 출력

방법 2) 메모리 초과
counting sort

방법 3) 성공
방법 1로 하되, print 말고 StringBuilder로 출력
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11728 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] arrN = new int[N];
        int[] arrM = new int[M];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int idxN = 0, idxM = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            if (idxN == N && idxM == M) {
                break;
            } else if (idxN == N && idxM != M) {
                stringBuilder.append(arrM[idxM++]).append(" ");
            } else if (idxN != N && idxM == M) {
                stringBuilder.append(arrN[idxN++]).append(" ");
            } else {
                if (arrN[idxN] <= arrM[idxM]) {
                    stringBuilder.append(arrN[idxN++]).append(" ");
                } else {
                    stringBuilder.append(arrM[idxM++]).append(" ");
                }
            }
        }

        System.out.print(stringBuilder.toString());
    }
}
