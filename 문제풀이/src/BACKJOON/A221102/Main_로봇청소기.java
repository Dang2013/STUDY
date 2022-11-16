package A221102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_로봇청소기 {

	// 북, 동, 남, 서
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static int count;
	
	static int N, M;
	
	static int map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		count = 1;
		
		dfs(r, c, d);
		
		System.out.println(count);
		
	}

	private static void dfs(int r, int c, int d) {
		map[r][c] = -1;
		
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
				count++;
				dfs(nr, nc, d);
				return;
			}
		}
		
		int dir = (d + 2) % 4;
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {
			dfs(nr, nc, d);			
		}
	}
}
