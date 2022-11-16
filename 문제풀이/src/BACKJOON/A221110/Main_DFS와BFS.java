package A221110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_DFS와BFS {

	static int N, M, V;
	static int[][] map;
	static boolean[] isChecked;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		isChecked = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start][end] = 1;
			map[end][start] = 1;
		}
		
		dfs(V);
		sb.append("\n");
		isChecked = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
		
	}

	private static void dfs(int start) {
		isChecked[start] = true;
		sb.append(start + " ");
		
		for (int i = 1; i <= N; i++) {
			if(map[start][i] == 1 && !isChecked[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		isChecked[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur + " ");
			
			for (int i = 1; i <= N; i++) {
				if(map[cur][i] == 1 && !isChecked[i]) {
					q.add(i);
					isChecked[i] = true;
				}
			}
		}
	}

}
