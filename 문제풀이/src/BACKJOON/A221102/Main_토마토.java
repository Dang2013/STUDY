package BACKJOON.A221102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato {
	int x;
	int y;
	
	tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_토마토 {
	static int N, M;
	static int[][] map;
	static Queue<tomato> q = new LinkedList<>();
	
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < M; j++) {
				int isTomato = Integer.parseInt(st.nextToken());
				map[i][j] = isTomato;
				
				if(isTomato == 1) {
					q.add(new tomato(i, j));
				}
			}
		}
		
		System.out.println(bfs());
		
	}

	public static int bfs() {
		while(!q.isEmpty()) {
			tomato cur = q.remove();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(map[nr][nc] == 0) {
						q.add(new tomato(nr, nc));
						map[nr][nc] = map[cur.x][cur.y] + 1;
					}
				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					return -1;
				}
				
				result = Math.max(result, map[i][j]);
			} 
		}
		
		result = result - 1;
		
		return result;
	}

}
