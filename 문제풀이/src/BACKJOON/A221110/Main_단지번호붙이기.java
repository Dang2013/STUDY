package BACKJOON.A221110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class House {
	int x;
	int y;
	
	public House(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main_단지번호붙이기 {
	
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] map;
	static boolean[][] isChecked;
	static List<Integer> list = new ArrayList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		isChecked = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int aptCount = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!isChecked[i][j] && map[i][j] == 1) {
					aptCount++;
					bfs(i, j);
				}
			}
		}
		
		sb.append(aptCount).append('\n');
		
		list.sort(null);
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append('\n');
		}
		
		System.out.println(sb);
		
	}

	private static void bfs(int r, int c) {
		int count = 1;
		Queue<House> q = new LinkedList<>();
		q.offer(new House(r, c));
		isChecked[r][c] = true;
		
		while(!q.isEmpty()) {
			House cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !isChecked[nr][nc]) {
					if(map[nr][nc] == 1) {
						q.offer(new House(nr, nc));
						isChecked[nr][nc] = true;
						count++;
					}
				}
			}
			
		}
		list.add(count);
	}

}
