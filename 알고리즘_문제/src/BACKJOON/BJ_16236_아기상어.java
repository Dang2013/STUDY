package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class fish {
	int x;
	int y;
	
	public fish(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class BJ_16236_아기상어 {
	static int N;
	static fish shark = new fish(-1, -1);
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				
				map[i][j] = a;
				
				if(a == 9) {
					shark.x = i;
					shark.y = j;
					map[i][j] = 0;
				}
			}
		}
		
		feed();
	}

	private static void feed() {
		
	}

}
