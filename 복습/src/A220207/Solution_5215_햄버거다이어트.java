package A220207;

import java.io.*;
import java.util.*;

public class Solution_5215_햄버거다이어트 {
	
	static boolean[] visited;
	static int[][] ingredient;
	static int N, L, maxT;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			// 재료 개수
			N = sc.nextInt();
			// 제한 칼로리
			L = sc.nextInt();
			
			maxT = 0;
			
			// 선호도 점수, 칼로리 입력
			ingredient = new int[N][2];
			
			// 재료 선택했는지 체크할 boolean 배열
			visited = new boolean[N];
			
			// 재료 정보 입력
			for (int i = 0; i < N; i++) {
				ingredient[i][0] = sc.nextInt();
				ingredient[i][1] = sc.nextInt();
			}
			
			subSet(0);
			
			sb.append("#"+tc+" "+maxT);
		}
		
		System.out.println(sb);

	}
	
	// 재료들의 부분집합 구하기
	static void subSet(int cnt) {
		// 재료를 모두 확인했다면
		if(cnt == N) {
			// 선호도 점수 합
			int sumT = 0;
			// 칼로리 합
			int sumK = 0;
			
			for (int i = 0; i < N; i++) {
				// 선택한 재료들의
				if(visited[i]) {
					// 선호도 점수 합하기
					sumT += ingredient[i][0];
					// 칼로리 합하기
					sumK += ingredient[i][1];
				}
			}
			
			// 칼로리가 제한 칼로리를 넘지 않는 재료 집합의
			if(sumK <= L) {
				// 최대 선호도 점수 출력
				if(sumT > maxT) {
					maxT = sumT;
				}
			}
			return;
		}
		
		// 재료 선택했다고 체크
		visited[cnt] = true;
		// 다음 재료 선택으로
		subSet(cnt+1);
		
		// 재료 선택 안했다고 체크
		visited[cnt] = false;
		// 다음 재료 선택으로
		subSet(cnt+1);
	}

}
