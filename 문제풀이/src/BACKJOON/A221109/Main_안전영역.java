package A221109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_안전영역 {
	
	static int N, maxSafe, safeCount;
	static int[][] map;
	static boolean[][] isChecked;
	
	// 4방
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Dot {
		int x;
		int y;
		
		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		maxSafe = 0;
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int H = Integer.parseInt(st.nextToken());
				max = Math.max(max, H);
				map[i][j] = H;
			}
		}
		
		for (int h = 0; h <= max; h++) {
			isChecked = new boolean[N][N];
			safeCount = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] - h > 0 && !isChecked[i][j]) {
						bfs(i, j, h);
						safeCount++;
					}
				}
			}
			maxSafe = Math.max(maxSafe, safeCount);
		}
		
		System.out.println(maxSafe);
		
	}

	private static void bfs(int r, int c, int h) {
		isChecked[r][c] = true;
		
		Queue<Dot> q = new LinkedList<>();
		
		q.offer(new Dot(r, c));
		
		while(!q.isEmpty()) {
			Dot cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !isChecked[nr][nc]) {
					if(map[nr][nc] - h > 0) {
						isChecked[nr][nc] = true;
						q.offer(new Dot(nr, nc));
					}
				}
			}
		}
		
	}

}
