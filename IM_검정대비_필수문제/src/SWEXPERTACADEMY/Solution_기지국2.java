package SWEXPERTACADEMY;

import java.io.*;
import java.util.*;

public class Solution_기지국2 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());	// 배열 크기
			
			char[][] map = new char[N][];
			
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int nr, nc;
			
			//	기지국 찾기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					if(map[r][c] >= 'A' && map[r][c] <= 'C') {	// 기지국이면
						//	기지국 주변 4방 탐색	(4방향을 1칸, 2칸, 3칸 넓혀서 탐색)
						for (int d = 0; d < 4; d++) {
							//	기지국의 유형만큼 칸을 탐색
							for (int k = 1; k <= (map[r][c] - 'A') + 1; k++) {
								nr = r + k * dr[d];
								nc = c + k * dc[d];
								
								if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 'H') {
									map[nr][nc] = 'X';
								}
							}
						}
						
					}
				}
			}
			
			int hCnt = 0;
			
			// 커버되지 않는 집의 수 세기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c] == 'H') {
						hCnt++;
					}
				}
			}
			
			System.out.println("#"+tc+" "+hCnt);
			
		}
		
	}

}
