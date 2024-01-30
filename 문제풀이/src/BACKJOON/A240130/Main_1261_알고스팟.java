package BACKJOON.A240130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int r;
	int c;
	int cost;
	
	public Node(int r, int c, int cost) {
		super();
		this.r = r;
		this.c = c;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
	
}

public class Main_1261_알고스팟 {
	static int INF = Integer.MAX_VALUE;
	static int N, M;
	static int[][] map, dist;
	static boolean[][] visited;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		dist = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j-1) - '0';
				dist[i][j] = INF;
			}
		}
		
		dijkstra(1,1);
		
		System.out.println(dist[N][M]);
	}

	private static void dijkstra(int r, int c) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(r, c, 0));
		dist[r][c] = 0;
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			int x = cur.r;
			int y = cur.c;
			int cost = cur.cost;
			
			if(x == N && y == M) {
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = x + dr[d];
				int nc = y + dc[d];
				
				if(nr >= 1 && nr <= N && nc >= 1 && nc <= M && !visited[nr][nc]) {
					if(dist[nr][nc] > cost + map[nr][nc]) {
						dist[nr][nc] = cost + map[nr][nc];
						visited[nr][nc] = true;
						q.offer(new Node(nr,nc,cost+map[nr][nc]));
					}
				}
			}
		}
	}

}
