package A220208;

import java.io.*;
import java.util.*;

public class Main_2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 탑의 개수 입력받기
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		// 탑의 정보 저장할 stack : 레이저 신호는 한 방향이므로 stack을 사용
		// int[] : 탑의 높이, 탑의 번호
		Stack<int[]> stack = new Stack<>();
		
		// 탑의 개수만큼 반복
		for (int i = 1; i <= N; i++) {
			// 탑의 높이 입력받기
			int height = Integer.parseInt(st.nextToken());
			
			// 스택이 빌 때까지 반복
			while(!stack.isEmpty()) {
				
				// top 정보 받아오기
				int[] tower = stack.peek();
				
				// 현재 탑의 높이가 top의 높이보다 높으면
				if (height > tower[0]) {
					// top의 정보 제거
					stack.pop();
				}
				// 현재 탑의 높이가 top의 높이보다 작으면
				else {
					// top의 번호 출력
					sb.append(tower[1] + " ");
					// 현재 탑 정보 stack에 저장
					stack.push(new int[] {height, i});
					break;
				}
			}
			
			// 스택이 비어있으면
			if (stack.isEmpty()) {
				// 0을 출력
				sb.append("0 ");
				// 현재 탑 정보 stack에 저장
				stack.push(new int[] {height, i});
			}
		}

		System.out.println(sb);
		
	}

}
