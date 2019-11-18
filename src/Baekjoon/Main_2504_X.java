/*
송지은_백준 알고리즘 2504번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_X {
	public static void main(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String t = bufferedReader.readLine();

		int tempInt;
		String tempStr;
		Stack<String> stack = new Stack();
		int count = 0;

		for (int i = 0; i < t.length(); i++) {
			switch (t.substring(count, ++count)) {
				case "(":
					stack.push("(");
					break;
				case ")":
					tempStr = stack.pop();
					if (tempStr == "(") {
						stack.push("2");
					} else if (tempStr == ")" || tempStr == "]" || tempStr == "["){
						System.out.print(0);
						return;
					}
					else{
						tempInt = Integer.parseInt(tempStr) * 2;
						stack.pop();
						if (!stack.isEmpty() && stack.peek() != "(" && stack.peek() != "[") {
							tempInt = tempInt + Integer.parseInt(stack.pop());
						}
						stack.push(Integer.toString(tempInt));
					}
					break;
				case "[":
					stack.push("[");
					break;
				case "]":
					tempStr = stack.pop();
					if (tempStr == "[") {
						stack.push("3");
					} else if (tempStr == ")" || tempStr == "]" || tempStr == "("){
						System.out.print(0);
						return;
					} else {
						tempInt = Integer.parseInt(tempStr) * 3;
						stack.pop();
						if (!stack.isEmpty() && stack.peek() != "(" && stack.peek() != "[") {
							tempInt = tempInt + Integer.parseInt(stack.pop());
						}
						stack.push(Integer.toString(tempInt));
					}
					break;
				default:
					break;
			}
		}

		int result = 0;
		String tempResult;
		while (!stack.isEmpty()){
			tempResult = stack.pop();
			if(tempResult == "(" || tempResult == "[" || tempResult == ")" || tempResult == "]"){
				System.out.print(0);
				return;
			}
			result += Integer.parseInt(tempResult);
		}

		System.out.print(result);
	}
}
