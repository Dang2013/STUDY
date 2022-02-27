package BACKJOON;

import java.io.*;
import java.util.*;

public class Main_자리배정 {

	// 시계 방향 - 상, 우, 하, 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		if(K > N*M) {
			System.out.println("0");
			return;
		}
		
		int[][] map = new int[N][M];
		
		// 시작 좌표
		int r = N-1;
		int c = 0;
		
		// 방향 - 0 : 상 / 1 : 우 / 2 : 하 / 3 : 좌
		int dir = 0;
		
		int nums = 0;
		
		while(++nums <= N * M) {
			map[r][c] = nums;
			int nr = r + dr[dir%4];
			int nc = c + dc[dir%4];
			
			// 이동할 방향이 경계 안이고 빈 칸일 경우
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
				// 이동
				r = nr;
				c = nc;
			}
			// 경계를 벗어나거나 빈칸이 아닐 경우
			else {
				// 방향 전환 후 이동
				dir++;
				r += dr[dir%4];
				c += dc[dir%4];
			}
		}
		
		// 답은 ( a b ) 형태로 출력
		// a = column값 + 1
		int a = 0;
		// b = R - row값
		int b = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == K) {
					a = j + 1;
					b = (N - i);
				}
			}
		}
		
		System.out.println(a + " " + b);
	}

}
