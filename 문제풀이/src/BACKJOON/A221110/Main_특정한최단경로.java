package BACKJOON.A221110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int end;
	int weight;
	
	public Node(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight; 
	}
}

public class Main_특정한최단경로 {

	static int N, E;
	static List<Node>[] list;
	static int[] dist;
	static int INF = 200000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		dist = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, weight));
			list[end].add(new Node(start, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 1 -> v1 -> v2 -> N
		int result1 = 0;
		result1 += djkstra(1, v1);
		result1 += djkstra(v1, v2);
		result1 += djkstra(v2, N);
		// 1 -> v2 -> v1 -> N
		int result2 = 0;
		result2 += djkstra(1, v2);
		result2 += djkstra(v2, v1);
		result2 += djkstra(v1, N);
		
		int ans = 0;
		if(result1 >= INF && result2 >= INF) {
			ans = -1;
		} else {
			ans = Math.min(result1, result2);			
		}
		
		System.out.println(ans);
		
	}

	private static int djkstra(int start, int end) {
		Arrays.fill(dist, INF);
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.end;
			
			for (int i = 0; i < list[cur].size(); i++) {
				Node node = list[cur].get(i);
				if(dist[node.end] > dist[cur] + node.weight) {
					dist[node.end] = dist[cur] + node.weight;
					q.add(new Node(node.end, dist[node.end]));
				}
			}
		}
		return dist[end];
	}

}
