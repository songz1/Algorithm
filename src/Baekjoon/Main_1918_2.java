/*
송지은_백준 알고리즘 1918번

1. 입력값 알파벳인 경우, 결과 문자열에 바로 붙이기
2. 입력값 * / 인 경우, Stack의 top이 * / 아닐때까지 pop 하면서 결과 문자열에 붙인 후 입력값 push
3. 입력값 + - 인 경우, Stack의 top이 * / 일때까지 pop 하면서 결과 문자열에 붙인 후 입력값 push
4. 입력값 ( 인 경우, push
5. 입력값 ) 인 경우, Stack의 top이 ( 일때까지 pop 하면서 결과 문자열에 붙인 후 ( 은 pop
6. Stack이 빌때까지 pop 해서 결과 문자열에 붙이기
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1918_2 {
    static String result = "";
    static Stack<Character> stack = new Stack();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        for (char c : str.toCharArray()) {
            if (c == '*' || c == '/' || c == '+' || c == '-' || c == '(' || c == ')') {
                check(c);
            } else {
                result += c;
            }
        }

        while (!stack.empty()) {
            result += stack.pop();
        }

        System.out.print(result);
    }

    public static void check(char c) {
        switch (c) {
            case '*':
            case '/':
                while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    result += stack.pop();
                }
            case '(':
                stack.push(c);

                break;
            case '+':
            case '-':
                while (!stack.empty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.push(c);

                break;
            case ')':
                while (!stack.empty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();

                break;
        }
    }
}
