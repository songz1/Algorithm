/*
송지은_백준 알고리즘 9466번

방법 1) 시간초과 ==> 2, 3, 4, ..... , 99999, 100000, 100000 경우 O(n^2)
1. 자기자신 가르키는 경우 -1 저장
2. -1 아닌 항목들 돌면서 DFS로 사이클 생기는지 확인
3. 사이클 생기면 모두 -1 저장
4. 사이클 안생기면 count++
5. 2로 가기

방법 2) 시간초과
1. 한 번 돌때 사이클 생기는 항목 Map에 체크해주기
2. 방문 했으나 Map에 체크가 안되어 있는 항목수 만큼 바로 count++
3. count 하면서 Map은 false로 바꾸기 (다시 검사 못하게)

방법 3) 시간초과 하...
DFS 포기
1. 항목 별로 사이클 존재하는지 확인
2. 사이클 발견되면 사이클 개수 구해서 전체 학생 수에서 빼주기

방법 4) 성공
방법 3에서 visited 초기화 위치 변경
(before) cycle마다 초기화 -> (after) 테스트 케이스마다 초기화
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9466 {
    static int[] student;
    static Boolean[] visited;  // 방문 확인용
    static Boolean[] check;  // 방문 판단용

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            student = new int[n];

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                student[j] = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            }

            int count = n;
            check = new Boolean[n];
            Arrays.fill(check, false);

            visited = new Boolean[n];
            Arrays.fill(visited, false);

            for (int j = 0; j < n; j++) {
                if (!check[j]) {
                    int cnt = cycle(j);

                    if (cnt != 0) {
                        count -= cnt;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static int cycle(int idx) {
        int i, cnt = 0;  // 사이클 개수

        for (i = idx; !visited[i]; i = student[i]) {
            visited[i] = true;
        }

        if (i == idx) {
            for (int j = idx; !check[j]; j = student[j]) {
                cnt++;
                check[j] = true;
            }

            return cnt;
        } else {
            for (int j = idx; j != i; j = student[j]) {
                check[j] = true;
            }

            return 0;
        }
    }
}
