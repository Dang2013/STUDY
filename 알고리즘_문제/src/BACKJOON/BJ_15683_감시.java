package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

class cctv {
	int x;
	int y;
	int type;
	
	public cctv(int x, int y, int type) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

public class BJ_15683_감시 {
	static int N, M, ans;
	static int[][] origin;
	static List<cctv> list = new ArrayList<cctv>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		origin = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				
				origin[i][j] = a;
				
				if(a != 0 && a != 6) {
					list.add(new cctv(i, j, a));
				}
			}
		}
		
		// 1번 감시 : 0 / 1 / 2 / 3
		// 2번 감시 : 0, 2 / 1, 3
		// 3번 감시 : 0, 1 / 1, 2 / 2, 3 / 3, 0
		// 4번 감시 : 0, 1, 2 / 1, 2, 3 / 2, 3, 0 / 3, 0, 1
		// 5번 감시 : 0, 1, 2, 3
		
		ans = Integer.MAX_VALUE;
		
		check(0, origin);
		
		System.out.println(ans);
	}

	private static void check(int cnt, int[][] map) {
		if(cnt == list.size()) {
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						res++;
					}
				}
			}
			ans = Math.min(ans, res);
			return;
		}
		
		cctv cur = list.get(cnt);
		
		int[][] room = new int[N][M];
		
		if(cur.type == 1) {
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						room[i][j] = map[i][j];
					}
				}
				check(cnt+1, observe(room, cur, d));
			}
		} else if(cur.type == 2) {
			for (int d = 0; d < 2; d++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						room[i][j] = map[i][j];
					}
				}
				check(cnt+1, observe(observe(room, cur, d), cur, d+2));
			}
			
		} else if(cur.type == 3) {
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						room[i][j] = map[i][j];
					}
				}
				check(cnt+1, observe(observe(room, cur, d), cur, (d+1)%4));
			}
			
		} else if(cur.type == 4) {
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						room[i][j] = map[i][j];
					}
				}
				check(cnt+1, observe(observe(observe(room, cur, d), cur, (d+1)%4), cur, (d+2)%4));
			}
			
		} else if(cur.type == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					room[i][j] = map[i][j];
				}
			}
			check(cnt+1, observe(observe(observe(observe(room, cur, 0), cur, 1), cur, 2), cur, 3));
		}
		
	}

	private static int[][] observe(int[][] room, cctv cur, int d) {
		int k = 1;
		while(true) {
			int nr = cur.x + (dr[d] * k);
			int nc = cur.y + (dc[d] * k);
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || room[nr][nc] == 6) {
				break;
			}
			
			room[nr][nc] = 7;
			k += 1;
		}
		
		return room;
	}

}
