package BACKJOON.A231102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Fireball {
	int r;
	int c;
	int m;
	int s;
	int d;
	
	public Fireball(int r, int c, int m, int s, int d) {
		super();
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}

public class Main_20056_마법사상어와파이어볼 {
	private static int N, M, K;
	private static Queue<Fireball>[][] map;
	
	private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new LinkedList[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if(map[r][c] != null) {
				map[r][c].offer(new Fireball(r, c, m, s, d));
			} else if (map[r][c] == null) {
				map[r][c] = new LinkedList<Fireball>();
				map[r][c].offer(new Fireball(r, c, m, s, d));
			}
		}
		
		for (int i = 0; i < K; i++) {
			map = move();
		}
		
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != null) {
					Queue q = map[i][j];
					
					while(!q.isEmpty()) {
						Fireball cur = (Fireball) q.poll();
						
						result += cur.m;
					}
				}
			}
		}
		
		System.out.println(result);
	}

	private static Queue<Fireball>[][] move() {
		Queue<Fireball>[][] newMap = new LinkedList[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != null) {
					Queue q = map[i][j];
					
					while(!q.isEmpty()) {
						Fireball cur = (Fireball) q.poll();
						
						int nr = (i + (dr[cur.d] * cur.s) % N) % N;
						int nc = (j + (dc[cur.d] * cur.s) % N) % N;
						
						if(newMap[nr][nc] != null) {
							newMap[nr][nc].offer(new Fireball(nr, nc, cur.m, cur.d, cur.s));
						} else {
							newMap[nr][nc] = new LinkedList<Fireball>();
							newMap[nr][nc].add(new Fireball(nr, nc, cur.m, cur.d, cur.s));
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(newMap[i][j] != null && newMap[i][j].size() >= 2) {
					Queue q = newMap[i][j];
					Fireball first = (Fireball) q.poll();
					int sumM = first.m;
					int sumS = first.s;
					int cnt = 1;
					boolean isOdd = false;
					if (first.d % 2 == 1) {
						isOdd = true;
					}
					
					boolean isDir = true;
					
					while(!q.isEmpty()) {
						cnt++;
						Fireball cur = (Fireball) q.poll();
						
						sumM += cur.m;
						sumS += cur.s;
						
						if(cur.d % 2 == 0 && !isOdd) {
							continue;
						} else if (cur.d % 2 == 1 && isOdd) {
							continue;
						} else {
							isDir = false;
						}
					}
					
					newMap[i][j] = new LinkedList<Fireball>();
					
					if (sumM/5 == 0) {
						continue;
					} else {
						if(isDir) {
							newMap[i][j].offer(new Fireball(i, j, sumM/5, 0, sumS/cnt));
							newMap[i][j].offer(new Fireball(i, j, sumM/5, 2, sumS/cnt));
							newMap[i][j].offer(new Fireball(i, j, sumM/5, 4, sumS/cnt));
							newMap[i][j].offer(new Fireball(i, j, sumM/5, 6, sumS/cnt));
						} else {
							newMap[i][j].offer(new Fireball(i, j, sumM/5, 1, sumS/cnt));
							newMap[i][j].offer(new Fireball(i, j, sumM/5, 3, sumS/cnt));
							newMap[i][j].offer(new Fireball(i, j, sumM/5, 5, sumS/cnt));
							newMap[i][j].offer(new Fireball(i, j, sumM/5, 7, sumS/cnt));
						}
					}
				}
			}
		}
		
		return newMap;
	}

}
