package BACKJOON.A221122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Town implements Comparable<Town>{
	int end;
	int cost;
	
	public Town(int end, int cost) {
		super();
		this.end = end;
		this.cost = cost;
	}

	@Override
	public int compareTo(Town o) {
		return cost - o.cost;
	}
}

public class Main_파티 {

	static final int INF = 987654321;
	static int N, M, X;
	static List<List<Town>> goList, backList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		goList = new ArrayList<>();
		backList = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			goList.add(new ArrayList<>());
			backList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			goList.get(start).add(new Town(end, cost));
			backList.get(end).add(new Town(start, cost));
		}
		
		int[] goDist = dijkstra(goList);
		int[] backDist = dijkstra(backList);
		
		int answer = 0;
		
		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, goDist[i] + backDist[i]);
		}
		
		System.out.println(answer);
		
	}

	private static int[] dijkstra(List<List<Town>> list) {
		PriorityQueue<Town> q = new PriorityQueue<>();
		q.offer(new Town(X, 0));
		
		boolean[] isCheck = new boolean[N+1];
		int[] dist = new int[N+1];
		
		Arrays.fill(dist, INF);
		dist[X] = 0;
		
		while(!q.isEmpty()) {
			Town curTown = q.poll();
			int cur = curTown.end;
			
			if(!isCheck[cur]) {
				isCheck[cur] = true;
				
				for (int i = 0; i < list.get(cur).size(); i++) {
					Town t = list.get(cur).get(i);
					
					if(!isCheck[t.end] && dist[t.end] > dist[cur] + t.cost) {
						dist[t.end] = dist[cur] + t.cost;
						q.offer(new Town(t.end, dist[t.end]));
					}
				}
			}
			
			
		}
		
		return dist;
	}

}
