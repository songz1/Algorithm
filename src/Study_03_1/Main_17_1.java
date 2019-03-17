/*
송지은_문자 정렬 #2
입력: 문자 배열 char[]
출력: 오름차순으로 배열 정렬하기
배열에는 소문자만 들어있음
 */

package Study_03_1;

import java.util.Arrays;

public class Main_17_1 {
    public static void main(String[] args) {
        char[] str = {'c', 'p', 'r', 'a', 's', 'j', 'i', 'e', 'z', 'o', 'a', 't', 'c', 'c'};
        int[] count = new int[26];

        for (int i = 0; i < str.length; i++)
            ++count[str[i] - 'a'];

        int index = 0;
        for (int i = 0; i < count.length; i++)
            if (count[i] != 0)
                for (int j = 0; j < count[i]; j++)
                    str[index++] = (char) (i + 'a');

        System.out.println(Arrays.toString(str));
    }
}
