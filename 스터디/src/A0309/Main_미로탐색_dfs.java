package A0309;

import java.io.*;
import java.util.*;

public class Main_미로탐색_dfs {
	
	// dfs로 풀어서 예제 입/출력은 나왔지만 제출했을 때 시간초과에 걸렸다. -> bfs 풀이로 전환

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int N, M, min;
	static int[][] maze;
	static boolean[][] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		maze = new int[N][M];
		isSelected = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		
		min = Integer.MAX_VALUE;
		isSelected[0][0] = true;
		dfs(0, 0, 1);
		
		System.out.println(min);
	}

	private static void dfs(int r, int c, int cnt) {
		if(r == (N - 1) && c == (M - 1)) {
			if(cnt < min) {
				min = cnt;
			}
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < N && nr >= 0 && nc < M && nc >= 0 && !isSelected[nr][nc] && maze[nr][nc] == 1) {
				isSelected[nr][nc] = true;
				dfs(nr, nc, cnt+1);
				isSelected[nr][nc] = false;
			}
		}
	}

}
