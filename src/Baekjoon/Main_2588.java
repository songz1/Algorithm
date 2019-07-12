/*
송지은_백준 알고리즘 2588번
*/

package Baekjoon;

import java.util.Scanner;

public class Main_2588 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String n = input.nextLine();
		String m = input.nextLine();

		System.out.println(((int) m.charAt(2) - 48) * Integer.parseInt(n));
		System.out.println(((int) m.charAt(1) - 48) * Integer.parseInt(n));
		System.out.println(((int) m.charAt(0) - 48) * Integer.parseInt(n));
		System.out.println(Integer.parseInt(n) * Integer.parseInt(m));
	}
}
