/*
송지은_백준 알고리즘 2504번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504 {
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
					if (stack.isEmpty() || stack.peek() == "]" || stack.peek() == "[" || stack.peek() == ")") {
						System.out.println("0");
						return;
					}

					tempStr = stack.pop();
					if (tempStr == "(") {
						if (!stack.isEmpty() && stack.peek() != "(" && stack.peek() != "[") {
							tempInt = Integer.parseInt(stack.pop()) + 2;
							stack.push(Integer.toString(tempInt));
						} else {
							stack.push("2");
						}
					} else {
						tempInt = Integer.parseInt(tempStr) * 2;
						if (!stack.isEmpty() && stack.peek() == "(") {
							stack.pop();
							if (!stack.isEmpty() && stack.peek() != "(" && stack.peek() != "[") {
								tempInt = Integer.parseInt(stack.pop()) + tempInt;
							}
							stack.push(Integer.toString(tempInt));
						}
					}

					break;
				case "[":
					stack.push("[");
					break;
				case "]":
					if (stack.isEmpty() || stack.peek() == ")" || stack.peek() == "(" || stack.peek() == "]") {
						System.out.println("0");
						return;
					}

					tempStr = stack.pop();
					if (tempStr == "[") {
						if (!stack.isEmpty() && stack.peek() != "(" && stack.peek() != "[") {
							tempInt = Integer.parseInt(stack.pop()) + 3;
							stack.push(Integer.toString(tempInt));
						} else {
							stack.push("3");
						}
					} else {
						tempInt = Integer.parseInt(tempStr) * 3;
						if (!stack.isEmpty() && stack.peek() == "[") {
							stack.pop();
							if (!stack.isEmpty() && stack.peek() != "(" && stack.peek() != "[") {
								tempInt = Integer.parseInt(stack.pop()) + tempInt;
							}
							stack.push(Integer.toString(tempInt));
						}
					}

					break;
				default:
					break;
			}
		}

		int result = 0;
		String tempResult;
		while (!stack.isEmpty()) {
			tempResult = stack.pop();
			if (tempResult == "(" || tempResult == "[" || tempResult == ")" || tempResult == "]") {
				System.out.println("0");
				return;
			}
			result += Integer.parseInt(tempResult);
		}

		System.out.println(result);
	}
}
