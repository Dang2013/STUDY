package A220204;

import java.io.*;
import java.util.*;

public class Solution_2001_파리퇴치 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			// 파리 맵 크기
			int N = sc.nextInt();
			// 파리채 크기
			int M = sc.nextInt();
			
			// 파리 맵 정보 배열
			int[][] map = new int[N][N];
			
			// 파리 맵 정보 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// 테스트케이스의 결과값
			int max = 0;
			
			// 파리채의 크기가 맵의 크기를 넘지 않도록
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <= N-M; j++) {
					// 죽인 파리 수 초기화
					int sum = 0;
					// 파리채 크기 만큼
					for (int x = i; x <= (i + M-1); x++) {
						for (int y = j; y <= (j + M-1); y++) {
							// 죽인 파리수 더하기
							sum += map[x][y];
						}
					}
					// 죽인 파리 수의 합 중 최대값 도출
					if(sum > max) max = sum;
				}
			}
			
			// 출력
			sb.append("#"+tc+" "+max+"\n");
		}
		
		System.out.println(sb);
		
	}
}
