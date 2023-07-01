package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class tree implements Comparable<tree>{
	int x;
	int y;
	int z;
	
	public tree(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(tree o) {
		return this.z - o.z;
	}
}

public class BJ_16235_나무재테크 {
	static int N, M, K, ans;
	static int[][] A, map;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		map = new int[N][N];
		ArrayList<tree> list = new ArrayList<tree>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			
			list.add(new tree(x, y, z));
		}
		
		// 나무 나이 오름차순으로 정렬
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Collections.sort(list);
			}
		}
		
		ans = 0;
		
		age(0, list);
		
		System.out.println(ans);
	}

	private static void age(int year, List<tree> list) {
		if(year >= K){
			ans = list.size();
			return;
		}
		
		List<tree> newlist = new ArrayList<tree>();
		List<tree> death = new ArrayList<tree>();
		
		// 봄
		for (int i = 0; i < list.size(); i++) {
			tree cur = list.get(i);
			
			if(map[cur.x][cur.y] >= cur.z) {
				map[cur.x][cur.y] -= cur.z;
				newlist.add(new tree(cur.x, cur.y, cur.z + 1));
			} else {
				death.add(cur);
			}
		}
		
		
		// 여름
		for (int i = 0; i < death.size(); i++) {
			tree cur = death.get(i);
			
			map[cur.x][cur.y] += cur.z / 2;
		}
		
		// 가을
		for (int i = 0; i < newlist.size(); i++) {
			tree cur = newlist.get(i);
			
			if(cur.z % 5 == 0) {
				for (int d = 0; d < 8; d++) {
					int nr = cur.x + dr[d];
					int nc = cur.y + dc[d];
					
					if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
						newlist.add(new tree(nr, nc, 1));
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}
		
		// 겨울
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += A[i][j];
			}
		}
		
		age(year+1, newlist);
		
	}

}
