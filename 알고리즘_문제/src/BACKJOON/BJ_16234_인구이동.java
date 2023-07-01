package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class nation{
	int r;
	int c;
	
	public nation(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class BJ_16234_인구이동 {
	static int N, L, R, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static ArrayList<nation> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		
		move();
		
		System.out.println(ans);
	}

	private static void move() {
		while(true) {
			visited = new boolean[N][N];
			boolean isMove = false;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						int sum = bfs(i, j);
						if(list.size() > 1) {
							changepop(sum);
							isMove = true;
						}
					}
				}
			}
			if(!isMove) {
				return;
			}
			ans++;
		}
	}

	private static void changepop(int sum) {
		int avg = sum / list.size();
		for (int i = 0; i < list.size(); i++) {
			nation cur = list.get(i);
			map[cur.r][cur.c] = avg;
		}
	}

	private static int bfs(int x, int y) {
		Queue<nation> q = new LinkedList<nation>();
		list = new ArrayList<nation>();
		q.offer(new nation(x, y));
		list.add(new nation(x, y));
		visited[x][y] = true;
		
		int sum = map[x][y];
		
		while(!q.isEmpty()) {
			nation cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					int diff = Math.abs(map[r][c] - map[nr][nc]);
					
					if(diff >= L && diff <= R) {
						q.offer(new nation(nr, nc));
						list.add(new nation(nr, nc));
						visited[nr][nc] = true;
						sum += map[nr][nc];
					}
				}
			}
		}
		
		return sum;
		
	}

}
