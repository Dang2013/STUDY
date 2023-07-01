package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class p {
	int x;
	int y;
	
	public p(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class BJ_3190_뱀 {
	static int N, K, L, ans;
	static int[][] map;
	static boolean[][] isSnake;
	static Map<Integer, Character> direction;
	//방향 우하좌상
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N][N];
		isSnake = new boolean[N][N];
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			map[x][y] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		
		direction = new HashMap<>();
		
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			
			direction.put(time, dir);
		}
		
		moving(0, 0);
		
	}

	private static void moving(int r, int c) {
		isSnake[r][c] = true;
		Queue<point> q = new LinkedList<>();
		q.add(new point(r, c));
		
		while(true) {
			point cur = q.poll();
		}
	}
}
