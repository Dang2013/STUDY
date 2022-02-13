package A220203;

import java.io.*;
import java.util.*;


public class Solution_1954_달팽이숫자 {

	// 우 하 좌 상
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[][] snail = new int[N][N];
			
			// 첫 시작 방향
			int dir = 0;
			
			//첫 시작 좌표
			int r = 0;
			int c = 0;
			
			for (int i = 1; i <= N * N; i++) {
				snail[r][c] = i;
				
				// 기본 : 오른쪽으로 이동
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				// 경계를 넘어가거나 입력된 칸을 만나면 방향 전환 -> 우 하 좌 상 -> dr,dc의 인덱스 +1
				if(nr >= N || nr < 0 || nc >= N || nc < 0 || snail[nr][nc] != 0) {
					dir = (dir + 1) % 4;
				}
				
				r = r + dr[dir];
				c = c + dc[dir];
			}
			
			System.out.println("#"+tc);
			for (int i = 0; i < N; i++) {
				System.out.println();
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j]+" ");
				}
			}
		}

	}

}
