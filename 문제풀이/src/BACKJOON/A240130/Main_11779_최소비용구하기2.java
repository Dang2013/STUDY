package BACKJOON.A240130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus>{
	int idx;
	int cost;
	
	public Bus(int idx, int cost) {
		super();
		this.idx = idx;
		this.cost = cost;
	}

	@Override
	public int compareTo(Bus o) {
		return this.cost - o.cost;
	}
	
}

public class Main_11779_최소비용구하기2 {
	static int n,m;
	static int INF = Integer.MAX_VALUE;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<ArrayList<Bus>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		dist = new int[n+1];
		visited = new boolean[n+1];
		
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			dist[i] = INF;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Bus(end, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start, end);				
	}


	private static void dijkstra(int start, int end) {
		PriorityQueue<Bus> q = new PriorityQueue<>();
		q.offer(new Bus(start, 0));
		dist[start] = 0;
		int[] route = new int[n+1];
		
		while(!q.isEmpty()) {
			Bus cur = q.poll();
			
			if(cur.cost > dist[cur.idx]) {
				continue;
			}
			
			ArrayList<Bus> curList = list.get(cur.idx);

			for (int i = 0; i < curList.size(); i++) {
				Bus next = curList.get(i);
				if(dist[next.idx] > dist[cur.idx] + next.cost) {
					dist[next.idx] = dist[cur.idx] + next.cost;
					q.offer(new Bus(next.idx, dist[next.idx]));
					route[next.idx] = cur.idx;
				}				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(dist[end]).append("\n");

		Stack<Integer> stack = new Stack<>();
		int count = 0;
		while (end != 0) {
			stack.push(end);
			end = route[end];
			count++;
		}
		
		sb.append(count).append("\n");
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
