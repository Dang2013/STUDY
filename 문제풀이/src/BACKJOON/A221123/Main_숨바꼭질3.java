package BACKJOON.A221123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_숨바꼭질3 {

	static int N, K;
	static int[] map = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs(N);
		
		System.out.println(map[K] - 1);
	}

	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		map[x] = 1;
		q.add(x);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < 3; i++) {
				int nx = 0;
				int add = 0;
				if(i == 0) {
					nx = cur + 1;
					add = 1;
				} else if(i == 1) {
					nx = cur - 1;
					add = 1;
				} else if(i == 2) {
					nx = cur * 2;
					add = 0;
				}
				
				if(nx >= 0 && nx <= 100000) {
					if(map[nx] == 0 || map[nx] > map[cur] + add) {
						map[nx] = map[cur] + add;
						q.add(nx);						
					}
				}
			}
		}
	}

}
