package A221107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main_특정거리의도시찾기 {
	private static int INF = Integer.MAX_VALUE;
	static int N, M, K, X;
	static List<List<City>> list;
	static int[] dis;

	static class City implements Comparable<City> {
		int Num;
		int Weight;
		
		public City(int num, int weight) {
			super();
			Num = num;
			Weight = weight;
		}

		@Override
		public int compareTo(City o) {
			return Weight - o.Weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		dis = new int[N+1];
		Arrays.fill(dis, INF);
		list = new ArrayList<>();
		
		for (int i = 0; i <= M; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new City(end, 1));
		}
		
		dijkstra(X);
		
		for (int i = 1; i < dis.length; i++) {
			if(dis[i] == K) {
				sb.append(i).append('\n');
			}
		}
		
		if(sb.length() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}
	}

	private static void dijkstra(int num) {
		PriorityQueue<City> q = new PriorityQueue<>();
		boolean visit[] = new boolean[N+1];
		dis[num] = 0;
		
		q.offer(new City(num, 0));
		
		while(!q.isEmpty()) {
			City c = q.poll();
			int cur = c.Num;
			
			if(visit[cur]) {
				continue;
			}
			
			visit[cur] = true;
			
			for (int i = 0; i < list.get(cur).size(); i++) {
				City curCity = list.get(cur).get(i);
				
				if(!visit[curCity.Num] && dis[curCity.Num] > (curCity.Weight + dis[cur])) {
					dis[curCity.Num] = curCity.Weight + dis[cur];
					q.offer(new City(curCity.Num, dis[curCity.Num]));
				}
			}
		}
	}

}
