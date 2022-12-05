package SW.A221205;

import java.util.Scanner;

class Solution
{
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, cnt;
	static int[][] map;
	static boolean[][] isConnected;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			isConnected = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						isConnected[i][j] = true;
						if(i == 0 || j == 0) {
							continue;
						}
						else 
							connect(i, j);
					}
				}
			}
		}
	}

	private static void connect(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && isConnected[nr][nc] == false) {
					go(nr, nc, i);
			}
		}
	}

	private static void go(int r, int c, int dir) {
		for (int i = 1; i < N; i++) {
			int nr = r + (dr[dir] * i);
			int nc = c + (dc[dir] * i);
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || isConnected[nr][nc] == true) {
				break;
			}
			
			cnt += 1;
		}
	}
}