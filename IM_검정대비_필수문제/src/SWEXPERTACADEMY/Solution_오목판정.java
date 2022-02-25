package SWEXPERTACADEMY;

import java.io.*;
import java.util.*;

public class Solution_오목판정 {
	
	static int T, N;
	static char[][] map;
	
	// 우, 우하, 하, 좌하
	static int[] dr = {0, 1, 1, 1};
	static int[] dc = {1, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/오목판정_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			String result = "NO";
			
			map = new char[N][];
			
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 바둑돌을 찾으면
					if(map[i][j] == 'o') {
						if(check(i, j)) {
							result = "YES";
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}

	private static boolean check(int r, int c) {
		// 4방 탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 경계값 내에서 바둑돌을 찾으면
			if(nr < N && nr >= 0 && nc < N && nc >= 0 && map[nr][nc] == 'o') {
				// 현재 바둑돌 2개
				int cnt = 2;
				while(true) {
					// 같은 방향으로 이동하며
					nr += dr[i];
					nc += dc[i];
					// 바둑돌 발견하면
					if(nr < N && nr >= 0 && nc < N && nc >= 0 && map[nr][nc] == 'o') {
						// 바둑돌 개수 ++
						cnt++;
					}
					// 경계밖이거나 바둑돌이 없으면 다음 방향으로
					else {
						break;
					}
				}
				
				// 바둑돌이 5개 이상 이어져있으면 true 반환
				if(cnt >= 5) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}
