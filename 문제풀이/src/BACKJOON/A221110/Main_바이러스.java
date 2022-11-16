package A221110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_바이러스 {

	static int N, E;
	static int[][] network;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		network = new int[N+1][N+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			network[start][end] = 1;
			network[end][start] = 1;
		}
		
		int ans = bfs();
		
		System.out.println(ans);
		
	}

	private static int bfs() {
		boolean[] isChecked = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		isChecked[1] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if(network[cur][i] == 1 && !isChecked[i]) {
					q.add(i);
					count++;
					isChecked[i] = true;
				}
			}
			
		}
		
		return count;
		
	}

}
