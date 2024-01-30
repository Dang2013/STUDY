package BACKJOON.A231106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class fish {
	int r;
	int c;
	int size;
	
	public fish(int r, int c, int size) {
		super();
		this.r = r;
		this.c = c;
		this.size = size;
	}
}

public class Main_16236_아기상어 {
	private static int N;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
	}

}
