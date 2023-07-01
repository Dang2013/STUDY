package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class virus {
	int x;
	int y;
	int time;
	
	public virus(int x, int y, int time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class BJ_17142_연구소3 {
	static int N, M, originEmptySpace, ans;
	static List<virus> list = new ArrayList<virus>();
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		originEmptySpace = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				
				map[i][j] = a;
				
				if(a == 2) {
					list.add(new virus(i, j, 0));
				} else if(a == 0) {
					originEmptySpace++;
				}
			}
		}
		
		int[] selected = new int[M];
		ans = Integer.MAX_VALUE;
		
		if(originEmptySpace == 0) {
			System.out.println(0);
		} else {
			comb(0, 0, selected);
			if(ans == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(ans);
			}
		}
		
	}

	private static void comb(int cnt, int start, int[] selected) {
		if(cnt >= M) {
			spread(selected, originEmptySpace);
			return;
		}
		
		for (int i = start; i < list.size(); i++) {
			selected[cnt] = i;
			comb(cnt+1, i+1, selected);
		}
	}

	private static void spread(int[] selected, int emptySpace) {
		Queue<virus> q = new LinkedList<virus>();
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < M; i++) {
			int idx = selected[i];
			virus v = list.get(idx);
			visited[v.x][v.y] = true;
			q.add(v);
		}
		
		while(!q.isEmpty()) {
			virus cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
					continue;
				}
				
				if(map[nr][nc] == 1 || visited[nr][nc]) {
					continue;
				}
				
				if(map[nr][nc] == 0) {
					emptySpace--;
				}

				if(emptySpace == 0) {
					ans = Math.min(ans, cur.time + 1);
					return;
				}
				
				visited[nr][nc] = true;
				q.add(new virus(nr, nc, cur.time + 1));
			}
		}
	}
}

