package A221110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//class Edge implements Comparable<Edge> {
//	int end;
//	int weight;
//	
//	public Edge(int end, int weight) {
//		super();
//		this.end = end;
//		this.weight = weight;
//	}
//
//	@Override
//	public int compareTo(Edge o) {
//		return weight - o.weight;
//	}
//}

public class Main_최단경로 {

	static int V, E, K;
	static int INF = 100000000;
	static List<Edge>[] list;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V + 1];
		dist = new int[V + 1];
		
		Arrays.fill(dist, INF);
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 리스트에 그래프 정보 초기화
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Edge(end, weight));
		}
		
		dijkstra(K);
		
		for (int i = 1; i <= V; i++) {
			if(dist[i] == INF) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		
		System.out.print(sb);
		
	}

	private static void dijkstra(int start) {
		PriorityQueue<Edge> q = new PriorityQueue<>();
		boolean[] isChecked = new boolean[V + 1];
		q.add(new Edge(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Edge curEdge = q.poll();
			int cur = curEdge.end;
			
			if(isChecked[cur]) {
				continue;
			}
			
			isChecked[cur] = true;
			
			for (int i = 0; i < list[cur].size(); i++) {
				Edge edge = list[cur].get(i);
				if(!isChecked[edge.end] && dist[edge.end] > dist[cur] + edge.weight) {
					dist[edge.end] = dist[cur] + edge.weight;
					q.add(new Edge(edge.end, dist[edge.end]));
				}
			}
			
		}
	}

	

}
