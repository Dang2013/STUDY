package BACKJOON.A231101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Move {
	int d;
	int s;
	
	public Move(int d, int s) {
		super();
		this.d = d;
		this.s = s;
	}
}

class Site {
	int r;
	int c;
	
	public Site(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class Main_21610_마법사상어와비바라기 {
	
	private static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	private static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	private static int N, M;
	private static int[][] map;
	private static boolean[][] curCloud;
	private static Move[] order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		curCloud = new boolean[N][N];
		order = new Move[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			order[i] = new Move(d,s);
		}
		
		curCloud[N-1][0] = true;
		curCloud[N-1][1] = true;
		curCloud[N-2][0] = true;
		curCloud[N-2][1] = true;

		
		ArrayList<Site> cloudList = new ArrayList<Site>();
		cloudList.add(new Site(N-1, 0));
		cloudList.add(new Site(N-1, 1));
		cloudList.add(new Site(N-2, 0));
		cloudList.add(new Site(N-2, 1));
		
		for (int i = 0; i < M; i++) {
			cloudMove(cloudList, order[i]);
		}

	}

	private static void cloudMove(ArrayList<Site> old, Move cur) {
		int d = cur.d - 1;
		int s = cur.s;
		
		for (int i = 0; i < old.size(); i++) {
			Site curCloud = old.get(i);
			
			
		}
	}

}
