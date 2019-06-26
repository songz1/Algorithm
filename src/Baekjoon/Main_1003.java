/*
송지은_백준 알고리즘 1003번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_1003 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		int[] n = new int[t];
		for(int i=0; i<t; i++){
			n[i] = input.nextInt();
		}

		int[][] fibonacci = new int[41][2];
		fibonacci[0][0]=1;
		fibonacci[1][1]=1;

		for(int i=2; i<41; i++){
			for(int j=0; j<2; j++){
				fibonacci[i][j] = fibonacci[i-2][j]+fibonacci[i-1][j];
			}
		}

		for(int i=0; i<t; i++){
			System.out.println(fibonacci[n[i]][0]+" "+fibonacci[n[i]][1]);
		}

		input.close();
	}
}
