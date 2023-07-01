package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500_테트로미노 {
	static int N, M, ans;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MIN_VALUE;
		
		boolean[][] visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, map[i][j], 1, visited);
				visited[i][j] = false;
				check(i, j);
			}
		}
		
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int sum, int cnt, boolean[][] visited) {
		if(cnt == 4) {
			ans = Integer.max(sum, ans);
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
				continue;
			}
			
			visited[nr][nc] = true;
			dfs(nr, nc, sum + map[nr][nc], cnt+1, visited);
			visited[nr][nc] = false;
		}
	}
	
	private static void check(int r, int c) {
		// ㅏ
		if(r < N - 2 && c < M - 1) {
			ans = Integer.max(ans, map[r][c] + map[r+1][c] + map[r+1][c+1] + map[r+2][c]);
		}
		
		// ㅜ 
		if(r < N - 1 && c < M - 2) {
			ans = Integer.max(ans, map[r][c] + map[r][c+1] + map[r+1][c+1] + map[r][c+2]);
		}
		
		// ㅗ
		if(r < N - 1 && c < M - 1 && c >= 1) {
			ans = Integer.max(ans, map[r][c] + map[r+1][c-1] + map[r+1][c] + map[r+1][c+1]);
		}
		
		// ㅓ
		if(r < N - 2 && c >= 1) {
			ans = Integer.max(ans, map[r][c] + map[r+1][c] + map[r+1][c-1] + map[r+2][c]);
		}
		
	}

}
