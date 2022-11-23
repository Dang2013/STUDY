package BACKJOON.A221123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	int x;
	int y;
	int cost;
	
	public Point(int x, int y, int cost) {
		super();
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(Point o) {
		return cost - o.cost;
	}
	
}

public class Main_녹색옷입은애가젤다지 {
	static int N;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int[][] map;
	static int[][] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = 0;
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				break;
			}
			
			tc++;
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			
			sb.append("Problem ").append(tc).append(": ").append(djkstra()).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

	private static int djkstra() {
		PriorityQueue<Point> q = new PriorityQueue<>();
		dist[0][0] = map[0][0];
		q.add(new Point(0, 0, map[0][0]));
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(dist[nr][nc] > dist[cur.x][cur.y] + map[nr][nc]) {
						dist[nr][nc] = dist[cur.x][cur.y] + map[nr][nc];
						q.add(new Point(nr, nc, dist[nr][nc]));
					}
				}
			}
		}
		
		return dist[N-1][N-1];
		
	}

}
