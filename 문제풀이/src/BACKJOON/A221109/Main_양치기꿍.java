package A221109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_양치기꿍 {
	static int R, C, Wolf, Sheep;
	static char[][] map;
	static boolean[][] isChecked;
	
	// 4방
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class Dot {
		int r;
		int c;
		
		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 세로
		R = Integer.parseInt(st.nextToken());
		// 가로
		C = Integer.parseInt(st.nextToken());
		// 맵
		map = new char[R][C];
		// 체크된 곳인지
		isChecked = new boolean[R][C];
		
		// map 입력
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		Wolf = 0;
		Sheep = 0;
		
		// 울타리 내 조사
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '#' && !isChecked[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(Sheep + " " + Wolf);
		
	}

	private static void bfs(int x, int y) {
		// 울타리 내 늑대, 양 수 초기화
		int vCount = 0;
		int kCount = 0;
		
		// 현재 위치가 늑대, 양인 경우 Count
		if(map[x][y] == 'v') {
			vCount++;
		} else if(map[x][y] == 'k') {
			kCount++;
		}
		
		isChecked[x][y] = true;
		
		Queue<Dot> q = new LinkedList<>();
		
		q.offer(new Dot(x, y));
		
		while(!q.isEmpty()) {
			Dot cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != '#' && !isChecked[nr][nc]) {
					if(map[nr][nc] == 'v') {
						vCount++;
					} else if(map[nr][nc] == 'k') {
						kCount++;
					}
					
					isChecked[nr][nc] = true;
					q.offer(new Dot(nr, nc));
				}
			}
		}
		
		// 양이 늑대보다 많을 경우
		if(kCount > vCount) {
			// 늑대가 잡아먹힘
			vCount = 0;
		} else {
			// 이외의 경우엔 모두 양이 잡아먹힘
			kCount = 0;
		}
		
		Wolf += vCount;
		Sheep += kCount;
		
	}

}
