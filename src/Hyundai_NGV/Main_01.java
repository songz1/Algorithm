package Hyundai_NGV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        String num = bufferedReader.readLine();

        int max = Integer.MIN_VALUE;
        long result = Long.MIN_VALUE;
        for (int i = 0; i <= N - K; i++) {
            if (max < num.charAt(i) - '0') {
                max = num.charAt(i) - '0';
                result = Long.parseLong(num.substring(i, i + K));
            } else if (max == num.charAt(i) - '0') {
                long temp = Long.parseLong(num.substring(i, i + K));
                result = result >= temp ? result : temp;
            }
        }

        System.out.print(result);
        System.exit(0);
    }
}
