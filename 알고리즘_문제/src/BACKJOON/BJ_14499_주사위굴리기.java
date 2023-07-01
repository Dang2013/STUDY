package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14499_주사위굴리기 {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] operation, dice;
	// 동서북남
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		// 맵 정보 저장 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 주사위 이동 명령 저장 
		operation = new int[K];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < K; i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}
		
		// 주사위 굴리기
		dice = new int[6];
		rolling(x, y, 0);
	}

	private static void rolling(int r, int c, int cnt) {
		if(cnt == K) {
			return;
		}
		
		int cur = operation[cnt];
		
		int nr = r + dr[cur - 1];
		int nc = c + dc[cur - 1];
		
		if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
			rolling(r, c, cnt+1);
			return;
		} else {
			if(cur == 1) {
				east();
			} else if(cur == 2) {
				west();
			} else if(cur == 3) {
				north();
			} else if(cur == 4) {
				south();
			}
			
			if(map[nr][nc] == 0) {
				map[nr][nc] = dice[5];
			} else {
				dice[5] = map[nr][nc];
			}
			System.out.println(dice[0]);
			rolling(nr, nc, cnt+1);
		}
		
		return;
		
	}

	private static void east() {
		// 0 -> 3 / 3 -> 5 / 2 -> 0 / 5 -> 2
		int temp = dice[3];
		dice[3] = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[5];
		dice[5] = temp;
	}

	private static void west() {
		// 0 -> 2 / 3 -> 0 / 2 -> 5 / 5 -> 3
		int temp = dice[2];
		dice[2] = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[5];
		dice[5] = temp;
		
	}

	private static void north() {
		// 0 -> 4 / 1 -> 0 / 4 -> 5 / 5 -> 1
		int temp = dice[4];
		dice[4] = dice[0];
		dice[0] = dice[1];
		dice[1] = dice[5];
		dice[5] = temp;
	}

	private static void south() {
		// 0 -> 1 / 1 -> 5 / 4 -> 0 / 5 -> 4
		int temp = dice[1];
		dice[1] = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[5];
		dice[5] = temp;
	}

}
