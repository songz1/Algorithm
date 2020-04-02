/*
송지은_백준 알고리즘 16936번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16936 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bufferedReader.readLine());

        ArrayList<Check> list = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(stringTokenizer.nextToken());
            Check check = new Check(num);

            list.add(check);
        }

        Comparator<Check> comparator = new Comparator<Check>() {
            @Override
            public int compare(Check o1, Check o2) {
                if (o1.getThree() == o2.getThree()) {
                    return (int)(o1.getTwo() - o2.getTwo());
                }

                return (int)(o2.getThree() - o1.getThree());
            }
        };

        Collections.sort(list, comparator);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).num + " ");
        }
    }

    public static class Check {
        long num;
        long three;
        long two;

        public Check(long num) {
            this.num = num;
            this.three = cal3(num);
            this.two = cal2(num);
        }

        public static long cal3(long num) {
            long three = 0;

            while (num > 0) {
                if (num % 3 == 0) {
                    three++;
                    num /= 3;
                } else {
                    break;
                }
            }

            return three;
        }

        public static long cal2(long num) {
            long two = 0;

            while (num > 0) {
                if (num % 2 == 0) {
                    two++;
                    num /= 2;
                } else {
                    break;
                }
            }

            return two;
        }

        public long getThree() {
            return three;
        }

        public long getTwo() {
            return two;
        }
    }
}
