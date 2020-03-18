/*
송지은_백준 알고리즘 1063번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        String king = stringTokenizer.nextToken();
        String stone = stringTokenizer.nextToken();
        int N = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < N; i++) {
            String move = bufferedReader.readLine();
            char ctemp;
            int itemp;
            String tking;

            switch (move) {
                case "R":
                    if (king.charAt(0) == 'H') {
                        break;
                    }

                    ctemp = (char) ((int) king.charAt(0) + 1);
                    tking = "" + ctemp + king.charAt(1);

                    if (tking.equals(stone) && stone.charAt(0) == 'H') {
                        break;
                    } else if (tking.equals(stone)) {
                        ctemp = (char) ((int) stone.charAt(0) + 1);
                        stone = "" + ctemp + stone.charAt(1);
                    }

                    king = tking;

                    break;
                case "L":
                    if (king.charAt(0) == 'A') {
                        break;
                    }

                    ctemp = (char) ((int) king.charAt(0) - 1);
                    tking = "" + ctemp + king.charAt(1);

                    if (tking.equals(stone) && stone.charAt(0) == 'A') {
                        break;
                    } else if (tking.equals(stone)) {
                        ctemp = (char) ((int) stone.charAt(0) - 1);
                        stone = "" + ctemp + stone.charAt(1);
                    }

                    king = tking;

                    break;
                case "B":
                    if (king.charAt(1) == '1') {
                        break;
                    }

                    itemp = Integer.parseInt(king.substring(1)) - 1;
                    tking = "" + king.charAt(0) + itemp;

                    if (tking.equals(stone) && stone.charAt(1) == '1') {
                        break;
                    } else if (tking.equals(stone)) {
                        itemp = Integer.parseInt(stone.substring(1)) - 1;
                        stone = "" + stone.charAt(0) + itemp;
                    }

                    king = tking;

                    break;
                case "T":
                    if (king.charAt(1) == '8') {
                        break;
                    }

                    itemp = Integer.parseInt(king.substring(1)) + 1;
                    tking = "" + king.charAt(0) + itemp;

                    if (tking.equals(stone) && stone.charAt(1) == '8') {
                        break;
                    } else if (tking.equals(stone)) {
                        itemp = Integer.parseInt(stone.substring(1)) + 1;
                        stone = "" + stone.charAt(0) + itemp;
                    }

                    king = tking;

                    break;
                case "RT":
                    if (king.charAt(0) == 'H' || king.charAt(1) == '8') {
                        break;
                    }

                    ctemp = (char) ((int) king.charAt(0) + 1);
                    itemp = Integer.parseInt(king.substring(1)) + 1;
                    tking = "" + ctemp + itemp;

                    if (tking.equals(stone) && (stone.charAt(0) == 'H' || stone.charAt(1) == '8')) {
                        break;
                    } else if (tking.equals(stone) && stone.charAt(0) != 'H' && stone.charAt(1) != '8') {
                        ctemp = (char) ((int) stone.charAt(0) + 1);
                        itemp = Integer.parseInt(stone.substring(1)) + 1;
                        stone = "" + ctemp + itemp;
                    }

                    king = tking;

                    break;
                case "LT":
                    if (king.charAt(0) == 'A' || king.charAt(1) == '8') {
                        break;
                    }

                    ctemp = (char) ((int) king.charAt(0) - 1);
                    itemp = Integer.parseInt(king.substring(1)) + 1;
                    tking = "" + ctemp + itemp;

                    if (tking.equals(stone) && (stone.charAt(0) == 'A' || stone.charAt(1) == '8')) {
                        break;
                    } else if (tking.equals(stone) && stone.charAt(0) != 'A' && stone.charAt(1) != '8') {
                        ctemp = (char) ((int) stone.charAt(0) - 1);
                        itemp = Integer.parseInt(stone.substring(1)) + 1;
                        stone = "" + ctemp + itemp;
                    }

                    king = tking;

                    break;
                case "RB":
                    if (king.charAt(0) == 'H' || king.charAt(1) == '1') {
                        break;
                    }

                    ctemp = (char) ((int) king.charAt(0) + 1);
                    itemp = Integer.parseInt(king.substring(1)) - 1;
                    tking = "" + ctemp + itemp;

                    if (tking.equals(stone) && (stone.charAt(0) == 'H' || stone.charAt(1) == '1')) {
                        break;
                    } else if (tking.equals(stone) && stone.charAt(0) != 'H' && stone.charAt(1) != '1') {
                        ctemp = (char) ((int) stone.charAt(0) + 1);
                        itemp = Integer.parseInt(stone.substring(1)) - 1;
                        stone = "" + ctemp + itemp;
                    }

                    king = tking;

                    break;
                case "LB":
                    if (king.charAt(0) == 'A' || king.charAt(1) == '1') {
                        break;
                    }

                    ctemp = (char) ((int) king.charAt(0) - 1);
                    itemp = Integer.parseInt(king.substring(1)) - 1;
                    tking = "" + ctemp + itemp;

                    if (tking.equals(stone) && (stone.charAt(0) == 'A' || stone.charAt(1) == '1')) {
                        break;
                    } else if (tking.equals(stone) && stone.charAt(0) != 'A' && stone.charAt(1) != '1') {
                        ctemp = (char) ((int) stone.charAt(0) - 1);
                        itemp = Integer.parseInt(stone.substring(1)) - 1;
                        stone = "" + ctemp + itemp;
                    }

                    king = tking;

                    break;
            }
        }

        System.out.println(king);
        System.out.println(stone);
    }
}