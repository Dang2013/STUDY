package BACKJOON.A231219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4991_로봇청소기 {
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			
			char[][] map = new char[h][w];
			
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					char cur = str.charAt(j);
					map[i][j] = cur;
					
				}
			}
			
			
		}
	}

}
