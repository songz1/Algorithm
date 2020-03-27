/*
송지은_백준 알고리즘 1712번

1. 가변 비용 >= 노트북 가격 -> 손익분기점 X

방법 1) 틀림
2. 반복문으로 A+(B*판매량) < C*판매량 지점 찾기

방법 2) 정답
2. 위의 부등식 풀면 -> 판매량 > A/(C-B)
3. A/(C-B)+1 바로 출력
*/

package Baekjoon;

import java.util.Scanner;

public class Main_1712 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        if (B >= C) {
            System.out.print(-1);
            return;
        }

        System.out.print(A / (C - B) + 1);
    }
}
