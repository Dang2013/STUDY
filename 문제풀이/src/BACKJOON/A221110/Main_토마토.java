package A221110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int z;
	int x;
	int y;
	
	public Tomato(int z, int x, int y) {
		super();
		this.z = z;
		this.x = x;
		this.y = y;
	}
}

public class Main_토마토 {

	static int M, N, H, tomatoCount;
	static int[][][] storage;
	static boolean[][][] isChecked;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] dz = {-1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		storage = new int[H][N][M];
		isChecked = new boolean[H][N][M];
		
		tomatoCount = 0;
		
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int t = Integer.parseInt(st.nextToken());
					storage[h][i][j] = t;
					if(t == 0) {
						tomatoCount++;
					}
				}
			}
		}
		
		
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(storage[h][i][j] == 1 && !isChecked[h][i][j]) {
						bfs(h, i, j);
					}
				}
			}
		}
		
		int ans = Integer.MIN_VALUE;
		
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					ans = Math.max(ans, storage[h][i][j]);
				}
			}
		}
		
		if(tomatoCount != 0) {
			ans = -1;
		} else if(ans == 1) {
			ans = 0;
		} else {
			ans -= 1;
		}
		
		System.out.println(ans);
		
	}

	private static void bfs(int h, int r, int c) {
		Queue<Tomato> q = new LinkedList<>();
		q.add(new Tomato(h, r, c));
		isChecked[h][r][c] = true;
		
		while(!q.isEmpty()) {
			Tomato cur = q.poll();
			
			// 위 아래 체크
			for (int d = 0; d < 2; d++) {
				int nz = cur.z + dz[d];
				
				if(nz >= 0 && nz < H && !isChecked[nz][cur.x][cur.y]) {
					if(storage[nz][cur.x][cur.y] == 0) {
						tomatoCount--;
						storage[nz][cur.x][cur.y] = storage[cur.z][cur.x][cur.y] + 1;
						isChecked[nz][cur.x][cur.y] = true;
						q.add(new Tomato(nz, cur.x, cur.y));
					}
				}
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !isChecked[cur.z][nr][nc]) {
					if(storage[cur.z][nr][nc] == 0) {
						tomatoCount--;
						storage[cur.z][nr][nc] = storage[cur.z][cur.x][cur.y] + 1;
						isChecked[cur.z][nr][nc] = true;
						q.add(new Tomato(cur.z, nr, nc));
					}
				}
			}
			
		}
	}

}
