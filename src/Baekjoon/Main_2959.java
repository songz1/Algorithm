/*
송지은_백준 알고리즘 2959번
*/

package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2959 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[4];

		for(int i=0; i<4; i++){
			arr[i] = scanner.nextInt();
		}

		Arrays.sort(arr);

		System.out.print(arr[0]*arr[2]);
	}
}
