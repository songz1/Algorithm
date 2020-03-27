/*
송지은_백준 알고리즘 15803번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_15803 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] location = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                location[i][j] = scanner.nextInt();
            }
        }

        int idx1 = 0, idx2 = 1;
        double[] inclination = new double[3];
        for (int i = 0; i < 3; i++) {
            if (location[idx1][0] - location[idx2][0] == 0) {
                inclination[idx1] = -1;
            } else {
                inclination[idx1] = (double) (location[idx1][1] - location[idx2][1]) / (double) (location[idx1][0] - location[idx2][0]);
            }

            idx1++;
            idx2 = idx2 == 2 ? 0 : idx2 + 1;
        }

        if (inclination[0] == inclination[1] && inclination[1] == inclination[2]) {
            System.out.print("WHERE IS MY CHICKEN?");
        } else {
            System.out.print("WINNER WINNER CHICKEN DINNER!");
        }
    }
}
