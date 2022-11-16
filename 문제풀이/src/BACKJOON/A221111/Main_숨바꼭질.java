package A221111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_숨바꼭질 {

	static int N, K;
	static int[] map = new int[100001];
	static boolean[] isChecked = new boolean[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs(N);
		
		System.out.println(map[K]);
	}

	private static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		isChecked[n] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < 3; i++) {
				int nx = 0;
				int add = 1;
				if(i == 0) {
					nx = cur + 1;
				} else if(i == 1) {
					nx = cur - 1;
				} else if(i == 2) {
					nx = cur * 2;
				}
				
				if(nx >= 0 && nx <= 100000 && !isChecked[nx]) {
					map[nx] = map[cur] + add;
					isChecked[nx] = true;
					q.offer(nx);
				}
			}
		}
	}

}
