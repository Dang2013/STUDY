package A0309;

import java.io.*;
import java.util.*;

public class Main_미로탐색_당현찬 {
	
	// dfs로 풀어서 예제 입/출력은 나왔지만 제출했을 때 시간초과에 걸렸다. -> bfs 풀이로 전환
	// 레벨별 탐색으로 min값을 구하는 것 보단 레벨별로 이동가능한 경로에 횟수 누적이 출력이 더 쉬울 것 같아 구현

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int N, M;
	// 미로
	static int[][] maze;
	// 방문 여부
	static boolean[][] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		maze = new int[N][M];
		isSelected = new boolean[N][M];
		
		// 미로 입력
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 시작점인 (0,0) 방문 표시
		isSelected[0][0] = true;
		// bfs 탐색 시작
		bfs();
		
		// 도착점에 누적된 이동 횟수 출력
		System.out.println(maze[N-1][M-1]);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[]{0, 0});
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int r = current[0];
			int c = current[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < N && nr >= 0 && nc < M && nc >= 0 && !isSelected[nr][nc] && maze[nr][nc] > 0) {
					// 다음 경로 큐에 입력
					q.offer(new int[]{nr, nc});
					// 해당 경로 방문했다고
					isSelected[nr][nc] = true; 
					// 이동 횟수 누적
					maze[nr][nc] = maze[r][c] + 1;
				}
			}
		}
	}

}
