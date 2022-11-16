package BACKJOON.A221111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_스타트링크 {

	static int F, S, G, U, D;
	static int[] map;
	static boolean[] isChecked;
	static int[] dc = new int[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[F+1];
		isChecked = new boolean[F+1];
		
		dc[0] = U;
		dc[1] = D * -1;
		
		bfs(S);
		
	}

	private static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		isChecked[s] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == G) {
				System.out.println(map[G]);
				return;
			}
			
			for (int i = 0; i < 2; i++) {
				int nc = cur + dc[i];
				
				if(nc >= 1 && nc <= F && !isChecked[nc]) {
					map[nc] = map[cur] + 1;
					q.offer(nc);
					isChecked[nc] = true;
				}
			}
		}
		
		System.out.println("use the stairs");
		
	}

}
