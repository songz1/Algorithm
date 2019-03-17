/*
송지은_문자 정렬 #1
입력: 문자 배열 char[]
출력: 오름차순으로 배열 정렬하기
 */

package Study_03_1;

import java.util.Arrays;

public class Main_17 {
    public static void main(String[] args) {
        char[] str = {'P', 't', 'C', 'c', 'S', 'o', 'z', 'U', 'c', 'p', 'F', 'h', 'G', 'A', 'A'};
        int[] counta = new int[26];
        int[] countA = new int[26];

        for (int i = 0; i < str.length; i++)
            if (str[i] - 'a' < 0) ++countA[str[i] - 'A'];
            else ++counta[str[i] - 'a'];

        int index = 0;
        for (int i = 0; i < countA.length; i++) {
            if (countA[i] != 0)
                for (int j = 0; j < countA[i]; j++)
                    str[index++] = (char) (i + 'A');
            if (counta[i] != 0)
                for (int j = 0; j < counta[i]; j++)
                    str[index++] = (char) (i + 'a');
        }

        System.out.println(Arrays.toString(str));
    }
}
