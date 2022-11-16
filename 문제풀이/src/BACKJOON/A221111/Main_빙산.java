package A221111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class iceBerg {
	int x;
	int y;
	
	public iceBerg(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main_빙산 {
	
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

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
		
		int ans = 0;
		int cnt = 0;
		
		while((cnt = check()) < 2) {
			if(cnt == 0) {
				ans = 0;
				break;
			}
			
			melt();
			ans++;
		}
		
		System.out.println(ans);
		
	}


	private static int check() {
		boolean[][] isChecked = new boolean[N][M];
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0 && !isChecked[i][j]) {
					dfs(i, j, isChecked);
					cnt++;
				}
			}
		}
		
		return cnt;
	}

	private static void dfs(int r, int c, boolean[][] isChecked) {
		isChecked[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && !isChecked[nr][nc]) {
				if(map[nr][nc] != 0) {
					dfs(nr, nc, isChecked);
				}
			}
		}
	}
	
	private static void melt() {
		Queue<iceBerg> q = new LinkedList<>();
		boolean[][] isChecked = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					q.offer(new iceBerg(i, j));
					isChecked[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			iceBerg cur = q.poll();
			
			int seaCount = 0;
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !isChecked[nr][nc]) {
					if(map[nr][nc] == 0) {
						seaCount++;
					}
				}
			}
			
			if(map[cur.x][cur.y] - seaCount < 0) {
				map[cur.x][cur.y] = 0;
			} else {
				map[cur.x][cur.y] -= seaCount;
			}
			
		}
		
	}
}
