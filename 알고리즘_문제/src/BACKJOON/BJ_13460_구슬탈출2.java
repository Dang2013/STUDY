package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class bead {
	int x;
	int y;
	
	public bead(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class BJ_13460_구슬탈출2 {
	
	// 4방 
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static char[][] map;
	static bead Red, Blue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		// map 입력 
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
				
				if(ch == 'R') {
					Red = new bead(i, j);
				} else if(ch == 'B') {
					Blue = new bead(i, j);
				}
			}
		}
		
		bfs(Red, Blue);
		
	}

	private static void bfs(bead R, bead B) {
		Queue<bead> q = new LinkedList<>();
		q.offer(R);
		
		while(!q.isEmpty()) {
			bead cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(map[nr][nc] != '#') {
					
				}
			}
			
		}
	}

}
