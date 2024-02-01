package BACKJOON.A240131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18352_특정거리의도시찾기 {
	static int N, M, K, X;
	static int INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
			dist[i] = INF;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
		}
		
		BFS();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				sb.append(i).append("\n");
			}
		}
		
		if (sb.length() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}
	}

	private static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(X);
		dist[X] = 0;
		visited[X] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			ArrayList<Integer> nextList = graph.get(cur);
			
			for (int i = 0; i < nextList.size(); i++) {
				int next = nextList.get(i);
				
				if(visited[next]) {
					continue;
				}
				
				dist[next] = dist[cur] + 1;
				visited[next] = true;
				q.offer(next);
			}
		}
	}
}
