package SWEXPERTACADEMY;

import java.io.*;
import java.util.*;

public class Solution_저수지의물의총깊이구하기 {

	static int T, N, max;
	static char[][] map;
	
	// 8방 탐색 - 상 우상 우 우하 하 좌하 좌 좌상
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/저수지_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			max = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 'W') {
						find(i, j);
					}
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}

	private static void find(int i, int j) {
		int depth = 0;
		
		for (int d = 0; d < 8; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr < N && nr >= 0 && nc < N && nc >= 0) {
				depth++;
				if(map[nr][nc] == 'G') {
					depth--;
				}
			}
		}
		
		if(depth <= 0) {
			depth = 1;
		}
		
		max = Math.max(max, depth);
	}

}
