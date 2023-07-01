package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class point {
	int x;
	int y;
	
	public point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class BJ_15686_치킨배달 {
	static int N, M, ans;
	static int[][] map;	
	static ArrayList<point> House;
	static ArrayList<point> Chicken;
	static boolean[] Open;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		House = new ArrayList<point>();
		Chicken = new ArrayList<point>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					House.add(new point(i, j));
				} else if(map[i][j] == 2) {
					Chicken.add(new point(i, j));
				}
			}
		}
		
		Open = new boolean[Chicken.size()];
		ans = Integer.MAX_VALUE;
		
		DFS(0, 0);
		
		System.out.println(ans);
	}

	private static void DFS(int start, int cnt) {
		if(cnt == M) {
			int res = 0;
			
			for (int i = 0; i < House.size(); i++) {
				int temp = Integer.MAX_VALUE;
				
				for (int j = 0; j < Chicken.size(); j++) {
					if(Open[j]) {
						int distance = Math.abs(House.get(i).x - Chicken.get(j).x) + Math.abs(House.get(i).y - Chicken.get(j).y);
						temp = Math.min(temp, distance);
					}
				}
				res += temp;
			}
			ans = Math.min(ans, res);
			return;
		}
		
		for (int i = start; i < Chicken.size(); i++) {
			Open[i] = true;
			DFS(start + 1, cnt + 1);
			Open[i] = false;
		}
		
	}

}
