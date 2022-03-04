package A220209;

import java.io.*;
import java.util.*;

public class Solution_1223_계산기2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1223.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			
			int N = sc.nextInt();
			
			String input = sc.next();
			
			// 후위표기식 저장할 StringBuilder
			StringBuilder sb = new StringBuilder();
			// 연산자 저장할 Stack
			Stack<Character> s = new Stack<>();
			
			// 1. 후위표기식으로 만들기
			for (int i = 0; i < N; i++) {
				char c = input.charAt(i);
				
				// 덧셈일 경우
				if(c == '+') {
					// 스택에 저장된 모든 연산자를 꺼내 후위표기식에 저장
					while(!s.isEmpty()) {
						sb.append(s.pop());
					}
					// 자신을 스택에 입력
					s.push(c);
				}
				// 곱셈일 경우
				else if(c == '*') {
					// 스택의 제일 위가 *이라면 pop하여 후위 표기식에 저장
					while(!s.isEmpty() && s.peek() == '*') {
						sb.append(s.pop());
					}
					// 자신을 스택에 입력
					s.push(c);
				}
				// 숫자일 경우
				else {
					sb.append(c);
				}
			}
			// 스택에 남아있는 연산자들 모두 꺼내 후위표기식에 추가
			while(!s.isEmpty()) {
				sb.append(s.pop());
			}
			
			// 2. 후위 표기식 계산
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < N; i++) {
				char c = sb.charAt(i);
				
				// 덧셈일 경우
				if(c == '+') {
					// 더하여 스택에 저장
					int op1 = stack.pop();
					int op2 = stack.pop();
					stack.push(op1 + op2);
				}
				// 곱셈일 경우
				else if(c == '*') {
					// 곱하여 스택에 저장
					int op1 = stack.pop();
					int op2 = stack.pop();
					stack.push(op1 * op2);
				}
				// 숫자일 경우
				else {
					// 문자형을 숫자로 변경하여 스택에 저장
					stack.push(c - '0');
				}
			}
			System.out.println("#"+tc+" "+stack.pop());
		}
	}

}
