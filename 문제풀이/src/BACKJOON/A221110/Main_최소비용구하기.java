package A221110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int end;
	int weight;
	
	public Edge(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return weight - o.weight;
	}
}

public class Main_최소비용구하기 {
	
	static int N, M;
	static int INF = 100000000;
	static List<Edge>[] list;
	static int[] dist;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		// 해당 (인덱스 번호)의 노드가 가진 간선 정보
		list = new ArrayList[N + 1];
		// 가중치 정보
		dist = new int[N + 1];
		
		Arrays.fill(dist, INF);
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 그래프 초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Edge(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(djkstra(start, end));
		
	}

	private static int djkstra(int start, int end) {
		PriorityQueue<Edge> q = new PriorityQueue<>();
		boolean[] isChecked = new boolean[N + 1];
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
		
		return dist[end];
		
	}

}
