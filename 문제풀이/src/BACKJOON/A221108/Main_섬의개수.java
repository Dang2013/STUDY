package A221108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_섬의개수 {

	static int w, h;
	static int[][] map;
	static int count;
	static boolean[][] visited;
	
	//8방
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			// 0 0이 입력되면 종료
			if(w == 0 && h == 0) {
				break;
			}else {
				map = new int[h][w];
				visited = new boolean[h][w];
				
				for (int i = 0; i < h; i++) {
					st = new StringTokenizer(br.readLine());
					for (int j = 0; j < w; j++) {
						map[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				count = 0;
				
				for (int i = 0; i < h; i++) {
					for (int j = 0; j < w; j++) {
						if(map[i][j] == 1 && !visited[i][j]) {
							search(i, j);
							count++;
						}
					}
				}
				
				sb.append(count).append('\n');
			}
		}
		
		System.out.println(sb);
		
	}

	private static void search(int x, int y) {
		visited[x][y] = true;
		
		for (int d = 0; d < 8; d++) {
			int nr = x + dr[d];
			int nc = y + dc[d];
			
			if(nr >= 0 && nr < h && nc >= 0 && nc < w) {
				if(map[nr][nc] == 1 && !visited[nr][nc]) {
					search(nr, nc);
				}
			}
		}
	}

}
